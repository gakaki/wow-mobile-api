package com.wow.mobileapi.controller;


import com.wow.attribute.service.CategoryService;
import com.wow.attribute.vo.request.CategoryQueryRequest;
import com.wow.attribute.vo.response.CategoryListResponse;
import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController extends BaseController {

    private static final Logger logger = LoggerFactory.getLogger(CategoryController.class);

    @Autowired
    private CategoryService categoryService;

    /**
     * 获取二级子分类
     * @param apiRequest
     * @return
     */
    @RequestMapping(value = "/v1/category/sub-category", method = RequestMethod.GET)
    public ApiResponse getSecondCategoryList(ApiRequest apiRequest) {
        ApiResponse apiResponse = new ApiResponse();
        CategoryQueryRequest categoryQueryRequest = JsonUtil
                .fromJSON(apiRequest.getParamJson(), CategoryQueryRequest.class);
        //判断json格式参数是否有误
        if (categoryQueryRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        try {
            CategoryListResponse productResponse = categoryService.getSubCategory(categoryQueryRequest.getCategoryId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(productResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, productResponse);
            }else{
                apiResponse.setData(productResponse);
            }
        } catch (Exception e) {
            logger.error("获取二级子分类---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }
}