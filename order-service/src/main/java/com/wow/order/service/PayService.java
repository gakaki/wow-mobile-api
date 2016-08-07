package com.wow.order.service;

import com.wow.common.response.CommonResponse;
import com.wow.order.vo.ChargeRequest;
import com.wow.order.vo.response.ChargeResponse;
import com.wow.order.vo.response.OrderPayResultResponse;

/**
 * Created by zhengzhiqing on 16/7/25.
 */
public interface PayService {
    /**
     *
     * @param chargeRequest
     * @return
     */
    ChargeResponse getCharge(ChargeRequest chargeRequest);

    /**
    * 处理支付通知
    * 
    * @param signature
    * @param content
    * @return
    */
    CommonResponse webhooks(String signature, String content);
    
    /**根据订单号查询订单支付结果
     * @param orderCode
     * @return
     */
    OrderPayResultResponse queryOrderPayResult(String orderCode);
}
