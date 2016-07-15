package com.wow.mobileapi.controller;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.BeanUtil;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.StringUtil;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.request.user.LoginRequest;
import com.wow.mobileapi.request.user.LogoutRequest;
import com.wow.user.service.SessionService;
import com.wow.user.vo.LoginVo;
import com.wow.user.vo.response.LoginResponse;
import com.wow.user.vo.response.LogoutResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 登录、登出
 * Created by zhengzhiqing on 16/6/23.
 */
@RestController
public class SessionController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

    @Autowired
    private SessionService sessionService;

    /**
     * 创建新的会话(登入)
     * @param apiRequest
     * @return
     */
    @RequestMapping(value="/v1/session/login", method = RequestMethod.POST)
    public ApiResponse login(ApiRequest apiRequest) {

        ApiResponse apiResponse = new ApiResponse();
        LoginRequest loginRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), LoginRequest.class);
        //判断json格式参数是否有误
        if (loginRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(loginRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        //TODO: 可能会需要从header中获取部分信息,放到LoginRequest,比如login channel
        LoginVo loginVo = new LoginVo();
        BeanUtil.copyProperties(loginRequest, loginVo);

        try {
            LoginResponse loginResponse = sessionService.login(loginVo);
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(loginResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, loginResponse);
            } else {
                apiResponse.setData(loginResponse.getEndUserSession());
            }
        } catch (Exception e) {
            logger.error("login发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;

    }

    /**
     * 销毁当前会话(登出)
     * @param apiRequest
     * @return
     */
    @RequestMapping(value="/v1/session/logout", method = RequestMethod.POST)
    public ApiResponse logout(ApiRequest apiRequest) {
        logger.info("paramJson=" + apiRequest.getParamJson());
        ApiResponse apiResponse = new ApiResponse();
        LogoutRequest logoutRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), LogoutRequest.class);
        //判断json格式参数是否有误
        if (logoutRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(logoutRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        try {
            LogoutResponse logoutResponse = sessionService
                .logout(logoutRequest.getEndUserId(), logoutRequest.getLoginChannel());
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(logoutResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, logoutResponse);
            } else {
                apiResponse.setData(logoutResponse.isSuccess());
            }
        } catch (Exception e) {
            logger.error("logout发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;

    }
}
