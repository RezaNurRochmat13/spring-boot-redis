package com.spring.boot.redis.service.inmemory;

import com.spring.boot.redis.entity.Product;
import com.spring.boot.redis.repository.inmemory.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> doGetAllProducts() {
        return productRepository.findAll();
    }
}
