package com.wow.mobileapi.controller;

import com.wow.mobileapi.dto.ApiResponse;
import com.wow.mobileapi.util.ResponseUtil;
import com.wow.user.service.SessionService;
import com.wow.user.vo.LoginRequest;
import com.wow.user.vo.LoginResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * 登录、登出
 * Created by zhengzhiqing on 16/6/23.
 */
@RestController
@RequestMapping("/v1/sessions")
public class SessionController {

    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

    @Autowired
    private SessionService sessionService;

    /**
     * 创建新的会话(登入)
     * @param loginRequest
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ApiResponse login(@Validated @RequestBody LoginRequest loginRequest) {
        ApiResponse apiResponse = new ApiResponse();
        LoginResult loginResult = sessionService.login(loginRequest);
        if (loginResult.isValidUser()) {
            ResponseUtil.setResponse(apiResponse,"0");
            apiResponse.setData(loginResult.getEndUserSession());
        } else {
            ResponseUtil.setResponse(apiResponse,"40201");
            apiResponse.setData(loginResult.getEndUserSession());
        }
        return apiResponse;
    }

    /**
     * 销毁当前会话(登出)
     * @param endUserId
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public ApiResponse logout(@PathVariable Integer endUserId, @PathVariable byte loginChannel) {
        ApiResponse apiResponse = new ApiResponse();
        boolean isSuccess = (sessionService.logout(endUserId,loginChannel)==1);
        ResponseUtil.setResponse(apiResponse,"0");
        apiResponse.setData(isSuccess);
        return apiResponse;
    }
}
