package com.spring.boot.redis.controller;

import com.spring.boot.redis.entity.User;
import com.spring.boot.redis.service.inmemory.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/users")
    public ResponseEntity<Object> createUserInMemory(@RequestBody User payload) {
        User user = userService.saveUserHash(payload);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @GetMapping("users")
    public ResponseEntity<Object> allUsersInMemory() {
        return new ResponseEntity<>(userService.listUserHash(), HttpStatus.OK);
    }

    @GetMapping("users/{id}")
    public ResponseEntity<Object> detailUserHash(@PathVariable Long id) {
        return new ResponseEntity<>(userService.detailUserHash(id), HttpStatus.OK);
    }

    @PutMapping("users/{id}")
    public ResponseEntity<Object> updateUserHash(@PathVariable Long id,
                                                 @RequestBody User payload) {
        return new ResponseEntity<>(userService.updateUserHash(id, payload), HttpStatus.OK);
    }

    @DeleteMapping("users/{id}")
    public ResponseEntity<Object> deleteUserHash(@PathVariable Long id) {
        userService.deleteUserHash(id);
        return new ResponseEntity<>("", HttpStatus.NO_CONTENT);
    }

}
