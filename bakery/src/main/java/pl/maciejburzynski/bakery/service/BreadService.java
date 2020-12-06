package pl.maciejburzynski.bakery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.maciejburzynski.bakery.entity.Bread;
import pl.maciejburzynski.bakery.repository.BreadRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class BreadService {

    private final BreadRepository breadRepository;


    public Set<Bread> getAll() {
    return breadRepository.getAll();
    }

    public void addBread(Bread bread) {
        breadRepository.addBread(bread);
    }

    public void addBreads(Bread... breads) {
        breadRepository.addBreads(breads);
    }
}
