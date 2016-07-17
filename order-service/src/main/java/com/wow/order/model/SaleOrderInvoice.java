package com.wow.order.model;

import java.io.Serializable;

public class SaleOrderInvoice implements Serializable {
    private Integer id;

    private Integer endUserId;

    private Integer orderId;

    private Byte invoiceType;

    private Byte invoiceMethod;

    private String invoiceTitle;

    private Boolean needProductList;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Byte getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Byte invoiceType) {
        this.invoiceType = invoiceType;
    }

    public Byte getInvoiceMethod() {
        return invoiceMethod;
    }

    public void setInvoiceMethod(Byte invoiceMethod) {
        this.invoiceMethod = invoiceMethod;
    }

    public String getInvoiceTitle() {
        return invoiceTitle;
    }

    public void setInvoiceTitle(String invoiceTitle) {
        this.invoiceTitle = invoiceTitle == null ? null : invoiceTitle.trim();
    }

    public Boolean getNeedProductList() {
        return needProductList;
    }

    public void setNeedProductList(Boolean needProductList) {
        this.needProductList = needProductList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", endUserId=").append(endUserId);
        sb.append(", orderId=").append(orderId);
        sb.append(", invoiceType=").append(invoiceType);
        sb.append(", invoiceMethod=").append(invoiceMethod);
        sb.append(", invoiceTitle=").append(invoiceTitle);
        sb.append(", needProductList=").append(needProductList);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}