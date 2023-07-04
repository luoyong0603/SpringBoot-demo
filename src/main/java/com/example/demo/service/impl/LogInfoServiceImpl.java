package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.LogInfoMapper;
import com.example.demo.entity.LogInfo;
import com.example.demo.service.LogInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 日志业务接口
 *
 * @Author luoYong
 * @Date 2021-08-03 17:17
 */
@Slf4j
@Service
public class LogInfoServiceImpl extends ServiceImpl<LogInfoMapper, LogInfo> implements LogInfoService {

}
