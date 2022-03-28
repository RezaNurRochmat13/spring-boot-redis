package com.spring.boot.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class InvalidateRedisCache {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @DeleteMapping("/invalidate/users")
    public ResponseEntity<Object> deleteCacheUsers() {
        redisTemplate.delete("User");

        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }
}
