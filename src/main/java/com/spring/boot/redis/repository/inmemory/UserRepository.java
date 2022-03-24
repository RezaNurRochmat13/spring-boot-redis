package com.spring.boot.redis.repository.inmemory;

import com.spring.boot.redis.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
