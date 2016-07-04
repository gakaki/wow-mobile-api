package com.wow.product.mapper;

import com.wow.product.model.ProductCombine;
import com.wow.product.model.ProductCombineExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductCombineMapper {
    int countByExample(ProductCombineExample example);

    int deleteByExample(ProductCombineExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductCombine record);

    int insertBatch(List<ProductCombine> productCombines);

    int insertSelective(ProductCombine record);

    List<ProductCombine> selectByExample(ProductCombineExample example);

    ProductCombine selectByPrimaryKey(Integer id);

     List<ProductCombine>  selectByProductId(Integer id);

    int updateByExampleSelective(@Param("record") ProductCombine record, @Param("example") ProductCombineExample example);

    int updateByExample(@Param("record") ProductCombine record, @Param("example") ProductCombineExample example);

    int updateByPrimaryKeySelective(ProductCombine record);

    int updateByPrimaryKey(ProductCombine record);
}