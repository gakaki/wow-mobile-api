package com.wow.product.service;

import com.wow.product.model.Warehouse;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/24.
 */
public interface WarehouseService {
    /**
     * 创建仓库
     * @return
     */
    int createWarehouse(Warehouse warehouse);

    /**
     * 更新仓库
     * @param warehouse
     * @return
     */
    int updateWarehouse(Warehouse warehouse);

    /**
     * 删除仓库
     * @param warehouse
     * @return
     */
    int deleteWarehouse(Warehouse warehouse);

    /**
     * 根据ID查询仓库
     * @param warehouse
     * @return
     */
    Warehouse getWarehouseById(Warehouse warehouse);

    /**
     * 根据名称查询仓库
     * @param warehouse
     * @return
     */
    Warehouse getWarehouseByName(Warehouse warehouse);

    /**
     * 查询所有仓库
     * @param warehouse
     * @return
     */
    List<Warehouse> getAllWarehouses(Warehouse warehouse);

}
