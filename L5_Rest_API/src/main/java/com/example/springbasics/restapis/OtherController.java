package com.example.springbasics.restapis;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherController {

    @GetMapping("/test")
    public String getTestString(){
        return "Hello World";
    }
}
