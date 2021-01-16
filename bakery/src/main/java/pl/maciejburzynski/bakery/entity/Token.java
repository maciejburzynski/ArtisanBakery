package pl.maciejburzynski.bakery.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "tokens")
public class Token extends BasicEntity {

    private String value;

    @OneToOne(cascade = CascadeType.ALL)
    private User user;
}
