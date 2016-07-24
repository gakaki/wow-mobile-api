package com.wow.order.vo;

import java.io.Serializable;

/**
 * 订单项目产品库存vo
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月15日 下午6:21:56 Exp $
 */
public class OrderItemProductStockVo implements Serializable {

    /**  */
    private static final long serialVersionUID = 1L;

    // 仓库id
    private int warehouseId;
    
    //库存数量
    private int productQty;

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getProductQty() {
        return productQty;
    }

    public void setProductQty(int productQty) {
        this.productQty = productQty;
    }
}
