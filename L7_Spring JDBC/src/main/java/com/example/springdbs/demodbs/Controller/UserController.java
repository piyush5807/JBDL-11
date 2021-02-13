package com.example.springdbs.demodbs.Controller;

import com.example.springdbs.demodbs.Model.User;
import com.example.springdbs.demodbs.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() throws SQLException {
        return userService.getUsers();
    }

    @GetMapping("/user")
    public User getUserById(@RequestParam("id") int id) throws Exception{

        return userService.getUser(id);
    }

    @PostMapping("/user")
    public void createUser(@RequestBody User user) throws SQLException { // Jackson mapper
        userService.insertUser(user);
    }
}
