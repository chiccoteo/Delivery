package star.uz.delivery.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import star.uz.delivery.configuration.enums.OrderStatus;
import star.uz.delivery.entity.template.AbsUUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "orders")
public class Order extends AbsUUID {
    private UUID customerId;
    private UUID addressId;
    private Date deliveryTime;
    private Double deliveryPrice;
    private UUID branchId;
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;
}
