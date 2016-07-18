package com.wow.user.service;

import com.wow.common.response.CommonResponse;
import com.wow.user.model.EndUser;
import com.wow.user.model.EndUserWechat;
import com.wow.user.vo.response.RegisterBindStatusResponse;
import com.wow.user.vo.response.RegisterResponse;
import com.wow.user.vo.response.UserCheckResponse;
import com.wow.user.vo.response.UserResponse;

/**
 * Created by zhengzhiqing on 16/6/16.
 */
public interface UserService {

    /**
     * 用户注册
     * @param endUser
     * @return 需要返回注册完成之后的end_user_id
     */
    RegisterResponse register(EndUser endUser);

    /**
     * 根据昵称判断是否已注册用户
     * @param nickName
     * @return 是否已经存在的用户
     */
    UserCheckResponse isExistedUserByNickName(String nickName);

    /**
     * 根据手机号判断是否已注册用户
     * @param mobile
     * @return 是否已经存在的用户
     */
    UserCheckResponse isExistedUserByMobile(String mobile);

    /**
     * 检查手机号的注册和绑定微信状态
     * @param mobile
     * @return 是否已注册和已绑定
     */
    RegisterBindStatusResponse getRegisterBindStatus(String mobile);

    /**
     * 绑定微信
     * @param endUserWechat
     * @return
     */
    CommonResponse bindWechat(EndUserWechat endUserWechat);

    /**
     * 根据微信号查找注册用户
     * @param openId
     * @return
     */
    UserResponse getUserByOpenId(String openId);

    /**
     * 用户信息更新
     *
     * @param endUser
     * @return
     */
    CommonResponse updateUser(EndUser endUser);

    /**
     * 用户重置密码
     * @param mobile
     * @param newPwd
     * @return
     */
    CommonResponse resetPassword(String mobile, String newPwd);

    /**
     * 根据Id获取用户信息
     *
     * @param endUserId
     * @return
     */
    UserResponse getUserById(int endUserId);

    /**
     * 根据手机号获取用户信息
     *
     * @param mobile
     * @return
     */
    UserResponse getUserByMobile(String mobile);

    /**
     * 根据昵称获取用户信息
     *
     * @param nickName
     * @return
     */
    UserResponse getUserByNickName(String nickName);

    /**
     * 验证手机号、密码是否匹配
     *
     * @param mobile
     * @param password
     * @return
     */
    UserResponse authenticate(String mobile, String password);

}
