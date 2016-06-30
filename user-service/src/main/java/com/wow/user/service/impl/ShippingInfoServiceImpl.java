package com.wow.user.service.impl;

import com.wow.user.mapper.ShippingInfoMapper;
import com.wow.user.model.ShippingInfo;
import com.wow.user.service.ShippingInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@Service
@Transactional(value = "userTransactionManager")
public class ShippingInfoServiceImpl implements ShippingInfoService {

    @Autowired
    private ShippingInfoMapper shippingInfoMapper;

    /**
     * 创建/添加收货信息
     *
     * @param shippingInfo
     * @return
     */
    @Override
    public int createShippingInfo(ShippingInfo shippingInfo) {
        return shippingInfoMapper.insert(shippingInfo);
    }

    /**
     * 更新收货信息(包括设置为默认收货地址)
     *
     * @param shippingInfo
     * @return
     */
    @Override
    public int updateShippingInfo(ShippingInfo shippingInfo) {
        return shippingInfoMapper.updateByPrimaryKeySelective(shippingInfo);
    }

    /**
     * 删除收货信息
     *
     * @param shippingInfoId
     * @return
     */
    @Override
    public int deleteShippingInfo(int shippingInfoId) {
        return shippingInfoMapper.deleteByPrimaryKey(shippingInfoId);
    }

    /**
     * 查询用户所有收货信息
     *
     * @param endUserId
     * @return
     */
    @Override
    public List<ShippingInfo> getShippingInfoByUserId(int endUserId) {
        return shippingInfoMapper.selectByUserId(endUserId);
    }

    /**
     * 查询用户默认收货信息
     * @param endUserId
     * @return
     */
    public ShippingInfo getDefaultShippingInfoByUserId(int endUserId) {
        return shippingInfoMapper.selectDefault(endUserId);
    }
}
