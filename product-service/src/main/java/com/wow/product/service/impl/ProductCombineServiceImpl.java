package com.wow.product.service.impl;

import com.wow.product.mapper.ProductCombineMapper;
import com.wow.product.model.ProductCombine;
import com.wow.product.model.ProductCombineExample;
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
        if(!CollectionUtils.isEmpty(productCombines))
            productCombines.forEach(o->productCombineMapper.insertSelective(o));
        return 0;
    }

    @Override
    public int addProductIntoCombine(ProductCombine productCombine) {
        if(productCombine!=null)
          return productCombineMapper.insertSelective(productCombine);
        return 0;
    }

    @Override
    public int updateProductCombines(List<ProductCombine> productCombines) {
        if(!CollectionUtils.isEmpty(productCombines))
        productCombines.forEach(o->productCombineMapper.updateByPrimaryKeySelective(o));
        return 0;
    }

    @Override
    public int removeProductFromCombine(ProductCombine productCombine) {
        Assert.notNull(productCombine,"入参是null");
        productCombine.setIsDeleted(true);
        return productCombineMapper.updateByPrimaryKeySelective(productCombine);
    }

    @Override
    public boolean isProductCombine(int productId) {

        return getProductCombineByProductId(productId).isEmpty();
    }

    private List<ProductCombine> getProductCombineByProductId(int productId) {
        ProductCombineExample productCombineExample=new ProductCombineExample();
        ProductCombineExample.Criteria criteria=productCombineExample.createCriteria();
        criteria.andProductIdEqualTo(productId);
        criteria.andIsDeletedEqualTo(false);
       return  productCombineMapper.selectByExample(productCombineExample);

    }

    /**
     * 根据组合主品,查找组合子品信息
     *
     * @param productId 组合品ID
     * @return List<ProductCombine> 子品列表
     */
    @Override
    public List<ProductCombine> getSubProductInfo(int productId) {

        List<ProductCombine> lists= getProductCombineByProductId(productId);
        if(!CollectionUtils.isEmpty(lists))
        {
            List<ProductCombine> resultLists=new ArrayList<>();
            HashSet<Integer> set=new HashSet();
            lists.forEach(o->set.add(o.getSubProductId()));
            set.forEach(o-> resultLists.addAll(getProductCombineByProductId(o)));
            return resultLists;
        }
        return null;
    }


}
