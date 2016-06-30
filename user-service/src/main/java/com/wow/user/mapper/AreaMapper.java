package com.wow.user.mapper;

import com.wow.user.model.Area;
import com.wow.user.model.AreaExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AreaMapper {
    int countByExample(AreaExample example);

    int deleteByExample(AreaExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Area record);

    int insertSelective(Area record);

    List<Area> selectByExample(AreaExample example);

    Area selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Area record, @Param("example") AreaExample example);

    int updateByExample(@Param("record") Area record, @Param("example") AreaExample example);

    int updateByPrimaryKeySelective(Area record);

    int updateByPrimaryKey(Area record);

    /**
     * 查找一级区域
     * @return
     */
    List<Area> selectFirstLevelArea();

    /**
     * 查找下级区域
     * @param areaId
     * @return
     */
    List<Area> selectNextLevelArea(@Param("areaId") int areaId);

}