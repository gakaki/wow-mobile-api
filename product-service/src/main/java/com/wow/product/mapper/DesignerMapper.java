package com.wow.product.mapper;

import com.wow.product.model.Designer;

public interface DesignerMapper {
    int insert(Designer record);

    int insertSelective(Designer record);

    Designer selectByPrimaryKey(Integer id);
}