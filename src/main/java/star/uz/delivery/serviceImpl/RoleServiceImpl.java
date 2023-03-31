package star.uz.delivery.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import star.uz.delivery.entity.Role;
import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.payload.RoleGetDto;
import star.uz.delivery.repository.RoleRepo;
import star.uz.delivery.service.RoleService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepo roleRepo;

    @Override
    public ApiResponse<?> getRoleId(Long id) {
        Optional<Role> optionalRole = roleRepo.findById(id);
        if(optionalRole.isEmpty()){
            return ApiResponse.errorResponse("Role not sound");
        }
        return ApiResponse.successResponse(optionalRole.get());
    }

    @Override
    public ApiResponse<?> getAllRole() {
        List<RoleGetDto> roleGetDtoList = roleRepo.findAll().stream().map(this::generateRoleDto).collect(Collectors.toList());
        return ApiResponse.successResponse(roleGetDtoList);
    }
    private RoleGetDto generateRoleDto(Role role){
        return RoleGetDto.builder()
                .roleId(role.getId())
                .name(role.getRoleName().name())
                .build();
    }
}
