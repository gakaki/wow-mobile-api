package com.wow.user.service;

import com.wow.user.model.ShippingInfo;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
public interface ShippingInfoService {
    /**
     * 创建/添加收货信息
     * @param shippingInfo
     * @return
     */
    int createShippingInfo(ShippingInfo shippingInfo);

    /**
     * 更新收货信息
     * @param shippingInfo
     * @return
     */
    int updateShippingInfo(ShippingInfo shippingInfo);

    /**
     * 删除收货信息
     * @param shippingInfoId
     * @return
     */
    int deleteShippingInfo(int shippingInfoId);

    /**
     * 查询用户所有收货信息
     * @param endUserId
     * @return
     */
    List<ShippingInfo> getShippingInfoByUserId(int endUserId);

}
