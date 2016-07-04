package com.wow.product.service.impl;

import com.wow.product.model.*;
import com.wow.product.service.SupplierService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fangying@wowdsgn on 2016/7/4.
 */
@Service
@Transactional(value = "productTransactionManager")
public class SupplierServiceImpl implements SupplierService {
    @Override
    public int createSupplier(Supplier supplier) {
        return 0;
    }

    @Override
    public Supplier getSupplierById(int supplierId) {
        return null;
    }

    @Override
    public Supplier getSupplierByName(String supplierName) {
        return null;
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
        return 0;
    }

    @Override
    public int deleteSupplier(Supplier supplier) {
        return 0;
    }

    @Override
    public int createProductSupplier(ProductSupplier productSupplier) {
        return 0;
    }

    @Override
    public int getProductSupplier(int productId) {
        return 0;
    }

    @Override
    public List<Product> getProductsBySupplier(int supplierId) {
        return null;
    }

    @Override
    public int updateProductSupplier(ProductSupplier productSupplier) {
        return 0;
    }

    @Override
    public int createProductSupplyLog(ProductSupplyLog productSupplyLog) {
        return 0;
    }

    @Override
    public List<ProductSupplyLog> getSupplyLogsByProduct(int productId) {
        return null;
    }

    @Override
    public List<ProductSupplyLog> getSupplyLogsBySupplier(int supplierId) {
        return null;
    }
}
