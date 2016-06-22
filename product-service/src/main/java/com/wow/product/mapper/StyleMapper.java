package com.wow.product.mapper;

import com.wow.product.model.Style;
import com.wow.product.model.StyleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StyleMapper {
    int countByExample(StyleExample example);

    int deleteByExample(StyleExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Style record);

    int insertSelective(Style record);

    List<Style> selectByExample(StyleExample example);

    Style selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Style record, @Param("example") StyleExample example);

    int updateByExample(@Param("record") Style record, @Param("example") StyleExample example);

    int updateByPrimaryKeySelective(Style record);

    int updateByPrimaryKey(Style record);
}