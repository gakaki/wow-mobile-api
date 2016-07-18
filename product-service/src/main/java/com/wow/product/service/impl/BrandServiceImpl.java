package com.wow.product.service.impl;

import com.wow.product.mapper.BrandMapper;
import com.wow.product.model.Brand;
import com.wow.product.model.BrandExample;
import com.wow.product.model.Designer;
import com.wow.product.model.Product;
import com.wow.product.service.BrandService;
import com.wow.product.service.DesignerService;
import com.wow.product.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/18.
 */
@Service
@Transactional(value = "productTransactionManager")
public class BrandServiceImpl implements BrandService {

    private static final Logger logger = LoggerFactory.getLogger(BrandServiceImpl.class);

    @Autowired
    private BrandMapper brandMapper;
     @Autowired
     private ProductService productService;
    @Autowired
    private DesignerService designerService;
    //Table: brand

    /**
     * 创建品牌
     *
     * @param brand
     * @return
     */
    public int createBrand(Brand brand) {
        return brandMapper.insertSelective(brand);
    }

    /**
     * 更新品牌
     *
     * @param brand
     * @return
     */
    public int updateBrand(Brand brand) {
        return brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public Brand getBrandById(int brandId) {
        return brandMapper.selectByPrimaryKey(brandId);
    }

    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Brand> getBrandById(List<Integer> brandIds)
    {
        BrandExample brandExample=new BrandExample();
        brandExample.or().andIdIn(brandIds);
        return brandMapper.selectByExample(brandExample);
    }
    /**
     * 根据首字母查询品牌
     *
     * @param firstLetter
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Brand> getBrandsByFirstLetter(String firstLetter) {
        BrandExample brandExample=new BrandExample();
        brandExample.or().andBrandNameFirstLetterEqualTo(firstLetter);
        return brandMapper.selectByExample(brandExample);
    }

    /**
     * 查询所有品牌
     *
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Brand> getAllBrands() {
        return brandMapper.selectAll();
    }

    /**
     * 查看品牌产品列表
     *
     * @param brand
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Product> getProductsByBrand(Brand brand) {
        if(brand!=null)
        return productService.getProductByBrandId(brand.getId());
        return null;
    }

    /**
     * 查看品牌设计师列表
     *
     * @param brand
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Designer> getDesignersByBrand(Brand brand) throws Exception {
        List<Product> products=getProductsByBrand(brand);
        List<Designer> designers=new ArrayList<>();
        if(!products.isEmpty())
            for(Product product:products)
            {
                designers.addAll(designerService.getDesignersByProduct(product));
            }
        return  designers;
    }

}
