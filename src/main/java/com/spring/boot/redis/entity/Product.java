package com.spring.boot.redis.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.redis.core.RedisHash;

import jakarta.persistence.Id;
import java.io.Serializable;

@RedisHash(value = "Product", timeToLive = 1500)
@Getter
@Setter
@NoArgsConstructor
public class Product implements Serializable {
    @Id
    private Long id;
    private String name;
    private String description;
    private String qty;
}
