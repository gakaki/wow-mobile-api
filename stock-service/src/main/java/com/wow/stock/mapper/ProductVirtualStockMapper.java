package com.wow.stock.mapper;

import com.wow.stock.model.ProductVirtualStock;
import com.wow.stock.model.ProductVirtualStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductVirtualStockMapper {
    int countByExample(ProductVirtualStockExample example);

    int deleteByExample(ProductVirtualStockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductVirtualStock record);

    int insertSelective(ProductVirtualStock record);

    List<ProductVirtualStock> selectByExample(ProductVirtualStockExample example);

    ProductVirtualStock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductVirtualStock record, @Param("example") ProductVirtualStockExample example);

    int updateByExample(@Param("record") ProductVirtualStock record, @Param("example") ProductVirtualStockExample example);

    int updateByPrimaryKeySelective(ProductVirtualStock record);

    int updateByPrimaryKey(ProductVirtualStock record);
}