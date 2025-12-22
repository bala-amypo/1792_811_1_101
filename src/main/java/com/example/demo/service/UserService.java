package com.example.demo.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.User;
import com.example.demo.exception.InvalidRequestException;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User register(User user) {
        validateUser(user);

        if (user.getRole() == null) {
            user.setRole("USER");
        }

        return userRepository.save(user);
    }

    @Override
    public User getByUsername(String username) {
        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with username: " + username));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User updateUser(String username, User updatedUser) {
        User existing = getByUsername(username);

        if (updatedUser.getPassword() != null && !updatedUser.getPassword().isEmpty()) {
            existing.setPassword(updatedUser.getPassword());
        }

        if (updatedUser.getRole() != null) {
            existing.setRole(updatedUser.getRole());
        }

        return userRepository.save(existing);
    }

    @Override
    public void deleteUser(String username) {
        User existing = getByUsername(username);
        userRepository.delete(existing);
    }

    private void validateUser(User user) {
        if (user == null) {
            throw new InvalidRequestException("User cannot be null");
        }

        if (user.getUsername() == null || user.getUsername().trim().isEmpty()) {
            throw new InvalidRequestException("Username cannot be empty");
        }

        if (user.getPassword() == null || user.getPassword().trim().isEmpty()) {
            throw new InvalidRequestException("Password cannot be empty");
        }

        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new InvalidRequestException("Username already exists");
        }
    }
}
