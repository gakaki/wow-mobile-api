package com.wow.product.mapper;

import com.wow.product.model.ProductShortListInTopic;
import com.wow.product.model.ProductShortListInTopicExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProductShortListInTopicMapper {
    int countByExample(ProductShortListInTopicExample example);

    int deleteByExample(ProductShortListInTopicExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ProductShortListInTopic record);

    int insertSelective(ProductShortListInTopic record);

    List<ProductShortListInTopic> selectByExample(ProductShortListInTopicExample example);

    ProductShortListInTopic selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ProductShortListInTopic record, @Param("example") ProductShortListInTopicExample example);

    int updateByExample(@Param("record") ProductShortListInTopic record, @Param("example") ProductShortListInTopicExample example);

    int updateByPrimaryKeySelective(ProductShortListInTopic record);

    int updateByPrimaryKey(ProductShortListInTopic record);
}