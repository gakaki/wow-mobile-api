package com.wow.user.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class EndUser implements Serializable {
    private Integer id;

    private String userName;

    private String password;

    private Byte memberLevel;

    private BigDecimal totalAmount;

    private Integer totalScore;

    private String nickName;

    private String realName;

    private Byte sex;

    private String avatar;

    private String country;

    private Date dateOfBirth;

    private Byte ageRange;

    private Byte constellation;

    private String mobile;

    private String email;

    private String hobby;

    private Byte marriageStatus;

    private Boolean hasChild;

    private Integer annualIncome;

    private Byte educationLevel;

    private String industry;

    private String remarks;

    private String selfIntroduction;

    private Boolean signAgreement;

    private Boolean isForbidden;

    private Date registerTime;

    private Date updateTime;

    private Boolean isDeleted;

    private String city;

    private String county;

    private String forbidReason;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Byte getMemberLevel() {
        return memberLevel;
    }

    public void setMemberLevel(Byte memberLevel) {
        this.memberLevel = memberLevel;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Boolean getIsForbidden() {
        return isForbidden;
    }

    public void setIsForbidden(Boolean isForbidden) {
        this.isForbidden = isForbidden;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Boolean getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
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

    public String getForbidReason() {
        return forbidReason;
    }

    public void setForbidReason(String forbidReason) {
        this.forbidReason = forbidReason;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", userName=").append(userName);
        sb.append(", password=").append(password);
        sb.append(", memberLevel=").append(memberLevel);
        sb.append(", totalAmount=").append(totalAmount);
        sb.append(", totalScore=").append(totalScore);
        sb.append(", nickName=").append(nickName);
        sb.append(", realName=").append(realName);
        sb.append(", sex=").append(sex);
        sb.append(", avatar=").append(avatar);
        sb.append(", country=").append(country);
        sb.append(", dateOfBirth=").append(dateOfBirth);
        sb.append(", ageRange=").append(ageRange);
        sb.append(", constellation=").append(constellation);
        sb.append(", mobile=").append(mobile);
        sb.append(", email=").append(email);
        sb.append(", hobby=").append(hobby);
        sb.append(", marriageStatus=").append(marriageStatus);
        sb.append(", hasChild=").append(hasChild);
        sb.append(", annualIncome=").append(annualIncome);
        sb.append(", educationLevel=").append(educationLevel);
        sb.append(", industry=").append(industry);
        sb.append(", remarks=").append(remarks);
        sb.append(", selfIntroduction=").append(selfIntroduction);
        sb.append(", signAgreement=").append(signAgreement);
        sb.append(", isForbidden=").append(isForbidden);
        sb.append(", registerTime=").append(registerTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", isDeleted=").append(isDeleted);
        sb.append(", city=").append(city);
        sb.append(", county=").append(county);
        sb.append(", forbidReason=").append(forbidReason);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}