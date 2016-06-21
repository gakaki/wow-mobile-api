package com.wow.product.service;

import com.wow.product.model.Scene;
import com.wow.product.model.SceneDisplayRule;

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
     * 绑定组合产品到一个场景(场景本质上就是一个组合产品)
     *
     * @param scene
     * @return
     */
    int bindProductCombineIntoScene(Scene scene);

    /**
     * 在特定页面上显示场景的规则,包括显示哪些场景,排序是什么
     *
     * @param sceneDisplayRule
     * @return
     */
    int createSceneDisplayRule(SceneDisplayRule sceneDisplayRule);

    /**
     * 更新特定页面上显示场景的规则,包括显示哪些场景,排序是什么
     *
     * @param sceneDisplayRule
     * @return
     */
    int updateSceneDisplayRule(SceneDisplayRule sceneDisplayRule);
}
