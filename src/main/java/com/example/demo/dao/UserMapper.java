package com.example.demo.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.UserEntity;
import com.example.demo.vo.UserInfoVo;
import com.example.demo.model.QueryUserInfoModel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户管理持久层
 */
@Component
public interface UserMapper extends BaseMapper<UserEntity> {


    @Select("select veedata from user where id = #{userId}")
    String findById(@Param("id") String id);

    List<UserEntity> getUserList();


    //    @Select("select * from user u left join grade g on u.id = g.student_id  where u.sex = #{model.sex} and g.name = #{model.className}")
    List<UserInfoVo> getUsers(@Param("model") QueryUserInfoModel model);


    //userIds 用户id集合
    List<UserInfoVo> getUsersByIds(@Param("userIds") List<Integer> userIds);


    List<UserEntity> getUserByIdFor(@Param("id") Integer id);
}
