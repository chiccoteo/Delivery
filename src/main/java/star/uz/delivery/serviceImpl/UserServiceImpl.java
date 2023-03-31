package star.uz.delivery.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import star.uz.delivery.entity.Role;
import star.uz.delivery.entity.Users;
import star.uz.delivery.payload.ApiResponse;
import star.uz.delivery.payload.UserCreatDto;
import star.uz.delivery.payload.UserUpdateDto;
import star.uz.delivery.repository.AttachmentContentRepo;
import star.uz.delivery.repository.AttachmentRepo;
import star.uz.delivery.repository.RoleRepo;
import star.uz.delivery.repository.UserRepo;
import star.uz.delivery.service.UserService;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;
    private final AttachmentRepo attachmentRepo;
    private final AttachmentContentRepo attachmentContentRepo;
    private final RoleRepo roleRepo;

    @Override
    public ApiResponse<?> creatUser(UserCreatDto userCreatDto) {
        Optional<Role> optionalRole = roleRepo.findById(userCreatDto.getRoleId());
        if (optionalRole.isEmpty()) {
            return ApiResponse.errorResponse("Role not found");
        }
        Role role = optionalRole.get();
        if (userRepo.existsByPhoneNumber(userCreatDto.getPhoneNumber())) {
            return ApiResponse.errorResponse("The user at this number already exists");
        }
        Users user = new Users();
        user.setFio(userCreatDto.getFio());
        user.setPhoneNumber(userCreatDto.getPhoneNumber());
        user.setAddress(userCreatDto.getAddress());
        user.setPassword(passwordEncoder.encode(userCreatDto.getPassword()));
        user.setRole(role);
        userRepo.save(user);
        return ApiResponse.successResponse("User added!");
    }

    @Override
    public ApiResponse<?> update(UserUpdateDto dto,UUID id) {
        Optional<Users> optionalUsers = userRepo.findById(id);
        if (optionalUsers.isEmpty()){
            return ApiResponse.errorResponse("User not found");
        }
        Users users = optionalUsers.get();
        Optional<Role> optional = roleRepo.findById(dto.getRoleId());
        if (optional.isEmpty()){
            return ApiResponse.errorResponse("Role not found");
        }
        Role role = optional.get();
        users.setFio(dto.getFio());
        users.setAddress(dto.getAddress());
        users.setPhoneNumber(dto.getPhoneNumber());
        users.setPassword(passwordEncoder.encode(dto.getPassword()));
        users.setRole(role);
        userRepo.save(users);
        return ApiResponse.successResponse("User saved");
    }

    @Override
    public ApiResponse<?> downloadUserProfile(UUID id, HttpServletResponse response) {
        return null;
    }

    @Override
    public ApiResponse<?> userPhotoUpload(UUID userId, MultipartHttpServletRequest photo) {
        return null;
    }

    @Override
    public ApiResponse<?> deleteUser(UUID id) {
    try{
        userRepo.deleteById(id);
    }catch (Exception e){
        return ApiResponse.errorResponse("User not deleted");
    }

        return ApiResponse.successResponse("User Deleted ");
    }

    @Override
    public ApiResponse<?> getByIdUser(UUID id) {
        Optional<Users> optionalUsers = userRepo.findById(id);
        if (optionalUsers.isEmpty()){
            return ApiResponse.errorResponse("User not found");
        }
        return ApiResponse.successResponse(optionalUsers.get());
    }

    @Override
    public ApiResponse<?> getAllUser() {
        List<UserCreatDto> all=userRepo.findAll().stream()
                .map(this::generateUserDto)
                .collect(Collectors.toList());
        return ApiResponse.successResponse(all);
    }
    public UserCreatDto generateUserDto(Users users){
        return UserCreatDto.builder()
                .id(users.getId())
                .fio(users.getFio())
                .address(users.getAddress())
                .phoneNumber(users.getPhoneNumber())
                .roleId(users.getRole().getId())
                .build();
    }
}
