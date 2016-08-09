package com.wow.product.service;

import com.wow.product.model.ApplicableScene;
import com.wow.product.model.ProductApplicableScene;

import java.util.List;

/**
 * 适用场景服务
 *
 * Created by zhengzhiqing on 16/6/24.
 */
public interface ApplicableSceneService {

    //table: applicable_scene

    /**
     * 创建适用场景
     * @param applicableScene
     * @return
     */
    int createApplicableScene(ApplicableScene applicableScene);

    /**
     * 更新适用场景
     * @param applicableScene
     * @return
     */
    int updateApplicableScene(ApplicableScene applicableScene);

    /**
     * 删除适用场景
     * @param applicableScene
     * @return
     */
    int deleteApplicableScene(ApplicableScene applicableScene);

    /**
     * 根据ID查找适用场景
     * @param applicableSceneId
     * @return
     */
    ApplicableScene getApplicableSceneById(int applicableSceneId);

    /**
     * 根据名称查找适用场景
     * @param applicableSceneName
     * @return
     */
    ApplicableScene getApplicableSceneByName(String applicableSceneName) throws Exception;

    /**
     * 查找所有适用场景
     * @return
     */
    List<ApplicableScene> getAllApplicableScene();

    /**
     *
     * @param productId
     * @return
     */
    List<ApplicableScene> getApplicableSceneInProduct(int productId);

    /**
     * 产品适用场景
     *
     * @param applicableScenes
     * @return
     */
    int createProductApplicableScene(List<ProductApplicableScene> applicableScenes);

    /**
     * 批量更新产品的属性值
     * @param applicableScenes
     * @return
     */
    int updateProductApplicableScene(List<ProductApplicableScene> applicableScenes);

    /**
     * 替换产品的应用场景
     * @param productId
     * @param applicableScenes
     * @return
     */
    int replaceProductApplicableScene(Integer productId, List<ProductApplicableScene> applicableScenes);
}
