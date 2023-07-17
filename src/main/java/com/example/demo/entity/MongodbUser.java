package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author luoYong
 * @version 1.0
 * @date 2023/7/13 16:44
 */
@Data
//Document注解表明对应了MongoDB中的user表。
@NoArgsConstructor//无参构造
@AllArgsConstructor//全参构造
@Document(collection = "user")
public class MongodbUser {

    @Id
    private Long id;
    private String username;
    private Integer age;

}
