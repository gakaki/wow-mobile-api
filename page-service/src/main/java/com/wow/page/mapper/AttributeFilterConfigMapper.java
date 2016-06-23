package com.wow.page.mapper;

import com.wow.page.model.AttributeFilterConfig;
import com.wow.page.model.AttributeFilterConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AttributeFilterConfigMapper {
    int countByExample(AttributeFilterConfigExample example);

    int deleteByExample(AttributeFilterConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AttributeFilterConfig record);

    int insertSelective(AttributeFilterConfig record);

    List<AttributeFilterConfig> selectByExample(AttributeFilterConfigExample example);

    AttributeFilterConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AttributeFilterConfig record, @Param("example") AttributeFilterConfigExample example);

    int updateByExample(@Param("record") AttributeFilterConfig record, @Param("example") AttributeFilterConfigExample example);

    int updateByPrimaryKeySelective(AttributeFilterConfig record);

    int updateByPrimaryKey(AttributeFilterConfig record);
}