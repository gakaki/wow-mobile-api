package com.wow.price.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:ds_price.properties")
@EnableTransactionManagement
@MapperScan(basePackages ="com.wow.price.mapper",sqlSessionFactoryRef="priceSqlSessionFactory")
public class PriceDSConfig {

    @Bean(name = "priceDataSource")
    @ConfigurationProperties(prefix = "wow.datasource.price")
    public DataSource priceDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "priceSqlSessionFactory")
    @Autowired
    @Qualifier("priceDataSource")
    public SqlSessionFactory priceSqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/price/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "priceTransactionManager")
    @Autowired
    @Qualifier("priceDataSource")
    public DataSourceTransactionManager priceTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "priceSqlSessionTemplate")
    @Autowired
    @Qualifier("priceSqlSessionFactory")
    public SqlSessionTemplate priceSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}