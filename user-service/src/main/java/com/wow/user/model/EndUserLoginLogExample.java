package com.wow.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EndUserLoginLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EndUserLoginLogExample() {
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

        public Criteria andEndUserIdIsNull() {
            addCriterion("end_user_id is null");
            return (Criteria) this;
        }

        public Criteria andEndUserIdIsNotNull() {
            addCriterion("end_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andEndUserIdEqualTo(Integer value) {
            addCriterion("end_user_id =", value, "endUserId");
            return (Criteria) this;
        }

        public Criteria andEndUserIdNotEqualTo(Integer value) {
            addCriterion("end_user_id <>", value, "endUserId");
            return (Criteria) this;
        }

        public Criteria andEndUserIdGreaterThan(Integer value) {
            addCriterion("end_user_id >", value, "endUserId");
            return (Criteria) this;
        }

        public Criteria andEndUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_user_id >=", value, "endUserId");
            return (Criteria) this;
        }

        public Criteria andEndUserIdLessThan(Integer value) {
            addCriterion("end_user_id <", value, "endUserId");
            return (Criteria) this;
        }

        public Criteria andEndUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("end_user_id <=", value, "endUserId");
            return (Criteria) this;
        }

        public Criteria andEndUserIdIn(List<Integer> values) {
            addCriterion("end_user_id in", values, "endUserId");
            return (Criteria) this;
        }

        public Criteria andEndUserIdNotIn(List<Integer> values) {
            addCriterion("end_user_id not in", values, "endUserId");
            return (Criteria) this;
        }

        public Criteria andEndUserIdBetween(Integer value1, Integer value2) {
            addCriterion("end_user_id between", value1, value2, "endUserId");
            return (Criteria) this;
        }

        public Criteria andEndUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("end_user_id not between", value1, value2, "endUserId");
            return (Criteria) this;
        }

        public Criteria andLoginChannelIsNull() {
            addCriterion("login_channel is null");
            return (Criteria) this;
        }

        public Criteria andLoginChannelIsNotNull() {
            addCriterion("login_channel is not null");
            return (Criteria) this;
        }

        public Criteria andLoginChannelEqualTo(Byte value) {
            addCriterion("login_channel =", value, "loginChannel");
            return (Criteria) this;
        }

        public Criteria andLoginChannelNotEqualTo(Byte value) {
            addCriterion("login_channel <>", value, "loginChannel");
            return (Criteria) this;
        }

        public Criteria andLoginChannelGreaterThan(Byte value) {
            addCriterion("login_channel >", value, "loginChannel");
            return (Criteria) this;
        }

        public Criteria andLoginChannelGreaterThanOrEqualTo(Byte value) {
            addCriterion("login_channel >=", value, "loginChannel");
            return (Criteria) this;
        }

        public Criteria andLoginChannelLessThan(Byte value) {
            addCriterion("login_channel <", value, "loginChannel");
            return (Criteria) this;
        }

        public Criteria andLoginChannelLessThanOrEqualTo(Byte value) {
            addCriterion("login_channel <=", value, "loginChannel");
            return (Criteria) this;
        }

        public Criteria andLoginChannelIn(List<Byte> values) {
            addCriterion("login_channel in", values, "loginChannel");
            return (Criteria) this;
        }

        public Criteria andLoginChannelNotIn(List<Byte> values) {
            addCriterion("login_channel not in", values, "loginChannel");
            return (Criteria) this;
        }

        public Criteria andLoginChannelBetween(Byte value1, Byte value2) {
            addCriterion("login_channel between", value1, value2, "loginChannel");
            return (Criteria) this;
        }

        public Criteria andLoginChannelNotBetween(Byte value1, Byte value2) {
            addCriterion("login_channel not between", value1, value2, "loginChannel");
            return (Criteria) this;
        }

        public Criteria andUserAgentInfoIsNull() {
            addCriterion("user_agent_info is null");
            return (Criteria) this;
        }

        public Criteria andUserAgentInfoIsNotNull() {
            addCriterion("user_agent_info is not null");
            return (Criteria) this;
        }

        public Criteria andUserAgentInfoEqualTo(String value) {
            addCriterion("user_agent_info =", value, "userAgentInfo");
            return (Criteria) this;
        }

        public Criteria andUserAgentInfoNotEqualTo(String value) {
            addCriterion("user_agent_info <>", value, "userAgentInfo");
            return (Criteria) this;
        }

        public Criteria andUserAgentInfoGreaterThan(String value) {
            addCriterion("user_agent_info >", value, "userAgentInfo");
            return (Criteria) this;
        }

        public Criteria andUserAgentInfoGreaterThanOrEqualTo(String value) {
            addCriterion("user_agent_info >=", value, "userAgentInfo");
            return (Criteria) this;
        }

        public Criteria andUserAgentInfoLessThan(String value) {
            addCriterion("user_agent_info <", value, "userAgentInfo");
            return (Criteria) this;
        }

        public Criteria andUserAgentInfoLessThanOrEqualTo(String value) {
            addCriterion("user_agent_info <=", value, "userAgentInfo");
            return (Criteria) this;
        }

        public Criteria andUserAgentInfoLike(String value) {
            addCriterion("user_agent_info like", value, "userAgentInfo");
            return (Criteria) this;
        }

        public Criteria andUserAgentInfoNotLike(String value) {
            addCriterion("user_agent_info not like", value, "userAgentInfo");
            return (Criteria) this;
        }

        public Criteria andUserAgentInfoIn(List<String> values) {
            addCriterion("user_agent_info in", values, "userAgentInfo");
            return (Criteria) this;
        }

        public Criteria andUserAgentInfoNotIn(List<String> values) {
            addCriterion("user_agent_info not in", values, "userAgentInfo");
            return (Criteria) this;
        }

        public Criteria andUserAgentInfoBetween(String value1, String value2) {
            addCriterion("user_agent_info between", value1, value2, "userAgentInfo");
            return (Criteria) this;
        }

        public Criteria andUserAgentInfoNotBetween(String value1, String value2) {
            addCriterion("user_agent_info not between", value1, value2, "userAgentInfo");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNull() {
            addCriterion("login_ip is null");
            return (Criteria) this;
        }

        public Criteria andLoginIpIsNotNull() {
            addCriterion("login_ip is not null");
            return (Criteria) this;
        }

        public Criteria andLoginIpEqualTo(Long value) {
            addCriterion("login_ip =", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotEqualTo(Long value) {
            addCriterion("login_ip <>", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThan(Long value) {
            addCriterion("login_ip >", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpGreaterThanOrEqualTo(Long value) {
            addCriterion("login_ip >=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThan(Long value) {
            addCriterion("login_ip <", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpLessThanOrEqualTo(Long value) {
            addCriterion("login_ip <=", value, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpIn(List<Long> values) {
            addCriterion("login_ip in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotIn(List<Long> values) {
            addCriterion("login_ip not in", values, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpBetween(Long value1, Long value2) {
            addCriterion("login_ip between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginIpNotBetween(Long value1, Long value2) {
            addCriterion("login_ip not between", value1, value2, "loginIp");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNull() {
            addCriterion("login_time is null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIsNotNull() {
            addCriterion("login_time is not null");
            return (Criteria) this;
        }

        public Criteria andLoginTimeEqualTo(Date value) {
            addCriterion("login_time =", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotEqualTo(Date value) {
            addCriterion("login_time <>", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThan(Date value) {
            addCriterion("login_time >", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("login_time >=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThan(Date value) {
            addCriterion("login_time <", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("login_time <=", value, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeIn(List<Date> values) {
            addCriterion("login_time in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotIn(List<Date> values) {
            addCriterion("login_time not in", values, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeBetween(Date value1, Date value2) {
            addCriterion("login_time between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("login_time not between", value1, value2, "loginTime");
            return (Criteria) this;
        }

        public Criteria andSessionTokenIsNull() {
            addCriterion("session_token is null");
            return (Criteria) this;
        }

        public Criteria andSessionTokenIsNotNull() {
            addCriterion("session_token is not null");
            return (Criteria) this;
        }

        public Criteria andSessionTokenEqualTo(String value) {
            addCriterion("session_token =", value, "sessionToken");
            return (Criteria) this;
        }

        public Criteria andSessionTokenNotEqualTo(String value) {
            addCriterion("session_token <>", value, "sessionToken");
            return (Criteria) this;
        }

        public Criteria andSessionTokenGreaterThan(String value) {
            addCriterion("session_token >", value, "sessionToken");
            return (Criteria) this;
        }

        public Criteria andSessionTokenGreaterThanOrEqualTo(String value) {
            addCriterion("session_token >=", value, "sessionToken");
            return (Criteria) this;
        }

        public Criteria andSessionTokenLessThan(String value) {
            addCriterion("session_token <", value, "sessionToken");
            return (Criteria) this;
        }

        public Criteria andSessionTokenLessThanOrEqualTo(String value) {
            addCriterion("session_token <=", value, "sessionToken");
            return (Criteria) this;
        }

        public Criteria andSessionTokenLike(String value) {
            addCriterion("session_token like", value, "sessionToken");
            return (Criteria) this;
        }

        public Criteria andSessionTokenNotLike(String value) {
            addCriterion("session_token not like", value, "sessionToken");
            return (Criteria) this;
        }

        public Criteria andSessionTokenIn(List<String> values) {
            addCriterion("session_token in", values, "sessionToken");
            return (Criteria) this;
        }

        public Criteria andSessionTokenNotIn(List<String> values) {
            addCriterion("session_token not in", values, "sessionToken");
            return (Criteria) this;
        }

        public Criteria andSessionTokenBetween(String value1, String value2) {
            addCriterion("session_token between", value1, value2, "sessionToken");
            return (Criteria) this;
        }

        public Criteria andSessionTokenNotBetween(String value1, String value2) {
            addCriterion("session_token not between", value1, value2, "sessionToken");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPlatformTypeIsNull() {
            addCriterion("third_party_platform_type is null");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPlatformTypeIsNotNull() {
            addCriterion("third_party_platform_type is not null");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPlatformTypeEqualTo(Byte value) {
            addCriterion("third_party_platform_type =", value, "thirdPartyPlatformType");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPlatformTypeNotEqualTo(Byte value) {
            addCriterion("third_party_platform_type <>", value, "thirdPartyPlatformType");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPlatformTypeGreaterThan(Byte value) {
            addCriterion("third_party_platform_type >", value, "thirdPartyPlatformType");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPlatformTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("third_party_platform_type >=", value, "thirdPartyPlatformType");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPlatformTypeLessThan(Byte value) {
            addCriterion("third_party_platform_type <", value, "thirdPartyPlatformType");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPlatformTypeLessThanOrEqualTo(Byte value) {
            addCriterion("third_party_platform_type <=", value, "thirdPartyPlatformType");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPlatformTypeIn(List<Byte> values) {
            addCriterion("third_party_platform_type in", values, "thirdPartyPlatformType");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPlatformTypeNotIn(List<Byte> values) {
            addCriterion("third_party_platform_type not in", values, "thirdPartyPlatformType");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPlatformTypeBetween(Byte value1, Byte value2) {
            addCriterion("third_party_platform_type between", value1, value2, "thirdPartyPlatformType");
            return (Criteria) this;
        }

        public Criteria andThirdPartyPlatformTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("third_party_platform_type not between", value1, value2, "thirdPartyPlatformType");
            return (Criteria) this;
        }

        public Criteria andUserAgentInfoLikeInsensitive(String value) {
            addCriterion("upper(user_agent_info) like", value.toUpperCase(), "userAgentInfo");
            return (Criteria) this;
        }

        public Criteria andSessionTokenLikeInsensitive(String value) {
            addCriterion("upper(session_token) like", value.toUpperCase(), "sessionToken");
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