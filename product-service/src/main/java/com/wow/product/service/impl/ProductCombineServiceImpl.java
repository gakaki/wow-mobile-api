package com.wow.product.service.impl;

import com.wow.product.mapper.ProductCombineMapper;
import com.wow.product.model.ProductCombine;
import com.wow.product.model.ProductComment;
import com.wow.product.service.ProductCombineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by fangying@wowdsgn on 2016/7/4.
 */
@Service
@Transactional(value = "productTransactionManager")
public class ProductCombineServiceImpl  implements ProductCombineService{
    @Autowired
    ProductCombineMapper productCombineMapper;
    //table: product_combine
    /**
     * 创建组合产品
     *
     * @param productCombines
     * @return
     */
    @Override
    public int createProductCombines(List<ProductCombine> productCombines) {
        return  productCombineMapper.insertBatch(productCombines);
    }

    @Override
    public int addProductIntoCombine(ProductCombine productCombine) {
        return productCombineMapper.insert(productCombine);
    }

    @Override
    public int updateProductCombines(List<ProductCombine> productCombines) {
        if(CollectionUtils.isEmpty(productCombines))
            return  0;
        productCombines.forEach(o->productCombineMapper.updateByPrimaryKey(o));
        return 0;
    }

    @Override
    public int removeProductFromCombine(ProductCombine productCombine) {
        Assert.notNull(productCombine,"入参是null");
        return productCombineMapper.deleteByPrimaryKey(productCombine.getId());
    }

    @Override
    public boolean isProductCombine(int productId) {
        List<ProductCombine> lists=productCombineMapper.selectByProductId(productId);
        return !CollectionUtils.isEmpty(lists);
    }
    /**
     * 根据组合主品,查找组合子品信息
     *
     * @param productId 组合品ID
     * @return List<ProductCombine> 子品列表
     */
    @Override
    public List<ProductCombine> getSubProductInfo(int productId) {
        List<ProductCombine> lists= productCombineMapper.selectByProductId(productId);

        if(!CollectionUtils.isEmpty(lists))
        {
            List<ProductCombine> resultLists=new ArrayList<>();
            HashSet set=new HashSet();
            lists.stream().forEach(o->set.add(o.getSubProductId()));
            set.stream().forEach(o-> resultLists.addAll(productCombineMapper.selectByProductId((Integer) o)));
            return resultLists;
        }

        return null;
    }


}
