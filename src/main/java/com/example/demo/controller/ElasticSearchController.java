package com.example.demo.controller;

import com.example.demo.entity.People;
import com.example.demo.service.PeopleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.IndexOperations;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/3/7 10:09
 */
@Slf4j
@RestController
@RequestMapping("/user")
public class ElasticSearchController {

    @Autowired
    private PeopleService userService;

    @Autowired
    private ElasticsearchRestTemplate elasticsearchRestTemplate;


    /**
     * 创建/更新索引
     */
    @PostMapping("/create")
    public boolean  createIndex() {
        IndexOperations indexOperations = elasticsearchRestTemplate.indexOps(People.class);
        indexOperations.createMapping(People.class);
        return indexOperations.create();
    }

    @PostMapping("/save")
    public void Save() {
        People book = new People("001", "张三", "男", "2022-03-07");
        log.warn(book.toString());
        userService.save(book);
    }

    @GetMapping("/id/{id}")
    public People getBookById(@PathVariable String id) {
        Optional<People> opt = userService.findById(id);
        People book = opt.get();
        log.warn(book.toString());
        return book;
    }



}
