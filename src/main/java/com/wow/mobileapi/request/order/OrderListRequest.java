package com.wow.mobileapi.request.order;

import com.wow.common.request.ApiRequest;

/**
 * 创建订单列表请求类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月12日 下午4:50:51 Exp $
 */
public class OrderListRequest extends ApiRequest {

    private static final long serialVersionUID = 1L;

    //用户id
    private Integer endUserId;

    public Integer getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
    }

}
