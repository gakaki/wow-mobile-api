package com.wow.product.mapper;

import com.wow.product.model.ProductSupplier;
import com.wow.product.model.ProductSupplierExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductSupplierMapper {
    int countByExample(ProductSupplierExample example);

    int deleteByExample(ProductSupplierExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductSupplier record);

    int insertSelective(ProductSupplier record);

    List<ProductSupplier> selectByExample(ProductSupplierExample example);

    ProductSupplier selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductSupplier record, @Param("example") ProductSupplierExample example);

    int updateByExample(@Param("record") ProductSupplier record, @Param("example") ProductSupplierExample example);

    int updateByPrimaryKeySelective(ProductSupplier record);

    int updateByPrimaryKey(ProductSupplier record);
}