package com.wow.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wow.order.model.SaleOrderItemWarehouse;
import com.wow.order.model.SaleOrderItemWarehouseExample;

public interface SaleOrderItemWarehouseMapper {
    int countByExample(SaleOrderItemWarehouseExample example);

    int deleteByExample(SaleOrderItemWarehouseExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleOrderItemWarehouse record);
    
    int batchInsertSelective(List<SaleOrderItemWarehouse> records);

    int insertSelective(SaleOrderItemWarehouse record);

    List<SaleOrderItemWarehouse> selectByExample(SaleOrderItemWarehouseExample example);

    SaleOrderItemWarehouse selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SaleOrderItemWarehouse record, @Param("example") SaleOrderItemWarehouseExample example);

    int updateByExample(@Param("record") SaleOrderItemWarehouse record, @Param("example") SaleOrderItemWarehouseExample example);

    int updateByPrimaryKeySelective(SaleOrderItemWarehouse record);

    int updateByPrimaryKey(SaleOrderItemWarehouse record);
}