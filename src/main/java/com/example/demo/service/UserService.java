package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.UserRegisterDto;
import com.example.demo.entity.User;

public interface UserService {

    User register(UserRegisterDto dto);

    String authenticate(AuthRequest request);

    User getByUsername(String username);
}
