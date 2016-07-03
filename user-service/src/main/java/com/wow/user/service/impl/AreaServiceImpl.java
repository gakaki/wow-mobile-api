package com.wow.user.service.impl;

import com.wow.user.mapper.AreaMapper;
import com.wow.user.model.Area;
import com.wow.user.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/30.
 */
@Service
@Transactional(value = "userTransactionManager")
public class AreaServiceImpl implements AreaService{

    @Autowired
    private AreaMapper areaMapper;

    /**
     * 创建区域
     *
     * @param area
     * @return
     */
    @Override
    public int createArea(Area area) {
        return areaMapper.insert(area);
    }

    /**
     * 删除区域
     *
     * @param areaId
     * @return
     */
    @Override
    public int deleteArea(int areaId) {
        return areaMapper.deleteByPrimaryKey(areaId);
    }

    /**
     * 查找一级区域(省、直辖市)
     *
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public List<Area> findFirstLevelArea() {
        return areaMapper.selectFirstLevelArea();
    }

    /**
     * 查找下级区域
     *
     * @param areaId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public List<Area> findNextLevelArea(int areaId) {
        return areaMapper.selectNextLevelArea(areaId);
    }

}
