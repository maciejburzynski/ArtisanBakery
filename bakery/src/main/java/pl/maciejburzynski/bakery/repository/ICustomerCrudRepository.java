package pl.maciejburzynski.bakery.repository;

import org.springframework.data.repository.CrudRepository;
import pl.maciejburzynski.bakery.entity.Customer;

public interface ICustomerCrudRepository extends CrudRepository<Customer, Long> {
}
