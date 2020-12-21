package pl.maciejburzynski.bakery.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
@Setter
@Getter
@NoArgsConstructor
public class Order extends BasicEntity{


    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private Customer customer;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Bread> breads;


    public Order(Customer customer) {
        this.customer = customer;
    }

    public Order(Customer customer, List<Bread> breads) {
        this.customer = customer;
        this.breads = breads;
    }

    public void assignCustomer(Customer customer) {
        setCustomer(customer);
    }
}
