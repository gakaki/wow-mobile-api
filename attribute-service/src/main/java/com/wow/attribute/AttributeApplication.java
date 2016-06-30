package com.wow.attribute;

import com.wow.attribute.model.Attribute;
import com.wow.attribute.model.Category;
import com.wow.attribute.service.AttributeService;
import com.wow.attribute.service.CategoryService;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/18.
 */

@SpringBootApplication
@RestController
@EnableTransactionManagement
@MapperScan("com.wow.attribute.mapper")
public class AttributeApplication {
    public static void main(String[] args) {
        SpringApplication.run(AttributeApplication.class, args);
    }

    @Autowired
    private AttributeService attributeService;

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/test-attribute/{attributeId}", method = RequestMethod.GET)
    public Attribute selectAttributeById(@PathVariable Integer attributeId) {
        //中文乱码问题
        System.out.println("accept request:" + attributeId);
        List<Attribute> attributes=new ArrayList<>();
        Attribute attribute1=new Attribute();
        attribute1.setCreateTime(new java.util.Date());
        attribute1.setUpdateTime(new java.util.Date());
        attribute1.setCreateBy("fangy");
        attribute1.setIsDeleted(false);
        attribute1.setAttributeName("ac1");
        attribute1.setAttributeValueType(new Byte((byte)0));
        attribute1.setCanMultipleSelected(false);
        attribute1.setDecimalPlace(new Byte((byte)0));
        attribute1.setShowName("");
        attribute1.setUpdateBy("");
        attributes.add(attribute1);

        Attribute attribute2=new Attribute();
        attribute2.setCreateTime(new java.util.Date());
        attribute2.setUpdateTime(new java.util.Date());
        attribute2.setCreateBy("fangy");
        attribute2.setIsDeleted(false);
        attribute2.setAttributeName("ac2");
        attribute2.setAttributeValueType(new Byte((byte)0));
        attribute2.setCanMultipleSelected(false);
        attribute2.setDecimalPlace(new Byte((byte)0));
        attribute2.setShowName("");
        attribute2.setUpdateBy("");
        attributes.add(attribute2);
        attributeService.addAttributesInCategory(389,attributes);
        return null;
    }
    @RequestMapping(value = "/test-category/{attributeId}", method = RequestMethod.GET)
    public Category selectCategoryById(@PathVariable Integer attributeId) {
        categoryService.deleteByPrimaryKey(attributeId);
        return  null;
    }

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