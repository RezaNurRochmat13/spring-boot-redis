package com.spring.boot.redis.service.inmemory;

import com.spring.boot.redis.entity.User;
import com.spring.boot.redis.repository.inmemory.UserRepository;
import com.spring.boot.redis.util.PasswordEncoderUtil;
import com.spring.boot.redis.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoderUtil passwordEncoderUtil;

    @Override
    public Iterable<User> listUserHash() {
        return userRepository.findAll();
    }

    @Override
    public User detailUserHash(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Data not found in redis : " + id));
    }

    @Override
    public User saveUserHash(User payload) {
        payload.setPassword(passwordEncoderUtil
                .passwordEncoder()
                .encode(payload.getPassword()));

        return userRepository.save(payload);
    }

    @Override
    public User updateUserHash(Long id, User payload) {
        User userById = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Data not found in redis : " + id));

        userById.setName(payload.getName());
        userById.setPassword(passwordEncoderUtil
                .passwordEncoder()
                .encode(payload.getPassword()));

        userRepository.save(userById);

        return userById;
    }

    @Override
    public void deleteUserHash(Long id) {
        User userById = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Data not found in redis : " + id));

        userRepository.delete(userById);
    }
}
