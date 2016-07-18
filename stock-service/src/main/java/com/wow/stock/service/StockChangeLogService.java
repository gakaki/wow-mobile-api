package com.wow.stock.service;

import com.wow.common.response.CommonResponse;
import com.wow.stock.model.ProductStockChangeLog;

/**
 * Created by zhengzhiqing on 16/7/16.
 */
public interface StockChangeLogService {
    CommonResponse createStockChangeLog(ProductStockChangeLog log);
}
