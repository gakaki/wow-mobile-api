package com.wow.page;

import org.mybatis.spring.annotation.MapperScan;
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
@MapperScan("com.wow.page.mapper")
public class PageApplication {
    public static void main(String[] args) {
        SpringApplication.run(PageApplication.class, args);
    }

//    @Autowired
//    private CouponService couponService;
//
//    @RequestMapping(value = "/test-page/{couponId}", method = RequestMethod.GET)
//    public Coupon getCouponById(@PathVariable Integer couponId) {
//        logger.info("accept request:" + couponId);
//        return couponService.getCouponById(couponId);
//    }

//    @Bean(name = "pageDataSource")
//    @Primary
//    @ConfigurationProperties(prefix = "wow.datasource.page")
//    public DataSource pageDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "pageSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory pageSqlSessionFactory(@Qualifier("pageDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/page/*Mapper.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "pageTransactionManager")
//    @Primary
//    public DataSourceTransactionManager pageTransactionManager(@Qualifier("pageDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "pageSqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate pageSqlSessionTemplate(@Qualifier("pageSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}