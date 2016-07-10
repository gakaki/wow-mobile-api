package com.wow.user.service.impl;

import com.taobao.api.request.AlibabaAliqinFcSmsNumSendRequest;

import com.wow.common.error.ErrorRepositoryManager;
import com.wow.common.util.RandomGenerator;
import com.wow.common.util.RedisUtil;
import com.wow.user.mapper.EndUserMapper;
import com.wow.user.mapper.EndUserWechatMapper;
import com.wow.user.model.EndUser;
import com.wow.user.model.EndUserExample;
import com.wow.user.model.EndUserShareBrand;
import com.wow.user.model.EndUserShareDesigner;
import com.wow.user.model.EndUserShareProduct;
import com.wow.user.model.EndUserShareScene;
import com.wow.user.model.EndUserWechat;
import com.wow.user.model.EndUserWechatExample;
import com.wow.user.service.SessionService;
import com.wow.user.service.UserService;
import com.wow.user.thirdparty.SmsSender;
import com.wow.user.util.PasswordUtil;
import com.wow.user.vo.RegisterRequestVo;
import com.wow.user.vo.RegisterResultVo;
import com.wow.user.vo.WechatBindingStatusVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;

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

    @Autowired
    private SmsSender smsSender;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private ErrorRepositoryManager errorRepositoryManager;

    @Value("${redis.captcha.timeout}")
    private long captchaTimeout;

    /**
     * 用户注册
     *
     * @param registerRequestVo
     * @return
     */
    @Override
    public RegisterResultVo register(@Validated RegisterRequestVo registerRequestVo) {
        RegisterResultVo registerResultVo = new RegisterResultVo();
        //TODO: validation required, use hibernate validator?
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
            } else if (!registerRequestVo.getCaptcha().equals(captchaOnServer)) {
                registerResultVo.setSuccess(false);
                registerResultVo.setResCode("40202");
                registerResultVo.setResMsg(errorRepositoryManager.getErrorMsg("40202"));
            } else {
                registerRequestVo.getEndUser().setPassword(
                        PasswordUtil.passwordHashGenerate(registerRequestVo.getEndUser().getPassword()));
                endUserMapper.insertSelective(registerRequestVo.getEndUser());
                //TODO: 如果该用户是通过好友推荐进来注册的,需要更新推荐相关信息,通过消息通知营销系统,否则要双向依赖
                registerResultVo.setSuccess(true);
                //注册成功,需要将用户ID返回
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
     * 检查手机号的注册和绑定微信状态
     *
     * @param mobile
     * @return
     */
    @Override
    public WechatBindingStatusVo checkWechatBindStatus(String mobile) {
        WechatBindingStatusVo wechatBindingStatusVo = new WechatBindingStatusVo();
        wechatBindingStatusVo.setMobile(mobile);
        wechatBindingStatusVo.setRegistered(isExistedUserByMobile(mobile));
        EndUserWechatExample endUserWechatExample = new EndUserWechatExample();
        EndUserWechatExample.Criteria criteria = endUserWechatExample.createCriteria();
        criteria.andMobileEqualTo(mobile);
        criteria.andWechatIdIsNotNull();
        criteria.andIsBindEqualTo(true);
        List<EndUserWechat> list = endUserWechatMapper.selectByExample(endUserWechatExample);
        if (list != null && list.size()==1) {
            EndUserWechat endUserWechat = list.get(0);
            wechatBindingStatusVo.setBindWechat(true);
            wechatBindingStatusVo.setWechatId(endUserWechat.getWechatId());
        } else if (list == null || list.size()==0){
            wechatBindingStatusVo.setBindWechat(false);
        } else if (list.size() > 1) {
            //异常
            wechatBindingStatusVo.setBindWechat(false);
        }
        return wechatBindingStatusVo;
    }

    /**
     * 绑定微信
     *
     * @param endUserWechat
     * @return
     */
    @Override
    public int bindWechatToUser(EndUserWechat endUserWechat) {
        return endUserWechatMapper.insertSelective(endUserWechat);
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
     * 请求并发送验证码
     * 注册,修改密码或者多次输入错误的情况下使用
     *
     * @param mobile
     * @return 验证码
     */
    public String sendCaptcha(String mobile) {

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
        //TODO: 是否所有验证码的过期时间一样,还是需要配置?
        redisUtil.set(mobile,randomNum,captchaTimeout);//缓存无限长,需要做成配置

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
    @CacheEvict(value = "UserCache", key="'USER_MOBILE_'+#mobile")
    public boolean resetPassword(String mobile, String captcha, String newPwd) {
        String captchaForMobile = getCaptchaOnServer(mobile);
        if (captchaForMobile.equals(captcha)) {
            EndUser endUser = getEndUserByMobile(mobile);
            if(endUser == null) {
                logger.error("该用户不存在");
                return false;
            }
            endUser.setPassword(PasswordUtil.passwordHashGenerate(newPwd));
            endUser.setUpdateTime(new Date());
            if (endUserMapper.updateByPrimaryKeySelective(endUser)>0) {
                //需要设置当前有效的session token失效(所有登录渠道)
                sessionService.invalidateSessionToken(endUser.getId());
            } else {
                //修改密码失败
            }
        } else {
            logger.info("验证码无效,请重新获取");
            return false;
        }
        return true;
    }

    /**
     * 获取服务器上生成的验证码
     * @param mobile
     * @return
     */
    @Transactional(propagation= Propagation.SUPPORTS)
    private String getCaptchaOnServer(String mobile) {
        String captchaOnServer = "";
        //get from redis
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
     * 一般是运营后台调用
     *
     * @param endUserIds
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.SUPPORTS)
    @Cacheable(value = "UserCache")
    public List<EndUser> getEndUsersByIds(int[] endUserIds) {
        //TODO:
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