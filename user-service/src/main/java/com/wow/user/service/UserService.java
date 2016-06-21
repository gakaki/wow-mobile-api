package com.wow.user.service;

import com.wow.user.model.*;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/16.
 */
public interface UserService {
    //Table: end_user

    /**
     * 用户注册
     *
     * @param endUser
     * @return
     */
    int register(EndUser endUser);

    /**
     * 用户信息更新
     *
     * @param endUser
     * @return
     */
    int updateEndUser(EndUser endUser);

    /**
     * 用户修改密码
     *
     * @param endUserId
     * @param oldPwd
     * @param newPwd
     * @return
     */
    int modifyPassword(int endUserId, String oldPwd, String newPwd);

    /**
     * 根据Id获取用户信息
     *
     * @param endUserId
     * @return
     */
    EndUser getEndUserById(int endUserId);

    /**
     * 批量查询多个用户
     *
     * @param endUserIds
     * @return
     */
    List<EndUser> getEndUsersByIds(int[] endUserIds);

    /**
     * 验证用户名、密码是否匹配
     *
     * @param userName
     * @param password
     * @return
     */
    boolean authenticate(String userName, String password);

    //table: end_user_follow_brand

    /**
     * 用户关注品牌
     *
     * @param endUserFollowBrand
     * @return
     */
    int followBrand(EndUserFollowBrand endUserFollowBrand);

    /**
     * 用户取消关注品牌
     *
     * @param endUserFollowBrand
     * @return
     */
    int cancelFollowBrand(EndUserFollowBrand endUserFollowBrand);

    //table: end_user_follow_designer

    /**
     * 用户关注设计师
     *
     * @param endUserFollowDesigner
     * @return
     */
    int followDesigner(EndUserFollowDesigner endUserFollowDesigner);

    /**
     * 用户取消关注设计师
     *
     * @param endUserFollowDesigner
     * @return
     */
    int cancelFollowDesigner(EndUserFollowDesigner endUserFollowDesigner);

    //table: end_user_follow_product

    /**
     * 用户关注产品
     *
     * @param endUserFollowProduct
     * @return
     */
    int followProduct(EndUserFollowProduct endUserFollowProduct);

    /**
     * 用户取消关注产品
     *
     * @param endUserFollowProduct
     * @return
     */
    int cancelFollowProduct(EndUserFollowProduct endUserFollowProduct);

    //table: end_user_follow_scene

    /**
     * 用户关注场景
     *
     * @param endUserFollowScene
     * @return
     */
    int followScene(EndUserFollowScene endUserFollowScene);

    /**
     * 用户取消关注场景
     *
     * @param endUserFollowScene
     * @return
     */
    int cancelFollowScene(EndUserFollowScene endUserFollowScene);


    //table: end_user_share_brand

    /**
     * 用户分享品牌
     *
     * @param endUserShareBrand
     * @return
     */
    int shareBrand(EndUserShareBrand endUserShareBrand);
    //table: end_user_share_designer

    /**
     * 用户分享设计师
     *
     * @param endUserShareDesigner
     * @return
     */
    int shareDesigner(EndUserShareDesigner endUserShareDesigner);
    //table: end_user_share_product

    /**
     * 用户分享设计师
     *
     * @param endUserShareProduct
     * @return
     */
    int shareProduct(EndUserShareProduct endUserShareProduct);

    //table: end_user_share_scene
    //用户分享场景
    int shareScene(EndUserShareScene endUserShareScene);

    //table: shipping_info

    /**
     * 创建收货地址
     *
     * @param shippingInfo
     * @return
     */
    int addShippingInfo(ShippingInfo shippingInfo);

    /**
     * 修改或删除收货地址,包括指定默认收货地址
     *
     * @param shippingInfo
     * @return
     */
    int updateShippingInfo(ShippingInfo shippingInfo);

    //table: shopping_cart

    /**
     * 添加商品到购物车
     *
     * @param shoppingCart
     * @return
     */
    int addProductIntoCart(ShoppingCart shoppingCart);

    /**
     * 调整购物车里的产品数量
     */
    int updateProductNumInCart(ShoppingCart shoppingCart);

    /**
     * 删除购物车里某种产品
     *
     * @param shoppingCart
     * @return
     */
    int deleteProductInCart(ShoppingCart shoppingCart);
}
