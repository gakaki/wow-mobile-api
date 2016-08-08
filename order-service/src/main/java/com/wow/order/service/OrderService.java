package com.wow.order.service;

import java.util.List;

import com.wow.common.response.CommonResponse;
import com.wow.order.model.ReturnOrder;
import com.wow.order.model.SaleOrder;
import com.wow.order.model.SaleOrderLog;
import com.wow.order.vo.OrderDeliverQuery;
import com.wow.order.vo.OrderDetailQuery;
import com.wow.order.vo.OrderListQuery;
import com.wow.order.vo.OrderQuery;
import com.wow.order.vo.OrderSettleQuery;
import com.wow.order.vo.response.OrderDetailResponse;
import com.wow.order.vo.response.OrderListResponse;
import com.wow.order.vo.response.OrderResponse;
import com.wow.order.vo.response.OrderSettleResponse;

/**
 * 订单服务
 * <p>
 * Created by zhengzhiqing on 16/6/16.
 */
public interface OrderService {

    /**
     * 购物车结算
     * 
     * @param orderVo
     * @return
     */
    OrderSettleResponse settleOrder(OrderSettleQuery query);

    /**
     * 立即购买结算
     * 
     * @param orderVo
     * @return
     */
    OrderSettleResponse buyNow(OrderSettleQuery query);

    /**
     * 下单
     *
     * @param orderVo
     */
    OrderResponse createOrderFromCart(OrderQuery query);

    /**
     * 立即购买下单
     *
     * @param orderVo
     */
    OrderResponse createOrderFromDirect(OrderQuery query);

    /**
     * 查询用户订单列表
     * 
     * @param query
     * @return
     */
    OrderListResponse queryOrderListPage(OrderListQuery query);

    /**
     * 订单支付
     *
     * @param order 订单号
     */
    CommonResponse payOrder(String orderCode);

    /**
     * 订单支付回调通知 ping++服务端调用
     *
     * @param order 订单号
     */
    CommonResponse payOrderCallBack(String orderCode);

    /**
     * 在发货之前取消订单
     *
     * @param order
     */
    CommonResponse cancelOrder(OrderDetailQuery query);

    /**根据订单号查询订单明细
     * @param orderCode
     * @return
     */
    OrderDetailResponse queryOrderDetailByOrderCode(OrderDetailQuery query);

    /**
     * @param orderId
     * @return
     */
    List<SaleOrderLog> queryOrderLogsByOrderId(int orderId);

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
     * 发货
     *
     * @param order
     */
    CommonResponse deliverGoods(OrderDeliverQuery query);

    /**
     * 虚拟库存到货之后发货
     *
     * @param order
     */
    boolean deliverDelayedGoods(SaleOrder order);

    /**
     * 自动取消订单
     * 
     * @param timeoutMinute
     * @return
     */
    CommonResponse autoCancel(int timeoutMinute);

    /**
     * 确认收货 订单完成
     *
     * @param order 订单号
     */
    CommonResponse confirmReceiving(OrderDetailQuery query);

}
