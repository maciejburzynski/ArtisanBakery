package pl.maciejburzynski.bakery.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.maciejburzynski.bakery.service.UserService;

@Configuration
@RequiredArgsConstructor
public class BakerySecurity extends WebSecurityConfigurerAdapter {

    private final UserDetailsServiceImpl userService;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.headers().disable();
//        http.authorizeRequests()
//                .antMatchers("/api/breads").permitAll()
//                .antMatchers("/signup").permitAll()
//                .antMatchers("/register").permitAll()
//                .antMatchers("/environment").hasAuthority("ROLE_ADMIN")
//                .and()
//                .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }
}
