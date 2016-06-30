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

    int adjustVirtualStock(@Param("productId")int productId, @Param("adjustNum")int adjustNum);

    int getAvailableVirtualStock(@Param("productId")int productId);

    int getFrozenVirtualStock(@Param("productId")int productId);

    int unfreezeVirtualStock(@Param("productId")int productId, @Param("productQty")int productQty);

    //虚拟发货,同时扣减虚拟库存和虚拟冻结库存
    int shipOutVirtualStock(@Param("productId")int productId, @Param("productQty")int productQty);

}