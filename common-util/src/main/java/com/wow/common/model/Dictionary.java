package com.wow.common.model;

import java.io.Serializable;

public class Dictionary implements Serializable {
    private Integer id;

    private String key;

    private String value;

    private String keyGroup;

    private String keyDesc;

    private Byte keyOrder;

    private Boolean isValid;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key == null ? null : key.trim();
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
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

    public Byte getKeyOrder() {
        return keyOrder;
    }

    public void setKeyOrder(Byte keyOrder) {
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
        sb.append(", key=").append(key);
        sb.append(", value=").append(value);
        sb.append(", keyGroup=").append(keyGroup);
        sb.append(", keyDesc=").append(keyDesc);
        sb.append(", keyOrder=").append(keyOrder);
        sb.append(", isValid=").append(isValid);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}