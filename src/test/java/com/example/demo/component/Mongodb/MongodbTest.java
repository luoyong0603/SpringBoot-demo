package com.example.demo.component.Mongodb;

import com.example.demo.entity.MongodbUser;
import com.example.demo.service.MongodbUserRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/7/13 16:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MongodbTest {

    @Autowired
    private MongodbUserRepository mongodbUserRepository;
    @Autowired
    private MongoTemplate mongoTemplate;


    @Test
    public void insertTest() {
        mongodbUserRepository.deleteAll();

        // 创建三个User，并验证User总数
        mongodbUserRepository.save(new MongodbUser(1L, "赵云", 30));
        mongodbUserRepository.save(new MongodbUser(2L, "貂蝉", 40));
        mongodbUserRepository.save(new MongodbUser(3L, "李白", 50));
        Assertions.assertEquals(3, mongodbUserRepository.findAll().size());
    }

    //删除数据
    @Test
    public void deleteByIdTest() {
        mongodbUserRepository.deleteById(1L);
        Assertions.assertEquals(2, mongodbUserRepository.findAll().size());
    }

    //修改数据
    @Test
    public void updateByIdTest() {

        // 使用Query和Update构造更新条件和更新内容
        Long id = 2L;
        Integer age = 99;
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update().set("age", age);
        mongoTemplate.updateFirst(query, update, MongodbUser.class);
    }

    //根据用户名指定查询
    @Test
    public void queryByNameTest() {
        //指定查询
        Query query = new Query(Criteria.where("username").is("李白"));
        System.out.println(mongoTemplate.find(query, MongodbUser.class));
    }


    //根据年龄范围查询
    @Test
    public void queryBAgesTest() {
        //范围查询
        Query query = new Query();
        query.addCriteria(Criteria.where("age").gte(30).lte(60));
        System.out.println(mongoTemplate.find(query, MongodbUser.class));
    }



}
