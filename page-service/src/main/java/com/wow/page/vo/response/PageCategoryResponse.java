package com.wow.page.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.page.model.PageCategoryConfig;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/13.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PageCategoryResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<PageCategoryConfig> pageCategoryConfigList;

    public List<PageCategoryConfig> getPageCategoryConfigList() {
        return pageCategoryConfigList;
    }

    public void setPageCategoryConfigList(List<PageCategoryConfig> pageCategoryConfigList) {
        this.pageCategoryConfigList = pageCategoryConfigList;
    }
}
