package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/8/25 11:29
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SampleHandlerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testHello() {
        webTestClient
                .get()
                .uri("/hello")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBodyList(String.class)
                .hasSize(2)
                .contains("Hello", "World");
    }

}