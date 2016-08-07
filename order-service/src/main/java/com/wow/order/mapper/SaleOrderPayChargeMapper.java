package com.wow.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wow.order.model.SaleOrderPayCharge;
import com.wow.order.model.SaleOrderPayChargeExample;

public interface SaleOrderPayChargeMapper {
    int countByExample(SaleOrderPayChargeExample example);

    int deleteByExample(SaleOrderPayChargeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleOrderPayCharge record);

    int insertSelective(SaleOrderPayCharge record);

    List<SaleOrderPayCharge> selectByExample(SaleOrderPayChargeExample example);

    SaleOrderPayCharge selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SaleOrderPayCharge record, @Param("example") SaleOrderPayChargeExample example);

    int updateByExample(@Param("record") SaleOrderPayCharge record, @Param("example") SaleOrderPayChargeExample example);

    int updateByPrimaryKeySelective(SaleOrderPayCharge record);

    int updateByPrimaryKey(SaleOrderPayCharge record);

    SaleOrderPayCharge selectOnlyByExample(SaleOrderPayChargeExample example);

}