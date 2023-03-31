package star.uz.delivery.service;

import star.uz.delivery.payload.ApiResponse;

public interface RoleService {
    ApiResponse<?> getRoleId(Long id);

    ApiResponse<?> getAllRole();

}
