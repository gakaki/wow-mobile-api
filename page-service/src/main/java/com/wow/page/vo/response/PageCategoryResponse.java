package com.wow.page.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.page.vo.PageCategoryVo;

/**
 * Created by zhengzhiqing on 16/7/13.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PageCategoryResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<PageCategoryVo> pageCategoryVoList;

    public List<PageCategoryVo> getPageCategoryVoList() {
        return pageCategoryVoList;
    }

    public void setPageCategoryVoList(List<PageCategoryVo> pageCategoryVoList) {
        this.pageCategoryVoList = pageCategoryVoList;
    }
}
