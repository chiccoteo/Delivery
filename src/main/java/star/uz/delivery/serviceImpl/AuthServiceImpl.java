package star.uz.delivery.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import star.uz.delivery.entity.Users;
import star.uz.delivery.secret.JwtProvider;
import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.payload.LoginDTO;
import star.uz.delivery.service.AuthService;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final JwtProvider jwtProvider;
    private final AuthenticationManager manager;
    @Override
    public ApiResponse<?> login(LoginDTO loginDTO) {
        try{
            Authentication authentication = manager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getFio(),loginDTO.getPassword()));
            Users principal = (Users)  authentication.getPrincipal();
            return  ApiResponse.successResponse("You have successfully logged in ",jwtProvider.generateToken(principal));
        }catch (Exception e){
            e.getStackTrace();
            return  ApiResponse.errorResponse(e.getMessage());
        }
    }
}
