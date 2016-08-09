package com.wow.product.mapper;

import java.util.List;

import com.wow.product.model.GroupProduct;
import com.wow.product.vo.ProductInTopicVo;
import com.wow.product.vo.ProductListQuery;
import com.wow.product.vo.response.GroupProductResponse;
import org.apache.ibatis.annotations.Param;

import com.wow.common.page.PageData;
import com.wow.common.page.PageModel;
import com.wow.product.model.Product;
import com.wow.product.model.ProductExample;
import com.wow.product.vo.ProductListVo;
import com.wow.product.vo.ProductVo;

public interface ProductMapper {
    int countByExample(ProductExample example);

    int deleteByExample(ProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Product record);

    int insertSelective(Product record);

    List<Product> selectByExampleWithBLOBs(ProductExample example);

    List<Product> selectByExample(ProductExample example);

    Product selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExampleWithBLOBs(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKeyWithBLOBs(Product record);

    int updateByPrimaryKey(Product record);

    //按分类查询产品并按销量排序
    List<PageData> selectProductByCategoryOrderBySoldQty(PageModel page);

    //按分类查询产品并按价格排序
    List<PageData> selectProductByCategoryOrderBySellPrice(PageModel page);
    
    //按分类查询产品并按上架时间排序
    List<PageData> selectProductByCategoryOrderByOnShelfTime(PageModel page);
    
    List<ProductVo> selectProductByBrandId(@Param("brandId") Integer brandId);

    List<ProductVo> selectProductByDesignerId(@Param("designerId") Integer designerId);

    List<PageData> selectProductByBrandIdListPage(PageModel model);

    List<PageData> selectProductByDesignerIdListPage(PageModel model);
    
    //后台产品列表分页查询
    List<PageData> selectProductListPage(PageModel page);
    //按产品ID批量查询产品列表信息
    List<ProductListVo> selectProductByProductIds(@Param("productIds") List<Integer> productIds);
    

    List<PageData> queryProductByTopicGroupListPage(PageModel model);

    List<ProductInTopicVo> selectProductInTopic(@Param("topicId") Integer topicId);
}