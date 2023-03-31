package star.uz.delivery.controllerImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import star.uz.delivery.controller.AttachmentController;
import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.service.AttachmentService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
@RestController
@RequiredArgsConstructor
public class AttachmentControllerImpl implements AttachmentController {
    private final AttachmentService attachmentService;

    @Override
    public HttpEntity<?> uploadFile(MultipartHttpServletRequest file) throws IOException {
        ApiResponse<?>response=attachmentService.uploadFile(file);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }

    @Override
    public HttpEntity<?> download(UUID id, HttpServletResponse response) throws IOException {
        ApiResponse<?> response1=attachmentService.downloadFile(id,response);
        return ResponseEntity.status(response1.isSuccess()?201:409).body(response1);
    }

    @Override
    public HttpEntity<?> getAllFileNameAndId() {
        ApiResponse<?> response = attachmentService.getAllFileNameAndId();
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }
}
