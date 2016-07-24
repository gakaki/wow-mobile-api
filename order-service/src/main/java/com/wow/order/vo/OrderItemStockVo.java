package com.wow.order.vo;

import java.io.Serializable;
import java.util.List;

/**
 * 订单项目库存vo
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月15日 下午6:21:56 Exp $
 */
public class OrderItemStockVo implements Serializable {

    /**  */
    private static final long serialVersionUID = 1L;

    //订单项目id
    private Integer saleOrderItemId;

    //产品id
    private Integer productId;
    
    //虚拟库存数量
    private Integer virtualProductQty;
    
    //订单项目产品库存
    private List<OrderItemProductStockVo> orderItemProductStockVos;
    
    public List<OrderItemProductStockVo> getOrderItemProductStockVos() {
        return orderItemProductStockVos;
    }

    public void setOrderItemProductStockVos(List<OrderItemProductStockVo> orderItemProductStockVos) {
        this.orderItemProductStockVos = orderItemProductStockVos;
    }

    public Integer getSaleOrderItemId() {
        return saleOrderItemId;
    }

    public void setSaleOrderItemId(Integer saleOrderItemId) {
        this.saleOrderItemId = saleOrderItemId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getVirtualProductQty() {
        return virtualProductQty;
    }

    public void setVirtualProductQty(Integer virtualProductQty) {
        this.virtualProductQty = virtualProductQty;
    }
}
