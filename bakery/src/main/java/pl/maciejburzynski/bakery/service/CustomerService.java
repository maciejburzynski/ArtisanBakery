package pl.maciejburzynski.bakery.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.maciejburzynski.bakery.entity.Customer;
import pl.maciejburzynski.bakery.exceptions.CustomerNotFoundException;
import pl.maciejburzynski.bakery.repository.CustomerCrudRepository;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerCrudRepository customerCrudRepository;

    public void saveCustomer(Customer customer) {
        customerCrudRepository.saveCustomer(customer);
    }

    public Set<Customer> getCustomers() {
        return customerCrudRepository.getAllCustomers();
    }

    public Customer getCustomerById(Long id) {
       return customerCrudRepository.getCustomerById(id)
               .orElseThrow(() -> new CustomerNotFoundException("Customer with provided ID doesn't exist"));
    }

    public void deleteCustomerById(Long id) {
        customerCrudRepository.deleteCustomerById(id);
    }
}
