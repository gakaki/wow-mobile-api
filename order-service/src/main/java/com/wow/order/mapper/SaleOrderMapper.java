package com.wow.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wow.common.page.PageData;
import com.wow.common.page.PageModel;
import com.wow.order.model.SaleOrder;
import com.wow.order.model.SaleOrderExample;
import com.wow.order.vo.OrderListQuery;
import com.wow.order.vo.OrderListVo;

public interface SaleOrderMapper {
    int countByExample(SaleOrderExample example);

    int deleteByExample(SaleOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleOrder record);

    int insertSelective(SaleOrder record);

    List<SaleOrder> selectByExample(SaleOrderExample example);

    List<PageData> selectListPage(PageModel page);

    SaleOrder selectByPrimaryKey(Integer id);

    SaleOrder selectByOrderCode(String orderCode);

    int updateByExampleSelective(@Param("record") SaleOrder record, @Param("example") SaleOrderExample example);

    int updateByExample(@Param("record") SaleOrder record, @Param("example") SaleOrderExample example);

    int updateByPrimaryKeySelective(SaleOrder record);

    int updateByPrimaryKey(SaleOrder record);

    List<OrderListVo> selectByEndUserId(OrderListQuery query);
}