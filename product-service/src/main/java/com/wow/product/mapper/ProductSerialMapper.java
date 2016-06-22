package com.wow.product.mapper;

import com.wow.product.model.ProductSerial;
import com.wow.product.model.ProductSerialExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductSerialMapper {
    int countByExample(ProductSerialExample example);

    int deleteByExample(ProductSerialExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductSerial record);

    int insertSelective(ProductSerial record);

    List<ProductSerial> selectByExample(ProductSerialExample example);

    ProductSerial selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductSerial record, @Param("example") ProductSerialExample example);

    int updateByExample(@Param("record") ProductSerial record, @Param("example") ProductSerialExample example);

    int updateByPrimaryKeySelective(ProductSerial record);

    int updateByPrimaryKey(ProductSerial record);
}