package com.wow.stock.service;

import com.wow.product.model.Warehouse;
import com.wow.stock.model.ProductVirtualStock;
import com.wow.stock.model.ProductWarehouseStock;
import com.wow.stock.vo.AvailableStock;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/17.
 */
public interface StockService {
    /**
     * 第一次商品进入仓库时创建库存记录
     *
     * @param productWarehouseStock
     * @return
     */
    int createProductWarehouseStock(ProductWarehouseStock productWarehouseStock);

    /**
     * 如果支持虚拟库存,第一次时创建虚拟库存
     *
     * @param productVirtualStock
     * @return
     */
    int createProductVirtualStock(ProductVirtualStock productVirtualStock);

    /**
     * 调整仓库实际库存(调增,调减都可以)
     *
     * @param productId
     * @param warehouseId
     * @param adjustNum
     */
    int adjustWarehouseRealStock(int productId, int warehouseId, int adjustNum);

    /**
     * 调整虚拟库存(调增,调减都可以)
     *
     * @param productId
     * @param adjustNum
     */
    int adjustVirtualStock(int productId, int adjustNum);

    /**
     * 冻结库存(一般是下单时)
     *
     * @param productId
     * @param warehouseId
     * @param productQty 产品数量-正整数
     */
    int freezeWarehouseStock(int productId, int warehouseId, int productQty);

    /**
     * 解冻仓库库存(一般是取消订单)
     *
     * @param productId
     * @param warehouseId
     * @param productQty 产品数量-正整数
     */
    int unfreezeWarehouseStock(int productId, int warehouseId, int productQty);

    /**
     * 解冻虚拟库存(一般是取消订单)
     *
     * @param productId
     * @param productQty 产品数量-正整数
     */
    int unfreezeVirtualStock(int productId, int productQty);

    /**
     * 计算可用库存=仓库可用库存+虚拟可用库存
     *
     * @param productId
     * @return
     */
    AvailableStock getAvailableStock(int productId);

    /**
     * 发货出库-同时减少实际库存和冻结库存
     *
     * @param productId
     * @param warehouseId
     * @param productQty 产品数量-正整数
     */
    int shipOutGoods(int productId, int warehouseId, int productQty);


    /**
     * 创建仓库(自营的创建自营仓库,供应商的创建供应商虚拟仓库)
     *
     * @param warehouse
     * @return
     */
    int createWarehouse(Warehouse warehouse);

    /**
     * 变更仓库信息
     *
     * @param warehouse
     * @return
     */
    int updateWarehouse(Warehouse warehouse);

    /**
     * 查询产品所在仓库列表
     *
     * @param productId
     * @return
     */
    List<Integer> selectWarehouseByProductId(int productId);
}
