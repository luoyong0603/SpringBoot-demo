package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class DemoController {

    //注入JDBC模板接口
//    @Autowired
//    private JdbcTemplate jdbcTemplate;

//    /**
//     * 查询所有用户
//     */
//    @GetMapping("/get-users")
//    public List<Map<String, Object>> getUserList(){
//        //查询语句
//        String sql = "select * from user";
//        List<Map<String, Object>> list =  jdbcTemplate.queryForList(sql);
//        return list;
//    }

}
