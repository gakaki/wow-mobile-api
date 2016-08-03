package com.wow.user.service;

/**
 * 用户关注服务
 * Created by zhengzhiqing on 16/6/30.
 */
public interface FollowService {
    /**
     * 用户关注品牌
     * @param endUserId
     * @param brandId
     * @return
     */
    int followBrand(int endUserId, int brandId);

    /**
     * 用户取消关注品牌
     * @param endUserId
     * @param brandId
     * @return
     */
    int cancelFollowBrand(int endUserId, int brandId);

    /**
     * 用户关注设计师
     * @param endUserId
     * @param designerId
     * @return
     */
    int followDesigner(int endUserId, int designerId);

    /**
     * 用户取消关注设计师
     * @param endUserId
     * @param designerId
     * @return
     */
    int cancelFollowDesigner(int endUserId, int designerId);

    /**
     * 用户关注产品
     * @param endUserId
     * @param productId
     * @return
     */
    int followProduct(int endUserId, int productId);

    /**
     * 用户取消关注产品
     * @param endUserId
     * @param productId
     * @return
     */
    int cancelFollowProduct(int endUserId, int productId);

    /**
     * 用户关注场景
     * @param endUserId
     * @param sceneId
     * @return
     */
    int followScene(int endUserId, int sceneId);

    /**
     * 用户取消关注场景
     * @param endUserId
     * @param sceneId
     * @return
     */
    int cancelFollowScene(int endUserId, int sceneId);

}
