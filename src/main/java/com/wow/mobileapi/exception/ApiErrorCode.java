package com.wow.mobileapi.exception;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhengzhiqing on 16/6/27.
 */
public class ApiErrorCode {
    private static Map<String,String> ERROR_CODE_MAP = new HashMap<String,String>();
    static {
        ERROR_CODE_MAP.put("0","Success");
        ERROR_CODE_MAP.put("40000","Invalid input parameter");
        ERROR_CODE_MAP.put("40401","AttributeId cannot <= 0");
        ERROR_CODE_MAP.put("40002","Another invalid input parameter");
        ERROR_CODE_MAP.put("40201","Username and password not matched");
        ERROR_CODE_MAP.put("50000","Internal error");
    }

    public static String getErrorMsg(String errorCode) {
        return ERROR_CODE_MAP.get(errorCode);
    }
}
