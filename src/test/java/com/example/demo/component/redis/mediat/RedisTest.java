//package com.example.demo.component.redis.mediat;
//
//import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
//class RedisTest {
//
//    @Autowired
//    private RedisMediator redisMediator;
//
//
//    /**
//     * 插入一个key
//     */
//    @Test
//    void testSetKey() {
//        redisMediator.set("name", "diaochan");
//    }
//
//    @Test
//    void testHasKey() {
//        boolean has = redisMediator.hasKey("name");
//        System.out.println("是否存在：" + has);
//    }
//
//    /**
//     * 获取一个key
//     */
//    @Test
//    void testGetKey() {
//        String name = redisMediator.get("name");
//        System.out.println("获取到的name对于的值为:" + name);
//    }
//
//    /**
//     * 指定缓存失效时间(秒)
//     */
//    @Test
//    void testExpireKey() {
//        redisMediator.expire("name", 3600);
//    }
//
//
//    /**
//     * 删除一个key
//     */
//    @Test
//    void testDelKey() {
//        redisMediator.del("name");
//    }
//
//}
//
