package com.wow.product.service.impl;

import com.wow.product.mapper.ProductSupplierMapper;
import com.wow.product.mapper.ProductSupplyLogMapper;
import com.wow.product.mapper.SupplierBrandMapper;
import com.wow.product.mapper.SupplierMapper;
import com.wow.product.model.*;
import com.wow.product.service.BrandService;
import com.wow.product.service.ProductService;
import com.wow.product.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

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
    @Autowired
    private BrandService brandService;
    @Autowired
    private SupplierBrandMapper supplierBrandMapper;
    @Override
    public int createSupplier(Supplier supplier) {

        return supplierMapper.insertSelective(supplier);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public Supplier getSupplierById(int supplierId) {
        return supplierMapper.selectByPrimaryKey(supplierId);
    }



    @Transactional(propagation= Propagation.SUPPORTS)
    public Supplier getSupplierByName(String supplierName) throws Exception {

        SupplierExample supplierExample=new SupplierExample();
        SupplierExample.Criteria criteria=supplierExample.createCriteria();
        criteria.andSupplierNameEqualTo(supplierName);
        criteria.andIsDeletedEqualTo(false);
        return supplierMapper.selectByExample(supplierExample).get(0);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Supplier> getAllSuppliers() {
        return supplierMapper.selectAll();
    }

    /**
     * 查询供应商供应品牌
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Brand> getBrandsBySupplier(int supplierId) {
        SupplierBrandExample supplierBrandExample=new SupplierBrandExample();
        supplierBrandExample.or().andSupplierIdEqualTo(supplierId).andIsDeleteNotEqualTo(false);
        List< SupplierBrand> supplierBrands=supplierBrandMapper.selectByExample(supplierBrandExample);
        if(!supplierBrands.isEmpty()) {
            HashSet<Integer> set=new HashSet<>();
            for(SupplierBrand supplierBrand:supplierBrands)
            {
                set.add(supplierBrand.getBrandId());
            }
            return brandService.getBrandById(new ArrayList(set));
        }
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
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public int getProductSupplier(int productId) throws Exception {

             ProductSupplierExample productSupplierExample=new ProductSupplierExample();
             ProductSupplierExample.Criteria criteria=productSupplierExample.createCriteria();
             criteria.andProductIdEqualTo(productId);
             criteria.andIsDeletedEqualTo(false);
             return productSupplierMapper.selectByExample(productSupplierExample)
                    .get(0).getSupplierId();

    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Product> getProductsBySupplier(int supplierId) {

        ProductSupplierExample productSupplierExample = new ProductSupplierExample();
        ProductSupplierExample.Criteria criteria = productSupplierExample.createCriteria();
        criteria.andSupplierIdEqualTo(supplierId);
        criteria.andIsDeletedEqualTo(false);
        List<ProductSupplier> list = productSupplierMapper.selectByExample(productSupplierExample);
        if (!list.isEmpty()) {
            HashSet<Integer> productIds = new HashSet<>();
            for(ProductSupplier productSupplier:list)
            {
                productIds.add(productSupplier.getProductId());
            }
            return  productService.getProductById(new ArrayList<Integer>(productIds));
        }
        return  null;
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
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<ProductSupplyLog> getSupplyLogsByProduct(int productId) {
        ProductSupplyLogExample productSupplyLogExample=new ProductSupplyLogExample();
        ProductSupplyLogExample.Criteria criteria=productSupplyLogExample.createCriteria();
        criteria.andProductIdEqualTo(productId);
        criteria.andIsDeletedEqualTo(false);
        return productSupplyLogMapper.selectByExample(productSupplyLogExample);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<ProductSupplyLog> getSupplyLogsBySupplier(int supplierId) {
        ProductSupplyLogExample productSupplyLogExample=new ProductSupplyLogExample();
        ProductSupplyLogExample.Criteria criteria=productSupplyLogExample.createCriteria();
        criteria.andSupplierIdEqualTo(supplierId);
        criteria.andIsDeletedEqualTo(false);
        return productSupplyLogMapper.selectByExample(productSupplyLogExample);
    }
}
