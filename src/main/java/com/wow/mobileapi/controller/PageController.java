package com.wow.mobileapi.controller;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.mobileapi.constant.BizConstant;
import com.wow.page.service.PageConfigService;
import com.wow.page.vo.response.PageBannerResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhengzhiqing on 16/6/23.
 */
@RestController
public class PageController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private PageConfigService pageConfigService;

    @RequestMapping(value = "/v1/page/banners", method = RequestMethod.GET)
    public ApiResponse getBannersOnHomePage(ApiRequest apiRequest) {
        logger.info("start to get banners on page");
        ApiResponse apiResponse = new ApiResponse();

        try {
            PageBannerResponse pageBannerResponse = pageConfigService.getBannersByPageType(BizConstant.PAGE_TYPE_HOME);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(pageBannerResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, pageBannerResponse);
            } else {
                apiResponse.setData(pageBannerResponse.getPageBannerConfigList());
            }
        } catch (Exception e) {
            logger.error("查找Banner错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

//    @RequestMapping(value = "/v1/page/scenes", method = RequestMethod.GET)
//    public ApiResponse getScenesOnHomePage(ApiRequest apiRequest) {
//        logger.info("start to get scenes on page");
//        ApiResponse apiResponse = new ApiResponse();
//
//        try {
//            PageSceneResponse pageSceneResponse = pageConfigService.getScenesByPageType(BizConstant.PAGE_TYPE_HOME);
//            //如果处理失败 则返回错误信息
//            if (ErrorCodeUtil.isFailedResponse(pageSceneResponse.getResCode())) {
//                setServiceErrorResponse(apiResponse, pageSceneResponse);
//            } else {
//                apiResponse.setData(pageSceneResponse.getSceneList());
//            }
//        } catch (Exception e) {
//            logger.error("查找Scene错误---" + e);
//            setInternalErrorResponse(apiResponse);
//        }
//
//        return apiResponse;
//    }
//
//    @RequestMapping(value = "/v1/page/topics", method = RequestMethod.GET)
//    public ApiResponse getTopicsOnHomePage(ApiRequest apiRequest) {
//        logger.info("start to get topics on page");
//
//        ApiResponse apiResponse = new ApiResponse();
//
//        try {
//            PageTopicResponse pageTopicResponse = pageConfigService.getTopicsByPageType(BizConstant.PAGE_TYPE_HOME);
//            //如果处理失败 则返回错误信息
//            if (ErrorCodeUtil.isFailedResponse(pageTopicResponse.getResCode())) {
//                setServiceErrorResponse(apiResponse, pageTopicResponse);
//            } else {
//                apiResponse.setData(pageTopicResponse.getPageTopicVoList());
//            }
//        } catch (Exception e) {
//            logger.error("查找Topic错误---" + e);
//            setInternalErrorResponse(apiResponse);
//        }
//
//        return apiResponse;
//    }
}