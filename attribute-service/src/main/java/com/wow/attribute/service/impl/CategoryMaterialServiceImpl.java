package com.wow.attribute.service.impl;

import com.wow.attribute.mapper.CategoryMaterialMapper;
import com.wow.attribute.service.CategoryMaterialService;
import com.wow.attribute.vo.response.MaterialResponse;
import com.wow.common.util.ErrorCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by win7 on 2016/8/4.
 */
@Service
public class CategoryMaterialServiceImpl implements CategoryMaterialService {

    @Autowired
    private CategoryMaterialMapper categoryMaterialMapper;

    @Override
    public MaterialResponse queryMaterialsByCategory(int categoryId) {
        MaterialResponse resp=new MaterialResponse();
        if(categoryId==0){
            resp.setResCode("40405");
            resp.setResMsg(ErrorCodeUtil.getErrorMsg("40405"));
        }
        resp.setCategoryMaterial(categoryMaterialMapper.queryMaterialsByCategory(categoryId));
        return resp;
    }
}
