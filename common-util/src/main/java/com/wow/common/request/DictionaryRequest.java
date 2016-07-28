package com.wow.common.request;

/**
 * Created by win7 on 2016/7/27.
 */
public class DictionaryRequest extends ApiRequest{

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String keyName;

    private String keyValue;

    private String keyGroup;

    private short keyOrder;

    private Boolean isValid;

    private Integer idCon;

    private String keyNameCon;

    private String keyValueCon;

    private String keyGroupCon;

    private Short keyOrderCon;

    private Boolean isValidCon;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public String getKeyGroup() {
        return keyGroup;
    }

    public void setKeyGroup(String keyGroup) {
        this.keyGroup = keyGroup;
    }

    public short getKeyOrder() {
        return keyOrder;
    }

    public void setKeyOrder(short keyOrder) {
        this.keyOrder = keyOrder;
    }

    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    public Integer getIdCon() {
        return idCon;
    }

    public void setIdCon(Integer idCon) {
        this.idCon = idCon;
    }

    public String getKeyNameCon() {
        return keyNameCon;
    }

    public void setKeyNameCon(String keyNameCon) {
        this.keyNameCon = keyNameCon;
    }

    public String getKeyValueCon() {
        return keyValueCon;
    }

    public void setKeyValueCon(String keyValueCon) {
        this.keyValueCon = keyValueCon;
    }

    public String getKeyGroupCon() {
        return keyGroupCon;
    }

    public void setKeyGroupCon(String keyGroupCon) {
        this.keyGroupCon = keyGroupCon;
    }

    public Short getKeyOrderCon() {
        return keyOrderCon;
    }

    public void setKeyOrderCon(Short keyOrderCon) {
        this.keyOrderCon = keyOrderCon;
    }

    public Boolean getValidCon() {
        return isValidCon;
    }

    public void setValidCon(Boolean validCon) {
        isValidCon = validCon;
    }
}
