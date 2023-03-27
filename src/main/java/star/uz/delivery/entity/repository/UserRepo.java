package star.uz.delivery.entity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import star.uz.delivery.entity.Users;

import java.util.Optional;
import java.util.UUID;

public interface UserRepo extends JpaRepository<Users, UUID> {

    Optional<Users> findByFio(String fio);
}
