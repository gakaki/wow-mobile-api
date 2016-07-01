package com.wow.user.controller;

import com.wow.user.model.EndUser;
import com.wow.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * Created by zhengzhiqing on 16/7/1.
 */
@RestController
public class UserTestController {

    private static final Logger logger = LoggerFactory.getLogger(UserTestController.class);

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param endUser
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String register(@Validated @RequestBody EndUser endUser) {
        String registerResult = "";
        //先根据用户名查找是否已经注册过
        if (userService.isExistedUser(endUser.getUserName())) {
            logger.info("existed user try to register...");
            registerResult = "您已经注册过,请直接登录";
        } else {
            logger.info("user register...");
            endUser.setIsDeleted(false);
            endUser.setRegisterTime(new Date());
            int i = userService.register(endUser);
            if (i > 0) {
                registerResult = "注册成功,请登录";
            } else {
                registerResult = "注册失败,请重试";
            }
        }
        return registerResult;
    }

    /**
     * 查询用户
     * @param endUserId
     * @return
     */
    @RequestMapping(value = "/users/{endUserId}", method = RequestMethod.GET)
    public EndUser selectUserById(@PathVariable Integer endUserId) {
        logger.info("getUser:" + endUserId);
        EndUser endUser = userService.getEndUserById(endUserId);
        logger.info("endUser=" + endUser);
        return endUser;
    }

}
