package com.wow.product.service.impl;

import com.wow.product.model.Brand;
import com.wow.product.model.Designer;
import com.wow.product.model.Product;
import com.wow.product.service.BrandService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/18.
 */
@Service
public class BrandServiceImpl implements BrandService {

//    @Autowired
//    BrandMapper brandMapper;

    //Table: brand

    /**
     * 创建品牌
     *
     * @param brand
     * @return
     */
    public int createBrand(Brand brand) {
        return 0;
    }

    /**
     * 更新品牌
     *
     * @param brand
     * @return
     */
    public int updateBrand(Brand brand) {
        return 0;
    }

    /**
     * 根据首字母查询品牌
     *
     * @param firstLetter
     * @return
     */
    public List<Brand> getBrandsByFirstLetter(String firstLetter) {
        System.out.println("BrandServiceImpl:getBrandsByFirstLetter:" + firstLetter);
        List<Brand> brands = new ArrayList<Brand>();
        Brand brand1 = new Brand();
        brand1.setId(1);
        brand1.setBrandName(firstLetter + 1);
        Brand brand2 = new Brand();
        brand2.setId(2);
        brand2.setBrandName(firstLetter + 2);
        brands.add(brand1);
        brands.add(brand2);
        System.out.println("BrandServiceImpl:getBrandsByFirstLetter:" + brands);
        return brands;
    }

    /**
     * 查询所有品牌
     *
     * @return
     */
    public List<Brand> getAllBrands() {
        return null;
    }

    /**
     * 查看品牌产品列表
     *
     * @param brand
     * @return
     */
    public List<Product> getProductsByBrand(Brand brand) {
        return null;
    }

    /**
     * 查看品牌设计师列表
     *
     * @param brand
     * @return
     */
    public List<Designer> getDesignersByBrand(Brand brand) {
        return null;
    }

}
