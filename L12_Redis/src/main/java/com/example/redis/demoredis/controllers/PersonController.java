package com.example.redis.demoredis.controllers;

import com.example.redis.demoredis.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@RestController
public class PersonController {

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    // -------------------------------X---------------------------------------------

    @GetMapping("/getValue")
    public String getValue(@RequestParam("key") String key){
        return (String)redisTemplate.opsForValue().get(key);
    }

    @PostMapping("/setValue")
    public void setValue(@RequestParam("key") String key,
                         @RequestParam("value") String value,
                         @RequestParam(value = "expiry", required = false) Long expiry) {

        if (expiry == null) {
            redisTemplate.opsForValue().set(key, value);
        } else {
            redisTemplate.opsForValue().set(key, value, Duration.ofSeconds(expiry));
        }
    }

    // ----------------------------x------------------------------------------------------

    // 1. retrieve from index l to r
    // 2. lpush
    // 3. rpush
    // 4. lpop
    // 5. rpop
    @GetMapping("/lrange")
    public List<User> getUsersByList(@RequestParam("key") String key,
                                     @RequestParam(value = "start", required = false, defaultValue = "0") long start,
                                     @RequestParam(value = "end", required = false, defaultValue = "-1") long end){

        return redisTemplate.opsForList().
                range(key, start, end).
                stream().
                map(x -> (User) x).
                collect(Collectors.toList());
    }

    @PostMapping("/lpush")
    public Long lpush(@RequestParam("key") String key, @RequestBody User user){
        return redisTemplate.opsForList().leftPush(key, user);
    }

    @PostMapping("/rpush")
    public Long rpush(@RequestParam("key") String key, @RequestBody User user){
        return redisTemplate.opsForList().rightPush(key, user);
    }

    @GetMapping("/lpop")
    public User lpop(@RequestParam("key") String key){

        return (User)redisTemplate.opsForList().leftPop(key);
    }

    @GetMapping("/rpop")
    public User rpop(@RequestParam("key") String key){
        return (User)redisTemplate.opsForList().rightPop(key);
    }


    // ----------------------X-------------------------------

    @GetMapping("/hgetall")
    public Map<Object, Object> hgetall(@RequestParam("key") String key) {

        Map<Object, Object> mapToReturn = new HashMap<>();

        List<Object> fields = Arrays.asList("id", "name", "country", "age");
        List<Object> values = redisTemplate.opsForHash().multiGet(key, fields);

        for(int i = 0; i < fields.size(); i++){
            mapToReturn.put(fields.get(i), values.get(i));
        }

        return mapToReturn;
    }

    @PostMapping("/hmset")
    public void hmset(@RequestParam("key") String key, @RequestBody User user){

        Map<String, Object> fieldMap = new HashMap<>();
        fieldMap.put("age", user.getAge());
        fieldMap.put("country", user.getCountry());
        fieldMap.put("name", user.getName());
        fieldMap.put("id", user.getId());
        redisTemplate.opsForHash().putAll(key, fieldMap);
    }

}
