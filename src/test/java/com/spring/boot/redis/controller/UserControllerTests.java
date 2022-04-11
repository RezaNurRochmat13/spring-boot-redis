package com.spring.boot.redis.controller;

import com.spring.boot.redis.RedisApplicationTests;
import com.spring.boot.redis.repository.inmemory.UserRepository;
import org.json.JSONObject;
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

    @Test
    public void testGetAllUserWithPagination() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .get("/api/v1/users?page=0&size=10")
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult response = mockMvc
                .perform(requestBuilder)
                .andReturn();

        JSONObject actual = new JSONObject(response.getResponse().getContentAsString());

        System.out.println(actual.getJSONArray(""));

        // Assertion
        assertEquals(200, response.getResponse().getStatus());
//        assertEquals(5, actual.getJSONArray("data").length());
    }

    @Test
    public void testGetAllUserWithoutPagination() throws Exception {}
}