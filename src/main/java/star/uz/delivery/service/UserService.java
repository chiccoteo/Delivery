package star.uz.delivery.service;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.payload.UserCreatDto;
import star.uz.delivery.payload.UserUpdateDto;

import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

public interface UserService {
    ApiResponse<?> creatUser(UserCreatDto userCreatDto);

    ApiResponse<?> update(UserUpdateDto updateDto);

    ApiResponse<?> downloadUserProfile(UUID id, HttpServletResponse response);

    ApiResponse<?> userPhotoUpload(UUID userId, MultipartHttpServletRequest photo);

    ApiResponse<?> deleteUser(UUID id);

    ApiResponse<?> getByIdUser(UUID id);

    ApiResponse<?> getAllUser();

}
