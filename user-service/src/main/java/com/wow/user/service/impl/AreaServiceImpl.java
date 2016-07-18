package com.wow.user.service.impl;

import com.wow.user.mapper.AreaMapper;
import com.wow.user.model.Area;
import com.wow.user.model.AreaExample;
import com.wow.user.model.EndUserExample;
import com.wow.user.service.AreaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private static final Logger logger = LoggerFactory.getLogger(AreaServiceImpl.class);

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
        return areaMapper.insertSelective(area);
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
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Area> getFirstLevelArea() {
        AreaExample areaExample = new AreaExample();
        AreaExample.Criteria criteria = areaExample.createCriteria();
        criteria.andAreaLevelEqualTo((byte)1);
        List<Area> areaList = areaMapper.selectByExample(areaExample);
        logger.info("areaList:" + areaList);
        return areaList;
    }

    /**
     * 查找下级区域
     *
     * @param areaId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Area> getNextLevelArea(int areaId) {
        AreaExample areaExample = new AreaExample();
        AreaExample.Criteria criteria = areaExample.createCriteria();
        criteria.andParentAreaIdEqualTo(areaId);
        List<Area> areaList = areaMapper.selectByExample(areaExample);
        logger.info("areaList:" + areaList);
        return areaList;
    }

}
