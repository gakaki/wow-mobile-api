package com.wow.order.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wow.common.enums.SaleOrderStatusEnum;
import com.wow.common.page.PageData;
import com.wow.common.page.PageModel;
import com.wow.common.util.CollectionUtil;
import com.wow.common.util.DateUtil;
import com.wow.common.util.JsonUtil;
import com.wow.order.mapper.SaleOrderMapper;
import com.wow.order.service.AdminOrderService;
import com.wow.order.vo.AdminOrderListQuery;
import com.wow.order.vo.AdminOrderListVo;
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

    @Override
    public AdminOrderListResponse queryOrderListPage(AdminOrderListQuery query) {
        AdminOrderListResponse adminOrderListResponse = new AdminOrderListResponse();

        //设置分页查询对象
        PageModel model = new PageModel();
        if (query.getPageSize() != null) {
            model.setShowCount(query.getPageSize());
        }
        if (query.getCurrentPage() != null) {
            model.setCurrentPage(query.getCurrentPage());
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

        //包装处理订单列表数据
        for (AdminOrderListVo adminOrderListVo : orderLists) {
            //设置订单创建时间格式
            adminOrderListVo.setOrderCreateTimeFormat(DateUtil.formatDatetime(adminOrderListVo.getOrderCreateTime()));
            adminOrderListVo.setOrderCreateTime(null); //不序列化输出
            //设置订单状态名称
            adminOrderListVo.setOrderStatusName(SaleOrderStatusEnum.get(adminOrderListVo.getOrderStatus().intValue()));
        }

        adminOrderListResponse.setOrderLists(orderLists);

        return adminOrderListResponse;
    }

}