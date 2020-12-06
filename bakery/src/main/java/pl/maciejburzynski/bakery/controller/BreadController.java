package pl.maciejburzynski.bakery.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.maciejburzynski.bakery.entity.Bread;
import pl.maciejburzynski.bakery.service.BreadService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = ("/restapi/breads"))
public class BreadController {

    private final BreadService breadService;

    @GetMapping
    public Set getBreads(){
        return breadService.getAll();
    }

    @PostMapping
    public void addBread(Bread bread){
        breadService.addBread(bread);
    }

}
