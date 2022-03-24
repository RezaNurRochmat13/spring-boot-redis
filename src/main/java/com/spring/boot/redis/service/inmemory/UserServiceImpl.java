package com.spring.boot.redis.service.inmemory;

import com.spring.boot.redis.entity.User;
import com.spring.boot.redis.repository.inmemory.UserRepository;
import com.spring.boot.redis.util.PasswordEncoderUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoderUtil passwordEncoderUtil;

    @Override
    public User saveUserHash(User payload) {
        payload.setPassword(passwordEncoderUtil
                .passwordEncoder()
                .encode(payload.getPassword()));

        return userRepository.save(payload);
    }
}
