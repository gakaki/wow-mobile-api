package com.wow.product.service.impl;

import com.wow.product.model.Warehouse;
import com.wow.product.service.WarehouseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fangying@wowdsgn on 2016/7/4.
 */
@Service
@Transactional(value = "productTransactionManager")
public class WarehouseServiceImpl implements WarehouseService {
    @Override
    public int createWarehouse(Warehouse warehouse) {
        return 0;
    }

    @Override
    public int updateWarehouse(Warehouse warehouse) {
        return 0;
    }

    @Override
    public int deleteWarehouse(Warehouse warehouse) {
        return 0;
    }

    @Override
    public Warehouse getWarehouseById(Warehouse warehouse) {
        return null;
    }

    @Override
    public Warehouse getWarehouseByName(Warehouse warehouse) {
        return null;
    }

    @Override
    public List<Warehouse> getAllWarehouses(Warehouse warehouse) {
        return null;
    }
}
