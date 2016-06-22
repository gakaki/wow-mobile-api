package com.wow.stock.mapper;

import com.wow.stock.model.ProductStockChangeLog;
import com.wow.stock.model.ProductStockChangeLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductStockChangeLogMapper {
    int countByExample(ProductStockChangeLogExample example);

    int deleteByExample(ProductStockChangeLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductStockChangeLog record);

    int insertSelective(ProductStockChangeLog record);

    List<ProductStockChangeLog> selectByExample(ProductStockChangeLogExample example);

    ProductStockChangeLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductStockChangeLog record, @Param("example") ProductStockChangeLogExample example);

    int updateByExample(@Param("record") ProductStockChangeLog record, @Param("example") ProductStockChangeLogExample example);

    int updateByPrimaryKeySelective(ProductStockChangeLog record);

    int updateByPrimaryKey(ProductStockChangeLog record);
}