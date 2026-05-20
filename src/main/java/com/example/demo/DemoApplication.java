package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @GetMapping("/")
    public String home() {
<<<<<<< HEAD
        return "Hello from Arun 🚀";
=======
        return "Hello from Earth. Its a beautiful day 🚀";
>>>>>>> 604c4bf0f4fe9fd476894898db71e1316a519d5e
    }
}