package com.example.springsecurity.demosecuritydb.Repository;

import com.example.springsecurity.demosecuritydb.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Integer> {

    public User findByUsername(String name);
}
