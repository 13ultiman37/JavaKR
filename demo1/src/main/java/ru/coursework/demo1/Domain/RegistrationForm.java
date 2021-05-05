package ru.coursework.demo1.Domain;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collections;

@Data
public class RegistrationForm {

    private String username;
    private String password;
    private String name;
    private String email;
    private String phone;

    public User toUser(PasswordEncoder passwordEncoder) {
        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setName(name);
        user.setPhone(phone);
        user.setRoles(Collections.singleton(Role.USER));

        return user;
    }
}
