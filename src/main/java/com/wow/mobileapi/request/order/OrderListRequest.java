package com.wow.mobileapi.request.order;

import java.util.List;

import com.wow.common.request.PageRequest;

/**
 * 创建订单列表请求类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月12日 下午4:50:51 Exp $
 */
public class OrderListRequest extends PageRequest {

    private static final long serialVersionUID = 1L;

    //用户id
    private Integer endUserId;

    //订单状态
    private Byte orderStatus;
    
    
    //订单状态集合 支持获取多个订单状态的列表 如果orderStatus和orderStatusList都不为空 则优先按照orderStatus来查询
    private List<Byte> orderStatusList;
    
    public List<Byte> getOrderStatusList() {
        return orderStatusList;
    }

    public void setOrderStatusList(List<Byte> orderStatusList) {
        this.orderStatusList = orderStatusList;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
    }

}
