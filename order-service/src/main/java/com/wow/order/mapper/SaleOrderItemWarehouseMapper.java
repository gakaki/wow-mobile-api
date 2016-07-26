package com.wow.order.mapper;

import com.wow.order.model.SaleOrderItemWarehouse;
import com.wow.order.model.SaleOrderItemWarehouseExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleOrderItemWarehouseMapper {
    int countByExample(SaleOrderItemWarehouseExample example);

    int deleteByExample(SaleOrderItemWarehouseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleOrderItemWarehouse record);

    int insertSelective(SaleOrderItemWarehouse record);

    List<SaleOrderItemWarehouse> selectByExample(SaleOrderItemWarehouseExample example);

    SaleOrderItemWarehouse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SaleOrderItemWarehouse record, @Param("example") SaleOrderItemWarehouseExample example);

    int updateByExample(@Param("record") SaleOrderItemWarehouse record, @Param("example") SaleOrderItemWarehouseExample example);

    int updateByPrimaryKeySelective(SaleOrderItemWarehouse record);

    int updateByPrimaryKey(SaleOrderItemWarehouse record);
}