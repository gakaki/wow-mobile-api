package com.wow.product.service;

import com.wow.product.model.Designer;
import com.wow.product.model.Product;
import com.wow.product.model.ProductDesigner;

import java.util.List;

/**
 * 设计师服务
 * Created by zhengzhiqing on 16/6/16.
 */
public interface DesignerService {
    //Table: designer

    /**
     * 创建设计师
     *
     * @param designer
     * @return
     */
    int createDesigner(Designer designer);

    /**
     * 根据Id查询设计师
     *
     * @param designerId
     * @return
     */
    Designer getDesignerById(int designerId);

    /**
     * 更新设计师
     *
     * @param designer
     * @return
     */
    int updateDesigner(Designer designer);

    /**
     * 根据国家查询设计师
     *
     * @param country
     * @return
     */
    List<Designer> getDesignersByCountry(String country);

    /**
     * 根据风格查询设计师
     *
     * @param style
     * @return
     */
    List<Designer> getDesignersByStyle(String style);

    /**
     * 根据设计师id查询设计师设计的产品列表
     *
     * @param designerId
     * @return
     */
    List<Product> getProductsByDesigner(int designerId);

    /**
     * 根据设计师名查询设计师设计的产品列表
     *
     * @param designerName
     * @return
     */
    List<Product> getProductsByDesigner(String designerName);

    //table: product_designer

    /**
     * 设置产品设计师
     *
     * @param productDesigner
     * @return
     */
    int createProductDesigner(ProductDesigner productDesigner);

    /**
     * 批量设置产品设计师
     *
     * @param productDesigners
     * @return
     */
    int createProductDesigners(List<ProductDesigner> productDesigners);

    /**
     * 查询产品的所有设计师
     *
     * @param product
     * @return
     */
    List<Designer> queryDesignersByProduct(Product product);
}
