package com.example.demo.repository;

import com.example.demo.model.user;
import org.Springframework.data.jpa.repository.JpaRepository;
import org.Springframework.data.Stereotype.JpaRepository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    UserfindByUsername( String username);
}