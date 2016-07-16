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
import com.wow.user.vo.response.RegisterResponse;
import com.wow.user.vo.response.UserCheckResponse;
import com.wow.user.vo.response.UserResponse;
import com.wow.user.vo.response.WechatBindStatusResponse;
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
     * @param captcha
     * @return
     */
    @Override
    public RegisterResponse register(EndUser endUser, String captcha) {
        RegisterResponse registerResponse = new RegisterResponse();
        //TODO: validation required, use hibernate validator?
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

        //判断验证码是否与服务端一致,且服务端验证码未过期
        String captchaOnServer = getCaptchaOnServer(mobile);
        if (StringUtils.isEmpty(captchaOnServer)) {
            ErrorResponseUtil.setErrorResponse(registerResponse,"40102");
        } else if (!captcha.equals(captchaOnServer)) {
            ErrorResponseUtil.setErrorResponse(registerResponse,"40103");
        } else {
            endUser.setPassword(
                    PasswordUtil.passwordHashGenerate(endUser.getPassword()));
            endUserMapper.insertSelective(endUser);
            //TODO: 如果该用户是通过好友推荐进来注册的,需要更新推荐相关信息,通过消息通知营销系统,否则要双向依赖
            //注册成功,需要将用户ID返回
            registerResponse.setEndUserId(endUser.getId());
        }
        return registerResponse;
    }

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
        EndUser user = getEndUserByNickName(nickName).getEndUser();
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
        UserResponse userResponse = getEndUserByMobile(mobile);
        userCheckResponse.setExistedUser(userResponse.getEndUser() != null);
        return userCheckResponse;
    }

    /**
     * 检查手机号的注册和绑定微信状态
     *
     * @param mobile
     * @return
     */
    @Override
    public WechatBindStatusResponse checkWechatBindStatus(String mobile) {
        WechatBindStatusResponse wechatBindStatusResponse = new WechatBindStatusResponse();
        WechatBindStatusVo wechatBindStatusVo = new WechatBindStatusVo();
        wechatBindStatusVo.setMobile(mobile);
        wechatBindStatusVo.setRegistered(isExistedUserByMobile(mobile).isExistedUser());
        EndUserWechatExample endUserWechatExample = new EndUserWechatExample();
        EndUserWechatExample.Criteria criteria = endUserWechatExample.createCriteria();
        criteria.andMobileEqualTo(mobile);
        criteria.andWechatIdIsNotNull();
        criteria.andIsBindEqualTo(true);
        List<EndUserWechat> list = endUserWechatMapper.selectByExample(endUserWechatExample);
        if (CollectionUtil.isNotEmpty(list)) {
            EndUserWechat endUserWechat = list.get(0);
            wechatBindStatusVo.setBinded(true);
            wechatBindStatusVo.setWechatId(endUserWechat.getWechatId());
            wechatBindStatusVo.setEndUserId(endUserWechat.getEndUserId());
        } else {
            wechatBindStatusVo.setBinded(false);
        }
        wechatBindStatusResponse.setWechatBindStatusVo(wechatBindStatusVo);
        return wechatBindStatusResponse;
    }

    /**
     * 绑定微信
     *
     * @param endUserWechat
     * @return
     */
    @Override
    public WechatBindStatusResponse bindWechatToUser(EndUserWechat endUserWechat) {
        WechatBindStatusResponse wechatBindStatusResponse = new WechatBindStatusResponse();
        WechatBindStatusVo wechatBindStatusVo = new WechatBindStatusVo();
        int i = endUserWechatMapper.insertSelective(endUserWechat);
        wechatBindStatusVo.setBinded(i>0);
        wechatBindStatusVo.setMobile(endUserWechat.getMobile());
        wechatBindStatusResponse.setWechatBindStatusVo(wechatBindStatusVo);
        return wechatBindStatusResponse;
    }

    /**
     * 判断微信号是否已经绑定了一个账号
     *
     * @param wechatId
     * @return
     */
    @Override
    public WechatBindStatusResponse checkIfWechatIdBindToUserId(String wechatId) {
        WechatBindStatusResponse wechatBindStatusResponse = new WechatBindStatusResponse();
        WechatBindStatusVo wechatBindStatusVo = endUserWechatMapper.selectByWechatId(wechatId);
        if (wechatBindStatusVo == null) {
            wechatBindStatusVo = new WechatBindStatusVo();
            wechatBindStatusVo.setBinded(false);
        } else if (wechatBindStatusVo.isBinded()) {
            wechatBindStatusVo.setRegistered(true);
        }
        wechatBindStatusResponse.setWechatBindStatusVo(wechatBindStatusVo);
//        EndUserWechatExample endUserWechatExample = new EndUserWechatExample();
//        EndUserWechatExample.Criteria criteria = endUserWechatExample.createCriteria();
//        criteria.andWechatIdEqualTo(String.valueOf(wechatId));
//        criteria.andEndUserIdIsNotNull();
//        criteria.andIsBindEqualTo(true);
//        List<EndUserWechat> endUserWechatList = endUserWechatMapper.selectByExample(endUserWechatExample);
//        if (CollectionUtil.isEmpty(endUserWechatList)) {
//            wechatBindStatusVo.setBinded(false);
//            wechatBindStatusResponse.setWechatBindStatusVo(wechatBindStatusVo);
//        } else if (endUserWechatList.size() > 1) {
//            wechatBindStatusResponse.setResCode("50105");
//            wechatBindStatusResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50105"));
//        } else {
//            EndUserWechat endUserWechat = endUserWechatList.get(0);
//            wechatBindStatusVo.setBinded(true);
//            wechatBindStatusVo.setMobile(endUserWechat.getMobile());
//            wechatBindStatusVo.setRegistered(true);
//            wechatBindStatusVo.setWechatId(String.valueOf(wechatId));
//            wechatBindStatusVo.setEndUserId(endUserWechat.getEndUserId());
//            wechatBindStatusResponse.setWechatBindStatusVo(wechatBindStatusVo);
//        }
        return wechatBindStatusResponse;
    }

    /**
     * 用户信息更新
     *
     * @param endUser
     * @return
     */
    @Override
    @CacheEvict(value = "UserCache",key="'USER_ID_'+#endUserId")
    public CommonResponse updateEndUser(EndUser endUser) {
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
     * @param captcha
     * @param newPwd
     * @return
     */
    @Override
    @CacheEvict(value = "UserCache", key="'USER_MOBILE_'+#mobile")
    public CommonResponse resetPassword(String mobile, String captcha, String newPwd) {
        CommonResponse commonResponse = new CommonResponse();
        UserResponse userResponse = getEndUserByMobile(mobile);
        EndUser endUser = userResponse.getEndUser();
        if(endUser== null) {
            commonResponse.setResCode("40105");
            commonResponse.setResCode(ErrorCodeUtil.getErrorMsg("40105"));
            return commonResponse;
        }

        String captchaForMobile = getCaptchaOnServer(mobile);
        if (StringUtil.isNotEmpty(captchaForMobile) && captchaForMobile.equals(captcha)) {
            endUser.setPassword(PasswordUtil.passwordHashGenerate(newPwd));
            endUser.setUpdateTime(new Date());
            endUserMapper.updateByPrimaryKeySelective(endUser);
            //需要设置当前有效的session token失效(所有登录渠道)
            sessionService.invalidateSessionToken(endUser.getId());
        } else {
            commonResponse.setResCode("40103");
            commonResponse.setResCode(ErrorCodeUtil.getErrorMsg("40103"));
        }
        return commonResponse;
    }

    /**
     * 获取服务器上生成的验证码
     * @param mobile
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    private String getCaptchaOnServer(String mobile) {
        String captchaOnServer = "111111"; //TODO, hard code for test only
//        //get from redis
//        Object captcha = RedisUtil.get(mobile);
//        if (captcha != null) {
//            captchaOnServer = (String) captcha;
//        }
        return captchaOnServer;
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
    public UserResponse getEndUserById(int endUserId) {
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
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Cacheable(value = "UserCache",key="'USER_NAME_'+#userName")
    public UserResponse getEndUserByUserName(String userName) {
        UserResponse userResponse = new UserResponse();
        EndUserExample endUserExample = new EndUserExample();
        EndUserExample.Criteria criteria = endUserExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        criteria.andIsDeletedEqualTo(false);
        List<EndUser> userList = endUserMapper.selectByExample(endUserExample);
        EndUser endUser;
        if (userList.size() > 1) {
            logger.error("找到多条该用户名对应的用户");
            userResponse.setResCode("50505");
            userResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50505"));
        } else if (userList.size() == 1) {
            endUser =  userList.get(0);
            userResponse.setEndUser(endUser);
        } else {
            logger.error("找不到该用户名对应的用户");
            userResponse.setResCode("50506");
            userResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50506"));
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
    public UserResponse getEndUserByMobile(String mobile) {
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
    public UserResponse getEndUserByNickName(String nickName) {
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
     * 批量查询多个用户
     * 一般是运营后台调用
     *
     * @param endUserIds
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    @Cacheable(value = "UserCache")
    public List<EndUser> getEndUsersByIds(int[] endUserIds) {
        //TODO:
        return null;
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
        EndUser endUser = getEndUserByMobile(mobile).getEndUser();
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