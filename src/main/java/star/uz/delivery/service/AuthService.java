package star.uz.delivery.service;

import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.payload.LoginDTO;

public interface AuthService {
    ApiResponse<?> login(LoginDTO loginDTO);
}
