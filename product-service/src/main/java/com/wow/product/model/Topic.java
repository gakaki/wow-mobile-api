package com.wow.product.model;

import java.io.Serializable;
import java.util.Date;

public class Topic implements Serializable {
    private Integer id;

    private String topicName;

    private String topicImg;

    private String topicImgLink;

    private String topicMainTitle;

    private String topicDesc;

    private Byte topicType;

    private Integer groupId;

    private Boolean canShow;

    private Byte productQtyShowAlongWithTopic;

    private Boolean isAllowComment;

    private Integer commentQty;

    private Integer followQty;

    private Integer shareQty;

    private Integer likeQty;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private Boolean isDeleted;

    private String topicContentDetails;

    private static final long serialVersionUID = 1L;

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

    public Boolean getCanShow() {
        return canShow;
    }

    public void setCanShow(Boolean canShow) {
        this.canShow = canShow;
    }

    public Byte getProductQtyShowAlongWithTopic() {
        return productQtyShowAlongWithTopic;
    }

    public void setProductQtyShowAlongWithTopic(Byte productQtyShowAlongWithTopic) {
        this.productQtyShowAlongWithTopic = productQtyShowAlongWithTopic;
    }

    public Boolean getIsAllowComment() {
        return isAllowComment;
    }

    public void setIsAllowComment(Boolean isAllowComment) {
        this.isAllowComment = isAllowComment;
    }

    public Integer getCommentQty() {
        return commentQty;
    }

    public void setCommentQty(Integer commentQty) {
        this.commentQty = commentQty;
    }

    public Integer getFollowQty() {
        return followQty;
    }

    public void setFollowQty(Integer followQty) {
        this.followQty = followQty;
    }

    public Integer getShareQty() {
        return shareQty;
    }

    public void setShareQty(Integer shareQty) {
        this.shareQty = shareQty;
    }

    public Integer getLikeQty() {
        return likeQty;
    }

    public void setLikeQty(Integer likeQty) {
        this.likeQty = likeQty;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getTopicContentDetails() {
        return topicContentDetails;
    }

    public void setTopicContentDetails(String topicContentDetails) {
        this.topicContentDetails = topicContentDetails;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", topicName=").append(topicName);
        sb.append(", topicImg=").append(topicImg);
        sb.append(", topicImgLink=").append(topicImgLink);
        sb.append(", topicMainTitle=").append(topicMainTitle);
        sb.append(", topicDesc=").append(topicDesc);
        sb.append(", topicType=").append(topicType);
        sb.append(", groupId=").append(groupId);
        sb.append(", canShow=").append(canShow);
        sb.append(", productQtyShowAlongWithTopic=").append(productQtyShowAlongWithTopic);
        sb.append(", isAllowComment=").append(isAllowComment);
        sb.append(", commentQty=").append(commentQty);
        sb.append(", followQty=").append(followQty);
        sb.append(", shareQty=").append(shareQty);
        sb.append(", likeQty=").append(likeQty);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", topicContentDetails=").append(topicContentDetails);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}