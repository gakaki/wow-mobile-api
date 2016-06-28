package com.wow.product.mapper;

import com.wow.product.model.ProductMaterial;
import com.wow.product.model.ProductMaterialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductMaterialMapper {
    int countByExample(ProductMaterialExample example);

    int deleteByExample(ProductMaterialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductMaterial record);

    int insertSelective(ProductMaterial record);

    List<ProductMaterial> selectByExample(ProductMaterialExample example);

    ProductMaterial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductMaterial record, @Param("example") ProductMaterialExample example);

    int updateByExample(@Param("record") ProductMaterial record, @Param("example") ProductMaterialExample example);

    int updateByPrimaryKeySelective(ProductMaterial record);

    int updateByPrimaryKey(ProductMaterial record);
}