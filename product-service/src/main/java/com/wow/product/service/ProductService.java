package com.wow.product.service;

import com.wow.attribute.model.Attribute;
import com.wow.common.response.CommonResponse;
import com.wow.product.model.*;
import com.wow.product.vo.request.ProductCreateRequest;
import com.wow.product.vo.response.ProductImgResponse;
import com.wow.product.vo.response.ProductResponse;

import java.util.List;

/**
 * 产品服务
 * Created by zhengzhiqing on 16/6/16.
 */
public interface ProductService {

    /**
     * 创建产品
     *
     * @param productCreateRequest
     */
    CommonResponse createProductInfo(ProductCreateRequest productCreateRequest);

    /**
     *
     * @param product
     * @return
     */
    int createProduct(Product product);

    /**
     * 根据ID查询产品
     * @param productId
     * @return
     */
    Product getProductById(int productId);

    /**
     * 批量查询产品
     * @param productId
     * @return
     */
    List<Product> getProductById(List<Integer> productId);

    /**
     * 根据品牌查询产品
     * @param brandId
     * @return
     */
    List<Product> getProductByBrandId(int brandId);

    /**
     * 更新产品
     *
     * @param product
     * @return
     */
    int updateProduct(Product product);

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

    /**
     * 查询产品材质
     * @param productId
     * @return
     */
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
     * 根据分类查询产品
     * @param category
     * @param sortBy 1:上架时间 2:销量 3:价格
     * @param asc 是否升序
     * @return
     */
    List<Product> getProductByCategoryId(int category, int sortBy, boolean asc);

    /**
     * 获取产品(包括单品和系列品)详情页信息
     * @param productId
     * @return
     */
    public ProductResponse getItemDetailById(int productId);

    /**
     * 查询产品非主图
     * @param productId
     * @return
     */
    public ProductImgResponse getProductNonPrimaryImages(int productId);

}
