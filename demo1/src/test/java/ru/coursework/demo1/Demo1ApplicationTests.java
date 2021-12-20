package ru.coursework.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.coursework.demo1.Controller.HomeController;
import ru.coursework.demo1.Controller.RegistrationController;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class Demo1ApplicationTests {

    @Autowired
    private HomeController homeController;

    @Autowired
    private RegistrationController registrationController;

    @Test
    void contextLoads() throws Exception{
        assertThat(homeController).isNotNull();
        assertThat(registrationController).isNotNull();
    }

}