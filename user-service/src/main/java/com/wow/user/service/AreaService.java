package com.wow.user.service;

import com.wow.user.model.Area;

import java.util.List;

/**
 * 区域信息服务
 * Created by zhengzhiqing on 16/6/24.
 */
public interface AreaService {
    /**
     * 创建区域
     * @param area
     * @return
     */
    int createArea(Area area);

    /**
     * 删除区域
     * @param areaId
     * @return
     */
    int deleteArea(int areaId);

    /**
     * 查找一级区域(省、直辖市)
     * @return
     */
    List<Area> findFirstLevelArea();

    /**
     * 查找下级区域
     * @param areaId
     * @return
     */
    List<Area> findNextLevelArea(int areaId);

}
