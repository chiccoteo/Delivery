package star.uz.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import star.uz.delivery.entity.Characters;

public interface CharactersRepo extends JpaRepository<Characters,Long> {
}
