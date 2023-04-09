package star.uz.delivery.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import star.uz.delivery.entity.template.AbsUUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product extends AbsUUID {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private double price;
    private UUID photo_id;
    private String description;
    private Long categoryId;
}
