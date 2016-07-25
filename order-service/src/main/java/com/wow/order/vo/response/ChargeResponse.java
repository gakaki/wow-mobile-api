package com.wow.order.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.pingplusplus.model.Charge;
import com.wow.common.response.CommonResponse;

/**
 *
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ChargeResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private Charge charge;

    public Charge getCharge() {
        return charge;
    }

    public void setCharge(Charge charge) {
        this.charge = charge;
    }
}
