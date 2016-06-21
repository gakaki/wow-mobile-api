package com.wow.product.service;


import com.wow.product.model.ProductSupplier;
import com.wow.product.model.ProductSupplyLog;
import com.wow.product.model.Supplier;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/17.
 */
public interface SupplierService {
    //table: product_supplier

    /**
     * 创建产品的供应商
     *
     * @param productSupplier
     * @return
     */
    int createProductSupplier(ProductSupplier productSupplier);

    /**
     * 更新产品的供应商 - 应该比较少见
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
    List<ProductSupplyLog> querySupplyLogsByProduct(int productId);

    /**
     * 查看供应商的供货记录
     *
     * @param supplierId
     * @return
     */
    List<ProductSupplyLog> querySupplyLogsBySupplier(int supplierId);

    //table: supplier

    /**
     * 创建供应商
     *
     * @param supplier
     * @return
     */
    int createSupplier(Supplier supplier);

    /**
     * 更新供应商
     *
     * @param supplier
     * @return
     */
    int updateSupplier(Supplier supplier);
}
