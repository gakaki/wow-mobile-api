package com.wow.product.config;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * Created by fangying@wowdsgn on 2016/7/1.
 */
@Configuration
@MapperScan("com.wow.product.mapper")
public class ProductConfiguration {

    @Bean(name = "productDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.product")
    public DataSource productDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "productSqlSessionFactory")
    @Primary
    public SqlSessionFactory productSqlSessionFactory(@Qualifier("productDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/product/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "productTransactionManager")
    @Primary
    public DataSourceTransactionManager productTransactionManager(@Qualifier("productDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "productSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate productSqlSessionTemplate(@Qualifier("productSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}
