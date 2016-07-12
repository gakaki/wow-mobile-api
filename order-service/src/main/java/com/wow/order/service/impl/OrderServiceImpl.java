package com.wow.order.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wow.order.model.Order;
import com.wow.order.model.OrderLog;
import com.wow.order.model.ReturnOrder;
import com.wow.order.service.OrderService;
import com.wow.order.vo.OrderVo;
import com.wow.order.vo.response.OrderResponse;

/**
 * 订单服务
 * <p>
 * Created by zhengzhiqing on 16/6/16.
 */
@Service
@Transactional("orderTransactionManager")
public class OrderServiceImpl implements OrderService {
    /**
     * 下单
     *
     * @param orderVo
     */
    public void placeOrder(OrderVo orderVo) {
        //从OrderVo中获取信息,创建订单,概要步骤如下
        /**
         * 1. 根据包裹信息,在相应仓库上冻结库存,注意组合品的库存计算
         * 2. 每一个包裹做成一个子单order,拥有共同的父单parent_order
         * 3. 每一个包裹里的每种产品做成一个订单项order_item
         * 4. 如果是组合产品,在order_item里有父子两层关系
         * 5. 其他如发货地址,发票信息,支付信息都维护在父单上
         */
    }

    /**
     * 在发货之前取消订单
     *
     * @param order
     */
    public void cancelOrder(Order order) {

    }

    /**
     * @param orderId
     * @return
     */
    @Override
    public OrderResponse queryOrderById(int orderId) {
        OrderResponse orderResponse=new OrderResponse();
        
        orderResponse.setResCode("12121");
        orderResponse.setResMsg("订单号不存在");
        
        return orderResponse;
    }

    /**
     * @param orderCode
     * @return
     */
    public Order queryOrderByOrderCode(String orderCode) {
        return null;
    }

    /**
     * @param endUserId
     * @return
     */
    public List<Order> queryOrdersByUserId(int endUserId) {
        return null;
    }

    /**
     * @param orderLog
     */
    public void createOrderLog(OrderLog orderLog) {

    }

    /**
     * @param orderId
     * @return
     */
    public List<OrderLog> queryOrderLogsByOrderId(int orderId) {
        return null;
    }

    /**
     * 下退货单
     *
     * @param returnOrder
     * @return
     */
    public int placeReturnOrder(ReturnOrder returnOrder) {
        return 0;
    }

    /**
     * 审批退货单
     *
     * @param returnOrder
     * @return
     */
    public int approveReturnOrder(ReturnOrder returnOrder) {
        return 0;
    }

    /**
     * 拒绝退货单?
     *
     * @param returnOrder
     * @return
     */
    public int rejectReturnOrder(ReturnOrder returnOrder) {
        return 0;
    }

    /**
     * 发货
     *
     * @param order
     */
    public boolean deliverGoods(Order order) {
        return false;
    }

    /**
     * 虚拟库存到货之后发货
     *
     * @param order
     */
    public boolean deliverDelayedGoods(Order order) {
        return false;
    }

}