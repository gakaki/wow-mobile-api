package com.wow.product.mapper;

import com.wow.product.model.ProductApplicableScene;
import com.wow.product.model.ProductApplicableSceneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductApplicableSceneMapper {
    int countByExample(ProductApplicableSceneExample example);

    int deleteByExample(ProductApplicableSceneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductApplicableScene record);

    int insertSelective(ProductApplicableScene record);

    List<ProductApplicableScene> selectByExample(ProductApplicableSceneExample example);

    ProductApplicableScene selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductApplicableScene record, @Param("example") ProductApplicableSceneExample example);

    int updateByExample(@Param("record") ProductApplicableScene record, @Param("example") ProductApplicableSceneExample example);

    int updateByPrimaryKeySelective(ProductApplicableScene record);

    int updateByPrimaryKey(ProductApplicableScene record);
}