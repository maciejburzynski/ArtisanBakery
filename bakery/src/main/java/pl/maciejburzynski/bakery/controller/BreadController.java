package pl.maciejburzynski.bakery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = ("/restapi/bread"))
public class BreadController {


    @GetMapping
    public String starter(){
        return "Pierwszy rest";
    }


}
