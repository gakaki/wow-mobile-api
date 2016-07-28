package com.wow.order.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;

/**
 *
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ChargeResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    //返回的支付凭证信息
    private String charge;

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }

}
