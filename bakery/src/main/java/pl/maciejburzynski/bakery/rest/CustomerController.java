package pl.maciejburzynski.bakery.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.maciejburzynski.bakery.entity.Customer;
import pl.maciejburzynski.bakery.service.CustomerService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "api/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public Set<Customer> getCustomers(){
        log.info("Showing up all the customers");
        return customerService.getCustomers();
    }

    @GetMapping("/{id}")
    public Customer getCustomers(@PathVariable Long id){
        log.info("Showing customer no.: {}", id);
        return customerService.getCustomerById(id);
    }

    @PostMapping
    public ResponseEntity addCustomer(@RequestBody Customer customer){
        log.info("Adding customer: {} time...", customer);
        customerService.addCustomer(customer);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity deleteCustomer(@PathVariable Long id){
        log.info("Remocing customer no.: {}", id);
        customerService.deleteCustomerById(id);
        return ResponseEntity
                .status(HttpStatus.OK)
                .build();
    }


}
