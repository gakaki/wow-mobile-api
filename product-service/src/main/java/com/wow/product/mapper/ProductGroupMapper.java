package com.wow.product.mapper;

import com.wow.product.model.ProductGroup;
import com.wow.product.model.ProductGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductGroupMapper {
    int countByExample(ProductGroupExample example);

    int deleteByExample(ProductGroupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductGroup record);

    int insertSelective(ProductGroup record);

    List<ProductGroup> selectByExample(ProductGroupExample example);

    ProductGroup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductGroup record, @Param("example") ProductGroupExample example);

    int updateByExample(@Param("record") ProductGroup record, @Param("example") ProductGroupExample example);

    int updateByPrimaryKeySelective(ProductGroup record);

    int updateByPrimaryKey(ProductGroup record);
}