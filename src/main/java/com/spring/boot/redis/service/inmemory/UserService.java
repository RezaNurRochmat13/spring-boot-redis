package com.spring.boot.redis.service.inmemory;

import com.spring.boot.redis.entity.User;

import java.util.List;

public interface UserService {
    Iterable<User> listUserHash();
    User detailUserHash(Long id);
    User saveUserHash(User payload);
    User updateUserHash(Long id, User payload);
    void deleteUserHash(Long id);
}
