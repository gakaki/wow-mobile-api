package com.wow.mobileapi.controller;

import com.wow.user.model.EndUserSession;
import com.wow.user.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
     * @param userName
     * @param password
     * @return
     */
    @RequestMapping(method = RequestMethod.POST)
    public EndUserSession login(@RequestParam String userName, @RequestParam String password) {
        logger.info("user login...");
        return loginService.login(userName, password);
    }

    /**
     * 销毁当前会话(登出)
     * @param endUserId
     * @return
     */
    @RequestMapping(method = RequestMethod.DELETE)
    public EndUserSession logout(@PathVariable Integer endUserId) {
        logger.info("user logout...");
        return loginService.logout(endUserId);
    }
}
