package com.wow.order.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wow.common.constant.CommonConstant;
import com.wow.common.enums.ProductStatusEnum;
import com.wow.common.enums.SaleOrderStatusEnum;
import com.wow.common.response.CommonResponse;
import com.wow.common.util.BeanUtil;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.DateUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.IpConvertUtil;
import com.wow.common.util.NumberUtil;
import com.wow.common.util.RandomGenerator;
import com.wow.common.util.StringUtil;
import com.wow.order.mapper.SaleOrderItemMapper;
import com.wow.order.mapper.SaleOrderItemWarehouseMapper;
import com.wow.order.mapper.SaleOrderLogMapper;
import com.wow.order.mapper.SaleOrderMapper;
import com.wow.order.model.ReturnOrder;
import com.wow.order.model.SaleOrder;
import com.wow.order.model.SaleOrderItem;
import com.wow.order.model.SaleOrderItemWarehouse;
import com.wow.order.model.SaleOrderLog;
import com.wow.order.service.OrderService;
import com.wow.order.vo.OrderDetailQuery;
import com.wow.order.vo.OrderItemImgVo;
import com.wow.order.vo.OrderItemVo;
import com.wow.order.vo.OrderListQuery;
import com.wow.order.vo.OrderListVo;
import com.wow.order.vo.OrderQuery;
import com.wow.order.vo.OrderSettleQuery;
import com.wow.order.vo.OrderSettleVo;
import com.wow.order.vo.response.OrderDetailResponse;
import com.wow.order.vo.response.OrderListResponse;
import com.wow.order.vo.response.OrderResponse;
import com.wow.order.vo.response.OrderSettleResponse;
import com.wow.product.mapper.ProductSupplierMapper;
import com.wow.product.model.ProductSupplier;
import com.wow.product.model.ProductSupplierExample;
import com.wow.stock.service.StockService;
import com.wow.stock.vo.FreezeStockVo;
import com.wow.stock.vo.ProductQtyVo;
import com.wow.stock.vo.WarehouseStockFrozenResultVo;
import com.wow.stock.vo.response.BatchFreezeStockResponse;
import com.wow.user.mapper.ShippingInfoMapper;
import com.wow.user.mapper.ShoppingCartMapper;
import com.wow.user.model.ShippingInfo;
import com.wow.user.vo.ShoppingCartQueryVo;
import com.wow.user.vo.ShoppingCartResultVo;

/**
 * 订单服务
 * <p>
 * Created by zhengzhiqing on 16/6/16.
 */
@Service
@Transactional("orderTransactionManager")
public class OrderServiceImpl implements OrderService {
    @Autowired
    private ShoppingCartMapper shoppingCartMapper;

    @Autowired
    private ShippingInfoMapper shippingInfoMapper;

    @Autowired
    private SaleOrderMapper saleOrderMapper;

    @Autowired
    private SaleOrderLogMapper saleOrderLogMapper;

    @Autowired
    private SaleOrderItemMapper saleOrderItemMapper;

    @Autowired
    private SaleOrderItemWarehouseMapper saleOrderItemWarehouseMapper;

    @Autowired
    private ProductSupplierMapper productSupplierMapper;

    @Autowired
    private StockService stockService;

    /**
     * 下单
     *   1. 保存订单相关信息 扣减库存
          2. 每一个包裹里的每种产品做成一个订单项order_item
          3. 订单价格校验 客户端传递订单总价，服务器再次计算价格
     * @param orderVo
     */
    @Override
    public OrderResponse createOrder(OrderQuery query) {
        OrderResponse orderResponse = new OrderResponse();

        // 业务校验开始
        //判断用户购物车id列表是否为空
        if (CollectionUtil.isEmpty(query.getShoppingCartIds())) {
            orderResponse.setResCode("40304");
            orderResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40304"));

            return orderResponse;
        }

        //判断收货地址是否存在
        ShippingInfo shippingInfo = shippingInfoMapper.selectByPrimaryKey(query.getShippingInfoId());
        if (shippingInfo == null) {
            orderResponse.setResCode("40305");
            orderResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40305"));

            return orderResponse;
        }

        query.setShippingInfo(shippingInfo);

        ShoppingCartQueryVo shoppingCartQuery = new ShoppingCartQueryVo();
        shoppingCartQuery.setShoppingCartIds(query.getShoppingCartIds());

        //根据用户购物车id列表 获取用户购物车信息列表
        List<ShoppingCartResultVo> shoppingCartResult = shoppingCartMapper.queryByShoppingCartIds(shoppingCartQuery);

        // 调用库存服务
        List<ProductQtyVo> productQtyVoList = wrapProductQty(shoppingCartResult);
        //调用批量锁定库存服务
        BatchFreezeStockResponse batchFreezeResponse = stockService.batchFreezeStock(productQtyVoList);
        //判断库存是否足够
        if (ErrorCodeUtil.isFailedResponse(batchFreezeResponse.getResCode())) {
            orderResponse.setResCode(batchFreezeResponse.getResCode());
            orderResponse.setResMsg(batchFreezeResponse.getResMsg());

            return orderResponse;
        }

        //设置产品库存使用情况
        query.setFreezeStockVoList(batchFreezeResponse.getFreezeStockVoList());
        //设置用户购买的产品信息列表
        query.setShoppingCartResult(shoppingCartResult);

        //计算订单总金额
        BigDecimal orderAmount = calculateOrderPrice(query);

        //校验订单金额是否正确
        if (NumberUtil.isNotEquals(query.getOrderAmount(), orderAmount)) {
            orderResponse.setResCode("40306");
            orderResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40306"));

            return orderResponse;
        }

        query.setOrderAmount(orderAmount);
        //业务校验结束

        /*** 保存订单开始*/

        //包装订单对象
        SaleOrder saleOrder = wrapOrder(query);
        saleOrderMapper.insertSelective(saleOrder);
        //设置订单id
        query.setOrderId(saleOrder.getId());

        //包装订单项目
        List<SaleOrderItem> saleOrderItems = wrapOrderItem(query);
        for (SaleOrderItem saleOrderItem : saleOrderItems) {
            saleOrderItemMapper.insertSelective(saleOrderItem);
        }

        //保存订单项目仓库信息
        List<SaleOrderItemWarehouse> orderItemWareHouses = wrapAllOrderItemWareHouse(saleOrderItems, query);

        saleOrderItemWarehouseMapper.batchInsertSelective(orderItemWareHouses);

        //写入客户提交订单日志
        SaleOrderLog warpOrderLog = warpOrderLog(saleOrder.getId(), ErrorCodeUtil.getErrorMsg("40357"));
        saleOrderLogMapper.insertSelective(warpOrderLog);

        //清空购物车中用户购买的产品
        ShoppingCartQueryVo shoppingCartQueryVo = new ShoppingCartQueryVo();

        shoppingCartQueryVo.setIsDeleted(Boolean.TRUE);
        shoppingCartQueryVo.setUpdateTime(DateUtil.currentDate());
        shoppingCartQueryVo.setShoppingCartIds(query.getShoppingCartIds());

        shoppingCartMapper.updateByPrimaryKeys(shoppingCartQueryVo);

        /*** 保存订单结束*/

        //设置返回信息
        orderResponse.setOrderId(saleOrder.getId());
        orderResponse.setOrderCode(saleOrder.getOrderCode());

        return orderResponse;
    }

    /**
     * 包装订单产品全部项目仓库信息
     * @param query 
     * 
     * @param wrapOrderItems
     * @return
     */
    private List<SaleOrderItemWarehouse> wrapAllOrderItemWareHouse(List<SaleOrderItem> saleOrderItems, OrderQuery query) {
        List<SaleOrderItemWarehouse> allOrderItemWareHouses = new ArrayList<SaleOrderItemWarehouse>();

        for (SaleOrderItem saleOrderItem : saleOrderItems) {
            FreezeStockVo freezeStockVo = getFreezeStock(query.getFreezeStockVoList(), saleOrderItem.getProductId());
            if (freezeStockVo != null) {
                List<SaleOrderItemWarehouse> orderItemWareHouses = wrapOrderItemWareHouse(saleOrderItem, freezeStockVo
                    .getWarehouseStockFrozenResultVoList());

                allOrderItemWareHouses.addAll(orderItemWareHouses);
            }
        }

        return allOrderItemWareHouses;
    }

    /**
     * 包装订单项目对应的仓库信息
     * 
     * @param saleOrderItem
     * @param warehouseStockFrozenResultVoList
     */
    private List<SaleOrderItemWarehouse> wrapOrderItemWareHouse(SaleOrderItem saleOrderItem, List<WarehouseStockFrozenResultVo> warehouseStocks) {
        List<SaleOrderItemWarehouse> orderItemWareHouses = new ArrayList<SaleOrderItemWarehouse>();

        SaleOrderItemWarehouse saleOrderItemWarehouse = null;
        for (WarehouseStockFrozenResultVo warehouseStock : warehouseStocks) {
            saleOrderItemWarehouse = new SaleOrderItemWarehouse();

            saleOrderItemWarehouse.setSaleOrderItemId(saleOrderItem.getId());
            saleOrderItemWarehouse.setProductId(saleOrderItem.getProductId());

            saleOrderItemWarehouse.setWarehouseId(warehouseStock.getWarehouseId());
            saleOrderItemWarehouse.setFrozenRealStockQty(warehouseStock.getFrozenStock());

            saleOrderItemWarehouse.setCreateTime(DateUtil.currentDate());
            saleOrderItemWarehouse.setUpdateTime(DateUtil.currentDate());
            saleOrderItemWarehouse.setIsDeleted(Boolean.FALSE);

            orderItemWareHouses.add(saleOrderItemWarehouse);
        }

        return orderItemWareHouses;

    }

    /**
     * 根据产品id获取锁定的库存信息
     * 
     * @param freezeStockVoList
     * @param productId
     */
    private FreezeStockVo getFreezeStock(List<FreezeStockVo> freezeStockVoList, int productId) {
        if (CollectionUtil.isEmpty(freezeStockVoList)) {
            return null;
        }

        for (FreezeStockVo freezeStockVo : freezeStockVoList) {
            if (freezeStockVo.getProductId() == productId) {
                return freezeStockVo;
            }
        }

        return null;
    }

    /**
     * 包装产品锁定数量集合
     * 
     * @param shoppingCartResult
     * @return
     */
    private List<ProductQtyVo> wrapProductQty(List<ShoppingCartResultVo> shoppingCartResult) {
        List<ProductQtyVo> productQtyVos = new ArrayList<ProductQtyVo>(shoppingCartResult.size());

        ProductQtyVo productQtyVo = null;
        for (ShoppingCartResultVo shoppingCart : shoppingCartResult) {
            productQtyVo = new ProductQtyVo();
            productQtyVo.setProductId(shoppingCart.getProductId());
            productQtyVo.setProductQty(shoppingCart.getProductQty());

            productQtyVos.add(productQtyVo);
        }

        return productQtyVos;
    }

    //包装订单日志
    private SaleOrderLog warpOrderLog(Integer orderId, String eventLog) {
        SaleOrderLog saleOrderLog = new SaleOrderLog();

        saleOrderLog.setOrderId(orderId);
        saleOrderLog.setEventLog(eventLog);
        saleOrderLog.setEventTime(DateUtil.currentDate());

        return saleOrderLog;
    }

    /**
     * 包装订单信息
     * 
     * @param query
     * @return
     */
    private SaleOrder wrapOrder(OrderQuery query) {
        SaleOrder saleOrder = new SaleOrder();

        //设置订单号
        saleOrder.setEndUserId(query.getEndUserId());
        saleOrder.setOrderCode(RandomGenerator.createRandom(true, 10));
        saleOrder.setEndUserCouponId(query.getEndUserId());

        //设置订单总金额 优惠金额 运费等
        saleOrder.setOrderAmount(query.getOrderAmount());
        saleOrder.setProductAmount(query.getProductAmount());
        saleOrder.setDeliveryFee(query.getDeliveryfee());
        saleOrder.setCouponAmount(query.getCouponFee());

        saleOrder.setEndUserRemarks(query.getRemark());

        //设置收货人地址信息
        ShippingInfo shippingInfo = query.getShippingInfo();

        saleOrder.setReceiverName(shippingInfo.getReceiverName());
        saleOrder.setReceiverProvince(shippingInfo.getProvinceName());
        saleOrder.setReceiverCity(shippingInfo.getCityName());
        saleOrder.setReceiverCounty(shippingInfo.getCountyName());
        saleOrder.setReceiverAddress(shippingInfo.getAddressDetail());
        saleOrder.setReceiverMobile(shippingInfo.getReceiverMobile());
        saleOrder.setReceiverPostcode(shippingInfo.getReceiverPostcode());

        saleOrder.setEndUserRemarks(query.getRemark());

        //设置订单状态为待付款
        saleOrder.setOrderStatus(SaleOrderStatusEnum.TO_BE_PAID.getKey().byteValue());
        saleOrder.setPaymentStatus(CommonConstant.UNPAY);
        saleOrder.setIsUseCoupon(query.getCouponId() == null ? Boolean.FALSE : Boolean.TRUE);
        saleOrder.setEndUserCouponId(query.getCouponId());

        //目前都不是父订单
        saleOrder.setIsLeaf(Boolean.FALSE);
        saleOrder.setOrderSource(query.getOrderSource());
        saleOrder.setOrderIp(IpConvertUtil.ipToLong(query.getOrderIp()));

        saleOrder.setOrderCreateTime(DateUtil.currentDate());
        saleOrder.setUpdateTime(DateUtil.currentDate());

        return saleOrder;
    }

    /**
     * 包装订单项信息
     * 
     * @param query
     * @return
     */
    private List<SaleOrderItem> wrapOrderItem(OrderQuery query) {
        List<SaleOrderItem> saleOrderItems = new ArrayList<SaleOrderItem>();

        List<ShoppingCartResultVo> shoppingCartResult = query.getShoppingCartResult();

        //根据产品id列表获取供应商信息
        List<ProductSupplier> productSuppliers = getSupplierByProductIds(shoppingCartResult);

        SaleOrderItem saleOrderItem = null;
        ProductSupplier productSupplier = null;
        FreezeStockVo freezeStockVo = null;

        for (ShoppingCartResultVo shoppingCart : shoppingCartResult) {
            saleOrderItem = new SaleOrderItem();

            saleOrderItem.setSaleOrderId(query.getOrderId());
            saleOrderItem.setProductId(shoppingCart.getProductId());
            saleOrderItem.setProductName(shoppingCart.getProductName());

            saleOrderItem.setOrderItemPrice(shoppingCart.getSellPrice());
            saleOrderItem.setOrderItemQty(shoppingCart.getProductQty());

            //计算产品总价
            long productTotalPrice = calculateProductTotalPrice(shoppingCart.getSellPrice(), shoppingCart
                .getProductQty());
            saleOrderItem.setOrderItemAmount(NumberUtil.convertToYuan(productTotalPrice));

            //获取产品对应的供应商id
            productSupplier = getSupplierByProductId(productSuppliers, shoppingCart.getProductId());
            if (productSupplier != null) {
                saleOrderItem.setProductSupplierId(productSupplier.getSupplierId());
                saleOrderItem.setProductSaleType(productSupplier.getProductSaleType());
            }

            //获取产品使用的具体库存
            freezeStockVo = getFreezeStock(query.getFreezeStockVoList(), shoppingCart.getProductId());
            if (freezeStockVo != null) {
                saleOrderItem.setFrozenRealStockQty(freezeStockVo.getFrozenWarehouseStockTotalQty());
                saleOrderItem.setFrozenVirtualStockQty(freezeStockVo.getFrozenVirtualStockQty());
                //如果使用虚拟库存的话 则设置虚拟库存是否准备 默认为null
                if (freezeStockVo.getFrozenVirtualStockQty() > 0) {
                    saleOrderItem.setIsVirtualStockReady(Boolean.FALSE); //默认为未准备好
                }
            }

            saleOrderItem.setNeedAssemble(Boolean.FALSE);
            saleOrderItem.setIsItemLeaf(Boolean.FALSE);

            saleOrderItem.setCreateTime(DateUtil.currentDate());
            saleOrderItem.setUpdateTime(DateUtil.currentDate());
            saleOrderItem.setIsDeleted(Boolean.FALSE);

            saleOrderItems.add(saleOrderItem);
        }

        return saleOrderItems;
    }

    /**
     * 
     * 根据产品id列表获取供应商信息
     * @param shoppingCartResult
     */
    private List<ProductSupplier> getSupplierByProductIds(List<ShoppingCartResultVo> shoppingCartResult) {
        List<Integer> productIds = getProductIds(shoppingCartResult);

        ProductSupplierExample productSupplierExample = new ProductSupplierExample();
        ProductSupplierExample.Criteria criteria = productSupplierExample.createCriteria();

        criteria.andProductIdIn(productIds);
        criteria.andIsDeletedEqualTo(Boolean.FALSE);

        return productSupplierMapper.selectByExample(productSupplierExample);
    }

    /**
     * 根据产品id查询相关供应商信息
     * 
     * @param areas
     * @param integer
     */
    private ProductSupplier getSupplierByProductId(List<ProductSupplier> productSuppliers, Integer productId) {
        if (CollectionUtil.isEmpty(productSuppliers)) {
            return null;
        }

        for (ProductSupplier productSupplier : productSuppliers) {
            if (productId.intValue() == productSupplier.getProductId().intValue()) {
                return productSupplier;
            }
        }

        return null;
    }

    /**
     * 获取产品id列表
     * 
     * @param shoppingCartResult
     * @return
     */
    private List<Integer> getProductIds(List<ShoppingCartResultVo> shoppingCartResult) {
        List<Integer> productIds = new ArrayList<>(shoppingCartResult.size());

        for (ShoppingCartResultVo shoppingCart : shoppingCartResult) {
            productIds.add(shoppingCart.getProductId());
        }

        return productIds;
    }

    /**
     * 计算订单运费
     * 
     * @param orderPrice 订单总价
     */
    private long calculateDeliveryFee(long orderPrice) {
        //订单金额小于指定的阀值时计算运费
        if (orderPrice < NumberUtil.convertToFen(CommonConstant.THRESHOLD)) {
            return NumberUtil.convertToFen(CommonConstant.DELIVERYFEE);
        }

        return 0L;
    }

    /**
     * 计算订单总价格
     * 设置订单运费和优惠金额
     * @param query
     * @return
     */
    private BigDecimal calculateOrderPrice(OrderQuery query) {
        List<ShoppingCartResultVo> shoppingCartResult = query.getShoppingCartResult();

        if (CollectionUtil.isEmpty(shoppingCartResult)) {
            return CommonConstant.ZEROB_IGDECIMAL;
        }

        long totalPrice = 0L;
        for (ShoppingCartResultVo shoppingCart : shoppingCartResult) {
            //计算产品总价 产品单价乘以数量
            long productTotalPrice = calculateProductTotalPrice(shoppingCart.getSellPrice(), shoppingCart
                .getProductQty());

            totalPrice += productTotalPrice;
        }

        //设置订单产品总价
        query.setProductAmount(NumberUtil.convertToYuan(totalPrice));

        //计算订单优惠金额
        long couponFee = calculateCouponFee(shoppingCartResult, query.getCouponId());
        query.setCouponFee(NumberUtil.convertToYuan(couponFee));
        totalPrice -= couponFee;

        //计算订单运费
        long deliveryfee = calculateDeliveryFee(totalPrice);
        query.setDeliveryfee(NumberUtil.convertToYuan(deliveryfee));
        totalPrice += deliveryfee;

        return NumberUtil.convertToYuan(totalPrice);
    }

    /**
     * 计算产品总价 产品数量乘以单价
     * 
     * @param sellPrice
     * @param productQty
     * @return
     */
    private long calculateProductTotalPrice(BigDecimal sellPrice, Byte productQty) {
        return NumberUtil.convertToFen(sellPrice) * productQty;
    }

    /**
     * 计算优惠金额
     * 判断优惠券的使用限制和订单总金额
     * @param shoppingCartResult
     * @param couponId
     * @return
     */
    private long calculateCouponFee(List<ShoppingCartResultVo> shoppingCartResult, Integer couponId) {
        return 0L;
    }

    /**
     * 在发货之前取消订单
     *
     * @param order
     */
    @Override
    public CommonResponse cancelOrder(OrderDetailQuery query) {
        CommonResponse commonResponse = new CommonResponse();

        // 业务校验开始
        //校验订单号是否为空
        if (StringUtil.isEmpty(query.getOrderCode())) {
            commonResponse.setResCode("40358");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40358"));

            return commonResponse;
        }

        //根据订单号获取订单
        SaleOrder saleOrder = saleOrderMapper.selectByOrderCode(query.getOrderCode());
        //判断订单号是否存在
        if (saleOrder == null) {
            commonResponse.setResCode("40359");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40359"));

            return commonResponse;
        }

        //如果订单状态为非代付款 则无法取消订单
        if (saleOrder.getOrderStatus().intValue() != SaleOrderStatusEnum.TO_BE_PAID.getKey().intValue()) {
            commonResponse.setResCode("40309");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40309"));

            return commonResponse;
        }

        //如果订单支付状态为已支付  则无法取消订单
        if (saleOrder.getPaymentStatus().intValue() == CommonConstant.PAID) {
            commonResponse.setResCode("40310");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40310"));

            return commonResponse;
        }
        // 业务校验结束

        //调用释放库存服务

        //更新订单状态
        SaleOrder targetSaleOrder = new SaleOrder();

        targetSaleOrder.setId(saleOrder.getId());
        targetSaleOrder.setOrderStatus(SaleOrderStatusEnum.CANCELLED.getKey().byteValue());

        targetSaleOrder.setCancelRequestTime(DateUtil.currentDate());
        targetSaleOrder.setUpdateTime(DateUtil.currentDate());

        saleOrderMapper.updateByPrimaryKeySelective(targetSaleOrder);

        //记录订单操作日志 用户主动取消订单
        SaleOrderLog warpOrderLog = warpOrderLog(saleOrder.getId(), ErrorCodeUtil.getErrorMsg("40358"));
        saleOrderLogMapper.insertSelective(warpOrderLog);

        return commonResponse;
    }

    /**
     * @param orderId
     * @return
     */
    @Override
    public OrderSettleResponse queryOrderById(int orderId) {
        OrderSettleResponse orderResponse = new OrderSettleResponse();

        //设置错误码和错误信息
        orderResponse.setResCode("40001");
        orderResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40001"));

        return orderResponse;
    }

    /**根据订单号获取订单明细
     * @param orderCode
     * @return
     */
    @Override
    public OrderDetailResponse queryOrderByOrderCode(String orderCode) {
        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();

        //校验订单号是否为空
        if (StringUtil.isEmpty(orderCode)) {
            orderDetailResponse.setResCode("40358");
            orderDetailResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40358"));

            return orderDetailResponse;
        }

        //根据订单号获取订单
        SaleOrder saleOrder = saleOrderMapper.selectByOrderCode(orderCode);
        //判断订单号是否存在
        if (saleOrder == null) {
            orderDetailResponse.setResCode("40359");
            orderDetailResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40359"));

            return orderDetailResponse;
        }

        //设置订单明细
        setOrderDetail(orderDetailResponse, saleOrder);

        //获取订单对应的产品信息
        List<OrderItemVo> orderItemVos = saleOrderItemMapper.selectByOrderId(saleOrder.getId());

        orderDetailResponse.setOrderItemVos(orderItemVos);

        return orderDetailResponse;
    }

    /**
     * 设置订单明细
     * 
     * @param orderDetailResponse
     * @param saleOrder
     */
    private void setOrderDetail(OrderDetailResponse orderDetailResponse, SaleOrder saleOrder) {
        orderDetailResponse.setOrderId(saleOrder.getId());
        orderDetailResponse.setOrderCode(saleOrder.getOrderCode());

        orderDetailResponse.setReceiverName(saleOrder.getReceiverName());
        orderDetailResponse.setReceiverMobile(saleOrder.getReceiverMobile());
        orderDetailResponse.setReceiverAddress(saleOrder.getReceiverAddress());

        orderDetailResponse.setOrderAmount(saleOrder.getOrderAmount());
        orderDetailResponse.setDeliveryFee(saleOrder.getDeliveryFee());
        orderDetailResponse.setCouponAmount(saleOrder.getCouponAmount());
        orderDetailResponse.setTotalPackages(saleOrder.getTotalPackages());

        orderDetailResponse.setOrderStatus(saleOrder.getOrderStatus());
        orderDetailResponse.setOrderStatusName(SaleOrderStatusEnum.get(saleOrder.getOrderStatus().intValue()));
        orderDetailResponse.setPaymentStatus(saleOrder.getPaymentStatus());
        orderDetailResponse.setPaymentStatusName(CommonConstant.getPayStatusName(saleOrder.getPaymentStatus()));
        orderDetailResponse.setPaymentMethod(saleOrder.getPaymentMethod());
        orderDetailResponse.setPaymentMethodName(CommonConstant.getDeliveryMothodName(saleOrder.getPaymentMethod()));

        //设置日期格式
        orderDetailResponse.setOrderCreateTimeFormat(DateUtil.formatDatetime(saleOrder.getOrderCreateTime()));
    }

    /**
     * @param endUserId
     * @return
     */
    @Override
    public List<SaleOrder> queryOrdersByUserId(int endUserId) {
        return null;
    }

    /**
     * @param orderLog
     */
    @Override
    public void createOrderLog(SaleOrderLog orderLog) {

    }

    /**
     * @param orderId
     * @return
     */
    @Override
    public List<SaleOrderLog> queryOrderLogsByOrderId(int orderId) {
        return null;
    }

    /**
     * 下退货单
     *
     * @param returnOrder
     * @return
     */
    @Override
    public int placeReturnOrder(ReturnOrder returnOrder) {
        return 0;
    }

    /**
     * 审批退货单
     *
     * @param returnOrder
     * @return
     */
    @Override
    public int approveReturnOrder(ReturnOrder returnOrder) {
        return 0;
    }

    /**
     * 拒绝退货单?
     *
     * @param returnOrder
     * @return
     */
    @Override
    public int rejectReturnOrder(ReturnOrder returnOrder) {
        return 0;
    }

    /**
     * 发货
     *
     * @param order
     */
    @Override
    public boolean deliverGoods(SaleOrder order) {
        return false;
    }

    /**
     * 虚拟库存到货之后发货
     *
     * @param order
     */
    @Override
    public boolean deliverDelayedGoods(SaleOrder order) {
        return false;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public OrderSettleResponse settleOrder(OrderSettleQuery query) {
        OrderSettleResponse response = new OrderSettleResponse();

        // 业务校验开始
        //判断用户购物车id列表是否为空
        if (CollectionUtil.isEmpty(query.getShoppingCartIds())) {
            response.setResCode("40304");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40304"));

            return response;
        }
        //业务校验结束

        ShoppingCartQueryVo shoppingCartQuery = new ShoppingCartQueryVo();
        shoppingCartQuery.setShoppingCartIds(query.getShoppingCartIds());

        //根据用户购物车id列表 获取用户购物车信息列表
        List<ShoppingCartResultVo> shoppingCartResult = shoppingCartMapper.queryByShoppingCartIds(shoppingCartQuery);

        if (CollectionUtil.isEmpty(shoppingCartResult)) {
            return response;
        }

        wrapOrderSettleResponse(response, shoppingCartResult);

        return response;
    }

    /**
     * 包装订单产品项响应类
     * 
     * @param shoppingCartResult
     * @return
     */
    private OrderSettleResponse wrapOrderSettleResponse(OrderSettleResponse response, List<ShoppingCartResultVo> shoppingCartResult) {
        List<OrderSettleVo> orderSettles = new ArrayList<OrderSettleVo>(shoppingCartResult.size());
        long totalPrice = 0L; //订单总价

        OrderSettleVo orderSettle = null;
        for (ShoppingCartResultVo shoppingCartResultVo : shoppingCartResult) {
            orderSettle = new OrderSettleVo();
            BeanUtil.copyProperties(shoppingCartResultVo, orderSettle);

            if (orderSettle.getProductStatus() != null) {
                //转化产品状态名称
                orderSettle.setProductStatusName(ProductStatusEnum.get((int) orderSettle.getProductStatus()));
            }

            //产品单价
            long productPrice = NumberUtil.convertToFen(orderSettle.getSellPrice());
            //计算该产品销售总价( 产品单价乘以数量)
            long sellTotalAmount = productPrice * orderSettle.getProductQty();
            orderSettle.setSellTotalAmount(NumberUtil.convertToYuan(sellTotalAmount));

            //计算订单总价
            totalPrice += sellTotalAmount;

            orderSettles.add(orderSettle);
        }

        //设置订单项信息
        response.setOrderSettles(orderSettles);

        //计算订单运费
        long deliveryfee = calculateDeliveryFee(totalPrice);
        totalPrice += deliveryfee;

        //计算订单总价
        response.setTotalAmount(NumberUtil.convertToYuan(totalPrice));

        return response;
    }

    @Override
    public OrderListResponse queryOrderList(OrderListQuery query) {
        OrderListResponse response = new OrderListResponse();

        // 业务校验开始
        //判断用户id是否为空
        if (query.getEndUserId() == null) {
            response.setResCode("40304");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40304"));

            return response;
        }

        List<OrderListVo> orderLists = saleOrderMapper.selectByEndUserId(query);
        if (CollectionUtil.isEmpty(orderLists)) {
            return response;
        }

        //业务校验结束

        //获取订单id集合
        List<Integer> orderIds = new ArrayList<Integer>(orderLists.size());
        for (OrderListVo orderVo : orderLists) {
            orderIds.add(orderVo.getOrderId());
        }

        List<OrderItemImgVo> orderItemImgs = saleOrderItemMapper.selectSpecImgByOrderIds(orderIds);

        //包装订单产品对应的图片map
        Map<Integer, List<String>> map = getSpecImgMap(orderItemImgs);

        for (OrderListVo orderVo : orderLists) {
            //设置订单状态名称
            orderVo.setOrderStatusName(SaleOrderStatusEnum.get(orderVo.getOrderStatus().intValue()));
            orderVo.setProductSpecImgs(map.get(orderVo.getOrderId()));
        }

        response.setOrderLists(orderLists);

        return response;
    }

    /**
     * 包装订单产品项目的图片信息
     * 
     * @param orderItemImgs
     */
    private Map<Integer, List<String>> getSpecImgMap(List<OrderItemImgVo> orderItemImgs) {
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();

        for (OrderItemImgVo orderItemIm : orderItemImgs) {
            if (map.containsKey(orderItemIm.getSaleOrderId())) {
                map.get(orderItemIm.getSaleOrderId()).add(orderItemIm.getSpecImg());
            } else {
                List<String> orderItemImgList = new ArrayList<String>();
                orderItemImgList.add(orderItemIm.getSpecImg());

                map.put(orderItemIm.getSaleOrderId(), orderItemImgList);
            }

        }

        return map;
    }

    /**
     * 订单支付前的预处理
     * 
     * @param orderCode
     * @return
     */
    @Override
    public CommonResponse payOrder(String orderCode) {
        CommonResponse commonResponse = new CommonResponse();

        return commonResponse;
    }

    /**
     *支付回调通知
     * 
     * @param orderCode
     * @return
     */
    @Override
    public CommonResponse payOrderCallBack(String orderCode) {
        return null;
    }

}