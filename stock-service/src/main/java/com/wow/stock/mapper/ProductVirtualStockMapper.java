package com.wow.stock.mapper;

import com.wow.stock.model.ProductVirtualStock;
import com.wow.stock.model.ProductVirtualStockExample;
import com.wow.stock.vo.VirtualStockVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

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

    Integer getAvailableVirtualStock(@Param("productId")int productId);

    List<VirtualStockVo> getAvailableVirtualStocks(@Param("productIds")List<Integer> productIds);

    Integer getFrozenVirtualStock(@Param("productId")int productId);

    int unfreezeVirtualStock(@Param("productId")int productId, @Param("productQty")int productQty);

    int freezeVirtualStock(@Param("productId")int productId, @Param("productQty")int productQty);

    //虚拟发货,同时扣减虚拟库存和虚拟冻结库存
    int shipOutVirtualStock(@Param("productId")int productId, @Param("productQty")int productQty);

    /**
     * 查找所有有虚拟冻结的产品库存信息
     * @return
     */
    List<ProductVirtualStock> selectAllProductsWithFrozenVirtualStock();

}