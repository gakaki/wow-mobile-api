package com.wow.product.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wow.product.model.Product;
import com.wow.product.model.ProductExample;
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
    
    List<ProductVo> selectPageByCategoryIdOrderbyShelfTime(@Param("categoryIds") List<Integer> categoryIds,@Param("asc") String asc);
    
    List<ProductVo> selectPageByCategoryIdOrderbyTotalSold(@Param("categoryIds") String categoryIds,@Param("asc") String asc);
    
    List<ProductVo> selectPageByCategoryIdOrderbySellPrice(@Param("categoryIds") String categoryIds,@Param("asc") String asc);
}