package com.wow.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VersionLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VersionLogExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNull() {
            addCriterion("app_type is null");
            return (Criteria) this;
        }

        public Criteria andAppTypeIsNotNull() {
            addCriterion("app_type is not null");
            return (Criteria) this;
        }

        public Criteria andAppTypeEqualTo(Byte value) {
            addCriterion("app_type =", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotEqualTo(Byte value) {
            addCriterion("app_type <>", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThan(Byte value) {
            addCriterion("app_type >", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("app_type >=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThan(Byte value) {
            addCriterion("app_type <", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeLessThanOrEqualTo(Byte value) {
            addCriterion("app_type <=", value, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeIn(List<Byte> values) {
            addCriterion("app_type in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotIn(List<Byte> values) {
            addCriterion("app_type not in", values, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeBetween(Byte value1, Byte value2) {
            addCriterion("app_type between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andAppTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("app_type not between", value1, value2, "appType");
            return (Criteria) this;
        }

        public Criteria andPlatFormIsNull() {
            addCriterion("plat_form is null");
            return (Criteria) this;
        }

        public Criteria andPlatFormIsNotNull() {
            addCriterion("plat_form is not null");
            return (Criteria) this;
        }

        public Criteria andPlatFormEqualTo(Byte value) {
            addCriterion("plat_form =", value, "platForm");
            return (Criteria) this;
        }

        public Criteria andPlatFormNotEqualTo(Byte value) {
            addCriterion("plat_form <>", value, "platForm");
            return (Criteria) this;
        }

        public Criteria andPlatFormGreaterThan(Byte value) {
            addCriterion("plat_form >", value, "platForm");
            return (Criteria) this;
        }

        public Criteria andPlatFormGreaterThanOrEqualTo(Byte value) {
            addCriterion("plat_form >=", value, "platForm");
            return (Criteria) this;
        }

        public Criteria andPlatFormLessThan(Byte value) {
            addCriterion("plat_form <", value, "platForm");
            return (Criteria) this;
        }

        public Criteria andPlatFormLessThanOrEqualTo(Byte value) {
            addCriterion("plat_form <=", value, "platForm");
            return (Criteria) this;
        }

        public Criteria andPlatFormIn(List<Byte> values) {
            addCriterion("plat_form in", values, "platForm");
            return (Criteria) this;
        }

        public Criteria andPlatFormNotIn(List<Byte> values) {
            addCriterion("plat_form not in", values, "platForm");
            return (Criteria) this;
        }

        public Criteria andPlatFormBetween(Byte value1, Byte value2) {
            addCriterion("plat_form between", value1, value2, "platForm");
            return (Criteria) this;
        }

        public Criteria andPlatFormNotBetween(Byte value1, Byte value2) {
            addCriterion("plat_form not between", value1, value2, "platForm");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("version is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("version is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(String value) {
            addCriterion("version =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(String value) {
            addCriterion("version <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(String value) {
            addCriterion("version >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(String value) {
            addCriterion("version >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(String value) {
            addCriterion("version <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(String value) {
            addCriterion("version <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLike(String value) {
            addCriterion("version like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotLike(String value) {
            addCriterion("version not like", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<String> values) {
            addCriterion("version in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<String> values) {
            addCriterion("version not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(String value1, String value2) {
            addCriterion("version between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(String value1, String value2) {
            addCriterion("version not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andBuildVersionIsNull() {
            addCriterion("build_version is null");
            return (Criteria) this;
        }

        public Criteria andBuildVersionIsNotNull() {
            addCriterion("build_version is not null");
            return (Criteria) this;
        }

        public Criteria andBuildVersionEqualTo(String value) {
            addCriterion("build_version =", value, "buildVersion");
            return (Criteria) this;
        }

        public Criteria andBuildVersionNotEqualTo(String value) {
            addCriterion("build_version <>", value, "buildVersion");
            return (Criteria) this;
        }

        public Criteria andBuildVersionGreaterThan(String value) {
            addCriterion("build_version >", value, "buildVersion");
            return (Criteria) this;
        }

        public Criteria andBuildVersionGreaterThanOrEqualTo(String value) {
            addCriterion("build_version >=", value, "buildVersion");
            return (Criteria) this;
        }

        public Criteria andBuildVersionLessThan(String value) {
            addCriterion("build_version <", value, "buildVersion");
            return (Criteria) this;
        }

        public Criteria andBuildVersionLessThanOrEqualTo(String value) {
            addCriterion("build_version <=", value, "buildVersion");
            return (Criteria) this;
        }

        public Criteria andBuildVersionLike(String value) {
            addCriterion("build_version like", value, "buildVersion");
            return (Criteria) this;
        }

        public Criteria andBuildVersionNotLike(String value) {
            addCriterion("build_version not like", value, "buildVersion");
            return (Criteria) this;
        }

        public Criteria andBuildVersionIn(List<String> values) {
            addCriterion("build_version in", values, "buildVersion");
            return (Criteria) this;
        }

        public Criteria andBuildVersionNotIn(List<String> values) {
            addCriterion("build_version not in", values, "buildVersion");
            return (Criteria) this;
        }

        public Criteria andBuildVersionBetween(String value1, String value2) {
            addCriterion("build_version between", value1, value2, "buildVersion");
            return (Criteria) this;
        }

        public Criteria andBuildVersionNotBetween(String value1, String value2) {
            addCriterion("build_version not between", value1, value2, "buildVersion");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNull() {
            addCriterion("publish_date is null");
            return (Criteria) this;
        }

        public Criteria andPublishDateIsNotNull() {
            addCriterion("publish_date is not null");
            return (Criteria) this;
        }

        public Criteria andPublishDateEqualTo(Date value) {
            addCriterion("publish_date =", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotEqualTo(Date value) {
            addCriterion("publish_date <>", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThan(Date value) {
            addCriterion("publish_date >", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateGreaterThanOrEqualTo(Date value) {
            addCriterion("publish_date >=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThan(Date value) {
            addCriterion("publish_date <", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateLessThanOrEqualTo(Date value) {
            addCriterion("publish_date <=", value, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateIn(List<Date> values) {
            addCriterion("publish_date in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotIn(List<Date> values) {
            addCriterion("publish_date not in", values, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateBetween(Date value1, Date value2) {
            addCriterion("publish_date between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishDateNotBetween(Date value1, Date value2) {
            addCriterion("publish_date not between", value1, value2, "publishDate");
            return (Criteria) this;
        }

        public Criteria andPublishLogIsNull() {
            addCriterion("publish_log is null");
            return (Criteria) this;
        }

        public Criteria andPublishLogIsNotNull() {
            addCriterion("publish_log is not null");
            return (Criteria) this;
        }

        public Criteria andPublishLogEqualTo(String value) {
            addCriterion("publish_log =", value, "publishLog");
            return (Criteria) this;
        }

        public Criteria andPublishLogNotEqualTo(String value) {
            addCriterion("publish_log <>", value, "publishLog");
            return (Criteria) this;
        }

        public Criteria andPublishLogGreaterThan(String value) {
            addCriterion("publish_log >", value, "publishLog");
            return (Criteria) this;
        }

        public Criteria andPublishLogGreaterThanOrEqualTo(String value) {
            addCriterion("publish_log >=", value, "publishLog");
            return (Criteria) this;
        }

        public Criteria andPublishLogLessThan(String value) {
            addCriterion("publish_log <", value, "publishLog");
            return (Criteria) this;
        }

        public Criteria andPublishLogLessThanOrEqualTo(String value) {
            addCriterion("publish_log <=", value, "publishLog");
            return (Criteria) this;
        }

        public Criteria andPublishLogLike(String value) {
            addCriterion("publish_log like", value, "publishLog");
            return (Criteria) this;
        }

        public Criteria andPublishLogNotLike(String value) {
            addCriterion("publish_log not like", value, "publishLog");
            return (Criteria) this;
        }

        public Criteria andPublishLogIn(List<String> values) {
            addCriterion("publish_log in", values, "publishLog");
            return (Criteria) this;
        }

        public Criteria andPublishLogNotIn(List<String> values) {
            addCriterion("publish_log not in", values, "publishLog");
            return (Criteria) this;
        }

        public Criteria andPublishLogBetween(String value1, String value2) {
            addCriterion("publish_log between", value1, value2, "publishLog");
            return (Criteria) this;
        }

        public Criteria andPublishLogNotBetween(String value1, String value2) {
            addCriterion("publish_log not between", value1, value2, "publishLog");
            return (Criteria) this;
        }

        public Criteria andIsRequiredUpgradeIsNull() {
            addCriterion("is_required_upgrade is null");
            return (Criteria) this;
        }

        public Criteria andIsRequiredUpgradeIsNotNull() {
            addCriterion("is_required_upgrade is not null");
            return (Criteria) this;
        }

        public Criteria andIsRequiredUpgradeEqualTo(Boolean value) {
            addCriterion("is_required_upgrade =", value, "isRequiredUpgrade");
            return (Criteria) this;
        }

        public Criteria andIsRequiredUpgradeNotEqualTo(Boolean value) {
            addCriterion("is_required_upgrade <>", value, "isRequiredUpgrade");
            return (Criteria) this;
        }

        public Criteria andIsRequiredUpgradeGreaterThan(Boolean value) {
            addCriterion("is_required_upgrade >", value, "isRequiredUpgrade");
            return (Criteria) this;
        }

        public Criteria andIsRequiredUpgradeGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_required_upgrade >=", value, "isRequiredUpgrade");
            return (Criteria) this;
        }

        public Criteria andIsRequiredUpgradeLessThan(Boolean value) {
            addCriterion("is_required_upgrade <", value, "isRequiredUpgrade");
            return (Criteria) this;
        }

        public Criteria andIsRequiredUpgradeLessThanOrEqualTo(Boolean value) {
            addCriterion("is_required_upgrade <=", value, "isRequiredUpgrade");
            return (Criteria) this;
        }

        public Criteria andIsRequiredUpgradeIn(List<Boolean> values) {
            addCriterion("is_required_upgrade in", values, "isRequiredUpgrade");
            return (Criteria) this;
        }

        public Criteria andIsRequiredUpgradeNotIn(List<Boolean> values) {
            addCriterion("is_required_upgrade not in", values, "isRequiredUpgrade");
            return (Criteria) this;
        }

        public Criteria andIsRequiredUpgradeBetween(Boolean value1, Boolean value2) {
            addCriterion("is_required_upgrade between", value1, value2, "isRequiredUpgrade");
            return (Criteria) this;
        }

        public Criteria andIsRequiredUpgradeNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_required_upgrade not between", value1, value2, "isRequiredUpgrade");
            return (Criteria) this;
        }

        public Criteria andUpgradeUrlIsNull() {
            addCriterion("upgrade_url is null");
            return (Criteria) this;
        }

        public Criteria andUpgradeUrlIsNotNull() {
            addCriterion("upgrade_url is not null");
            return (Criteria) this;
        }

        public Criteria andUpgradeUrlEqualTo(String value) {
            addCriterion("upgrade_url =", value, "upgradeUrl");
            return (Criteria) this;
        }

        public Criteria andUpgradeUrlNotEqualTo(String value) {
            addCriterion("upgrade_url <>", value, "upgradeUrl");
            return (Criteria) this;
        }

        public Criteria andUpgradeUrlGreaterThan(String value) {
            addCriterion("upgrade_url >", value, "upgradeUrl");
            return (Criteria) this;
        }

        public Criteria andUpgradeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("upgrade_url >=", value, "upgradeUrl");
            return (Criteria) this;
        }

        public Criteria andUpgradeUrlLessThan(String value) {
            addCriterion("upgrade_url <", value, "upgradeUrl");
            return (Criteria) this;
        }

        public Criteria andUpgradeUrlLessThanOrEqualTo(String value) {
            addCriterion("upgrade_url <=", value, "upgradeUrl");
            return (Criteria) this;
        }

        public Criteria andUpgradeUrlLike(String value) {
            addCriterion("upgrade_url like", value, "upgradeUrl");
            return (Criteria) this;
        }

        public Criteria andUpgradeUrlNotLike(String value) {
            addCriterion("upgrade_url not like", value, "upgradeUrl");
            return (Criteria) this;
        }

        public Criteria andUpgradeUrlIn(List<String> values) {
            addCriterion("upgrade_url in", values, "upgradeUrl");
            return (Criteria) this;
        }

        public Criteria andUpgradeUrlNotIn(List<String> values) {
            addCriterion("upgrade_url not in", values, "upgradeUrl");
            return (Criteria) this;
        }

        public Criteria andUpgradeUrlBetween(String value1, String value2) {
            addCriterion("upgrade_url between", value1, value2, "upgradeUrl");
            return (Criteria) this;
        }

        public Criteria andUpgradeUrlNotBetween(String value1, String value2) {
            addCriterion("upgrade_url not between", value1, value2, "upgradeUrl");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andVersionLikeInsensitive(String value) {
            addCriterion("upper(version) like", value.toUpperCase(), "version");
            return (Criteria) this;
        }

        public Criteria andBuildVersionLikeInsensitive(String value) {
            addCriterion("upper(build_version) like", value.toUpperCase(), "buildVersion");
            return (Criteria) this;
        }

        public Criteria andPublishLogLikeInsensitive(String value) {
            addCriterion("upper(publish_log) like", value.toUpperCase(), "publishLog");
            return (Criteria) this;
        }

        public Criteria andUpgradeUrlLikeInsensitive(String value) {
            addCriterion("upper(upgrade_url) like", value.toUpperCase(), "upgradeUrl");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}