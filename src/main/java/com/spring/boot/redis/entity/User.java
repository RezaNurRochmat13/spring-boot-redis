package com.spring.boot.redis.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash(value = "User", timeToLive = 1500)
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {
    @Id
    private Long Id;
    private String name;
    private String password;
}
