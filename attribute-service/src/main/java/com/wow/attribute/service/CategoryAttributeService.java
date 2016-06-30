package com.wow.attribute.service;

import com.wow.attribute.mapper.BaseMapper;
import com.wow.attribute.model.CategoryAttribute;

import java.util.List;


/**
 * Created by fangying@wowdsgn on 2016/6/30.
 */
public interface CategoryAttributeService extends BaseMapper<CategoryAttribute> {

    List<CategoryAttribute> selectByCategoryId(int categoryId);
    int deleteByCategoryId(int categoryId);
    int insertBatch(List<CategoryAttribute> CategoryAttributes);
}
