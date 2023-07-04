package com.example.demo.service;

import com.example.demo.entity.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/3/7 10:29
 */
public interface PeopleService {

    Optional<People> findById(String id);

    People save(People blog);

    void delete(People blog);

    Optional<People> findOne(String id);

    List<People> findAll();

    Page<People> findByAuthor(String author, PageRequest pageRequest);

}
