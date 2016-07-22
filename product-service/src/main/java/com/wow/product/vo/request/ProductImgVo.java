package com.wow.product.vo.request;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/21.
 */
public class ProductImgVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String imgUrl;

    private String imgDesc;

    private boolean isPrimary;

    private byte sortOrder;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgDesc() {
        return imgDesc;
    }

    public void setImgDesc(String imgDesc) {
        this.imgDesc = imgDesc;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }

    public byte getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(byte sortOrder) {
        this.sortOrder = sortOrder;
    }
}
