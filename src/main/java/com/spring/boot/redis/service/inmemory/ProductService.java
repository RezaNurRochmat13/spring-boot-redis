package com.spring.boot.redis.service.inmemory;

import com.spring.boot.redis.entity.Product;

public interface ProductService {
    Iterable<Product> doGetAllProducts();
}
