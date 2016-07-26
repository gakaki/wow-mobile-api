package com.wow.order.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wow.order.model.SaleOrderItem;
import com.wow.order.model.SaleOrderItemExample;
import com.wow.order.vo.OrderItemImgVo;
import com.wow.order.vo.OrderItemQuery;
import com.wow.order.vo.OrderItemStockVo;
import com.wow.order.vo.OrderItemVo;

public interface SaleOrderItemMapper {
    int countByExample(SaleOrderItemExample example);

    int deleteByExample(SaleOrderItemExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SaleOrderItem record);

    int insertSelective(SaleOrderItem record);

    List<SaleOrderItem> selectByExample(SaleOrderItemExample example);

    SaleOrderItem selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SaleOrderItem record, @Param("example") SaleOrderItemExample example);

    int updateByExample(@Param("record") SaleOrderItem record, @Param("example") SaleOrderItemExample example);

    int updateByPrimaryKeySelective(SaleOrderItem record);

    int updateByPrimaryKey(SaleOrderItem record);

    //根据订单id获取订单项目中产品规格图片
    List<OrderItemImgVo> selectSpecImgByOrderIds(List<Integer> orderIds);

    //根据订单id获取产品明细
    List<OrderItemVo> selectByOrderId(Integer orderId);

    //根据订单id获取订单项目使用库存明细
    List<OrderItemStockVo> selectWareHouseStockByOrderId(Integer orderId);

    //根据订单项id列表更新订单发货状态
    int updateDeliveryByIds(OrderItemQuery query);

}