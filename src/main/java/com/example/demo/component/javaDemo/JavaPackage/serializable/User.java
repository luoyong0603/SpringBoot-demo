package com.example.demo.component.javaDemo.JavaPackage.serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 1L; // 版本号



    private String name;
    private int age;
    // ...
}
