package pl.maciejburzynski.bakery;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejburzynski.bakery.entity.Bread;
import pl.maciejburzynski.bakery.entity.Customer;
import pl.maciejburzynski.bakery.service.BreadService;
import pl.maciejburzynski.bakery.service.CustomerService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInit {

  private final BreadService breadService;
  private final CustomerService customerService;


    @EventListener(ApplicationReadyEvent.class)
    public void initBreads(){
        addCustomers();
        addBreads();
    }


    private void addBreads() {
        Bread bread = new Bread("Wielozbożowy", BigDecimal.valueOf(2.99));
        Bread bread1 = new Bread("Pytlowy", BigDecimal.valueOf(3.99));

        breadService.addBread(bread);
        breadService.addBread(bread1);
    }

    private void addCustomers() {
        Customer customer = new Customer("Andrzej","Andrzejewski");
        Customer customer1 = new Customer("Marcin","Marcinowski");

        customerService.addCustomer(customer);
        customerService.addCustomer(customer1);
    }
}
