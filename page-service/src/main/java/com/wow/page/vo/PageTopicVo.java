package com.wow.page.vo;

import com.wow.product.model.ProductImage;
import com.wow.product.model.ProductShortListInTopic;
import com.wow.product.model.Topic;

import java.io.Serializable;
import java.util.List;

/**
 * Created by fangying@wowdsgn on 2016/7/8.
 */
public class PageTopicVo implements Serializable {
    private Integer id;
    private String topicName;
    private String topicImg;
    private String topicImgLink;
    private String topicMainTitle;
    private String topicDesc;
    private Byte topicType;
    private Integer groupId;
    private String topicContentDetails;
    private  List<ProductImageVo> productImageVos;

    @Override
    public String toString() {
        return "PageTopicVo{" +
                "id=" + id +
                ", topicName='" + topicName + '\'' +
                ", topicImg='" + topicImg + '\'' +
                ", topicImgLink='" + topicImgLink + '\'' +
                ", topicMainTitle='" + topicMainTitle + '\'' +
                ", topicDesc='" + topicDesc + '\'' +
                ", topicType=" + topicType +
                ", groupId=" + groupId +
                ", topicContentDetails='" + topicContentDetails + '\'' +
                ", images=" + productImageVos +
                '}';
    }


    public List<ProductImageVo> getImages() {
        return productImageVos;
    }

    public void setImages(List<ProductImageVo> images) {
        this.productImageVos = images;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopicName() {
        return topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    public String getTopicImg() {
        return topicImg;
    }

    public void setTopicImg(String topicImg) {
        this.topicImg = topicImg;
    }

    public String getTopicImgLink() {
        return topicImgLink;
    }

    public void setTopicImgLink(String topicImgLink) {
        this.topicImgLink = topicImgLink;
    }

    public String getTopicMainTitle() {
        return topicMainTitle;
    }

    public void setTopicMainTitle(String topicMainTitle) {
        this.topicMainTitle = topicMainTitle;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public Byte getTopicType() {
        return topicType;
    }

    public void setTopicType(Byte topicType) {
        this.topicType = topicType;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getTopicContentDetails() {
        return topicContentDetails;
    }

    public void setTopicContentDetails(String topicContentDetails) {
        this.topicContentDetails = topicContentDetails;
    }


}
