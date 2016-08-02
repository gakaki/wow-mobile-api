package com.wow.user.vo;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/16.
 */
public class LoginResponseVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String sessionToken;

    private String nickName;

    private Byte sex;

    private String avatar;

    private Byte ageRange;

    private String industry;

    private String selfIntroduction;

    private Byte constellation;

    private int productQtyInCart;

    private String mobile;

    public String getSessionToken() {
        return sessionToken;
    }

    public void setSessionToken(String sessionToken) {
        this.sessionToken = sessionToken;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Byte getSex() {
        return sex;
    }

    public void setSex(Byte sex) {
        this.sex = sex;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Byte getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(Byte ageRange) {
        this.ageRange = ageRange;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public Byte getConstellation() {
        return constellation;
    }

    public void setConstellation(Byte constellation) {
        this.constellation = constellation;
    }

    public int getProductQtyInCart() {
        return productQtyInCart;
    }

    public void setProductQtyInCart(int productQtyInCart) {
        this.productQtyInCart = productQtyInCart;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
