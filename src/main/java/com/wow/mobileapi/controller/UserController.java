package com.wow.mobileapi.controller;

import com.wow.user.model.EndUser;
import com.wow.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/user")
public class UserController {

    // 在Java类中创建 logger 实例
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public EndUser findUser(@PathVariable Integer id) {
        logger.info("get user, id=" + id);
        EndUser endUser = userService.getEndUserById(id);
        if (endUser == null) {
            endUser = new EndUser();
            endUser.setId(id);
            endUser.setNickName("nickname");
            endUser.setRealName("realname");
            endUser.setUserName("username");
        }
        return endUser;
    }
}