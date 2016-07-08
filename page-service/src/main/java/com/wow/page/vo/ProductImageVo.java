package com.wow.page.vo;

/**
 * Created by fangying@wowdsgn on 2016/7/8.
 */
public class ProductImageVo {
    private Integer productId;

    private String imgName;

    private String imgUrl;

    private String imgDesc;

    private Integer groupId;

    private Byte viewPlatform;

    private Byte sortOrder;

    @Override
    public String toString() {
        return "ProductImageVo{" +
                "productId=" + productId +
                ", imgName='" + imgName + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", imgDesc='" + imgDesc + '\'' +
                ", groupId=" + groupId +
                ", viewPlatform=" + viewPlatform +
                ", sortOrder=" + sortOrder +
                '}';
    }


    public Byte getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Byte sortOrder) {
        this.sortOrder = sortOrder;
    }


    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

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

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Byte getViewPlatform() {
        return viewPlatform;
    }

    public void setViewPlatform(Byte viewPlatform) {
        this.viewPlatform = viewPlatform;
    }

}
