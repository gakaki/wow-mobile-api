package com.wow.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wow.order.model.SaleOrderPay;
import com.wow.order.model.SaleOrderPayExample;

public interface SaleOrderPayMapper {
    int countByExample(SaleOrderPayExample example);

    int deleteByExample(SaleOrderPayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleOrderPay record);

    int insertSelective(SaleOrderPay record);

    List<SaleOrderPay> selectByExample(SaleOrderPayExample example);

    SaleOrderPay selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SaleOrderPay record, @Param("example") SaleOrderPayExample example);

    int updateByExample(@Param("record") SaleOrderPay record, @Param("example") SaleOrderPayExample example);

    int updateByPrimaryKeySelective(SaleOrderPay record);

    int updateByPrimaryKey(SaleOrderPay record);

    SaleOrderPay selectOnlyByExample(SaleOrderPayExample example);

}