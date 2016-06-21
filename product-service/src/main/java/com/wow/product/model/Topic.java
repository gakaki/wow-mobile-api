package com.wow.product.model;

import java.io.Serializable;
import java.util.Date;

public class Topic implements Serializable {
    private Integer id;

    private String topicName;

    private Boolean canShow;

    private String topicImg;

    private String topicImgLink;

    private String topicTitle;

    private String topicDesc;

    private Integer followNum;

    private Integer commentNum;

    private Integer shareNum;

    private Integer groupId;

    private Boolean isAllowComment;

    private Integer likeNum;

    private Byte productNumShowAlongWithTopic;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    private Boolean isDeleted;

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

    public Boolean getCanShow() {
        return canShow;
    }

    public void setCanShow(Boolean canShow) {
        this.canShow = canShow;
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

    public String getTopicTitle() {
        return topicTitle;
    }

    public void setTopicTitle(String topicTitle) {
        this.topicTitle = topicTitle;
    }

    public String getTopicDesc() {
        return topicDesc;
    }

    public void setTopicDesc(String topicDesc) {
        this.topicDesc = topicDesc;
    }

    public Integer getFollowNum() {
        return followNum;
    }

    public void setFollowNum(Integer followNum) {
        this.followNum = followNum;
    }

    public Integer getCommentNum() {
        return commentNum;
    }

    public void setCommentNum(Integer commentNum) {
        this.commentNum = commentNum;
    }

    public Integer getShareNum() {
        return shareNum;
    }

    public void setShareNum(Integer shareNum) {
        this.shareNum = shareNum;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Boolean getIsAllowComment() {
        return isAllowComment;
    }

    public void setIsAllowComment(Boolean isAllowComment) {
        this.isAllowComment = isAllowComment;
    }

    public Integer getLikeNum() {
        return likeNum;
    }

    public void setLikeNum(Integer likeNum) {
        this.likeNum = likeNum;
    }

    public Byte getProductNumShowAlongWithTopic() {
        return productNumShowAlongWithTopic;
    }

    public void setProductNumShowAlongWithTopic(Byte productNumShowAlongWithTopic) {
        this.productNumShowAlongWithTopic = productNumShowAlongWithTopic;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", topicName=").append(topicName);
        sb.append(", canShow=").append(canShow);
        sb.append(", topicImg=").append(topicImg);
        sb.append(", topicImgLink=").append(topicImgLink);
        sb.append(", topicTitle=").append(topicTitle);
        sb.append(", topicDesc=").append(topicDesc);
        sb.append(", followNum=").append(followNum);
        sb.append(", commentNum=").append(commentNum);
        sb.append(", shareNum=").append(shareNum);
        sb.append(", groupId=").append(groupId);
        sb.append(", isAllowComment=").append(isAllowComment);
        sb.append(", likeNum=").append(likeNum);
        sb.append(", productNumShowAlongWithTopic=").append(productNumShowAlongWithTopic);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}