package com.wow.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by zhengzhiqing on 16/7/5.
 */
public class JsonUtil {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String pojo2Json(Object object) {
        String resultJsonStr = "";
        try {
            resultJsonStr = objectMapper.writeValueAsString(object);
        } catch (Exception e) {
            resultJsonStr="";
        }
        
        return resultJsonStr;
    }

    /**
     * 将 JSON 字符串转为 Java 对象
     */
    public static <T> T fromJSON(String json, Class<T> type) {
        T obj;
        try {
            obj = objectMapper.readValue(json, type);
        } catch (Exception e) {
            obj=null;
        }
        
        return obj;
    }
}
