package com.wow.order.mapper;

import com.wow.order.model.SaleOrderInvoice;
import com.wow.order.model.SaleOrderInvoiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SaleOrderInvoiceMapper {
    int countByExample(SaleOrderInvoiceExample example);

    int deleteByExample(SaleOrderInvoiceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleOrderInvoice record);

    int insertSelective(SaleOrderInvoice record);

    List<SaleOrderInvoice> selectByExample(SaleOrderInvoiceExample example);

    SaleOrderInvoice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SaleOrderInvoice record, @Param("example") SaleOrderInvoiceExample example);

    int updateByExample(@Param("record") SaleOrderInvoice record, @Param("example") SaleOrderInvoiceExample example);

    int updateByPrimaryKeySelective(SaleOrderInvoice record);

    int updateByPrimaryKey(SaleOrderInvoice record);
}