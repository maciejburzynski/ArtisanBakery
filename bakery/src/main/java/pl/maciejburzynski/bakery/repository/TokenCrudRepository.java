package pl.maciejburzynski.bakery.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.maciejburzynski.bakery.entity.Token;
import pl.maciejburzynski.bakery.entity.User;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TokenCrudRepository {

    private final ITokenCrudRepository tokenCrudRepository;

    public void saveToken(Token token) {
        tokenCrudRepository.save(token);
    }

    public Optional<Token> findByUser(User user) {
        return tokenCrudRepository.findByUser(user);
    }
}
