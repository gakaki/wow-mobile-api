package com.wow.common.util;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wow.common.factory.SpringBeanFactory;
import com.wow.common.mapper.BaseMaterialMapper;
import com.wow.common.model.BaseMaterial;

/**
 * Created by win7 on 2016/8/10.
 */
public class MaterialDataUtil {

    private static final BaseMaterialMapper baseMaterialMapper = SpringBeanFactory
        .getBean("baseMaterialMapper", BaseMaterialMapper.class);

    public static String getMaterialById(int id) {
        Object v = RedisUtil.get("m_" + id);
        if (v == null) {
            BaseMaterial baseMaterial = baseMaterialMapper.queryMaterialById(id);
            if (baseMaterial == null)
                return null;
            v = baseMaterial.getName();
            RedisUtil.set("m_" + id, baseMaterial.getName());
        }
        return v.toString();
    }

    public static void addAllMaterial(List<BaseMaterial> list) {
        Map<Serializable, Object> map = new HashMap<Serializable, Object>(50);
        int count = 1;

        for (BaseMaterial m : list) {
            if (count % 50 == 0) {
                RedisUtil.multiSet(map);
                map.clear();
            }

            map.put("m_" + m.getId(), m.getName());
            count++;
        }
    }

    public static void init() {
        addAllMaterial(baseMaterialMapper.queryAllMaterial());
    }
}
