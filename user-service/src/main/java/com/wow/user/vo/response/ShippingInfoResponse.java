package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.user.model.ShippingInfo;

/**
 * Created by zhengzhiqing on 16/6/28.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ShippingInfoResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    private ShippingInfo shippingInfo;

    public ShippingInfo getShippingInfo() {
        return shippingInfo;
    }

    public void setShippingInfo(ShippingInfo shippingInfo) {
        this.shippingInfo = shippingInfo;
    }
}
