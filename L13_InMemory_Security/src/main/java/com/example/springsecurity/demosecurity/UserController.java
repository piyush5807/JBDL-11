package com.example.springsecurity.demosecurity;


import org.springframework.context.ApplicationContext;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 9fce3273-d307-4544-adfd-8acf24da3fc8
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


}
