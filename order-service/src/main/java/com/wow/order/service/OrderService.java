package com.wow.order.service;

import java.util.List;

import com.wow.order.model.OrderLog;
import com.wow.order.model.ReturnOrder;
import com.wow.order.model.SaleOrder;
import com.wow.order.vo.OrderQuery;
import com.wow.order.vo.OrderSettleQuery;
import com.wow.order.vo.response.OrderResponse;
import com.wow.order.vo.response.OrderSettleResponse;

/**
 * 订单服务
 * <p>
 * Created by zhengzhiqing on 16/6/16.
 */
public interface OrderService {

    /**
     * 订单结算
     * 
     * @param orderVo
     * @return
     */
    OrderSettleResponse settleOrder(OrderSettleQuery query);

    /**
     * 下单
     *
     * @param orderVo
     */
    OrderResponse createOrder(OrderQuery query);

    /**
     * 在发货之前取消订单
     *
     * @param order
     */
    void cancelOrder(SaleOrder order);

    /**
     * @param orderId
     * @return
     */
    OrderSettleResponse queryOrderById(int orderId);

    /**
     * @param orderCode
     * @return
     */
    SaleOrder queryOrderByOrderCode(String orderCode);

    /**
     * @param endUserId
     * @return
     */
    List<SaleOrder> queryOrdersByUserId(int endUserId);

    /**
     * @param orderLog
     */
    void createOrderLog(OrderLog orderLog);

    /**
     * @param orderId
     * @return
     */
    List<OrderLog> queryOrderLogsByOrderId(int orderId);

    /**
     * 下退货单
     *
     * @param returnOrder
     * @return
     */
    int placeReturnOrder(ReturnOrder returnOrder);

    /**
     * 审批退货单
     *
     * @param returnOrder
     * @return
     */
    int approveReturnOrder(ReturnOrder returnOrder);

    /**
     * 拒绝退货单?
     *
     * @param returnOrder
     * @return
     */
    int rejectReturnOrder(ReturnOrder returnOrder);

    /**
     * 发货
     *
     * @param order
     */
    boolean deliverGoods(SaleOrder order);

    /**
     * 虚拟库存到货之后发货
     *
     * @param order
     */
    boolean deliverDelayedGoods(SaleOrder order);

}
