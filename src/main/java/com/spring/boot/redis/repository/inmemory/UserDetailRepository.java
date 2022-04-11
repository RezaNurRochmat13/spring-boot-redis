package com.spring.boot.redis.repository.inmemory;

import com.spring.boot.redis.entity.UserDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends CrudRepository<UserDetail, Long> {
}
