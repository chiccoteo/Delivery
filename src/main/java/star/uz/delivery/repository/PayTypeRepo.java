package star.uz.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import star.uz.delivery.entity.PayType;

public interface PayTypeRepo extends JpaRepository<PayType,Long> {
}
