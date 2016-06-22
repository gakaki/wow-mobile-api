package com.wow.product.mapper;

import com.wow.product.model.ProductComment;
import com.wow.product.model.ProductCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductCommentMapper {
    int countByExample(ProductCommentExample example);

    int deleteByExample(ProductCommentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductComment record);

    int insertSelective(ProductComment record);

    List<ProductComment> selectByExample(ProductCommentExample example);

    ProductComment selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductComment record, @Param("example") ProductCommentExample example);

    int updateByExample(@Param("record") ProductComment record, @Param("example") ProductCommentExample example);

    int updateByPrimaryKeySelective(ProductComment record);

    int updateByPrimaryKey(ProductComment record);
}