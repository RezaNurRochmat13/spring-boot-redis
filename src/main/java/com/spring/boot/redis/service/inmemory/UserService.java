package com.spring.boot.redis.service.inmemory;

import com.spring.boot.redis.entity.User;

public interface UserService {
    User saveUserHash(User payload);
}
