package star.uz.delivery.controllerImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import star.uz.delivery.controller.RoleController;
import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.service.RoleService;
@RestController
@RequiredArgsConstructor
public class RoleControllerImpl implements RoleController {
    private final RoleService roleService;

    @Override
    public HttpEntity<?> getRole(Long id) {
        ApiResponse<?> response = roleService.getRoleId(id);
        return ResponseEntity.status(response.isSuccess() ? 201 : 409).body(response);
    }

    @Override
    public HttpEntity<?> getRole() {
        ApiResponse<?> response = roleService.getAllRole();
        return ResponseEntity.status(response.isSuccess()?201:409).body(response);
    }
}
