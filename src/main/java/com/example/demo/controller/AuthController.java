package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    // REGISTER (CREATE)
    @PostMapping("/register")
    public String register(@RequestBody String userData) {
        return "User registered successfully";
    }

    // LOGIN (READ / VERIFY)
    @PostMapping("/login")
    public String login(@RequestBody String loginData) {
        return "Login successful";
    }

}
