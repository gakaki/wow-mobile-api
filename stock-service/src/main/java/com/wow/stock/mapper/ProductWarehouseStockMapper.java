package com.wow.stock.mapper;

import com.wow.stock.model.ProductWarehouseStock;
import com.wow.stock.model.ProductWarehouseStockExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductWarehouseStockMapper {
    int countByExample(ProductWarehouseStockExample example);

    int deleteByExample(ProductWarehouseStockExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductWarehouseStock record);

    int insertSelective(ProductWarehouseStock record);

    List<ProductWarehouseStock> selectByExample(ProductWarehouseStockExample example);

    ProductWarehouseStock selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductWarehouseStock record, @Param("example") ProductWarehouseStockExample example);

    int updateByExample(@Param("record") ProductWarehouseStock record, @Param("example") ProductWarehouseStockExample example);

    int updateByPrimaryKeySelective(ProductWarehouseStock record);

    int updateByPrimaryKey(ProductWarehouseStock record);
}