package com.wow.mobileapi.controller;

import com.wow.mobileapi.dto.ApiResponse;
import com.wow.mobileapi.util.ResponseUtil;
import com.wow.page.model.PageBannerConfig;
import com.wow.page.model.PageSceneConfig;
import com.wow.page.model.PageTopicConfig;
import com.wow.page.service.PageConfigService;
import com.wow.product.model.Product;
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

    @RequestMapping(value = "/type/{pageType}/banners", method = RequestMethod.GET)
    public ApiResponse getBannersOnPage(@PathVariable Integer pageType) {
        logger.info("start to get banners on page");
        ApiResponse apiResponse = new ApiResponse();
        List<PageBannerConfig> bannerList = pageConfigService.getBannersByPageType(pageType);
        ResponseUtil.setResponse(apiResponse,"0");
        apiResponse.setData(bannerList);
        return apiResponse;
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
