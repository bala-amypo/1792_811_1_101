package com.example.demo.config;

import org.springframework.stereotype.Component;

@Component
public class JwtProvider {
    
    // Simple implementation for now
    public String generateToken(String username) {
        return "dummy-jwt-token-for-" + username;
    }
    
    public String getUsernameFromJWT(String token) {
        if (token.startsWith("dummy-jwt-token-for-")) {
            return token.substring(20);
        }
        return null;
    }
    
    public boolean validateToken(String token) {
        return token != null && token.startsWith("dummy-jwt-token-for-");
    }
}