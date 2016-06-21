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

}
