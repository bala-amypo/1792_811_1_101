package com.example.demo.service;

import com.example.demo.dto.AuthRequest;
import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.UserRegisterDto;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(UserRegisterDto dto) {
        if (userRepository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("User with email " + dto.getEmail() + " already exists");
        }

        User user = User.builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(passwordEncoder.encode(dto.getPassword()))
                .role(dto.getRole() != null ? dto.getRole() : "USER")
                .build();

        return userRepository.save(user);
    }

    public AuthResponse login(AuthRequest request) {
        // OPTION 1: Use constructor directly
        AuthResponse response = new AuthResponse();
        response.setToken("dummy-token");
        response.setEmail(request.getEmail());
        response.setName("User");
        response.setRole("USER");
        return response;
        
        // OPTION 2: Use manual builder (uncomment if you created manual builder)
        // return AuthResponse.builder()
        //         .token("dummy-token")
        //         .email(request.getEmail())
        //         .name("User")
        //         .role("USER")
        //         .build();
    }
    
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }
}