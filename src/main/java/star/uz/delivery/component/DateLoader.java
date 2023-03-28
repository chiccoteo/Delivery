package star.uz.delivery.component;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import star.uz.delivery.configuration.enums.RoleName;
import star.uz.delivery.entity.Role;
import star.uz.delivery.entity.Users;
import star.uz.delivery.repository.RoleRepo;
import star.uz.delivery.repository.UserRepo;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DateLoader implements CommandLineRunner {

    private final PasswordEncoder passwordEncoder;
    private final RoleRepo roleRepo;
    private final UserRepo userRepo;
//    private final
    @Value("${spring.sql.init.mode}")
    private String mode;
    @Override
    public void run(String... args) throws Exception {
        if (mode.equals("always")){
            Role admin = new Role(RoleName.ROLE_ADMIN);
            Role manager = new Role(RoleName.ROLE_MANAGER);
            Role employee = new Role(RoleName.ROLE_EMPLOYEE);
            roleRepo.saveAll(List.of(admin,manager,employee));
            Users userAdmin =new Users("Firuzbek","+998932101600","Toshkent", passwordEncoder.encode("12345678"),admin);
            userRepo.save(userAdmin);

        }
    }
}
