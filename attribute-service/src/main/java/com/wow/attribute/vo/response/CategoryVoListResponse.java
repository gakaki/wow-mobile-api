package com.wow.attribute.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.attribute.vo.CategoryFirstVo;
import com.wow.attribute.vo.CategorySecondVo;
import com.wow.common.response.CommonResponse;

/**
 * Created by zhengzhiqing on 16/7/14.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class CategoryVoListResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

//	private CategoryFirstVo categoryFirstVo;
	
    private List<CategorySecondVo> categoryList;

    private String bgImg;
    
//    public CategoryFirstVo getCategoryFirstVo() {
//		return categoryFirstVo;
//	}
//
//	public void setCategoryFirstVo(CategoryFirstVo categoryFirstVo) {
//		this.categoryFirstVo = categoryFirstVo;
//	}

	public List<CategorySecondVo> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<CategorySecondVo> categoryList) {
        this.categoryList = categoryList;
    }

    public String getBgImg() {
        return bgImg;
    }

    public void setBgImg(String bgImg) {
        this.bgImg = bgImg;
    }
}
