package com.wow.mobileapi.response.product;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.product.vo.request.ProductImgVo;

import java.util.List;

/**
 * Created by fangying@wowdsgn on 2016/7/14.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductImageResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private List<ProductImgVo> productImgVoLit;

    public List<ProductImgVo> getProductImgVoLit() {
        return productImgVoLit;
    }

    public void setProductImgVoLit(List<ProductImgVo> productImgVoLit) {
        this.productImgVoLit = productImgVoLit;
    }
}
