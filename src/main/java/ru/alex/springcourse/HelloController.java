package ru.alex.springcourse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

    @GetMapping("/hello_world")
    public String sayHello() {
        return "hello_world";

    }
}
//http://localhost:8080/hello_world