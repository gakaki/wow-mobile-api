package com.wow.user.vo.response;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.user.vo.ShoppingCartResultVo;

/**
 * 获取用户购物车信息响应类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月14日 下午4:46:14 Exp $
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ShoppingCartResponse extends CommonResponse {

    /**  */
    private static final long serialVersionUID = 1L;
    
    private List<ShoppingCartResultVo> shoppingCartResult;
    
    //购物车总价
    private BigDecimal totalAmount;
    
    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<ShoppingCartResultVo> getShoppingCartResult() {
        return shoppingCartResult;
    }

    public void setShoppingCartResult(List<ShoppingCartResultVo> shoppingCartResult) {
        this.shoppingCartResult = shoppingCartResult;
    }

}
