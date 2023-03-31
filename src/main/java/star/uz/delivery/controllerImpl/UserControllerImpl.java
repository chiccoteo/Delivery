package star.uz.delivery.controllerImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import star.uz.delivery.controller.UserController;
import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.payload.UserCreatDto;
import star.uz.delivery.payload.UserUpdateDto;
import star.uz.delivery.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;
@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {
    private final UserService userService;
    @Override
    public HttpEntity<?> creat(UserCreatDto creatDto) {
        ApiResponse<?> response  =userService.creatUser(creatDto);
        return ResponseEntity.status(response.isSuccess()?200:409).body(response);
    }

    @Override
    public HttpEntity<?> update(UserUpdateDto updateDto,UUID id) {
        ApiResponse<?> response= userService.update(updateDto,id);
        return ResponseEntity.status(response.isSuccess()?200:409).body(response);
    }

    @Override
    public HttpEntity<?> get() {
        ApiResponse<?> response=userService.getAllUser();
        return ResponseEntity.status(response.isSuccess()?201:49).body(response);
    }

    @Override
    public HttpEntity<?> getById(UUID id) {
        ApiResponse<?> response=userService.getByIdUser(id);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }

    @Override
    public HttpEntity<?> delete(UUID id) {
        ApiResponse<?> response=userService.deleteUser(id);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }

    @Override
    public HttpEntity<?> userPhotoUpload(UUID userId, MultipartHttpServletRequest photo) throws IOException {
        ApiResponse<?> response =userService.userPhotoUpload(userId,photo);
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }

    @Override
    public HttpEntity<?> downloadUserProfile(UUID id, HttpServletResponse response) throws IOException {
        ApiResponse<?> apiResponse=userService.downloadUserProfile(id,response);
        return ResponseEntity.status(apiResponse.isSuccess()?201:409).body(apiResponse);
    }
}
