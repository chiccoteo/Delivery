package star.uz.delivery.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import star.uz.delivery.payload.UserCreatDto;
import star.uz.delivery.payload.UserUpdateDto;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

import static star.uz.delivery.utils.AppConstant.BASE_PATH;

@RequestMapping(UserController.path)
public interface UserController {
    String path = BASE_PATH + "/user";

    @PostMapping
    HttpEntity<?> creat(@RequestBody UserCreatDto creatDto);

    @PutMapping
    HttpEntity<?> update(@RequestBody UserUpdateDto updateDto);

    @GetMapping
    HttpEntity<?> get();

    @GetMapping("/{id}")
    HttpEntity<?> getById(@PathVariable UUID id);

    @DeleteMapping("/{id}")
    HttpEntity<?> delete(@PathVariable UUID id);
    @PostMapping ("//uploadUserProfilePhoto/{userId}")
    HttpEntity<?> userPhotoUpload(@PathVariable UUID userId, MultipartHttpServletRequest photo)throws  IOException;

    @GetMapping("downloadUserProfilePhoto/{id}")
    HttpEntity<?> downloadUserProfile(@PathVariable UUID id, HttpServletResponse response)throws IOException;
}
