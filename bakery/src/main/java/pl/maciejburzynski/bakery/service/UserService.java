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

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserCrudRepository userCrudRepository;
    private final PasswordEncoder passwordEncoder;


    public UserDetails findByUsername(String s) {
        return userCrudRepository.findByUsername(s)
                .orElseThrow(() -> new UserNotFoundException("User doesn't exist"));
    }

    public void addUser(User user) {
        user.setRole("ROLE_USER");
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userCrudRepository.addUser(user);
    }
}
