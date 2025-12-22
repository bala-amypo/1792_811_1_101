package com.example.demo.service;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

import org.springframework.stereotype.Service;

import com.example.demo.entity.User;

@Service
public class UserService {

    // In-memory storage
    private Map<Long, User> users = new HashMap<>();

    // CREATE
    public User addUser(User user) {
        users.put(user.getId(), user);
        return user;
    }

    // READ ALL
    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    // READ BY ID
    public User getUserById(Long id) {
        return users.get(id);
    }

    // UPDATE
    public User updateUser(Long id, User user) {
        users.put(id, user);
        return user;
    }

    // DELETE
    public User deleteUser(Long id) {
        return users.remove(id);
    }
}
