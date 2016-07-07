package com.wow.product.service;

import java.util.List;

import com.wow.product.model.Brand;
import com.wow.product.model.Designer;
import com.wow.product.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 品牌服务
 * <p>
 * Created by zhengzhiqing on 16/6/16.
 */
public interface BrandService {
    //Table: brand

    /**
     * 创建品牌
     *
     * @param brand
     * @return
     */
    int createBrand(Brand brand);

    /**
     * 更新品牌
     *
     * @param brand
     * @return
     */
    int updateBrand(Brand brand);

    Brand getBrandById(int brandId);
    /**
     * 根据首字母查询品牌
     *
     * @param firstLetter
     * @return
     */
    List<Brand> getBrandsByFirstLetter(String firstLetter);

    /**
     * 查询所有品牌
     *
     * @return
     */
    List<Brand> getAllBrands();

    /**
     * 查看品牌产品列表
     *
     * @param brand
     * @return
     */
    List<Product> getProductsByBrand(Brand brand);

    /**
     * 查看品牌设计师列表
     *
     * @param brand
     * @return
     */
    List<Designer> getDesignersByBrand(Brand brand);

}