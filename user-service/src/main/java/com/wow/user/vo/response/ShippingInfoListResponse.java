package com.wow.user.vo.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.user.vo.ShippingInfoResult;

/**
 * Created by zhengzhiqing on 16/6/28.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ShippingInfoListResponse extends CommonResponse {

    /**  */
    private static final long serialVersionUID = 1L;
    private List<ShippingInfoResult> shippingInfoResultList;

    public List<ShippingInfoResult> getShippingInfoResultList() {
        return shippingInfoResultList;
    }

    public void setShippingInfoResultList(List<ShippingInfoResult> shippingInfoResultList) {
        this.shippingInfoResultList = shippingInfoResultList;
    }

}
