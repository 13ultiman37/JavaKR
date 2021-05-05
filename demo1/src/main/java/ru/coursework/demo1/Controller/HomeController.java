package ru.coursework.demo1.Controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.coursework.demo1.Domain.User;

@Controller
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String index(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {
            model.addAttribute("user", user.getUsername());
            return "index";
        }
        model.addAttribute("user", "anonymous");
        return "index";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PreAuthorize(value = "hasAnyAuthority('ADMIN', 'USER')")
    @GetMapping("/foruser")
    public String forUser() {
        return "foruser";
    }

    @PreAuthorize(value = "hasAnyAuthority('ADMIN')")
    @GetMapping("/foradmin")
    public String forAdmin() {
        return "foradmin";
    }
}