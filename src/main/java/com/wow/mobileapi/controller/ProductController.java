package com.wow.mobileapi.controller;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.StringUtil;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.request.product.ProductQueryRequest;
import com.wow.price.service.PriceService;
import com.wow.price.vo.ProductPriceResponse;
import com.wow.product.service.ProductSerialService;
import com.wow.product.service.ProductService;
import com.wow.product.vo.response.ProductResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);

    @Autowired
    private ProductService productService;

    @Autowired
    private ProductSerialService productSerialService;

    @Autowired
    private PriceService priceService;

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
            //获取产品基本信息
            ProductResponse productResponse = productService.getItemDetailById(productId);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(productResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, productResponse);
            } else {
                //产品价格(售价和原价)
                ProductPriceResponse productPriceResponse = priceService.getProductPrice(productId);
                if (productPriceResponse != null && productPriceResponse.getProductPrice() != null) {
                    productResponse.setSellPrice(productPriceResponse.getProductPrice().getSellPrice());
                    productResponse.setOriginalPrice(productPriceResponse.getProductPrice().getOriginalPrice());
                } else {
                    //TODO 价格异常
                }

                apiResponse.setData(productResponse);
            }
        } catch (Exception e) {
            logger.error("查找产品详情发生错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 系列品规格选择页详细信息
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/product/spec", method = RequestMethod.GET)
    public ApiResponse getItemSpecInfo(ApiRequest apiRequest) {
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
            //TODO
            //获取系列品所有子品
            //获取各子品的基本信息(颜色,规格,名称,尺寸,重量),价格(销售价),库存,图片等
            //做成适合前端展示的数据结构
        } catch (Exception e) {
            logger.error("查找产品规格发生错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
}