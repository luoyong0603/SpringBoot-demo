package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * 测试
 */
@RestController
public class SampleHandler {

    @GetMapping("/hello")
    public Flux<String> hello() {
        return Flux.just("Hello", "World");
    }

}
