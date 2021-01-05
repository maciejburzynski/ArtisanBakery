package pl.maciejburzynski.bakery.entity;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import pl.maciejburzynski.bakery.security.UserRole;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Collection;
import java.util.Collections;
import java.util.Set;

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
    @Transient
    private Set <? extends GrantedAuthority> authorities;

//    public User(Set<? extends GrantedAuthority> authorities) {
//        this.authorities = authorities;
//    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (role.equals("ADMIN")) {
            return UserRole.ADMIN.getGrantedAuthorities();
        } else {
            return UserRole.USER.getGrantedAuthorities();
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
        return true;
    }
}

