package com.wow.user.service.impl;

import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;
import com.wow.common.error.ErrorRepositoryManager;
import com.wow.common.util.RandomGenerator;
import com.wow.common.util.RedisUtil;
import com.wow.user.mapper.EndUserMapper;
import com.wow.user.model.*;
import com.wow.user.service.UserService;
import com.wow.user.thirdparty.SmsSender;
import com.wow.user.util.PasswordUtil;
import com.wow.user.vo.RegisterRequestVo;
import com.wow.user.vo.RegisterResultVo;
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
    private SmsSender smsSender;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ErrorRepositoryManager errorRepositoryManager;

    /**
     * 用户注册
     *
     * @param registerRequestVo
     * @return
     */
    @Override
    public RegisterResultVo register(RegisterRequestVo registerRequestVo) {
        RegisterResultVo registerResultVo = new RegisterResultVo();
        String mobile = registerRequestVo.getEndUser().getMobile();
        if (StringUtils.isEmpty(mobile)) {
            registerResultVo.setSuccess(false);
            registerResultVo.setResCode("40000");
            registerResultVo.setResMsg(errorRepositoryManager.getErrorMsg("40000"));
        } else {
            //判断验证码是否与服务端一致,且服务端验证码未过期
            String captchaOnServer = getCaptchaOnServer(mobile);
            if (StringUtils.isEmpty(captchaOnServer)) {
                registerResultVo.setSuccess(false);
                registerResultVo.setResCode("40201");
                registerResultVo.setResMsg(errorRepositoryManager.getErrorMsg("40201"));
            } else if (!registerRequestVo.getCaptcha().equalsIgnoreCase(captchaOnServer)) {
                registerResultVo.setSuccess(false);
                registerResultVo.setResCode("40202");
                registerResultVo.setResMsg(errorRepositoryManager.getErrorMsg("40202"));
            } else {
                registerRequestVo.getEndUser().setPassword(
                        PasswordUtil.passwordHashGenerate(registerRequestVo.getEndUser().getPassword()));
                endUserMapper.insertSelective(registerRequestVo.getEndUser());
                registerResultVo.setSuccess(true);
                registerResultVo.setEndUserId(registerRequestVo.getEndUser().getId());
                registerResultVo.setResCode("0");
                registerResultVo.setResMsg(errorRepositoryManager.getErrorMsg("0"));
            }
        }
        return registerResultVo;
    }

    /**
     * 根据用户名判断是否已注册用户
     *
     * @param userName
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public boolean isExistedUserByUserName(String userName) {
        EndUser user = getEndUserByUserName(userName);
        logger.info("user=" + user);
        return (user != null);
    }

    /**
     * 根据手机号判断是否已注册用户
     *
     * @param mobile
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public boolean isExistedUserByMobile(String mobile) {
        EndUser user = getEndUserByMobile(mobile);
        logger.info("user=" + user);
        return (user != null);
    }

    /**
     * 根据昵称判断是否已注册用户
     *
     * @param nickName
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    public boolean isExistedUserByNickName(String nickName) {
        EndUser user = getEndUserByNickName(nickName);
        logger.info("user=" + user);
        return (user != null);
    }

    /**
     * 用户信息更新
     *
     * @param endUser
     * @return
     */
    @Override
    @CacheEvict(value = "UserCache",key="'USER_ID_'+#endUserId")
    public int updateEndUser(EndUser endUser) {
        return endUserMapper.updateByPrimaryKeySelective(endUser);
    }

    /**
     * 请求验证码
     *
     * @param mobile
     * @return 验证码
     */
    public String getCaptcha(String mobile) {

        //调用阿里大鱼的短信接口,往目标手机发送随机生成的6位数字,并将6位数字存储到Redis中
        //1. generate 6-bit digit randomly
        String randomNum = RandomGenerator.createRandom(true,6);

        //2. call alidayu interface to send sms
        AlibabaAliqinFcSmsNumSendRequest req = new AlibabaAliqinFcSmsNumSendRequest();
        req.setExtend( "13764641531 uid " );//公共回传参数，在“消息返回”中会透传回该参数；举例：用户可以传入自己下级的会员ID，在消息返回时，该会员ID会包含在内，用户可以根据该会员ID识别是哪位会员使用了你的应用
        req.setSmsType("normal");//短信类型，传入值请填写normal
        req.setSmsFreeSignName("尖叫设计");//短信签名，传入的短信签名必须是在阿里大鱼“管理中心-短信签名管理”中的可用签名。如“阿里大鱼”已在短信签名管理中通过审核，则可传入”阿里大鱼“（传参时去掉引号）作为短信签名。短信效果示例：【阿里大鱼】欢迎使用阿里大鱼服务。
        req.setSmsParamString("{'code':'" + randomNum + "','product':'尖叫设计'}");//短信模板变量，传参规则{"key":"value"}，key的名字须和申请模板中的变量名一致，多个变量之间以逗号隔开。示例：针对模板“验证码${code}，您正在进行${product}身份验证，打死不要告诉别人哦！”，传参时需传入{"code":"1234","product":"alidayu"}
        req.setRecNum(mobile);//短信接收号码。支持单个或多个手机号码，传入号码为11位手机号码，不能加0或+86。群发短信需传入多个号码，以英文逗号分隔，一次调用最多传入200个号码。示例：18600000000,13911111111,13322222222
        req.setSmsTemplateCode("SMS_5165048");//短信模板ID，传入的模板必须是在阿里大鱼“管理中心-短信模板管理”中的可用模板。示例：SMS_585014
        logger.info("request=" + req);
        smsSender.sendValidateCode(req);

        //3. store digit into redis
        redisUtil.set(mobile,randomNum,3000000000000000L);//缓存5分钟

        return randomNum;
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
//    @CacheEvict(value = "UserCache", key="'USER_MOBILE_'+#mobile")
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
        String captchaOnServer = "";
        Object captcha = redisUtil.get(mobile);
        if (captcha != null) {
            captchaOnServer = (String) captcha;
        }
        return captchaOnServer;
    }
    /**
     * 根据Id获取用户信息
     *
     * @param endUserId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    @Cacheable(value = "UserCache",key="'USER_ID_'+#endUserId")
    public EndUser getEndUserById(int endUserId) {
        logger.info("无缓存的时候调用这里");
        return endUserMapper.selectByPrimaryKey(endUserId);
    }

    /**
     * 根据用户名获取用户信息
     *
     * @param userName
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    @Cacheable(value = "UserCache",key="'USER_NAME_'+#userName")
    public EndUser getEndUserByUserName(String userName) {
        EndUserExample endUserExample = new EndUserExample();
        EndUserExample.Criteria criteria = endUserExample.createCriteria();
        criteria.andUserNameEqualTo(userName);
        criteria.andIsDeletedEqualTo(false);
        List<EndUser> userList = endUserMapper.selectByExample(endUserExample);
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
    @Cacheable(value = "UserCache", key="'USER_MOBILE_'+#mobile")
    public EndUser getEndUserByMobile(String mobile) {
        EndUserExample endUserExample = new EndUserExample();
        EndUserExample.Criteria criteria = endUserExample.createCriteria();
        criteria.andMobileEqualTo(mobile);
        criteria.andIsDeletedEqualTo(false);
        List<EndUser> userList = endUserMapper.selectByExample(endUserExample);
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
    @Cacheable(value = "UserCache")
    public EndUser getEndUserByNickName(String nickName) {
        EndUserExample endUserExample = new EndUserExample();
        EndUserExample.Criteria criteria = endUserExample.createCriteria();
        criteria.andNickNameEqualTo(nickName);
        criteria.andIsDeletedEqualTo(false);
        List<EndUser> userList = endUserMapper.selectByExample(endUserExample);
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
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    @Cacheable(value = "UserCache")
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
        if (endUser!=null
                && endUser.getPassword()!=null
                && PasswordUtil.passwordHashValidate(password, endUser.getPassword())) {
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