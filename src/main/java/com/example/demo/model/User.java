package com.example.demo.model;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;

    // REQUIRED (fixes builder().name())
    private String name;

    private String email;
    private String password;

    // REQUIRED (fixes getRole())
    private String role;
}
