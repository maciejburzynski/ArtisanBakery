package pl.maciejburzynski.bakery.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.maciejburzynski.bakery.BakeryConfig;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/environment")
public class EnvironmentVariablesController {

    private final BakeryConfig config;

    private static final String ENVIRONMENT_NAME = "Environment name: ";

    @GetMapping
    private String envName(){
        return ENVIRONMENT_NAME + config.getEnvironmentName();
    }
}
