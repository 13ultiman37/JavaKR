package ru.coursework.demo1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.AbstractDataFieldMaxValueIncrementer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.coursework.demo1.Domain.Order;
import ru.coursework.demo1.Domain.OrderForm;
import ru.coursework.demo1.Domain.User;
import ru.coursework.demo1.Repository.OrderRepo;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    OrderRepo orderRepo;

    @GetMapping
    public String index(@AuthenticationPrincipal User user, Model model) {
        if (user != null) {
            model.addAttribute("user", user.getUsername());
            model.addAttribute("role", user.getRoles());
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
    public String forUser(@AuthenticationPrincipal User user, Model model) {
        model.addAttribute("name", user.getName());
        Iterable<Order> orders = orderRepo.findAllByUserid(user.getId());
        model.addAttribute("orders", orders);
        return "foruser";
    }

    @GetMapping("/order")
    public String Addingorder(){

        return "order";
    }


    @PostMapping("/order")
    public String processOrder(@AuthenticationPrincipal User user, OrderForm form){

        orderRepo.save(form.toOrder(user));

        return "redirect:/foruser";
    }


    @PreAuthorize(value = "hasAnyAuthority('ADMIN')")
    @GetMapping("/foradmin")
    public String forAdmin(Map<String, Object> model) {
        model.put("orders", orderRepo.findAll());
        return "foradmin";
    }


}