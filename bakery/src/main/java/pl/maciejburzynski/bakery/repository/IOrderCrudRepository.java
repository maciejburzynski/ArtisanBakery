package pl.maciejburzynski.bakery.repository;

import org.springframework.data.repository.CrudRepository;
import pl.maciejburzynski.bakery.entity.Customer;
import pl.maciejburzynski.bakery.entity.Order;

public interface IOrderCrudRepository extends CrudRepository<Order, Long> {
}
