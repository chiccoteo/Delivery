package star.uz.delivery.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import star.uz.delivery.entity.template.AbsLong;

import javax.persistence.Entity;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PayType extends AbsLong {
    private String  name;
    private UUID photoId;
}
