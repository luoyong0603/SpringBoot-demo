package com.example.demo;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeoutException;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MemcachedTest {

    @Autowired
    private MemcachedClient memcachedClient;


    @Test
    public void testMemcachedAdd() throws InterruptedException, TimeoutException, MemcachedException {
        // 存储数据
        memcachedClient.set("key", 0, "value", 3600);
        assertNull(memcachedClient.get("key"));
    }

    @Test
    public void testMemcachedDelete() throws InterruptedException, TimeoutException, MemcachedException {

        // 获取数据
        String value = (String) memcachedClient.get("key");
        assertEquals("value", value);
        // 删除数据
        memcachedClient.delete("key");
        assertNull(memcachedClient.get("key"));
    }

}
