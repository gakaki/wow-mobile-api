package com.wow.user.mapper;

import com.wow.user.model.EndUserShareDesigner;
import com.wow.user.model.EndUserShareDesignerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface EndUserShareDesignerMapper {
    int countByExample(EndUserShareDesignerExample example);

    int deleteByExample(EndUserShareDesignerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EndUserShareDesigner record);

    int insertSelective(EndUserShareDesigner record);

    List<EndUserShareDesigner> selectByExample(EndUserShareDesignerExample example);

    EndUserShareDesigner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EndUserShareDesigner record, @Param("example") EndUserShareDesignerExample example);

    int updateByExample(@Param("record") EndUserShareDesigner record, @Param("example") EndUserShareDesignerExample example);

    int updateByPrimaryKeySelective(EndUserShareDesigner record);

    int updateByPrimaryKey(EndUserShareDesigner record);
}