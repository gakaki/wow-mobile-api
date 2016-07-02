package com.wow.marketing;

import com.wow.marketing.model.Coupon;
import com.wow.marketing.service.CouponService;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableTransactionManagement
@MapperScan("com.wow.marketing.mapper")
public class MarketingApplication {

    private static final Logger logger = LoggerFactory.getLogger(MarketingApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MarketingApplication.class, args);
    }

    @Autowired
    private CouponService couponService;

    @RequestMapping(value = "/test-marketing/{couponId}", method = RequestMethod.GET)
    public Coupon getCouponById(@PathVariable Integer couponId) {
        logger.info("accept request:" + couponId);
        return couponService.getCouponById(couponId);
    }

//    @Bean(name = "marketingDataSource")
//    @Primary
//    @ConfigurationProperties(prefix = "wow.datasource.marketing")
//    public DataSource marketingDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "marketingSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory marketingSqlSessionFactory(@Qualifier("marketingDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/marketing/*Mapper.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "marketingTransactionManager")
//    @Primary
//    public DataSourceTransactionManager marketingTransactionManager(@Qualifier("marketingDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "marketingSqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate marketingSqlSessionTemplate(@Qualifier("marketingSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}