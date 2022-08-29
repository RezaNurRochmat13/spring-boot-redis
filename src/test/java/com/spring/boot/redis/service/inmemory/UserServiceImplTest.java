package com.spring.boot.redis.service.inmemory;

import com.spring.boot.redis.entity.User;
import com.spring.boot.redis.repository.inmemory.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private Iterable<User> users;

    @BeforeEach
    private void setupData() throws Exception {
        users = Arrays.asList(new User("reja", "rejadoremi"));
    }

    @Test
    public void listUserHash() {
        given(userRepository.findAll()).willReturn(users);

        Iterable<User> userListsExpected = userService.listUserHash();

        assertThat(userListsExpected).isNotNull();
    }

    @Test
    public void detailUserHash() {
    }

    @Test
    public void saveUserHash() {
    }

    @Test
    public void updateUserHash() {
    }

    @Test
    public void deleteUserHash() {
    }
}