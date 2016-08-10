package com.wow.order.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wow.common.constant.CommonConstant;
import com.wow.common.enums.SaleOrderStatusEnum;
import com.wow.common.page.PageData;
import com.wow.common.page.PageModel;
import com.wow.common.response.CommonResponse;
import com.wow.common.util.BeanUtil;
import com.wow.common.util.CodeGenerator;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.DateUtil;
import com.wow.common.util.DictionaryUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.IpConvertUtil;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.MapUtil;
import com.wow.common.util.NumberUtil;
import com.wow.common.util.StringUtil;
import com.wow.order.mapper.DeliveryOrderMapper;
import com.wow.order.mapper.SaleOrderItemMapper;
import com.wow.order.mapper.SaleOrderItemWarehouseMapper;
import com.wow.order.mapper.SaleOrderLogMapper;
import com.wow.order.mapper.SaleOrderMapper;
import com.wow.order.model.DeliveryOrder;
import com.wow.order.model.DeliveryOrderExample;
import com.wow.order.model.ReturnOrder;
import com.wow.order.model.SaleOrder;
import com.wow.order.model.SaleOrderExample;
import com.wow.order.model.SaleOrderItem;
import com.wow.order.model.SaleOrderItemExample;
import com.wow.order.model.SaleOrderItemWarehouse;
import com.wow.order.model.SaleOrderLog;
import com.wow.order.service.OrderService;
import com.wow.order.vo.DeliveryOrderVo;
import com.wow.order.vo.OrderDeliverQuery;
import com.wow.order.vo.OrderDetailQuery;
import com.wow.order.vo.OrderItemImgVo;
import com.wow.order.vo.OrderItemQuery;
import com.wow.order.vo.OrderItemStockVo;
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
import com.wow.price.model.ProductPrice;
import com.wow.price.service.PriceService;
import com.wow.price.vo.ProductListPriceResponse;
import com.wow.product.mapper.ProductMapper;
import com.wow.product.mapper.ProductSerialMapper;
import com.wow.product.model.Product;
import com.wow.product.model.ProductSerial;
import com.wow.product.model.ProductSerialExample;
import com.wow.stock.service.StockService;
import com.wow.stock.vo.FreezeStockVo;
import com.wow.stock.vo.ProductQtyVo;
import com.wow.stock.vo.ProductWarehouseQtyVo;
import com.wow.stock.vo.UnfreezeStockVo;
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
    private StockService stockService;

    @Autowired
    private PriceService priceService;

    @Autowired
    private DeliveryOrderMapper deliveryOrderMapper;

    @Autowired
    private ProductMapper productMapper;

    @Autowired
    private ProductSerialMapper productSerialMapper;

    /**
     * 下单
     *   1. 保存订单相关信息 扣减库存
          2. 每一个包裹里的每种产品做成一个订单项order_item
          3. 订单价格校验 客户端传递订单总价，服务器再次计算价格 比较价格是否一致
     * @param orderVo
     */
    @Override
    public OrderResponse createOrderFromCart(OrderQuery query) {
        OrderResponse orderResponse = new OrderResponse();

        /*** 业务校验开始*/
        //如果收货地址不存在 则返回错误提示
        ShippingInfo shippingInfo = shippingInfoMapper.selectByPrimaryKey(query.getShippingInfoId());
        if (shippingInfo == null) {
            orderResponse.setResCode("40305");
            orderResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40305"));

            return orderResponse;
        }

        //校验订单来源是否为空
        if (query.getOrderSource() == null) {
            orderResponse.setResCode("40332");
            orderResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40332"));

            return orderResponse;
        }

        ShoppingCartQueryVo shoppingCartQuery = new ShoppingCartQueryVo();
        shoppingCartQuery.setEndUserId(query.getEndUserId());

        //获取用户选中的购物车信息列表
        List<ShoppingCartResultVo> shoppingCartResult = shoppingCartMapper.queryByShoppingCartIds(shoppingCartQuery);

        //如果未找到用户选中的产品 则直接返回错误
        if (CollectionUtil.isEmpty(shoppingCartResult)) {
            orderResponse.setResCode("40311");
            orderResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40311"));

            return orderResponse;
        }

        //购物车产品id列表
        List<Integer> productIds = getProductIds(shoppingCartResult);
        //调用获取产品价格服务
        ProductListPriceResponse priceResponse = priceService.batchGetProductPrice(productIds);

        //判断服务是否调用成功 如果处理失败 则返回错误信息
        if (ErrorCodeUtil.isFailedResponse(priceResponse.getResCode())) {
            orderResponse.setResCode(priceResponse.getResCode());
            orderResponse.setResMsg(priceResponse.getResMsg());

            return orderResponse;
        }

        //设置产品价格
        setProductPrice(shoppingCartResult, priceResponse.getMap());

        //设置结算的产品信息
        query.setShoppingCartResult(shoppingCartResult);
        //设置用户购买的购物车产品信息
        query.setShoppingCartIds(getShoppingCartIds(shoppingCartResult));

        //计算订单总金额
        BigDecimal orderAmount = calculateOrderPrice(query);

        //校验客户端提交订单金额是否正确
        if (NumberUtil.isNotEquals(query.getOrderAmount(), orderAmount)) {
            orderResponse.setResCode("40306");
            orderResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40306"));

            return orderResponse;
        }

        // 调用库存服务
        List<ProductQtyVo> productQtyVoList = wrapProductQty(shoppingCartResult);
        //调用批量锁定库存服务
        BatchFreezeStockResponse batchFreezeResponse = stockService.batchFreezeStock(productQtyVoList);
        //如果调用库存服务失败 则返回错误提示
        if (ErrorCodeUtil.isFailedResponse(batchFreezeResponse.getResCode())) {
            orderResponse.setResCode(batchFreezeResponse.getResCode());
            orderResponse.setResMsg(batchFreezeResponse.getResMsg());

            return orderResponse;
        }

        //设置产品库存使用情况
        query.setFreezeStockVoList(batchFreezeResponse.getFreezeStockVoList());
        //设置订单总金额
        query.setOrderAmount(orderAmount);
        //设置订单收件人信息
        query.setShippingInfo(shippingInfo);
        /*** 业务校验结束*/

        //保存订单
        saveOrder(query, orderResponse);

        return orderResponse;
    }

    /**
     * 保存订单
     * 
     * @param query
     * @param orderResponse
     */
    private OrderResponse saveOrder(OrderQuery query, OrderResponse orderResponse) {
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

        //如果有实际库存则保存冻结的库存信息
        if (CollectionUtil.isNotEmpty(orderItemWareHouses)) {
            saleOrderItemWarehouseMapper.batchInsertSelective(orderItemWareHouses);
        }

        //写入客户提交订单日志
        SaleOrderLog warpOrderLog = warpOrderLog(saleOrder.getId(), ErrorCodeUtil.getErrorMsg("40357"));
        saleOrderLogMapper.insertSelective(warpOrderLog);

        //如果是正常从购物车创建订单
        if (query.getProductId() == null) {
            //清空购物车中用户购买的产品
            ShoppingCartQueryVo shoppingCartQueryVo = new ShoppingCartQueryVo();

            shoppingCartQueryVo.setIsDeleted(Boolean.TRUE);
            shoppingCartQueryVo.setUpdateTime(DateUtil.currentDate());
            shoppingCartQueryVo.setShoppingCartIds(query.getShoppingCartIds());

            shoppingCartMapper.updateByPrimaryKeys(shoppingCartQueryVo);
        }
        /*** 保存订单结束*/

        //设置返回信息
        orderResponse.setOrderId(saleOrder.getId());
        orderResponse.setOrderCode(saleOrder.getOrderCode());

        return orderResponse;
    }

    /*
     * 获取用户购买的购物车id列表
     */
    private List<Integer> getShoppingCartIds(List<ShoppingCartResultVo> shoppingCartResult) {
        List<Integer> shoppingCartIds = new ArrayList<>(shoppingCartResult.size());

        for (ShoppingCartResultVo shoppingCart : shoppingCartResult) {
            shoppingCartIds.add(shoppingCart.getShoppingCartId());
        }

        return shoppingCartIds;
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
        //如果没有实际库存 则直接返回
        if (CollectionUtil.isEmpty(warehouseStocks)) {
            return Collections.emptyList();
        }

        List<SaleOrderItemWarehouse> orderItemWareHouses = new ArrayList<SaleOrderItemWarehouse>();

        SaleOrderItemWarehouse saleOrderItemWarehouse = null;
        for (WarehouseStockFrozenResultVo warehouseStock : warehouseStocks) {
            saleOrderItemWarehouse = new SaleOrderItemWarehouse();

            saleOrderItemWarehouse.setSaleOrderItemId(saleOrderItem.getId());

            saleOrderItemWarehouse.setWarehouseId(warehouseStock.getWarehouseId());
            saleOrderItemWarehouse.setFrozenWarehouseStockQty(warehouseStock.getFrozenStock());

            saleOrderItemWarehouse.setCreateTime(DateUtil.currentDate());

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

        saleOrderLog.setSaleOrderId(orderId);
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

        saleOrder.setEndUserId(query.getEndUserId());
        saleOrder.setOrderCode(CodeGenerator.createOrderNo(query.getEndUserId()));
        saleOrder.setEndUserCouponId(query.getEndUserId());

        //设置订单总金额 优惠金额 运费等
        saleOrder.setOrderAmount(query.getOrderAmount());
        saleOrder.setProductAmount(query.getProductAmount());
        saleOrder.setDeliveryFee(query.getDeliveryfee());
        saleOrder.setPreferentialAmount(query.getCouponFee());

        saleOrder.setEndUserRemark(query.getRemark());
        saleOrder.setTotalProductQty(query.getTotalProductQty());//设置总的商品件数
        saleOrder.setUnShipOutQty(query.getShoppingCartResult().size()); //设置未发货的商品数 默认为用户订购的产品数

        //设置收货人地址信息
        ShippingInfo shippingInfo = query.getShippingInfo();

        saleOrder.setReceiverName(shippingInfo.getReceiverName());
        saleOrder.setReceiverProvince(shippingInfo.getProvinceName());
        saleOrder.setReceiverCity(shippingInfo.getCityName());
        saleOrder.setReceiverCounty(shippingInfo.getCountyName());
        //设置收件人详细地址 省市区加上地址信息
        String addressDetail = getAddressDetail(shippingInfo);
        saleOrder.setReceiverAddress(addressDetail);
        saleOrder.setReceiverMobile(shippingInfo.getReceiverMobile());
        saleOrder.setReceiverPostcode(shippingInfo.getReceiverPostcode());

        saleOrder.setEndUserRemark(query.getRemark());

        //设置订单状态为待付款
        saleOrder.setOrderStatus(SaleOrderStatusEnum.TO_BE_PAID.getKey().byteValue());
        saleOrder.setPaymentStatus(CommonConstant.UNPAY);
        saleOrder.setIsUseCoupon(query.getCouponId() == null ? Boolean.FALSE : Boolean.TRUE);
        saleOrder.setEndUserCouponId(query.getCouponId());

        saleOrder.setOrderSource(query.getOrderSource());
        saleOrder.setOrderIp(IpConvertUtil.ipToLong(query.getOrderIp()));

        saleOrder.setOrderCreateTime(DateUtil.currentDate());
        saleOrder.setUpdateTime(DateUtil.currentDate());

        return saleOrder;
    }

    /**
     * 获取收货人地址详细信息
     * 
     * @param shippingInfo
     * @return
     */
    private String getAddressDetail(ShippingInfo shippingInfo) {
        StringBuilder sb = new StringBuilder();

        sb.append(shippingInfo.getProvinceName());
        sb.append(shippingInfo.getCityName());
        sb.append(shippingInfo.getCountyName());
        sb.append(shippingInfo.getAddressDetail());

        return sb.toString();
    }

    /**
     * 包装订单项信息
     * 
     * @param query
     * @return
     */
    private List<SaleOrderItem> wrapOrderItem(OrderQuery query) {
        List<ShoppingCartResultVo> shoppingCartResult = query.getShoppingCartResult();

        List<SaleOrderItem> saleOrderItems = new ArrayList<SaleOrderItem>(shoppingCartResult.size());

        SaleOrderItem saleOrderItem = null;
        FreezeStockVo freezeStockVo = null;

        for (ShoppingCartResultVo shoppingCart : shoppingCartResult) {
            saleOrderItem = new SaleOrderItem();

            saleOrderItem.setSaleOrderId(query.getOrderId());
            saleOrderItem.setProductId(shoppingCart.getProductId());
            saleOrderItem.setParentProductId(shoppingCart.getParentProductId());
            saleOrderItem.setProductName(shoppingCart.getProductName());

            saleOrderItem.setOrderItemPrice(shoppingCart.getSellPrice());
            saleOrderItem.setOrderItemQty(shoppingCart.getProductQty());

            //计算产品总价
            long productTotalPrice = calculateProductTotalPrice(shoppingCart.getSellPrice(), shoppingCart
                .getProductQty());
            saleOrderItem.setOrderItemAmount(NumberUtil.convertToYuan(productTotalPrice));

            //获取产品使用的具体库存
            freezeStockVo = getFreezeStock(query.getFreezeStockVoList(), shoppingCart.getProductId());
            if (freezeStockVo != null) {
                //设置该产品使用的库存总数和虚拟库存总数
                saleOrderItem.setFrozenWarehouseStockTotalQty(freezeStockVo.getFrozenWarehouseStockTotalQty());
                saleOrderItem.setFrozenVirtualStockQty(freezeStockVo.getFrozenVirtualStockQty());
                //设置虚拟库存是否准备 默认为未准备好
                saleOrderItem.setIsVirtualStockReady(Boolean.FALSE);
            }

            saleOrderItem.setNeedAssemble(Boolean.FALSE);

            saleOrderItem.setCreateTime(DateUtil.currentDate());
            saleOrderItem.setUpdateTime(DateUtil.currentDate());
            saleOrderItem.setIsDeleted(Boolean.FALSE);

            saleOrderItems.add(saleOrderItem);
        }

        return saleOrderItems;
    }

    /**
     * 计算订单运费
     * 
     * @param orderPrice 订单总价
     */
    private long calculateDeliveryFee(long orderPrice) {
        //订单金额小于指定的阀值时计算运费
        if (orderPrice <CommonConstant.THRESHOLD_LONG) {
            return CommonConstant.DELIVERYFEE_LONG;
        }
        
        return 0L;
    }

    /**
     * 计算订单总价格  从购物车过来进行计算
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
        int totalProductQty = 0;
        for (ShoppingCartResultVo shoppingCart : shoppingCartResult) {
            //计算产品总价 产品单价乘以数量
            long productTotalPrice = calculateProductTotalPrice(shoppingCart.getSellPrice(), shoppingCart
                .getProductQty());

            totalProductQty += shoppingCart.getProductQty();
            totalPrice += productTotalPrice;
        }

        //设置商品总件数
        query.setTotalProductQty(totalProductQty);
        //设置订单商品总价
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
     * 计算优惠金额 暂未实行
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

        /*** 业务校验开始*/

        //如果订单号为空 则直接返回错误提示
        if (StringUtil.isEmpty(query.getOrderCode())) {
            commonResponse.setResCode("40358");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40358"));

            return commonResponse;
        }

        //根据订单号获取订单
        SaleOrder saleOrder = selectByOrderCode(query.getOrderCode());
        //如果订单号不存在  则直接返回错误提示
        if (saleOrder == null) {
            commonResponse.setResCode("40359");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40359"));

            return commonResponse;
        }

        //如果订单状态为交易关闭 则无法取消订单
        if (saleOrder.getOrderStatus().intValue() == SaleOrderStatusEnum.CLOSED.getKey().intValue()) {
            commonResponse.setResCode("40321");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40321"));

            return commonResponse;
        }

        //如果订单状态为已取消 则无法重复取消订单
        if (saleOrder.getOrderStatus().intValue() == SaleOrderStatusEnum.CANCELLED.getKey().intValue()) {
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

        //获取需要释放库存的产品
        List<UnfreezeStockVo> unfreezeStocks = getUnfreezeStocks(saleOrder.getId());
        //调用释放库存服务
        CommonResponse unfreezeStockResponse = stockService.batchUnfreezeStock(unfreezeStocks);
        //如果调用释放库存服务失败 则返回错误提示
        if (ErrorCodeUtil.isFailedResponse(unfreezeStockResponse.getResCode())) {
            return unfreezeStockResponse;
        }

        /*** 业务校验结束*/

        //更新订单状态
        SaleOrder targetSaleOrder = new SaleOrder();

        targetSaleOrder.setId(saleOrder.getId());
        //如果是自动取消订单 则订单状态为交易关闭
        if (query.isAutoCancel()) {
            targetSaleOrder.setOrderStatus(SaleOrderStatusEnum.CLOSED.getKey().byteValue());
        } else {
            //否则订单状态为订单已取消
            targetSaleOrder.setOrderStatus(SaleOrderStatusEnum.CANCELLED.getKey().byteValue());
        }

        targetSaleOrder.setCancelRequestTime(DateUtil.currentDate());
        targetSaleOrder.setUpdateTime(DateUtil.currentDate());

        saleOrderMapper.updateByPrimaryKeySelective(targetSaleOrder);

        //记录订单操作日志 
        //如果是自动取消订单 则订单日志为系统取消订单 否则为用户主动取消订单
        String errorCode = query.isAutoCancel() ? "40360" : "40358";

        SaleOrderLog warpOrderLog = warpOrderLog(saleOrder.getId(), ErrorCodeUtil.getErrorMsg(errorCode));
        saleOrderLogMapper.insertSelective(warpOrderLog);

        return commonResponse;
    }

    /**
     * 根据订单id获取要解冻的产品库存信息
     * 
     * @param orderId
     * @return
     */
    private List<UnfreezeStockVo> getUnfreezeStocks(Integer orderId) {
        //根据订单id获取产品使用的库存情况
        List<OrderItemStockVo> orderItemStocks = saleOrderItemMapper.selectWareHouseStockByOrderId(orderId);

        List<UnfreezeStockVo> stockVos = new ArrayList<UnfreezeStockVo>(orderItemStocks.size());
        UnfreezeStockVo stockVo = null;

        for (OrderItemStockVo orderItemStock : orderItemStocks) {
            stockVo = new UnfreezeStockVo();

            stockVo.setOrderId(orderId);
            stockVo.setProductId(orderItemStock.getProductId());
            stockVo.setVirtualProductQty(orderItemStock.getVirtualProductQty());
            String json = JsonUtil.pojo2Json(orderItemStock.getOrderItemProductStockVos());
            stockVo.setProductWarehouseQtyVoList(Arrays.asList(JsonUtil.fromJSON(json, ProductWarehouseQtyVo[].class)));

            stockVos.add(stockVo);
        }

        return stockVos;
    }

    /**根据订单号获取订单明细
     * @param orderCode
     * @return
     */
    @Override
    public OrderDetailResponse queryOrderDetailByOrderCode(OrderDetailQuery query) {
        OrderDetailResponse orderDetailResponse = new OrderDetailResponse();

        /*** 业务校验开始*/
        //如果订单号是否为空  则直接返回错误提示
        if (StringUtil.isEmpty(query.getOrderCode())) {
            orderDetailResponse.setResCode("40358");
            orderDetailResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40358"));

            return orderDetailResponse;
        }

        //根据订单号获取订单
        SaleOrder saleOrder = selectByOrderCode(query.getOrderCode());
        //如果订单号不存在  则直接返回错误提示
        if (saleOrder == null) {
            orderDetailResponse.setResCode("40359");
            orderDetailResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40359"));

            return orderDetailResponse;
        }

        //如果用户查看的订单不是自己的 不允许查看
        if (saleOrder.getEndUserId().intValue() != query.getEndUserId().intValue()) {
            orderDetailResponse.setResCode("40331");
            orderDetailResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40331"));

            return orderDetailResponse;
        }

        /*** 业务校验结束*/

        //设置订单明细
        setOrderDetail(orderDetailResponse, saleOrder);

        //获取订单对应的商品信息
        List<OrderItemVo> orderItems = saleOrderItemMapper.selectByOrderId(saleOrder.getId());

        //处理未发货的商品清单
        List<OrderItemVo> unShipOutOrderItems = getUnShipOutOrderItems(orderItems);

        orderDetailResponse.setUnShipOutOrderItems(unShipOutOrderItems);

        //如果订单状态为部分发货以后状态是 才显示发货单信息
        if (saleOrder.getOrderStatus().byteValue() >= SaleOrderStatusEnum.PARTIAL_SHIPPED.getKey().byteValue()) {
            //获取发货单信息
            List<DeliveryOrderVo> deliveryOrderVos = getDeliveryOrderInfo(saleOrder.getId(), orderItems);

            orderDetailResponse.setPackages(deliveryOrderVos);
        }

        return orderDetailResponse;
    }

    /**
     * 获取未发货清单列表
     * 
     * @param orderItems
     * @return
     */
    private List<OrderItemVo> getUnShipOutOrderItems(List<OrderItemVo> orderItems) {
        List<OrderItemVo> unShipOutOrderItems = new ArrayList<OrderItemVo>(orderItems.size());

        for (OrderItemVo orderItemVo : orderItems) {
            if (!orderItemVo.getIsShippedOut()) {
                unShipOutOrderItems.add(orderItemVo);
            }
        }

        return unShipOutOrderItems;
    }

    /**
     * 获取发货单信息
     * 
     * @param orderId
     * @param orderItems
     * @return
     */
    private List<DeliveryOrderVo> getDeliveryOrderInfo(Integer orderId, List<OrderItemVo> orderItems) {
        DeliveryOrderExample deliveryOrderExample = new DeliveryOrderExample();
        DeliveryOrderExample.Criteria criteria = deliveryOrderExample.createCriteria();
        criteria.andSaleOrderIdEqualTo(orderId);

        List<DeliveryOrder> deliveryOrders = deliveryOrderMapper.selectByExample(deliveryOrderExample);

        //获取发货单对应的商品信息
        Map<Integer, List<OrderItemVo>> map = getDeliveryOrderMap(orderItems);

        List<DeliveryOrderVo> deliveryOrderVos = new ArrayList<DeliveryOrderVo>(deliveryOrders.size());
        DeliveryOrderVo deliveryOrderVo = null;
        for (DeliveryOrder deliveryOrder : deliveryOrders) {
            deliveryOrderVo = new DeliveryOrderVo();
            deliveryOrderVo.setDeliveryCompanyCode(deliveryOrder.getDeliveryCompanyCode());
            deliveryOrderVo.setDeliveryCompanyName(deliveryOrder.getDeliveryCompanyName());
            deliveryOrderVo.setDeliveryOrderNo(deliveryOrder.getDeliveryOrderNo());

            deliveryOrderVo.setOrderItems(map.get(deliveryOrder.getId()));

            deliveryOrderVos.add(deliveryOrderVo);
        }

        return deliveryOrderVos;
    }

    /**
     * 获取发货单对应的商品信息
     * 
     * @param orderItems
     * @return
     */
    private Map<Integer, List<OrderItemVo>> getDeliveryOrderMap(List<OrderItemVo> orderItems) {
        Map<Integer, List<OrderItemVo>> map = new HashMap<Integer, List<OrderItemVo>>();

        for (OrderItemVo orderItemVo : orderItems) {
            if (map.containsKey(orderItemVo.getDeliveryOrderId())) {
                map.get(orderItemVo.getDeliveryOrderId()).add(orderItemVo);
            } else {
                List<OrderItemVo> orderItemList = new ArrayList<OrderItemVo>();
                orderItemList.add(orderItemVo);
                map.put(orderItemVo.getDeliveryOrderId(), orderItemList);
            }
        }

        return map;
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

        //设置订单金额
        orderDetailResponse.setReceiverName(saleOrder.getReceiverName());
        orderDetailResponse.setReceiverMobile(saleOrder.getReceiverMobile());
        orderDetailResponse.setReceiverAddress(saleOrder.getReceiverAddress());

        //设置订单金额相关
        orderDetailResponse.setOrderAmount(saleOrder.getOrderAmount());
        orderDetailResponse.setProductAmount(saleOrder.getProductAmount());
        orderDetailResponse.setDeliveryFee(saleOrder.getDeliveryFee());
        orderDetailResponse.setCouponAmount(saleOrder.getPreferentialAmount());
        orderDetailResponse.setTotalProductQty(saleOrder.getTotalProductQty());

        //设置订单状态 支付状态 支付方式
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

        ShoppingCartQueryVo shoppingCartQuery = new ShoppingCartQueryVo();
        shoppingCartQuery.setEndUserId(query.getEndUserId());

        //获取用户选中的购物车信息列表
        List<ShoppingCartResultVo> shoppingCartResult = shoppingCartMapper.queryByShoppingCartIds(shoppingCartQuery);

        if (CollectionUtil.isEmpty(shoppingCartResult)) {
            response.setResCode("40311");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40311"));

            return response;
        }

        //购物车产品id列表
        List<Integer> productIds = getProductIds(shoppingCartResult);
        //调用获取产品价格服务
        ProductListPriceResponse priceResponse = priceService.batchGetProductPrice(productIds);

        //判断服务是否调用成功 如果处理失败 则返回错误信息
        if (ErrorCodeUtil.isFailedResponse(priceResponse.getResCode())) {
            response.setResCode(priceResponse.getResCode());
            response.setResMsg(priceResponse.getResMsg());

            return response;
        }
        //业务校验结束

        //设置产品价格
        setProductPrice(shoppingCartResult, priceResponse.getMap());

        //包装订单结算信息
        wrapOrderSettleResponse(response, shoppingCartResult);

        return response;
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
     * 设置产品价格
     * 
     * @param shoppingCartResult
     * @param map
     */
    private void setProductPrice(List<ShoppingCartResultVo> shoppingCartResult, Map<Integer, ProductPrice> map) {
        if (MapUtil.isEmpty(map)) {
            return;
        }

        ProductPrice productPrice = null;

        //设置产品价格
        for (ShoppingCartResultVo shoppingCart : shoppingCartResult) {
            productPrice = map.get(shoppingCart.getProductId());

            //设置产品价格
            if (productPrice != null) {
                shoppingCart.setSellPrice(productPrice.getSellPrice());
            }
        }
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

            //产品单价
            long productPrice = NumberUtil.convertToFen(orderSettle.getSellPrice());
            //计算该产品销售总价( 产品单价乘以数量)
            long sellTotalAmount = productPrice * orderSettle.getProductQty();
            orderSettle.setProductTotalAmount(NumberUtil.convertToYuan(sellTotalAmount));

            //计算订单总价
            totalPrice += sellTotalAmount;

            orderSettles.add(orderSettle);
        }

        //设置订单项信息
        response.setOrderSettles(orderSettles);
        //设置订单产品总价(不包含运费)
        response.setProductTotalAmount(NumberUtil.convertToYuan(totalPrice));

        //计算订单运费
        long deliveryfee = calculateDeliveryFee(totalPrice);
        totalPrice += deliveryfee;

        //设置订单运费
        response.setDeliveryFee(NumberUtil.convertToYuan(deliveryfee));
        //设置订单总价
        response.setTotalAmount(NumberUtil.convertToYuan(totalPrice));

        return response;
    }

    @Override
    @Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
    public OrderListResponse queryOrderListPage(OrderListQuery query) {
        OrderListResponse response = new OrderListResponse();

        // 业务校验开始
        //判断用户id是否为空
        if (query.getEndUserId() == null) {
            response.setResCode("40304");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40304"));

            return response;
        }

        //设置分页查询对象
        PageModel model = new PageModel();
        if (query.getPageSize() != null) {
            model.setShowCount(query.getPageSize());
        }
        if (query.getCurrentPage() != null) {
            model.setCurrentPage(query.getCurrentPage());
        }
        model.setModel(query);

        List<PageData> pageDataList = saleOrderMapper.selectListPage(model);
        if (CollectionUtil.isEmpty(pageDataList)) {
            return response;
        }
        //业务校验结束

        List<OrderListVo> orderLists = Arrays.asList(JsonUtil.fromJSON(pageDataList, OrderListVo[].class));

        //获取订单id集合
        List<Integer> orderIds = new ArrayList<Integer>(orderLists.size());
        for (OrderListVo orderVo : orderLists) {
            orderIds.add(orderVo.getOrderId());
        }

        List<OrderItemImgVo> orderItemImgs = saleOrderItemMapper.selectSpecImgByOrderIds(orderIds);

        //包装订单产品对应的图片map
        Map<Integer, List<String>> map = getSpecImgMap(orderItemImgs);

        for (OrderListVo orderVo : orderLists) {
            //设置订单创建时间格式
            orderVo.setOrderCreateTimeFormat(DateUtil.formatDatetime(orderVo.getOrderCreateTime()));
            orderVo.setOrderCreateTime(null); //不序列化输出
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
            if (StringUtil.isEmpty(orderItemIm.getSpecImg())) {
                continue;
            }

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

    /**
    * 订单发货
    * @see com.wow.order.service.OrderService#deliverGoods(com.wow.order.vo.OrderDeliverQuery)
    */
    @Override
    public CommonResponse deliverGoods(OrderDeliverQuery query) {
        CommonResponse commonResponse = new CommonResponse();

        /*** 业务校验开始*/
        //如果用户购物车id列表为空  则返回错误提示
        if (CollectionUtil.isEmpty(query.getSaleOrderItemIds())) {
            commonResponse.setResCode("40311");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40311"));

            return commonResponse;
        }

        //如果订单号为空 则直接返回错误提示
        if (StringUtil.isEmpty(query.getOrderCode())) {
            commonResponse.setResCode("40307");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40307"));

            return commonResponse;
        }

        SaleOrder saleOrder = selectByOrderCode(query.getOrderCode());

        //如果订单号不存在  则直接返回错误提示
        if (saleOrder == null) {
            commonResponse.setResCode("40308");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40308"));

            return commonResponse;
        }

        //如果订单状态为已取消 则无法重复取消订单
        if (saleOrder.getOrderStatus().intValue() == SaleOrderStatusEnum.CANCELLED.getKey().intValue()) {
            commonResponse.setResCode("40309");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40309"));

            return commonResponse;
        }

        //如果订单状态为交易已关闭  则无法发货
        if (saleOrder.getOrderStatus().intValue() == SaleOrderStatusEnum.CLOSED.getKey().intValue()) {
            commonResponse.setResCode("40321");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40321"));

            return commonResponse;
        }

        //如果订单支付状态为未支付  则无法发货
        if (saleOrder.getPaymentStatus().byteValue() == CommonConstant.UNPAY.byteValue()) {
            commonResponse.setResCode("40323");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40323"));

            return commonResponse;
        }

        //如果未发货的数量为0 则直接返回错误提示 不可重复发货
        if (saleOrder.getUnShipOutQty() == 0) {
            commonResponse.setResCode("40313");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40313"));

            return commonResponse;
        }

        query.setOrderId(saleOrder.getId());

        //获取未发货的订单项
        SaleOrderItemExample saleOrderItemExample = new SaleOrderItemExample();
        SaleOrderItemExample.Criteria criteria = saleOrderItemExample.createCriteria();

        criteria.andIdIn(query.getSaleOrderItemIds());
        criteria.andIsShippedOutEqualTo(Boolean.FALSE);

        int saleOrderItems = saleOrderItemMapper.countByExample(saleOrderItemExample);

        //如果发货的商品清单id不正确  则直接返回错误提示
        if (saleOrderItems != query.getSaleOrderItemIds().size()) {
            commonResponse.setResCode("40312");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40312"));

            return commonResponse;
        }

        /*** 业务校验结束*/

        /*** 拆分包裹开始
         *     1.  生成发货单
         *     2.  更新订单项发货状态
         *     3.  绑定订单项目到发货单
         *     4 . 修改订单状态 部分发货或者已发货
         * */

        //生成发货单
        DeliveryOrder deliveryOrder = wrapDeliveryOrder(query);
        deliveryOrderMapper.insertSelective(deliveryOrder);

        //更新订单项发货状态
        OrderItemQuery orderItemQuery = new OrderItemQuery();

        orderItemQuery.setDeliveryOrderId(deliveryOrder.getId());
        orderItemQuery.setOrderItemIds(query.getSaleOrderItemIds());

        saleOrderItemMapper.updateDeliveryByIds(orderItemQuery);

        //修改订单状态 判断是部分发货还是全部发货
        SaleOrder targetOrder = new SaleOrder();
        targetOrder.setId(saleOrder.getId());
        //重新设置未发货的商品个数
        int unShipOutQty = saleOrder.getUnShipOutQty() - query.getSaleOrderItemIds().size();
        targetOrder.setUnShipOutQty(unShipOutQty);
        //如果未发货商品数量为0 则设置订单状态为待收货
        if (unShipOutQty == 0) {
            targetOrder.setOrderStatus(SaleOrderStatusEnum.TO_BE_RECEIVED.getKey().byteValue());
        } else {
            //如果还有部分商品未发货 则设置订单状态为部分发货
            targetOrder.setOrderStatus(SaleOrderStatusEnum.PARTIAL_SHIPPED.getKey().byteValue());
        }
        targetOrder.setUpdateTime(DateUtil.currentDate());

        saleOrderMapper.updateByPrimaryKeySelective(targetOrder);
        /*** 拆分包裹结束*/

        //记录操作日志
        SaleOrderLog warpOrderLog = warpOrderLog(saleOrder.getId(), ErrorCodeUtil.getErrorMsg("40314"));
        saleOrderLogMapper.insertSelective(warpOrderLog);

        return commonResponse;
    }

    /**
     * 根据订单号获取订单信息
     * 
     * @param orderCode
     * @return
     */
    private SaleOrder selectByOrderCode(String orderCode) {
        //根据订单号获取订单
        SaleOrderExample saleOrderExample = new SaleOrderExample();
        SaleOrderExample.Criteria criteria = saleOrderExample.createCriteria();
        criteria.andOrderCodeEqualTo(orderCode);

        return saleOrderMapper.selectOnlyByExample(saleOrderExample);
    }

    /**
     * 包装发货单信息
     * 
     * @param query
     * @return
     */
    private DeliveryOrder wrapDeliveryOrder(OrderDeliverQuery query) {
        DeliveryOrder deliveryOrder = new DeliveryOrder();

        deliveryOrder.setSaleOrderId(query.getOrderId());
        deliveryOrder.setDeliveryMothod(query.getDeliveryMothod());
        //从数据字典中获取配送公司名称
        deliveryOrder.setDeliveryCompanyCode(query.getDeliveryCompanyCode());
        String companyName = DictionaryUtil.getValue("delivery_company", query.getDeliveryCompanyCode());
        deliveryOrder.setDeliveryCompanyName(companyName);
        deliveryOrder.setDeliveryOrderNo(query.getDeliveryOrderNo()); //设置配送单号
        deliveryOrder.setShipOutDate(DateUtil.currentDate()); //设置配送日期
        deliveryOrder.setCreateTime(DateUtil.currentDate());

        return deliveryOrder;
    }

    @Override
    public CommonResponse autoCancel(int timeoutMinute) {
        CommonResponse commonResponse = new CommonResponse();

        //查询超过20分钟仍然没有支付的订单列表
        List<SaleOrder> saleOrders = saleOrderMapper.selectTimeOutUnpayOrder(timeoutMinute);
        if (CollectionUtil.isEmpty(saleOrders)) {
            return commonResponse;
        }

        OrderDetailQuery query = new OrderDetailQuery();
        query.setAutoCancel(true);

        for (SaleOrder saleOrder : saleOrders) {
            query.setOrderCode(saleOrder.getOrderCode());

            //调用取消订单服务
            cancelOrder(query);
        }

        return commonResponse;
    }

    @Override
    public OrderSettleResponse buyNow(OrderSettleQuery query) {
        OrderSettleResponse response = new OrderSettleResponse();

        //校验产品id是否为空
        if (query.getProductId() == null) {
            response.setResCode("40316");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40316"));

            return response;
        }

        Product product = productMapper.selectByPrimaryKey(query.getProductId());

        //校验产品是否存在
        if (product == null) {
            response.setResCode("40301");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40301"));

            return response;
        }

        //调用获取产品价格服务
        ProductListPriceResponse priceResponse = priceService.batchGetProductPrice(Arrays.asList(query.getProductId()));

        //判断服务是否调用成功 如果处理失败 则返回错误信息
        if (ErrorCodeUtil.isFailedResponse(priceResponse.getResCode())) {
            response.setResCode(priceResponse.getResCode());
            response.setResMsg(priceResponse.getResMsg());

            return response;
        }

        //如果该产品价格不存在 则直接返回
        if (MapUtil.isEmpty(priceResponse.getMap()) || !priceResponse.getMap().containsKey(product.getId())) {
            response.setResCode("40326");
            response.setResMsg(ErrorCodeUtil.getErrorMsg("40326"));

            return response;
        }

        //业务校验结束

        //如果购买的产品数量为空 则默认为1
        if (query.getProductQty() == null) {
            query.setProductQty((byte) 1);
        }

        //设置产品价格
        ShoppingCartResultVo shoppingCartResultVo = wrapShoppingCart(product, priceResponse.getMap());
        //设置产品数量
        shoppingCartResultVo.setProductQty(query.getProductQty());
        //计算产品总价
        long productTotalPrice = calculateProductTotalPrice(shoppingCartResultVo.getSellPrice(), shoppingCartResultVo
            .getProductQty());

        shoppingCartResultVo.setProductTotalAmount(NumberUtil.convertToYuan(productTotalPrice));

        //包装购物车结算信息
        wrapOrderSettleResponse(response, Arrays.asList(shoppingCartResultVo));

        return response;
    }

    /**
     * 设置产品价格
     * 
     * @param product
     * @param map
     * @return
     */
    private ShoppingCartResultVo wrapShoppingCart(Product product, Map<Integer, ProductPrice> map) {
        ProductPrice productPrice = map.get(product.getId());

        ShoppingCartResultVo shoppingCartResultVo = new ShoppingCartResultVo();

        //获取父产品信息
        ProductSerial parentProduct = getParentProduct(product.getId());
        shoppingCartResultVo.setParentProductId(parentProduct == null ? 0 : parentProduct.getProductId());

        shoppingCartResultVo.setProductId(product.getId());
        shoppingCartResultVo.setProductName(product.getProductName());
        shoppingCartResultVo.setSellPrice(productPrice.getSellPrice());
        shoppingCartResultVo.setColor(product.getColorDisplayName());
        shoppingCartResultVo.setSpecName(product.getSpecName());
        shoppingCartResultVo.setSpecImg(product.getProductColorImg());

        return shoppingCartResultVo;
    }

    @Override
    public OrderResponse createOrderFromDirect(OrderQuery query) {
        OrderResponse orderResponse = new OrderResponse();

        //校验产品id是否为空
        if (query.getProductId() == null) {
            orderResponse.setResCode("40316");
            orderResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40316"));

            return orderResponse;
        }

        //校验订单来源是否为空
        if (query.getOrderSource() == null) {
            orderResponse.setResCode("40332");
            orderResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40332"));

            return orderResponse;
        }

        Product product = productMapper.selectByPrimaryKey(query.getProductId());

        //校验产品是否存在
        if (product == null) {
            orderResponse.setResCode("40301");
            orderResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40301"));

            return orderResponse;
        }

        //如果收货地址不存在 则返回错误提示
        ShippingInfo shippingInfo = shippingInfoMapper.selectByPrimaryKey(query.getShippingInfoId());
        if (shippingInfo == null) {
            orderResponse.setResCode("40305");
            orderResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40305"));

            return orderResponse;
        }

        //调用获取产品价格服务
        ProductListPriceResponse priceResponse = priceService.batchGetProductPrice(Arrays.asList(query.getProductId()));

        //判断服务是否调用成功 如果处理失败 则返回错误信息
        if (ErrorCodeUtil.isFailedResponse(priceResponse.getResCode())) {
            orderResponse.setResCode(priceResponse.getResCode());
            orderResponse.setResMsg(priceResponse.getResMsg());

            return orderResponse;
        }

        //如果该产品价格不存在 则直接返回
        if (MapUtil.isEmpty(priceResponse.getMap()) || !priceResponse.getMap().containsKey(product.getId())) {
            orderResponse.setResCode("40326");
            orderResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40326"));

            return orderResponse;
        }

        //业务校验结束

        //如果购买的产品数量为空 则默认为1
        if (query.getProductQty() == null) {
            query.setProductQty((byte) 1);
        }

        //设置总的产品件数
        query.setTotalProductQty(query.getProductQty().intValue());

        //设置产品价格
        ShoppingCartResultVo shoppingCartResultVo = wrapShoppingCart(product, priceResponse.getMap());
        //设置产品数量
        shoppingCartResultVo.setProductQty(query.getProductQty());
        query.setShoppingCartResult(Arrays.asList(shoppingCartResultVo));

        //计算订单总金额
        BigDecimal orderAmount = calculateOrderPrice(query);

        //校验客户端提交订单金额是否正确
        if (NumberUtil.isNotEquals(query.getOrderAmount(), orderAmount)) {
            orderResponse.setResCode("40306");
            orderResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40306"));

            return orderResponse;
        }

        // 调用库存服务
        List<ProductQtyVo> productQtyVoList = wrapProductQty(query.getShoppingCartResult());
        //调用批量锁定库存服务
        BatchFreezeStockResponse batchFreezeResponse = stockService.batchFreezeStock(productQtyVoList);
        //如果调用库存服务失败 则返回错误提示
        if (ErrorCodeUtil.isFailedResponse(batchFreezeResponse.getResCode())) {
            orderResponse.setResCode(batchFreezeResponse.getResCode());
            orderResponse.setResMsg(batchFreezeResponse.getResMsg());

            return orderResponse;
        }

        //设置产品库存使用情况
        query.setFreezeStockVoList(batchFreezeResponse.getFreezeStockVoList());
        //设置订单总金额
        query.setOrderAmount(orderAmount);
        //设置订单收件人信息
        query.setShippingInfo(shippingInfo);

        //保存订单
        saveOrder(query, orderResponse);

        return orderResponse;
    }

    /**
     * 根据产品id获取父产品信息
     * 
     * @param productId
     * @return
     */
    private ProductSerial getParentProduct(Integer productId) {
        ProductSerialExample productSerialExample = new ProductSerialExample();
        ProductSerialExample.Criteria criteria = productSerialExample.createCriteria();
        criteria.andSubProductIdEqualTo(productId);

        return productSerialMapper.selectUniqueByExample(productSerialExample);
    }

    @Override
    public CommonResponse confirmReceiving(OrderDetailQuery query) {
        CommonResponse commonResponse = new CommonResponse();

        /*** 业务校验开始*/
        //如果订单号是否为空  则直接返回错误提示
        if (StringUtil.isEmpty(query.getOrderCode())) {
            commonResponse.setResCode("40358");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40358"));

            return commonResponse;
        }

        //根据订单号获取订单
        SaleOrder saleOrder = selectByOrderCode(query.getOrderCode());
        //如果订单号不存在  则直接返回错误提示
        if (saleOrder == null) {
            commonResponse.setResCode("40359");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40359"));

            return commonResponse;
        }

        //如果订单支付状态为未支付  则直接返回错误提示
        if (saleOrder.getPaymentStatus().byteValue() == CommonConstant.UNPAY.byteValue()) {
            commonResponse.setResCode("40323");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40323"));

            return commonResponse;
        }

        //如果订单状态不为待收货状态 则返回提示错误
        if (saleOrder.getOrderStatus().intValue() != SaleOrderStatusEnum.TO_BE_RECEIVED.getKey().intValue()) {
            commonResponse.setResCode("40330");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40330"));

            return commonResponse;
        }
        /*** 业务校验结束*/

        //更新订单状态为交易完成
        SaleOrder targetSaleOrder = new SaleOrder();

        targetSaleOrder.setId(saleOrder.getId());
        targetSaleOrder.setOrderStatus(SaleOrderStatusEnum.COMPLETED.getKey().byteValue());
        targetSaleOrder.setUpdateTime(DateUtil.currentDate());

        saleOrderMapper.updateByPrimaryKeySelective(targetSaleOrder);

        //写入订单确认收货完成的日志
        SaleOrderLog warpOrderLog = warpOrderLog(saleOrder.getId(), ErrorCodeUtil.getErrorMsg("40362"));
        saleOrderLogMapper.insertSelective(warpOrderLog);

        return commonResponse;
    }

}