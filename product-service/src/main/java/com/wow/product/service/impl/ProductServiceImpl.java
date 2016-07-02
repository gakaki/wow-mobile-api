package com.wow.product.service.impl;


import com.wow.attribute.model.*;
import com.wow.attribute.service.AttributeService;

import com.wow.attribute.service.CategoryService;
import com.wow.product.mapper.ProductAttributeMapper;
import com.wow.product.mapper.ProductImageMapper;
import com.wow.product.mapper.ProductMapper;
import com.wow.product.model.Product;
import com.wow.product.model.ProductAttribute;
import com.wow.product.model.ProductImage;
import com.wow.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Iterator;
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

    @Autowired
    private ProductImageMapper productImageMapper;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    AttributeService attributeService;

    @Autowired
    private ProductAttributeMapper productAttributeMapper;
    /**
     * 创建产品(注意要调用生码接口)
     *
     * @param product
     */
    public int createProduct(Product product) {
        if(product==null)
            return -1;
        String productCode = generateProductCode();

            product.setProductCode(productCode.substring(0,7));
        return productMapper.insert(product);
    }

    /**
     * 生成产品编码
     * @return
     */
    private String generateProductCode() {

        return java.util.UUID.randomUUID().toString();
    }


    /**
     * 根据ID查询产品
     *
     * @param productId
     * @return
     */
    public Product getProductById(int productId) {
        return productMapper.selectByPrimaryKey(productId);
    }

    /**
     * 更新产品
     *
     * @param product
     * @return
     */
    public int updateProduct(Product product) {
        return productMapper.updateByPrimaryKey(product);
    }

    //table: product_image

    /**
     * 添加产品图片
     *
     * @param productImage
     * @return
     */
    public int addProductImage(ProductImage productImage) {
        return productImageMapper.insert(productImage);
    }

    /**
     * 批量添加产品图片
     *
     * @param productImages
     * @return
     */
    public int addProductImages(List<ProductImage> productImages) {
        if(productImages==null ||productImages.size()==0)
            return -1;
        productImageMapper.insertBatch(productImages);
        return 0;
    }

    /**
     * 查找产品图片
     *
     * @param productId
     * @return
     */
    public List<ProductImage> getProductImages(int productId) {
        return  productImageMapper.selectByProductId(productId);
    }

    /**
     * 修改产品图片
     *
     * @param productImage
     * @return
     */
    public int updateProductImage(ProductImage productImage) {
        return productImageMapper.updateByPrimaryKey(productImage);
    }

    /**
     * 删除产品图片
     *
     * @param productImages
     * @return
     */
    public int deleteProductImages(List<ProductImage> productImages) {
        if(productImages==null ||productImages.size()==0)
            return -1;
        return productImageMapper.deleteBatch(productImages);
    }

    //table: product_attribute

    /**
     * 查询产品的属性:根据product找category,根据category找category_attributes
     *
     * @param product
     * @return
     */
    public List<Attribute> getAttributesInProduct(Product product){
        if(product==null)
            return null;
      Category category= categoryService.getCategoryById(product.getCategoryId());
        if(category!=null)
           return attributeService.getAttributesInCategory(category.getId());

        return null;
    }

    /**
     * 批量设置产品的属性值
     *
     * @param productAttributes
     * @return
     */
    public int createProductAttribute(List<ProductAttribute> productAttributes) {
        if(productAttributes==null ||productAttributes.size()==0)
            return -1;
        return productAttributeMapper.insertBatch(productAttributes);
    }

    /**
     * 批量更新产品的属性值
     *
     * @param productAttributes
     * @return
     */
    public int updateProductAttribute(List<ProductAttribute> productAttributes) {
        if(productAttributes==null ||productAttributes.size()==0)
            return -1;
        Iterator  var=productAttributes.iterator();
        int updateFlag=0;
        while (var.hasNext())
        {
            updateFlag=  productAttributeMapper.updateByPrimaryKey((ProductAttribute)var.next());
        }
        return updateFlag;
    }

}
