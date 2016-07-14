package com.wow.attribute.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.attribute.model.Category;
import com.wow.common.response.CommonResponse;

/**
 * Created by zhengzhiqing on 16/7/14.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CategoryResponse extends CommonResponse {

    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
