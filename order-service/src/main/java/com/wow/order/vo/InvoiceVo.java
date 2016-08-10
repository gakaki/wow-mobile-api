package com.wow.order.vo;

/**
 * Created by zhengzhiqing on 16/6/16.
 */
public class InvoiceVo {
    /**
     * 发票类型,0:不需要,1:普通发票,2:增值税专用发票
     */
    private int invoiceType;
    /**
     * 开票方式,0:纸质发票 1:电子发票
     */
    private int invoiceMethod;
    /**
     * 发票抬头,0:个人,1:单位
     */
    private int invoiceTitle;
    /**
     * 是否需要商品清单
     */
    private boolean isNeedProductList;
    public int getInvoiceType() {
        return invoiceType;
    }
    public void setInvoiceType(int invoiceType) {
        this.invoiceType = invoiceType;
    }
    public int getInvoiceMethod() {
        return invoiceMethod;
    }
    public void setInvoiceMethod(int invoiceMethod) {
        this.invoiceMethod = invoiceMethod;
    }
    public int getInvoiceTitle() {
        return invoiceTitle;
    }
    public void setInvoiceTitle(int invoiceTitle) {
        this.invoiceTitle = invoiceTitle;
    }
    public boolean isNeedProductList() {
        return isNeedProductList;
    }
    public void setNeedProductList(boolean isNeedProductList) {
        this.isNeedProductList = isNeedProductList;
    }
    
    
}
