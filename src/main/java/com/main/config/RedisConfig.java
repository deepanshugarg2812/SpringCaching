package com.main.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.stereotype.Component;


@Configuration
public class RedisConfig {
    @Bean
    public RedisConnectionFactory lettuceConnectionFactoryTest(){
        LettuceConnectionFactory redisConnectionFactory =
                new LettuceConnectionFactory(new RedisStandaloneConfiguration("127.0.0.1", 6379));
        redisConnectionFactory.afterPropertiesSet();
        return redisConnectionFactory;
    }
}
