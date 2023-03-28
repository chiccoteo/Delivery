package star.uz.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import star.uz.delivery.entity.Order;

import java.util.UUID;

public interface OrderRepo extends JpaRepository<Order, UUID> {
}
