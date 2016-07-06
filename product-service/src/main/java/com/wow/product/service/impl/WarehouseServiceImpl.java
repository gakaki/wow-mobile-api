package com.wow.product.service.impl;

import com.wow.product.mapper.WarehouseMapper;
import com.wow.product.model.Warehouse;
import com.wow.product.model.WarehouseExample;
import com.wow.product.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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
    public Warehouse getWarehouseById(Integer warehouseId) {
            return warehouseMapper.selectByPrimaryKey(warehouseId);
    }

    @Override
    public Warehouse getWarehouseByName(String warehouseName) {
        try{
            WarehouseExample warehouseExample=new WarehouseExample();
            warehouseExample.or().andIsDeletedEqualTo(false).andWarehouseNameEqualTo(warehouseName);
            return warehouseMapper.selectByExample(warehouseExample).get(0);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Warehouse> getAllWarehouses(Warehouse warehouse) {
        return null;
    }
}
