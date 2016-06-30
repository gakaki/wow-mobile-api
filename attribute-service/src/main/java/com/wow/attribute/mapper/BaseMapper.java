package com.wow.attribute.mapper;


import java.io.Serializable;

/**
 * Created by fangying@wowdsgn on 2016/6/30.
 */
 public interface BaseMapper <T> {

    int insert(T t);

    int deleteByPrimaryKey(Integer id);

    int updateByPrimaryKey(T t);

    T selectByPrimaryKey(Integer id);
}
