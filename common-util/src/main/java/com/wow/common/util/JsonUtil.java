package com.wow.common.util;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by zhengzhiqing on 16/7/5.
 */
public class JsonUtil {
    public static String pojo2Json(Object object) {
        ObjectMapper mapper = new ObjectMapper();
        String resultJsonStr = "";
        //POJO to JSON
        try {
            resultJsonStr = mapper.writeValueAsString(object);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultJsonStr;
    }
}
