package com.wow.product.model;

import java.io.Serializable;

public class Designer implements Serializable {
    private Integer id;

    private String designerName;

    private Byte designerSex;

    private String designerCountry;

    private String designerHomeUrl;

    private String designerPhoto;

    private String designerVideo;

    private String designerDesc;

    private String designerStyle;

    private Boolean isActive;

    private Boolean isDeleted;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDesignerName() {
        return designerName;
    }

    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }

    public Byte getDesignerSex() {
        return designerSex;
    }

    public void setDesignerSex(Byte designerSex) {
        this.designerSex = designerSex;
    }

    public String getDesignerCountry() {
        return designerCountry;
    }

    public void setDesignerCountry(String designerCountry) {
        this.designerCountry = designerCountry;
    }

    public String getDesignerHomeUrl() {
        return designerHomeUrl;
    }

    public void setDesignerHomeUrl(String designerHomeUrl) {
        this.designerHomeUrl = designerHomeUrl;
    }

    public String getDesignerPhoto() {
        return designerPhoto;
    }

    public void setDesignerPhoto(String designerPhoto) {
        this.designerPhoto = designerPhoto;
    }

    public String getDesignerVideo() {
        return designerVideo;
    }

    public void setDesignerVideo(String designerVideo) {
        this.designerVideo = designerVideo;
    }

    public String getDesignerDesc() {
        return designerDesc;
    }

    public void setDesignerDesc(String designerDesc) {
        this.designerDesc = designerDesc;
    }

    public String getDesignerStyle() {
        return designerStyle;
    }

    public void setDesignerStyle(String designerStyle) {
        this.designerStyle = designerStyle;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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
        sb.append(", designerName=").append(designerName);
        sb.append(", designerSex=").append(designerSex);
        sb.append(", designerCountry=").append(designerCountry);
        sb.append(", designerHomeUrl=").append(designerHomeUrl);
        sb.append(", designerPhoto=").append(designerPhoto);
        sb.append(", designerVideo=").append(designerVideo);
        sb.append(", designerDesc=").append(designerDesc);
        sb.append(", designerStyle=").append(designerStyle);
        sb.append(", isActive=").append(isActive);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}