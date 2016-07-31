package com.wow.order.vo;

import java.io.Serializable;
import java.util.Date;

import com.wow.common.page.PageQuery;

/**
 * 订单列表查询类
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月17日 上午11:42:47 Exp $
 */
public class AdminOrderListQuery extends PageQuery implements Serializable {
    /**  */
    private static final long serialVersionUID = 1L;

    //用户id
    private Integer endUserId;

    //订单号
    private String orderCode;
    
    //开始日期
    private String beginDate;
    
    //结束日期
    private String endDate;
    
    //开始日期 日期格式
    private Date beginDateFormat;
    
    //结束日期 日期格式
    private Date endDateFormat;
    
    //付款方式
    private Byte paymentMethod;

    //订单状态
    private Byte orderStatus;
    
    //收货人姓名
    private String receiverName;
    
    //收货人手机号码
    private String receiverMobile;
    
    //产品名称
    private String productName;
    
    public Date getBeginDateFormat() {
        return beginDateFormat;
    }

    public void setBeginDateFormat(Date beginDateFormat) {
        this.beginDateFormat = beginDateFormat;
    }

    public Date getEndDateFormat() {
        return endDateFormat;
    }

    public void setEndDateFormat(Date endDateFormat) {
        this.endDateFormat = endDateFormat;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Byte getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(Byte paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Byte getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Byte orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getEndUserId() {
        return endUserId;
    }

    public void setEndUserId(Integer endUserId) {
        this.endUserId = endUserId;
    }

}