package star.uz.delivery.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import star.uz.delivery.payload.ApiResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

public interface AttachmentService {
    ApiResponse<?> uploadFile(MultipartHttpServletRequest file) throws IOException;

    ApiResponse<?> downloadFile(UUID id , HttpServletResponse response) throws IOException;

    ApiResponse<?> getAllFileNameAndId();

}
