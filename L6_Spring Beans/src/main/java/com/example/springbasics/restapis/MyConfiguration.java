package com.example.springbasics.restapis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class MyConfiguration { // myConfiguration
    private static Logger logger = LoggerFactory.getLogger(MyConfiguration.class);

//    @Autowired
//    User user;

    @Bean
//    @Scope("singleton")
    public User getMyUser(){
        logger.info("some test log");

//        return user;
        User local_user = new User(1, 4, "Piyush", "India");
        logger.info("local user {}", local_user);

        return local_user;
    }
}
