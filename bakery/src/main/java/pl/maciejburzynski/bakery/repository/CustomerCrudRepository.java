package pl.maciejburzynski.bakery.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import pl.maciejburzynski.bakery.entity.Customer;
import pl.maciejburzynski.bakery.exceptions.CustomerNotFoundException;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Repository
@RequiredArgsConstructor
public class CustomerCrudRepository {

    private final ICustomerCrudRepository customerCrudRepository;

    public void saveCustomer(Customer customer) {
        customerCrudRepository.save(customer);
    }

    public Set<Customer> getAllCustomers() {
        return StreamSupport
                .stream(customerCrudRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    public Optional<Customer> getCustomerById(Long id) throws CustomerNotFoundException {
        return customerCrudRepository.findById(id);
    }

    public void deleteCustomerById(Long id) {
      customerCrudRepository.deleteById(id);
    }
}

