package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.user.model.ShippingInfo;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/28.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ShippingInfoListResponse extends CommonResponse {

    private List<ShippingInfo> shippingInfoList;

    public List<ShippingInfo> getShippingInfoList() {
        return shippingInfoList;
    }

    public void setShippingInfoList(List<ShippingInfo> shippingInfoList) {
        this.shippingInfoList = shippingInfoList;
    }
}
