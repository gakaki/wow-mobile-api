package com.wow.mobileapi.controller;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.StringUtil;
import com.wow.common.util.ValidatorUtil;
import com.wow.mobileapi.request.topic.TopicQueryRequest;
import com.wow.product.service.TopicService;
import com.wow.product.vo.response.TopicResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by win7 on 2016/8/4.
 */
@RestController
public class TopicController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(TopicController.class);

    @Autowired
    private TopicService topicService;

//    @RequestMapping(value="/v1/topic/queryAll",method = RequestMethod.GET)
//    public ApiResponse queryAllTopic(){
//        ApiResponse resp=new ApiResponse();
//        resp.setData(topicService.getAllTopics());
//        return resp;
//    }

    @RequestMapping(value="/v1/topic",method = RequestMethod.GET)
    public ApiResponse getTopicById(ApiRequest req){
        ApiResponse apiResponse=new ApiResponse();
        TopicQueryRequest topicQueryRequest = JsonUtil.fromJSON(req.getParamJson(), TopicQueryRequest.class);
        //判断json格式参数是否有误
        if (topicQueryRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        String errorMsg = ValidatorUtil.getError(topicQueryRequest);
        //如果校验错误 则返回
        if (StringUtil.isNotEmpty(errorMsg)) {
            setInvalidParameterResponse(apiResponse, errorMsg);
            return apiResponse;
        }

        try {
            TopicResponse topicResponse = topicService.getTopicById(topicQueryRequest.getTopicId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(topicResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, topicResponse);
                return apiResponse;
            } else {
                apiResponse.setData(topicResponse);
            }
        } catch (Exception e) {
            logger.error("查询专题出错", e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
}