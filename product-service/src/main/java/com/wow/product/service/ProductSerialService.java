package com.wow.product.service;

import java.util.List;

import com.wow.product.model.ProductSerial;
import com.wow.product.vo.response.SerialResponse;
import com.wow.product.vo.response.SpecResponse;

/**
 * 系列产品服务
 * Created by zhengzhiqing on 16/6/24.
 */
public interface ProductSerialService {
    //table: product_serial

    /**
     * 创建系列产品
     * @param productSerials
     * @return
     */
    int createProductSerial(List<ProductSerial> productSerials);

    /**
     * 更新系列产品
     * @param productSerials
     * @return
     */
    int updateProductSerial(List<ProductSerial> productSerials);

    /**
     * 根据系列主品查找所有子品
     * @param productId 系列主品ID
     * @return
     */
    List<ProductSerial> getProductSerials(int productId);

    /**
     * 删除系列产品
     * @param productSerials
     * @return
     */
    int deleteProductSerial(List<ProductSerial> productSerials);

    int deleteProductSerial(int productId);
    /**
     * 判断产品是否系列主品
     *
     * @param productId
     * @return
     */
    boolean isProductSerial(int productId);

    /**
     * 查询系列品的主子品
     *
     * @param productId
     * @return
     */
    ProductSerial getPrimarySubProductOfProductSerial(int productId);

    SerialResponse getSerialByProductId(Integer productId) throws Exception;

    List<SpecResponse> getSpecByProductId(Integer productId) throws  Exception;

}
