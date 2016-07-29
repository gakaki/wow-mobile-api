package com.wow.product.service.impl;

import com.wow.common.util.ErrorCodeUtil;
import com.wow.product.mapper.BrandMapper;
import com.wow.product.model.Brand;
import com.wow.product.model.BrandExample;
import com.wow.product.service.BrandService;
import com.wow.product.vo.BrandVo;
import com.wow.product.vo.response.ProductBrandResponse;
import com.wow.product.vo.response.ProductBrandVoResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    /**
     *
     * @param brandId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public ProductBrandResponse getBrandById(int brandId) {
    	ProductBrandResponse productBrandResponse = new ProductBrandResponse();
        Brand brand = brandMapper.selectByPrimaryKey(brandId);
        brand.setBrandLogoImg(brand.getBrandLogoImg());
    	productBrandResponse.setBrand(brand);
        return productBrandResponse;
    }

    /**
     *
     * @param brandId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public ProductBrandVoResponse getBrandVoById(Integer brandId) {
    	ProductBrandVoResponse productBrandVoResponse = new ProductBrandVoResponse();
    	
        if (brandId == null) {
        	productBrandVoResponse.setResCode("40204");
        	productBrandVoResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40204"));
            return productBrandVoResponse;
        }
    	
    	Brand brand = brandMapper.selectByPrimaryKey(brandId);
    	BrandVo brandVo = new BrandVo();
    	
    	if(brand!=null){
    		brandVo.setId(brand.getId());
    		brandVo.setBrandCname(brand.getBrandCname());
    		brandVo.setBrandEname(brand.getBrandEname());
    		brandVo.setBrandLogoImg(brand.getBrandLogoImg());
    		brandVo.setBrandDesc(brand.getBrandDesc());
    	}
    	
    	productBrandVoResponse.setBrandVo(brandVo);
        return productBrandVoResponse;
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
    public ProductBrandResponse getAllBrands() {
    	ProductBrandResponse productBrandResponse = new ProductBrandResponse();
    	productBrandResponse.setBrandList(brandMapper.selectAll());
    	return productBrandResponse;
    }

    /**
     * 查询所有品牌首字母
     *
     * @return
     */
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public ProductBrandResponse selectBrandFirstLetter(){
    	ProductBrandResponse productBrandResponse = new ProductBrandResponse();
    	productBrandResponse.setBrandFirstLetterList(brandMapper.selectBrandFirstLetter());
    	return productBrandResponse;
    }

}
