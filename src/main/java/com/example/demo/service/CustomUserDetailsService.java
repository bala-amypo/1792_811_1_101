package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {

    // create / register user
    User createUser(User user);

    // fetch user by id
    User getUserById(Long id);

    // fetch user by email
    User getUserByEmail(String email);
}
