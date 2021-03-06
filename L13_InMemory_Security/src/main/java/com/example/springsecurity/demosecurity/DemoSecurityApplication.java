package com.example.springsecurity.demosecurity;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class DemoSecurityApplication{

	public static void main(String[] args) {
		SpringApplication.run(DemoSecurityApplication.class, args);
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//
//		System.out.println(encoder.encode("piyush123"));
//		System.out.println(encoder.encode("karan123"));
	}

}
