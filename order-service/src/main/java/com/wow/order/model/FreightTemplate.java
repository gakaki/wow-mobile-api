package com.wow.order.model;

import java.io.Serializable;

public class FreightTemplate implements Serializable {
    private Integer id;

    private Byte chargingRul;

    private Boolean isShippingFree;

    private Short shippingFreeMinAmount;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getChargingRul() {
        return chargingRul;
    }

    public void setChargingRul(Byte chargingRul) {
        this.chargingRul = chargingRul;
    }

    public Boolean getIsShippingFree() {
        return isShippingFree;
    }

    public void setIsShippingFree(Boolean isShippingFree) {
        this.isShippingFree = isShippingFree;
    }

    public Short getShippingFreeMinAmount() {
        return shippingFreeMinAmount;
    }

    public void setShippingFreeMinAmount(Short shippingFreeMinAmount) {
        this.shippingFreeMinAmount = shippingFreeMinAmount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", chargingRul=").append(chargingRul);
        sb.append(", isShippingFree=").append(isShippingFree);
        sb.append(", shippingFreeMinAmount=").append(shippingFreeMinAmount);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}