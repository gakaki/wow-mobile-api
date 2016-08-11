package com.wow.order.vo;

import java.io.Serializable;
import java.util.List;

import com.wow.common.page.PageQuery;

/**
 * 订单列表查询类
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月17日 上午11:42:47 Exp $
 */
public class OrderListQuery extends PageQuery implements Serializable {
    /**  */
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