package com.wow.common.util;

import com.wow.common.response.CommonResponse;

/**
 * Created by zhengzhiqing on 16/7/16.
 */
public class ErrorResponseUtil {
    public static void setErrorResponse(CommonResponse commonResponse, String errorCode) {
        commonResponse.setResCode(errorCode);
        commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg(errorCode));
    }

    /**
     * 
     * 判断业务调用方法是否成功
     * @param errorCode
     * @return
     */
    public static boolean isServiceCallSuccess(String errorCode) {
        return "0".equals(errorCode);
    }
}
