package com.example.springbasics.restapis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanController {

    private static Logger logger = LoggerFactory.getLogger(BeanController.class);

    @Autowired
    MyConfiguration config;

    @Autowired
    ApplicationContext context;

    // com.example.springbasics.restapis.User@1ed92a1
    // com.example.springbasics.restapis.User@1ed92a1


    // Config global user : com.example.springbasics.restapis.User@22680f52, local user com.example.springbasics.restapis.User@60d84f61
    // API local user is com.example.springbasics.restapis.User@60d84f61, global user is com.example.springbasics.restapis.User@22680f52

    // local user is com.example.springbasics.restapis.User@77b21474, global user is com.example.springbasics.restapis.User@28c090dc

    @Autowired
    User user;

    @Autowired
    User getMyUser;

    @GetMapping("/bean/test")
    public User getUser(){

        User user  = (User)context.getBean("getMyUser");

        return null;

////        User user = config.getMyUser();
//        logger.info("local user is {}, global user is {}", user1, this.user1);
//        return user1;
    }
}
