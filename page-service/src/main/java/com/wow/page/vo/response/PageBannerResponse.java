package com.wow.page.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.page.model.PageBannerConfig;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/13.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PageBannerResponse extends CommonResponse {

    private List<PageBannerConfig> pageBannerConfigList;

    public List<PageBannerConfig> getPageBannerConfigList() {
        return pageBannerConfigList;
    }

    public void setPageBannerConfigList(List<PageBannerConfig> pageBannerConfigList) {
        this.pageBannerConfigList = pageBannerConfigList;
    }
}
