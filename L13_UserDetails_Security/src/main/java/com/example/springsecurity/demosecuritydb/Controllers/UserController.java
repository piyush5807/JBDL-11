package com.example.springsecurity.demosecuritydb.Controllers;

import com.example.springsecurity.demosecuritydb.Models.User;
import com.example.springsecurity.demosecuritydb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/student/greet")
    public String greetStudent(@RequestParam("name") String name){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Hi Student: " + name;
    }

    @PostMapping("/student/greet2")
    public String greet2Student(@RequestParam("name") String name){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Hi Student: " + name;
    }


    @GetMapping("/faculty")
    public String greetFaculty(@RequestParam("name") String name){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Hi Faculty: " + name;
    }

    @GetMapping("/")
    public String greetPublic(@RequestParam("name") String name){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return "Hi Public User: " + name;
    }

    @Autowired
    UserRepository userRepository;

    @GetMapping("/signup")
    public void signup(@RequestBody User user){

        // Change the password to the encrypted one
        userRepository.save(user);

        // 500 unique constraint failed
        // return an error msg to client to change the username to something else
    }

}
