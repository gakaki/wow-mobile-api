package com.wow.user.service;

import com.wow.user.model.*;
import com.wow.user.vo.response.RegisterResponse;
import com.wow.user.vo.response.*;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/16.
 */
public interface UserService {

    /**
     * 用户注册
     * @param endUser
     * @param captcha
     * @return
     */
    RegisterResponse register(EndUser endUser, String captcha);

    /**
     * 根据用户名判断是否已注册用户
     * @param userName
     * @return
     */
    UserCheckResponse isExistedUserByUserName(String userName);

    /**
     * 根据昵称判断是否已注册用户
     * @param nickName
     * @return
     */
    UserCheckResponse isExistedUserByNickName(String nickName);
    /**
     * 根据手机号判断是否已注册用户
     * @param mobile
     * @return
     */
    UserCheckResponse isExistedUserByMobile(String mobile);

    /**
     * 检查手机号的注册和绑定微信状态
     * @param mobile
     * @return
     */
    WechatBindStatusResponse checkWechatBindStatus(String mobile);

    /**
     * 绑定微信
     * @param endUserWechat
     * @return
     */
    WechatBindStatusResponse bindWechatToUser(EndUserWechat endUserWechat);

    /**
     * 检查微信号是否已经绑定到一个已注册用户
     * @param wechatId
     * @return
     */
    WechatBindStatusResponse checkIfWechatIdBindToUserId(String wechatId);

    /**
     * 用户信息更新
     *
     * @param endUser
     * @return
     */
    UserUpdateResponse updateEndUser(EndUser endUser);

    /**
     * 获取验证码
     * @param mobile
     * @return 验证码
     */
    CaptchaResponse sendCaptcha(String mobile);

    /**
     * 用户重置密码
     * @param mobile
     * @param captcha
     * @param newPwd
     * @return
     */
    ResetPwdResponse resetPassword(String mobile, String captcha, String newPwd);

    /**
     * 根据Id获取用户信息
     *
     * @param endUserId
     * @return
     */
    UserResponse getEndUserById(int endUserId);

    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    UserResponse getEndUserByUserName(String userName);

    /**
     * 根据手机号获取用户信息
     *
     * @param mobile
     * @return
     */
    UserResponse getEndUserByMobile(String mobile);

    /**
     * 根据昵称获取用户信息
     *
     * @param nickName
     * @return
     */
    UserResponse getEndUserByNickName(String nickName);

    /**
     * 批量查询多个用户
     *
     * @param endUserIds
     * @return
     */
    List<EndUser> getEndUsersByIds(int[] endUserIds);

    /**
     * 验证手机号(也是用户名)、密码是否匹配
     *
     * @param mobile
     * @param password
     * @return
     */
    UserResponse authenticate(String mobile, String password);

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
