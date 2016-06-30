package com.wow.user.mapper;

import com.wow.user.model.ShippingInfo;
import com.wow.user.model.ShippingInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ShippingInfoMapper {
    int countByExample(ShippingInfoExample example);

    int deleteByExample(ShippingInfoExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShippingInfo record);

    int insertSelective(ShippingInfo record);

    List<ShippingInfo> selectByExample(ShippingInfoExample example);

    ShippingInfo selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShippingInfo record, @Param("example") ShippingInfoExample example);

    int updateByExample(@Param("record") ShippingInfo record, @Param("example") ShippingInfoExample example);

    int updateByPrimaryKeySelective(ShippingInfo record);

    int updateByPrimaryKey(ShippingInfo record);

    /**
     * 查找用户的收货信息
     * @param endUserId
     * @return
     */
    List<ShippingInfo> selectByUserId(@Param("endUserId") int endUserId);

    /**
     * 查询用户默认收货信息
     * @param endUserId
     * @return
     */
    ShippingInfo selectDefault(@Param("endUserId") int endUserId);
}