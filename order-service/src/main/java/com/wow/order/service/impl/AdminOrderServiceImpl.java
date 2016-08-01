package com.wow.order.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wow.common.constant.CommonConstant;
import com.wow.common.enums.SaleOrderStatusEnum;
import com.wow.common.page.PageData;
import com.wow.common.page.PageModel;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.DateUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.MapUtil;
import com.wow.common.util.StringUtil;
import com.wow.order.mapper.DeliveryOrderMapper;
import com.wow.order.mapper.SaleOrderItemMapper;
import com.wow.order.mapper.SaleOrderMapper;
import com.wow.order.model.DeliveryOrder;
import com.wow.order.model.DeliveryOrderExample;
import com.wow.order.model.SaleOrder;
import com.wow.order.model.SaleOrderExample;
import com.wow.order.service.AdminOrderService;
import com.wow.order.vo.AdminDeliveryOrderVo;
import com.wow.order.vo.AdminOrderItemVo;
import com.wow.order.vo.AdminOrderListQuery;
import com.wow.order.vo.AdminOrderListVo;
import com.wow.order.vo.OrderDetailQuery;
import com.wow.order.vo.OrderItemVo;
import com.wow.order.vo.response.AdminOrderDetailResponse;
import com.wow.order.vo.response.AdminOrderListResponse;

/**
 * 后台订单服务
 * <p>
 * Created by zhengzhiqing on 16/6/16.
 */
@Service
@Transactional("orderTransactionManager")
public class AdminOrderServiceImpl implements AdminOrderService {

    @Autowired
    private SaleOrderMapper saleOrderMapper;

    @Autowired
    private SaleOrderItemMapper saleOrderItemMapper;

    @Autowired
    private DeliveryOrderMapper deliveryOrderMapper;

    @Override
    public AdminOrderListResponse queryOrderListPage(AdminOrderListQuery query) {
        AdminOrderListResponse adminOrderListResponse = new AdminOrderListResponse();

        if (query.getBeginDateFormat() != null && query.getEndDateFormat() != null) {
            //如果开始日期比结束日期大 则直接返回错误
            if (!DateUtil.isLessThanOrEquals(query.getBeginDateFormat(), query.getEndDateFormat())) {
                adminOrderListResponse.setResCode("40324");
                adminOrderListResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40324"));

                return adminOrderListResponse;
            }
        }

        //设置分页查询对象
        PageModel model = new PageModel();
        if (query.getPageSize() != null) {
            model.setShowCount(query.getPageSize());
        }
        if (query.getCurrentPage() != null) {
            model.setCurrentPage(query.getCurrentPage());
            //仅在第一页时获取相应的分页记录
            if (query.getCurrentPage() == 1) {
                model.setIsPage(true);
            }
        }

        model.setModel(query);

        List<PageData> pageDataList = saleOrderMapper.selectForAdminListPage(model);

        if (CollectionUtil.isEmpty(pageDataList)) {
            return adminOrderListResponse;
        }

        List<AdminOrderListVo> orderLists = Arrays.asList(JsonUtil.fromJSON(pageDataList, AdminOrderListVo[].class));

        //获取订单id集合
        List<Integer> orderIds = new ArrayList<Integer>(orderLists.size());
        for (AdminOrderListVo adminOrderListVo : orderLists) {
            orderIds.add(adminOrderListVo.getOrderId());
        }

        List<AdminOrderItemVo> orderItemVos = saleOrderItemMapper.selectByOrderIds(orderIds);

        Map<Integer, List<AdminOrderItemVo>> map = getOrderItemMap(orderItemVos);

        //包装处理订单列表数据
        for (AdminOrderListVo adminOrderListVo : orderLists) {
            //设置订单创建时间格式
            adminOrderListVo.setOrderCreateTimeFormat(DateUtil.formatDatetime(adminOrderListVo.getOrderCreateTime()));
            adminOrderListVo.setOrderCreateTime(null); //不序列化输出
            //设置订单状态名称
            adminOrderListVo.setOrderStatusName(SaleOrderStatusEnum.get(adminOrderListVo.getOrderStatus().intValue()));

            adminOrderListVo.setOrderItemVos(getAdminOrderList(map, adminOrderListVo.getOrderId()));
        }

        adminOrderListResponse.setOrderLists(orderLists);

        //设置分页信息
        adminOrderListResponse.setCurrentPage(query.getCurrentPage());
        adminOrderListResponse.setPageSize(query.getPageSize());
        adminOrderListResponse.setTotalPage(model.getTotalPage());
        adminOrderListResponse.setTotalResult(model.getTotalResult());

        return adminOrderListResponse;
    }

    /**
     * 
     * 根据订单id获取相应的订单产品信息
     * @param map
     * @param orderId
     * @return 
     */
    private List<AdminOrderItemVo> getAdminOrderList(Map<Integer, List<AdminOrderItemVo>> map, Integer orderId) {
        //如果未找到订单id对应的订单产品信息 则返回一个空集合
        if (MapUtil.isEmpty(map) || !map.containsKey(orderId)) {
            return Collections.emptyList();
        }

        return map.get(orderId);
    }

    /**
     * 
     * 获取订单项目对应的商品信息
     * @param orderItemVos
     * @return
     */
    private Map<Integer, List<AdminOrderItemVo>> getOrderItemMap(List<AdminOrderItemVo> orderItemVos) {
        Map<Integer, List<AdminOrderItemVo>> map = new HashMap<Integer, List<AdminOrderItemVo>>();

        for (AdminOrderItemVo orderItemVo : orderItemVos) {
            if (map.containsKey(orderItemVo.getSaleOrderId())) {
                map.get(orderItemVo.getSaleOrderId()).add(orderItemVo);
            } else {
                List<AdminOrderItemVo> orderItemList = new ArrayList<AdminOrderItemVo>();
                orderItemList.add(orderItemVo);
                map.put(orderItemVo.getSaleOrderId(), orderItemList);
            }
        }

        return map;
    }

    @Override
    public AdminOrderDetailResponse queryOrderDetail(OrderDetailQuery query) {
        AdminOrderDetailResponse orderDetailResponse = new AdminOrderDetailResponse();

        /*** 业务校验开始*/
        //如果订单号是否为空  则直接返回错误提示
        if (StringUtil.isEmpty(query.getOrderCode())) {
            orderDetailResponse.setResCode("40358");
            orderDetailResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40358"));

            return orderDetailResponse;
        }

        //根据订单号获取订单
        SaleOrder saleOrder = selectByOrderCode(query.getOrderCode());
        //如果订单号不存在  则直接返回错误提示
        if (saleOrder == null) {
            orderDetailResponse.setResCode("40359");
            orderDetailResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40359"));

            return orderDetailResponse;
        }
        /*** 业务校验结束*/

        //设置订单明细
        setOrderDetail(orderDetailResponse, saleOrder);

        //获取订单对应的商品信息
        List<OrderItemVo> orderItems = saleOrderItemMapper.selectByOrderId(saleOrder.getId());

        //对象转换
        String json = JsonUtil.pojo2Json(orderItems);
        List<AdminOrderItemVo> adminOrderItems = Arrays.asList(JsonUtil.fromJSON(json, AdminOrderItemVo[].class));

        orderDetailResponse.setOrderItems(adminOrderItems);

        //获取订单对应的运单信息
        List<DeliveryOrder> deliveryOrders = selectByOrderId(saleOrder.getId());

        //如果有相关的运单信息 则进行对象封装
        if (CollectionUtil.isNotEmpty(deliveryOrders)) {
            json = JsonUtil.pojo2Json(deliveryOrders);
            List<AdminDeliveryOrderVo> adminDeliveryOrders = Arrays
                .asList(JsonUtil.fromJSON(json, AdminDeliveryOrderVo[].class));

            orderDetailResponse.setDeliveryOrders(adminDeliveryOrders);
        }

        return orderDetailResponse;
    }

    /**
     * 设置订单明细
     * 
     * @param orderDetailResponse
     * @param saleOrder
     */
    private void setOrderDetail(AdminOrderDetailResponse orderDetailResponse, SaleOrder saleOrder) {
        orderDetailResponse.setOrderId(saleOrder.getId());
        orderDetailResponse.setOrderCode(saleOrder.getOrderCode());

        //设置收件人信息
        orderDetailResponse.setReceiverName(saleOrder.getReceiverName());
        orderDetailResponse.setReceiverMobile(saleOrder.getReceiverMobile());
        orderDetailResponse.setReceiverAddress(saleOrder.getReceiverAddress());

        //设置订单金额
        orderDetailResponse.setOrderAmount(saleOrder.getOrderAmount());
        orderDetailResponse.setDeliveryFee(saleOrder.getDeliveryFee());
        orderDetailResponse.setCouponAmount(saleOrder.getPreferentialAmount());

        //设置订单状态 支付状态 支付方式
        orderDetailResponse.setOrderStatus(saleOrder.getOrderStatus());
        orderDetailResponse.setOrderStatusName(SaleOrderStatusEnum.get(saleOrder.getOrderStatus().intValue()));
        orderDetailResponse.setPaymentStatus(saleOrder.getPaymentStatus());
        orderDetailResponse.setPaymentStatusName(CommonConstant.getPayStatusName(saleOrder.getPaymentStatus()));
        orderDetailResponse.setPaymentMethod(saleOrder.getPaymentMethod());
        orderDetailResponse.setPaymentMethodName(CommonConstant.getDeliveryMothodName(saleOrder.getPaymentMethod()));

        //设置日期格式
        orderDetailResponse.setOrderCreateTimeFormat(DateUtil.formatDatetime(saleOrder.getOrderCreateTime()));
    }

    /**
     * 根据订单号获取订单信息
     * 
     * @param orderCode
     * @return
     */
    private SaleOrder selectByOrderCode(String orderCode) {
        //根据订单号获取订单
        SaleOrderExample saleOrderExample = new SaleOrderExample();
        SaleOrderExample.Criteria criteria = saleOrderExample.createCriteria();
        criteria.andOrderCodeEqualTo(orderCode);

        return saleOrderMapper.selectOnlyByExample(saleOrderExample);
    }

    /**
     * 根据订单号获取运单信息
     * 
     * @param orderCode
     * @return
     */
    private List<DeliveryOrder> selectByOrderId(Integer saleOrderId) {
        //根据订单号获取订单
        DeliveryOrderExample deliveryOrderExample = new DeliveryOrderExample();
        DeliveryOrderExample.Criteria criteria = deliveryOrderExample.createCriteria();
        criteria.andSaleOrderIdEqualTo(saleOrderId);

        return deliveryOrderMapper.selectByExample(deliveryOrderExample);
    }

}