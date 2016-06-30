package com.wow.stock.service.impl;

import com.wow.product.mapper.WarehouseMapper;
import com.wow.product.model.Warehouse;
import com.wow.stock.mapper.ProductVirtualStockMapper;
import com.wow.stock.mapper.ProductWarehouseStockMapper;
import com.wow.stock.model.ProductVirtualStock;
import com.wow.stock.model.ProductWarehouseStock;
import com.wow.stock.service.StockService;
import com.wow.stock.vo.AvailableStock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created by zhengzhiqing on 16/6/17.
 */
@Service
public class StockServiceImpl implements StockService{

    @Autowired
    ProductWarehouseStockMapper productWarehouseStockMapper;

    @Autowired
    ProductVirtualStockMapper productVirtualStockMapper;

    @Autowired
    WarehouseMapper warehouseMapper;

    /**
     * 第一次商品进入仓库时创建库存记录
     *
     * @param productWarehouseStock
     * @return
     */
    public int createProductWarehouseStock(ProductWarehouseStock productWarehouseStock) {
        return productWarehouseStockMapper.insert(productWarehouseStock);
    }

    /**
     * 如果支持虚拟库存,第一次时创建虚拟库存
     *
     * @param productVirtualStock
     * @return
     */
    public int createProductVirtualStock(ProductVirtualStock productVirtualStock) {
        return productVirtualStockMapper.insert(productVirtualStock);
    }

    /**
     * 调整仓库实际库存(调增,调减都可以)
     *
     * @param productId
     * @param warehouseId
     * @param adjustNum 可以为正数或负数
     */
    public int adjustWarehouseRealStock(int productId, int warehouseId, int adjustNum) {
        //先更新真实库存
        productWarehouseStockMapper.adjustWarehouseRealStock(productId, warehouseId, adjustNum);
        //如果是调增库存(比如进货),需要先满足之前冻结的虚拟库存
        if(adjustNum > 0) {
            //当前冻结的虚拟库存数量
            int frozenVirtualStockQty = productVirtualStockMapper.getFrozenVirtualStock(productId);
            //需要解冻的虚拟库存数量
            int unfreezeVirtualStockQty = 0;
            if (adjustNum >= frozenVirtualStockQty) {
                unfreezeVirtualStockQty = frozenVirtualStockQty;
            } else {
                unfreezeVirtualStockQty = adjustNum;
            }
            //虚拟冻结转真实冻结
            productVirtualStockMapper.shipOutVirtualStock(productId, unfreezeVirtualStockQty);
            productWarehouseStockMapper.freezeWarehouseStock(productId, warehouseId, unfreezeVirtualStockQty);
            //更新订单状态
            //TODO:查看order_item中有虚拟冻结的产品,修改冻结状态和冻结数量。提醒发货员发货等
        }
        return 1;
    }

    /**
     * 调整虚拟库存(调增,调减都可以)
     *
     * @param productId
     * @param adjustNum 可以为正数或负数
     */
    public int adjustVirtualStock(int productId, int adjustNum) {
        return productVirtualStockMapper.adjustVirtualStock(productId, adjustNum);
    }

    /**
     * 冻结仓库库存(一般是下单时)
     *
     * @param productId
     * @param warehouseId
     * @param productQty 产品数量-正整数
     */
    public int freezeWarehouseStock(int productId, int warehouseId, int productQty) {
        return productWarehouseStockMapper.freezeWarehouseStock(productId,warehouseId,productQty);
    }

    /**
     * 解冻库存(一般是取消订单)
     *
     * @param productId
     * @param warehouseId
     * @param productQty 产品数量-正整数
     */
    public int unfreezeWarehouseStock(int productId, int warehouseId, int productQty) {
        return productWarehouseStockMapper.unfreezeWarehouseStock(productId,warehouseId,productQty);
    }

    /**
     * 解冻虚拟库存(一般是取消订单)
     *
     * @param productId
     * @param productQty 产品数量-正整数
     */
    @Override
    public int unfreezeVirtualStock(int productId, int productQty) {
        return productVirtualStockMapper.unfreezeVirtualStock(productId, productQty);
    }

    /**
     * 计算可用库存=仓库可用库存+虚拟可用库存
     *
     * @param productId
     * @return
     */
    public AvailableStock getAvailableStock(int productId) {
        AvailableStock availableStock = new AvailableStock();
        //首先遍历所有仓库,查找仓库库存,然后计算虚拟可用库存
        Map<Integer,Integer> map = productWarehouseStockMapper.getWarehouseAvailableStock(productId);
        availableStock.setAvailableRealStockQtyMap(map);

        int totalAvailableRealStock = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            totalAvailableRealStock += entry.getValue();
        }

        availableStock.setTotalAvailableRealStockQty(totalAvailableRealStock);

        int availableVirtualStockQty = productVirtualStockMapper.getAvailableVirtualStock(productId);
        availableStock.setAvailableVirtualStockQty(availableVirtualStockQty);

        availableStock.setTotalAvailableStockQty(totalAvailableRealStock + availableVirtualStockQty);

        return availableStock;
    }

    /**
     * 发货出库-同时减少实际库存和冻结库存
     *
     * @param productId
     * @param warehouseId
     * @param productQty 产品数量-正整数
     */
    public int shipOutGoods(int productId, int warehouseId, int productQty) {
        return productWarehouseStockMapper.shipOutWarehouseGoods(productId,warehouseId,productQty);
    }

    /**
     * 创建仓库(自营的创建自营仓库,供应商的创建供应商虚拟仓库)
     *
     * @param warehouse
     * @return
     */
    public int createWarehouse(Warehouse warehouse) {
        return warehouseMapper.insert(warehouse);
    }

    /**
     * 变更仓库信息
     *
     * @param warehouse
     * @return
     */
    public int updateWarehouse(Warehouse warehouse) {
        return warehouseMapper.updateByPrimaryKeySelective(warehouse);
    }

    /**
     * 查询产品所在仓库列表
     *
     * @param productId
     * @return
     */
    public List<Integer> selectWarehouseByProductId(int productId) {
        return productWarehouseStockMapper.selectWarehouseByProductId(productId);
    }
}
