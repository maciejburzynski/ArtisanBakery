package pl.maciejburzynski.bakery.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Getter
@Setter
@Table(name = "breads")
@NoArgsConstructor
@Entity
public class Bread extends BasicEntity {

    private String name;
    private BigDecimal price;

    public Bread(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
}
