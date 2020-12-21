package pl.maciejburzynski.bakery.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import pl.maciejburzynski.bakery.entity.Bread;
import pl.maciejburzynski.bakery.exceptions.BreadNotFoundException;

import java.math.BigDecimal;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RequiredArgsConstructor
@Repository
public class BreadCrudRepository  {
    private final IBreadCrudRepository breadCrudRepository;

    public Set<Bread> getAll() {
        return StreamSupport
                .stream(breadCrudRepository.findAll().spliterator(),false)
                .collect(Collectors.toSet());
    }

    public void addBread(Bread bread) {
        breadCrudRepository.save(bread);
    }

    public void addBreads(Iterable<Bread> breads) {
        breadCrudRepository.saveAll(breads);
    }

    public void deleteBreadById(Long id) {
        breadCrudRepository.deleteById(id);
    }

    public void updateBread(Long id, String name, BigDecimal price) {
        breadCrudRepository.updateBread(id, name, price);
    }

    public Optional<Bread> getBreadById(Long id) throws BreadNotFoundException {
     return breadCrudRepository.findById(id);
    }
}
