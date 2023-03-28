package star.uz.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import star.uz.delivery.entity.Product;

import java.util.UUID;

public interface ProductRepo extends JpaRepository<Product, UUID> {
}
