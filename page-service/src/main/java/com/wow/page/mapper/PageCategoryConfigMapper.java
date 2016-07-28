package com.wow.page.mapper;

import com.wow.page.model.PageCategoryConfig;
import com.wow.page.model.PageCategoryConfigExample;
import com.wow.page.vo.PageCategoryVo;

import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PageCategoryConfigMapper {
    int countByExample(PageCategoryConfigExample example);

    int deleteByExample(PageCategoryConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PageCategoryConfig record);

    int insertSelective(PageCategoryConfig record);

    List<PageCategoryConfig> selectByExample(PageCategoryConfigExample example);

    PageCategoryConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PageCategoryConfig record, @Param("example") PageCategoryConfigExample example);

    int updateByExample(@Param("record") PageCategoryConfig record, @Param("example") PageCategoryConfigExample example);

    int updateByPrimaryKeySelective(PageCategoryConfig record);

    int updateByPrimaryKey(PageCategoryConfig record);
    
    List<PageCategoryVo> selectByParentCategoryId(@Param("pageType") int pageType,@Param("categoryLevel") Integer categoryLevel);
}