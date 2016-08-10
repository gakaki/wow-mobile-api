package com.wow.common.request;

/**
 * Created by win7 on 2016/7/27.
 */
public class DictionaryRequest extends ApiRequest{

    private static final long serialVersionUID = 1L;

    private Integer keyId;

    private String keyGroup;

    public Integer getKeyId() {
        return keyId;
    }

    public void setKeyId(Integer keyId) {
        this.keyId = keyId;
    }



    public String getKeyGroup() {
        return keyGroup;
    }

    public void setKeyGroup(String keyGroup) {
        this.keyGroup = keyGroup;
    }

}
