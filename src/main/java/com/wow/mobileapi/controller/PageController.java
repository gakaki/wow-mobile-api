package com.wow.mobileapi.controller;

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
import com.wow.common.util.JsonUtil;
import com.wow.common.util.StringUtil;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.constant.BizConstant;
import com.wow.mobileapi.request.product.ProductInfoRequest;
import com.wow.page.service.PageConfigService;
import com.wow.page.vo.response.PageBannerResponse;
import com.wow.page.vo.response.PageCategoryResponse;
import com.wow.page.vo.response.PageProductResponse;
import com.wow.product.service.ProductService;
import com.wow.product.vo.ProductVo;

/**
 * Created by zhengzhiqing on 16/6/23.
 */
@RestController
public class PageController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(PageController.class);

    @Autowired
    private PageConfigService pageConfigService;
    @Autowired
    private ProductService productService;

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
    
    @RequestMapping(value = "/v1/page/find/product", method = RequestMethod.GET)
    public ApiResponse getProductOnFindPage(ApiRequest apiRequest) {
        logger.info("start to get product_find on page");
        ApiResponse apiResponse = new ApiResponse();

        try {
        	PageProductResponse pageProductsResponse = pageConfigService.getProductsOnPage(BizConstant.PAGE_TYPE_FIND);
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

    /**
     * 按分类查询产品列表
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/page/find/categroyProductList", method = RequestMethod.GET)
    public ApiResponse getProductListByCategory(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        ProductInfoRequest productInfoRequest = JsonUtil
                .fromJSON(apiRequest.getParamJson(), ProductInfoRequest.class);
            //判断json格式参数是否有误
            if (productInfoRequest == null) {
                setParamJsonParseErrorResponse(apiResponse);
                return apiResponse;
            }

            String errorMsg = ValidatorUtil.getError(productInfoRequest);
            //如果校验错误 则返回
            if (StringUtil.isNotEmpty(errorMsg)) {
                setInvalidParameterResponse(apiResponse, errorMsg);
                return apiResponse;
            }
        
        List<ProductVo> productList = productService.getProductByCategoryId(productInfoRequest.getCategoryId(), productInfoRequest.getSortBy(), productInfoRequest.getAsc());
        if (productList != null) {
            apiResponse.setResCode("0");
            apiResponse.setResMsg("Success");
            apiResponse.setData(productList);
        } else {
            apiResponse.setResCode("40201");
            apiResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40201"));
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