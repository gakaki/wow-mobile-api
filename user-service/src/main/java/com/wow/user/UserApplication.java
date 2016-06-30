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
@EnableTransactionManagement
@MapperScan("com.wow.user.mapper")
public class UserApplication {

    private static final Logger logger = LoggerFactory.getLogger(UserApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

    @Autowired
    private UserService userService;
    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "/test-user/{endUserId}", method = RequestMethod.GET)
    public EndUser selectUserById(@PathVariable Integer endUserId) {
        logger.info("getUser:" + endUserId);
        EndUser endUser = userService.getEndUserById(endUserId);
        logger.info("endUser=" + endUser);
        return endUser;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public LoginResult login(@Validated @RequestBody LoginRequest loginRequest) {
        logger.info("user login...");
        return sessionService.login(loginRequest);
    }

    @RequestMapping(value = "/logout/{endUserId}/{loginChannel}", method = RequestMethod.PUT)
    public int logout(@PathVariable int endUserId, @PathVariable byte loginChannel) {
        logger.info("user logout...");
        return sessionService.logout(endUserId, loginChannel);
    }

    @RequestMapping(value = "/isvalidsession/{sessionToken}/{loginChannel}", method = RequestMethod.GET)
    public boolean isValidSession(@PathVariable String sessionToken,
                                      @PathVariable byte loginChannel) {
        logger.info("is valid session?");
        return sessionService.isValidSessionToken(sessionToken, loginChannel);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
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

//    @Bean(name = "userDataSource")
//    @ConfigurationProperties(prefix = "spring.datasource.user")
//    public DataSource userDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "userSqlSessionFactory")
//    public SqlSessionFactory userSqlSessionFactory(@Qualifier("userDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/user/*Mapper.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "userTransactionManager")
//    public DataSourceTransactionManager userTransactionManager(@Qualifier("userDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "userSqlSessionTemplate")
//    public SqlSessionTemplate userSqlSessionTemplate(@Qualifier("userSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }

}