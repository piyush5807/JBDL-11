package com.example.springsecurity.demosecuritydb;

import com.example.springsecurity.demosecuritydb.Models.User;
import com.example.springsecurity.demosecuritydb.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class DemoSecurityDbApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityDbApplication.class, args);
	}

	@Autowired
	UserRepository repository;

	@Override
	public void run(String... args) throws Exception {

		BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

		String encodedPwdForJohn = bCryptPasswordEncoder.encode("john123");
		String encodedPwdForJim = bCryptPasswordEncoder.encode("jim123");

		User user = User.builder().username("John").
				authorities("FACULTY:STUDENT").
				password(encodedPwdForJohn)
				.build();

		User user2 = User.builder().username("Jim")
				.authorities("STUDENT")
				.password(encodedPwdForJim)
				.build();

		repository.saveAll(Arrays.asList(user, user2));

	}
}
