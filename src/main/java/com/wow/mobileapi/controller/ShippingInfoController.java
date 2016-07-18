package com.wow.mobileapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.response.CommonResponse;
import com.wow.common.util.BeanUtil;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.StringUtil;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.request.user.ShippingInfoRequest;
import com.wow.user.model.ShippingInfo;
import com.wow.user.service.ShippingInfoService;
import com.wow.user.vo.ShippingInfoResult;
import com.wow.user.vo.response.ShippingInfoListResponse;
import com.wow.user.vo.response.ShippingInfoResponse;

/**
 * Created by zhengzhiqing on 16/7/12.
 */
@RestController
public class ShippingInfoController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(ShippingInfoController.class);

    @Autowired
    ShippingInfoService shippingInfoService;

    /**
     * 创建/添加收货信息
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/shippinginfo/create", method = RequestMethod.POST)
    public ApiResponse createShippingInfo(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        ShippingInfoRequest shippingInfoRequest = JsonUtil
            .fromJSON(apiRequest.getParamJson(), ShippingInfoRequest.class);
        //判断json格式参数是否有误
        if (shippingInfoRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(shippingInfoRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        ShippingInfo shippingInfo = new ShippingInfo();
        BeanUtil.copyProperties(shippingInfoRequest, shippingInfo);

        //设置用户id
        shippingInfo.setEndUserId(35);

        try {
            CommonResponse commonResponse = shippingInfoService.createShippingInfo(shippingInfo);
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("创建收货信息发生错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 更新收货信息  有且仅有1个是默认
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/shippinginfo/update", method = RequestMethod.POST)
    public ApiResponse updateShippingInfo(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        ShippingInfoRequest shippingInfoRequest = JsonUtil
            .fromJSON(apiRequest.getParamJson(), ShippingInfoRequest.class);
        //判断json格式参数是否有误
        if (shippingInfoRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(shippingInfoRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        ShippingInfo shippingInfo = new ShippingInfo();
        BeanUtil.copyProperties(shippingInfoRequest, shippingInfo);

        //设置用户id
        shippingInfo.setEndUserId(30);

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
    @RequestMapping(value = "/v1/user/shippinginfo/delete", method = RequestMethod.POST)
    public ApiResponse deleteShippingInfo(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        ShippingInfoRequest shippingInfoRequest = JsonUtil
            .fromJSON(apiRequest.getParamJson(), ShippingInfoRequest.class);
        //判断json格式参数是否有误
        if (shippingInfoRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(shippingInfoRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        try {
            CommonResponse commonResponse = shippingInfoService.deleteShippingInfo(shippingInfoRequest.getId());
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
    public ApiResponse getShippingInfoByUserId(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        ShippingInfoRequest shippingInfoRequest = JsonUtil
            .fromJSON(apiRequest.getParamJson(), ShippingInfoRequest.class);
        //判断json格式参数是否有误
        if (shippingInfoRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(shippingInfoRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        Integer endUserId = 35;

        try {
            ShippingInfoListResponse shippingInfoListResponse = shippingInfoService.getShippingInfoByUserId(endUserId);
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(shippingInfoListResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, shippingInfoListResponse);
            } else {
                apiResponse.setData(shippingInfoListResponse.getShippingInfoResultList());
            }
        } catch (Exception e) {
            logger.error("查询所有收货信息发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

    /**
     * 查询用户默认收货地址
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/shippinginfo/default", method = RequestMethod.GET)
    public ApiResponse getDefaultShippingInfoByUserId(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        ShippingInfoRequest shippingInfoRequest = JsonUtil
            .fromJSON(apiRequest.getParamJson(), ShippingInfoRequest.class);
        //判断json格式参数是否有误
        if (shippingInfoRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(shippingInfoRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        //        ShippingInfo shippingInfo = new ShippingInfo();
        //        BeanUtil.copyProperties(shippingInfoRequest, shippingInfo);
        Integer endUserId = 35;

        try {
            ShippingInfoResponse shippingInfoResponse = shippingInfoService.getDefaultShippingInfoByUserId(endUserId);
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(shippingInfoResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, shippingInfoResponse);
            } else {
                ShippingInfoResult shippingInfoResult = new ShippingInfoResult();
                BeanUtil.copyProperties(shippingInfoResponse.getShippingInfo(), shippingInfoResult);

                apiResponse.setData(shippingInfoResult);
            }
        } catch (Exception e) {
            logger.error("查询默认收货信息发生错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    /**
     * 设置默认地址信息
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/user/shippinginfo/set-default", method = RequestMethod.POST)
    public ApiResponse setAsDefaultShippingInfo(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        ShippingInfoRequest shippingInfoRequest = JsonUtil
            .fromJSON(apiRequest.getParamJson(), ShippingInfoRequest.class);
        //判断json格式参数是否有误
        if (shippingInfoRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(shippingInfoRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        Integer endUserId = 30;

        try {
            CommonResponse commonResponse = shippingInfoService
                .setAsDefaultShippingInfo(shippingInfoRequest.getId(), endUserId);
            //如果处理失败 则返回错误信息
            if (!isServiceCallSuccess(commonResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, commonResponse);
            }
        } catch (Exception e) {
            logger.error("设置默认收货信息发生错误---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }
        
        return apiResponse;
    }

}
