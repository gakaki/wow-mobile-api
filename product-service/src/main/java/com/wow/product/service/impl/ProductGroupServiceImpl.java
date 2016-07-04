package com.wow.product.service.impl;

import com.wow.product.model.Group;
import com.wow.product.model.Product;
import com.wow.product.service.ProductGroupService;

import java.util.List;

/**
 * Created by fangying@wowdsgn on 2016/7/4.
 */
public class ProductGroupServiceImpl implements ProductGroupService {
    @Override
    public int createGroup(Group group) {
        return 0;
    }

    @Override
    public List<Group> getGroupsByGroupType(int groupType) {
        return null;
    }

    @Override
    public int addProductIntoGroup(int productId, int groupId) {
        return 0;
    }

    @Override
    public int addProductsIntoGroup(int[] productId, int groupId) {
        return 0;
    }

    @Override
    public List<Product> getProductsInGroup(int groupId) {
        return null;
    }
}
