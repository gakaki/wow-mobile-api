package com.wow.stock.service;

import com.wow.common.response.CommonResponse;
import com.wow.stock.model.ProductVirtualStock;
import com.wow.stock.model.ProductWarehouseStock;
import com.wow.stock.vo.ProductQtyVo;
import com.wow.stock.vo.response.AvailableStockResponse;
import com.wow.stock.vo.response.AvailableStocksResponse;
import com.wow.stock.vo.response.BatchFreezeStockResponse;
import com.wow.stock.vo.response.FreezeStockResponse;

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
    CommonResponse createProductWarehouseStock(ProductWarehouseStock productWarehouseStock);

    /**
     * 如果支持虚拟库存,第一次时创建虚拟库存
     *
     * @param productVirtualStock
     * @return
     */
    CommonResponse createProductVirtualStock(ProductVirtualStock productVirtualStock);

    /**
     * 调整仓库实际库存(调增,调减都可以)
     *
     * @param productId
     * @param warehouseId
     * @param adjustNum
     */
    CommonResponse adjustWarehouseRealStock(int productId, int warehouseId, int adjustNum);

    /**
     * 调整虚拟库存(调增,调减都可以)
     *
     * @param productId
     * @param adjustNum
     */
    CommonResponse adjustVirtualStock(int productId, int adjustNum);

    /**
     * 冻结仓库库存
     *
     * @param productId
     * @param warehouseId
     * @param productQty 产品数量-正整数
     */
    CommonResponse freezeWarehouseStock(int productId, int warehouseId, int productQty);

    /**
     * 冻结库存(通用方法,可能会冻结仓库库存和/或虚拟库存)
     * @param productId
     * @param productQty
     * @return
     */
    FreezeStockResponse freezeStock(int productId, int productQty);

    /**
     * 批量冻结库存
     * @param productQtyVoList
     * @return
     */
    BatchFreezeStockResponse batchFreezeStock(List<ProductQtyVo> productQtyVoList);

    /**
     * 冻结虚拟库存
     * @param productId
     * @param productQty
     * @return
     */
    CommonResponse freezeVirtualStock(int productId, int productQty);

    /**
     * 解冻仓库库存(一般是取消订单)
     *
     * @param productId
     * @param warehouseId
     * @param productQty 产品数量-正整数
     */
    CommonResponse unfreezeWarehouseStock(int productId, int warehouseId, int productQty);

    /**
     * 解冻虚拟库存(一般是取消订单)
     *
     * @param productId
     * @param productQty 产品数量-正整数
     */
    CommonResponse unfreezeVirtualStock(int productId, int productQty);

    /**
     * 计算可用库存=仓库可用库存+虚拟可用库存
     *
     * @param productId
     * @return
     */
    AvailableStockResponse getAvailableStock(int productId);

    /**
     * 批量计算可用库存=仓库可用库存+虚拟可用库存
     *
     * @param productIds
     * @return
     */
    AvailableStocksResponse batchGetAvailableStock(List<Integer> productIds);

    /**
     * 发货出库-同时减少实际库存和冻结库存
     *
     * @param productId
     * @param warehouseId
     * @param productQty 产品数量-正整数
     */
    CommonResponse shipOutGoods(int productId, int warehouseId, int productQty);


//    /**
//     * 创建仓库(自营的创建自营仓库,供应商的创建供应商虚拟仓库)
//     *
//     * @param warehouse
//     * @return
//     */
//    CommonResponse createWarehouse(Warehouse warehouse);
//
//    /**
//     * 变更仓库信息
//     *
//     * @param warehouse
//     * @return
//     */
//    CommonResponse updateWarehouse(Warehouse warehouse);

//    /**
//     * 查询产品所在仓库列表
//     *
//     * @param productId
//     * @return
//     */
//    List<Integer> selectWarehouseByProductId(int productId);

    /**
     * 查找所有有虚拟冻结的产品库存信息
     * @return
     */
    List<ProductVirtualStock> selectAllProductsWithFrozenVirtualStock();
}
