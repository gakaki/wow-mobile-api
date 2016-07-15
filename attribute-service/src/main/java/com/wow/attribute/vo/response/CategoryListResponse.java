package com.wow.attribute.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.attribute.model.Category;
import com.wow.common.response.CommonResponse;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/14.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CategoryListResponse extends CommonResponse {

    private List<Category> categoryList;

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
