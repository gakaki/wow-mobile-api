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
     * 是否已注册用户
     * @param userName
     * @return
     */
    boolean isExistedUser(String userName);

    /**
     * 用户信息更新
     *
     * @param endUser
     * @return
     */
    int updateEndUser(EndUser endUser);

    /**
     * 获取验证码
     * @param mobile
     * @return 验证码
     */
    String getCaptcha(String mobile);

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
     * 用户重置密码
     * @param mobile
     * @param captcha
     * @param newPwd
     * @return
     */
    boolean resetPassword(String mobile, String captcha, String newPwd);

    /**
     * 根据Id获取用户信息
     *
     * @param endUserId
     * @return
     */
    EndUser getEndUserById(int endUserId);

    /**
     * 根据手机号获取用户信息
     *
     * @param mobile
     * @return
     */
    EndUser getEndUserByMobile(String mobile);

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
    EndUser authenticate(String userName, String password);

    /**
     * 删除用户
     * @param endUserId
     * @return
     */
    int deleteUser(int endUserId);

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
}
