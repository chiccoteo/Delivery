package star.uz.delivery.entity.template;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;

import javax.persistence.MappedSuperclass;
import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class AbsEntity extends AbsUUID {

    private String name;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        AbsEntity absEntity = (AbsEntity) o;
        return getId() != null && Objects.equals(getId(), absEntity.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

}
