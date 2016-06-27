package com.wow.product.service.impl;


import com.wow.attribute.model.Attribute;
import com.wow.product.mapper.ProductMapper;
import com.wow.product.model.*;
import com.wow.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * 产品服务
 * Created by zhengzhiqing on 16/6/16.
 */
@Service
@Transactional(value = "productTransactionManager")
public class ProductServiceImpl implements ProductService {

    //table: product
    @Autowired
    private ProductMapper productMapper;
    /**
     * 创建产品(注意要调用生码接口)
     *
     * @param product
     */
    public int createProduct(Product product) {
        String productCode = generateProductCode(product);
        return 1;
    }

    /**
     * 生成产品编码
     * @param product
     * @return
     */
    private String generateProductCode(Product product) {
        return "";
    }


    /**
     * 根据ID查询产品
     *
     * @param productId
     * @return
     */
    public Product getProductById(int productId) {
        return null;
    }

    /**
     * 更新产品
     *
     * @param product
     * @return
     */
    public int updateProduct(Product product) {
        return 0;
    }

    //table: product_image

    /**
     * 添加产品图片
     *
     * @param productImage
     * @return
     */
    public int addProductImage(ProductImage productImage) {
        return 0;
    }

    /**
     * 批量添加产品图片
     *
     * @param productImages
     * @return
     */
    public int addProductImages(List<ProductImage> productImages) {
        return 0;
    }

    /**
     * 查找产品图片
     *
     * @param productId
     * @return
     */
    public List<ProductImage> getProductImages(int productId) {
        return null;
    }

    /**
     * 修改产品图片
     *
     * @param productImage
     * @return
     */
    public int updateProductImage(ProductImage productImage) {
        return 0;
    }

    /**
     * 删除产品图片
     *
     * @param productImages
     * @return
     */
    public int deleteProductImages(List<ProductImage> productImages) {
        return 0;
    }

    //table: product_attribute

    /**
     * 查询产品的属性:根据product找category,根据category找category_attributes
     *
     * @param product
     * @return
     */
    public List<Attribute> getAttributesInProduct(Product product) {
        return null;
    }

    /**
     * 批量设置产品的属性值
     *
     * @param productAttributes
     * @return
     */
    public int createProductAttribute(List<ProductAttribute> productAttributes) {
        return 0;
    }

    /**
     * 批量更新产品的属性值
     *
     * @param productAttributes
     * @return
     */
    public int updateProductAttribute(List<ProductAttribute> productAttributes) {
        return 0;
    }

}
