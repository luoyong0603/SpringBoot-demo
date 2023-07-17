package com.example.demo.service;

import com.example.demo.entity.MongodbUser;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @version 1.0
 * @date 2023/7/13 16:46
 */
public interface  MongodbUserRepository extends MongoRepository<MongodbUser, Long> {

    MongodbUser findByUsername(String username);
}
