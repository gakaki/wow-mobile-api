package com.wow.mobileapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.BeanUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.StringUtil;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.request.user.VersionLogRequest;
import com.wow.user.service.VersionLogService;
import com.wow.user.vo.VersionLogQuery;
import com.wow.user.vo.response.VersionLogResponse;

/**
 * Created by zhengzhiqing on 16/7/2.
 */
@RestController
@RequestMapping(value = "/v1/version")
public class VersionController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(VersionController.class);

    @Autowired
    private VersionLogService versionLogService;

    /**
     * 检查版本更新
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "/check", produces = "application/json;charset=UTF-8", method = RequestMethod.GET)
    public ApiResponse checkVersion(ApiRequest request) {
        VersionLogRequest versionLogRequest = JsonUtil.fromJSON(request.getParamJson(), VersionLogRequest.class);
        ApiResponse apiResponse = new ApiResponse();
        //判断json格式参数是否有误
        if (versionLogRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(versionLogRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        try {
            VersionLogQuery versionLogQuery = new VersionLogQuery();
            BeanUtil.copyProperties(versionLogRequest, versionLogQuery);

            VersionLogResponse versionLogResponse = versionLogService.checkVersion(versionLogQuery);
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(versionLogResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, versionLogResponse);
            } else {
                apiResponse.setData(versionLogResponse);
            }
        } catch (Exception e) {
            logger.error("检查版本更新错误---", e);
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }

}