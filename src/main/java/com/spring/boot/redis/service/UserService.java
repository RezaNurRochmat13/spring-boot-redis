package com.spring.boot.redis.service;

import com.spring.boot.redis.entity.User;

public interface UserService {
    User saveUserHash(User payload);
}
