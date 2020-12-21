package pl.maciejburzynski.bakery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.maciejburzynski.bakery.entity.Order;
import pl.maciejburzynski.bakery.repository.OrderCrudRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderCrudRepository orderCrudRepository;

    public void addOrder(Order order) {
    orderCrudRepository.addOrder(order);
    }

    public Set getOrders() {
        return orderCrudRepository.getOrders();
    }
}
