package com.example.mongo.demomongo.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address {

    private String street;
    private int house;
    private String city;
    private int zipCode;


}
