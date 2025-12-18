package com.example.demo.model;




@Entity
public class user {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private String password;
    private String email;
}