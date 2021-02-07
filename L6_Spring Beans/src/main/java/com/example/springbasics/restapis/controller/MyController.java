package com.example.springbasics.restapis.controller;

import com.example.springbasics.restapis.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerError;
import java.util.*;
import java.util.stream.Collectors;

@RestController // creating object + acting as collection of APIs
public class MyController {

    private static Logger logger = LoggerFactory.getLogger(MyController.class);

    // com.example.springbasics.restapis.User@29f917b1
    // com.example.springbasics.restapis.User@29f917b1

    // IOC container - application context
    // critical section - synchronized

    @Autowired
    User user;

    @Autowired
    User user1;

    @GetMapping("/user")
    public User getUser(){

        User user = new User();
        System.out.println("user = " + this.user + ", second user = " + user1 + ", local user = " + user);

        user.setAge(10);
        return user;
    }



    // GET  - get some information from server
    // POST - insert / post something on server
    // PUT - modifying something on the server
    // DELETE - deleting something from server
    // PATCH
    // HEAD

    // Spring as a framework :
    // 1. Inversion of control
    // 2. Dependency injection

//    private HashMap<Integer, User> users = new HashMap<>();
//
////    @GetMapping("/get_users")
////    public Map<Integer, User> getUsers(){
////        return users;
////    }
////
////    @GetMapping("/get_user")
////    public User getUser(@RequestParam("my_id") int id){
////        return users.get(id);
////    }
//
//    @GetMapping("/get_user")
//    public List<User> getUsers(@RequestParam(value = "my_id", required = false) Integer id){
//
//        if(id == null){
//            if(users.values().size() > 0) {
//                return users.values().stream().collect(Collectors.toList());
//            }
//
//            return new ArrayList<>();
//        }
//
//        return Collections.singletonList(users.get(id));
//
//    }
//
//    @PostMapping("/insert_user")
//    public void insertUser(@RequestParam(value = "id") int id,
//                           @RequestParam(value = "age", required = false, defaultValue = "20") int age,
//                           @RequestParam(value = "name", required = false, defaultValue = "ABC") String name,
//                           @RequestParam(value = "country", required = false, defaultValue = "India") String country){
//
//        User user = new User(id, age, name, country);
//
//        users.put(id, user);
//
//    }
//
//    @RequestMapping(value = "/modify_user", method = RequestMethod.PUT)
//    public void modifyUser(@RequestBody User user) throws Exception {
//
//        if(user == null){
//            throw new Exception("User object is empty");
//        }
//        users.put(user.getId(), user);
//    }
//
//    // curl -XDELETE "127.0.0.1:7000/delete_user/4"
//
//    @DeleteMapping("/delete_user/{id}")
//    public void deleteUser(@PathVariable("id") int id){
//
//        users.remove(id);
//    }
//
//    // curl -XDELETE "127.0.0.1:7000/delete_user?id=2"
//
//    @DeleteMapping("/delete_user")
//    public void deleteUser2(@RequestParam("id") int id){
//
//        users.remove(id);
//    }
//
//
//    @GetMapping("/save_user")
//    public void saveUser(@RequestBody User user){
//
//        users.putIfAbsent(user.getId(), user);
//    }
//

    @GetMapping("/logs")
    public void printSomeLogs(){

        logger.debug("Hi debug");
        logger.warn("Hi warn");
        logger.trace("Hi trace");
        logger.error("Hi error");
        logger.info("Hi info");
    }


}
