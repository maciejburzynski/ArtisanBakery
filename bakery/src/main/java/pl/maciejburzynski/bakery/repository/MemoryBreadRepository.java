package pl.maciejburzynski.bakery.repository;

import lombok.Getter;
import org.springframework.stereotype.Repository;
import pl.maciejburzynski.bakery.entity.Bread;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class MemoryBreadRepository implements BreadRepository {
    private Set<Bread> breads = new HashSet<>();

    @Override
    public Set<Bread> getAll() {
        return breads;
    }

    @Override
    public void addBread(Bread bread) {
        breads.add(bread);
    }

    @Override
    public void addBreads(Bread... breadsToAdd) {
        for (Bread bread :
                breadsToAdd) {
            breads.add(bread);
        }
    }
}
