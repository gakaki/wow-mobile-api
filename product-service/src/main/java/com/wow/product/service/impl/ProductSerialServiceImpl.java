package com.wow.product.service.impl;

import com.wow.product.mapper.ProductSerialMapper;
import com.wow.product.model.ProductSerial;
import com.wow.product.model.ProductSerialExample;
import com.wow.product.service.ProductSerialService;
import com.wow.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;


import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;


/**
 * Created by fangying@wowdsgn on 2016/7/4.
 */
@Service
@Transactional(value = "productTransactionManager")
public class ProductSerialServiceImpl implements ProductSerialService {

    @Autowired
    ProductSerialMapper productSerialMapper;
    @Autowired
    ProductService productService;

    /**
     * 创建系列产品
     * @param productSerials
     * @return
     */
    @Override
    public int createProductSerial(List<ProductSerial> productSerials) {
        if(!CollectionUtils.isEmpty(productSerials))
            productSerials.forEach(o->productSerialMapper.insert(o));
        return 0;
    }

    /**
     * 更新系列产品
     * @param productSerials
     * @return
     */
    @Override
    public int updateProductSerial(List<ProductSerial> productSerials) {
        if(!CollectionUtils.isEmpty(productSerials))
        {
            productSerials.forEach(o->productSerialMapper.updateByPrimaryKeySelective(o));
        }
        return 0;
    }

    /**
     * 根据系列主品查找所有子品
     * @param productId 产品ID
     * @return
     */
    @Override
    public List<ProductSerial> getProductSerials(int productId) {
        ProductSerialExample productSerialExample=new ProductSerialExample();
        ProductSerialExample.Criteria criteria=productSerialExample.createCriteria();
        criteria.andProductIdEqualTo(productId);
        criteria.andIsDeletedEqualTo(false);
        return productSerialMapper.selectByExample(productSerialExample);

    }

    /**
     * 删除系列产品
     * @param productSerials
     * @return
     */
    @Override
    public int deleteProductSerial(List<ProductSerial> productSerials) {
        if(!CollectionUtils.isEmpty(productSerials))
        {
            productSerials.forEach(new Consumer<ProductSerial>() {
                @Override
                public void accept(ProductSerial productSerial) {
                    productSerial.setIsDeleted(true);
                    productSerialMapper.updateByPrimaryKeySelective(productSerial);
                }
            });
        }
        return 0;
    }

    /**
     * 根据产品ID删除
     * @param productId
     * @return
     */
    public  int deleteProductSerial(int productId)
    {
        ProductSerialExample productSerialExample=new ProductSerialExample();
        ProductSerialExample.Criteria criteria=productSerialExample.createCriteria();
        criteria.andProductIdEqualTo(productId);
        ProductSerial productSerial=new ProductSerial();
        productSerial.setIsDeleted(true);
        return  productSerialMapper.updateByExampleSelective(productSerial,productSerialExample);
    }

    /**
     * 判断产品是否系列主品
     *
     * @param productId
     * @return
     */
    @Override
    public boolean isProductSerial(int productId) {
        List<ProductSerial> productSerials=getProductSerials(productId);
        return !CollectionUtils.isEmpty(productSerials);

    }

    /**
     * 查询系列品的主子品
     *
     * @param productId
     * @return
     */
    @Override
    public ProductSerial getPrimarySubProductOfProductSerial(int productId) {
        return  getProductSerials(productId).stream().filter(o->o.getIsPrimary()==true).findAny().get();
    }

}
