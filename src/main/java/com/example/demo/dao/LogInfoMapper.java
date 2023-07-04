package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.entity.LogInfo;
import org.springframework.stereotype.Component;

import java.util.Date;


/**
 * 系统日志持久层
 *
 * @Author luoYong
 * @Date 2021-08-05 15:27
 */
@Component
public interface LogInfoMapper extends BaseMapper<LogInfo> {

    /**
     * 清除指定日期之前的日志
     *
     * @param date 时间
     */
    void clear(Date date);
}
