package com.wow.page.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.page.vo.PageProductVo;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/13.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class PageProductResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private PageProductVo recommendProduct;
    private List<PageProductVo> pageNewProductVoList;

    public PageProductVo getRecommendProduct() {
        return recommendProduct;
    }

    public void setRecommendProduct(PageProductVo recommendProduct) {
        this.recommendProduct = recommendProduct;
    }

    public List<PageProductVo> getPageNewProductVoList() {
		return pageNewProductVoList;
	}

	public void setPageNewProductVoList(List<PageProductVo> pageNewProductVoList) {
		this.pageNewProductVoList = pageNewProductVoList;
	}
    
}
