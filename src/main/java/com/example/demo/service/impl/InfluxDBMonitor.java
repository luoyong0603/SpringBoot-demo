package com.example.demo.service.impl;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.influxdb.InfluxDB;
import org.influxdb.dto.Point;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@AllArgsConstructor
@Slf4j
public class InfluxDBMonitor {

    private InfluxDB influxDB;

    @Scheduled(fixedRate = 5000) //5秒执行一次
    public void InsertDataForInfluxDB() {
        //随机数字
        int count = (int) (Math.random() * 100);

        Point point = Point.measurement("test_count")     // 表名
                .tag("index", "index")  // 索引字段名
                .addField("count", count)        // 字段名1
                .addField("count_str", "str_" + count)        // 字段名2
                .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)  // 时间
                .build();

        // 往test_count库插入数据
        influxDB.write("influx_demo", "autogen", point);

        log.info("写入数据库的count值为：" + count);
    }


}
