package com.wow.product.mapper;

import com.wow.product.model.SupplierBrand;
import com.wow.product.model.SupplierBrandExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SupplierBrandMapper {
    int countByExample(SupplierBrandExample example);

    int deleteByExample(SupplierBrandExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SupplierBrand record);

    int insertSelective(SupplierBrand record);

    List<SupplierBrand> selectByExample(SupplierBrandExample example);

    SupplierBrand selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SupplierBrand record, @Param("example") SupplierBrandExample example);

    int updateByExample(@Param("record") SupplierBrand record, @Param("example") SupplierBrandExample example);

    int updateByPrimaryKeySelective(SupplierBrand record);

    int updateByPrimaryKey(SupplierBrand record);
}