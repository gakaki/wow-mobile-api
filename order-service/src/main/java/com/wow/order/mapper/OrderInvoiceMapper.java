package com.wow.order.mapper;

import com.wow.order.model.OrderInvoice;
import com.wow.order.model.OrderInvoiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderInvoiceMapper {
    int countByExample(OrderInvoiceExample example);

    int deleteByExample(OrderInvoiceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(OrderInvoice record);

    int insertSelective(OrderInvoice record);

    List<OrderInvoice> selectByExample(OrderInvoiceExample example);

    OrderInvoice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") OrderInvoice record, @Param("example") OrderInvoiceExample example);

    int updateByExample(@Param("record") OrderInvoice record, @Param("example") OrderInvoiceExample example);

    int updateByPrimaryKeySelective(OrderInvoice record);

    int updateByPrimaryKey(OrderInvoice record);
}