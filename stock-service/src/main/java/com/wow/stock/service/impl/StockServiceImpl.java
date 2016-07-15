package com.wow.stock.service.impl;

import com.wow.common.response.CommonResponse;
import com.wow.product.mapper.WarehouseMapper;
import com.wow.product.model.Warehouse;
import com.wow.stock.mapper.ProductVirtualStockMapper;
import com.wow.stock.mapper.ProductWarehouseStockMapper;
import com.wow.stock.model.ProductVirtualStock;
import com.wow.stock.model.ProductWarehouseStock;
import com.wow.stock.service.StockService;
import com.wow.stock.vo.AvailableStockVo;
import com.wow.stock.vo.VirtualStockVo;
import com.wow.stock.vo.WarehouseStockVo;
import com.wow.stock.vo.response.AvailableStockResponse;
import com.wow.stock.vo.response.AvailableStocksResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhengzhiqing on 16/6/17.
 */
@Service
@Transactional("stockTransactionManager")
public class StockServiceImpl implements StockService {

    private static final Logger logger = LoggerFactory.getLogger(StockServiceImpl.class);

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
    public CommonResponse createProductWarehouseStock(ProductWarehouseStock productWarehouseStock) {
        CommonResponse commonResponse = new CommonResponse();
        productWarehouseStockMapper.insertSelective(productWarehouseStock);
        return commonResponse;
    }

    /**
     * 如果支持虚拟库存,第一次时创建虚拟库存
     *
     * @param productVirtualStock
     * @return
     */
    public CommonResponse createProductVirtualStock(ProductVirtualStock productVirtualStock) {
        CommonResponse commonResponse = new CommonResponse();
        productVirtualStockMapper.insertSelective(productVirtualStock);
        return commonResponse;
    }

    /**
     * 调整仓库实际库存(调增,调减都可以)
     *
     * @param productId
     * @param warehouseId
     * @param adjustNum 可以为正数或负数
     */
    @Override
    public CommonResponse adjustWarehouseRealStock(int productId, int warehouseId, int adjustNum) {
        //先更新真实库存
        CommonResponse commonResponse = new CommonResponse();
        productWarehouseStockMapper.adjustWarehouseRealStock(productId, warehouseId, adjustNum);
        return commonResponse;
        //考虑到目前虚拟库存的情况并不多,通过每天的定时任务来扫描虚拟库存订单,而不是在这里主动去满足那些订单,以后再优化
        //或者做成消息通知模式,一旦有产品到货,通知订单子系统处理虚拟库存的订单
        //消息考虑redis mq 或者 rabbit mq

//        //如果是调增库存(比如进货),需要先满足之前冻结的虚拟库存
//        if(adjustNum > 0) {
//            //当前冻结的虚拟库存数量
//            int frozenVirtualStockQty = productVirtualStockMapper.getFrozenVirtualStock(productId);
//            //需要解冻的虚拟库存数量
//            int unfreezeVirtualStockQty = 0;
//            if (adjustNum >= frozenVirtualStockQty) {
//                unfreezeVirtualStockQty = frozenVirtualStockQty;
//            } else {
//                unfreezeVirtualStockQty = adjustNum;
//            }
//            if (unfreezeVirtualStockQty > 0) {
//                //虚拟冻结转真实冻结
//                productVirtualStockMapper.shipOutVirtualStock(productId, unfreezeVirtualStockQty);
//                productWarehouseStockMapper.freezeWarehouseStock(productId, warehouseId, unfreezeVirtualStockQty);
//                //更新订单状态
//                //TODO:查看order_item中有虚拟冻结的产品,修改冻结状态和冻结数量。提醒发货员发货等
//            }
//        }
    }

    /**
     * 调整虚拟库存(调增,调减都可以)
     *
     * @param productId
     * @param adjustNum 可以为正数或负数
     */
    @Override
    public CommonResponse adjustVirtualStock(int productId, int adjustNum) {
        CommonResponse commonResponse = new CommonResponse();
        productVirtualStockMapper.adjustVirtualStock(productId, adjustNum);
        return commonResponse;
    }

    /**
     * 冻结仓库库存(一般是下单时)
     * 自营订单和供应商直送订单逻辑一致
     *
     * @param productId
     * @param warehouseId
     * @param productQty 产品数量-正整数
     */
    @Override
    public CommonResponse freezeWarehouseStock(int productId, int warehouseId, int productQty) {
        CommonResponse commonResponse = new CommonResponse();
        productWarehouseStockMapper.freezeWarehouseStock(productId,warehouseId,productQty);
        return commonResponse;
    }

    /**
     * 解冻库存(一般是取消订单)
     *
     * @param productId
     * @param warehouseId
     * @param productQty 产品数量-正整数
     */
    @Override
    public CommonResponse unfreezeWarehouseStock(int productId, int warehouseId, int productQty) {
        CommonResponse commonResponse = new CommonResponse();
        productWarehouseStockMapper.unfreezeWarehouseStock(productId,warehouseId,productQty);
        return commonResponse;
    }

    /**
     * 解冻虚拟库存(一般是取消订单)
     *
     * @param productId
     * @param productQty 产品数量-正整数
     */
    @Override
    public CommonResponse unfreezeVirtualStock(int productId, int productQty) {
        CommonResponse commonResponse = new CommonResponse();
        productVirtualStockMapper.unfreezeVirtualStock(productId, productQty);
        return commonResponse;
    }

    /**
     * 计算可用库存=仓库可用库存+虚拟可用库存
     *
     * @param productId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public AvailableStockResponse getAvailableStock(int productId) {
        AvailableStockResponse availableStockResponse = new AvailableStockResponse();
        AvailableStockVo availableStockVo = new AvailableStockVo();

        Map<Integer,Integer> map =new HashMap<Integer, Integer>();

        //首先遍历所有仓库,查找仓库库存,然后计算虚拟可用库存
        List<WarehouseStockVo> warehouseStockVoList = productWarehouseStockMapper.getWarehouseAvailableStock(productId);
        long totalAvailableRealStock = 0;
        for (WarehouseStockVo warehouseStockVo : warehouseStockVoList) {
            map.put(warehouseStockVo.getWarehouseId(),warehouseStockVo.getAvailableStock());
            totalAvailableRealStock += warehouseStockVo.getAvailableStock();
        }
        availableStockVo.setAvailableRealStockQtyMap(map);

        availableStockVo.setTotalAvailableRealStockQty(totalAvailableRealStock);

        Integer availableVirtualStockQty = productVirtualStockMapper.getAvailableVirtualStock(productId);
        if (availableVirtualStockQty != null) {
            availableStockVo.setAvailableVirtualStockQty(availableVirtualStockQty);
            availableStockVo.setTotalAvailableStockQty(totalAvailableRealStock + availableVirtualStockQty);
        } else {
            availableStockVo.setTotalAvailableStockQty(totalAvailableRealStock);
        }

        availableStockResponse.setAvailableStockVo(availableStockVo);
        return availableStockResponse;
    }

    /**
     * 计算可用库存=仓库可用库存+虚拟可用库存
     *
     * @param productIds
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public AvailableStocksResponse batchGetAvailableStock(List<Integer> productIds) {

        AvailableStocksResponse availableStocksResponse = new AvailableStocksResponse();

        Map<Integer, AvailableStockVo> map = new HashMap<Integer, AvailableStockVo>();

        //首先遍历所有仓库,查找仓库可用库存
        List<WarehouseStockVo> warehouseStockVoList= productWarehouseStockMapper.getWarehouseAvailableStocks(productIds);

        //然后计算虚拟可用库存
        List<VirtualStockVo> virtualStockVoList = productVirtualStockMapper.getAvailableVirtualStocks(productIds);

        for (WarehouseStockVo warehouseStockVo: warehouseStockVoList) {
            int productId = warehouseStockVo.getProductId();
            int warehouseId = warehouseStockVo.getWarehouseId();
            int availableStock = warehouseStockVo.getAvailableStock();

            Map<Integer, Integer> warehouseMap = new HashMap<Integer, Integer>();
            warehouseMap.put(warehouseId, availableStock);
            AvailableStockVo availableStockVo = map.get(productId);

            if (availableStockVo==null) {
                availableStockVo = new AvailableStockVo();
                availableStockVo.setAvailableRealStockQtyMap(warehouseMap);
                availableStockVo.setTotalAvailableRealStockQty(availableStock);
                availableStockVo.setTotalAvailableStockQty(availableStockVo.getTotalAvailableRealStockQty());
                map.put(productId, availableStockVo);
            } else {
                if (availableStockVo.getAvailableRealStockQtyMap()==null) {
                    availableStockVo.setAvailableRealStockQtyMap(warehouseMap);
                    availableStockVo.setTotalAvailableRealStockQty(availableStock);
                    availableStockVo.setTotalAvailableStockQty(availableStockVo.getTotalAvailableRealStockQty());
                } else {
                    availableStockVo.getAvailableRealStockQtyMap().put(warehouseId, availableStock);
                    availableStockVo.setTotalAvailableRealStockQty(availableStockVo.getTotalAvailableStockQty() + availableStock);
                    availableStockVo.setTotalAvailableStockQty(availableStockVo.getTotalAvailableRealStockQty());
                }
            }
        }

        for (VirtualStockVo virtualStockVo: virtualStockVoList) {

            int productId = virtualStockVo.getProductId();
            int availableVirtualStock = virtualStockVo.getAvailableVirtualStock();

            AvailableStockVo availableStockVo = map.get(productId);

            if (availableStockVo==null) {
                availableStockVo = new AvailableStockVo();
                availableStockVo.setAvailableVirtualStockQty(availableVirtualStock);
                availableStockVo.setTotalAvailableStockQty(availableVirtualStock);
                map.put(productId, availableStockVo);
            } else {
                availableStockVo.setAvailableVirtualStockQty(availableVirtualStock);
                availableStockVo.setTotalAvailableStockQty(availableStockVo.getTotalAvailableStockQty() + availableVirtualStock);
            }
        }

        availableStocksResponse.setAvailableStockVoMap(map);

        return availableStocksResponse;
    }

    /**
     * 发货出库-同时减少实际库存和冻结库存
     *
     * @param productId
     * @param warehouseId
     * @param productQty 产品数量-正整数
     */
    @Override
    public CommonResponse shipOutGoods(int productId, int warehouseId, int productQty) {
        CommonResponse commonResponse = new CommonResponse();
        productWarehouseStockMapper.shipOutWarehouseGoods(productId,warehouseId,productQty);
        return commonResponse;
    }

    /**
     * 创建仓库(自营的创建自营仓库,供应商的创建供应商虚拟仓库)
     *
     * @param warehouse
     * @return
     */
    @Override
    public CommonResponse createWarehouse(Warehouse warehouse) {
        CommonResponse commonResponse = new CommonResponse();
        warehouseMapper.insertSelective(warehouse);
        return commonResponse;
    }

    /**
     * 变更仓库信息
     *
     * @param warehouse
     * @return
     */
    @Override
    public CommonResponse updateWarehouse(Warehouse warehouse) {
        CommonResponse commonResponse = new CommonResponse();
        warehouseMapper.updateByPrimaryKeySelective(warehouse);
        return commonResponse;
    }

    /**
     * 查询产品所在仓库列表
     *
     * @param productId
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Integer> selectWarehouseByProductId(int productId) {
        return productWarehouseStockMapper.selectWarehouseByProductId(productId);
    }

    /**
     * 查找所有有虚拟冻结的产品库存信息
     *
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<ProductVirtualStock> selectAllProductsWithFrozenVirtualStock() {
        return productVirtualStockMapper.selectAllProductsWithFrozenVirtualStock();
    }
}
