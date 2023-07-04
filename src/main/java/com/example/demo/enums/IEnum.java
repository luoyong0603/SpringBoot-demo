package com.example.demo.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * 系统所有枚举必须实现该接口
 */
public interface IEnum {

    /**
     * 获取枚举的key
     */
    Integer getKey();

    /**
     * 获取枚举的下标
     */
    String getValue();

    /**
     * 将参数反序列化为枚举
     *
     * @param param 当前值
     * @param clazz 枚举类型
     */
    static <T extends Enum<T> & IEnum> T parse(Integer param, Class<T> clazz) {
        if (param == null || clazz == null) {
            return null;
        }
        T[] enums = clazz.getEnumConstants();
        for (T t : enums) {
            Integer key = t.getKey();
            if (key.equals(param)) {
                return t;
            }
        }
        return null;
    }

    /**
     * 将参数反序列化为枚举
     *
     * @param param 当前值
     * @param clazz 枚举类型
     */
    static <T extends Enum<T> & IEnum> T parse(String param, Class<T> clazz) {
        if (StringUtils.isBlank(param) || clazz == null) {
            return null;
        }
        T[] enums = clazz.getEnumConstants();
        for (T t : enums) {
            String value = t.getValue();
            if (value.equals(param)) {
                return t;
            }
        }
        return null;
    }


}
