package com.wow.mobileapi.controller;




import com.wow.mobileapi.dto.response.ApiResponse;
import com.wow.mobileapi.util.ResponseUtil;

import com.wow.page.service.PageService;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.wow.mobileapi.dto.response.ApiResponse;

/**
 * Created by zhengzhiqing on 16/6/23.
 */
@RestController
@RequestMapping("/v1/pages")
public class PageController {
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private PageService pageService;

    @Autowired
    private ResponseUtil responseUtil;

//    @RequestMapping(value = "/type/{pageType}/banners", method = RequestMethod.GET)
//    public ApiResponse getBannersOnPage(@PathVariable Integer pageType) {
//        logger.info("start to get banners on page");
//        ApiResponse apiResponse = new ApiResponse();
//        List<PageBannerConfig> bannerList = (List<PageBannerConfig>)pageService.getByPageType(pageType);
//        responseUtil.setResponse(apiResponse,"0");
//        apiResponse.setData(bannerList);
//        return apiResponse;
//    }
//    @RequestMapping(value = "/type/{pageType}/scenes", method = RequestMethod.GET)
//    public ApiResponse getScenesOnPage(@PathVariable Integer pageType) {
//        logger.info("start to get scenes on page");
//        ApiResponse apiResponse = new ApiResponse();
//        List<PageSceneConfig> sceneList = pageService.getByPageType(pageType);
//        List<Scene> scenes=new ArrayList<>();
//        sceneList.forEach(
//                new Consumer<PageSceneConfig>() {
//                    @Override
//                    public void accept(PageSceneConfig pageSceneConfig) {
//                        Scene scene= sceneService.getSceneById(pageSceneConfig.getSceneId());
//                        scene.setSceneImg("http://www.wowdsgn.com" + scene.getSceneImg());
//                        if(scene!=null)
//                            scenes.add(scene);
//                    }
//                });
//
//        responseUtil.setResponse(apiResponse,"0");
//        apiResponse.setData(scenes);
//        return apiResponse;
//    }

    @RequestMapping(value = "/type/{pageType}", method = RequestMethod.GET)
    public ApiResponse getTopicsOnPage(@PathVariable Integer pageType) {
        logger.info("start to get topics on page");
        ApiResponse apiResponse = new ApiResponse();
        Object topicList = pageService.getByPageType(pageType);
        responseUtil.setResponse(apiResponse,"0");
        apiResponse.setData(topicList);
        return apiResponse;
    }
}