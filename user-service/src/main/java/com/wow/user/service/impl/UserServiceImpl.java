package com.wow.user.service.impl;

import com.wow.user.mapper.EndUserMapper;
import com.wow.user.model.EndUser;
import com.wow.user.model.EndUserFollowBrand;
import com.wow.user.model.EndUserFollowDesigner;
import com.wow.user.model.EndUserFollowProduct;
import com.wow.user.model.EndUserFollowScene;
import com.wow.user.model.EndUserShareBrand;
import com.wow.user.model.EndUserShareDesigner;
import com.wow.user.model.EndUserShareProduct;
import com.wow.user.model.EndUserShareScene;
import com.wow.user.model.ShippingInfo;
import com.wow.user.model.ShoppingCart;
import com.wow.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/21.
 */
@Service
@Transactional(value = "userTransactionManager")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private EndUserMapper endUserMapper;

    //Table: end_user

    /**
     * 用户注册
     *
     * @param endUser
     * @return
     */
    public int register(EndUser endUser) {
        return endUserMapper.insert(endUser);
    }

    /**
     * 是否已注册用户
     *
     * @param userName
     * @return
     */
    @Override
    public boolean isExistedUser(String userName) {
        EndUser user = endUserMapper.selectByUserName(userName);
        logger.info("user=" + user);
        return (user != null);
    }

    /**
     * 用户信息更新
     *
     * @param endUser
     * @return
     */
    public int updateEndUser(EndUser endUser) {
        return 1;
    }

    /**
     * 用户修改密码
     *
     * @param endUserId
     * @param oldPwd
     * @param newPwd
     * @return
     */
    public int modifyPassword(int endUserId, String oldPwd, String newPwd) {
        return 1;
    }

    /**
     * 根据Id获取用户信息
     *
     * @param endUserId
     * @return
     */
    public EndUser getEndUserById(int endUserId) {
        logger.info("get end user with id:" + endUserId);
        return endUserMapper.selectByPrimaryKey(endUserId);
    }

    /**
     * 批量查询多个用户
     *
     * @param endUserIds
     * @return
     */
    public List<EndUser> getEndUsersByIds(int[] endUserIds) {
        return null;
    }

    /**
     * 验证用户名、密码是否匹配
     *
     * @param userName
     * @param password
     * @return
     */
    public EndUser authenticate(String userName, String password) {
        return endUserMapper.selectByUserNamePassword(userName,password);
    }

    /**
     * 删除用户
     *
     * @param endUserId
     * @return
     */
    public int deleteUser(int endUserId) {
        return endUserMapper.deleteByPrimaryKey(endUserId);
    }

    //table: end_user_follow_brand

    /**
     * 用户关注品牌
     *
     * @param endUserFollowBrand
     * @return
     */
    public int followBrand(EndUserFollowBrand endUserFollowBrand) {
        return 0;
    }

    /**
     * 用户取消关注品牌
     *
     * @param endUserFollowBrand
     * @return
     */
    public int cancelFollowBrand(EndUserFollowBrand endUserFollowBrand) {
        return 0;
    }

    //table: end_user_follow_designer

    /**
     * 用户关注设计师
     *
     * @param endUserFollowDesigner
     * @return
     */
    public int followDesigner(EndUserFollowDesigner endUserFollowDesigner) {
        return 0;
    }

    /**
     * 用户取消关注设计师
     *
     * @param endUserFollowDesigner
     * @return
     */
    public int cancelFollowDesigner(EndUserFollowDesigner endUserFollowDesigner) {
        return 0;
    }

    //table: end_user_follow_product

    /**
     * 用户关注产品
     *
     * @param endUserFollowProduct
     * @return
     */
    public int followProduct(EndUserFollowProduct endUserFollowProduct) {
        return 0;
    }

    /**
     * 用户取消关注产品
     *
     * @param endUserFollowProduct
     * @return
     */
    public int cancelFollowProduct(EndUserFollowProduct endUserFollowProduct) {
        return 0;
    }

    //table: end_user_follow_scene

    /**
     * 用户关注场景
     *
     * @param endUserFollowScene
     * @return
     */
    public int followScene(EndUserFollowScene endUserFollowScene) {
        return 0;
    }

    /**
     * 用户取消关注场景
     *
     * @param endUserFollowScene
     * @return
     */
    public int cancelFollowScene(EndUserFollowScene endUserFollowScene) {
        return 0;
    }


    //table: end_user_share_brand

    /**
     * 用户分享品牌
     *
     * @param endUserShareBrand
     * @return
     */
    public int shareBrand(EndUserShareBrand endUserShareBrand) {
        return 0;
    }
    //table: end_user_share_designer

    /**
     * 用户分享设计师
     *
     * @param endUserShareDesigner
     * @return
     */
    public int shareDesigner(EndUserShareDesigner endUserShareDesigner) {
        return 0;
    }
    //table: end_user_share_product

    /**
     * 用户分享设计师
     *
     * @param endUserShareProduct
     * @return
     */
    public int shareProduct(EndUserShareProduct endUserShareProduct) {
        return 0;
    }

    //table: end_user_share_scene
    //用户分享场景
    public int shareScene(EndUserShareScene endUserShareScene) {
        return 0;
    }

    //table: shipping_info

    /**
     * 创建收货地址
     *
     * @param shippingInfo
     * @return
     */
    public int addShippingInfo(ShippingInfo shippingInfo) {
        return 0;
    }

    /**
     * 修改或删除收货地址,包括指定默认收货地址
     *
     * @param shippingInfo
     * @return
     */
    public int updateShippingInfo(ShippingInfo shippingInfo) {
        return 0;
    }

    //table: shopping_cart

    /**
     * 添加商品到购物车
     *
     * @param shoppingCart
     * @return
     */
    public int addProductIntoCart(ShoppingCart shoppingCart) {
        return 0;
    }

    /**
     * 调整购物车里的产品数量
     */
    public int updateProductNumInCart(ShoppingCart shoppingCart) {
        return 0;
    }

    /**
     * 删除购物车里某种产品
     *
     * @param shoppingCart
     * @return
     */
    public int deleteProductInCart(ShoppingCart shoppingCart) {
        return 0;
    }
}
