package star.uz.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import star.uz.delivery.entity.Payment;

import java.util.UUID;

public interface PaymentRepo extends JpaRepository<Payment, UUID> {
}
