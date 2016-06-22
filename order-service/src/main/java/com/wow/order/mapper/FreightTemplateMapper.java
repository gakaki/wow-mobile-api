package com.wow.order.mapper;

import com.wow.order.model.FreightTemplate;
import com.wow.order.model.FreightTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FreightTemplateMapper {
    int countByExample(FreightTemplateExample example);

    int deleteByExample(FreightTemplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FreightTemplate record);

    int insertSelective(FreightTemplate record);

    List<FreightTemplate> selectByExample(FreightTemplateExample example);

    FreightTemplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FreightTemplate record, @Param("example") FreightTemplateExample example);

    int updateByExample(@Param("record") FreightTemplate record, @Param("example") FreightTemplateExample example);

    int updateByPrimaryKeySelective(FreightTemplate record);

    int updateByPrimaryKey(FreightTemplate record);
}