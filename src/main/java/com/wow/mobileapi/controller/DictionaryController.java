package com.wow.mobileapi.controller;

import java.util.List;

import com.wow.common.service.CountryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wow.common.constant.BizConstant;
import com.wow.common.model.Dictionary;
import com.wow.common.request.ApiRequest;
import com.wow.common.request.DictionaryRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.response.CommonResponse;
import com.wow.common.response.DictionaryResponse;
import com.wow.common.service.DictionaryService;
import com.wow.common.util.BeanUtil;
import com.wow.common.util.DictionaryUtil;
import com.wow.common.util.JsonUtil;

/**
 * Created by win7 on 2016/7/27.
 */
@RestController
@CrossOrigin(maxAge = 3600)
public class DictionaryController extends BaseController{

    private static final Logger logger = LoggerFactory.getLogger(DictionaryController.class);

    @Autowired
    private CountryService countryService;


    /**
     *
     * @param apiRequest
     * @return 返回国家信息
     */
    @RequestMapping(value="/v1/dictionary/query",method = RequestMethod.GET)
    public ApiResponse queryDictionary(ApiRequest apiRequest){
        ApiResponse apiResponse = new ApiResponse();
        apiResponse.setData(countryService.queryAllCountry());
        return apiResponse;
    }
}
