package pl.maciejburzynski.bakery.repository;

import org.springframework.data.repository.CrudRepository;
import pl.maciejburzynski.bakery.entity.Token;
import pl.maciejburzynski.bakery.entity.User;

import java.util.Optional;

public interface ITokenCrudRepository extends CrudRepository<Token, Long> {
    Optional<Token> findByUser(User user);
}
