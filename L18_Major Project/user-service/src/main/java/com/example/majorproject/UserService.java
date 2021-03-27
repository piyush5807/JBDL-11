package com.example.majorproject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    ObjectMapper objectMapper;

    private static final String REDIS_KEY_PREFIX = "user::";
    private static final String CREATE_WALLET_TOPIC = "wallet_create";
    private static final int REDIS_EXPIRY = 12;


    public void createUser(UserRequest userRequest) throws JsonProcessingException {
        // create a user instance

        User user = User.builder()
                .age(userRequest.getAge())
                .name(userRequest.getName())
                .email(userRequest.getEmail())
                .userId(userRequest.getUserId())
                .build();
        userRepository.save(user);

        // TODO: Insert the data in redis as well with some expiry

        saveUserInCache(user);

        // TODO: Publish a kafka event for creating a user's wallet
        JSONObject walletRequest = new JSONObject();
        walletRequest.put("userId", userRequest.getUserId());

        kafkaTemplate.send(CREATE_WALLET_TOPIC,
                userRequest.getUserId(),
                objectMapper.writeValueAsString(walletRequest)
        );

    }

    private void saveUserInCache(User user){
        String redis_key = REDIS_KEY_PREFIX + user.getUserId();
        Map userMap = objectMapper.convertValue(user, Map.class);
        redisTemplate.opsForHash().putAll(redis_key, userMap);
        redisTemplate.expire(redis_key, Duration.ofHours(REDIS_EXPIRY));
    }

    public User getUserByUserId(String userId) throws Exception{
        try {
            // TODO: Query from redis, if not found then query db

            Map map = redisTemplate.opsForHash().entries(REDIS_KEY_PREFIX + userId);
            User user;

            if(map == null || map.size() == 0){
                user = userRepository.findByUserId(userId);
                if(user == null){
                    throw new UserNotFoundException();
                }
                saveUserInCache(user);
                return user;
            }else {
                user = objectMapper.convertValue(map, User.class);
                return user;
            }
        }catch (Exception e){
            throw new UserException();
        }
    }
}
