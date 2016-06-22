package com.wow.marketing.mapper;

import com.wow.marketing.model.EndUserCoupon;
import com.wow.marketing.model.EndUserCouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EndUserCouponMapper {
    int countByExample(EndUserCouponExample example);

    int deleteByExample(EndUserCouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserCoupon record);

    int insertSelective(EndUserCoupon record);

    List<EndUserCoupon> selectByExample(EndUserCouponExample example);

    EndUserCoupon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserCoupon record, @Param("example") EndUserCouponExample example);

    int updateByExample(@Param("record") EndUserCoupon record, @Param("example") EndUserCouponExample example);

    int updateByPrimaryKeySelective(EndUserCoupon record);

    int updateByPrimaryKey(EndUserCoupon record);
}