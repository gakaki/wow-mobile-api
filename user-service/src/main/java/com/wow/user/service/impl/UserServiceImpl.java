package com.wow.user.service.impl;

import com.wow.user.mapper.EndUserMapper;
import com.wow.user.model.*;
import com.wow.user.service.UserService;
import com.wow.user.util.PasswordUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     * 用户注册
     *
     * @param endUser
     * @return
     */
    @Override
    public int register(EndUser endUser) {
        endUser.setPassword(PasswordUtil.passwordHashGenerate(endUser.getPassword()));
        return endUserMapper.insertSelective(endUser);
    }

    /**
     * 是否已注册用户
     *
     * @param userName
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public boolean isExistedUser(String userName) {
        EndUser user = getEndUserByUserName(userName);
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
        return endUserMapper.updateByPrimaryKeySelective(endUser);
    }

    /**
     * 获取验证码
     *
     * @param mobile
     * @return 验证码
     */
    public String getCaptcha(String mobile) {
        String captcha = "";
        //TODO:调用阿里大禹的短信接口,往目标手机发送随机生成的6位数字,并将6位数字存储到Redis中
        //1. generate 6-bit digit randomly
        //2. call alidayu interface to send sms
        //3. store digit into redis
        return captcha;
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
    public boolean resetPassword(String mobile, String captcha, String newPwd) {
        String captchaForMobile = getCaptchaOnServer(mobile);
        if (captchaForMobile.equalsIgnoreCase(captcha)) {
            EndUser endUser = getEndUserByMobile(mobile);
            if(endUser == null) {
                logger.error("该用户不存在");
                return false;
            }
            endUser.setPassword(PasswordUtil.passwordHashGenerate(newPwd));
            endUser.setUpdateTime(new Date());
            return (endUserMapper.updateByPrimaryKeySelective(endUser)>0);
        } else {
            logger.info("验证码无效,请重新获取");
            return false;
        }
    }

    /**
     *
     * @param mobile
     * @return
     */
    @Transactional(propagation= Propagation.SUPPORTS)
    private String getCaptchaOnServer(String mobile) {
        //TODO: get captcha from redis or mysql
        return "123456";
    }
    /**
     * 根据Id获取用户信息
     *
     * @param endUserId
     * @return
     */
    @Transactional(propagation= Propagation.SUPPORTS)
    public EndUser getEndUserById(int endUserId) {
        logger.info("get end user with id:" + endUserId);
        return endUserMapper.selectByPrimaryKey(endUserId);
    }

    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    @Override
    public EndUser getEndUserByUserName(String userName) {
        EndUserExample endUserExample = new EndUserExample();
        EndUserExample.Criteria criteria = endUserExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        criteria.andIsDeletedEqualTo(false);
        List<EndUser> userList = endUserMapper.selectByExample(endUserExample);
        logger.info("userList:" + userList);
        if (userList.size() > 1) {
            logger.error("username should be unique");
            return null;
        } else if (userList.size() == 1) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    /**
     * 根据手机号获取用户信息
     *
     * @param mobile
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public EndUser getEndUserByMobile(String mobile) {
        EndUserExample endUserExample = new EndUserExample();
        EndUserExample.Criteria criteria = endUserExample.createCriteria();
        criteria.andMobileEqualTo(mobile);
        criteria.andIsDeletedEqualTo(false);
        List<EndUser> userList = endUserMapper.selectByExample(endUserExample);
        logger.info("userList:" + userList);
        if (userList.size() > 1) {
            logger.error("mobile should be unique");
            return null;
        } else if (userList.size() == 1) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    /**
     * 根据昵称获取用户信息
     *
     * @param nickName
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public EndUser getEndUserByNickName(String nickName) {
        EndUserExample endUserExample = new EndUserExample();
        EndUserExample.Criteria criteria = endUserExample.createCriteria();
        criteria.andNickNameEqualTo(nickName);
        criteria.andIsDeletedEqualTo(false);
        List<EndUser> userList = endUserMapper.selectByExample(endUserExample);
        logger.info("userList:" + userList);
        if (userList.size() > 1) {
            logger.error("nickname should be unique");
            return null;
        } else if (userList.size() == 1) {
            return userList.get(0);
        } else {
            return null;
        }
    }

    /**
     * 批量查询多个用户
     *
     * @param endUserIds
     * @return
     */
    @Transactional(propagation= Propagation.SUPPORTS)
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
    @Transactional(propagation= Propagation.SUPPORTS)
    public EndUser authenticate(String userName, String password) {

        EndUser endUser = getEndUserByUserName(userName);
        if (PasswordUtil.passwordHashValidate(password, endUser.getPassword())) {
            return endUser;
        } else {
            return null;
        }
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

}