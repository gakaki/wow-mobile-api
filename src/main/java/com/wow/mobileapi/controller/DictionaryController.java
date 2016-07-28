package com.wow.mobileapi.controller;

import com.wow.common.model.Dictionary;
import com.wow.common.model.DictionaryExample;
import com.wow.common.request.ApiRequest;
import com.wow.common.request.DictionaryRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.response.CommonResponse;
import com.wow.common.response.DictionaryResponse;
import com.wow.common.service.DictionaryService;
import com.wow.common.util.BeanUtil;
import com.wow.common.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by win7 on 2016/7/27.
 */
@RestController
@CrossOrigin(maxAge = 3600)
public class DictionaryController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(DictionaryController.class);

    @Autowired
    private DictionaryService dictionaryService;

    @RequestMapping(value="/v1/dictionary/add",method = RequestMethod.POST)
    public ApiResponse addDictionary(ApiRequest apiRequest){
        ApiResponse apiResponse = new ApiResponse();
        DictionaryRequest dictionaryRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), DictionaryRequest.class);
        try {
            Dictionary dictionary=new Dictionary();
            BeanUtil.copyProperties(dictionaryRequest,dictionary);
            int count=dictionaryService.createDictionary(dictionary);
            CommonResponse commonResponse = new CommonResponse();
            if(count==0) {
                commonResponse.setResCode("4000");
                commonResponse.setResMsg("字典信息增加失败");
            }
            apiResponse.setData(commonResponse);
        } catch (Exception e) {
            logger.error("字典信息增加addDictionary错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    @RequestMapping(value="/v1/dictionary/del",method = RequestMethod.POST)
    public ApiResponse delDictionary(ApiRequest apiRequest){
        ApiResponse apiResponse = new ApiResponse();
        DictionaryRequest dictionaryRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), DictionaryRequest.class);
        try {
            Dictionary dictionary=new Dictionary();
            BeanUtil.copyProperties(dictionaryRequest,dictionary);
            dictionary.setIsValid(false);
            int count=dictionaryService.updateDictionary(dictionary,dictionaryRequest);
            CommonResponse commonResponse = new CommonResponse();
            if(count==0) {
                commonResponse.setResCode("4000");
                commonResponse.setResMsg("字典信息删除失败");
            }
            apiResponse.setData(commonResponse);
        } catch (Exception e) {
            logger.error("字典信息删除delDictionary错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    @RequestMapping(value="/v1/dictionary/update",method = RequestMethod.POST)
    public ApiResponse updateDictionary(ApiRequest apiRequest){
        ApiResponse apiResponse = new ApiResponse();
        DictionaryRequest dictionaryRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), DictionaryRequest.class);
        try {
            Dictionary dictionary=new Dictionary();
            BeanUtil.copyProperties(dictionaryRequest,dictionary);
            int count=dictionaryService.updateDictionary(dictionary,dictionaryRequest);
            CommonResponse commonResponse = new CommonResponse();
            if(count==0) {
                commonResponse.setResCode("4000");
                commonResponse.setResMsg("字典信息更新失败");
            }
            apiResponse.setData(commonResponse);
        } catch (Exception e) {
            logger.error("字典信息更新updateDictionary错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }

    @RequestMapping(value="/v1/dictionary/query",method = RequestMethod.GET)
    public ApiResponse queryDictionary(ApiRequest apiRequest){
        ApiResponse apiResponse = new ApiResponse();
        DictionaryRequest dictionaryRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), DictionaryRequest.class);
        //判断json格式参数是否有误
        if (dictionaryRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        try {
            List<Dictionary> dictionaryList = dictionaryService.queryDictionary(dictionaryRequest);
            DictionaryResponse dictionaryResponse = new DictionaryResponse();
            dictionaryResponse.setDictionaryList(dictionaryList);
            apiResponse.setData(dictionaryResponse);
        } catch (Exception e) {
            logger.error("字典信息查找findNextLevelArea错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        return apiResponse;
    }
}
