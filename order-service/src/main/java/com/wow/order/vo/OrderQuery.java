package com.wow.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 创建订单查询类
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月17日 上午11:42:47 Exp $
 */
public class OrderQuery implements Serializable{
    /**  */
    private static final long serialVersionUID = 1L;

    //购物车id列表
    private List<Integer> shoppingCartIds;

    //用户id
    private Integer endUserId;

    //收货人地址id
    private Integer shippingInfoId;

    //优惠券id
    private Integer couponId;

    //订单总价 客户端传递 用以校验价格是否发生变化
    private BigDecimal totalPrice;

    //订单备注
    private String remark;

    public List<Integer> getShoppingCartIds() {
        return shoppingCartIds;
    }

    public void setShoppingCartIds(List<Integer> shoppingCartIds) {
        this.shoppingCartIds = shoppingCartIds;
    }

    public Integer getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
    }

    public Integer getShippingInfoId() {
        return shippingInfoId;
    }

    public void setShippingInfoId(Integer shippingInfoId) {
        this.shippingInfoId = shippingInfoId;
    }

    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
    

}
