package com.wow.stock.config;

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
@PropertySource("classpath:ds_stock.properties")
@EnableTransactionManagement
@MapperScan(basePackages ="com.wow.stock.mapper",sqlSessionFactoryRef="stockSqlSessionFactory")
public class StockDSConfig {

    @Bean(name = "stockDataSource")
    @ConfigurationProperties(prefix = "wow.datasource.stock")
    public DataSource stockDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "stockSqlSessionFactory")
    public SqlSessionFactory stockSqlSessionFactory(
            @Qualifier("stockDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources("classpath:/mapper/stock/*Mapper.xml"));
        
        //加入分页插件
        PagePlugin pagePlugin=new PagePlugin();
        pagePlugin.setDialect("mysql");
        pagePlugin.setPageSqlId(".*ListPage.*"); //以listPage结尾
        
        bean.setPlugins(new Interceptor[] {pagePlugin});
        
        return bean.getObject();
    }

    @Bean(name = "stockTransactionManager")
    public DataSourceTransactionManager stockTransactionManager(
            @Qualifier("stockDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "stockSqlSessionTemplate")
    public SqlSessionTemplate stockSqlSessionTemplate(
            @Qualifier("stockSqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
}