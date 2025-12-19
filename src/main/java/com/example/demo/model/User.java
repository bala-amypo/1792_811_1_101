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
        return id;
    }

    public void setId(Long id) {
       this.id = id;
    }

    public String getUsername() {
        return username;
    }

     public void setUsername(String username) {
        this.username = username;
    }

     public String getPassword() {
         return password;
    }

    public void setPassword(String password) {
         this.password;
    }

     public String getemail() {
         return email;
    }

     public void setemail( String email) {
          this.email;
    }

}



    