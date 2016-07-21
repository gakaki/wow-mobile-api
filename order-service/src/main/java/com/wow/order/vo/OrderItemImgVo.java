package com.wow.order.vo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 订单项目图片vo
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月15日 下午6:21:56 Exp $
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class OrderItemImgVo implements Serializable {
    /**  */
    private static final long serialVersionUID = 1L;

    //订单id
    private Integer saleOrderId;

    //产品名称
    private String specImg;

    public Integer getSaleOrderId() {
        return saleOrderId;
    }

    public void setSaleOrderId(Integer saleOrderId) {
        this.saleOrderId = saleOrderId;
    }

    public String getSpecImg() {
        return specImg;
    }

    public void setSpecImg(String specImg) {
        this.specImg = specImg;
    }

}
