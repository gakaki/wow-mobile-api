package com.wow.order.service.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
        //业务校验结束

        query.setShippingInfo(shippingInfo);

        //判断库存是否足够 调用库存服务
        ShoppingCartQueryVo shoppingCartQuery = new ShoppingCartQueryVo();
        shoppingCartQuery.setShoppingCartIds(query.getShoppingCartIds());

        //根据用户购物车id列表 获取用户购物车信息列表
        List<ShoppingCartResultVo> shoppingCartResult = shoppingCartMapper.queryByShoppingCartIds(shoppingCartQuery);

        query.setShoppingCartResult(shoppingCartResult);

        //计算订单总金额
        BigDecimal totalPrice = calculateOrderPrice(query);
        //计算订单优惠金额

        wrapOrder(query);

        wrapOrderItem(query);

        return orderResponse;
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
        saleOrder.setOrderCode(RandomGenerator.createRandom(true, 10));
        saleOrder.setEndUserCouponId(query.getEndUserId());

        //设置订单总金额 优惠金额 运费等
        saleOrder.setOrderAmount(query.getOrderAmount());
        saleOrder.setProductAmount(query.getProductAmount());
        saleOrder.setDeliveryFee(query.getDeliveryfee());
        saleOrder.setCouponAmount(query.getCouponFee());

        saleOrder.setEndUserRemarks(query.getRemark());

        //设置收货人地址信息
        // ShippingInfo shippingInfo = query.getShippingInfo();
        //设置订单状态为待付款
        saleOrder.setOrderStatus(SaleOrderStatusEnum.TO_BE_PAID.getKey().byteValue());
        saleOrder.setPaymentStatus(CommonConstant.UNPAY);
        saleOrder.setIsUseCoupon(query.getCouponId() == null ? Boolean.FALSE : Boolean.TRUE);
        saleOrder.setEndUserCouponId(query.getCouponId());
        
        //目前都不是父订单
        saleOrder.setIsLeaf(Boolean.FALSE );
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
        List<SaleOrderItem> saleOrderItems = new ArrayList<>();

        return saleOrderItems;
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
            long productPrice = NumberUtil.convertToFen(shoppingCart.getSellPrice());
            totalPrice += productPrice * shoppingCart.getProductQty();
        }

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

            //转化产品状态名称
            if (orderItemVo.getProductStatus() != null) {
                orderItemVo.setProductStatusName(ProductStatusEnum.get((int) orderItemVo.getProductStatus()));
            }

            //产品单价
            long productPrice = NumberUtil.convertToFen(orderItemVo.getSellPrice());
            //计算该产品销售总价( 产品单价乘以数量)
            long sellTotalAmount = productPrice * orderItemVo.getProductQty();
            //仅计算已经上架的产品价格
            if (orderItemVo.getProductStatus().intValue() == ProductStatusEnum.ORDER_STATUS_SHELVE.getKey()) {
                //计算订单总价
                totalPrice += sellTotalAmount;
            }

            orderItemVo.setSellTotalAmount(NumberUtil.convertToYuan(sellTotalAmount));

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