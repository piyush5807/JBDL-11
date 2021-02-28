package com.example.redis.demoredis;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

@Configuration
public class RedisConfig {

    // ConnectionFactory -> LettuceConnection/ JedisConnection
    // Redis Template

    // localhost, 6379

    @Bean
    LettuceConnectionFactory getFactory(){


        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration
                ("redis-15420.c245.us-east-1-3.ec2.cloud.redislabs.com", 15420);

        redisStandaloneConfiguration.setPassword("OiqNvnffAhnfP6s6jLCrS4nRK5p2DksN");

        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(redisStandaloneConfiguration);

        return connectionFactory;
    }

    @Bean
    RedisTemplate<String, Object> getTemplate(){
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        redisTemplate.afterPropertiesSet();
        RedisSerializer<String> stringRedisSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringRedisSerializer);

        JdkSerializationRedisSerializer jdkSerializationRedisSerializer = new JdkSerializationRedisSerializer();
        redisTemplate.setValueSerializer(jdkSerializationRedisSerializer);
        redisTemplate.setHashValueSerializer(jdkSerializationRedisSerializer);
        redisTemplate.setConnectionFactory(getFactory());

        return redisTemplate;
    }
}
