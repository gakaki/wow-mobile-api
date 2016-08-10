package com.wow.order.vo;

import com.wow.user.model.ShippingInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 订单请求,包含创建订单所需要的所有字段。用于生成订单(order)和订单项(order_item)
 * Created by zhengzhiqing on 16/6/16.
 */
public class OrderVo {

    private int endUserId;

    private ShippingInfo shippingInfo;

    private InvoiceVo invoiceVo;

    private List<PackageVo> packageList;

    private PaymentVo paymentVo;
    /**
     * 订单总金额=商品金额+运费
     */
    private BigDecimal orderTotalAmount;
    public int getEndUserId() {
        return endUserId;
    }
    public void setEndUserId(int endUserId) {
        this.endUserId = endUserId;
    }
    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }
    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }
    public InvoiceVo getInvoiceVo() {
        return invoiceVo;
    }
    public void setInvoiceVo(InvoiceVo invoiceVo) {
        this.invoiceVo = invoiceVo;
    }
    public List<PackageVo> getPackageList() {
        return packageList;
    }
    public void setPackageList(List<PackageVo> packageList) {
        this.packageList = packageList;
    }
    public PaymentVo getPaymentVo() {
        return paymentVo;
    }
    public void setPaymentVo(PaymentVo paymentVo) {
        this.paymentVo = paymentVo;
    }
    public BigDecimal getOrderTotalAmount() {
        return orderTotalAmount;
    }
    public void setOrderTotalAmount(BigDecimal orderTotalAmount) {
        this.orderTotalAmount = orderTotalAmount;
    }
    

}
