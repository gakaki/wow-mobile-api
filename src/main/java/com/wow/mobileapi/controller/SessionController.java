package com.wow.mobileapi.controller;

import com.wow.attribute.model.Attribute;
import com.wow.mobileapi.dto.ApiResponse;
import com.wow.mobileapi.util.ErrorRespUtil;
import com.wow.user.model.EndUserSession;
import com.wow.user.service.LoginService;
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
@RequestMapping("/v1.0/sessions")
public class SessionController {

    private static final Logger logger = LoggerFactory.getLogger(SessionController.class);

    @Autowired
    private LoginService loginService;

    /**
     * 创建新的会话(登入)
     * @param loginRequest
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public ApiResponse login(@Validated @RequestBody LoginRequest loginRequest) {
        ApiResponse apiResponse = new ApiResponse();
        logger.info("user login...");
        LoginResult loginResult = loginService.login(loginRequest);
        if (loginResult.isValidUser()) {
            apiResponse.setResCode("0");
            apiResponse.setResMsg("success");
            apiResponse.setData(loginResult.getEndUserSession());
        } else {
            ErrorRespUtil.setError(apiResponse,"40201");
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
    public ApiResponse logout(@PathVariable Integer endUserId) {
        ApiResponse apiResponse = new ApiResponse();
        logger.info("user logout...");
        EndUserSession endUserSession = loginService.logout(endUserId);
        apiResponse.setResCode("0");
        apiResponse.setResMsg("success");
        apiResponse.setData(endUserSession);
        return apiResponse;
    }
}
