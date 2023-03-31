package star.uz.delivery.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import star.uz.delivery.entity.Attachment;
import star.uz.delivery.entity.AttachmentContent;
import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.payload.AttachmentGetAllDto;
import star.uz.delivery.repository.AttachmentContentRepo;
import star.uz.delivery.repository.AttachmentRepo;
import star.uz.delivery.service.AttachmentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttachmentServiceImpl implements AttachmentService {
    private final AttachmentRepo attachmentRepo;
    private final AttachmentContentRepo attachmentContentRepo;

    @Override
    public ApiResponse<?> uploadFile(MultipartHttpServletRequest file) throws IOException {
        Iterator<String> fileName = file.getFileNames();
        MultipartFile multipartFile = file.getFile(fileName.next());
        if (multipartFile != null) {
            String originalFileName = multipartFile.getOriginalFilename();
            long size = multipartFile.getSize();
            String contentType = multipartFile.getContentType();
            Attachment attachment = new Attachment();
            attachment.setFileOriginalName(originalFileName);
            attachment.setSize(size);
            attachment.setContentType(contentType);
            Attachment attachment1 = attachmentRepo.save(attachment);
            AttachmentContent attachmentContent = new AttachmentContent();
            attachmentContent.setMainContent(multipartFile.getBytes());
            attachmentContent.setAttachment(attachment1);
            attachmentContentRepo.save(attachmentContent);
            return ApiResponse.successResponse("File saved");
        }
        return ApiResponse.errorResponse("File saxlashga hotolik");
    }

    @Override
    public ApiResponse<?> downloadFile( UUID id,HttpServletResponse response) throws IOException {
        Optional<Attachment> attachmentOptional = attachmentRepo.findById(id);
        if (attachmentOptional.isEmpty()) {
            return new ApiResponse<>(false, "Attachment topilmadi", id);
        }
        Attachment attachment1 = attachmentOptional.get();
        Optional<AttachmentContent> attachmentContent = attachmentContentRepo.findByAttachmentId(id);
        if (attachmentContent.isEmpty()) {
            return ApiResponse.errorResponse("AttachmentContent Topilmadi");
        }
        AttachmentContent attachmentContent1 = attachmentContent.get();

        response.setContentType(attachment1.getContentType());
        FileCopyUtils.copy(attachmentContent1.getMainContent(), response.getOutputStream());

        return ApiResponse.successResponse("Success");

    }

    @Override
    public ApiResponse<?> getAllFileNameAndId() {
        List<AttachmentGetAllDto> list = attachmentRepo.findAll().stream().map(this::attachmentGetAllDto)
                .collect(Collectors.toList());
        return ApiResponse.successResponse(list);
    }
    public AttachmentGetAllDto attachmentGetAllDto(Attachment attachment){
        return AttachmentGetAllDto.builder()
                .id(attachment.getId())
                .fileName(attachment.getFileOriginalName().toUpperCase())
                .build();
    }

}
