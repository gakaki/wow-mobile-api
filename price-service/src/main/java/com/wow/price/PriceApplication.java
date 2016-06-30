package com.wow.price;

import com.wow.price.model.ProductPrice;
import com.wow.price.service.PriceService;
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
@MapperScan("com.wow.price.mapper")
public class PriceApplication {

    private static final Logger logger = LoggerFactory.getLogger(PriceApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PriceApplication.class, args);
    }

    @Autowired
    private PriceService priceService;

    @RequestMapping(value = "/test-price/{productId}", method = RequestMethod.GET)
    public ProductPrice getOrderById(@PathVariable Integer productId) {
        logger.info("accept request:" + productId);
        return priceService.queryProductPrice(productId);
    }

//    @Bean(name = "priceDataSource")
//    @Primary
//    @ConfigurationProperties(prefix = "spring.datasource.price")
//    public DataSource priceDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "priceSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory priceSqlSessionFactory(@Qualifier("priceDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/price/*Mapper.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "priceTransactionManager")
//    @Primary
//    public DataSourceTransactionManager priceTransactionManager(@Qualifier("priceDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "priceSqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate priceSqlSessionTemplate(@Qualifier("priceSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}