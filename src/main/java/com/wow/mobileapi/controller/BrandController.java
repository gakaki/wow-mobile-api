package com.wow.mobileapi.controller;

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
import com.wow.mobileapi.request.product.ProductQueryRequest;
import com.wow.product.model.Brand;
import com.wow.product.service.BrandService;
import com.wow.product.vo.response.ProductBrandResponse;

/**
 * Created by zhengzhiqing on 16/6/23.
 */
@RestController
public class BrandController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(BrandController.class);

    @Autowired
    private BrandService brandService;

    /**
     * 查询品牌列表和品牌首字母列表
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/product/brand/list", method = RequestMethod.GET)
    public ApiResponse getProductBrandList(ApiRequest apiRequest) {
        logger.info("start to get productBrand_find on page");
        ApiResponse apiResponse = new ApiResponse();

        try {
        	ProductBrandResponse productBrandResponse = brandService.getAllBrands();
        	ProductBrandResponse productBrandFirstLetterResponse = brandService.selectBrandFirstLetter();
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(productBrandResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, productBrandResponse);
            }else if(ErrorCodeUtil.isFailedResponse(productBrandFirstLetterResponse.getResCode())){
            	setServiceErrorResponse(apiResponse, productBrandFirstLetterResponse);
            }else {
            	productBrandResponse.setBrandFirstLetterList(productBrandFirstLetterResponse.getBrandFirstLetterList());
                apiResponse.setData(productBrandResponse);
            }
        } catch (Exception e) {
            logger.error("查找productBrand_find错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
    
    /**
     * 查询品牌详情
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/product/brand/detail", method = RequestMethod.GET)
    public ApiResponse getProductBrandDetail(ApiRequest apiRequest) {
        logger.info("start to get productBrand_detail on page");
        ApiResponse apiResponse = new ApiResponse();
        ProductQueryRequest productQueryRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), ProductQueryRequest.class);
        
        try {
        	Brand brand = brandService.getBrandById(productQueryRequest.getBrandId());
            
        	ProductBrandResponse productBrandResponse = new ProductBrandResponse();
        	productBrandResponse.setBrand(brand);
            apiResponse.setData(productBrandResponse);
            
        } catch (Exception e) {
            logger.error("查找productBrand_detail错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
}