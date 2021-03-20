package com.example.majorproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/user")
    public UserResponse getUserByUserId(@RequestParam("userId") String userId) throws Exception{
        return userService.getUserByUserId(userId);
    }

    @PostMapping("/user")
    public void createUser(@RequestBody UserRequest userRequest){
        userService.createUser(userRequest);
    }

}
