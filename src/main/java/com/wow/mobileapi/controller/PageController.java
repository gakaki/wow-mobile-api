package com.wow.mobileapi.controller;

import com.wow.common.util.RedisUtil;
import com.wow.mobileapi.dto.ApiResponse;
import com.wow.mobileapi.util.ResponseUtil;
import com.wow.page.model.PageBannerConfig;
import com.wow.page.model.PageSceneConfig;
import com.wow.page.model.PageTopicConfig;
import com.wow.page.service.PageConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/23.
 */
@RestController
@RequestMapping("/v1/pages")
public class PageController {
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private PageConfigService pageConfigService;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ResponseUtil responseUtil;

    @RequestMapping(value = "/type/{pageType}/banners", method = RequestMethod.GET)
    public ApiResponse getBannersOnPage(@PathVariable Integer pageType) {
        logger.info("start to get banners on page");
        ApiResponse apiResponse = new ApiResponse();
        List<PageBannerConfig> bannerList = pageConfigService.getBannersByPageType(pageType);
        responseUtil.setResponse(apiResponse,"0");
        apiResponse.setData(bannerList);
        return apiResponse;
    }

    @RequestMapping("/redis")
    public Object testRedis(){
        if (!redisUtil.exists("123")) {
            System.out.println("start to set 123 to redis");
            redisUtil.set("123", "测试");
        }
        return redisUtil.get("123");
    }


    @RequestMapping(value = "/type/{pageType}/scenes", method = RequestMethod.GET)
    public List<PageSceneConfig> getScenesOnPage(@PathVariable Integer pageType) {
        return null;
    }

    @RequestMapping(value = "/type/{pageType}/topics", method = RequestMethod.GET)
    public List<PageTopicConfig> getTopicsOnPage(@PathVariable Integer pageType) {
        return null;
    }
}
