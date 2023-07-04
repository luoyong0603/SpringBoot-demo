package com.example.demo.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * json工具类
 */
@Slf4j
public class JsonUtils {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    /*
     * 初始化ObjectMapper
     */
    static {
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        OBJECT_MAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        OBJECT_MAPPER.configure(JsonParser.Feature.IGNORE_UNDEFINED, true);
        OBJECT_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OBJECT_MAPPER.enable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        OBJECT_MAPPER.registerModule(new JavaTimeModule());
    }

    /**
     * 对象转为json串
     *
     * @param object 要转为json串的对象
     */
    public static String writeValueAsString(Object object) throws JsonProcessingException {
        if (object != null) {
            return OBJECT_MAPPER.writeValueAsString(object);
        }
        return "";
    }

    /**
     * json串转对象
     *
     * @param content 要转换的json串
     * @param type    泛型信息
     */
    public static <T> T readValue(String content, TypeReference<T> type) throws JsonProcessingException {
        if (StringUtils.isBlank(content)) {
            return JsonUtils.readValue("{}", type);
        }
        return OBJECT_MAPPER.readValue(content, type);
    }

    /**
     * json文件转对象
     *
     * @param file json文件
     * @param type 泛型信息
     */
    public static <T> T readValue(File file, TypeReference<T> type) throws IOException {
        if (!file.exists()) {
            return JsonUtils.readValue("{}", type);
        }
        return OBJECT_MAPPER.readValue(file, type);
    }

    /**
     * 对象转map
     *
     * @param object 要转换的对象
     */
    public static Map<String, Object> convertToMap(Object object) {
        TypeReference<HashMap<String, Object>> type = new TypeReference<HashMap<String, Object>>() {
        };
        return OBJECT_MAPPER.convertValue(object, type);
    }

    /**
     * 将json串转为JsonNode
     *
     * @param content json串
     */
    public static JsonNode readTree(String content) throws JsonProcessingException {
        return OBJECT_MAPPER.readTree(content);
    }

}
