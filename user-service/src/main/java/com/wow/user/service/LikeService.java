package com.wow.user.service;

import com.wow.common.response.CommonResponse;
import com.wow.user.vo.response.FavoriteBrandResponse;
import com.wow.user.vo.response.FavoriteDesignerResponse;
import com.wow.user.vo.response.FavoriteProductResponse;
import com.wow.user.vo.response.FavoriteSceneResponse;

/**
 * 用户喜欢服务
 * Created by zhengzhiqing on 16/6/30.
 */
public interface LikeService {
    /**
     * 用户喜欢品牌
     * @param endUserId
     * @param brandId
     * @return
     */
    CommonResponse likeBrand(Integer endUserId, Integer brandId);

    /**
     * 删除喜欢的品牌
     * @param id
     * @return
     */
    CommonResponse deleteLikedBrand(Integer id);

    /**
     * 查询用户喜欢的品牌
     * @param endUserId
     * @return
     */
    FavoriteBrandResponse getLikedBrand(Integer endUserId);

    /**
     * 用户喜欢设计师
     * @param endUserId
     * @param designerId
     * @return
     */
    CommonResponse likeDesigner(Integer endUserId, Integer designerId);

    /**
     * 删除喜欢的设计师
     * @param id
     * @return
     */
    CommonResponse deleteLikedDesigner(Integer id);

    /**
     * 查询用户喜欢的设计师
     * @param endUserId
     * @return
     */
    FavoriteDesignerResponse getLikedDesigner(Integer endUserId);

    /**
     * 用户喜欢产品
     * @param endUserId
     * @param productId
     * @return
     */
    CommonResponse likeProduct(Integer endUserId, Integer productId);

    /**
     * 删除喜欢的产品
     * @param id
     * @return
     */
    CommonResponse deleteLikedProduct(Integer id);

    /**
     * 查询用户喜欢的产品
     * @param endUserId
     * @return
     */
    FavoriteProductResponse getLikedProduct(Integer endUserId);

    /**
     * 用户喜欢场景
     * @param endUserId
     * @param sceneId
     * @return
     */
    CommonResponse likeScene(Integer endUserId, Integer sceneId);

    /**
     * 删除喜欢的场景
     * @param id
     * @return
     */
    CommonResponse deleteLikedScene(Integer id);

    /**
     * 查询用户喜欢的场景
     * @param endUserId
     * @return
     */
    FavoriteSceneResponse getLikedScene(Integer endUserId);

}
