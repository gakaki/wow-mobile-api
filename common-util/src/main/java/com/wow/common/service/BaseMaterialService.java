package com.wow.common.service;

import com.wow.common.model.BaseMaterial;

import java.util.List;

/**
 * Created by win7 on 2016/8/10.
 */
public interface BaseMaterialService {

    /**
     * 获取所有可用的材质
     * @return
     */
    List<BaseMaterial> queryAllMaterial();

    /**
     * 根据材质id获取材质
     * @param id
     * @return
     */
    BaseMaterial queryMaterialById(int id);
}
