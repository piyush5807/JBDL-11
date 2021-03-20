package com.example.majorproject;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true)
    private String userId;
    private String email;
    private String name;
    private int age;


    public UserResponse toResponse(){
        return UserResponse.builder().user(this).build();
    }

}
