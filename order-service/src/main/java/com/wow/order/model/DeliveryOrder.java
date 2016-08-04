package com.wow.order.model;

import java.io.Serializable;
import java.util.Date;

public class DeliveryOrder implements Serializable {
    private Integer id;

    private Integer saleOrderId;

    private Byte deliveryMothod;

    private String deliveryCompanyCode;

    private String deliveryCompanyName;

    private String deliveryOrderNo;

    private Date shipOutDate;

    private Date createTime;

    private String createBy;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(Integer saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public Byte getDeliveryMothod() {
        return deliveryMothod;
    }

    public void setDeliveryMothod(Byte deliveryMothod) {
        this.deliveryMothod = deliveryMothod;
    }

    public String getDeliveryCompanyCode() {
        return deliveryCompanyCode;
    }

    public void setDeliveryCompanyCode(String deliveryCompanyCode) {
        this.deliveryCompanyCode = deliveryCompanyCode == null ? null : deliveryCompanyCode.trim();
    }

    public String getDeliveryCompanyName() {
        return deliveryCompanyName;
    }

    public void setDeliveryCompanyName(String deliveryCompanyName) {
        this.deliveryCompanyName = deliveryCompanyName == null ? null : deliveryCompanyName.trim();
    }

    public String getDeliveryOrderNo() {
        return deliveryOrderNo;
    }

    public void setDeliveryOrderNo(String deliveryOrderNo) {
        this.deliveryOrderNo = deliveryOrderNo == null ? null : deliveryOrderNo.trim();
    }

    public Date getShipOutDate() {
        return shipOutDate;
    }

    public void setShipOutDate(Date shipOutDate) {
        this.shipOutDate = shipOutDate;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", saleOrderId=").append(saleOrderId);
        sb.append(", deliveryMothod=").append(deliveryMothod);
        sb.append(", deliveryCompanyCode=").append(deliveryCompanyCode);
        sb.append(", deliveryCompanyName=").append(deliveryCompanyName);
        sb.append(", deliveryOrderNo=").append(deliveryOrderNo);
        sb.append(", shipOutDate=").append(shipOutDate);
        sb.append(", createTime=").append(createTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}