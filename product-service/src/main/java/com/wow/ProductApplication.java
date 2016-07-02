package com.wow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApplication {

    private static final Logger logger = LoggerFactory.getLogger(ProductApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
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