package star.uz.delivery.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@RequestMapping("/profile")
public interface AttachmentController {

    @PostMapping("/upload")
    HttpEntity<?> uploadFile(MultipartHttpServletRequest file) throws IOException;

    @GetMapping("download/{id}")
    HttpEntity<?> download(@PathVariable UUID id, HttpServletResponse response)throws IOException;


    @GetMapping("/")
    HttpEntity<?> getAllFileNameAndId();

}
