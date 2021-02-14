package com.example.springjpa.demojpa.Service;

import com.example.springjpa.demojpa.Model.User;
import com.example.springjpa.demojpa.Model.UserPrimaryKey;
import com.example.springjpa.demojpa.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.findAll(); // []
    }

    public User getUser(int id){
        return userRepository.findById(id).get();

    }

    public void insertUser(User user){
        userRepository.save(user);
    }
}
