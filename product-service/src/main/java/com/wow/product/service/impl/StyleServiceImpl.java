package com.wow.product.service.impl;

import com.wow.product.mapper.StyleMapper;
import com.wow.product.model.Style;
import com.wow.product.model.StyleExample;
import com.wow.product.service.StyleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * Created by fangying@wowdsgn on 2016/7/7.
 */
@Service
@Transactional(value = "productTransactionManager")
public class StyleServiceImpl implements StyleService{
    @Autowired
    private StyleMapper styleMapper;
    @Override
    public int createStyle(Style style) {
        return styleMapper.insertSelective(style);
    }

    @Override
    public int updateStyle(Style style) {
        return styleMapper.updateByPrimaryKeySelective(style);
    }

    @Override
    public int deleteStyle(Style style) {
        if(style!=null)
            style.setIsDeleted(true);
        return updateStyle(style);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public Style getStyleById(Integer styleId) {

           return styleMapper.selectByPrimaryKey(styleId);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public Style getStyleByName(String styleName) throws Exception {
        StyleExample example=new StyleExample();
        example.or().andStyleNameEqualTo(styleName).andIsDeletedEqualTo(false);
        return styleMapper.selectByExample(example).get(0);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Style> getAllStyles() {
        return styleMapper.selectAll();
    }
}
