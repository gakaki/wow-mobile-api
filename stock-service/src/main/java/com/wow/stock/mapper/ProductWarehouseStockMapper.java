package com.wow.stock.mapper;

import com.wow.stock.model.ProductWarehouseStock;
import com.wow.stock.model.ProductWarehouseStockExample;
import java.util.List;
import java.util.Map;

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

    int adjustWarehouseRealStock(@Param("productId")int productId, @Param("warehouseId")int warehouseId, @Param("adjustNum")int adjustNum);

    int freezeWarehouseStock(@Param("productId")int productId, @Param("warehouseId")int warehouseId, @Param("productQty")int productQty);

    int unfreezeWarehouseStock(@Param("productId")int productId, @Param("warehouseId")int warehouseId, @Param("productQty")int productQty);

    Map<Integer,Integer> getWarehouseAvailableStock(@Param("productId")int productId);

    int shipOutWarehouseGoods(@Param("productId")int productId, @Param("warehouseId")int warehouseId, @Param("productQty")int productQty);

    List<Integer> selectWarehouseByProductId(@Param("productId")int productId);

}