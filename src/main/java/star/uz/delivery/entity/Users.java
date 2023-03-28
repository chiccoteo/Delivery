package star.uz.delivery.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.Hibernate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import star.uz.delivery.entity.template.AbsUUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.UUID;

@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Users extends AbsUUID implements UserDetails {
    @Column(nullable = false)
    private String fio;
    @Column(nullable = false, unique = true)
    private String phoneNumber;
    private String address;
    private String password;
    private UUID photoId;
    @ManyToOne
    private Role role;

    //security
    private boolean accountNonExpired=true;
    private boolean accountNonLocked=true;
     private boolean credentialsNonExpired=true;
     boolean enabled=true;

    public Users( String fio, String phoneNumber, String address, String password, Role role) {
        this.fio = fio;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.password = password;
        this.role = role;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(role);
    }

    @Override
    public String getUsername() {
        return this.fio;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.accountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.accountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.credentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return this.enabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Users users = (Users) o;
        return getId() != null && Objects.equals(getId(), users.getId());
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }





}
