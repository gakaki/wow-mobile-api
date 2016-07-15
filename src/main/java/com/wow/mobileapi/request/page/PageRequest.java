package com.wow.mobileapi.request.page;

import com.wow.common.request.ApiRequest;

/**
 * Created by zhengzhiqing on 16/7/13.
 */
public class PageRequest extends ApiRequest {

    private int pageType;

    public int getPageType() {
        return pageType;
    }

    public void setPageType(int pageType) {
        this.pageType = pageType;
    }
}
