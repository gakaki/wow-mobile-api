package com.wow.page.mapper;

import com.wow.page.model.PageSceneConfig;
import com.wow.page.model.PageSceneConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PageSceneConfigMapper {
    int countByExample(PageSceneConfigExample example);

    int deleteByExample(PageSceneConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PageSceneConfig record);

    int insertSelective(PageSceneConfig record);

    List<PageSceneConfig> selectByExample(PageSceneConfigExample example);

    PageSceneConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PageSceneConfig record, @Param("example") PageSceneConfigExample example);

    int updateByExample(@Param("record") PageSceneConfig record, @Param("example") PageSceneConfigExample example);

    int updateByPrimaryKeySelective(PageSceneConfig record);

    int updateByPrimaryKey(PageSceneConfig record);

    List<PageSceneConfig> selectByPageType(@Param("pageType") int pageType);
}