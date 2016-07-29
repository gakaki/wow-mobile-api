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
import com.wow.common.util.StringUtil;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.request.product.ProductQueryRequest;
import com.wow.product.service.DesignerService;
import com.wow.product.vo.response.ProductDesignerResponse;
import com.wow.product.vo.response.ProductDesignerVoResponse;

/**
 * Created by zhengzhiqing on 16/6/23.
 */
@RestController
public class DesignerController extends BaseController {
    private static final Logger logger = LoggerFactory.getLogger(DesignerController.class);

    @Autowired
    private DesignerService designerService;

    /**
     * 查询设计师列表
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/designer/list", method = RequestMethod.GET)
    public ApiResponse getProductDesignerList(ApiRequest apiRequest) {
        logger.info("start to get productDesigner_find on page");
        ApiResponse apiResponse = new ApiResponse();

        try {
        	ProductDesignerResponse productDesignerResponse = designerService.getAllDesigners();
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(productDesignerResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, productDesignerResponse);
            }else {
                apiResponse.setData(productDesignerResponse.getDesignerList());
            }
        } catch (Exception e) {
            logger.error("查找productDesigner_find错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
    
    /**
     * 查询设计师详情
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/designer/detail", method = RequestMethod.GET)
    public ApiResponse getProductDesignerDetail(ApiRequest apiRequest) {
        logger.info("start to get productDesigner_detail on page");
        ApiResponse apiResponse = new ApiResponse();
        ProductQueryRequest productQueryRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), ProductQueryRequest.class);

        //判断json格式参数是否有误
        if (productQueryRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        try {
        	ProductDesignerVoResponse productDesignerVoResponse = designerService.getDesignerVoById(productQueryRequest.getDesignerId());
        	//如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(productDesignerVoResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, productDesignerVoResponse);
            } else {
            	apiResponse.setData(productDesignerVoResponse);     
            }
        } catch (Exception e) {
            logger.error("查找productDesigner_detail错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
}