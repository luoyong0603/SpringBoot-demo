package com.example.demo.dao;

import com.example.demo.entity.People;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/3/7 10:27
 */
@Repository
public interface PeopleRepository extends ElasticsearchRepository<People, String> {

    //Optional<Book> findById(String id);

    Page<People> findByName(String name, Pageable  pageable);

}
