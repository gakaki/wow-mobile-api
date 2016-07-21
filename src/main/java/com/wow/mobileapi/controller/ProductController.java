package com.wow.mobileapi.controller;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.StringUtil;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.request.product.ProductQueryRequest;
import com.wow.product.model.Brand;
import com.wow.product.service.BrandService;
import com.wow.product.service.ProductService;
import com.wow.product.vo.response.ProductResponse;
import com.wow.stock.vo.AvailableStockVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private BrandService brandService;
    @Autowired
    private ProductService productService;

    /**
     * 产品详情页
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/product", method = RequestMethod.GET)
    public ApiResponse getItemDetail(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        ProductQueryRequest productQueryRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), ProductQueryRequest.class);
        //判断json格式参数是否有误
        if (productQueryRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(productQueryRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        int productId = productQueryRequest.getProductId();

        try {
            ProductResponse productResponse = productService.getItemDetailById(productId);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(productResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, productResponse);
            } else {
                apiResponse.setData(productResponse);
            }
        } catch (Exception e) {
            logger.error("查找产品详情发生错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    @RequestMapping(value = "/v1/product/brand/{firstLetter}", method = RequestMethod.GET)
    public List<Brand> getBrandById(@PathVariable String firstLetter) {
        logger.info("firstLetter is:" + firstLetter);
        List<Brand> brandList = brandService.getBrandsByFirstLetter(firstLetter);
        logger.info("brandList:" + brandList);
        return brandList;
    }

}