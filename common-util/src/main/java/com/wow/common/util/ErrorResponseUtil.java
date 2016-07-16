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
}
