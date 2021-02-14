package com.example.springjpa.demojpa.Repository;

import com.example.springjpa.demojpa.Model.User;
import com.example.springjpa.demojpa.Model.UserPrimaryKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    // select * from user where name = "John" and age > 50 - 2 ways
    // update a record

//    @Query("select * from user where ")
//    public List<User> getUserCustom();
}
