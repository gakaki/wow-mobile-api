package com.wow.mobileapi.controller;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.JsonUtil;
import com.wow.mobileapi.request.topic.TopicQueryRequest;
import com.wow.product.service.TopicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by win7 on 2016/8/4.
 */
@RestController
public class TopicController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(TopicController.class);

    @Autowired
    private TopicService topicService;

    @RequestMapping(value="/v1/topic/queryAll",method = RequestMethod.GET)
    public ApiResponse queryAllTopic(){
        ApiResponse resp=new ApiResponse();
        resp.setData(topicService.getAllTopics());
        return resp;
    }

    @RequestMapping(value="/v1/topic/queryById",method = RequestMethod.GET)
    public ApiResponse queryTopicById(ApiRequest req){
        ApiResponse resp=new ApiResponse();
        TopicQueryRequest topicQueryRequest = JsonUtil.fromJSON(req.getParamJson(), TopicQueryRequest.class);
        //判断json格式参数是否有误
        if (topicQueryRequest == null) {
            setParamJsonParseErrorResponse(resp);
            return resp;
        }
        resp.setData(topicService.getTopicById(topicQueryRequest.getId()));
        return resp;
    }
}
