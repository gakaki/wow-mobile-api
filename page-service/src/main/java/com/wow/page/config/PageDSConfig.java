package com.wow.page.config;

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
@PropertySource("classpath:ds_page.properties")
@EnableTransactionManagement
@MapperScan(basePackages ="com.wow.page.mapper",sqlSessionFactoryRef="pageSqlSessionFactory")
public class PageDSConfig {

    @Bean(name = "pageDataSource")
    @ConfigurationProperties(prefix = "wow.datasource.page")
    public DataSource pageDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "pageSqlSessionFactory")
    @Autowired
    @Qualifier("pageDataSource")
    public SqlSessionFactory pageSqlSessionFactory(DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:/mapper/page/*Mapper.xml"));
        return bean.getObject();
    }

    @Bean(name = "pageTransactionManager")
    @Autowired
    @Qualifier("pageDataSource")
    public DataSourceTransactionManager pageTransactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "pageSqlSessionTemplate")
    @Autowired
    @Qualifier("pageSqlSessionFactory")
    public SqlSessionTemplate pageSqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}