package com.wow.product.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;

import java.util.Date;

/**
 * Created by win7 on 2016/8/5.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class TopicResponse extends CommonResponse{

    private static final long serialVersionUID = 1L;

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

    public Boolean getAllowComment() {
        return isAllowComment;
    }

    public void setAllowComment(Boolean allowComment) {
        isAllowComment = allowComment;
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

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getTopicContentDetails() {
        return topicContentDetails;
    }

    public void setTopicContentDetails(String topicContentDetails) {
        this.topicContentDetails = topicContentDetails;
    }
}
