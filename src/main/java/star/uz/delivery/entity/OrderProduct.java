package star.uz.delivery.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import star.uz.delivery.entity.template.AbsUUID;

import javax.persistence.Entity;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class OrderProduct extends AbsUUID {
    private UUID productId;
    private int amount;
    private Double price;
    private UUID orderId;
}
