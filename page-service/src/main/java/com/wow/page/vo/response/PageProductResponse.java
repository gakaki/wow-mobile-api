package com.wow.page.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.page.model.PageProductConfig;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/13.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PageProductResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<PageProductConfig> pageProductConfigList;

    public List<PageProductConfig> getPageProductConfigList() {
        return pageProductConfigList;
    }

    public void setPageProductConfigList(List<PageProductConfig> pageProductConfigList) {
        this.pageProductConfigList = pageProductConfigList;
    }
}
