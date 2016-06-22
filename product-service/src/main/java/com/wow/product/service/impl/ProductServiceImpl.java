package com.wow.product.service.impl;


import com.wow.product.model.*;
import com.wow.product.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * 产品服务
 * Created by zhengzhiqing on 16/6/16.
 */
@Service
public class ProductServiceImpl implements ProductService {

    //table: product

    /**
     * 创建产品
     *
     * @param product
     */
    public int createProduct(Product product) {
        return 1;
    }

    /**
     * 创建产品编码
     *
     * @param product
     * @return
     */
    public int createProductCode(Product product) {
        return 1;
    }

    /**
     * 更新产品
     *
     * @param product
     * @return
     */
    public int updateProduct(Product product) {
        return 1;
    }


    //table: group

    /**
     * 创建产品分组
     *
     * @param group
     * @return
     */
    public int createGroup(Group group) {
        return 1;
    }

    /**
     * 根据分组类型查询所有产品分组
     *
     * @param groupType
     * @return
     */
    public List<Group> getGroupsByGroupType(String groupType){
        return null;
    }

    //table: product_combine

    /**
     * 创建组合产品
     *
     * @param productCombine
     * @return
     */
    public int createProductCombine(ProductCombine productCombine) {
        return 1;
    }

    /**
     * 一次性创建组合产品
     *
     * @param productCombines
     * @return
     */
    public int createProductCombine(List<ProductCombine> productCombines){
        return 1;
    }

    /**
     * 根据组合主品,查找组合子品信息
     *
     * @param productId
     * @return
     */
    public List<ProductCombine> querySubProductInfo(int productId){
        return new ArrayList<ProductCombine>();
    }

    //table: product_comment

    /**
     * 评论产品
     *
     * @param productComment
     * @return
     */
    public int createProductComment(ProductComment productComment) {
        return 1;
    }

    //table: product_group

    /**
     * 添加产品到产品组
     *
     * @param productId
     * @param groupId
     * @return
     */
    public int addProductIntoGroup(int productId, int groupId) {
        return 1;
    }

    /**
     * 批量添加产品到产品组
     *
     * @param productId
     * @param groupId
     * @return
     */
    public int addProductsIntoGroup(int[] productId, int groupId) {
        return 1;
    }

    //table: product_image

    /**
     * 添加产品图片
     *
     * @param productImage
     * @return
     */
    public int addProductImage(ProductImage productImage) {
        return 1;
    }

    /**
     * 批量添加产品图片
     *
     * @param productImages
     * @return
     */
    public int addProductImages(List<ProductImage> productImages) {
        return 1;
    }

    //table: product_serial

    /**
     * 判断产品是否系列产品
     *
     * @param productId
     * @return
     */
    public boolean isProductSerial(int productId) {
        return false;
    }

    /**
     * 查询系列品的主子品
     *
     * @param productId
     * @return
     */
    public Product queryPrimarySubProductOfProductSerial(int productId) {
        return null;
    }

    //table: product_summary

    /**
     * 创建产品统计信息,包括总销量,评论数
     *
     * @param productSummary
     * @return
     */
    public int createProductSummary(ProductSummary productSummary) {
        return 1;
    }

    /**
     * 更新产品统计信息,包括总销量,评论数(可以使用定时任务或者队列的方式来更新,注意并发)
     *
     * @param productSummary
     * @return
     */
    public int updateProductSummary(ProductSummary productSummary) {
        return 1;
    }
}
