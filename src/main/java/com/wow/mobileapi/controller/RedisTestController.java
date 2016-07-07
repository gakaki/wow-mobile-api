package com.wow.mobileapi.controller;

import com.wow.common.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhengzhiqing on 16/7/7.
 */
@RestController
@RequestMapping("/v1/redis")
public class RedisTestController {

    @Autowired
    private RedisUtil redisUtil;

    private static final Logger logger = LoggerFactory.getLogger(RedisTestController.class);

    @RequestMapping("/redis")
    public Object testRedis(){
        if (!redisUtil.exists("123")) {
            System.out.println("start to set 123 to redis");
            redisUtil.set("123", "测试");
        }
        return redisUtil.get("123");
    }
}
