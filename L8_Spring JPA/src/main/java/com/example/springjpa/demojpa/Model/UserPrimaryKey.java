package com.example.springjpa.demojpa.Model;

import javax.persistence.IdClass;

@IdClass(User.class)
public class UserPrimaryKey {

    private int id;
    private String name;


}
