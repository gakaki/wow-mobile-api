package com.wow.order.service;

import com.wow.order.vo.AdminOrderListQuery;
import com.wow.order.vo.response.AdminOrderListResponse;

/**
 * 后台订单服务
 * <p>
 * Created by zhengzhiqing on 16/6/16.
 */
public interface AdminOrderService {

    /**
     * 查询用户订单列表
     * 
     * @param query
     * @return
     */
    AdminOrderListResponse queryOrderListPage(AdminOrderListQuery query);
}
