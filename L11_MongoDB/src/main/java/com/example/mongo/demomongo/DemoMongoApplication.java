package com.example.mongo.demomongo;

import com.example.mongo.demomongo.models.User;
import com.example.mongo.demomongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoMongoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoMongoApplication.class, args);

	}

	@Autowired
	UserRepository userRepository;

	public void run(String ... args){
		userRepository.findByUserName("Arthur").forEach(System.out::println);
	}

}
