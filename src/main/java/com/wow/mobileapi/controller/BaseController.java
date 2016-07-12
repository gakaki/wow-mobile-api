package com.wow.mobileapi.controller;

import com.wow.common.response.ApiResponse;
import com.wow.common.response.CommonResponse;

/**
 * controller基类 用以处理controller中的一些通用方法
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月12日 上午10:56:17 Exp $
 */
public class BaseController {

    /**
     * 
     * 判断调用service方法是否成功
     * @param errorCode
     * @return
     */
    public boolean isServiceCallSuccess(String errorCode) {
        return "0".equals(errorCode);
    }

    /**
     * 包装具体的业务错误信息
     * 
     * @param apiResponse
     * @param commonResponse
     */
    public void copyResponse(ApiResponse apiResponse, CommonResponse commonResponse) {
        apiResponse.setResCode(commonResponse.getResCode());
        apiResponse.setResMsg(commonResponse.getResMsg());
    }

    
    /**
     * 包装json参数解析错误信息
     * 
     * @param apiResponse
     */
    public void setParseError(ApiResponse apiResponse) {
        apiResponse.setResCode("40001");
        apiResponse.setResMsg("paramJson参数格式有误");
    }

    /**
     * 包装json参数解析错误信息
     *
     * @param apiResponse
     */
    public void setInternalError(ApiResponse apiResponse) {
        apiResponse.setResCode("50000");
        apiResponse.setResMsg("服务端异常");
    }

}
