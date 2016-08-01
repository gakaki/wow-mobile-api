package com.wow.price.mapper;

import java.math.BigDecimal;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wow.price.model.ProductPrice;
import com.wow.price.model.ProductPriceExample;

public interface ProductPriceMapper {
    int countByExample(ProductPriceExample example);

    int deleteByExample(ProductPriceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductPrice record);

    int insertSelective(ProductPrice record);

    List<ProductPrice> selectByExample(ProductPriceExample example);

    ProductPrice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductPrice record, @Param("example") ProductPriceExample example);

    int updateByExample(@Param("record") ProductPrice record, @Param("example") ProductPriceExample example);

    int updateByPrimaryKeySelective(ProductPrice record);

    int updateByPrimaryKey(ProductPrice record);

    ProductPrice selectByProductId(@Param("productId") int productId);

    List<ProductPrice> selectByProductIds(@Param("productIds") List<Integer> productIds);
    
    List<ProductPrice> selectPriceChangedProduct(@Param("updateStartTime") String updateStartTime,@Param("updateEndTime") String updateEndTime);
    
    int updateProductMinPrice(@Param("productId") int productId,@Param("sellPrice") BigDecimal sellPrice);
    
//    /**
//     * 查找系列品的价格(取售价最低的子品)
//     * @param productId
//     * @return
//     */
//    ProductPrice selectMinSalePriceByProductId(@Param("productId") int productId);
}