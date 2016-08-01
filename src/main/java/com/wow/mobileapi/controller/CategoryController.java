package com.wow.mobileapi.controller;


import com.wow.attribute.model.Category;
import com.wow.attribute.service.CategoryService;
import com.wow.attribute.vo.request.CategoryQueryRequest;
import com.wow.attribute.vo.response.CategoryListResponse;
import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.JsonUtil;
import com.wow.mobileapi.response.category.SubCategory;
import com.wow.mobileapi.response.category.SubCategoryResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

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
        SubCategoryResponse subCategoryResponse = new SubCategoryResponse();
        CategoryQueryRequest categoryQueryRequest = JsonUtil
                .fromJSON(apiRequest.getParamJson(), CategoryQueryRequest.class);
        //判断json格式参数是否有误
        if (categoryQueryRequest == null) {
            setParamJsonParseErrorResponse(apiResponse);
            return apiResponse;
        }

        try {
            CategoryListResponse categoryListResponse = categoryService.getSubCategory(categoryQueryRequest.getCategoryId());
            //如果处理失败 则返回错误信息
            if (ErrorCodeUtil.isFailedResponse(categoryListResponse.getResCode())) {
                setServiceErrorResponse(apiResponse, categoryListResponse);
            }else{
                List<SubCategory> subCategoryList = new ArrayList<>();
                for (Category category: categoryListResponse.getCategoryList()) {
                    SubCategory subCategory = new SubCategory();
                    subCategory.setId(category.getId());
                    subCategory.setCategoryName(category.getCategoryName());
                    subCategory.setCategoryLevel(category.getCategoryLevel());
                    subCategoryList.add(subCategory);
                }
                subCategoryResponse.setSubCategoryList(subCategoryList);
                apiResponse.setData(subCategoryResponse);
            }
        } catch (Exception e) {
            logger.error("获取二级子分类---" + e);
            e.printStackTrace();
            setInternalErrorResponse(apiResponse);
        }

        return apiResponse;
    }
}