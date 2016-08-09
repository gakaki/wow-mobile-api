package com.wow.product.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.product.vo.ProductInTopicVo;
import com.wow.product.vo.ProductVo;

import java.util.List;

/**
 * Created by win7 on 2016/8/5.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ProductInTopicResponse extends CommonResponse{

    private static final long serialVersionUID = 1L;

    private List<ProductInTopicVo> productList;

    public List<ProductInTopicVo> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductInTopicVo> productList) {
        this.productList = productList;
    }
}
