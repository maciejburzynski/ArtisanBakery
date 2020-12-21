package pl.maciejburzynski.bakery.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.maciejburzynski.bakery.service.OrderService;

import java.util.Set;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "/api/orders")
public class OrderController {

    private final OrderService orderService;

    @GetMapping
    public Set getOrders() {
        log.info("Showing up all the breads");
        return orderService.getOrders();
    }
}
