package pl.maciejburzynski.bakery.entity;

import lombok.*;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customers")
@Setter
@Getter
public class Customer extends BasicEntity {

    private String firstName;
    private String lastName;

    @OneToOne()
    private Order order;

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
