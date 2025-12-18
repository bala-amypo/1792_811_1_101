package com.example.demo.model;

import jakarta.presistence.Entity;
import jakarta.presistence.GeneratedValue;
import jakarta.presistence.GeneratedType;
import jakarta.presistence.Id;



@Entity
public class  user {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String password;
    private String email;
}

public User(String username, String password, String email) {
    this.username = username;
    this.password = password;
    this.email = email;
}

public Long getId() {
    return id
}