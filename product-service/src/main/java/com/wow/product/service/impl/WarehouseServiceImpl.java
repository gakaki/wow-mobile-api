package com.wow.product.service.impl;

import com.wow.product.mapper.WarehouseMapper;
import com.wow.product.model.Warehouse;
import com.wow.product.model.WarehouseExample;
import com.wow.product.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by fangying@wowdsgn on 2016/7/4.
 */
@Service
@Transactional(value = "productTransactionManager")
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;
    @Override
    public int createWarehouse(Warehouse warehouse) {
        return warehouseMapper.insertSelective(warehouse);
    }

    @Override
    public int updateWarehouse(Warehouse warehouse) {
        return warehouseMapper.updateByPrimaryKeySelective(warehouse);
    }

    @Override
    public int deleteWarehouse(Warehouse warehouse) {
        if(warehouse!=null) {
            warehouse.setIsDeleted(true);
            return updateWarehouse(warehouse);
        }
        return 0;
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public Warehouse getWarehouseById(Integer warehouseId) {
            return warehouseMapper.selectByPrimaryKey(warehouseId);
    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public Warehouse getWarehouseByName(String warehouseName) throws Exception {
            WarehouseExample warehouseExample=new WarehouseExample();
            warehouseExample.or().andIsDeletedEqualTo(false).andWarehouseNameEqualTo(warehouseName);
            return warehouseMapper.selectByExample(warehouseExample).get(0);


    }

    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public List<Warehouse> getAllWarehouses() {
        return warehouseMapper.selectAll();
    }
}
