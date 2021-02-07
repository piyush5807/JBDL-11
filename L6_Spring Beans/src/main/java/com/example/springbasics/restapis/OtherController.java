//package com.example.springbasics.restapis;
//
//import com.example.springbasics.restapis.controller.MyController;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Scope;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.Arrays;
//import java.util.List;
//import java.util.stream.Collectors;
//
//@RestController
//public class OtherController {
//
//    private static Logger logger = LoggerFactory.getLogger(OtherController.class);
//
////    @Autowired
////    Logger logger;
//
//    // com.example.springbasics.restapis.User@422b93b3 - other controller
//    // com.example.springbasics.restapis.User@422b93b3
//    // com.example.springbasics.restapis.User@2f8a4e58 - mycontroller
//
////    com.example.springbasics.restapis.User@680c795f
////    com.example.springbasics.restapis.User@7971f151
//
//    @Autowired
//    ApplicationContext context;
//
//    public OtherController() {
//        System.out.println("In othercontroller constructor " + this);
//    }
//
//    @Autowired
//    User user;
//
//    @GetMapping("/other/user")
//    public User getUser(){
//        System.out.println(user);
//        return user;
//    }
//
//    @GetMapping("/get_beans")
//    public void getBeans(){
//        OtherController controller = (OtherController) context.getBean("otherController");
//
//        System.out.println(context);
//
//        System.out.println(controller);
////        return Arrays.stream(context.getBeanDefinitionNames()).collect(Collectors.toList());
//    }
//
//    @GetMapping("/other/logs")
//    public void printSomeLogs(){
//
//        logger.debug("Hi debug");
//        logger.warn("Hi warn");
//        logger.trace("Hi trace");
//        logger.error("Hi error");
//        logger.info("Hi info");
//    }
//
//}
