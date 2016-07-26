package com.wow.order.service;

import com.wow.order.vo.ChargeRequest;
import com.wow.order.vo.response.ChargeResponse;

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
}
