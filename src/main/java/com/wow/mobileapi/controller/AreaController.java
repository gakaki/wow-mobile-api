package com.wow.mobileapi.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.JsonUtil;
import com.wow.mobileapi.request.area.AreaRequest;
import com.wow.mobileapi.response.area.AreaResponse;
import com.wow.product.model.Designer;
import com.wow.product.vo.response.ProductDesignerResponse;
import com.wow.user.model.Area;
import com.wow.user.service.AreaService;

/**
 * Created by zhengzhiqing on 16/7/10.
 */
@RestController
public class AreaController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(AreaController.class);

    @Autowired
    private AreaService areaService;

    /**
     * 查找次级区域
     * @param areaId
     * @return
     */
    @RequestMapping(value = "v1/areas/subareas", method = RequestMethod.GET)
    public ApiResponse findNextLevelArea(ApiRequest apiRequest) {
    	ApiResponse apiResponse = new ApiResponse();
        AreaRequest areaRequest = JsonUtil.fromJSON(apiRequest.getParamJson(), AreaRequest.class);
    	//判断json格式参数是否有误
        if (areaRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }
        
        try {
        	List<Area> areaList = areaService.getNextLevelArea(areaRequest.getAreaId());
            
        	AreaResponse areaResponse = new AreaResponse();
        	areaResponse.setAreaList(areaList);
            apiResponse.setData(areaResponse);
            
        } catch (Exception e) {
            logger.error("查找findNextLevelArea错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        
        return apiResponse;
    }

    /**
     * 查找一级区域
     * @return
     */
    @RequestMapping(value = "v1/areas/firstlevel", method = RequestMethod.GET)
    public ApiResponse findFirstLevelArea() {
    	
    	ApiResponse apiResponse = new ApiResponse();
    	
    	try {
        	List<Area> areaList = areaService.getFirstLevelArea();
            
        	AreaResponse areaResponse = new AreaResponse();
        	areaResponse.setAreaList(areaList);
            apiResponse.setData(areaResponse);
            
        } catch (Exception e) {
            logger.error("查找findFirstLevelArea错误---" + e);
            setInternalErrorResponse(apiResponse);
        }
        
        return apiResponse;
    }

}
