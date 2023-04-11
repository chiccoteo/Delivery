package star.uz.delivery.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import star.uz.delivery.entity.Restaurant;

import java.util.UUID;

public interface   RestaurantRepo extends JpaRepository<Restaurant, UUID> {
    boolean existsByRestaurantNameAndPhoneNumber(String restaurantName, String phoneNumber);
}
