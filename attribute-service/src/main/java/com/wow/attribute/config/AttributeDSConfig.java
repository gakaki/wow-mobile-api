package com.wow.attribute.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
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
@PropertySource("classpath:ds_attribute.properties")
@EnableTransactionManagement
@MapperScan(basePackages ="com.wow.attribute.mapper",sqlSessionFactoryRef="attributeSqlSessionFactory")
public class AttributeDSConfig {

    @Bean(name = "attributeDataSource")
    @ConfigurationProperties(prefix = "wow.datasource.attribute")
    public DataSource attributeDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "attributeSqlSessionFactory")
    public SqlSessionFactory attributeSqlSessionFactory(
            @Qualifier("attributeDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:/mapper/attribute/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "attributeTransactionManager")
    public DataSourceTransactionManager attributeTransactionManager(
            @Qualifier("attributeDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "attributeSqlSessionTemplate")
    public SqlSessionTemplate attributeSqlSessionTemplate(
            @Qualifier("attributeSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}