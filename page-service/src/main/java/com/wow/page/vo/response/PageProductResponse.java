package com.wow.page.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.page.vo.PageProductNewVo;
import com.wow.page.vo.PageProductVo;

/**
 * Created by zhengzhiqing on 16/7/13.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PageProductResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<PageProductVo> pageProductVoList;
    private List<PageProductNewVo> pageNewProductVoList;

    public List<PageProductVo> getPageProductVoList() {
        return pageProductVoList;
    }

    public void setPageProductVoList(List<PageProductVo> pageProductVoList) {
        this.pageProductVoList = pageProductVoList;
    }

	public List<PageProductNewVo> getPageNewProductVoList() {
		return pageNewProductVoList;
	}

	public void setPageNewProductVoList(List<PageProductNewVo> pageNewProductVoList) {
		this.pageNewProductVoList = pageNewProductVoList;
	}
    
}
