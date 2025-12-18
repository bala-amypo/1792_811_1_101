package com.example.demo.repository;

import.com.example.demo.model




@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    UserfindByUsername( String username);
}