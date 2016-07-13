package com.wow.page.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.page.vo.PageTopicVo;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/13.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PageTopicResponse extends CommonResponse {

    private List<PageTopicVo> pageTopicVoList;

    public List<PageTopicVo> getPageTopicVoList() {
        return pageTopicVoList;
    }

    public void setPageTopicVoList(List<PageTopicVo> pageTopicVoList) {
        this.pageTopicVoList = pageTopicVoList;
    }
}
