package star.uz.delivery.entity.template;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import star.uz.delivery.entity.Users;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.TemporalType.TIMESTAMP;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public abstract  class AbsAuditor implements Serializable {
    @JoinColumn(updatable = false) // why
    @CreatedBy //Why
    @ManyToOne
    private Users createdBy;


    @JoinColumn(updatable = false)
    @CreatedDate
    @Temporal(TIMESTAMP)
    protected Date createdDate; //What is protected

    @LastModifiedBy
    @Temporal(TIMESTAMP)
    protected Date lastModifiedDate;

}
