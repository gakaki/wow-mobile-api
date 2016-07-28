package com.wow.common.model;

import java.io.Serializable;

public class Dictionary implements Serializable {
    private Integer id;

    private String keyName;

    private String keyValue;

    private String keyGroup;

    private String keyDesc;

    private Short keyOrder;

    private Boolean isValid;

    private static final long serialVersionUID = 1L;

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
        this.keyName = keyName == null ? null : keyName.trim();
    }

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue == null ? null : keyValue.trim();
    }

    public String getKeyGroup() {
        return keyGroup;
    }

    public void setKeyGroup(String keyGroup) {
        this.keyGroup = keyGroup == null ? null : keyGroup.trim();
    }

    public String getKeyDesc() {
        return keyDesc;
    }

    public void setKeyDesc(String keyDesc) {
        this.keyDesc = keyDesc == null ? null : keyDesc.trim();
    }

    public Short getKeyOrder() {
        return keyOrder;
    }

    public void setKeyOrder(Short keyOrder) {
        this.keyOrder = keyOrder;
    }

    public Boolean getIsValid() {
        return isValid;
    }

    public void setIsValid(Boolean isValid) {
        this.isValid = isValid;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", keyName=").append(keyName);
        sb.append(", keyValue=").append(keyValue);
        sb.append(", keyGroup=").append(keyGroup);
        sb.append(", keyDesc=").append(keyDesc);
        sb.append(", keyOrder=").append(keyOrder);
        sb.append(", isValid=").append(isValid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}