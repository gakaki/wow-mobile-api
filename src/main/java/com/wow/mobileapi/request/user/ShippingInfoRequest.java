package com.wow.mobileapi.request.user;

import com.wow.common.request.ApiRequest;

/**
 * 用户收货地址请求类
 * Created by zhengzhiqing on 16/7/12.
 */
public class ShippingInfoRequest extends ApiRequest {

    /**  */
    private static final long serialVersionUID = 1L;
    
    //收货人地址id 仅在修改删除时传递
    private Integer id;

    //收货人姓名
    private String receiverName;

    //省份id
    private Integer provinceId;

    //城市id
    private Integer cityId;

    //区域id
    private Integer countyId;

    //详细地址
    private String addressDetail;

    //地址类别 公司或者个人
    private String addressAlias;

    //收件人手机号码
    private String receiverMobile;

    //收件人电话号码
    private String receiverPhone;

    //收件人邮编
    private String receiverPostcode;

    //收件人email
    private String receiverEmail;

    //是否默认地址
    private Boolean isDefault;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getCountyId() {
        return countyId;
    }

    public void setCountyId(Integer countyId) {
        this.countyId = countyId;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getAddressAlias() {
        return addressAlias;
    }

    public void setAddressAlias(String addressAlias) {
        this.addressAlias = addressAlias;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverPhone() {
        return receiverPhone;
    }

    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone;
    }

    public String getReceiverPostcode() {
        return receiverPostcode;
    }

    public void setReceiverPostcode(String receiverPostcode) {
        this.receiverPostcode = receiverPostcode;
    }

    public String getReceiverEmail() {
        return receiverEmail;
    }

    public void setReceiverEmail(String receiverEmail) {
        this.receiverEmail = receiverEmail;
    }

    public Boolean getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Boolean isDefault) {
        this.isDefault = isDefault;
    }

}
