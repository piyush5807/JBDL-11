package com.example.mongo.demomongo.repositories;

import com.example.mongo.demomongo.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.stream.Stream;

public interface UserRepository extends MongoRepository<User, String> {

    public List<User> findByName(String name);

    // find all the people which have age greater than some given age

    // jpql, native sql

    @Query("{age : {$gte: ?0 }}")
    public List<User> findUserByAge(int age);

    @Query("{'name' : ?0 }")
    public Stream<User> findByUserName(String name);

}
