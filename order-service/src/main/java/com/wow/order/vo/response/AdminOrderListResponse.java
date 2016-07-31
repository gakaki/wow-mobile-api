package com.wow.order.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.order.vo.AdminOrderListVo;


/**
 * 后台订单列表接口响应类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月11日 下午6:49:05 Exp $
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class AdminOrderListResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;
    
    //订单列表
    private List<AdminOrderListVo> orderLists;

    public List<AdminOrderListVo> getOrderLists() {
        return orderLists;
    }

    public void setOrderLists(List<AdminOrderListVo> orderLists) {
        this.orderLists = orderLists;
    }
}
