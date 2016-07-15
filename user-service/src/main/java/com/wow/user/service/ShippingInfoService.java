package com.wow.user.service;

import com.wow.common.response.CommonResponse;
import com.wow.user.model.ShippingInfo;
import com.wow.user.vo.response.ShippingInfoListResponse;
import com.wow.user.vo.response.ShippingInfoResponse;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
public interface ShippingInfoService {
    /**
     * 创建/添加收货信息
     * @param shippingInfo
     * @return
     */
    CommonResponse createShippingInfo(ShippingInfo shippingInfo);

    /**
     * 更新收货信息
     * @param shippingInfo
     * @return
     */
    CommonResponse updateShippingInfo(ShippingInfo shippingInfo);

    /**
     * 删除收货信息
     * @param shippingInfoId
     * @return
     */
    CommonResponse deleteShippingInfo(int shippingInfoId);

    /**
     * 查询用户所有收货信息
     * @param endUserId
     * @return
     */
    ShippingInfoListResponse getShippingInfoByUserId(int endUserId);

    /**
     * 查询用户默认收货信息
     * @param endUserId
     * @return
     */
    public ShippingInfoResponse getDefaultShippingInfoByUserId(int endUserId);

}
