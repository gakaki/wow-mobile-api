package com.wow.attribute.mapper;

import com.wow.attribute.model.CategoryAttribute;
import com.wow.attribute.model.CategoryAttributeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CategoryAttributeMapper {
    int countByExample(CategoryAttributeExample example);

    int deleteByExample(CategoryAttributeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CategoryAttribute record);

    int insertSelective(CategoryAttribute record);

    List<CategoryAttribute> selectByExample(CategoryAttributeExample example);

    CategoryAttribute selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CategoryAttribute record, @Param("example") CategoryAttributeExample example);

    int updateByExample(@Param("record") CategoryAttribute record, @Param("example") CategoryAttributeExample example);

    int updateByPrimaryKeySelective(CategoryAttribute record);

    int updateByPrimaryKey(CategoryAttribute record);
}