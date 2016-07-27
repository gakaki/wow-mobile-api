package com.wow.mobileapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.StringUtil;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.request.product.ProductQueryRequest;
import com.wow.product.service.DesignerService;
import com.wow.product.vo.response.ProductDesignerResponse;

/**
 * Created by zhengzhiqing on 16/6/23.
 */
@RestController
public class DesignerController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(DesignerController.class);

    @Autowired
    private DesignerService designerService;

    /**
     * 查询设计师详情
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/product/designer/detail", method = RequestMethod.GET)
    public ApiResponse getProductDesignerDetail(ApiRequest apiRequest) {
        logger.info("start to get productDesigner_detail on page");
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

        try {
        	ProductDesignerResponse productDesignerResponse = designerService.getDesignerById(productQueryRequest.getDesignerId());
            
            apiResponse.setData(productDesignerResponse.getDesigner());
        } catch (Exception e) {
            logger.error("查找productDesigner_detail错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
}