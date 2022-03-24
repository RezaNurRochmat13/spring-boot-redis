package com.spring.boot.redis.controller;

import com.spring.boot.redis.entity.User;
import com.spring.boot.redis.service.inmemory.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/users")
    public ResponseEntity<Object> createUserInMemory(@RequestBody User payload) {
        User user = userService.saveUserHash(payload);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
