package com.wow.product.vo;

import com.wow.common.page.PageQuery;

import java.io.Serializable;

/**
 * Created by win7 on 2016/8/2.
 */
public class ProductListQuery extends PageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer brandId;

    private Integer designerId;

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getDesignerId() {
        return designerId;
    }

    public void setDesignerId(Integer designerId) {
        this.designerId = designerId;
    }
}
