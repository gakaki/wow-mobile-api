package com.wow.user.controller;

import com.wow.user.service.SessionService;
import com.wow.user.vo.LoginRequest;
import com.wow.user.vo.LoginResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhengzhiqing on 16/6/18.
 */
@RestController
public class SessionTestController {
    private static final Logger logger = LoggerFactory.getLogger(SessionTestController.class);

    @Autowired
    private SessionService sessionService;

    /**
     * 用户登录
     * @param loginRequest
     * @return
     */
    @RequestMapping(value = "/sessions", method = RequestMethod.POST)
    public LoginResult login(@Validated @RequestBody LoginRequest loginRequest) {
        logger.info("user login...");
        return sessionService.login(loginRequest);
    }

    /**
     * 用户登出
     * @param endUserId
     * @param loginChannel
     * @return
     */
    @RequestMapping(value = "/sessions/{endUserId}/{loginChannel}", method = RequestMethod.DELETE)
    public int logout(@PathVariable int endUserId, @PathVariable byte loginChannel) {
        logger.info("user logout...");
        return sessionService.logout(endUserId, loginChannel);
    }

    /**
     * 验证会话token
     * @param sessionToken
     * @param loginChannel
     * @return
     */
    @RequestMapping(value = "/sessions/validation/{sessionToken}/{loginChannel}", method = RequestMethod.GET)
    public boolean isValidSession(@PathVariable String sessionToken,
                                      @PathVariable byte loginChannel) {
        logger.info("is valid session?");
        return sessionService.isValidSessionToken(sessionToken, loginChannel);
    }
}