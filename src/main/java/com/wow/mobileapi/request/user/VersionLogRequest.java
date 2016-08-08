package com.wow.mobileapi.request.user;

import javax.validation.constraints.NotNull;

import com.wow.common.request.ApiRequest;

/**
 * 
 * 
 * @author kaiwei
 * @version V1.0 2016年8月8日 下午3:42:05 Exp
 */
public class VersionLogRequest extends ApiRequest {

    private static final long serialVersionUID = 1L;

    //app类型
    @NotNull
    private Byte appType;

    //平台类型
    @NotNull
    private Byte platForm;

    //客户端当前版本号
    @NotNull
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
