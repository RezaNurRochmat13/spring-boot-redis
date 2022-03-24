package com.spring.boot.redis.service;

import com.spring.boot.redis.entity.User;
import com.spring.boot.redis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUserHash(User payload) {
        return userRepository.save(payload);
    }
}
