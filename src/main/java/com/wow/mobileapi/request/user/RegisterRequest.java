package com.wow.mobileapi.request.user;

import com.wow.common.request.ApiRequest;

import java.util.Date;

/**
 * Created by zhengzhiqing on 16/7/6.
 */
public class RegisterRequest extends ApiRequest {

    private String captcha;

    private String mobile;

    private String password;

    private String userName;

    private String nickName;

    private String realName;

    private Byte sex;

    private String avatar;

    private String email;

    private String country;

    private String province;

    private String city;

    private String county;

    private String address;

    private Date dateOfBirth;

    private Byte ageRange;

    private Byte constellation;

    private String hobby;

    private Byte marriageStatus;

    private Boolean hasChild;

    private Integer annualIncome;

    private Byte educationLevel;

    private String industry;

    private String remarks;

    private String selfIntroduction;

    private Boolean signAgreement;

    public String getCaptcha() {
        return captcha;
    }

    public void setCaptcha(String captcha) {
        this.captcha = captcha;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Byte getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(Byte ageRange) {
        this.ageRange = ageRange;
    }

    public Byte getConstellation() {
        return constellation;
    }

    public void setConstellation(Byte constellation) {
        this.constellation = constellation;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Byte getMarriageStatus() {
        return marriageStatus;
    }

    public void setMarriageStatus(Byte marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    public Boolean getHasChild() {
        return hasChild;
    }

    public void setHasChild(Boolean hasChild) {
        this.hasChild = hasChild;
    }

    public Integer getAnnualIncome() {
        return annualIncome;
    }

    public void setAnnualIncome(Integer annualIncome) {
        this.annualIncome = annualIncome;
    }

    public Byte getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(Byte educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSelfIntroduction() {
        return selfIntroduction;
    }

    public void setSelfIntroduction(String selfIntroduction) {
        this.selfIntroduction = selfIntroduction;
    }

    public Boolean getSignAgreement() {
        return signAgreement;
    }

    public void setSignAgreement(Boolean signAgreement) {
        this.signAgreement = signAgreement;
    }
}
