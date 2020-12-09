package pl.maciejburzynski.bakery.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.maciejburzynski.bakery.entity.Bread;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Primary
@Repository
public class BreadCrudRepository  {
    private final IBreadCrudRepository repository;

    public Set<Bread> getAll() {
        return StreamSupport
                .stream(repository.findAll().spliterator(),false)
                .collect(Collectors.toSet());
    }

    public void addBread(Bread bread) {
        repository.save(bread);
    }

    public void deleteBreadById(Long id) {
        repository.deleteById(id);
    }

    public void updateBread(Long id, String name, BigDecimal price) {
        repository.updateBread(id, name, price);
    }

    public Optional<Bread> getBreadById(Long id) {
     return repository.findById(id);
    }
}
