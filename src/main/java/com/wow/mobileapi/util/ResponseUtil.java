package com.wow.mobileapi.util;

import org.springframework.stereotype.Component;

import com.wow.common.response.ApiResponse;
import com.wow.common.util.ErrorCodeUtil;

/**
 * Created by zhengzhiqing on 16/6/27.
 */
@Component
public class ResponseUtil {

    public void setResponse(ApiResponse apiResponse, String resCode) {
        apiResponse.setResCode(resCode);
        apiResponse.setResMsg(ErrorCodeUtil.getErrorMsg(resCode));
    }
}