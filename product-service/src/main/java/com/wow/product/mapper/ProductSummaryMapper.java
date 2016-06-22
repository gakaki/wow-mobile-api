package com.wow.product.mapper;

import com.wow.product.model.ProductSummary;
import com.wow.product.model.ProductSummaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductSummaryMapper {
    int countByExample(ProductSummaryExample example);

    int deleteByExample(ProductSummaryExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductSummary record);

    int insertSelective(ProductSummary record);

    List<ProductSummary> selectByExample(ProductSummaryExample example);

    ProductSummary selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductSummary record, @Param("example") ProductSummaryExample example);

    int updateByExample(@Param("record") ProductSummary record, @Param("example") ProductSummaryExample example);

    int updateByPrimaryKeySelective(ProductSummary record);

    int updateByPrimaryKey(ProductSummary record);
}