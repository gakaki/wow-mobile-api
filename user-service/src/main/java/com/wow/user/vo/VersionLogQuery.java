package com.wow.user.vo;

import java.io.Serializable;

public class VersionLogQuery implements Serializable {
    
    /**  */
    private static final long serialVersionUID = 1L;

    //app类型
    private Byte appType;

    //平台类型
    private Byte platForm;

    //客户端当前版本号
    private String version;

    public Byte getAppType() {
        return appType;
    }

    public void setAppType(Byte appType) {
        this.appType = appType;
    }

    public Byte getPlatForm() {
        return platForm;
    }

    public void setPlatForm(Byte platForm) {
        this.platForm = platForm;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
