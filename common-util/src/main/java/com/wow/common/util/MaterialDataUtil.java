package com.wow.common.util;

import com.wow.common.factory.SpringBeanFactory;
import com.wow.common.mapper.BaseMaterialMapper;
import com.wow.common.model.BaseMaterial;
import com.wow.common.model.Country;
import com.wow.common.service.BaseMaterialService;

import java.util.List;

/**
 * Created by win7 on 2016/8/10.
 */
public class MaterialDataUtil {

    private static final BaseMaterialMapper baseMaterialMapper= SpringBeanFactory
            .getBean("baseMaterialMapper", BaseMaterialMapper.class);

    public static String getMaterialById(int id){
        Object v=RedisUtil.get("m_"+id);
        if(v==null){
            BaseMaterial baseMaterial=baseMaterialMapper.queryMaterialById(id);
            if(baseMaterial==null)
                return null;
            v=baseMaterial.getName();
            RedisUtil.set("m_"+id,baseMaterial.getName());
        }
        return v.toString();
    }

    public static void addAllMaterial(List<BaseMaterial> list){
        for(BaseMaterial m:list)
            RedisUtil.set("m_"+m.getId(),m.getName());
    }

    public static void init(){
        addAllMaterial(baseMaterialMapper.queryAllMaterial());
    }
}
