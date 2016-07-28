package com.wow.attribute.vo.request;

import com.wow.common.request.ApiRequest;

/**
 * Created by zhengzhiqing on 16/7/14.
 */
public class CategoryQueryRequest extends ApiRequest {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int categoryId;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}


