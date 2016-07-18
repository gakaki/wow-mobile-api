package com.wow.user.service.impl;

import com.wow.common.response.CommonResponse;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.ErrorResponseUtil;
import com.wow.common.util.StringUtil;
import com.wow.user.mapper.EndUserMapper;
import com.wow.user.mapper.EndUserWechatMapper;
import com.wow.user.model.EndUser;
import com.wow.user.model.EndUserExample;
import com.wow.user.model.EndUserWechat;
import com.wow.user.model.EndUserWechatExample;
import com.wow.user.service.SessionService;
import com.wow.user.service.UserService;
import com.wow.user.util.PasswordUtil;
import com.wow.user.vo.WechatBindStatusVo;
import com.wow.user.vo.response.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/21.
 */
@Service
@Transactional("userTransactionManager")
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private EndUserMapper endUserMapper;

    @Autowired
    private EndUserWechatMapper endUserWechatMapper;

    @Autowired
    private SessionService sessionService;

    /**
     * 用户注册
     * @param endUser
     * @return
     */
    @Override
    public RegisterResponse register(EndUser endUser) {
        RegisterResponse registerResponse = new RegisterResponse();
        String mobile = endUser.getMobile();

        if (StringUtils.isEmpty(mobile)) {
            registerResponse.setResCode("40000");
            registerResponse.setResMsg("手机号不能为空");
            return registerResponse;
        }

        //判断该手机号是否已经注册
        if (isExistedUserByMobile(mobile).isExistedUser()) {
            ErrorResponseUtil.setErrorResponse(registerResponse,"40106");
            return registerResponse;
        }

        endUser.setPassword(
                PasswordUtil.passwordHashGenerate(endUser.getPassword()));
        endUserMapper.insertSelective(endUser);
        //TODO: 如果该用户是通过好友推荐进来注册的,需要更新推荐相关信息,通过消息通知营销系统,否则要双向依赖

        //注册成功,需要将用户ID返回
        registerResponse.setEndUserId(endUser.getId());
        return registerResponse;
    }

//    /**
//     * 用户注册并绑定微信
//     *
//     * @param endUser
//     * @param endUserWechat
//     * @param captcha
//     * @return
//     */
//    @Override
//    public RegisterAndBindResponse registerAndBindWechat(EndUser endUser, EndUserWechat endUserWechat, String captcha) {
//        RegisterAndBindResponse registerAndBindResponse = new RegisterAndBindResponse();
//        RegisterResponse registerResponse = register(endUser,captcha);
//        if (registerResponse == null || !"0".equals(registerResponse.getResCode())) {
//            ErrorResponseUtil.setErrorResponse(registerAndBindResponse,registerResponse.getResCode());
//            return registerAndBindResponse;
//        } else {
//            int endUserId = registerResponse.getEndUserId();
//            endUserWechat.setMobile(endUser.getMobile());
//            endUserWechat.setEndUserId(endUserId);
//            WechatBindStatusResponse wechatBindStatusResponse = bindWechatToUser(endUserWechat);
//            if (wechatBindStatusResponse != null && wechatBindStatusResponse.getWechatBindStatusVo() != null) {
//                boolean isBinded = wechatBindStatusResponse.getWechatBindStatusVo().isBinded();
//                if (!isBinded) {
//                    ErrorResponseUtil.setErrorResponse(registerAndBindResponse,"50109");
//                    return registerAndBindResponse;
//                }
//            } else {
//                ErrorResponseUtil.setErrorResponse(registerAndBindResponse,"50109");
//                return registerAndBindResponse;
//            }
//            registerAndBindResponse.setEndUserId(endUserId);
//            registerAndBindResponse.setRegistered(true);
//            registerAndBindResponse.setBinded(true);
//            return registerAndBindResponse;
//        }
//    }

//    /**
//     * 根据用户名判断是否已注册用户
//     *
//     * @param userName
//     * @return
//     */
//    @Override
//    @Transactional(propagation= Propagation.NOT_SUPPORTED)
//    public UserCheckResponse isExistedUserByUserName(String userName) {
//        UserCheckResponse userCheckResponse = new UserCheckResponse();
//        EndUser user = getEndUserByUserName(userName).getEndUser();
//        userCheckResponse.setExistedUser(user != null);
//        return userCheckResponse;
//    }

    /**
     * 根据昵称判断是否已注册用户
     *
     * @param nickName
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public UserCheckResponse isExistedUserByNickName(String nickName) {
        UserCheckResponse userCheckResponse = new UserCheckResponse();
        EndUser user = getUserByNickName(nickName).getEndUser();
        userCheckResponse.setExistedUser(user!= null);
        return userCheckResponse;
    }

    /**
     * 根据手机号判断是否已注册用户
     *
     * @param mobile
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public UserCheckResponse isExistedUserByMobile(String mobile) {
        UserCheckResponse userCheckResponse = new UserCheckResponse();
        UserResponse userResponse = getUserByMobile(mobile);
        EndUser endUser = userResponse.getEndUser();
        if (endUser !=null && endUser.getId() !=null) {
            userCheckResponse.setExistedUser(true);
        } else {
            userCheckResponse.setExistedUser(false);
        }
        return userCheckResponse;
    }

    /**
     * 检查手机号的注册和绑定微信状态
     *
     * @param mobile
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public RegisterBindStatusResponse getRegisterBindStatus(String mobile) {
        logger.info("start to check if mobile registered and bind to wechat...");

        RegisterBindStatusResponse registerBindStatusResponse = new RegisterBindStatusResponse();

        UserCheckResponse userCheckResponse = isExistedUserByMobile(mobile);

        if (userCheckResponse != null && userCheckResponse.isExistedUser()) {
            registerBindStatusResponse.setRegistered(true);

            EndUserWechatExample endUserWechatExample = new EndUserWechatExample();
            EndUserWechatExample.Criteria criteria = endUserWechatExample.createCriteria();
            criteria.andMobileEqualTo(mobile);
            criteria.andIsBindEqualTo(true);
            List<EndUserWechat> list = endUserWechatMapper.selectByExample(endUserWechatExample);
            if (CollectionUtil.isNotEmpty(list)) {
                EndUserWechat endUserWechat = list.get(0);
                registerBindStatusResponse.setBinded(true);
            } else {
                registerBindStatusResponse.setBinded(false);
            }
        } else {
            registerBindStatusResponse.setRegistered(false);
        }
        logger.info("mobile-" + mobile + ", [registered:" + registerBindStatusResponse.isRegistered() + ", binded:" + registerBindStatusResponse.isBinded() + "]");
        return registerBindStatusResponse;
    }

    /**
     * 已有用户绑定微信
     *
     * @param endUserWechat
     * @return
     */
    @Override
    public CommonResponse bindWechat(EndUserWechat endUserWechat) {
        CommonResponse response = new CommonResponse();
        String mobile = endUserWechat.getMobile();
        Integer endUserId = endUserWechat.getEndUserId();
        String openId = endUserWechat.getOpenId();

        if (endUserId == null || StringUtil.isEmpty(openId)) {
            response.setResCode("40000");
            response.setResMsg("用户ID和openId不能为空");
            return response;
        }

        RegisterBindStatusResponse registerBindStatusResponse = getRegisterBindStatus(mobile);

        boolean isRegistered = registerBindStatusResponse.isRegistered();
        boolean isBinded = registerBindStatusResponse.isBinded();

        if (isBinded) {
            ErrorResponseUtil.setErrorResponse(response, "50107");
            return response;
        }

        if (!isRegistered) {
            ErrorResponseUtil.setErrorResponse(response, "40105");
            return response;
        }

        endUserWechat.setIsBind(true);
        endUserWechat.setBindTime(new Date());
        endUserWechatMapper.insertSelective(endUserWechat);

        return response;
    }

    /**
     * 判断微信号是否已经绑定了一个账号
     *
     * @param openId
     * @return
     */
    @Override
    public UserResponse getUserByOpenId(String openId) {
        UserResponse userResponse = new UserResponse();
        logger.info("start to get user by openId:" + openId);
        EndUser endUser = endUserMapper.selectByOpenId(openId);
        logger.info("endUser=" + endUser);
        if (endUser != null) {
            userResponse.setEndUser(endUser);
        }
        logger.info("getUserByOpenId:" + userResponse.getEndUser());
        return userResponse;
    }

    /**
     * 用户信息更新
     *
     * @param endUser
     * @return
     */
    @Override
    @CacheEvict(value = "UserCache",key="'USER_ID_'+#endUserId")
    public CommonResponse updateUser(EndUser endUser) {
        CommonResponse commonResponse = new CommonResponse();
        if (endUser == null || endUser.getId() == null) {
            commonResponse.setResCode("40000");
            commonResponse.setResMsg("更新用户必须提供用户ID");
            return commonResponse;
        }
        endUserMapper.updateByPrimaryKeySelective(endUser);
        return commonResponse;
    }

    /**
     * 用户忘记密码/重置密码 - 需要手机验证(以后可支持邮件验证?)
     *
     * @param mobile
     * @param newPwd
     * @return
     */
    @Override
    @CacheEvict(value = "UserCache", key="'USER_MOBILE_'+#mobile")
    public CommonResponse resetPassword(String mobile, String newPwd) {
        CommonResponse commonResponse = new CommonResponse();
        UserResponse userResponse = getUserByMobile(mobile);
        EndUser endUser = userResponse.getEndUser();
        if(endUser== null) {
            commonResponse.setResCode("40105");
            commonResponse.setResCode(ErrorCodeUtil.getErrorMsg("40105"));
            return commonResponse;
        }

        endUser.setPassword(PasswordUtil.passwordHashGenerate(newPwd));
        endUser.setUpdateTime(new Date());
        endUserMapper.updateByPrimaryKeySelective(endUser);
        //需要设置当前有效的session token失效(所有登录渠道)
        sessionService.invalidateSessionToken(endUser.getId());

        return commonResponse;
    }

    /**
     * 根据Id获取用户信息
     *
     * @param endUserId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
//    @Cacheable(value = "UserCache",key="'USER_ID_'+#endUserId")
    public UserResponse getUserById(int endUserId) {
        UserResponse userResponse = new UserResponse();
        EndUser endUser = endUserMapper.selectByPrimaryKey(endUserId);
        if (endUser != null) {
            userResponse.setEndUser(endUser);
        } else {
            userResponse.setResCode("50505");
            userResponse.setResMsg("该用户不存在");
        }
        return userResponse;
    }

    /**
     * 根据手机号获取用户信息
     *
     * @param mobile
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
//    @Cacheable(value = "UserCache", key="'USER_MOBILE_'+#mobile")
    public UserResponse getUserByMobile(String mobile) {
        UserResponse userResponse = new UserResponse();
        EndUserExample endUserExample = new EndUserExample();
        EndUserExample.Criteria criteria = endUserExample.createCriteria();
        criteria.andMobileEqualTo(mobile);
        criteria.andIsDeletedEqualTo(false);
        EndUser endUser;
        List<EndUser> userList = endUserMapper.selectByExample(endUserExample);
        if (userList.size() > 1) {
            logger.error("找到多条该手机对应的用户");
            userResponse.setResCode("50505");
            userResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50505"));
        } else if (userList.size() == 1) {
            endUser =  userList.get(0);
            logger.info("找到该手机对应的用户:" + endUser);
            userResponse.setEndUser(endUser);
        } else {
            logger.error("找不到该手机对应的用户");
            userResponse.setResCode("50506");
            userResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50506"));
        }

        return userResponse;
    }

    /**
     * 根据昵称获取用户信息
     *
     * @param nickName
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Cacheable(value = "UserCache")
    public UserResponse getUserByNickName(String nickName) {
        UserResponse userResponse = new UserResponse();
        EndUserExample endUserExample = new EndUserExample();
        EndUserExample.Criteria criteria = endUserExample.createCriteria();
        criteria.andNickNameEqualTo(nickName);
        criteria.andIsDeletedEqualTo(false);
        EndUser endUser;
        List<EndUser> userList = endUserMapper.selectByExample(endUserExample);
        if (userList.size() > 1) {
            logger.error("找到多条该昵称对应的用户");
            userResponse.setResCode("50505");
            userResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50505"));
        } else if (userList.size() == 1) {
            endUser =  userList.get(0);
            userResponse.setEndUser(endUser);
        } else {
            logger.error("找不到该昵称对应的用户");
            userResponse.setResCode("50506");
            userResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50506"));
        }

        return userResponse;
    }

    /**
     * 验证手机号(也是用户名)、密码是否匹配
     *
     * @param mobile
     * @param password
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public UserResponse authenticate(String mobile, String password) {
        UserResponse userResponse = new UserResponse();
        EndUser endUser = getUserByMobile(mobile).getEndUser();
        if (endUser!=null
                && endUser.getPassword()!=null
                && PasswordUtil.passwordHashValidate(password, endUser.getPassword())) {
            userResponse.setEndUser(endUser);
        } else {
            ErrorResponseUtil.setErrorResponse(userResponse, "40101");
        }
        return userResponse;
    }

}