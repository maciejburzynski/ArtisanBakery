package pl.maciejburzynski.bakery.service;

import javassist.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejburzynski.bakery.entity.Bread;
import pl.maciejburzynski.bakery.exceptions.BreadNotFoundException;
import pl.maciejburzynski.bakery.repository.BreadCrudRepository;

import java.math.BigDecimal;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class BreadService {

    private final BreadCrudRepository breadRepository;


    public Set<Bread> getBreads() {
        return breadRepository.getAll();
    }

    public Bread getBreadById(Long id) {
        return breadRepository.getBreadById(id)
                .orElseThrow(() -> new BreadNotFoundException("Requested bread doesn't exist"));
    }

    public void addBread(Bread bread) {
        breadRepository.addBread(bread);
    }

    public void deleteBreadById(Long id) {
        breadRepository.deleteBreadById(id);
    }

    public void updateBread(Long id, String name, BigDecimal price) {
        breadRepository.updateBread(id, name, price);
    }
}
