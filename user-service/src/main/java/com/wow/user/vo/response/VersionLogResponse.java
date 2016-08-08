package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;

/**
 * 版本日志
 * 
 * @author kaiwei
 * @version V1.0 2016年8月8日 下午2:53:54 Exp
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class VersionLogResponse extends CommonResponse {

    private static final long serialVersionUID = 1L;

    //最新版本号
    private String version;

    //版本构建号
    private String buildVersion;

    //发布日期
    private String publishDateFormat;

    //发布日志
    private String publishLog;

    //是否必须要升级 默认不升级
    private Boolean isRequiredUpgrade=Boolean.FALSE;
    
    //升级url
    private String upgradeUrl;
    
    public String getUpgradeUrl() {
        return upgradeUrl;
    }

    public void setUpgradeUrl(String upgradeUrl) {
        this.upgradeUrl = upgradeUrl;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getBuildVersion() {
        return buildVersion;
    }

    public void setBuildVersion(String buildVersion) {
        this.buildVersion = buildVersion;
    }

    public String getPublishDateFormat() {
        return publishDateFormat;
    }

    public void setPublishDateFormat(String publishDateFormat) {
        this.publishDateFormat = publishDateFormat;
    }

    public String getPublishLog() {
        return publishLog;
    }

    public void setPublishLog(String publishLog) {
        this.publishLog = publishLog;
    }

    public Boolean getIsRequiredUpgrade() {
        return isRequiredUpgrade;
    }

    public void setIsRequiredUpgrade(Boolean isRequiredUpgrade) {
        this.isRequiredUpgrade = isRequiredUpgrade;
    }

}
