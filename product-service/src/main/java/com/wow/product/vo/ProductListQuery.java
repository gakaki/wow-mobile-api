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

    private Integer groupId;

    private Integer topicId;

    private int column;

    private int type;

    private String orderColumn;

    private String orderType;

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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getOrderColumn() {
        return orderColumn;
    }

    public void setOrderColumn(String orderColumn) {
        this.orderColumn = orderColumn;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }
}
