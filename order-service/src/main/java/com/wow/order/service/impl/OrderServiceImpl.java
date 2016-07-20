package com.wow.order.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wow.common.constant.CommonConstant;
import com.wow.common.enums.ProductStatusEnum;
import com.wow.common.enums.SaleOrderStatusEnum;
import com.wow.common.util.BeanUtil;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.DateUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.IpConvertUtil;
import com.wow.common.util.NumberUtil;
import com.wow.common.util.RandomGenerator;
import com.wow.order.mapper.SaleOrderItemMapper;
import com.wow.order.mapper.SaleOrderLogMapper;
import com.wow.order.mapper.SaleOrderMapper;
import com.wow.order.model.ReturnOrder;
import com.wow.order.model.SaleOrder;
import com.wow.order.model.SaleOrderItem;
import com.wow.order.model.SaleOrderLog;
import com.wow.order.service.OrderService;
import com.wow.order.vo.OrderItemVo;
import com.wow.order.vo.OrderQuery;
import com.wow.order.vo.OrderSettleQuery;
import com.wow.order.vo.response.OrderResponse;
import com.wow.order.vo.response.OrderSettleResponse;
import com.wow.product.mapper.ProductSupplierMapper;
import com.wow.product.model.ProductSupplier;
import com.wow.product.model.ProductSupplierExample;
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
    private ProductSupplierMapper productSupplierMapper;

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

        //判断库存是否足够 调用库存服务
        query.setShoppingCartResult(shoppingCartResult);

        //计算订单总金额
        BigDecimal orderAmount = calculateOrderPrice(query);


        if (NumberUtil.isNotEquals(query.getOrderAmount(), orderAmount)) {
            orderResponse.setResCode("40306");
            orderResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40306"));

            return orderResponse;
        }

        query.setOrderAmount(orderAmount);
        //业务校验结束

        //包装订单对象
        SaleOrder saleOrder = wrapOrder(query);

        /*** 保存订单开始*/
        
        saleOrderMapper.insertSelective(saleOrder);
        //设置订单id
        query.setOrderId(saleOrder.getId());

        //包装订单项目
        List<SaleOrderItem> wrapOrderItems = wrapOrderItem(query);

        saleOrderItemMapper.batchInsertSelective(wrapOrderItems);

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
    public void cancelOrder(SaleOrder order) {

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

    /**
     * @param orderCode
     * @return
     */
    @Override
    public SaleOrder queryOrderByOrderCode(String orderCode) {
        return null;
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
        OrderItemVo orderItemVo = null;
        long totalPrice = 0L; //订单总价
        List<OrderItemVo> orderItems = new ArrayList<OrderItemVo>(shoppingCartResult.size());

        for (ShoppingCartResultVo shoppingCartResultVo : shoppingCartResult) {
            orderItemVo = new OrderItemVo();
            BeanUtil.copyProperties(shoppingCartResultVo, orderItemVo);

            if (orderItemVo.getProductStatus() != null) {
                //转化产品状态名称
                orderItemVo.setProductStatusName(ProductStatusEnum.get((int) orderItemVo.getProductStatus()));
            }

            //产品单价
            long productPrice = NumberUtil.convertToFen(orderItemVo.getSellPrice());
            //计算该产品销售总价( 产品单价乘以数量)
            long sellTotalAmount = productPrice * orderItemVo.getProductQty();
            orderItemVo.setSellTotalAmount(NumberUtil.convertToYuan(sellTotalAmount));

            //计算订单总价
            totalPrice += sellTotalAmount;

            orderItems.add(orderItemVo);
        }

        //设置订单项信息
        response.setOrderItems(orderItems);

        //计算订单运费
        long deliveryfee = calculateDeliveryFee(totalPrice);
        totalPrice += deliveryfee;

        //计算订单总价
        response.setTotalAmount(NumberUtil.convertToYuan(totalPrice));

        return response;
    }

}