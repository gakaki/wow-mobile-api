package com.wow.product.service;

import java.util.List;

import com.wow.product.model.Brand;
import com.wow.product.vo.response.ProductBrandAllResponse;
import com.wow.product.vo.response.ProductBrandResponse;
import com.wow.product.vo.response.ProductBrandVoResponse;

/**
 * 品牌服务
 * <p>
 * Created by zhengzhiqing on 16/6/16.
 */
public interface BrandService {

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

    /**
     * 查询品牌
     * @param brandId
     * @return
     */
    ProductBrandResponse getBrandById(int brandId);
    
    /**
     * 查询品牌
     * @param brandId
     * @return
     */
    ProductBrandVoResponse getBrandVoById(Integer brandId);

    /**
     * 批量查询品牌
     * @param brandIds
     * @return
     */
    List<Brand> getBrandById(List<Integer> brandIds);

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
    ProductBrandResponse getAllBrands();
    
    /**
     * 查询所有品牌首字母
    *
    * @return
    */
    ProductBrandResponse selectBrandFirstLetter();
    
    /**
     * 查询所有品牌
     * 移动端调用
     * @return
     */
    ProductBrandAllResponse getAllBrandsList();

}