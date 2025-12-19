package com.example.inventory.service;

import org.springframework.stereotype.Service;

import com.example.inventory.entity.User;
import com.example.inventory.exception.InvalidRequestException;
import com.example.inventory.exception.ResourceNotFoundException;
import com.example.inventory.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

   
    public User register(User user) {

        
        if (user.getUsername() == null || user.getUsername().isEmpty()) {
            throw new InvalidRequestException("Username cannot be empty");
        }

        if (user.getPassword() == null || user.getPassword().isEmpty()) {
            throw new InvalidRequestException("Password cannot be empty");
        }

       
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new InvalidRequestException("Username already exists");
        }

        
        if (user.getRole() == null) {
            user.setRole("USER");
        }

        return userRepository.save(user);
    }

    
    public User getByUsername(String username) {

        return userRepository.findByUsername(username)
                .orElseThrow(() ->
                    new ResourceNotFoundException("User not found with username:" + username));
    }
}
