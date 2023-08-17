package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.PgUser;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.stereotype.Component;


import java.awt.*;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/8/7 17:36
 */
@Component
public interface PgUserRepository extends BaseMapper<PgUser> {

    @Select("select * from public.pg_user where name=#{name} and age=#{age}")
    PgUser findByNameAndAge(@Param("name")String name,@Param("age")Integer age);

    @Select(" select * from public.pg_user where name= #{name}")
    PgUser findUser(@Param("name") String name);
}
