/**
 * Stome.com Co.,Ltd.
 * Copyright (c) 2004-2017, All Rights Reserved.
 */
package com.stome.workbanch.common.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonSerializer;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.SerializerProvider;
import org.codehaus.jackson.type.JavaType;
import org.codehaus.jackson.type.TypeReference;

/** 
 * JSON解析工具类
 * 
 * @author Robin 
 * @date 2017-01-29 06:40:41 
 * @version $id: JsonUtil.java v1.0 
 */
public class JsonUtil {

    /** log4j component */
    private static final Logger       LOGGER       = Logger.getLogger(JsonUtil.class);

    /** ObjectMapper对象 */
    private static final ObjectMapper OBJECTMAPPER = new ObjectMapper();

    static {
        // 是否允许解析使用Java/C++ 样式的注释
        OBJECTMAPPER.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
        // 是否将允许使用非双引号属性名字
        OBJECTMAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
        // 是否允许单引号来包住属性名称和字符串值
        OBJECTMAPPER.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        // 取消对非ASCII字符的转码
        OBJECTMAPPER.configure(JsonGenerator.Feature.ESCAPE_NON_ASCII, false);
        // 是否允许JSON字符串包含非引号控制字符（值小于32的ASCII字符，包含制表符和换行符）。
        // 如果该属性关闭，则如果遇到这些字符，则会抛出异常。
        // 允许出现特殊字符和转义符
        // 标准json中,要求键和值其实都是要双引号的.
        // 但如果非要设置键值为非双引号不可的话,则需要设置JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES,如下:
        OBJECTMAPPER.configure(JsonParser.Feature.ALLOW_UNQUOTED_CONTROL_CHARS, false);
        // JSON对象属性名称是否可以被String#intern 规范化表示
        OBJECTMAPPER.configure(JsonParser.Feature.INTERN_FIELD_NAMES, true);
        // JSON对象的属性名称是否被规范化
        OBJECTMAPPER.configure(JsonParser.Feature.CANONICALIZE_FIELD_NAMES, true);
        /**
         * 该特性决定了当遇到未知属性（没有映射到属性，没有任何setter或者任何可以处理它的handler），是否应该抛出一个
         * JsonMappingException异常。这个特性一般式所有其他处理方法对未知属性处理都无效后才被尝试，属性保留未处理状态。
         *
         * 默认情况下，该设置是被打开的。
         *
         * @since 1.2
         */
        OBJECTMAPPER.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        // 禁用序列化日期为timestamps
        OBJECTMAPPER.configure(SerializationConfig.Feature.WRITE_DATES_AS_TIMESTAMPS, false);
        //
        OBJECTMAPPER.configure(JsonGenerator.Feature.QUOTE_FIELD_NAMES, false);
        // 数字加引号
        OBJECTMAPPER.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, false);
        OBJECTMAPPER.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, false);
        OBJECTMAPPER.getSerializerProvider().setNullValueSerializer(new JsonSerializer<Object>() {

            @Override
            public void serialize(Object arg0, JsonGenerator arg1,
                                  SerializerProvider arg2) throws IOException,
                                                           JsonProcessingException {
                arg1.writeString("");
            }
        });

    }

    /** 
     * 将object对象转化为json字符串
     * 
     * @author Robin
     * @date 2017-01-29 06:43:27 
     * @version v1.0 
     * @param obj       object对象
     * @return 
     */
    public static String object2Json(Object obj) {
        try {
            return OBJECTMAPPER.writeValueAsString(obj);
        } catch (Exception e) {
            LOGGER.error("converting object to json string occured errors", e);
        }
        return null;
    }

    /** 
     * 将json字符串转化为java bean对象
     * 
     * @author Robin
     * @date 2017-01-29 06:59:53 
     * @version v1.0 
     * @param json      json字符串
     * @param clazz     转换目标类型
     * @return 
     */
    public static <T> T json2Object(String json, Class<T> clazz) {
        try {
            return OBJECTMAPPER.readValue(json, clazz);
        } catch (Exception e) {
            e.printStackTrace();
            LOGGER.error("converting json string to object occured errors", e);
        }
        return null;
    }

    /** 
     * 将json字符串转化为java bean对象
     * 
     * @author Robin
     * @date 2017-01-29 07:02:48 
     * @version v1.0 
     * @param json                json字符串
     * @param typeReference       转换目标类型
     * @return 
     */
    public static <T> T json2Object(String json, TypeReference<T> typeReference) {
        try {
            return OBJECTMAPPER.readValue(json, typeReference);
        } catch (Exception e) {
            LOGGER.error("converting json string to object occured errors", e);
        }
        return null;
    }

    /** 
     * 将json字符串转化为list对象
     * 
     * @author Robin
     * @date 2017-01-29 07:58:17 
     * @version v1.0 
     * @param json             json字符串
     * @param typeReference    目标类型描述对象
     * @return 
     */
    public static <T> List<T> json2List(String json, TypeReference<List<T>> typeReference) {
        try {
            return OBJECTMAPPER.readValue(json, typeReference);
        } catch (Exception e) {
            LOGGER.error("converting json string to list occured errors", e);
        }
        return null;
    }

    /** 
     * 将json字符串转化为list对象
     * 
     * @author Robin
     * @date 2017-01-29 07:58:17 
     * @version v1.0 
     * @param json     json字符串
     * @param clazz    目标类型
     * @return 
     */
    public static <T> List<T> json2List(String json, Class<T> clazz) {
        try {
            JavaType javaType = getCollectionType(clazz);
            return OBJECTMAPPER.readValue(json, javaType);
        } catch (Exception e) {
            LOGGER.error("converting json string to list occured errors", e);
        }
        return null;
    }

    /** 
     * 将json字符串转化为map对象
     * 
     * @author Robin
     * @date 2017-01-29 07:56:41 
     * @version v1.0 
     * @param json    json字符串
     * @param clazz   目标类型 
     * @return 
     */
    public static <T> Map<String, T> json2Map(String json, Class<T> clazz) {
        try {
            JavaType javaType = getMapType(clazz);
            return OBJECTMAPPER.readValue(json, javaType);
        } catch (Exception e) {
            LOGGER.error("converting json string to map occured errors", e);
        }
        return null;
    }

    /** 
     * 将json字符串转化为map对象
     * 
     * @author Robin
     * @date 2017-01-29 07:56:41 
     * @version v1.0 
     * @param clazz   目标类型 
     * @param json    json字符串
     * @return 
     */
    public static <T> Map<String, T> json2Map(Class<T> clazz, String json) {
        try {
            Map<String, Map<String, Object>> map = OBJECTMAPPER.readValue(json,
                new TypeReference<Map<String, T>>() {
                });
            Map<String, T> result = new HashMap<String, T>();

            for (Entry<String, Map<String, Object>> e : map.entrySet()) {
                result.put(e.getKey(), map2Object(e.getValue(), clazz));
            }
            return result;
        } catch (Exception e) {
            LOGGER.error("converting json string to map occured errors", e);
        }
        return null;
    }

    /** 
     * 将map转化为java bean对象
     * 
     * @author Robin
     * @date 2017-01-29 07:55:50 
     * @version v1.0 
     * @param map     map对象
     * @param clazz   目标类型
     * @return 
     */
    @SuppressWarnings("rawtypes")
    public static <T> T map2Object(Map map, Class<T> clazz) {
        try {
            return OBJECTMAPPER.convertValue(map, clazz);
        } catch (Exception e) {
            LOGGER.error("converting map to object occured errors", e);
        }
        return null;
    }

    /** 
     * 获取json转list类型描述对象
     * @author Robin
     * @date 2017-01-29 07:54:51 
     * @version v1.0 
     * @param clazz    list中存储的目标对象类型
     * @return 
     */
    public static <T> JavaType getCollectionType(Class<T> clazz) {
        return OBJECTMAPPER.getTypeFactory().constructParametricType(ArrayList.class, clazz);
    }

    /** 
     * 获取json转map类型描述对象
     * 
     * @author Robin
     * @date 2017-01-29 07:53:08 
     * @version v1.0 
     * @param clazz      map中存储的目标对象类型
     * @return 
     */
    public static <T> JavaType getMapType(Class<T> clazz) {
        return OBJECTMAPPER.getTypeFactory().constructParametricType(HashMap.class, String.class,
            clazz);
    }

}
