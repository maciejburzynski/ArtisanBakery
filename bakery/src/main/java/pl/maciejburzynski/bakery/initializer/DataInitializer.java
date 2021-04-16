package pl.maciejburzynski.bakery.initializer;

import  lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pl.maciejburzynski.bakery.BakeryConfig;
import pl.maciejburzynski.bakery.entity.Bread;
import pl.maciejburzynski.bakery.entity.Customer;
import pl.maciejburzynski.bakery.entity.Order;
import pl.maciejburzynski.bakery.entity.User;
import pl.maciejburzynski.bakery.service.BreadService;
import pl.maciejburzynski.bakery.service.CustomerService;
import pl.maciejburzynski.bakery.service.OrderService;
import pl.maciejburzynski.bakery.service.UserService;

import java.math.BigDecimal;
import java.util.Arrays;

import static pl.maciejburzynski.bakery.security.UserRole.*;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer {

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

        breadService.saveBread(bread);
        breadService.saveBread(bread1);
    }

    private void addCustomers() {
        Customer customer = new Customer("Andrzej", "Andrzejewski");
        Customer customer1 = new Customer("Marcin", "Marcinowski");

        customerService.saveCustomer(customer);
        customerService.saveCustomer(customer1);
    }

    private void addOrders() {
        Order order = new Order();
        Customer customer = new Customer("Andrzej", "Gołota");
        Bread bread = new Bread("Żulik", BigDecimal.valueOf(1.99));

        order.assignCustomer(customer);
        order.setBreads(Arrays.asList(bread));

        orderService.saveOrder(order);
    }

    private void addUsers() {
        User user = new User();
        User admin = new User();

        user.setMail("maciekburzynski@op.pl");
        user.setUsername("user");
        user.setUserRole(USER);
        user.setPassword(passwordEncoder.encode("user"));
        user.setEnable(true);

        admin.setMail("maciekburzynski@op.pl");
        admin.setUsername("admin");
        admin.setUserRole(ADMIN);
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setEnable(true);

        userService.saveUser(user);
        userService.saveUser(admin);
    }
}
