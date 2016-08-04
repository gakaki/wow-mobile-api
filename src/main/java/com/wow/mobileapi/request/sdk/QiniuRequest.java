package com.wow.mobileapi.request.sdk;

import com.wow.common.request.ApiRequest;

/**
 * Created by zhengzhiqing on 16/7/13.
 */
public class QiniuRequest extends ApiRequest {
    /**  */
    private static final long serialVersionUID = 1L;

    //bucket名称
    private String bucket;
    
    //key
    private String key;
    
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getBucket() {
        return bucket;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }
}
