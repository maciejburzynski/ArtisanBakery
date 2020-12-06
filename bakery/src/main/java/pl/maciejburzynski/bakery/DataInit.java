package pl.maciejburzynski.bakery;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pl.maciejburzynski.bakery.entity.Bread;
import pl.maciejburzynski.bakery.service.BreadService;
import java.math.BigDecimal;

@Component
@RequiredArgsConstructor
@Slf4j
public class DataInit {

  private final BreadService breadService;


    @EventListener(ApplicationReadyEvent.class)
    public void initBreads(){
        addBreads();
    }

    private void addBreads() {
        Bread bread = new Bread(1L,"Wielozbożowy", new BigDecimal(2.99));
        Bread bread1 = new Bread(2L,"Pytlowy", new BigDecimal(3.99));
        breadService.addBreads(bread, bread1);
    }
}
