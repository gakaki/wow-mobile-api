package com.wow.order.mapper;

import com.wow.order.model.OrderInvoice;

public interface OrderInvoiceMapper {
    int insert(OrderInvoice record);

    int insertSelective(OrderInvoice record);

    OrderInvoice selectByPrimaryKey(Integer id);
}