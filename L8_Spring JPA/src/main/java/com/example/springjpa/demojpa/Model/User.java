package com.example.springjpa.demojpa.Model;

import javax.persistence.*;

@Entity
@Table(name = "myUser") // -> my_user
public class User { // lower case user

    // data that it gets in form of result set -> java class

    // User user = new User()

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name; // firstName -> first_name

    private String lastName;

    @Column(name = "nation")
    private String country;

    private int AGE;

    // 40-50


    public User() {
    }

    public User(int age, String name, String lastName, String country, int id) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.AGE = age;
        this.lastName = lastName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAGE() {
        return AGE;
    }

    public void setAGE(int AGE) {
        this.AGE = AGE;
    }
}
