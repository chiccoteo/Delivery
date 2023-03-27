package star.uz.delivery.controllerImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import star.uz.delivery.controller.AuthController;
import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.payload.LoginDTO;
import star.uz.delivery.service.AuthService;

@RestController
@RequiredArgsConstructor
public class AuthControllerImpl implements AuthController {

    private  final AuthService authService;
    @Override
    public HttpEntity<?> login(LoginDTO loginDTO) {
        ApiResponse<?> apiResponse= authService.login(loginDTO);
        return ResponseEntity.status(apiResponse.isSuccess()?200:401).body(apiResponse);
    }
}
