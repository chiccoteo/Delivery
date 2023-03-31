package star.uz.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import star.uz.delivery.entity.Address;

import java.util.Optional;
import java.util.UUID;

public interface AddressRepo extends JpaRepository<Address, UUID> {

}
