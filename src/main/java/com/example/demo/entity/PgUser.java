package com.example.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Id;

import javax.persistence.GeneratedValue;

/**
 * 用于postgresql 数据库使用的
 *
 * @author luoYong
 * @version 1.0
 * @date 2023/8/7 17:32
 */
@Data
@NoArgsConstructor//无参构造
@TableName("public.pg_user")
public class PgUser {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Integer age;

    public PgUser(Long id,String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public PgUser(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

}
