package ru.coursework.demo1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.AbstractDataFieldMaxValueIncrementer;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ru.coursework.demo1.Domain.Order;
import ru.coursework.demo1.Domain.OrderForm;
import ru.coursework.demo1.Domain.User;
import ru.coursework.demo1.Repository.OrderRepo;
import ru.coursework.demo1.Repository.UserRepo;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    OrderRepo orderRepo;

    @Autowired
    UserRepo userRepo;

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
        model.put("users", userRepo.findAll());
        model.put("orders", orderRepo.findAll());
        return "foradmin";
    }


    @GetMapping("/completed")
    public String completed(@RequestParam Long id){
        Order order = orderRepo.findOrdersById(id);
        order.setCompleted(true);
        orderRepo.save(order);
        return "redirect:/foradmin";
    }

    @PreAuthorize(value = "hasAnyAuthority('ADMIN')")
    @GetMapping("/userpage")
    public String userpage(@RequestParam Long id, User user, Model model){
        model.addAttribute("name", userRepo.findById(id).get().getName());
        model.addAttribute("username", userRepo.findById(id).get().getUsername());
        model.addAttribute("phone", userRepo.findById(id).get().getPhone());
        model.addAttribute("email", userRepo.findById(id).get().getEmail());
        Iterable<Order> orders = orderRepo.findAllByUserid(id);
        model.addAttribute("orders", orders);
        return "userpage";
    }

}