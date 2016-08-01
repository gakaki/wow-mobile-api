package com.wow.order.vo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

import com.wow.stock.vo.FreezeStockVo;
import com.wow.user.model.ShippingInfo;
import com.wow.user.vo.ShoppingCartResultVo;

/**
 * 创建订单查询类
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月17日 上午11:42:47 Exp $
 */
public class OrderQuery implements Serializable {
    /**  */
    private static final long serialVersionUID = 1L;
    
    //用户订购的购物车id列表
    private List<Integer> shoppingCartIds;

    //用户id
    private Integer endUserId;

    //收货人地址id
    private Integer shippingInfoId;

    //优惠券id
    private Integer couponId;
    
    //订单总价 客户端传递 用以校验价格是否发生变化
    private BigDecimal orderAmount;

    //用户ip
    private String orderIp;

    //订单来源
    private Byte orderSource;

    //产品总金额
    private BigDecimal productAmount;

    //订单运费
    private BigDecimal deliveryfee;

    //订单优惠金额
    private BigDecimal couponFee;

    //订单备注
    private String remark;

    //用户购买的产品信息
    private List<ShoppingCartResultVo> shoppingCartResult;

    //锁定的产品库存信息
    private List<FreezeStockVo> freezeStockVoList;

    //用户收货地址信息
    private ShippingInfo shippingInfo;

    //订单id
    private Integer orderId;
    
    //总件数
    private Integer totalProductQty;
    
    public List<Integer> getShoppingCartIds() {
        return shoppingCartIds;
    }

    public void setShoppingCartIds(List<Integer> shoppingCartIds) {
        this.shoppingCartIds = shoppingCartIds;
    }

    public Integer getTotalProductQty() {
        return totalProductQty;
    }

    public void setTotalProductQty(Integer totalProductQty) {
        this.totalProductQty = totalProductQty;
    }

    public List<FreezeStockVo> getFreezeStockVoList() {
        return freezeStockVoList;
    }

    public void setFreezeStockVoList(List<FreezeStockVo> freezeStockVoList) {
        this.freezeStockVoList = freezeStockVoList;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

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

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }

    public BigDecimal getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(BigDecimal productAmount) {
        this.productAmount = productAmount;
    }

    public BigDecimal getDeliveryfee() {
        return deliveryfee;
    }

    public void setDeliveryfee(BigDecimal deliveryfee) {
        this.deliveryfee = deliveryfee;
    }

    public BigDecimal getCouponFee() {
        return couponFee;
    }

    public void setCouponFee(BigDecimal couponFee) {
        this.couponFee = couponFee;
    }

    public List<ShoppingCartResultVo> getShoppingCartResult() {
        return shoppingCartResult;
    }

    public void setShoppingCartResult(List<ShoppingCartResultVo> shoppingCartResult) {
        this.shoppingCartResult = shoppingCartResult;
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

}
