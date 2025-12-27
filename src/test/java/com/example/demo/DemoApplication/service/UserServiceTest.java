package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.dto.UserRegisterDto;
import com.example.demo.model.User;

@SpringBootTest
class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    void testRegisterUser() {

        UserRegisterDto dto = new UserRegisterDto();
        dto.setName("Test User");
        dto.setEmail("testuser@example.com");
        dto.setPassword("password123");

        User user = userService.register(dto);

        assertNotNull(user);
        assertNotNull(user.getEmail());
    }
}
