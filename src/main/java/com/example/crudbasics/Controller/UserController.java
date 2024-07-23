package com.example.crudbasics.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/protected")
    public String protectedEndpoint() {
        return "This is a protected endpoint!";
    }

    @GetMapping("/admin")
    public String adminEndpoint() {
        return "This is a protected admin endpoint!";
    }

    @GetMapping("/user")
    public String userEndpoint() {
        return "This is a protected user endpoint!";
    }
}
