package star.uz.delivery.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import star.uz.delivery.payload.LoginDTO;

import javax.validation.Valid;

@RequestMapping("/userLogin")
public interface AuthController {
    @PostMapping("/login")
    HttpEntity<?> login(@Valid @RequestBody LoginDTO loginDTO);
}
