package com.wow.product.service;

import com.wow.product.model.Scene;
import com.wow.product.model.SceneDisplayRule;

import java.util.List;

/**
 * 场景服务
 * Created by zhengzhiqing on 16/6/17.
 */
public interface SceneService {
    /**
     * 创建场景
     *
     * @param scene
     * @return
     */
    int createScene(Scene scene);

    /**
     * 更新场景
     *
     * @param scene
     * @return
     */
    int updateScene(Scene scene);

    /**
     * 删除场景
     *
     * @param scene
     * @return
     */
    int deleteScene(Scene scene);

    /**
     * 绑定组合产品到一个场景(场景本质上就是一个组合产品)
     *
     * @param scene
     * @return
     */
    int bindProductCombineIntoScene(Scene scene,int productId);

    /**
     * 查询所有场景
     * @return
     */
    List<Scene> getScenes();

    /**
     * 查询组合产品是否绑定到一个场景
     * @param productId 组合产品ID
     * @return
     */
    boolean isProductCombineBindScene(int productId);

}
