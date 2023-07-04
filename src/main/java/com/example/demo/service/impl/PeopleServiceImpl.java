package com.example.demo.service.impl;

import com.example.demo.entity.People;
import com.example.demo.dao.PeopleRepository;
import com.example.demo.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/3/7 11:04
 */
@Service
public class PeopleServiceImpl implements PeopleService {

    @Autowired
    private PeopleRepository userRepository;

    @Override
    public Optional<People> findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public People save(People blog) {
        return userRepository.save(blog);
    }

    @Override
    public void delete(People blog) {
        userRepository.delete(blog);
    }

    @Override
    public Optional<People> findOne(String id) {
        return userRepository.findById(id);
    }

    @Override
    public List<People> findAll() {
        return (List<People>) userRepository.findAll();
    }

    @Override
    public Page<People> findByAuthor(String author, PageRequest pageRequest) {
        return userRepository.findByName(author, pageRequest);
    }



}
