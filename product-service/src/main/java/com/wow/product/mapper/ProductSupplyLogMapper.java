package com.wow.product.mapper;

import com.wow.product.model.ProductSupplyLog;
import com.wow.product.model.ProductSupplyLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductSupplyLogMapper {
    int countByExample(ProductSupplyLogExample example);

    int deleteByExample(ProductSupplyLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductSupplyLog record);

    int insertSelective(ProductSupplyLog record);

    List<ProductSupplyLog> selectByExample(ProductSupplyLogExample example);

    ProductSupplyLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductSupplyLog record, @Param("example") ProductSupplyLogExample example);

    int updateByExample(@Param("record") ProductSupplyLog record, @Param("example") ProductSupplyLogExample example);

    int updateByPrimaryKeySelective(ProductSupplyLog record);

    int updateByPrimaryKey(ProductSupplyLog record);
}