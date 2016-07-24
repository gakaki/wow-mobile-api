package com.wow.common.util;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wow.common.page.PageData;

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
            e.printStackTrace();
            resultJsonStr = "";
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
            e.printStackTrace();
            obj = null;
        }

        return obj;
    }

    /**
     * 将 map转为 Java 对象
     */
    public static <T> T fromJSON(List<PageData> pageData, Class<T> type) {
        return fromJSON(pojo2Json(pageData), type);
    }
}
