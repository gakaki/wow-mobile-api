package com.wow.product.service;

import java.util.List;

import com.wow.product.model.Designer;
import com.wow.product.model.Product;
import com.wow.product.model.ProductDesigner;
import com.wow.product.model.SimpleDesigner;
import com.wow.product.vo.response.ProductDesignerResponse;
import com.wow.product.vo.response.ProductDesignerVoResponse;

/**
 * 设计师服务
 * Created by zhengzhiqing on 16/6/16.
 */
public interface DesignerService {

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
    ProductDesignerResponse getDesignerById(int designerId);
    
    /**
     * 根据Id查询设计师
     *
     * @param designerId
     * @return
     */
    ProductDesignerVoResponse getDesignerVoById(Integer designerId);

    /**
     * 批量查询设计师
     * @param designerIds
     * @return
     */
    List<Designer> getDesignerByIds(List<Integer> designerIds);

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
     * @param productId
     * @return
     */
    List<Designer> getDesignersByProduct(int productId);

    /**
     * 查询产品的设计师记录
     *
     * @param productId
     * @return
     */
    List<ProductDesigner> getProductDesigners(Integer productId);

    /**
     * 查询产品的主设计师
     * @param productId
     * @return
     */
    Designer getPrimaryDesignerByProduct(int productId);

    /**
     * 查看品牌设计师列表
     *
     * @param brandId
     * @return
     */
    List<Designer> getDesignersByBrand(int brandId) throws Exception;
    
    /**
     * 查询所有设计师
     *
     * @return
     */
    public ProductDesignerResponse getAllDesigners();

    /**
     * 查询所有设计师
     *
     * @return
     */
    public List<SimpleDesigner> getAllSimpleDesigners();

    /**
     * 批量插入产品设计师关联信息
     * @param list
     * @return
     */
    int addProductDesignersByBatch(List<ProductDesigner> list);
}
