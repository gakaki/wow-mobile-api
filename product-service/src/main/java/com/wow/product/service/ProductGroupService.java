package com.wow.product.service;

import com.wow.product.model.Group;
import com.wow.product.model.Product;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/6/24.
 */
public interface ProductGroupService {

    //table: group
    /**
     * 创建产品分组
     *
     * @param group
     * @return
     */
    int createGroup(Group group);

    /**
     * 根据分组类型查询所有产品分组
     *
     * @param groupType
     * @return
     */
    List<Group> getGroupsByGroupType(int groupType);

    //table: product_group
    /**
     * 添加产品到产品组
     *
     * @param productId
     * @param groupId
     * @return
     */
    int addProductIntoGroup(int productId, int groupId);

    /**
     * 批量添加产品到产品组
     *
     * @param productId
     * @param groupId
     * @return
     */
    int addProductsIntoGroup(int[] productId, int groupId);

    /**
     * 查找产品组里所有产品
     * @param groupId
     * @return
     */
    List<Product> getProductsInGroup(int groupId);

}
