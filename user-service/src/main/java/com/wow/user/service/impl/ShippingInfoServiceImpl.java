package com.wow.user.service.impl;

import com.wow.common.response.CommonResponse;
import com.wow.user.mapper.ShippingInfoMapper;
import com.wow.user.model.ShippingInfo;
import com.wow.user.service.ShippingInfoService;
import com.wow.user.vo.response.ShippingInfoListResponse;
import com.wow.user.vo.response.ShippingInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
    public CommonResponse createShippingInfo(ShippingInfo shippingInfo) {
        CommonResponse commonResponse = new CommonResponse();
        shippingInfoMapper.insert(shippingInfo);
        return commonResponse;
    }

    /**
     * 更新收货信息(包括设置为默认收货地址)
     *
     * @param shippingInfo
     * @return
     */
    @Override
    public CommonResponse updateShippingInfo(ShippingInfo shippingInfo) {
        CommonResponse commonResponse = new CommonResponse();
        shippingInfoMapper.updateByPrimaryKeySelective(shippingInfo);
        return commonResponse;
    }

    /**
     * 删除收货信息
     *
     * @param shippingInfoId
     * @return
     */
    @Override
    public CommonResponse deleteShippingInfo(int shippingInfoId) {
        CommonResponse commonResponse = new CommonResponse();
        shippingInfoMapper.deleteByPrimaryKey(shippingInfoId);
        return commonResponse;
    }

    /**
     * 查询用户所有收货信息
     *
     * @param endUserId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public ShippingInfoListResponse getShippingInfoByUserId(int endUserId) {
        ShippingInfoListResponse shippingInfoListResponse = new ShippingInfoListResponse();
        List<ShippingInfo> shippingInfoList = shippingInfoMapper.selectByUserId(endUserId);
        shippingInfoListResponse.setShippingInfoList(shippingInfoList);
        return shippingInfoListResponse;
    }

    /**
     * 查询用户默认收货信息
     * @param endUserId
     * @return
     */
    @Transactional(propagation= Propagation.SUPPORTS)
    public ShippingInfoResponse getDefaultShippingInfoByUserId(int endUserId) {
        ShippingInfoResponse shippingInfoResponse = new ShippingInfoResponse();
        ShippingInfo shippingInfo =  shippingInfoMapper.selectDefault(endUserId);
        shippingInfoResponse.setShippingInfo(shippingInfo);
        return shippingInfoResponse;
    }
}
