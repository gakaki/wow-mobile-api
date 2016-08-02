package com.wow.product.mapper;

import com.wow.product.model.ProductDesigner;
import com.wow.product.model.ProductDesignerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductDesignerMapper {
    int countByExample(ProductDesignerExample example);

    int deleteByExample(ProductDesignerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductDesigner record);

    int insertSelective(ProductDesigner record);

    List<ProductDesigner> selectByExample(ProductDesignerExample example);

    ProductDesigner selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductDesigner record, @Param("example") ProductDesignerExample example);

    int updateByExample(@Param("record") ProductDesigner record, @Param("example") ProductDesignerExample example);

    int updateByPrimaryKeySelective(ProductDesigner record);

    int updateByPrimaryKey(ProductDesigner record);

    int addByBatch(List<ProductDesigner> list);
}