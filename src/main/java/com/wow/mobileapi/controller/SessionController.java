package com.wow.mobileapi.controller;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.response.CommonResponse;
import com.wow.common.util.*;
import com.wow.mobileapi.constant.ErrorCodeConstant;
import com.wow.mobileapi.request.user.LoginByWechatRequest;
import com.wow.mobileapi.request.user.LoginRequest;
import com.wow.mobileapi.util.HttpRequestUtil;
import com.wow.user.constant.ThirdPartyPlatformType;
import com.wow.user.service.SessionService;
import com.wow.user.service.UserService;
import com.wow.user.vo.LoginVo;
import com.wow.user.vo.ThirdPartyLoginVo;
import com.wow.user.vo.response.LoginResponse;
import com.wow.user.vo.response.TokenValidateResponse;
import com.wow.user.vo.response.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 登录、登出
 * Created by zhengzhiqing on 16/6/23.
 */
@RestController
public class SessionController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

    @Autowired
    private SessionService sessionService;

    @Autowired
    private UserService userService;

    /**
     * 普通登录
     * @param apiRequest
     * @return
     */
    @RequestMapping(value="/v1/session/login", method = RequestMethod.POST)
    public ApiResponse login(ApiRequest apiRequest, HttpServletRequest request) {

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

        LoginVo loginVo = new LoginVo();
        BeanUtil.copyProperties(loginRequest, loginVo);
        loginVo.setLoginChannel(apiRequest.getChannel());
        loginVo.setLoginIp(HttpRequestUtil.getIpAddr(request));
        loginVo.setUserAgent(HttpRequestUtil.getUserAgent(request));

        try {
            LoginResponse loginResponse = sessionService.login(loginVo);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(loginResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, loginResponse);
            } else {
                apiResponse.setData(loginResponse.getLoginResponseVo());
            }
        } catch (Exception e) {
            logger.error("login发生错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;

    }

    /**
     * 微信登录:根据微信ID判断该微信是否已经绑定手机。如果没有,直接返回未绑定。如果已绑定,进行微信登录。
     * @param apiRequest
     * @return
     */
    @RequestMapping(value="/v1/session/login/wechat", method = RequestMethod.POST)
    public ApiResponse loginByWechat(ApiRequest apiRequest, HttpServletRequest request) {

        ApiResponse apiResponse = new ApiResponse();
        LoginByWechatRequest loginByWechatRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), LoginByWechatRequest.class);
        //判断json格式参数是否有误
        if (loginByWechatRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(loginByWechatRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        String openId =loginByWechatRequest.getOpenId();
        //检查微信是否已绑定手机,如果没有,则直接返回未绑定,如果已经绑定,进行微信登录
        UserResponse userResponse = userService.getUserByOpenId(openId);
        logger.info("endUser:" + userResponse.getEndUser());
        if (userResponse ==null || userResponse.getEndUser() ==null) {
            ErrorResponseUtil.setErrorResponse(apiResponse, "50110");
            return apiResponse;
        }

        ThirdPartyLoginVo thirdPartyLoginVo = new ThirdPartyLoginVo();
        thirdPartyLoginVo.setThirdPartyPlatformType(ThirdPartyPlatformType.THIRD_PARTY_PLATFORM_WECHAT);
        thirdPartyLoginVo.setThirdPartyPlatformUserId(loginByWechatRequest.getOpenId());
        thirdPartyLoginVo.setLoginChannel(apiRequest.getChannel());
        thirdPartyLoginVo.setLoginIp(HttpRequestUtil.getIpAddr(request));
        thirdPartyLoginVo.setUserAgent(HttpRequestUtil.getUserAgent(request));

        try {
            LoginResponse loginResponse = sessionService.thirdPartyLogin(thirdPartyLoginVo);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(loginResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, loginResponse);
            } else {
                apiResponse.setData(loginResponse.getLoginResponseVo());
            }
        } catch (Exception e) {
            logger.error("微信登录发生错误---" + e);
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
        ApiResponse apiResponse = new ApiResponse();

        String errorMsg = checkTokenChannel(apiRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        String sessionToken = apiRequest.getSessionToken();
        byte channel = apiRequest.getChannel();

        TokenValidateResponse tokenValidateResponse = sessionService.isValidSessionToken(sessionToken, channel);
        if (tokenValidateResponse == null || ! tokenValidateResponse.isValid()) {
            ErrorResponseUtil.setErrorResponse(apiResponse, ErrorCodeConstant.INVALID_TOKEN);
            return apiResponse;
        }

        try {
            CommonResponse commonResponse = sessionService.logout(apiRequest.getSessionToken(), apiRequest.getChannel());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("logout发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
}
