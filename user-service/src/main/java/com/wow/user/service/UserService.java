package com.wow.user.service;

import com.wow.common.response.CommonResponse;
import com.wow.user.model.EndUser;
import com.wow.user.model.EndUserWechat;
import com.wow.user.vo.response.RegisterResponse;
import com.wow.user.vo.response.UserCheckResponse;
import com.wow.user.vo.response.UserResponse;
import com.wow.user.vo.response.WechatBindStatusResponse;

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

//    /**
//     * 根据用户名判断是否已注册用户
//     * @param userName
//     * @return
//     */
//    UserCheckResponse isExistedUserByUserName(String userName);

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
     * @param openId
     * @return
     */
    WechatBindStatusResponse checkIfWechatIdBindToUserId(String openId);

    /**
     * 用户信息更新
     *
     * @param endUser
     * @return
     */
    CommonResponse updateEndUser(EndUser endUser);

    /**
     * 用户重置密码
     * @param mobile
     * @param captcha
     * @param newPwd
     * @return
     */
    CommonResponse resetPassword(String mobile, String captcha, String newPwd);

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

}
