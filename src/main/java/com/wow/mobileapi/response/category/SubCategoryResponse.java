package com.wow.mobileapi.response.category;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/8/1.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class SubCategoryResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<SubCategory> subCategoryList;

    public List<SubCategory> getSubCategoryList() {
        return subCategoryList;
    }

    public void setSubCategoryList(List<SubCategory> subCategoryList) {
        this.subCategoryList = subCategoryList;
    }
}
