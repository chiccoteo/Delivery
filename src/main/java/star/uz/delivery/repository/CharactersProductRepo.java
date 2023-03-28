package star.uz.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import star.uz.delivery.entity.CharactersProduct;

import java.util.UUID;

public interface CharactersProductRepo extends JpaRepository<CharactersProduct, UUID> {
}
