package com.wow.user;

import com.wow.user.model.EndUser;
import com.wow.user.service.SessionService;
import com.wow.user.service.UserService;
import com.wow.user.vo.LoginRequest;
import com.wow.user.vo.LoginResult;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.Date;

/**
 * Created by zhengzhiqing on 16/6/18.
 */
@SpringBootApplication
@RestController
public class UserApplication {

    private static final Logger logger = LoggerFactory.getLogger(UserApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Autowired
    private UserService userService;
    @Autowired
    private SessionService sessionService;

    /**
     * 用户注册
     * @param endUser
     * @return
     */
    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public String register(@Validated @RequestBody EndUser endUser) {
        String registerResult = "";
        //先根据用户名查找是否已经注册过
        if (userService.isExistedUser(endUser.getUserName())) {
            logger.info("existed user try to register...");
            registerResult = "您已经注册过,请直接登录";
        } else {
            logger.info("user register...");
            endUser.setIsDeleted(false);
            endUser.setRegisterTime(new Date());
            int i = userService.register(endUser);
            if (i > 0) {
                registerResult = "注册成功,请登录";
            } else {
                registerResult = "注册失败,请重试";
            }
        }
        return registerResult;
    }

    /**
     * 查询用户
     * @param endUserId
     * @return
     */
    @RequestMapping(value = "/users/{endUserId}", method = RequestMethod.GET)
    public EndUser selectUserById(@PathVariable Integer endUserId) {
        logger.info("getUser:" + endUserId);
        EndUser endUser = userService.getEndUserById(endUserId);
        logger.info("endUser=" + endUser);
        return endUser;
    }

    /**
     * 用户登录
     * @param loginRequest
     * @return
     */
    @RequestMapping(value = "/sessions", method = RequestMethod.POST)
    public LoginResult login(@Validated @RequestBody LoginRequest loginRequest) {
        logger.info("user login...");
        return sessionService.login(loginRequest);
    }

    /**
     * 用户登出
     * @param endUserId
     * @param loginChannel
     * @return
     */
    @RequestMapping(value = "/sessions/{endUserId}/{loginChannel}", method = RequestMethod.DELETE)
    public int logout(@PathVariable int endUserId, @PathVariable byte loginChannel) {
        logger.info("user logout...");
        return sessionService.logout(endUserId, loginChannel);
    }

    /**
     * 验证会话token
     * @param sessionToken
     * @param loginChannel
     * @return
     */
    @RequestMapping(value = "/sessions/validation/{sessionToken}/{loginChannel}", method = RequestMethod.GET)
    public boolean isValidSession(@PathVariable String sessionToken,
                                      @PathVariable byte loginChannel) {
        logger.info("is valid session?");
        return sessionService.isValidSessionToken(sessionToken, loginChannel);
    }

}