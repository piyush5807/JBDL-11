package com.example.springjpa.demojpa.Controller;

import com.example.springjpa.demojpa.Model.Bank;
import com.example.springjpa.demojpa.Model.User;
import com.example.springjpa.demojpa.Repository.BankRepository;
import com.example.springjpa.demojpa.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    BankRepository bankRepository;

    @GetMapping("/users")
    public List<User> getUsers(){
        return userService.getUsers();
    }

    @GetMapping("/user")
    public User getUserById(@RequestParam("id") int id) throws Exception{

        return userService.getUser(id);
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user){ // Jackson mapper
        userService.insertUser(user);
    }

    @PostMapping("/bank")
    public void createBank(@RequestBody Bank bank){
        bankRepository.save(bank);
    }
}
