package com.spring.boot.redis.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash(value = "UserDetail", timeToLive = 1500)
@Getter
@Setter
@ToString
@NoArgsConstructor
public class UserDetail implements Serializable {
    @Id
    private Long id;
    @JsonProperty("user_id")
    private Long userId;
    private String address;
    private String email;
}
