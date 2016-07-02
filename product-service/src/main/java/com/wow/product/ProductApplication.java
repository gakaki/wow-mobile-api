package com.wow.product;

import com.wow.product.model.Product;
import com.wow.product.service.ProductService;
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
@MapperScan("com.wow.product.mapper")
public class ProductApplication {

    private static final Logger logger = LoggerFactory.getLogger(ProductApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @Autowired
    private ProductService productService;

    @RequestMapping(value = "/test-product/{productId}", method = RequestMethod.GET)
    public Product getProductById(@PathVariable Integer productId) {
        logger.info("accept request:" + productId);
        return productService.getProductById(productId);
    }

//    @Bean(name = "productDataSource")
//    @Primary
//    @ConfigurationProperties(prefix = "wow.datasource.product")
//    public DataSource productDataSource() {
//        return DataSourceBuilder.create().build();
//    }
//
//    @Bean(name = "productSqlSessionFactory")
//    @Primary
//    public SqlSessionFactory productSqlSessionFactory(@Qualifier("productDataSource") DataSource dataSource) throws Exception {
//        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
//        bean.setDataSource(dataSource);
//        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/product/*Mapper.xml"));
//        return bean.getObject();
//    }
//
//    @Bean(name = "productTransactionManager")
//    @Primary
//    public DataSourceTransactionManager productTransactionManager(@Qualifier("productDataSource") DataSource dataSource) {
//        return new DataSourceTransactionManager(dataSource);
//    }
//
//    @Bean(name = "productSqlSessionTemplate")
//    @Primary
//    public SqlSessionTemplate productSqlSessionTemplate(@Qualifier("productSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
//        return new SqlSessionTemplate(sqlSessionFactory);
//    }
}