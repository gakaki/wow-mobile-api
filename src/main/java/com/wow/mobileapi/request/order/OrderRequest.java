package com.wow.mobileapi.request.order;

import java.math.BigDecimal;
import java.util.List;

import com.wow.common.request.ApiRequest;

/**
 * 创建订单接口请求类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月12日 下午4:50:51 Exp $
 */
public class OrderRequest extends ApiRequest {

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
    private BigDecimal orderAmount;
    
    //订单来源  1:Androi 2：iOS 3：PC 11: 天猫订单 10:有赞 12: 苏宁
    private Byte orderSource;
    
    //订单备注
    private String remark;
    
    //客户端ip
    private String orderIp;
    
    public String getOrderIp() {
        return orderIp;
    }

    public void setOrderIp(String orderIp) {
        this.orderIp = orderIp;
    }

    public Byte getOrderSource() {
        return orderSource;
    }

    public void setOrderSource(Byte orderSource) {
        this.orderSource = orderSource;
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

    public BigDecimal getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(BigDecimal orderAmount) {
        this.orderAmount = orderAmount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
    }

    public List<Integer> getShoppingCartIds() {
        return shoppingCartIds;
    }

    public void setShoppingCartIds(List<Integer> shoppingCartIds) {
        this.shoppingCartIds = shoppingCartIds;
    }
}
