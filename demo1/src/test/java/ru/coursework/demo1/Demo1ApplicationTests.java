package ru.coursework.demo1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.coursework.demo1.Controller.HomeController;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
class Demo1ApplicationTests {

    @Autowired
    private HomeController controller;

    @Test
    void contextLoads() throws Exception{
        assertThat(controller).isNotNull();
    }

}