package com.wow.product.service;

import com.wow.product.model.Style;

import java.util.List;

/**
 * 风格服务
 *
 * Created by zhengzhiqing on 16/6/24.
 */
public interface StyleService {
    //table: style

    /**
     * 创建风格
     * @param style
     * @return
     */
    int createStyle(Style style);

    /**
     * 修改风格
     * @param style
     * @return
     */
    int updateStyle(Style style);

    /**
     * 删除风格
     * @param style
     * @return
     */
    int deleteStyle(Style style);

    /**
     * 根据ID查找风格
     * @param styleId
     * @return
     */
    Style getStyleById(Integer styleId);

    /**
     * 根据名称查找风格
     * @param styleName
     * @return
     */
    Style getStyleByName(String styleName) throws Exception ;

    /**
     * 查看所有风格
     * @return
     */
    List<Style> getAllStyles();
}
