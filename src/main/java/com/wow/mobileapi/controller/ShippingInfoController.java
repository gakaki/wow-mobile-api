package com.wow.mobileapi.controller;


import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.response.CommonResponse;
import com.wow.common.util.BeanUtil;
import com.wow.common.util.JsonUtil;
import com.wow.user.model.ShippingInfo;
import com.wow.user.service.ShippingInfoService;
import com.wow.user.vo.request.ShippingInfoRequest;
import com.wow.user.vo.response.ShippingInfoListResponse;
import com.wow.user.vo.response.ShippingInfoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zhengzhiqing on 16/7/12.
 */
@RestController
public class ShippingInfoController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    ShippingInfoService shippingInfoService;

    /**
     * 创建/添加收货信息
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/shippinginfo/create", method = RequestMethod.POST)
    ApiResponse createShippingInfo(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        ShippingInfoRequest shippingInfoRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), ShippingInfoRequest.class);
        //判断json格式参数是否有误
        if (shippingInfoRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        ShippingInfo shippingInfo = new ShippingInfo();
        BeanUtil.copyProperties(shippingInfoRequest, shippingInfo);

        try {
            CommonResponse commonResponse = shippingInfoService.createShippingInfo(shippingInfo);
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("创建收货信息发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 更新收货信息
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/shippinginfo/update", method = RequestMethod.PUT)
    ApiResponse updateShippingInfo(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        ShippingInfoRequest shippingInfoRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), ShippingInfoRequest.class);
        //判断json格式参数是否有误
        if (shippingInfoRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        ShippingInfo shippingInfo = new ShippingInfo();
        BeanUtil.copyProperties(shippingInfoRequest, shippingInfo);

        try {
            CommonResponse commonResponse = shippingInfoService.updateShippingInfo(shippingInfo);
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("修改收货信息发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 删除收货信息
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/shippinginfo/delete", method = RequestMethod.DELETE)
    ApiResponse deleteShippingInfo(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        ShippingInfoRequest shippingInfoRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), ShippingInfoRequest.class);
        //判断json格式参数是否有误
        if (shippingInfoRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        ShippingInfo shippingInfo = new ShippingInfo();
        BeanUtil.copyProperties(shippingInfoRequest, shippingInfo);

        try {
            CommonResponse commonResponse = shippingInfoService.deleteShippingInfo(shippingInfo.getId());
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("删除收货信息发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 查询用户所有收货信息
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/shippinginfo/list", method = RequestMethod.GET)
    ApiResponse getShippingInfoByUserId(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        ShippingInfoRequest shippingInfoRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), ShippingInfoRequest.class);
        //判断json格式参数是否有误
        if (shippingInfoRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        ShippingInfo shippingInfo = new ShippingInfo();
        BeanUtil.copyProperties(shippingInfoRequest, shippingInfo);

        try {
            ShippingInfoListResponse shippingInfoListResponse = shippingInfoService.getShippingInfoByUserId(shippingInfo.getEndUserId());
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(shippingInfoListResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, shippingInfoListResponse);
            } else {
                apiResponse.setData(shippingInfoListResponse);
            }
        } catch (Exception e) {
            logger.error("查询所有收货信息发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 查询用户所有收货信息
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/shippinginfo/default", method = RequestMethod.GET)
    ApiResponse getDefaultShippingInfoByUserId(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        ShippingInfoRequest shippingInfoRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), ShippingInfoRequest.class);
        //判断json格式参数是否有误
        if (shippingInfoRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        ShippingInfo shippingInfo = new ShippingInfo();
        BeanUtil.copyProperties(shippingInfoRequest, shippingInfo);

        try {
            ShippingInfoResponse shippingInfoResponse = shippingInfoService.getDefaultShippingInfoByUserId(shippingInfo.getEndUserId());
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(shippingInfoResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, shippingInfoResponse);
            } else {
                apiResponse.setData(shippingInfoResponse);
            }
        } catch (Exception e) {
            logger.error("查询默认收货信息发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

}
