package com.wow.order.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.order.model.Order;


/**
 * 订单响应类 接口使用
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月11日 下午6:49:05 Exp $
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class OrderResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;
    
    //订单model
    private Order order;

    public Order getOrder() {
        return order;
    }


    public void setOrder(Order order) {
        this.order = order;
    }
}
