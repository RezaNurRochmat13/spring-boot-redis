package com.spring.boot.redis.controller;

import com.spring.boot.redis.RedisApplicationTests;
import com.spring.boot.redis.entity.User;
import com.spring.boot.redis.entity.UserDetail;
import com.spring.boot.redis.repository.inmemory.UserDetailRepository;
import com.spring.boot.redis.repository.inmemory.UserRepository;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class UserControllerTests extends RedisApplicationTests {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserDetailRepository userDetailRepository;

    @Before
    public void setUp() throws Exception {
        User user = userRepository.save(new User("Mirzani", "mirzani0001872"));
        UserDetail userDetail = new UserDetail();
        userDetail.setUserId(user.getId());
        userDetail.setAddress("Sleman");
        userDetail.setEmail("mirzani@gmail.com");

        userDetailRepository.save(userDetail);
    }

    @Test
    public void testGetAllUser() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/users")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilder)
                .andReturn();

        // Assertion
        assertEquals(200, response.getResponse().getStatus());
    }
}