package com.wow.page.mapper;

import com.wow.page.model.PageTopicConfig;
import com.wow.page.model.PageTopicConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PageTopicConfigMapper {
    int countByExample(PageTopicConfigExample example);

    int deleteByExample(PageTopicConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PageTopicConfig record);

    int insertSelective(PageTopicConfig record);

    List<PageTopicConfig> selectByExample(PageTopicConfigExample example);

    PageTopicConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PageTopicConfig record, @Param("example") PageTopicConfigExample example);

    int updateByExample(@Param("record") PageTopicConfig record, @Param("example") PageTopicConfigExample example);

    int updateByPrimaryKeySelective(PageTopicConfig record);

    int updateByPrimaryKey(PageTopicConfig record);
}