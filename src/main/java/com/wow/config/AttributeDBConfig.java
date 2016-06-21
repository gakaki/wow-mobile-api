package com.wow.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
@MapperScan("com.wow.attribute.mapper")
public class AttributeDBConfig {

    @Bean(name = "attributeDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.attribute")
    public DataSource attributeDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "attributeSqlSessionFactory")
    @Primary
    public SqlSessionFactory attributeSqlSessionFactory(@Qualifier("attributeDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/attribute/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "attributeTransactionManager")
    @Primary
    public DataSourceTransactionManager attributeTransactionManager(@Qualifier("attributeDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "attributeSqlSessionTemplate")
    @Primary
    public SqlSessionTemplate attributeSqlSessionTemplate(@Qualifier("attributeSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}