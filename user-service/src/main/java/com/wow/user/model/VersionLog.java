package com.wow.user.model;

import java.io.Serializable;
import java.util.Date;

public class VersionLog implements Serializable {
    private Integer id;

    private Byte appType;

    private Byte platForm;

    private String version;

    private String buildVersion;

    private Date publishDate;

    private String publishLog;

    private Boolean isRequiredUpgrade;

    private String upgradeUrl;

    private Date createTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
        this.version = version == null ? null : version.trim();
    }

    public String getBuildVersion() {
        return buildVersion;
    }

    public void setBuildVersion(String buildVersion) {
        this.buildVersion = buildVersion == null ? null : buildVersion.trim();
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublishLog() {
        return publishLog;
    }

    public void setPublishLog(String publishLog) {
        this.publishLog = publishLog == null ? null : publishLog.trim();
    }

    public Boolean getIsRequiredUpgrade() {
        return isRequiredUpgrade;
    }

    public void setIsRequiredUpgrade(Boolean isRequiredUpgrade) {
        this.isRequiredUpgrade = isRequiredUpgrade;
    }

    public String getUpgradeUrl() {
        return upgradeUrl;
    }

    public void setUpgradeUrl(String upgradeUrl) {
        this.upgradeUrl = upgradeUrl == null ? null : upgradeUrl.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", appType=").append(appType);
        sb.append(", platForm=").append(platForm);
        sb.append(", version=").append(version);
        sb.append(", buildVersion=").append(buildVersion);
        sb.append(", publishDate=").append(publishDate);
        sb.append(", publishLog=").append(publishLog);
        sb.append(", isRequiredUpgrade=").append(isRequiredUpgrade);
        sb.append(", upgradeUrl=").append(upgradeUrl);
        sb.append(", createTime=").append(createTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}