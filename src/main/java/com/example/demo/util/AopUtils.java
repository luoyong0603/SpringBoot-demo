package com.example.demo.util;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.demo.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;

import java.lang.reflect.Field;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author luoYong
 * @version 1.0
 * @date 2022/9/28 9:22
 */
public class AopUtils {

    /**
     * 通过反射获取指定类@ApiModelProperty注解修饰的name值跟value值
     */
    public static LinkedHashMap getApiModelProperty(String classPath) {

        //定义一个可顺序集合存放
        LinkedHashMap res = new LinkedHashMap();

        try {
            // 1.根据类路径获取类
            Class<?> c = Class.forName(classPath);
            //或者直接这样获取
//            Class<BaseEntity> aClass = BaseEntity.class;
//            Field[] declaredFields = aClass.getDeclaredFields();

            // 2.获取类的属性
            Field[] declaredFields = c.getDeclaredFields();
            // 3.遍历属性，获取属性上ApiModelProperty的值，属性的名，存入res
            if (declaredFields.length != 0) {
                for (Field field : declaredFields) {
                    if (field.getAnnotation(ApiModelProperty.class) != null) {

                        // 这存的key为注解的[name]类属性名，value为注解的[value]值
                        res.put(field.getName(), field.getAnnotation(ApiModelProperty.class).value());
                    }
                }
                return res;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) {
        LinkedHashMap apiModelProperty = AopUtils.getApiModelProperty("com.example.demo.entity.BaseEntity");
        System.out.println(apiModelProperty);
    }

}
