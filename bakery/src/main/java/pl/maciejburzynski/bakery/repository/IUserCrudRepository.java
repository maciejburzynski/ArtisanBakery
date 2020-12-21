package pl.maciejburzynski.bakery.repository;

import org.springframework.data.repository.CrudRepository;
import pl.maciejburzynski.bakery.entity.User;

import java.util.Optional;

public interface IUserCrudRepository extends CrudRepository<User, Long> {

    Optional<User> findByUsername(String username);
}
