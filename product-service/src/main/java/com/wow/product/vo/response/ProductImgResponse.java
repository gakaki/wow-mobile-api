package com.wow.product.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.product.vo.request.ProductImgVo;

import java.util.List;

/**
 * Created by fangying@wowdsgn on 2016/7/14.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductImgResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    List<ProductImgVo> productImgVoList;

    public List<ProductImgVo> getProductImgVoList() {
        return productImgVoList;
    }

    public void setProductImgVoList(List<ProductImgVo> productImgVoList) {
        this.productImgVoList = productImgVoList;
    }
}
