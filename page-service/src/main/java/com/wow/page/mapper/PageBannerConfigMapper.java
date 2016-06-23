package com.wow.page.mapper;

import com.wow.page.model.PageBannerConfig;
import com.wow.page.model.PageBannerConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PageBannerConfigMapper {
    int countByExample(PageBannerConfigExample example);

    int deleteByExample(PageBannerConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PageBannerConfig record);

    int insertSelective(PageBannerConfig record);

    List<PageBannerConfig> selectByExample(PageBannerConfigExample example);

    PageBannerConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PageBannerConfig record, @Param("example") PageBannerConfigExample example);

    int updateByExample(@Param("record") PageBannerConfig record, @Param("example") PageBannerConfigExample example);

    int updateByPrimaryKeySelective(PageBannerConfig record);

    int updateByPrimaryKey(PageBannerConfig record);
}