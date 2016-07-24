package com.wow.stock.service.impl;

import com.wow.common.response.CommonResponse;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.ErrorResponseUtil;
import com.wow.stock.mapper.ProductVirtualStockMapper;
import com.wow.stock.mapper.ProductWarehouseStockMapper;
import com.wow.stock.model.ProductVirtualStock;
import com.wow.stock.model.ProductWarehouseStock;
import com.wow.stock.service.StockService;
import com.wow.stock.vo.*;
import com.wow.stock.vo.response.AvailableStockResponse;
import com.wow.stock.vo.response.AvailableStocksResponse;
import com.wow.stock.vo.response.BatchFreezeStockResponse;
import com.wow.stock.vo.response.FreezeStockResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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

    /**
     * 第一次商品进入仓库时创建库存记录
     *
     * @param productWarehouseStock
     * @return
     */
    @Override
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
    @Override
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
        int i = productWarehouseStockMapper.adjustWarehouseRealStock(productId, warehouseId, adjustNum);
        if (i < 1) {
            commonResponse.setResCode("50602");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50602"));
        }
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
        int i = productVirtualStockMapper.adjustVirtualStock(productId, adjustNum);
        if (i < 1) {
            commonResponse.setResCode("50603");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50603"));
        }
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
        int i = productWarehouseStockMapper.freezeWarehouseStock(productId, warehouseId, productQty);
        if (i == 0) {
            commonResponse.setResCode("50601");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50601"));
        }
        return commonResponse;
    }

    /**
     * 冻结虚拟库存
     *
     * @param productId
     * @param productQty
     * @return
     */
    @Override
    public CommonResponse freezeVirtualStock(int productId, int productQty) {
        CommonResponse commonResponse = new CommonResponse();
        int i = productVirtualStockMapper.freezeVirtualStock(productId, productQty);
        if (i == 0) {
            ErrorResponseUtil.setErrorResponse(commonResponse, "50609");
        }
        return commonResponse;
    }

    /**
     * 冻结库存(通用方法,可能会冻结仓库库存和/或虚拟库存)
     *
     * @param productId
     * @param productQty
     * @return
     */
    @Override
    public FreezeStockResponse freezeStock(int productId, int productQty) {
        FreezeStockResponse freezeStockResponse = new FreezeStockResponse();
        FreezeStockVo freezeStockVo = new FreezeStockVo();
        freezeStockVo.setProductId(productId);
        /**
         * 1. 获取可用库存信息(包括仓库库存和虚拟库存)
         * 2. 根据购买数量,先冻结仓库库存,如果仓库库存足够,结束,如果仓库库存不够
         * 3. 再冻结虚拟库存,如果虚拟库存足够,结束
         * 4. 如果虚拟库存不足,报错误码:该产品库存不足
         */
        AvailableStockResponse availableStockResponse = getAvailableStock(productId);
        if (availableStockResponse == null || availableStockResponse.getAvailableStockVo() == null) {
            ErrorResponseUtil.setErrorResponse(freezeStockResponse, "50608");
            return freezeStockResponse;
        }

        AvailableStockVo availableStockVo = availableStockResponse.getAvailableStockVo();

        int total = availableStockVo.getTotalAvailableStockQty();
        int totalReal = availableStockVo.getTotalAvailableWarehouseStockQty();
        int totalVirtual = availableStockVo.getAvailableVirtualStockQty();
        List<WarehouseStockVo> warehouseStockVoList = availableStockVo.getWarehouseStockVoList();
        //总库存不满足,直接返回
        if (total < productQty) {
            ErrorResponseUtil.setErrorResponse(freezeStockResponse, "50608");
            return freezeStockResponse;
        }

        int restQty = productQty;

        //先冻结仓库库存
        if (totalReal > 0) {
            //记录仓库冻结结果
            List<WarehouseStockFrozenResultVo> list = new ArrayList<WarehouseStockFrozenResultVo>();

            //如果仓库只有一个
            if (warehouseStockVoList.size() == 1) {
                WarehouseStockVo warehouseStockVo = warehouseStockVoList.get(0);
                if (warehouseStockVo.getAvailableStock() >= restQty) {
                    freezeWarehouseStock(productId, warehouseStockVo.getWarehouseId(), restQty);
                    WarehouseStockFrozenResultVo warehouseStockFrozenResultVo = new WarehouseStockFrozenResultVo();
                    warehouseStockFrozenResultVo.setProductId(productId);
                    warehouseStockFrozenResultVo.setWarehouseId(warehouseStockVo.getWarehouseId());
                    warehouseStockFrozenResultVo.setFrozenStock(productQty);
                    list.add(warehouseStockFrozenResultVo);
                    freezeStockVo.setWarehouseStockFrozenResultVoList(list);
                    freezeStockResponse.setFreezeStockVo(freezeStockVo);
                    return freezeStockResponse;
                } else if (warehouseStockVo.getAvailableStock() > 0) {
                    freezeWarehouseStock(productId, warehouseStockVo.getWarehouseId(), warehouseStockVo
                        .getAvailableStock());
                    WarehouseStockFrozenResultVo warehouseStockFrozenResultVo = new WarehouseStockFrozenResultVo();
                    warehouseStockFrozenResultVo.setProductId(productId);
                    warehouseStockFrozenResultVo.setWarehouseId(warehouseStockVo.getWarehouseId());
                    warehouseStockFrozenResultVo.setFrozenStock(warehouseStockVo.getAvailableStock());
                    list.add(warehouseStockFrozenResultVo);
                    freezeStockVo.setWarehouseStockFrozenResultVoList(list);
                    freezeStockResponse.setFreezeStockVo(freezeStockVo);
                    restQty = restQty - warehouseStockVo.getAvailableStock();
                }
            } else {
                //如果有多个仓库,优先冻结自有仓库,如果自有仓库单仓满足,则冻结单个仓库,如果自有仓库多仓满足,则先冻结大的,后冻结小的
                //如果自有仓库库存不够,再冻结第三方仓库
                List<WarehouseStockVo> privateWarehouseStock = new ArrayList<WarehouseStockVo>();
                List<WarehouseStockVo> thirdPartyWarehouseStock = new ArrayList<WarehouseStockVo>();

                for (WarehouseStockVo warehouseStockVo : warehouseStockVoList) {
                    int warehouseId = warehouseStockVo.getWarehouseId();
                    if (warehouseId <= 100) { //假设我们会扩展到100个仓库,wow,wow
                        privateWarehouseStock.add(warehouseStockVo);
                    } else {
                        thirdPartyWarehouseStock.add(warehouseStockVo);
                    }
                }
                //自有仓库按库存多少排序
                sort(privateWarehouseStock);

                for (WarehouseStockVo warehouseStockVo : privateWarehouseStock) {
                    if (restQty > 0) {
                        //单仓可满足剩余库存
                        if (warehouseStockVo.getAvailableStock() >= restQty) {
                            freezeWarehouseStock(productId, warehouseStockVo.getWarehouseId(), restQty);
                            WarehouseStockFrozenResultVo warehouseStockFrozenResultVo = new WarehouseStockFrozenResultVo();
                            warehouseStockFrozenResultVo.setProductId(productId);
                            warehouseStockFrozenResultVo.setWarehouseId(warehouseStockVo.getWarehouseId());
                            warehouseStockFrozenResultVo.setFrozenStock(restQty);
                            list.add(warehouseStockFrozenResultVo);
                            restQty = 0;
                            break;
                        } else if (warehouseStockVo.getAvailableStock() > 0) {
                            //单仓不满足,全部冻结掉
                            freezeWarehouseStock(productId, warehouseStockVo.getWarehouseId(), warehouseStockVo
                                .getAvailableStock());
                            WarehouseStockFrozenResultVo warehouseStockFrozenResultVo = new WarehouseStockFrozenResultVo();
                            warehouseStockFrozenResultVo.setProductId(productId);
                            warehouseStockFrozenResultVo.setWarehouseId(warehouseStockVo.getWarehouseId());
                            warehouseStockFrozenResultVo.setFrozenStock(warehouseStockVo.getAvailableStock());
                            list.add(warehouseStockFrozenResultVo);
                            restQty = restQty - warehouseStockVo.getAvailableStock();
                        }
                    }
                }
            }
            freezeStockVo.setWarehouseStockFrozenResultVoList(list);
            if (restQty <= 0) {
                freezeStockVo.setFrozenVirtualStockQty(0);
                freezeStockVo.setFrozenWarehouseStockTotalQty(productQty);
                freezeStockResponse.setFreezeStockVo(freezeStockVo);
                return freezeStockResponse;
            }
        }

        //再冻结虚拟库存
        if (totalVirtual >= restQty) {
            freezeVirtualStock(productId, restQty);
            freezeStockVo.setFrozenVirtualStockQty(restQty);
            freezeStockResponse.setFreezeStockVo(freezeStockVo);
        } else {
            //虚拟库存不足
            ErrorResponseUtil.setErrorResponse(freezeStockResponse, "50609");
            return freezeStockResponse;
        }
        return freezeStockResponse;
    }

    /**
     * 冻结库存(通用方法,可能会冻结仓库库存和/或虚拟库存)
     *
     * @param productQtyVoList
     * @return
     */
    @Override
    public BatchFreezeStockResponse batchFreezeStock(List<ProductQtyVo> productQtyVoList) {
        BatchFreezeStockResponse batchFreezeStockResponse = new BatchFreezeStockResponse();
        List<FreezeStockVo> list = new ArrayList<FreezeStockVo>();
        for (ProductQtyVo productQtyVo : productQtyVoList) {
            FreezeStockResponse freezeStockResponse = freezeStock(productQtyVo.getProductId(), productQtyVo
                .getProductQty());
            if (freezeStockResponse == null) {
                ErrorResponseUtil.setErrorResponse(batchFreezeStockResponse, "50608");
                return batchFreezeStockResponse;
            }
            if (ErrorCodeUtil.isFailedResponse(freezeStockResponse.getResCode())) {
                batchFreezeStockResponse.setResCode("50608");
                batchFreezeStockResponse.setResMsg("库存不足 - productId:" + productQtyVo.getProductId());
                return batchFreezeStockResponse;
            } else {
                list.add(freezeStockResponse.getFreezeStockVo());
            }
        }
        batchFreezeStockResponse.setFreezeStockVoList(list);
        return batchFreezeStockResponse;
    }

    private void sort(List<WarehouseStockVo> data) {
        Collections.sort(data, new Comparator<WarehouseStockVo>() {
            public int compare(WarehouseStockVo warehouseStockVo1, WarehouseStockVo warehouseStockVo2) {
                Integer a = warehouseStockVo1.getAvailableStock();
                Integer b = warehouseStockVo2.getAvailableStock();
                //降序
                return b.compareTo(a);
            }
        });
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
        int i = productWarehouseStockMapper.unfreezeWarehouseStock(productId, warehouseId, productQty);
        if (i == 0) {
            commonResponse.setResCode("50604");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50604"));
        }
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
        int i = productVirtualStockMapper.unfreezeVirtualStock(productId, productQty);
        if (i == 0) {
            commonResponse.setResCode("50605");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50605"));
        }
        return commonResponse;
    }

    /**
     * 解冻库存(通用,一般是取消订单)
     *
     * @param unfreezeStockVo
     */
    @Override
    public CommonResponse unfreezeStock(UnfreezeStockVo unfreezeStockVo) {

        CommonResponse commonResponse = new CommonResponse();

        int productId = unfreezeStockVo.getProductId();
        int virtualProductQty = unfreezeStockVo.getVirtualProductQty();
        List<ProductWarehouseQtyVo> productWarehouseQtyVoList = unfreezeStockVo.getProductWarehouseQtyVoList();

        //解冻仓库库存
        if (CollectionUtil.isNotEmpty(productWarehouseQtyVoList)) {
            for (ProductWarehouseQtyVo productWarehouseQtyVo : productWarehouseQtyVoList) {
                unfreezeWarehouseStock(productId, productWarehouseQtyVo.getWarehouseId(), productWarehouseQtyVo.getProductQty());
            }
        }
        //解冻虚拟库存
        if (virtualProductQty > 0) {
            unfreezeVirtualStock(productId, virtualProductQty);
        }
        return commonResponse;
    }

    /**
     * 批量解冻库存(通用,一般是取消订单)
     *
     * @param unfreezeStockVoList
     */
    @Override
    public CommonResponse batchUnfreezeStock(List<UnfreezeStockVo> unfreezeStockVoList) {
        CommonResponse commonResponse = new CommonResponse();
        for (UnfreezeStockVo unfreezeStockVo : unfreezeStockVoList) {
            CommonResponse unfreezeStockResponse = unfreezeStock(unfreezeStockVo);
            if (unfreezeStockResponse == null || ErrorCodeUtil.isFailedResponse(unfreezeStockResponse.getResCode())) {
                ErrorResponseUtil.setErrorResponse(commonResponse, "50604");
                return commonResponse;
            }
        }
        return commonResponse;
    }

    /**
     * 计算可用库存=仓库可用库存+虚拟可用库存
     *
     * @param productId
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public AvailableStockResponse getAvailableStock(int productId) {
        AvailableStockResponse availableStockResponse = new AvailableStockResponse();
        AvailableStockVo availableStockVo = new AvailableStockVo();

        availableStockVo.setProductId(productId);

        //首先遍历所有仓库,查找仓库库存,然后计算虚拟可用库存
        List<WarehouseStockVo> warehouseStockVoList = productWarehouseStockMapper.getWarehouseAvailableStock(productId);
        int totalAvailableRealStock = 0;
        for (WarehouseStockVo warehouseStockVo : warehouseStockVoList) {
            //            map.put(warehouseStockVo.getWarehouseId(),warehouseStockVo.getAvailableStock());
            totalAvailableRealStock += warehouseStockVo.getAvailableStock();
        }
        //        availableStockVo.setAvailableRealStockQtyMap(map);
        availableStockVo.setWarehouseStockVoList(warehouseStockVoList);

        availableStockVo.setTotalAvailableWarehouseStockQty(totalAvailableRealStock);

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
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public AvailableStocksResponse batchGetAvailableStock(List<Integer> productIds) {

        AvailableStocksResponse availableStocksResponse = new AvailableStocksResponse();

        //        Map<Integer, AvailableStockVo> map = new HashMap<Integer, AvailableStockVo>();

        List<AvailableStockVo> availableStockVoList = new ArrayList<>();

        //首先遍历所有仓库,查找仓库可用库存
        List<WarehouseStockVo> warehouseStockVoList = productWarehouseStockMapper
            .getWarehouseAvailableStocks(productIds);

        //然后计算虚拟可用库存
        List<VirtualStockVo> virtualStockVoList = productVirtualStockMapper.getAvailableVirtualStocks(productIds);

        //productId: warehouseStockVoList
        //        Map<Integer, List<WarehouseStockVo>> map = new HashMap<Integer, List<WarehouseStockVo>>();

        Map<Integer, AvailableStockVo> map = new HashMap<Integer, AvailableStockVo>();

        //        AvailableStockVo availableStockVo = new AvailableStockVo();

        for (WarehouseStockVo warehouseStockVo : warehouseStockVoList) {
            int productId = warehouseStockVo.getProductId();
            int warehouseId = warehouseStockVo.getWarehouseId();
            int availableStock = warehouseStockVo.getAvailableStock();

            if (map.get(productId) == null) {
                AvailableStockVo availableStockVo = new AvailableStockVo();
                availableStockVo.setProductId(productId);
                map.put(productId, availableStockVo);
            }
            List<WarehouseStockVo> warehouseStockVos = map.get(productId).getWarehouseStockVoList();
            if (warehouseStockVos == null) {
                warehouseStockVos = new ArrayList<>();
                map.get(productId).setWarehouseStockVoList(warehouseStockVos);
                map.get(productId).setTotalAvailableWarehouseStockQty(availableStock);
                map.get(productId).setTotalAvailableStockQty(availableStock);
            } else {
                map.get(productId).setTotalAvailableWarehouseStockQty(map.get(productId)
                    .getTotalAvailableWarehouseStockQty() + availableStock);
                map.get(productId)
                    .setTotalAvailableStockQty(map.get(productId).getTotalAvailableStockQty() + availableStock);
            }
            map.get(productId).getWarehouseStockVoList().add(warehouseStockVo);
        }

        //                warehouseStockVos.setAvailableRealStockQtyMap(warehouseMap);
        //                warehouseStockVos.setTotalAvailableWarehouseStockQty(availableStock);
        //                warehouseStockVos.setTotalAvailableStockQty(availableStockVo.getTotalAvailableWarehouseStockQty());
        //                map.put(productId, availableStockVo);
        //            } else {
        //                map.get(productId).add(warehouseStockVo);
        //                if (availableStockVo.getAvailableRealStockQtyMap()==null) {
        //                    availableStockVo.setAvailableRealStockQtyMap(warehouseMap);
        //                    availableStockVo.setTotalAvailableWarehouseStockQty(availableStock);
        //                    availableStockVo.setTotalAvailableStockQty(availableStockVo.getTotalAvailableWarehouseStockQty());
        //                } else {
        //                    availableStockVo.getAvailableRealStockQtyMap().put(warehouseId, availableStock);
        //                    availableStockVo.setTotalAvailableWarehouseStockQty(availableStockVo.getTotalAvailableStockQty() + availableStock);
        //                    availableStockVo.setTotalAvailableStockQty(availableStockVo.getTotalAvailableWarehouseStockQty());
        //                }
        //            }
        //        }

        for (VirtualStockVo virtualStockVo : virtualStockVoList) {

            int productId = virtualStockVo.getProductId();
            int availableVirtualStock = virtualStockVo.getAvailableVirtualStock();

            AvailableStockVo availableStockVo = map.get(productId);

            if (availableStockVo == null) {
                availableStockVo = new AvailableStockVo();
                availableStockVo.setProductId(productId);
                availableStockVo.setAvailableVirtualStockQty(availableVirtualStock);
                availableStockVo.setTotalAvailableStockQty(availableVirtualStock);
                map.put(productId, availableStockVo);
            } else {
                availableStockVo.setAvailableVirtualStockQty(availableVirtualStock);
                availableStockVo
                    .setTotalAvailableStockQty(availableStockVo.getTotalAvailableStockQty() + availableVirtualStock);
            }
        }

        Collection<AvailableStockVo> availableStockVoCollection = map.values();

        List<AvailableStockVo> availableStockVos = new ArrayList<AvailableStockVo>(availableStockVoCollection);

        availableStocksResponse.setAvailableStockVoList(availableStockVos);

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
        int i = productWarehouseStockMapper.shipOutWarehouseGoods(productId, warehouseId, productQty);
        if (i == 0) {
            commonResponse.setResCode("50606");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50606"));
        }
        return commonResponse;
    }

    /**
     * 查找所有有虚拟冻结的产品库存信息
     *
     * @return
     */
    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public List<ProductVirtualStock> selectAllProductsWithFrozenVirtualStock() {
        return productVirtualStockMapper.selectAllProductsWithFrozenVirtualStock();
    }
}
