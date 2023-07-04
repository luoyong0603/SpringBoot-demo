package com.example.demo.util;

import com.example.demo.entity.UserEntity;

public class PrintUtil {

    /**
     * 对要遍历的元素添加add操作
     */
    public void addString(UserEntity x) {
        System.out.println(x.getName() + "add");
    }


}
