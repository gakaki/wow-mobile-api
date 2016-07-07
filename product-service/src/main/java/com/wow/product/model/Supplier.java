package com.wow.product.model;

import java.io.Serializable;
import java.util.Date;

public class Supplier implements Serializable {
    private Integer id;

    private String supplierName;

    private String companyName;

    private String siteUrl;

    private Integer supplierAreaId;

    private String address;

    private String shipAddress;

    private String fax;

    private String purchaseOwner;

    private String remark;

    private String contactName;

    private String contactPhone;

    private String contactMobile;

    private String contactEmail;

    private String contactQq;

    private String openAccountBank;

    private String bankAccountNo;

    private String taxNo;

    private String payLatency;

    private Boolean isActive;

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

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName == null ? null : companyName.trim();
    }

    public String getSiteUrl() {
        return siteUrl;
    }

    public void setSiteUrl(String siteUrl) {
        this.siteUrl = siteUrl == null ? null : siteUrl.trim();
    }

    public Integer getSupplierAreaId() {
        return supplierAreaId;
    }

    public void setSupplierAreaId(Integer supplierAreaId) {
        this.supplierAreaId = supplierAreaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getShipAddress() {
        return shipAddress;
    }

    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress == null ? null : shipAddress.trim();
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax == null ? null : fax.trim();
    }

    public String getPurchaseOwner() {
        return purchaseOwner;
    }

    public void setPurchaseOwner(String purchaseOwner) {
        this.purchaseOwner = purchaseOwner == null ? null : purchaseOwner.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName == null ? null : contactName.trim();
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone == null ? null : contactPhone.trim();
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile == null ? null : contactMobile.trim();
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail == null ? null : contactEmail.trim();
    }

    public String getContactQq() {
        return contactQq;
    }

    public void setContactQq(String contactQq) {
        this.contactQq = contactQq == null ? null : contactQq.trim();
    }

    public String getOpenAccountBank() {
        return openAccountBank;
    }

    public void setOpenAccountBank(String openAccountBank) {
        this.openAccountBank = openAccountBank == null ? null : openAccountBank.trim();
    }

    public String getBankAccountNo() {
        return bankAccountNo;
    }

    public void setBankAccountNo(String bankAccountNo) {
        this.bankAccountNo = bankAccountNo == null ? null : bankAccountNo.trim();
    }

    public String getTaxNo() {
        return taxNo;
    }

    public void setTaxNo(String taxNo) {
        this.taxNo = taxNo == null ? null : taxNo.trim();
    }

    public String getPayLatency() {
        return payLatency;
    }

    public void setPayLatency(String payLatency) {
        this.payLatency = payLatency == null ? null : payLatency.trim();
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
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
        this.createBy = createBy == null ? null : createBy.trim();
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
        this.updateBy = updateBy == null ? null : updateBy.trim();
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
        sb.append(", supplierName=").append(supplierName);
        sb.append(", companyName=").append(companyName);
        sb.append(", siteUrl=").append(siteUrl);
        sb.append(", supplierAreaId=").append(supplierAreaId);
        sb.append(", address=").append(address);
        sb.append(", shipAddress=").append(shipAddress);
        sb.append(", fax=").append(fax);
        sb.append(", purchaseOwner=").append(purchaseOwner);
        sb.append(", remark=").append(remark);
        sb.append(", contactName=").append(contactName);
        sb.append(", contactPhone=").append(contactPhone);
        sb.append(", contactMobile=").append(contactMobile);
        sb.append(", contactEmail=").append(contactEmail);
        sb.append(", contactQq=").append(contactQq);
        sb.append(", openAccountBank=").append(openAccountBank);
        sb.append(", bankAccountNo=").append(bankAccountNo);
        sb.append(", taxNo=").append(taxNo);
        sb.append(", payLatency=").append(payLatency);
        sb.append(", isActive=").append(isActive);
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