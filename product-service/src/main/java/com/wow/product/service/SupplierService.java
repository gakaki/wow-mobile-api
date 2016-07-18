package com.wow.product.service;


import com.wow.product.model.*;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/17.
 */
public interface SupplierService {

    //table: supplier
    /**
     * 创建供应商
     *
     * @param supplier
     * @return
     */
    int createSupplier(Supplier supplier);

    /**
     * 查询供应商
     *
     * @param supplierId
     * @return
     */
    Supplier getSupplierById(int supplierId);

    /**
     * 查询供应商
     *
     * @param supplierName
     * @return
     */
    Supplier getSupplierByName(String supplierName) throws Exception ;

    /**
     * 查询所有供应商
     * @return
     */
    List<Supplier> getAllSuppliers();

    /**
     * 查询供应商供应品牌
     * @return
     */
    List<Brand> getBrandsBySupplier(int supplierId);

    /**
     * 更新供应商
     *
     * @param supplier
     * @return
     */
    int updateSupplier(Supplier supplier);

    /**
     * 删除供应商
     *
     * @param supplier
     * @return
     */
    int deleteSupplier(Supplier supplier);

    //table: product_supplier
    /**
     * 创建产品的供应商
     *
     * @param productSupplier
     * @return
     */
    int createProductSupplier(ProductSupplier productSupplier);

    /**
     * 根据产品查询供应商
     *
     * @param productId
     * @return
     */
    int getProductSupplier(int productId) throws Exception;

    /**
     * 根据供应商查询产品
     *
     * @param supplierId
     * @return
     */
    List<Product> getProductsBySupplier(int supplierId);


    /**
     * 更新产品供应商信息,如到货周期,销售类型等
     *
     * @param productSupplier
     * @return
     */
    int updateProductSupplier(ProductSupplier productSupplier);

    //table: product_supply_log

    /**
     * 创建供货记录
     *
     * @param productSupplyLog
     * @return
     */
    int createProductSupplyLog(ProductSupplyLog productSupplyLog);

    /**
     * 查看产品的供货记录
     *
     * @param productId
     * @return
     */
    List<ProductSupplyLog> getSupplyLogsByProduct(int productId);

    /**
     * 查看供应商的供货记录
     *
     * @param supplierId
     * @return
     */
    List<ProductSupplyLog> getSupplyLogsBySupplier(int supplierId);

}
