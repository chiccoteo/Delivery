package star.uz.delivery.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import star.uz.delivery.entity.template.AbsEntity;
import star.uz.delivery.entity.template.AbsUUID;

import javax.persistence.Entity;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Restaurant extends AbsUUID {
    private String restaurantName;
    private String address;
    private String phoneNumber;
    private Date openTime;
    private Date closeTime;


}
