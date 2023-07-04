package com.example.demo.util;

import com.example.demo.entity.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import net.sourceforge.stripes.util.ReflectUtil;
import org.springframework.util.Assert;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author luoYong
 * @version 1.0
 * @date 2022/9/28 9:22
 */
public class AipModelPropertyParamUtils {

    /**
     * 通过反射获取指定类@ApiModelProperty注解修饰的name值跟value值
     */
/*    public static List<Map<String, String>> getApiModelProperty(Class<?> clazz) {

        Assert.notNull(clazz);

        return Arrays.stream(ReflectUtil.getFields(clazz))
                .filter(field -> field.isAnnotationPresent(ApiModelProperty.class))
                .map(field -> {
                    Map<String, String> map = new HashMap<>();
                    ApiModelProperty annotation = field.getAnnotation(ApiModelProperty.class);
                    map.put("filedName", field.getName());
                    map.put("desc", annotation.value());
                    return map;
                }).collect(Collectors.toList());
    }*/



}
