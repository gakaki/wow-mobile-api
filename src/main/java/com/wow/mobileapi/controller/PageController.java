package com.wow.mobileapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.mobileapi.constant.BizConstant;
import com.wow.mobileapi.response.page.PageBannerVo;
import com.wow.mobileapi.response.page.PageBannerVoResponse;
import com.wow.page.model.PageBannerConfig;
import com.wow.page.service.PageConfigService;
import com.wow.page.vo.response.PageBannerResponse;
import com.wow.page.vo.response.PageCategoryResponse;
import com.wow.page.vo.response.PageProductResponse;

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

        PageBannerVoResponse pageBannerVoResponse = new PageBannerVoResponse();
        List<PageBannerVo> carouselBanners = new ArrayList<>();
        List<PageBannerVo> bannerList = new ArrayList<>();

        try {
            PageBannerResponse pageBannerResponse = pageConfigService.getBannersByPageType(BizConstant.PAGE_TYPE_HOME);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(pageBannerResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, pageBannerResponse);
            } else {
                List<PageBannerConfig> pageBannerConfigList = pageBannerResponse.getPageBannerConfigList();

                for (PageBannerConfig pageBannerConfig : pageBannerConfigList) {
                    PageBannerVo pageBannerVo = new PageBannerVo();
                    pageBannerVo.setBannerImgSrc(pageBannerConfig.getBannerImgSrc());
                    pageBannerVo.setBannerLinkType(pageBannerConfig.getBannerLinkType());
                    pageBannerVo.setBannerLinkTargetId(pageBannerConfig.getBannerLinkTargetId());
                    pageBannerVo.setBannerLinkUrl(pageBannerConfig.getBannerLinkUrl());
                    if (pageBannerConfig.getPageModuleType() == BizConstant.PAGE_MODULE_TYPE_BANNER_CAROUSEL) {
                        carouselBanners.add(pageBannerVo);
                    } else if (pageBannerConfig.getPageModuleType() == BizConstant.PAGE_MODULE_TYPE_BANNER_LIST) {
                        bannerList.add(pageBannerVo);
                    }
                }

                pageBannerVoResponse.setBannerList(bannerList);
                pageBannerVoResponse.setCarouselBanners(carouselBanners);

                apiResponse.setData(pageBannerVoResponse);
            }
        } catch (Exception e) {
            logger.error("查找Banner错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
    
    @RequestMapping(value = "/v1/page/find/product", method = RequestMethod.GET)
    public ApiResponse getProductOnFindPage(ApiRequest apiRequest) {
        logger.info("start to get product_find on page");
        ApiResponse apiResponse = new ApiResponse();

        try {
        	// 根据分类，将产品的上新和单品分别放入两个list中返回给前台调用
        	PageProductResponse pageProductsResponse = pageConfigService.getProductsOnPage(BizConstant.PAGE_TYPE_FIND,BizConstant.PAGE_MODULE_TYPE_PRODUCT,BizConstant.PAGE_MODULE_TYPE_PRODUCT_NEWARRIVAL);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(pageProductsResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, pageProductsResponse);
            } else {
                apiResponse.setData(pageProductsResponse.getPageProductVoList());
            }
        } catch (Exception e) {
            logger.error("查找product_find错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
    
    @RequestMapping(value = "/v1/page/find/category", method = RequestMethod.GET)
    public ApiResponse getCategoryOnFindPage(ApiRequest apiRequest) {
        logger.info("start to get category_find on page");
        ApiResponse apiResponse = new ApiResponse();

        try {
        	PageCategoryResponse pageCategoryResponse = pageConfigService.getCategoriesOnPage(BizConstant.PAGE_TYPE_FIND,BizConstant.PAGE_CATEGORY_LEVEL);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(pageCategoryResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, pageCategoryResponse);
            } else {
                apiResponse.setData(pageCategoryResponse.getPageCategoryVoList());
            }
        } catch (Exception e) {
            logger.error("查找category_find错误---" + e);
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