package star.uz.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import star.uz.delivery.configuration.enums.RoleName;
import star.uz.delivery.entity.Role;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByRoleName(RoleName roleName);
}
