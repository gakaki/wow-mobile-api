package com.wow.stock.service.impl;

import com.wow.product.model.Warehouse;
import com.wow.stock.model.ProductVirtualStock;
import com.wow.stock.model.ProductWarehouseStock;
import com.wow.stock.service.StockService;
import org.springframework.stereotype.Service;

/**
 * Created by zhengzhiqing on 16/6/17.
 */
@Service
public class StockServiceImpl implements StockService{
    /**
     * 第一次商品进入仓库时创建库存记录
     *
     * @param productWarehouseStock
     * @return
     */
    public int createProductWarehouseStock(ProductWarehouseStock productWarehouseStock) {
        return 1;
    }

    /**
     * 如果支持虚拟库存,第一次时创建虚拟库存
     *
     * @param productVirtualStock
     * @return
     */
    public int createProductVirtualStock(ProductVirtualStock productVirtualStock) {
        return 1;
    }

    /**
     * 调整仓库实际库存(调增,调减都可以)
     *
     * @param productId
     * @param warehouseId
     * @param adjustNum
     */
    public void adjustWarehouseRealStock(int productId, int warehouseId, int adjustNum) {

    }

    /**
     * 调整虚拟库存(调增,调减都可以)
     *
     * @param productId
     * @param adjustNum
     */
    public void adjustVirtualStock(int productId, int adjustNum) {

    }

    /**
     * 冻结库存(一般是下单时)
     *
     * @param productId
     * @param warehouseId
     * @param productNum
     */
    public void freezeStock(int productId, int warehouseId, int productNum) {

    }

    /**
     * 解冻库存(一般是取消订单)
     *
     * @param productId
     * @param warehouseId
     * @param productNum
     */
    public void unFreezeStock(int productId, int warehouseId, int productNum) {

    }

    /**
     * 计算可用库存=仓库可用库存+虚拟可用库存
     *
     * @param productId
     * @return
     */
    public int getAvailableStock(int productId) {
        return 1;
    }

    /**
     * 发货出库-同时减少实际库存和冻结库存
     *
     * @param productId
     * @param warehouseId
     * @param productNum
     */
    public void deliverGoods(int productId, int warehouseId, int productNum) {
    }

    /**
     * 虚拟库存到货之后马上发货,不用进入仓库,否则可能被卖掉 - 减少虚拟冻结
     *
     * @param productId
     */
    public void deliverDelayedGoods(int productId) {
    }

    /**
     * 创建仓库(自营的创建自营仓库,供应商的创建供应商虚拟仓库)
     *
     * @param warehouse
     * @return
     */
    public int createWarehouse(Warehouse warehouse) {
        return 1;
    }

    /**
     * 变更仓库信息
     *
     * @param warehouse
     * @return
     */
    public int updateWarehouse(Warehouse warehouse) {
        return 1;
    }

    /**
     * 查询产品所在仓库列表
     *
     * @param productId
     * @return
     */
    public int[] queryWarehousesByProductId(int productId) {
        int[] a = {1,2};
        return a;
    }
}
