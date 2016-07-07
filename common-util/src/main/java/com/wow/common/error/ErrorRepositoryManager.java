package com.wow.common.error;

import com.wow.common.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * 可以考虑放到数据库里,加长时间缓存
 * Created by zhengzhiqing on 16/6/27.
 */
@Component
public class ErrorRepositoryManager {

    @Autowired
    RedisUtil redisUtil;

    private static Map<String,String> ERROR_CODE_MAP = new HashMap<String,String>();
    static {

        ERROR_CODE_MAP.put("0","Success");

        //system related
        ERROR_CODE_MAP.put("10000","Invalid session token");

        //common error
        ERROR_CODE_MAP.put("40000","Invalid input parameter");
        ERROR_CODE_MAP.put("40001","Another invalid input parameter");

        //user related
        ERROR_CODE_MAP.put("40201","验证码已过期");
        ERROR_CODE_MAP.put("40202","验证码不匹配");
        ERROR_CODE_MAP.put("40203","用户名和密码不匹配");
        ERROR_CODE_MAP.put("40204","Username and password not matched");
        ERROR_CODE_MAP.put("40205","Username and password not matched");
        ERROR_CODE_MAP.put("40206","Username and password not matched");
        ERROR_CODE_MAP.put("40207","Username and password not matched");
        ERROR_CODE_MAP.put("40208","");
        ERROR_CODE_MAP.put("40209","");
        ERROR_CODE_MAP.put("40210","");
        ERROR_CODE_MAP.put("40211","");
        ERROR_CODE_MAP.put("40212","");
        ERROR_CODE_MAP.put("40213","");
        ERROR_CODE_MAP.put("40214","");
        ERROR_CODE_MAP.put("40215","");
        ERROR_CODE_MAP.put("40216","");
        ERROR_CODE_MAP.put("40217","");
        ERROR_CODE_MAP.put("40218","");
        ERROR_CODE_MAP.put("40219","");

        //attribute related
        ERROR_CODE_MAP.put("40401","AttributeId cannot <= 0");

        //server side error
        ERROR_CODE_MAP.put("50000","Internal error");
    }

    public String getErrorMsg(String errorCode) {
        Object object = redisUtil.get(errorCode);
        String errorMsg = "";
        if (object != null) {
            errorMsg = (String) object;
        } else {
            //TODO: get from db
            errorMsg = getErrorMsgFromDb(errorCode);
        }
        return errorMsg;
    }

    private String getErrorMsgFromDb(String errorCode) {
        return ERROR_CODE_MAP.get(errorCode);
    }
}
