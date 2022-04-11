package com.spring.boot.redis.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@Component
public class BaseSingleResponse implements Serializable {
    private Object data;
}
