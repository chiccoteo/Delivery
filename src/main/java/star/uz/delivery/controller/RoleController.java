package star.uz.delivery.controller;

import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/role")
public interface RoleController {
    @GetMapping("/{id}")
    HttpEntity<?> getRole(@PathVariable Long id);

    @GetMapping("/list")
    HttpEntity<?>getRole();


}
