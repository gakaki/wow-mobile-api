package com.wow.product.service.impl;

import com.wow.product.mapper.ProductSupplierMapper;
import com.wow.product.mapper.ProductSupplyLogMapper;
import com.wow.product.mapper.SupplierMapper;
import com.wow.product.model.*;
import com.wow.product.service.ProductService;
import com.wow.product.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by fangying@wowdsgn on 2016/7/4.
 */
@Service
@Transactional(value = "productTransactionManager")
public class SupplierServiceImpl implements SupplierService {
    @Autowired
    private SupplierMapper supplierMapper;
    @Autowired
    private ProductSupplierMapper productSupplierMapper;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductSupplyLogMapper productSupplyLogMapper;
    @Override
    public int createSupplier(Supplier supplier) {

        return supplierMapper.insertSelective(supplier);
    }

    @Override
    public Supplier getSupplierById(int supplierId) {
        return supplierMapper.selectByPrimaryKey(supplierId);
    }

    @Override
    public Supplier getSupplierByName(String supplierName) {
        SupplierExample supplierExample=new SupplierExample();
        SupplierExample.Criteria criteria=supplierExample.createCriteria();
        criteria.andSupplierNameEqualTo(supplierName);
        criteria.andIsDeletedEqualTo(false);
        return supplierMapper.selectByExample(supplierExample).stream().findAny().get();
    }

    @Override
    public List<Supplier> getAllSuppliers() {

        return null;
    }

    @Override
    public List<Brand> getBrandsBySupplier(int supplierId) {
        return null;
    }

    @Override
    public int updateSupplier(Supplier supplier) {
        return supplierMapper.updateByPrimaryKeySelective(supplier);
    }

    @Override
    public int deleteSupplier(Supplier supplier) {
        supplier.setIsDeleted(true);
        return updateSupplier(supplier);
    }

    @Override
    public int createProductSupplier(ProductSupplier productSupplier) {
        return productSupplierMapper.insertSelective(productSupplier);
    }
    /**
     * 根据产品查询供应商
     *
     * @param productId
     * @return
     */
    @Override
    public int getProductSupplier(int productId) {

         try {
             ProductSupplierExample productSupplierExample=new ProductSupplierExample();
             ProductSupplierExample.Criteria criteria=productSupplierExample.createCriteria();
             criteria.andProductIdEqualTo(productId);
             criteria.andIsDeletedEqualTo(false);
             return productSupplierMapper.selectByExample(productSupplierExample)
                     .stream().findAny().get().getSupplierId();
         }
         catch (Exception e)
         {
             e.printStackTrace();
         }
         return 0;

    }

    @Override
    public List<Product> getProductsBySupplier(int supplierId) {
        try{
            ProductSupplierExample productSupplierExample=new ProductSupplierExample();
            ProductSupplierExample.Criteria criteria=productSupplierExample.createCriteria();
            criteria.andSupplierIdEqualTo(supplierId);
            criteria.andIsDeletedEqualTo(false);
          List<ProductSupplier> list=  productSupplierMapper.selectByExample(productSupplierExample);
            List<Product> products=new ArrayList<>();
            if(!list.isEmpty())
                list.forEach(new Consumer<ProductSupplier>() {
                    @Override
                    public void accept(ProductSupplier productSupplier) {
                        Product   product=  productService.getProductById(productSupplier.getProductId());
                        if(product!=null)
                            products.add(product);
                    }
                });
            return products;
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int updateProductSupplier(ProductSupplier productSupplier) {
        return productSupplierMapper.updateByPrimaryKeySelective(productSupplier);
    }

    @Override
    public int createProductSupplyLog(ProductSupplyLog productSupplyLog) {
        return productSupplyLogMapper.insertSelective(productSupplyLog);
    }

    @Override
    public List<ProductSupplyLog> getSupplyLogsByProduct(int productId) {
        ProductSupplyLogExample productSupplyLogExample=new ProductSupplyLogExample();
        ProductSupplyLogExample.Criteria criteria=productSupplyLogExample.createCriteria();
        criteria.andProductIdEqualTo(productId);
        criteria.andIsDeletedEqualTo(false);
        return productSupplyLogMapper.selectByExample(productSupplyLogExample);
    }

    @Override
    public List<ProductSupplyLog> getSupplyLogsBySupplier(int supplierId) {
        ProductSupplyLogExample productSupplyLogExample=new ProductSupplyLogExample();
        ProductSupplyLogExample.Criteria criteria=productSupplyLogExample.createCriteria();
        criteria.andSupplierIdEqualTo(supplierId);
        criteria.andIsDeletedEqualTo(false);
        return productSupplyLogMapper.selectByExample(productSupplyLogExample);
    }
}
