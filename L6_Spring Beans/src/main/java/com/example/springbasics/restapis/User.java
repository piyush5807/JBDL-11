package com.example.springbasics.restapis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

//@Component
//@Scope("prototype") // spring will not create it explicitly on application startup
public class User {

    private int id;
    private int age;
    private String name;
    private String country;

    public User(){
        this(10, 10, "Piyush", "India");
        System.out.println("Creating user object");
    }


    public User(int id, int age, String name, String country) {
        this.age = age;
        this.name = name;
        this.country = country;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
