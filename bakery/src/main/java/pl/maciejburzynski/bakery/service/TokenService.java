package pl.maciejburzynski.bakery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.maciejburzynski.bakery.entity.Token;
import pl.maciejburzynski.bakery.entity.User;
import pl.maciejburzynski.bakery.repository.TokenCrudRepository;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class TokenService {

    private final TokenCrudRepository tokenCrudRepository;

    public String generateToken() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    public void saveToken(Token token) {
        tokenCrudRepository.saveToken(token);
    }

    public Token findByUser(User user) {
        return tokenCrudRepository.findByUser(user)
                .orElseThrow(() -> new RuntimeException("chujnia z tym tokenem byczq"));
    }
}
