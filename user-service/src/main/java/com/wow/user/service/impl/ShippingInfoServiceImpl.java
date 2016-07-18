package com.wow.user.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.wow.common.response.CommonResponse;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.DateUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.user.mapper.AreaMapper;
import com.wow.user.mapper.ShippingInfoMapper;
import com.wow.user.model.Area;
import com.wow.user.model.ShippingInfo;
import com.wow.user.model.ShippingInfoExample;
import com.wow.user.service.ShippingInfoService;
import com.wow.user.vo.response.ShippingInfoListResponse;
import com.wow.user.vo.response.ShippingInfoResponse;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@Service
@Transactional(value = "userTransactionManager")
public class ShippingInfoServiceImpl implements ShippingInfoService {

    @Autowired
    private ShippingInfoMapper shippingInfoMapper;

    @Autowired
    private AreaMapper areaMapper;

    /**
     * 创建收货信息
     *
     * @param shippingInfo
     * @return
     */
    @Override
    public CommonResponse createShippingInfo(ShippingInfo shippingInfo) {
        CommonResponse commonResponse = new CommonResponse();

        //如果是设置默认地址
        if (shippingInfo.getIsDefault() != null && shippingInfo.getIsDefault()) {
            //先找出当前的默认收货地址,如果有则取消默认标记
            ShippingInfo currentDefaultShippingInfo = getDefaultShippingInfoByUserId(shippingInfo.getEndUserId())
                .getShippingInfo();
            if (currentDefaultShippingInfo != null) {
                currentDefaultShippingInfo.setIsDefault(false); //取消默认
                shippingInfoMapper.updateByPrimaryKeySelective(currentDefaultShippingInfo);
            }
        } else {
            //如果没有任何收货地址,则第一次插入的强制设置为默认
            ShippingInfoListResponse shippingInfoListResponse = getShippingInfoByUserId(shippingInfo.getEndUserId());
            if (CollectionUtil.isEmpty(shippingInfoListResponse.getShippingInfoList())) {
                shippingInfo.setIsDefault(true);
            }
        }

        //包装用户收货地址信息
        wrapShippingInfo(shippingInfo);

        shippingInfoMapper.insertSelective(shippingInfo);

        return commonResponse;
    }

    /**
     * 包装收货地址信息
     * 
     * @param shippingInfo
     */
    private void wrapShippingInfo(ShippingInfo shippingInfo) {
        List<Integer> ids = new ArrayList<Integer>(3);

        ids.add(shippingInfo.getProvinceId());
        ids.add(shippingInfo.getCityId());
        ids.add(shippingInfo.getCountyId());

        List<Area> areas = areaMapper.selectByIds(ids);

        //设置收货省份名称 城市名称 区域名称
        Area area = null;

        area = findById(areas, shippingInfo.getProvinceId());
        shippingInfo.setProvinceName(area == null ? null : area.getAreaName());
        area = findById(areas, shippingInfo.getCityId());
        shippingInfo.setCityName(area == null ? null : area.getAreaName());
        area = findById(areas, shippingInfo.getCountyId());
        shippingInfo.setCountyName(area == null ? null : area.getAreaName());

        if (shippingInfo.getId() == null) {
            shippingInfo.setCreateTime(DateUtil.currentDate());
        }
        shippingInfo.setUpdateTime(DateUtil.currentDate());
    }

    /**
     * 根据区域id查询相关区域信息
     * 
     * @param areas
     * @param integer
     */
    private Area findById(List<Area> areas, Integer id) {
        for (Area area : areas) {
            if (id.intValue() == area.getId().intValue()) {
                return area;
            }
        }

        return null;
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

        //如果设置为默认地址 则清空其他默认地址
        if (shippingInfo.getIsDefault() != null && shippingInfo.getIsDefault()) {
            //查询用户默认收货信息
            ShippingInfoResponse shippingInfoResponse = getDefaultShippingInfoByUserId(shippingInfo.getEndUserId());

            ShippingInfo currentDefaultShippingInfo = shippingInfoResponse.getShippingInfo();

            if (currentDefaultShippingInfo != null) {
                //判断默认地址是不是当前用户修改的地址
                boolean isCurrentShip = currentDefaultShippingInfo.getId().intValue() == shippingInfo.getId();

                //如果不是当前地址则取消默认标记
                if (!isCurrentShip) {
                    currentDefaultShippingInfo.setIsDefault(false);
                    shippingInfoMapper.updateByPrimaryKeySelective(currentDefaultShippingInfo);
                }
            }
            //return setAsDefaultShippingInfo(shippingInfo.getId(), shippingInfo.getEndUserId());
        }

        wrapShippingInfo(shippingInfo);

        //更新收货信息
        shippingInfoMapper.updateByPrimaryKeySelective(shippingInfo);

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
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
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
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    public ShippingInfoResponse getDefaultShippingInfoByUserId(int endUserId) {
        ShippingInfoResponse shippingInfoResponse = new ShippingInfoResponse();

        ShippingInfoExample shippingInfoExample = new ShippingInfoExample();
        ShippingInfoExample.Criteria criteria = shippingInfoExample.createCriteria();
        criteria.andIsDefaultEqualTo(true);
        criteria.andIsDeletedEqualTo(false);

        List<ShippingInfo> shippingInfoList = shippingInfoMapper.selectByExample(shippingInfoExample);
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
