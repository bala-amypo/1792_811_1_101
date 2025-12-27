package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    // REQUIRED for login
    Optional<User> findByEmail(String email);

    // REQUIRED for registration (fixes your error)
    boolean existsByEmail(String email);
}
