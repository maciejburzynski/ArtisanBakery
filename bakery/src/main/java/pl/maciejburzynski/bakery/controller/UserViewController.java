package pl.maciejburzynski.bakery.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.maciejburzynski.bakery.entity.User;
import pl.maciejburzynski.bakery.rest.weather.WeatherService;
import pl.maciejburzynski.bakery.service.TokenService;
import pl.maciejburzynski.bakery.service.UserService;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class UserViewController {

    private final UserService userService;
    private final TokenService tokenService;
    private final WeatherService weatherService;
    private User userToBeRegisteredHolder;

    @GetMapping("/")
    public String getStartPage(Model model, HttpServletRequest request) throws IOException, InterruptedException {
        model.addAttribute("weatherService", weatherService);
        model.addAttribute("loggedUser", getUsernameOfCurrentlyLoggedUser());
        if ("ADMIN".equals(getRoleOfCurrentlyLoggedUser())) {
            return "orders";
        }
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

    @PostMapping("/signup")
    public String registration(User userToBeRegistered) throws MessagingException {
        userToBeRegisteredHolder = userToBeRegistered;
        userService.sendTokenToUser(userToBeRegisteredHolder);
        userService.addInactiveUserToDatabase(userToBeRegisteredHolder);
        return "redirect:/token";
    }

    @GetMapping("/token")
    public String tokenGet() {
        return "token";
    }

    @PostMapping("/token")
    public String tokenPost(String typedTokenValue) throws MessagingException {
        if (isUserTokenEqual(typedTokenValue)) {
            userService.activateUser(userToBeRegisteredHolder);
            return "redirect:/login";
        } else {
            return "redirect:/signup";
        }
    }

    private boolean isUserTokenEqual(String typedTokenValue) {
        return typedTokenValue.equalsIgnoreCase(tokenService.findByUser(userToBeRegisteredHolder).getValue());
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
