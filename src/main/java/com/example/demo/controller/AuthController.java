package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.UserRegisterDto;
import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody UserRegisterDto dto) {

        User user = userService.register(dto);

        AuthResponse response = new AuthResponse(
                user.getEmail(),
                user.getRole()
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {

        User user = userService.login(request);

        AuthResponse response = new AuthResponse(
                user.getEmail(),
                user.getRole()
        );

        return ResponseEntity.ok(response);
    }
}
