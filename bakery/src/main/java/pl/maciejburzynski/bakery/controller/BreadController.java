package pl.maciejburzynski.bakery.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maciejburzynski.bakery.entity.Bread;
import pl.maciejburzynski.bakery.service.BreadService;

import java.util.Set;

@RequiredArgsConstructor
@RequestMapping(value = ("/api/breads"))
@Slf4j
@RestController
public class BreadController {

    private final BreadService breadService;

    @GetMapping
    public Set getBreads() {
        log.info("Showing up all the breads");
        return breadService.getBreads();
    }

    @GetMapping(path = "/{id}")
    public Bread getBread(@PathVariable Long id) {
        log.info("Showing bread no.: {}", id);
        return breadService.getBreadById(id);
    }

    @PostMapping
    public ResponseEntity addBread(@RequestBody Bread bread) {
        log.info("Adding bread: {} time...", bread);
        breadService.addBread(bread);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteBreadById(@PathVariable Long id) {
        log.info("Removing bread with ID no. : {} time...", id);
        breadService.deleteBreadById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity updateBread(@PathVariable Long id, @RequestBody Bread bread) {
        log.info("Updating bread with ID no. : {} time...", id);
        breadService.updateBread(id, bread.getName(), bread.getPrice());
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }
}


