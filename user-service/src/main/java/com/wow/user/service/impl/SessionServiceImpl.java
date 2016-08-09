package com.wow.user.service.impl;

import com.wow.common.response.CommonResponse;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.ErrorResponseUtil;
import com.wow.common.util.IpConvertUtil;
import com.wow.common.util.RedisUtil;
import com.wow.user.constant.ThirdPartyPlatformType;
import com.wow.user.mapper.EndUserMapper;
import com.wow.user.mapper.EndUserSessionMapper;
import com.wow.user.model.EndUser;
import com.wow.user.model.EndUserLoginLog;
import com.wow.user.model.EndUserSession;
import com.wow.user.model.EndUserSessionExample;
import com.wow.user.service.LoginLogService;
import com.wow.user.service.SessionService;
import com.wow.user.service.ShoppingCartService;
import com.wow.user.service.UserService;
import com.wow.user.vo.LoginResponseVo;
import com.wow.user.vo.LoginVo;
import com.wow.user.vo.ThirdPartyLoginVo;
import com.wow.user.vo.response.LoginResponse;
import com.wow.user.vo.response.TokenValidateResponse;
import com.wow.user.vo.response.UserResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by zhengzhiqing on 16/6/16.
 */
@Service
@Transactional(value = "userTransactionManager")
public class SessionServiceImpl implements SessionService {

    private static final Logger logger = LoggerFactory.getLogger(SessionServiceImpl.class);

    @Autowired
    private EndUserMapper endUserMapper;

    @Autowired
    private EndUserSessionMapper endUserSessionMapper;

    @Autowired
    private UserService userService;

    @Autowired
    private LoginLogService loginLogService;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Value("${session.expirationTime}")
    private long sessionExpirationTime;

    /**
     * 用户登录
     *
     * @param loginVo
     * @return
     */
    public LoginResponse login(LoginVo loginVo) {
        LoginResponse loginResponse = new LoginResponse();
        LoginResponseVo loginResponseVo = new LoginResponseVo();
        //检查数据库,看手机号和密码是否匹配
        EndUser endUser = userService.authenticate(loginVo.getMobile(), loginVo.getPassword()).getEndUser();
        if (endUser != null) { //验证成功
            EndUserSession endUserSession = saveOrUpdateSession(loginVo, endUser.getId(),null);
            loginResponseVo.setSessionToken(endUserSession.getSessionToken());
            loginResponseVo.setNickName(endUser.getNickName());
            loginResponseVo.setAgeRange(endUser.getAgeRange());
            loginResponseVo.setAvatar(endUser.getAvatar());
            loginResponseVo.setConstellation(endUser.getConstellation());
            loginResponseVo.setIndustry(endUser.getIndustry());
            loginResponseVo.setSelfIntroduction(endUser.getSelfIntroduction());
            loginResponseVo.setSex(endUser.getSex());
            loginResponseVo.setProductQtyInCart(getProductQtyInCartByUserId(endUser.getId()));
            loginResponse.setLoginResponseVo(loginResponseVo);
        } else {
            ErrorResponseUtil.setErrorResponse(loginResponse,"40101");
        }
        return loginResponse;
    }

    /**
     * 第三方登录
     *
     * @param thirdPartyLoginVo
     * @return
     */
    @Override
    public LoginResponse thirdPartyLogin(ThirdPartyLoginVo thirdPartyLoginVo) {
        LoginResponse loginResponse = new LoginResponse();
        LoginResponseVo loginResponseVo = new LoginResponseVo();

        int thirdPartyPlatformType = thirdPartyLoginVo.getThirdPartyPlatformType();
        logger.info("third party platform:" + thirdPartyPlatformType);
        String thirdPartyPlatformUserId = thirdPartyLoginVo.getThirdPartyPlatformUserId();

        if (thirdPartyPlatformType == ThirdPartyPlatformType.THIRD_PARTY_PLATFORM_WECHAT) {

            //检查end_user_wechat,查看该id是否已经绑定一个已注册用户
            UserResponse userResponse = userService.getUserByOpenId(thirdPartyPlatformUserId);

            if (userResponse != null && userResponse.getEndUser() != null) {
                EndUser endUser = userResponse.getEndUser();
                //根据userId和channel查找EndUserSession,如果有则更新,没有则创建
                LoginVo loginVo = new LoginVo();
                loginVo.setLoginIp(thirdPartyLoginVo.getLoginIp());
                loginVo.setLoginChannel(thirdPartyLoginVo.getLoginChannel());
                loginVo.setMobile(endUser.getMobile());
                loginVo.setUserAgent(thirdPartyLoginVo.getUserAgent());
                EndUserSession endUserSession = saveOrUpdateSession(loginVo, endUser.getId(),thirdPartyPlatformType);
                loginResponseVo.setNickName(endUser.getNickName());
                loginResponseVo.setSessionToken(endUserSession.getSessionToken());
                loginResponseVo.setAgeRange(endUser.getAgeRange());
                loginResponseVo.setAvatar(endUser.getAvatar());
                loginResponseVo.setConstellation(endUser.getConstellation());
                loginResponseVo.setIndustry(endUser.getIndustry());
                loginResponseVo.setSelfIntroduction(endUser.getSelfIntroduction());
                loginResponseVo.setSex(endUser.getSex());
                loginResponseVo.setProductQtyInCart(getProductQtyInCartByUserId(endUser.getId()));
                loginResponse.setLoginResponseVo(loginResponseVo);
            } else {
                ErrorResponseUtil.setErrorResponse(loginResponse, "50106");
            }
        }
        return loginResponse;
    }
    /**
     * 查询该用户购物车商品数量
     */
    private int getProductQtyInCartByUserId(int endUserId) {
        return shoppingCartService.getProductQtyInCart(endUserId);
    }

    /**
     * 创建或更新会话信息,记录登录日志
     * @param loginVo
     * @param endUserId
     * @param thirdPartyPlatformType - 第三方登录平台(如微信,QQ,微博等)
     */
    /*private EndUserSession saveOrUpdateSession(LoginVo loginVo,
                                     int endUserId, Integer thirdPartyPlatformType) {
        EndUserSession endUserSession = getSessionByUserIdAndChannel(endUserId, loginVo.getLoginChannel());
        long loginIp = IpConvertUtil.ipToLong(loginVo.getLoginIp());
        Date now = new Date();
        //token生成算法,暂用UUID,可以替换
        String sessionToken = UUID.randomUUID().toString();
        if (endUserSession == null) {
            logger.info("首次登录");
            endUserSession = new EndUserSession();
            endUserSession.setEndUserId(endUserId);
            endUserSession.setIsLogout(false);
            endUserSession.setLastLoginIp(loginIp);
            endUserSession.setLastRefreshTime(now);
            endUserSession.setLastLoginTime(now);
            endUserSession.setLoginChannel(loginVo.getLoginChannel());
            endUserSession.setLogoutTime(null);
            endUserSession.setSessionToken(sessionToken);
            endUserSession.setUserAgentInfo(loginVo.getUserAgent());
            endUserSessionMapper.insertSelective(endUserSession);
        } else {
            logger.info("修改会话");
            endUserSession.setIsLogout(false);
            endUserSession.setLastLoginIp(loginIp);
            endUserSession.setLastRefreshTime(now);
            endUserSession.setLastLoginTime(now);
            endUserSession.setLoginChannel(loginVo.getLoginChannel());
            endUserSession.setLogoutTime(null);
            endUserSession.setSessionToken(sessionToken);
            endUserSession.setUserAgentInfo(loginVo.getUserAgent());
            //此处不用updateByPrimaryKeySelective,因为setLogoutTime(null)
            endUserSessionMapper.updateByPrimaryKey(endUserSession);
        }
        logger.info("endUserSession=" + endUserSession);
        //记录登录日志
        EndUserLoginLog endUserLoginLog = new EndUserLoginLog();
        endUserLoginLog.setUserAgentInfo(loginVo.getUserAgent());
        endUserLoginLog.setLoginChannel(loginVo.getLoginChannel());
        endUserLoginLog.setEndUserId(endUserId);
        endUserLoginLog.setLoginIp(loginIp);
        endUserLoginLog.setLoginTime(now);
        endUserLoginLog.setSessionToken(sessionToken);
        if (thirdPartyPlatformType != null) {
            endUserLoginLog.setThirdPartyPlatformType(thirdPartyPlatformType.byteValue());
        }
        logger.info("endUserLoginLog:" + endUserLoginLog);
        loginLogService.addLoginLog(endUserLoginLog);
        return endUserSession;
    }*/

    /**
     * 根据userId和登录渠道查询会话
     *
     * @param userId
     * @param loginChannel
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    private EndUserSession getSessionByUserIdAndChannel (int userId, byte loginChannel) {
        EndUserSession endUserSession = null;
        EndUserSessionExample endUserSessionExample = new EndUserSessionExample();
        EndUserSessionExample.Criteria criteria = endUserSessionExample.createCriteria();
        criteria.andEndUserIdEqualTo(userId);
        criteria.andLoginChannelEqualTo(loginChannel);
        List<EndUserSession> endUserSessions = endUserSessionMapper.selectByExample(endUserSessionExample);
        if (CollectionUtil.isNotEmpty(endUserSessions)) {
            endUserSession = endUserSessions.get(0);
        }
        return endUserSession;
    }

    /**
     * 创建或更新会话信息,记录登录日志
     * @param loginVo
     * @param endUserId
     * @param thirdPartyPlatformType - 第三方登录平台(如微信,QQ,微博等)
     */
    private EndUserSession saveOrUpdateSession(LoginVo loginVo,
                                               int endUserId, Integer thirdPartyPlatformType) {
        EndUserSession endUserSession = getSessionByUserIdAndChannelOnRedis(endUserId, loginVo.getLoginChannel());
        long loginIp = IpConvertUtil.ipToLong(loginVo.getLoginIp());
        Date now = new Date();
        //token生成算法,暂用UUID,可以替换
        String sessionToken = UUID.randomUUID().toString();
        if (endUserSession == null) {
            logger.info("首次登录");
            endUserSession = new EndUserSession();
            endUserSession.setEndUserId(endUserId);
            endUserSession.setIsLogout(false);
            endUserSession.setLastLoginIp(loginIp);
            endUserSession.setLastRefreshTime(now);
            endUserSession.setLastLoginTime(now);
            endUserSession.setLoginChannel(loginVo.getLoginChannel());
            endUserSession.setLogoutTime(null);
            endUserSession.setSessionToken(sessionToken);
            endUserSession.setUserAgentInfo(loginVo.getUserAgent());
            addOrUpdateSessionOnRedis(endUserSession);
        } else {
            logger.info("修改会话");
            endUserSession.setIsLogout(false);
            endUserSession.setLastLoginIp(loginIp);
            endUserSession.setLastRefreshTime(now);
            endUserSession.setLastLoginTime(now);
            endUserSession.setLoginChannel(loginVo.getLoginChannel());
            endUserSession.setLogoutTime(null);
            endUserSession.setSessionToken(sessionToken);
            endUserSession.setUserAgentInfo(loginVo.getUserAgent());
            //此处不用updateByPrimaryKeySelective,因为setLogoutTime(null)
            addOrUpdateSessionOnRedis(endUserSession);
        }
        logger.info("endUserSession=" + endUserSession);
        //记录登录日志
        EndUserLoginLog endUserLoginLog = new EndUserLoginLog();
        endUserLoginLog.setUserAgentInfo(loginVo.getUserAgent());
        endUserLoginLog.setLoginChannel(loginVo.getLoginChannel());
        endUserLoginLog.setEndUserId(endUserId);
        endUserLoginLog.setLoginIp(loginIp);
        endUserLoginLog.setLoginTime(now);
        endUserLoginLog.setSessionToken(sessionToken);
        if (thirdPartyPlatformType != null) {
            endUserLoginLog.setThirdPartyPlatformType(thirdPartyPlatformType.byteValue());
        }
        logger.info("endUserLoginLog:" + endUserLoginLog);
        loginLogService.addLoginLog(endUserLoginLog);
        return endUserSession;
    }

    /**
     * 根据userId和登录渠道查询会话
     *
     * @param userId
     * @param loginChannel
     * @return
     */
    private EndUserSession getSessionByUserIdAndChannelOnRedis (int userId, byte loginChannel) {
        return (EndUserSession) RedisUtil.get("user-"+userId+"-"+loginChannel);
    }

    /**
     * 添加或修改用户sessionToken相关信息
     * @param endUserSession
     */
    private void addOrUpdateSessionOnRedis(EndUserSession endUserSession){
        EndUserSession session=null;
        if((session=(EndUserSession)RedisUtil.get("user-"+endUserSession.getEndUserId()+"-"+endUserSession.getLoginChannel()))!=null){
            RedisUtil.remove("session-"+session.getSessionToken());
            session=null;
        }
        RedisUtil.set("user-"+endUserSession.getEndUserId()+"-"+endUserSession.getLoginChannel(),endUserSession,sessionExpirationTime);
        RedisUtil.set("session-"+endUserSession.getSessionToken(),"user-"+endUserSession.getEndUserId()+"-"+endUserSession.getLoginChannel(),sessionExpirationTime);
    }

    /**
     * 延续会话过期时间
     *
     * @param endUserSession
     * @return
     */
    private void refreshSession(EndUserSession endUserSession) {
        EndUserSessionExample endUserSessionExample = new EndUserSessionExample();
        EndUserSessionExample.Criteria criteria = endUserSessionExample.createCriteria();
        criteria.andEndUserIdEqualTo(endUserSession.getEndUserId());
        criteria.andLoginChannelEqualTo(endUserSession.getLoginChannel());
        criteria.andIsLogoutEqualTo(false);
        criteria.andIsActiveEqualTo(true);
        endUserSession.setLastRefreshTime(new Date());
        endUserSessionMapper.updateByExampleSelective(endUserSession, endUserSessionExample);
    }



    /**
     * 用户登出
     *
     * @param sessionToken
     * @param loginChannel
     * @return
     */
    /*public CommonResponse logout(String sessionToken, byte loginChannel) {
        CommonResponse commonResponse = new CommonResponse();
        EndUserSession endUserSession = new EndUserSession();
        endUserSession.setIsLogout(true);
        endUserSession.setLogoutTime(new Date());
        EndUserSessionExample endUserSessionExample = new EndUserSessionExample();
        EndUserSessionExample.Criteria criteria = endUserSessionExample.createCriteria();
        criteria.andSessionTokenEqualTo(sessionToken);
        criteria.andLoginChannelEqualTo(loginChannel);
        endUserSessionMapper.updateByExampleSelective(endUserSession, endUserSessionExample);
        return commonResponse;
    }*/

    /**
     * 用户登出
     *
     * @param sessionToken
     * @param loginChannel
     * @return
     */
    public CommonResponse logout(String sessionToken, byte loginChannel) {
        CommonResponse commonResponse = new CommonResponse();
        EndUserSession endUserSession= (EndUserSession) RedisUtil.get("session-"+sessionToken);
        RedisUtil.remove("user-"+endUserSession.getEndUserId()+"-"+loginChannel);
        RedisUtil.remove("session-"+sessionToken);
        endUserSession=null;
        return commonResponse;
    }

    /**
     * 判断是否有效session
     *
     * @param sessionToken
     * @param loginChannel
     * @return
     */
    /*@Override
    public TokenValidateResponse isValidSessionToken(String sessionToken, byte loginChannel) {
        TokenValidateResponse tokenValidateResponse = new TokenValidateResponse();
        boolean isValid = false;
        Integer endUserId = null;
        long currentTime = System.currentTimeMillis();
        Date mustRefreshAfter = new Date(currentTime - sessionExpirationTime);
        EndUserSession endUserSession = getValidSessionByTokenChannel(
                sessionToken, loginChannel, mustRefreshAfter);
        if (endUserSession != null && endUserSession.getId() != null) {
            isValid = true;
            endUserId = endUserSession.getEndUserId();
            //刷新过期时间,不是每次都刷新,仅仅在当前时间与上次刷新时间之间间隔 < 过期时间的25%处刷新
            if (currentTime - endUserSession.getLastRefreshTime().getTime() < sessionExpirationTime*0.25) {
                refreshSession(endUserSession);
            }
        }
        tokenValidateResponse.setValid(isValid);
        if (endUserId != null) {
            tokenValidateResponse.setEndUserId(endUserId);
        }
        return tokenValidateResponse;
    }*/

    /**
     * 判断是否有效session
     *
     * @param sessionToken
     * @param loginChannel
     * @return
     */
    @Override
    public TokenValidateResponse isValidSessionToken(String sessionToken, byte loginChannel) {
        TokenValidateResponse tokenValidateResponse = new TokenValidateResponse();
        boolean isValid = false;

        EndUserSession endUserSession = (EndUserSession) RedisUtil.get(RedisUtil.get("session-"+sessionToken).toString());
        if(endUserSession!=null){
            isValid = true;
            long interval=System.currentTimeMillis()-endUserSession.getLastRefreshTime().getTime();
            if(interval<sessionExpirationTime*0.25){
                endUserSession.setLastRefreshTime(Calendar.getInstance().getTime());
                addOrUpdateSessionOnRedis(endUserSession);
            }
        }
        tokenValidateResponse.setValid(isValid);
        tokenValidateResponse.setEndUserId(endUserSession.getEndUserId());
        return tokenValidateResponse;
    }

    /**
     * 根据会话token查找当前有效的会话信息
     * @param sessionToken
     * @param loginChannel
     * @param mustRefreshAfter
     * @return
     */
    private EndUserSession getValidSessionByTokenChannel(
            String sessionToken, byte loginChannel, Date mustRefreshAfter) {
        EndUserSession endUserSession = null;
        EndUserSessionExample endUserSessionExample = new EndUserSessionExample();
        EndUserSessionExample.Criteria criteria = endUserSessionExample.createCriteria();
        criteria.andSessionTokenEqualTo(sessionToken);
        criteria.andLoginChannelEqualTo(loginChannel);
        criteria.andIsLogoutEqualTo(false);
        criteria.andIsActiveEqualTo(true);
        criteria.andLastRefreshTimeGreaterThan(mustRefreshAfter);

        List<EndUserSession> endUserSessions = endUserSessionMapper.selectByExample(endUserSessionExample);

        if (endUserSessions != null && endUserSessions.size()==1) {
            endUserSession = endUserSessions.get(0);
        } else if (endUserSessions.size() > 1) {
            //异常,不应该有多条记录
        }
        return endUserSession;

    }

    /**
     * 使会话失效 - 常用在修改密码之后
     *
     * @param endUserId
     * @return
     */
    @Override
    public CommonResponse invalidateSessionToken(int endUserId) {
        CommonResponse commonResponse = new CommonResponse();
        EndUserSessionExample endUserSessionExample = new EndUserSessionExample();
        EndUserSessionExample.Criteria criteria=endUserSessionExample.createCriteria();
        criteria.andIdEqualTo(endUserId);
        List<EndUserSession> endUserSessions=getAllActiveUserSession(endUserId);
        for (EndUserSession endUserSession : endUserSessions) {
            endUserSession.setIsActive(false);
            endUserSessionMapper.updateByExampleSelective(endUserSession, endUserSessionExample);
        }
        return commonResponse;
    }

    /**
     * 获取所有有效的会话
     * @param endUserId
     * @return
     */
    private List<EndUserSession> getAllActiveUserSession(int endUserId) {
        EndUserSessionExample endUserSessionExample = new EndUserSessionExample();
        EndUserSessionExample.Criteria criteria = endUserSessionExample.createCriteria();
        criteria.andIdEqualTo(endUserId);
        criteria.andIsLogoutEqualTo(false);
        criteria.andIsActiveEqualTo(true);
        return endUserSessionMapper.selectByExample(endUserSessionExample);
    }
}
