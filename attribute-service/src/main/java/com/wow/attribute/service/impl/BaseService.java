package com.wow.attribute.service.impl;

import com.sun.deploy.util.ReflectionUtil;
import com.wow.attribute.mapper.BaseMapper;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by fangying@wowdsgn on 2016/6/30.
 */
public abstract class BaseService<T> implements BaseMapper<T>{

    @Autowired
    BaseMapper baseMapper;

    public abstract void setMapper();


    @Override
    public int insert(T t) {
        return baseMapper.insert(t);
    }

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return baseMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKey(T t) {
        return baseMapper.updateByPrimaryKey(t);
    }

    @Override
    public T selectByPrimaryKey(Integer id) {
         return (T)baseMapper.selectByPrimaryKey(id);
    }
}
