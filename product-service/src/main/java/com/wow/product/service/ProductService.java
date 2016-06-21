package com.wow.product.service;

import com.wow.product.model.*;

import java.util.List;


/**
 * 产品服务
 * Created by zhengzhiqing on 16/6/16.
 */
public interface ProductService {

    //table: product

    /**
     * 创建产品
     *
     * @param product
     */
    int createProduct(Product product);

    /**
     * 创建产品编码
     *
     * @param product
     * @return
     */
    int createProductCode(Product product);

    /**
     * 更新产品
     *
     * @param product
     * @return
     */
    int updateProduct(Product product);


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
    List<Group> getGroupsByGroupType(String groupType);

    //table: product_combine

    /**
     * 创建组合产品
     *
     * @param productCombine
     * @return
     */
    int createProductCombine(ProductCombine productCombine);

    /**
     * 一次性创建组合产品
     *
     * @param productCombines
     * @return
     */
    int createProductCombine(List<ProductCombine> productCombines);

    /**
     * 根据组合主品,查找组合子品信息
     *
     * @param productId
     * @return
     */
    List<ProductCombine> querySubProductInfo(int productId);

    //table: product_comment

    /**
     * 评论产品
     *
     * @param productComment
     * @return
     */
    int createProductComment(ProductComment productComment);

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

    //table: product_image

    /**
     * 添加产品图片
     *
     * @param productImage
     * @return
     */
    int addProductImage(ProductImage productImage);

    /**
     * 批量添加产品图片
     *
     * @param productImages
     * @return
     */
    int addProductImages(List<ProductImage> productImages);

    //table: product_serial

    /**
     * 判断产品是否系列产品
     *
     * @param productId
     * @return
     */
    boolean isProductSerial(int productId);

    /**
     * 查询系列品的主子品
     *
     * @param productId
     * @return
     */
    Product queryPrimarySubProductOfProductSerial(int productId);

    //table: product_summary

    /**
     * 创建产品统计信息,包括总销量,评论数
     *
     * @param productSummary
     * @return
     */
    int createProductSummary(ProductSummary productSummary);

    /**
     * 更新产品统计信息,包括总销量,评论数(可以使用定时任务或者队列的方式来更新,注意并发)
     *
     * @param productSummary
     * @return
     */
    int updateProductSummary(ProductSummary productSummary);


}
