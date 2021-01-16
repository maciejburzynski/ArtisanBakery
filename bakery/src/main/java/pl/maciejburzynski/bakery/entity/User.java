package pl.maciejburzynski.bakery.entity;

import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.maciejburzynski.bakery.security.UserRole;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

import static pl.maciejburzynski.bakery.security.UserRole.ADMIN;
import static pl.maciejburzynski.bakery.security.UserRole.USER;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "users")
public class User extends BasicEntity implements UserDetails {

    private String username;
    private String password;
    private String mail;
    private String role;
    private Boolean enable;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role.equals(ADMIN.name())) {
            return ADMIN.getGrantedAuthorities();
        } else {
            return USER.getGrantedAuthorities();
        }
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enable;
    }
}

