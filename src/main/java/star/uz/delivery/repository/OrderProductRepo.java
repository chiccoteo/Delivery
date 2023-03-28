package star.uz.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import star.uz.delivery.entity.OrderProduct;

import java.util.UUID;

public interface OrderProductRepo extends JpaRepository<OrderProduct, UUID> {
}
