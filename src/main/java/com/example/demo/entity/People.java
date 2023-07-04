package com.example.demo.entity;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/3/7 10:13
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 *Document:
 * indexName = "user":索引名称,类似于mysql中的数据库;
 * type = "doc":文档类型,类似于mysql中的表;
 * shards = 5:分片数量
 * replicas = 1:副本
 */
@NoArgsConstructor//无参构造
@AllArgsConstructor//全参构造
@Document(indexName = "search-user", type = "doc", shards = 5, replicas = 1)
@Data
public class People {

    @Id
    private String id;

    /**
     * 中文分词设置，前提是您的es已经安装了中文分词ik插件
     * 中文分词有两种形式：
     * ik_max_word：会将文本做最细粒度的拆分
     * ik_smart：会将文本做最粗粒度的拆分
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word",searchAnalyzer ="ik_max_word")
    private String name;

    private String sex;

    private String birthDate;


}
