package com.wow.order.mapper;

import com.wow.order.model.FreightTemplate;

public interface FreightTemplateMapper {
    int insert(FreightTemplate record);

    int insertSelective(FreightTemplate record);

    FreightTemplate selectByPrimaryKey(Integer id);
}