package com.wow.user.service;

import com.wow.user.vo.response.*;

/**
 * 用户喜欢服务
 * Created by zhengzhiqing on 16/6/30.
 */
public interface FavoriteService {
    /**
     * 用户喜欢品牌
     * @param endUserId
     * @param brandId
     * @return
     */
    FavoriteCommonResponse updateFavoriteBrand(Integer endUserId, Integer brandId);


    /**
     * 查询用户喜欢的品牌
     * @param endUserId
     * @return
     */
    FavoriteBrandResponse getFavoriteBrand(Integer endUserId);

    /**
     * 查询用户是否喜欢一个品牌
     * @param endUserId
     * @return
     */
    FavoriteCommonResponse isUserFavoriteBrand(Integer endUserId, Integer brandId);

    /**
     * 用户喜欢设计师
     * @param endUserId
     * @param designerId
     * @return
     */
    FavoriteCommonResponse updateFavoriteDesigner(Integer endUserId, Integer designerId);

    /**
     * 查询用户喜欢的设计师
     * @param endUserId
     * @return
     */
    FavoriteDesignerResponse getFavoriteDesigner(Integer endUserId);

    /**
     * 查询用户是否喜欢一个设计师
     * @param endUserId
     * @param designerId
     * @return
     */
    FavoriteCommonResponse isUserFavoriteDesigner(Integer endUserId, Integer designerId);

    /**
     * 用户喜欢产品
     * @param endUserId
     * @param productId
     * @return
     */
    FavoriteCommonResponse updateFavoriteProduct(Integer endUserId, Integer productId);

    /**
     * 查询用户喜欢的产品
     * @param endUserId
     * @return
     */
    FavoriteProductResponse getFavoriteProduct(Integer endUserId);

    /**
     * 查询用户是否喜欢一个产品
     * @param endUserId
     * @param productId
     * @return
     */
    FavoriteCommonResponse isUserFavoriteProduct(Integer endUserId, Integer productId);

//    /**
//     * 用户喜欢场景
//     * @param endUserId
//     * @param sceneId
//     * @return
//     */
//    FavoriteCommonResponse updateFavoriteScene(Integer endUserId, Integer sceneId);
//
//    /**
//     * 查询用户喜欢的场景
//     * @param endUserId
//     * @return
//     */
//    FavoriteSceneResponse getFavoriteScene(Integer endUserId);
//
//    /**
//     * 查询用户是否喜欢一个场景
//     * @param endUserId
//     * @param sceneId
//     * @return
//     */
//    FavoriteCommonResponse isUserFavoriteScene(Integer endUserId, Integer sceneId);

}
