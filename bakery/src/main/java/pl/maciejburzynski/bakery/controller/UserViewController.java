package pl.maciejburzynski.bakery.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.maciejburzynski.bakery.entity.User;
import pl.maciejburzynski.bakery.rest.weather.WeatherService;
import pl.maciejburzynski.bakery.security.UserRole;
import pl.maciejburzynski.bakery.service.UserService;

import javax.mail.MessagingException;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class UserViewController {

    private final UserService userService;
    private final WeatherService weatherService;

    @GetMapping("/")
    public String getStartPage(Model model) throws IOException, InterruptedException {
        model.addAttribute("weatherService", weatherService);
        model.addAttribute("loggedUser", getUsernameOfCurrentlyLoggedUser());
//        if ("ADMIN".equals(getRoleOfCurrentlyLoggedUser())) {
//            return "orders";
//        }
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/signup")
    public String registrationEmpty(Model model) {
        model.addAttribute("user", new User());
        return "signup";
    }

    @PostMapping("/register")
    public String registration(User user) throws MessagingException {
        userService.addUser(user);
        return "signup";
    }

    private String getUsernameOfCurrentlyLoggedUser() {
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getName();
    }

    private String getRoleOfCurrentlyLoggedUser() {
        return SecurityContextHolder
                .getContext()
                .getAuthentication()
                .getAuthorities()
                .stream()
                .map(a -> a.getAuthority())
                .findFirst()
                .get();
    }
}
