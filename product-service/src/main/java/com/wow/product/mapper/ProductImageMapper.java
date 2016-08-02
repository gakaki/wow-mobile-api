package com.wow.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wow.product.model.ProductImage;
import com.wow.product.model.ProductImageExample;

public interface ProductImageMapper {
    int countByExample(ProductImageExample example);

    int deleteByExample(ProductImageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductImage record);


    int insertSelective(ProductImage record);

    List<ProductImage> selectByExample(ProductImageExample example);

    ProductImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductImage record, @Param("example") ProductImageExample example);

    int updateByExample(@Param("record") ProductImage record, @Param("example") ProductImageExample example);

    int updateByPrimaryKeySelective(ProductImage record);

    int updateByPrimaryKey(ProductImage record);
    
    ProductImage selectProductPrimaryOneImg(Integer productId);

    List<ProductImage> selectProductListPrimaryOneImg(@Param("productIds") List<Integer> productIds);

    int addByBatch(List<ProductImage> list);
}