package com.wow.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wow.common.page.PageData;
import com.wow.common.page.PageModel;
import com.wow.order.model.SaleOrder;
import com.wow.order.model.SaleOrderExample;
import com.wow.order.vo.SaleOrderVo;

public interface SaleOrderMapper {
    int countByExample(SaleOrderExample example);

    int deleteByExample(SaleOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleOrder record);

    int insertSelective(SaleOrder record);

    List<SaleOrder> selectByExample(SaleOrderExample example);

    SaleOrder selectOnlyByExample(SaleOrderExample example);

    SaleOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SaleOrder record, @Param("example") SaleOrderExample example);

    int updateByExample(@Param("record") SaleOrder record, @Param("example") SaleOrderExample example);

    int updateByPrimaryKeySelective(SaleOrder record);

    int updateByPrimaryKey(SaleOrder record);

    List<PageData> selectListPage(PageModel query);

    //后台查询订单列表
    List<PageData> selectForAdminListPage(PageModel query);

    /**
     * 获取超时未支付的订单列表
     * 
     * @param timeoutMinute
     * @return
     */
    List<SaleOrder> selectTimeOutUnpayOrder(int timeoutMinute);

    int updateByPrimaryByIdAndStatus(SaleOrderVo saleOrderVo);
}