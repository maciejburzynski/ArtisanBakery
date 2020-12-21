package pl.maciejburzynski.bakery;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejburzynski.bakery.entity.Bread;
import pl.maciejburzynski.bakery.entity.Customer;
import pl.maciejburzynski.bakery.entity.Order;
import pl.maciejburzynski.bakery.entity.User;
import pl.maciejburzynski.bakery.service.BreadService;
import pl.maciejburzynski.bakery.service.CustomerService;
import pl.maciejburzynski.bakery.service.OrderService;
import pl.maciejburzynski.bakery.service.UserService;

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
    private final OrderService orderService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @EventListener(ApplicationReadyEvent.class)
    public void initBreads() {
        addCustomers();
        addBreads();
        addOrders();
        addUsers();
    }

    private void addBreads() {
        Bread bread = new Bread("Wielozbożowy", BigDecimal.valueOf(2.99));
        Bread bread1 = new Bread("Pytlowy", BigDecimal.valueOf(3.99));

        breadService.addBread(bread);
        breadService.addBread(bread1);
    }

    private void addCustomers() {
        Customer customer = new Customer("Andrzej", "Andrzejewski");
        Customer customer1 = new Customer("Marcin", "Marcinowski");

        customerService.addCustomer(customer);
        customerService.addCustomer(customer1);
    }

    private void addOrders() {
        Order order = new Order();
        Customer customer = new Customer("Andrzej", "Gołota");
        Bread bread = new Bread("Żulik", BigDecimal.valueOf(1.99));

        order.assignCustomer(customer);
        order.setBreads(Arrays.asList(bread));

        orderService.addOrder(order);
    }

    private void addUsers() {
        User user = new User();
        User admin = new User();


        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("user123"));
        user.setRole("ROLE_USER");

        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin123"));
        admin.setRole("ROLE_ADMIN");

        userService.addUser(user);
        userService.addUser(admin);
    }
}
