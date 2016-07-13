package com.wow.product.service;

import com.wow.attribute.model.Attribute;
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
     * 根据ID查询产品
     * @param productId
     * @return
     */
    Product getProductById(int productId);

    List<Product> getProductById(List<Integer> productId);

    List<Product> getProductByBrandId(int brandId);

    /**
     * 更新产品
     *
     * @param product
     * @return
     */
    int updateProduct(Product product);

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

    /**
     * 查找产品图片
     * @param productId
     * @return
     */
    List<ProductImage> getProductImages(int productId);

    /**
     * 修改产品图片
     *
     * @param productImage
     * @return
     */
    int updateProductImage(ProductImage productImage);

    /**
     * 删除产品图片
     *
     * @param productImages
     * @return
     */
    int deleteProductImages(List<ProductImage> productImages);

    //table: product_attribute
    /**
     * 查询产品的属性:根据product找category,根据category找category_attributes
     *
     * @param product
     * @return
     */
    List<Attribute> getAttributesInProduct(Product product);

    /**
     * 批量设置产品的属性值
     *
     * @param productAttributes
     * @return
     */
    int createProductAttribute(List<ProductAttribute> productAttributes);

    /**
     * 批量更新产品的属性值
     * @param productAttributes
     * @return
     */
    int updateProductAttribute(List<ProductAttribute> productAttributes);


    List<Material> getMaterialInProduct(Integer productId);

    /**
     * 批量设置产品的材质
     *
     * @param productMaterials
     * @return
     */
    int createProductMaterial(List<ProductMaterial> productMaterials);

    /**
     * 批量更新产品的材质
     * @param productMaterials
     * @return
     */
    int updateProductMaterial(List<ProductMaterial> productMaterials);

    /**
     * 产品价格
     * @return
     */
    int createProductPrice(ProductPrice productPrice);

    int updateProductPrice(ProductPrice productPrice);

    ProductPrice getProductPrice(Integer productId) throws Exception ;

}
