package com.wow.user.mapper;

import com.wow.user.model.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Area record);

    int insertSelective(Area record);

    Area selectByPrimaryKey(Integer id);

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