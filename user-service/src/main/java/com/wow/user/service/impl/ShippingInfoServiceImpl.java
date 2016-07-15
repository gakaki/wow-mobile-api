package com.wow.user.service.impl;

import com.wow.common.response.CommonResponse;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.user.mapper.ShippingInfoMapper;
import com.wow.user.model.ShippingInfo;
import com.wow.user.model.ShippingInfoExample;
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
        if (shippingInfo.getIsDefault() !=null && shippingInfo.getIsDefault()) {
            //先找出当前的默认收货地址,如果有则取消默认标记
            ShippingInfo currentDefaultShippingInfo = getDefaultShippingInfoByUserId(shippingInfo.getEndUserId()).getShippingInfo();
            if (currentDefaultShippingInfo != null) {
                currentDefaultShippingInfo.setIsDefault(false);
                shippingInfoMapper.updateByPrimaryKeySelective(currentDefaultShippingInfo);
            }
        } else {
            //如果没有任何收货地址,则第一次插入的强制设置为默认
            ShippingInfoListResponse shippingInfoListResponse = getShippingInfoByUserId(shippingInfo.getEndUserId());
            if (CollectionUtil.isEmpty(shippingInfoListResponse.getShippingInfoList())) {
                shippingInfo.setIsDefault(true);
            }
        }
        shippingInfoMapper.insertSelective(shippingInfo);
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
        if (shippingInfo.getIsDefault() != null && shippingInfo.getIsDefault()) {
            return setAsDefaultShippingInfo(shippingInfo.getId(), shippingInfo.getEndUserId());
        } else {
            shippingInfoMapper.updateByPrimaryKeySelective(shippingInfo);
        }
        return commonResponse;
    }

    /**
     * 设为默认收货信息
     *
     * @param shippingInfoId
     * @return
     */
    @Override
    public CommonResponse setAsDefaultShippingInfo(int shippingInfoId, int endUserId) {
        CommonResponse commonResponse = new CommonResponse();
        //先找出当前的默认收货地址,取消默认标记
        ShippingInfo currentDefaultShippingInfo = getDefaultShippingInfoByUserId(endUserId).getShippingInfo();
        if (currentDefaultShippingInfo != null) {
            currentDefaultShippingInfo.setIsDefault(false);
            shippingInfoMapper.updateByPrimaryKeySelective(currentDefaultShippingInfo);
        }
        //再讲请求的地址设为默认
        ShippingInfo shippingInfo = shippingInfoMapper.selectByPrimaryKey(shippingInfoId);
        if (shippingInfo == null || shippingInfo.getId() == null) {
            commonResponse.setResCode("40104");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40104"));
            return commonResponse;
        }
        shippingInfo.setIsDefault(true);
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

        ShippingInfoExample shippingInfoExample = new ShippingInfoExample();
        ShippingInfoExample.Criteria criteria = shippingInfoExample.createCriteria();
        criteria.andEndUserIdEqualTo(endUserId);
        criteria.andIsDeletedEqualTo(false);
        List<ShippingInfo> shippingInfoList = shippingInfoMapper.selectByExample(shippingInfoExample);
        if (CollectionUtil.isEmpty(shippingInfoList)) {
            shippingInfoListResponse.setResCode("50104");
            shippingInfoListResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50104"));
        } else {
            shippingInfoListResponse.setShippingInfoList(shippingInfoList);
        }
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
        ShippingInfoExample shippingInfoExample = new ShippingInfoExample();
        ShippingInfoExample.Criteria criteria = shippingInfoExample.createCriteria();
        criteria.andIsDefaultEqualTo(true);
        criteria.andIsDeletedEqualTo(false);
        List<ShippingInfo> shippingInfoList =  shippingInfoMapper.selectByExample(shippingInfoExample);
        ShippingInfo defaultShippingInfo;
        if (CollectionUtil.isEmpty(shippingInfoList)) {
            shippingInfoResponse.setResCode("50102");
            shippingInfoResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50102"));
        } else if (shippingInfoList.size() > 1) {
            shippingInfoResponse.setResCode("50103");
            shippingInfoResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50103"));
        } else {
            defaultShippingInfo = shippingInfoList.get(0);
            shippingInfoResponse.setShippingInfo(defaultShippingInfo);
        }
        return shippingInfoResponse;
    }
}
