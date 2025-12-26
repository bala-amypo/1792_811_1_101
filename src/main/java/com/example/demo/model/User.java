package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.Set;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String name;
    private String email;
    private String password;
    private Set<Role> roles;
    private LocalDateTime createdAt;
}
