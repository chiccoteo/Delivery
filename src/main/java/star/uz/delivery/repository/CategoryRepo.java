package star.uz.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import star.uz.delivery.entity.Category;

public interface CategoryRepo extends JpaRepository<Category,Long> {
    boolean existsByName(String name);
}
