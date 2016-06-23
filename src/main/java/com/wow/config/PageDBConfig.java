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
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@EnableAutoConfiguration
@MapperScan("com.wow.page.mapper")
public class PageDBConfig {

    @Bean(name = "pageDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.page")
    public DataSource pageDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "pageSqlSessionFactory")
    public SqlSessionFactory pageSqlSessionFactory(@Qualifier("pageDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/page/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "pageTransactionManager")
    public DataSourceTransactionManager pageTransactionManager(@Qualifier("pageDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "pageSqlSessionTemplate")
    public SqlSessionTemplate pageSqlSessionTemplate(@Qualifier("pageSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}