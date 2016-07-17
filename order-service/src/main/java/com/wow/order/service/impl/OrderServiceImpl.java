package com.wow.order.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wow.common.constant.CommonConstant;
import com.wow.common.enums.ProductStatusEnum;
import com.wow.common.util.BeanUtil;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.NumberUtil;
import com.wow.order.model.Order;
import com.wow.order.model.OrderLog;
import com.wow.order.model.ReturnOrder;
import com.wow.order.service.OrderService;
import com.wow.order.vo.OrderItemVo;
import com.wow.order.vo.OrderQuery;
import com.wow.order.vo.OrderSettleQuery;
import com.wow.order.vo.response.OrderResponse;
import com.wow.order.vo.response.OrderSettleResponse;
import com.wow.user.mapper.ShoppingCartMapper;
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
        //业务校验结束
        
        //判断库存是否足够
        //计算订单金额
        

        return orderResponse;
    }

    /**
     * 在发货之前取消订单
     *
     * @param order
     */
    @Override
    public void cancelOrder(Order order) {

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
    public Order queryOrderByOrderCode(String orderCode) {
        return null;
    }

    /**
     * @param endUserId
     * @return
     */
    @Override
    public List<Order> queryOrdersByUserId(int endUserId) {
        return null;
    }

    /**
     * @param orderLog
     */
    @Override
    public void createOrderLog(OrderLog orderLog) {

    }

    /**
     * @param orderId
     * @return
     */
    @Override
    public List<OrderLog> queryOrderLogsByOrderId(int orderId) {
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
    public boolean deliverGoods(Order order) {
        return false;
    }

    /**
     * 虚拟库存到货之后发货
     *
     * @param order
     */
    @Override
    public boolean deliverDelayedGoods(Order order) {
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

        //订单金额小于指定的阀值时计算运费
        if (totalPrice < NumberUtil.convertToFen(CommonConstant.THRESHOLD)) {
            response.setDeliveryFee(CommonConstant.DELIVERYFEE);
            //计算运费
            totalPrice += NumberUtil.convertToFen(CommonConstant.DELIVERYFEE);
        }

        //计算订单总价
        response.setTotalAmount(NumberUtil.convertToYuan(totalPrice));

        return response;
    }

}