package com.wow.product.model;

import java.io.Serializable;
import java.util.Date;

public class Warehouse implements Serializable {
    private Integer id;

    private String warehouseName;

    private String address;

    private String province;

    private String city;

    private String county;

    private String town;

    private Boolean isRealWarehouse;

    private Short capaicity;

    private Byte dailyOrderLimit;

    private Byte workerQty;

    private String adminName;

    private String adminMobile;

    private String adminPhone;

    private String adminEmail;

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

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public Boolean getIsRealWarehouse() {
        return isRealWarehouse;
    }

    public void setIsRealWarehouse(Boolean isRealWarehouse) {
        this.isRealWarehouse = isRealWarehouse;
    }

    public Short getCapaicity() {
        return capaicity;
    }

    public void setCapaicity(Short capaicity) {
        this.capaicity = capaicity;
    }

    public Byte getDailyOrderLimit() {
        return dailyOrderLimit;
    }

    public void setDailyOrderLimit(Byte dailyOrderLimit) {
        this.dailyOrderLimit = dailyOrderLimit;
    }

    public Byte getWorkerQty() {
        return workerQty;
    }

    public void setWorkerQty(Byte workerQty) {
        this.workerQty = workerQty;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminMobile() {
        return adminMobile;
    }

    public void setAdminMobile(String adminMobile) {
        this.adminMobile = adminMobile;
    }

    public String getAdminPhone() {
        return adminPhone;
    }

    public void setAdminPhone(String adminPhone) {
        this.adminPhone = adminPhone;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
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
        sb.append(", warehouseName=").append(warehouseName);
        sb.append(", address=").append(address);
        sb.append(", province=").append(province);
        sb.append(", city=").append(city);
        sb.append(", county=").append(county);
        sb.append(", town=").append(town);
        sb.append(", isRealWarehouse=").append(isRealWarehouse);
        sb.append(", capaicity=").append(capaicity);
        sb.append(", dailyOrderLimit=").append(dailyOrderLimit);
        sb.append(", workerQty=").append(workerQty);
        sb.append(", adminName=").append(adminName);
        sb.append(", adminMobile=").append(adminMobile);
        sb.append(", adminPhone=").append(adminPhone);
        sb.append(", adminEmail=").append(adminEmail);
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