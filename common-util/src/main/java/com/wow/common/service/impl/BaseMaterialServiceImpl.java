package com.wow.common.service.impl;

import com.wow.common.mapper.BaseMaterialMapper;
import com.wow.common.model.BaseMaterial;
import com.wow.common.service.BaseMaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by win7 on 2016/8/10.
 */
@Service
public class BaseMaterialServiceImpl implements BaseMaterialService {

    @Autowired
    private BaseMaterialMapper materialMapper;

    public List<BaseMaterial> queryAllMaterial(){
        return materialMapper.queryAllMaterial();
    }
}
