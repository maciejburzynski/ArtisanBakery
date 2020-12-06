package pl.maciejburzynski.bakery.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Bread {

    private Long id;
    private String name;
    private BigDecimal price;

}
