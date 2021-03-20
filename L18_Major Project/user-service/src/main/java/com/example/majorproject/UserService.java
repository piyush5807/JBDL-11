package com.example.majorproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public void createUser(UserRequest userRequest){
        // create a user instance

        User user = User.builder()
                .age(userRequest.getAge())
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .userId(userRequest.getUserId())
                .build();
        userRepository.save(user);

        // TODO: Insert the data in redis as well with some expiry
        // TODO: Publish a kafka event for creating a user's wallet
    }

    public UserResponse getUserByUserId(String userId){
        try {
            // TODO: Query from redis, if not found then query db
            UserResponse userResponse = userRepository.findByUserId(userId).toResponse();
            if(userResponse.getUser() == null){
                return UserResponse.builder().user(null).status(404).build();
            }
            userResponse.setStatus(200);
            return userResponse;
        }catch (Exception e){
            return UserResponse.builder().user(null).status(500).build();
        }
    }
}
