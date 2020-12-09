package pl.maciejburzynski.bakery.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import pl.maciejburzynski.bakery.entity.Bread;

import java.math.BigDecimal;

interface IBreadCrudRepository extends CrudRepository<Bread, Long> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE Bread SET name = :name, price= :price WHERE id = :id", nativeQuery = true)
    void updateBread(@Param("id") Long id,
            @Param("name") String name,
            @Param("price") BigDecimal price);
}
