package com.wow.stock.service.impl;

import com.wow.common.response.CommonResponse;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.stock.mapper.ProductStockChangeLogMapper;
import com.wow.stock.model.ProductStockChangeLog;
import com.wow.stock.service.StockChangeLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by zhengzhiqing on 16/7/16.
 */
@Service
@Transactional("stockTransactionManager")
public class StockChangeLogServiceImpl implements StockChangeLogService {

    private static final Logger logger = LoggerFactory.getLogger(StockChangeLogServiceImpl.class);

    @Autowired
    ProductStockChangeLogMapper productStockChangeLogMapper;

    @Override
    public CommonResponse createStockChangeLog(ProductStockChangeLog log) {
        CommonResponse commonResponse = new CommonResponse();
        int i = productStockChangeLogMapper.insertSelective(log);
        if (i < 1) {
            commonResponse.setResCode("50607");
            commonResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50607"));
        }
        return commonResponse;
    }
}
