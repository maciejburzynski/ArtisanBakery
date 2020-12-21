package pl.maciejburzynski.bakery.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.maciejburzynski.bakery.entity.Order;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
@RequiredArgsConstructor
public class OrderCrudRepository {

    private final IOrderCrudRepository orderCrudRepository;

    public void addOrder(Order order) {
        orderCrudRepository.save(order);
    }

    public Set getOrders() {
        return StreamSupport.stream(orderCrudRepository
                        .findAll()
                        .spliterator(),
                false)
                .collect(Collectors.toSet());
    }

}
