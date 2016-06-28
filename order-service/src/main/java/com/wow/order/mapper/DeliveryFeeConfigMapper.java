package com.wow.order.mapper;

import com.wow.order.model.DeliveryFeeConfig;
import com.wow.order.model.DeliveryFeeConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DeliveryFeeConfigMapper {
    int countByExample(DeliveryFeeConfigExample example);

    int deleteByExample(DeliveryFeeConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DeliveryFeeConfig record);

    int insertSelective(DeliveryFeeConfig record);

    List<DeliveryFeeConfig> selectByExample(DeliveryFeeConfigExample example);

    DeliveryFeeConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DeliveryFeeConfig record, @Param("example") DeliveryFeeConfigExample example);

    int updateByExample(@Param("record") DeliveryFeeConfig record, @Param("example") DeliveryFeeConfigExample example);

    int updateByPrimaryKeySelective(DeliveryFeeConfig record);

    int updateByPrimaryKey(DeliveryFeeConfig record);
}