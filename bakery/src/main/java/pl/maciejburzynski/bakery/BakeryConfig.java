package pl.maciejburzynski.bakery;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties
@Component
@Data
public class BakeryConfig {

    private String environmentName;
    private String weatherKey;
}
