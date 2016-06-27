package com.wow.order.mapper;

import com.wow.order.model.DeliveryFeeTemplate;
import com.wow.order.model.DeliveryFeeTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeliveryFeeTemplateMapper {
    int countByExample(DeliveryFeeTemplateExample example);

    int deleteByExample(DeliveryFeeTemplateExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DeliveryFeeTemplate record);

    int insertSelective(DeliveryFeeTemplate record);

    List<DeliveryFeeTemplate> selectByExample(DeliveryFeeTemplateExample example);

    DeliveryFeeTemplate selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DeliveryFeeTemplate record, @Param("example") DeliveryFeeTemplateExample example);

    int updateByExample(@Param("record") DeliveryFeeTemplate record, @Param("example") DeliveryFeeTemplateExample example);

    int updateByPrimaryKeySelective(DeliveryFeeTemplate record);

    int updateByPrimaryKey(DeliveryFeeTemplate record);
}