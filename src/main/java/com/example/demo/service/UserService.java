package com.example.smartinventoryrestockpredictor.service;

import com.example.smartinventoryrestockpredictor.dto.AuthRequest;
import com.example.smartinventoryrestockpredictor.dto.UserRegisterDto;
import com.example.smartinventoryrestockpredictor.entity.User;

public interface UserService {

    User register(UserRegisterDto dto);

    String authenticate(AuthRequest request);

    User getByUsername(String username);
}
