package com.wow.marketing.config;

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
@PropertySource("classpath:ds_marketing.properties")
@EnableTransactionManagement
@MapperScan(basePackages ="com.wow.marketing.mapper",sqlSessionFactoryRef="marketingSqlSessionFactory")
public class MarketingDSConfig {

    @Bean(name = "marketingDataSource")
    @ConfigurationProperties(prefix = "wow.datasource.marketing")
    public DataSource marketingDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "marketingSqlSessionFactory")
    @Autowired
    @Qualifier("marketingDataSource")
    public SqlSessionFactory marketingSqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/marketing/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "marketingTransactionManager")
    @Autowired
    @Qualifier("marketingDataSource")
    public DataSourceTransactionManager marketingTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "marketingSqlSessionTemplate")
    @Autowired
    @Qualifier("marketingSqlSessionFactory")
    public SqlSessionTemplate marketingSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}