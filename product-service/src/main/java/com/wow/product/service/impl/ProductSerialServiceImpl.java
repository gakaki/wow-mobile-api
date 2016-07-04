package com.wow.product.service.impl;

import com.wow.product.mapper.ProductSerialMapper;
import com.wow.product.model.ProductSerial;
import com.wow.product.service.ProductSerialService;
import com.wow.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.*;
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
        return productSerialMapper.insertBatch(productSerials);
    }

    /**
     * 更新系列产品
     * @param productSerials
     * @return
     */
    @Override
    public int updateProductSerial(List<ProductSerial> productSerials) {
        for (ProductSerial ps:productSerials) {
            productSerialMapper.updateByPrimaryKey(ps);
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
        return productSerialMapper.selectByProductId(productId);

    }

    /**
     * 删除系列产品
     * @param productSerials
     * @return
     */
    @Override
    public int deleteProductSerial(List<ProductSerial> productSerials) {
        return productSerialMapper.deleteBatch(productSerials);
    }

    /**
     * 根据产品ID删除
     * @param productId
     * @return
     */
    public  int deleteProductSerial(int productId)
    {
        return  productSerialMapper.deleteByProductId(productId);
    }

    /**
     * 判断产品是否系列主品
     *
     * @param productId
     * @return
     */
    @Override
    public boolean isProductSerial(int productId) {
           if(getProductSerials(productId)!=null &&getProductSerials(productId).size()>0)
               return  true;
        return false;
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
