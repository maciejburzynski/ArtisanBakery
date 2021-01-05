package pl.maciejburzynski.bakery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.maciejburzynski.bakery.BakeryConfig;
import pl.maciejburzynski.bakery.entity.User;
import pl.maciejburzynski.bakery.exceptions.UserNotFoundException;
import pl.maciejburzynski.bakery.repository.UserCrudRepository;
import pl.maciejburzynski.bakery.security.BakerySecurity;
import pl.maciejburzynski.bakery.security.UserRole;

import javax.mail.MessagingException;

import static pl.maciejburzynski.bakery.security.UserRole.USER;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserCrudRepository userCrudRepository;
    private final PasswordEncoder passwordEncoder;
    private final MailService mailService;


    public UserDetails findByUsername(String s) {
        return userCrudRepository.findByUsername(s)
                .orElseThrow(() -> new UserNotFoundException("User doesn't exist " + s));
    }

    public void addUser(User user) throws MessagingException {
//        user.setGrantedAuthorities(USER.getGrantedAuthorities());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
            mailService.sendMail(user.getMail(),
                    "Witaj Piekarzu!",
                    "Jeśli dostałeś tego maila - jest dobrze ;)",
                    false);

        userCrudRepository.addUser(user);
    }

    public void addInitialUser(User user) {
        userCrudRepository.addUser(user);
    }
}
