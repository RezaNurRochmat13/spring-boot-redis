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
public class BaseListResponse implements Serializable {
    private int count;
    private Long total;
    private Object data;
}
