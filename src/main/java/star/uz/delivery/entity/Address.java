package star.uz.delivery.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import star.uz.delivery.entity.template.AbsUUID;

import javax.persistence.Entity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "address")
public class Address extends AbsUUID {
    private String addressName;
    private double lat;
    private double lan;
    private String street;
    private String home;
    private int flat;
    private String entrance;
    private int floor;
}
