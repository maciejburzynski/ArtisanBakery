package pl.maciejburzynski.bakery.repository;

import pl.maciejburzynski.bakery.entity.Bread;

import java.util.Set;

public interface BreadRepository {

    Set<Bread> getAll();

    void addBread(Bread bread);

    void addBreads(Bread... breads);
}
