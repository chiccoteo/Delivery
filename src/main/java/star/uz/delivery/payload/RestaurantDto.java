package star.uz.delivery.payload;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.sql.Time;
import java.util.Date;
import java.util.UUID;

@Data
@Builder
public class RestaurantDto {
    private UUID id;
    @Column(nullable = false)
    private  String restaurantName;
    private String address;
    @Column(nullable = false)
    private String phoneNumber;
    private Time openTime;
    private Time closeTime;

}
