package com.wow.product.mapper;

import com.wow.product.model.ProductImage;
import com.wow.product.model.ProductImageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductImageMapper {
    int countByExample(ProductImageExample example);

    int deleteByExample(ProductImageExample example);

    int deleteByPrimaryKey(Integer id);

    int deleteBatch(List<ProductImage> productImages);

    int insert(ProductImage record);

    int insertBatch(List<ProductImage> productImages);

    int insertSelective(ProductImage record);

    List<ProductImage> selectByExample(ProductImageExample example);

    List<ProductImage> selectByProductId(int productId);

    ProductImage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductImage record, @Param("example") ProductImageExample example);

    int updateByExample(@Param("record") ProductImage record, @Param("example") ProductImageExample example);

    int updateByPrimaryKeySelective(ProductImage record);

    int updateByPrimaryKey(ProductImage record);
}