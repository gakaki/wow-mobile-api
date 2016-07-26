package com.wow.order.mapper;

import com.wow.order.model.SaleOrderItem;
import com.wow.order.model.SaleOrderItemExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleOrderItemMapper {
    int countByExample(SaleOrderItemExample example);

    int deleteByExample(SaleOrderItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleOrderItem record);

    int insertSelective(SaleOrderItem record);

    List<SaleOrderItem> selectByExample(SaleOrderItemExample example);

    SaleOrderItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SaleOrderItem record, @Param("example") SaleOrderItemExample example);

    int updateByExample(@Param("record") SaleOrderItem record, @Param("example") SaleOrderItemExample example);

    int updateByPrimaryKeySelective(SaleOrderItem record);

    int updateByPrimaryKey(SaleOrderItem record);
}