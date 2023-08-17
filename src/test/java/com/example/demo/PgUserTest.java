package com.example.demo;

import com.example.demo.dao.PgUserRepository;
import com.example.demo.entity.PgUser;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Wrapper;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/8/7 17:40
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PgUserTest {

    @Autowired
    private PgUserRepository pgUserRepository;

    @Test
    public void insertTest() throws Exception {
        pgUserRepository.insert(new PgUser(1L, "赵云", 8));
        pgUserRepository.insert(new PgUser(2L, "黄忠", 34));
        pgUserRepository.insert(new PgUser(3L, "张飞", 27));
        pgUserRepository.insert(new PgUser(4L, "貂蝉", 31));
        pgUserRepository.insert(new PgUser(5L, "关羽", 66));
    }

    //根据指定id进行数据查询
    @Test
    public void deleteByIdTest() {
        Assertions.assertEquals(1, pgUserRepository.deleteById(1));
    }

    //根据指定id进行数据修改
    @Test
    public void updateById() {
        PgUser pgUser = pgUserRepository.selectById(1);
        System.out.println("修改前：" + pgUser.toString());
        pgUser.setAge(100);
        pgUser.setName("bug菌");
        Assertions.assertEquals(1, pgUserRepository.updateById(pgUser));
        System.out.println("修改后：" + pgUser.toString());
    }

    //根据指定name进行数据查询
    @Test
    public void queryByNameTest() {
        PgUser pgUser = pgUserRepository.findUser("bug菌");
        System.out.println(pgUser.toString());
    }

    //根据指定name和age组合进行数据查询
    @Test
    public void queryByNameAndAgeTest() {
        PgUser pgUser = pgUserRepository.findByNameAndAge("bug菌",100);
        System.out.println(pgUser.toString());
    }
}
