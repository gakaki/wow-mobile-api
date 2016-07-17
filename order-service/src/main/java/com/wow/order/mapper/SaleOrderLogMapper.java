package com.wow.order.mapper;

import com.wow.order.model.SaleOrderLog;
import com.wow.order.model.SaleOrderLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleOrderLogMapper {
    int countByExample(SaleOrderLogExample example);

    int deleteByExample(SaleOrderLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleOrderLog record);

    int insertSelective(SaleOrderLog record);

    List<SaleOrderLog> selectByExample(SaleOrderLogExample example);

    SaleOrderLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SaleOrderLog record, @Param("example") SaleOrderLogExample example);

    int updateByExample(@Param("record") SaleOrderLog record, @Param("example") SaleOrderLogExample example);

    int updateByPrimaryKeySelective(SaleOrderLog record);

    int updateByPrimaryKey(SaleOrderLog record);
}