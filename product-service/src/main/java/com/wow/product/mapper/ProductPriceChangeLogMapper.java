package com.wow.product.mapper;

import com.wow.product.model.ProductPriceChangeLog;
import com.wow.product.model.ProductPriceChangeLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductPriceChangeLogMapper {
    int countByExample(ProductPriceChangeLogExample example);

    int deleteByExample(ProductPriceChangeLogExample example);

    int insert(ProductPriceChangeLog record);

    int insertSelective(ProductPriceChangeLog record);

    List<ProductPriceChangeLog> selectByExample(ProductPriceChangeLogExample example);

    int updateByExampleSelective(@Param("record") ProductPriceChangeLog record, @Param("example") ProductPriceChangeLogExample example);

    int updateByExample(@Param("record") ProductPriceChangeLog record, @Param("example") ProductPriceChangeLogExample example);
}