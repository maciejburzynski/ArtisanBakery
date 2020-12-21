package pl.maciejburzynski.bakery.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.maciejburzynski.bakery.entity.User;

import java.util.Objects;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserCrudRepository {

    private final IUserCrudRepository userCrudRepository;

    public Optional<User> findByUsername(String username){
        return userCrudRepository.findByUsername(username);
    }

    public void addUser(User user) {
        userCrudRepository.save(user);
    }
}
