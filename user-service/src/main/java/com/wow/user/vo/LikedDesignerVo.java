package com.wow.user.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/13.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class LikedDesignerVo implements Serializable{

    private static final long serialVersionUID = 1L;

    private int designerId;

    private String designerName;

    private String designerPhoto;

    public int getDesignerId() {
        return designerId;
    }

    public void setDesignerId(int designerId) {
        this.designerId = designerId;
    }

    public String getDesignerName() {
        return designerName;
    }

    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }

    public String getDesignerPhoto() {
        return designerPhoto;
    }

    public void setDesignerPhoto(String designerPhoto) {
        this.designerPhoto = designerPhoto;
    }
}
