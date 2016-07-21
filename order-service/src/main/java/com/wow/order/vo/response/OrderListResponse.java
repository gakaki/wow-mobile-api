package com.wow.order.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.order.vo.OrderListVo;


/**
 * 订单列表接口响应类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月11日 下午6:49:05 Exp $
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class OrderListResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;
    
    //订单列表
    private List<OrderListVo> orderLists;

    public List<OrderListVo> getOrderLists() {
        return orderLists;
    }

    public void setOrderLists(List<OrderListVo> orderLists) {
        this.orderLists = orderLists;
    }
}
