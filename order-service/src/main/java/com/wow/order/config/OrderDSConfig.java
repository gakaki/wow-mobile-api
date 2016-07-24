package com.wow.order.config;

import javax.sql.DataSource;

import org.apache.ibatis.plugin.Interceptor;
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

import com.wow.common.page.PagePlugin;

@Configuration
@PropertySource("classpath:ds_order.properties")
@EnableTransactionManagement
@MapperScan(basePackages = "com.wow.order.mapper", sqlSessionFactoryRef = "orderSqlSessionFactory")
public class OrderDSConfig {

    @Bean(name = "orderDataSource")
    @ConfigurationProperties(prefix = "wow.datasource.order")
    public DataSource orderDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "orderSqlSessionFactory")
    public SqlSessionFactory orderSqlSessionFactory(@Qualifier("orderDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
            .getResources("classpath:/mapper/order/*Mapper.xml"));

        //加入分页插件
        PagePlugin pagePlugin=new PagePlugin();
        pagePlugin.setDialect("mysql");
        pagePlugin.setPageSqlId(".*ListPage.*"); //以listPage结尾
        
        bean.setPlugins(new Interceptor[] {pagePlugin});

        return bean.getObject();
    }

    @Bean(name = "orderTransactionManager")
    public DataSourceTransactionManager orderTransactionManager(@Qualifier("orderDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "orderSqlSessionTemplate")
    public SqlSessionTemplate orderSqlSessionTemplate(@Qualifier("orderSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}