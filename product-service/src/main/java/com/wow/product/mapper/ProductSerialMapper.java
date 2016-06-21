package com.wow.product.mapper;

import com.wow.product.model.ProductSerial;

public interface ProductSerialMapper {
    int insert(ProductSerial record);

    int insertSelective(ProductSerial record);

    ProductSerial selectByPrimaryKey(Integer id);
}