package com.example.demo.service;

import com.example.demo.model.user;
import com.example.demo.repository.UserRepository;
import org.Springframework.beans.fact.ory.annotation

@Service
public class UserService {

    @Autowired
    private UserRepository
    userRepository;

    public User findByUsername(String username ) {
        return userRepository.findByUsername(username);
    }

    public User save(User user) {
        return useRepository.save(user);
    }
}