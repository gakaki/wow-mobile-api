package com.wow.user.service;

import com.wow.common.response.CommonResponse;
import com.wow.product.model.Brand;
import com.wow.product.model.Designer;
import com.wow.product.model.Product;
import com.wow.product.model.Scene;
import com.wow.user.vo.response.LikedBrandResponse;
import com.wow.user.vo.response.LikedDesignerResponse;
import com.wow.user.vo.response.LikedProductResponse;
import com.wow.user.vo.response.LikedSceneResponse;

import java.util.List;

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
    CommonResponse likeBrand(int endUserId, int brandId);

    /**
     * 删除喜欢的品牌
     * @param id
     * @return
     */
    CommonResponse deleteLikedBrand(int id);

    /**
     * 查询用户喜欢的品牌
     * @param endUserId
     * @return
     */
    LikedBrandResponse getLikedBrand(int endUserId);

    /**
     * 用户喜欢设计师
     * @param endUserId
     * @param designerId
     * @return
     */
    CommonResponse likeDesigner(int endUserId, int designerId);

    /**
     * 删除喜欢的设计师
     * @param id
     * @return
     */
    CommonResponse deleteLikedDesigner(int id);

    /**
     * 查询用户喜欢的设计师
     * @param endUserId
     * @return
     */
    LikedDesignerResponse getLikedDesigner(int endUserId);

    /**
     * 用户喜欢产品
     * @param endUserId
     * @param productId
     * @return
     */
    CommonResponse likeProduct(int endUserId, int productId);

    /**
     * 删除喜欢的产品
     * @param id
     * @return
     */
    CommonResponse deleteLikedProduct(int id);

    /**
     * 查询用户喜欢的产品
     * @param endUserId
     * @return
     */
    LikedProductResponse getLikedProduct(int endUserId);

    /**
     * 用户喜欢场景
     * @param endUserId
     * @param sceneId
     * @return
     */
    CommonResponse likeScene(int endUserId, int sceneId);

    /**
     * 删除喜欢的场景
     * @param id
     * @return
     */
    CommonResponse deleteLikedScene(int id);

    /**
     * 查询用户喜欢的场景
     * @param endUserId
     * @return
     */
    LikedSceneResponse getLikedScene(int endUserId);

}
