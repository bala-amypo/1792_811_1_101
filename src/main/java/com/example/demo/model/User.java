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