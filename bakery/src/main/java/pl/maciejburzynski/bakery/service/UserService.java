package pl.maciejburzynski.bakery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pl.maciejburzynski.bakery.BakeryConfig;
import pl.maciejburzynski.bakery.entity.Token;
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
    private final TokenService tokenService;


    public void saveUser(User user) throws MessagingException {
        userCrudRepository.addUser(user);
    }

    public UserDetails findByUsername(String s) {
        return userCrudRepository.findByUsername(s)
                .orElseThrow(() -> new UserNotFoundException("User doesn't exist " + s));
    }


    public void addInitialUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }

    public void activateUser(User user) {
        user.setRole(USER.name());
        user.setEnable(true);
        userCrudRepository.addUser(user);
    }

    public void sendTokenToUser(User user) throws MessagingException {

        Token token = new Token();
        token.setValue(tokenService.generateToken());
        token.setUser(user);
        tokenService.saveToken(token);

        mailService.sendMail(user.getMail(),
                "Witaj Piekarzu!",
                "Jeśli dostałeś tego maila - jest dobrze ;) Twój kod aktywacyjny to "
                        + token.getValue(),
                false);

    }

    public void addInactiveUserToDatabase(User userToBeRegisteredHolder) {
        userToBeRegisteredHolder.setEnable(false);
        userToBeRegisteredHolder.setRole(USER.name());
    }
}
