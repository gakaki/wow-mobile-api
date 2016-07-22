package com.wow.product.vo.request;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by zhengzhiqing on 16/7/21.
 */
public class SpecVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String spec;
    private BigDecimal sellPrice;
    private BigDecimal activityPrice;
    private BigDecimal costPrice;
    private BigDecimal weight;
    private byte arrivalLatency;
    private boolean enabled;

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public BigDecimal getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(BigDecimal sellPrice) {
        this.sellPrice = sellPrice;
    }

    public BigDecimal getActivityPrice() {
        return activityPrice;
    }

    public void setActivityPrice(BigDecimal activityPrice) {
        this.activityPrice = activityPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public byte getArrivalLatency() {
        return arrivalLatency;
    }

    public void setArrivalLatency(byte arrivalLatency) {
        this.arrivalLatency = arrivalLatency;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
