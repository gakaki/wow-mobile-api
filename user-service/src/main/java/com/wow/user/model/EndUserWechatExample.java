package com.wow.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EndUserWechatExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EndUserWechatExample() {
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

        public Criteria andMobileIsNull() {
            addCriterion("mobile is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("mobile is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("mobile =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("mobile <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("mobile >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("mobile >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("mobile <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("mobile <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("mobile like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("mobile not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("mobile in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("mobile not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("mobile between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("mobile not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNull() {
            addCriterion("open_id is null");
            return (Criteria) this;
        }

        public Criteria andOpenIdIsNotNull() {
            addCriterion("open_id is not null");
            return (Criteria) this;
        }

        public Criteria andOpenIdEqualTo(String value) {
            addCriterion("open_id =", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotEqualTo(String value) {
            addCriterion("open_id <>", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThan(String value) {
            addCriterion("open_id >", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdGreaterThanOrEqualTo(String value) {
            addCriterion("open_id >=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThan(String value) {
            addCriterion("open_id <", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLessThanOrEqualTo(String value) {
            addCriterion("open_id <=", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdLike(String value) {
            addCriterion("open_id like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotLike(String value) {
            addCriterion("open_id not like", value, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdIn(List<String> values) {
            addCriterion("open_id in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotIn(List<String> values) {
            addCriterion("open_id not in", values, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdBetween(String value1, String value2) {
            addCriterion("open_id between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andOpenIdNotBetween(String value1, String value2) {
            addCriterion("open_id not between", value1, value2, "openId");
            return (Criteria) this;
        }

        public Criteria andWechatNickNameIsNull() {
            addCriterion("wechat_nick_name is null");
            return (Criteria) this;
        }

        public Criteria andWechatNickNameIsNotNull() {
            addCriterion("wechat_nick_name is not null");
            return (Criteria) this;
        }

        public Criteria andWechatNickNameEqualTo(String value) {
            addCriterion("wechat_nick_name =", value, "wechatNickName");
            return (Criteria) this;
        }

        public Criteria andWechatNickNameNotEqualTo(String value) {
            addCriterion("wechat_nick_name <>", value, "wechatNickName");
            return (Criteria) this;
        }

        public Criteria andWechatNickNameGreaterThan(String value) {
            addCriterion("wechat_nick_name >", value, "wechatNickName");
            return (Criteria) this;
        }

        public Criteria andWechatNickNameGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_nick_name >=", value, "wechatNickName");
            return (Criteria) this;
        }

        public Criteria andWechatNickNameLessThan(String value) {
            addCriterion("wechat_nick_name <", value, "wechatNickName");
            return (Criteria) this;
        }

        public Criteria andWechatNickNameLessThanOrEqualTo(String value) {
            addCriterion("wechat_nick_name <=", value, "wechatNickName");
            return (Criteria) this;
        }

        public Criteria andWechatNickNameLike(String value) {
            addCriterion("wechat_nick_name like", value, "wechatNickName");
            return (Criteria) this;
        }

        public Criteria andWechatNickNameNotLike(String value) {
            addCriterion("wechat_nick_name not like", value, "wechatNickName");
            return (Criteria) this;
        }

        public Criteria andWechatNickNameIn(List<String> values) {
            addCriterion("wechat_nick_name in", values, "wechatNickName");
            return (Criteria) this;
        }

        public Criteria andWechatNickNameNotIn(List<String> values) {
            addCriterion("wechat_nick_name not in", values, "wechatNickName");
            return (Criteria) this;
        }

        public Criteria andWechatNickNameBetween(String value1, String value2) {
            addCriterion("wechat_nick_name between", value1, value2, "wechatNickName");
            return (Criteria) this;
        }

        public Criteria andWechatNickNameNotBetween(String value1, String value2) {
            addCriterion("wechat_nick_name not between", value1, value2, "wechatNickName");
            return (Criteria) this;
        }

        public Criteria andWechatAvatarIsNull() {
            addCriterion("wechat_avatar is null");
            return (Criteria) this;
        }

        public Criteria andWechatAvatarIsNotNull() {
            addCriterion("wechat_avatar is not null");
            return (Criteria) this;
        }

        public Criteria andWechatAvatarEqualTo(String value) {
            addCriterion("wechat_avatar =", value, "wechatAvatar");
            return (Criteria) this;
        }

        public Criteria andWechatAvatarNotEqualTo(String value) {
            addCriterion("wechat_avatar <>", value, "wechatAvatar");
            return (Criteria) this;
        }

        public Criteria andWechatAvatarGreaterThan(String value) {
            addCriterion("wechat_avatar >", value, "wechatAvatar");
            return (Criteria) this;
        }

        public Criteria andWechatAvatarGreaterThanOrEqualTo(String value) {
            addCriterion("wechat_avatar >=", value, "wechatAvatar");
            return (Criteria) this;
        }

        public Criteria andWechatAvatarLessThan(String value) {
            addCriterion("wechat_avatar <", value, "wechatAvatar");
            return (Criteria) this;
        }

        public Criteria andWechatAvatarLessThanOrEqualTo(String value) {
            addCriterion("wechat_avatar <=", value, "wechatAvatar");
            return (Criteria) this;
        }

        public Criteria andWechatAvatarLike(String value) {
            addCriterion("wechat_avatar like", value, "wechatAvatar");
            return (Criteria) this;
        }

        public Criteria andWechatAvatarNotLike(String value) {
            addCriterion("wechat_avatar not like", value, "wechatAvatar");
            return (Criteria) this;
        }

        public Criteria andWechatAvatarIn(List<String> values) {
            addCriterion("wechat_avatar in", values, "wechatAvatar");
            return (Criteria) this;
        }

        public Criteria andWechatAvatarNotIn(List<String> values) {
            addCriterion("wechat_avatar not in", values, "wechatAvatar");
            return (Criteria) this;
        }

        public Criteria andWechatAvatarBetween(String value1, String value2) {
            addCriterion("wechat_avatar between", value1, value2, "wechatAvatar");
            return (Criteria) this;
        }

        public Criteria andWechatAvatarNotBetween(String value1, String value2) {
            addCriterion("wechat_avatar not between", value1, value2, "wechatAvatar");
            return (Criteria) this;
        }

        public Criteria andIsBindIsNull() {
            addCriterion("is_bind is null");
            return (Criteria) this;
        }

        public Criteria andIsBindIsNotNull() {
            addCriterion("is_bind is not null");
            return (Criteria) this;
        }

        public Criteria andIsBindEqualTo(Boolean value) {
            addCriterion("is_bind =", value, "isBind");
            return (Criteria) this;
        }

        public Criteria andIsBindNotEqualTo(Boolean value) {
            addCriterion("is_bind <>", value, "isBind");
            return (Criteria) this;
        }

        public Criteria andIsBindGreaterThan(Boolean value) {
            addCriterion("is_bind >", value, "isBind");
            return (Criteria) this;
        }

        public Criteria andIsBindGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_bind >=", value, "isBind");
            return (Criteria) this;
        }

        public Criteria andIsBindLessThan(Boolean value) {
            addCriterion("is_bind <", value, "isBind");
            return (Criteria) this;
        }

        public Criteria andIsBindLessThanOrEqualTo(Boolean value) {
            addCriterion("is_bind <=", value, "isBind");
            return (Criteria) this;
        }

        public Criteria andIsBindIn(List<Boolean> values) {
            addCriterion("is_bind in", values, "isBind");
            return (Criteria) this;
        }

        public Criteria andIsBindNotIn(List<Boolean> values) {
            addCriterion("is_bind not in", values, "isBind");
            return (Criteria) this;
        }

        public Criteria andIsBindBetween(Boolean value1, Boolean value2) {
            addCriterion("is_bind between", value1, value2, "isBind");
            return (Criteria) this;
        }

        public Criteria andIsBindNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_bind not between", value1, value2, "isBind");
            return (Criteria) this;
        }

        public Criteria andBindTimeIsNull() {
            addCriterion("bind_time is null");
            return (Criteria) this;
        }

        public Criteria andBindTimeIsNotNull() {
            addCriterion("bind_time is not null");
            return (Criteria) this;
        }

        public Criteria andBindTimeEqualTo(Date value) {
            addCriterion("bind_time =", value, "bindTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeNotEqualTo(Date value) {
            addCriterion("bind_time <>", value, "bindTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeGreaterThan(Date value) {
            addCriterion("bind_time >", value, "bindTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("bind_time >=", value, "bindTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeLessThan(Date value) {
            addCriterion("bind_time <", value, "bindTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeLessThanOrEqualTo(Date value) {
            addCriterion("bind_time <=", value, "bindTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeIn(List<Date> values) {
            addCriterion("bind_time in", values, "bindTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeNotIn(List<Date> values) {
            addCriterion("bind_time not in", values, "bindTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeBetween(Date value1, Date value2) {
            addCriterion("bind_time between", value1, value2, "bindTime");
            return (Criteria) this;
        }

        public Criteria andBindTimeNotBetween(Date value1, Date value2) {
            addCriterion("bind_time not between", value1, value2, "bindTime");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("sex is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("sex is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Byte value) {
            addCriterion("sex =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Byte value) {
            addCriterion("sex <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Byte value) {
            addCriterion("sex >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("sex >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Byte value) {
            addCriterion("sex <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Byte value) {
            addCriterion("sex <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Byte> values) {
            addCriterion("sex in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Byte> values) {
            addCriterion("sex not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Byte value1, Byte value2) {
            addCriterion("sex between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Byte value1, Byte value2) {
            addCriterion("sex not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andCountryIsNull() {
            addCriterion("country is null");
            return (Criteria) this;
        }

        public Criteria andCountryIsNotNull() {
            addCriterion("country is not null");
            return (Criteria) this;
        }

        public Criteria andCountryEqualTo(String value) {
            addCriterion("country =", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotEqualTo(String value) {
            addCriterion("country <>", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThan(String value) {
            addCriterion("country >", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryGreaterThanOrEqualTo(String value) {
            addCriterion("country >=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThan(String value) {
            addCriterion("country <", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLessThanOrEqualTo(String value) {
            addCriterion("country <=", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryLike(String value) {
            addCriterion("country like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotLike(String value) {
            addCriterion("country not like", value, "country");
            return (Criteria) this;
        }

        public Criteria andCountryIn(List<String> values) {
            addCriterion("country in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotIn(List<String> values) {
            addCriterion("country not in", values, "country");
            return (Criteria) this;
        }

        public Criteria andCountryBetween(String value1, String value2) {
            addCriterion("country between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andCountryNotBetween(String value1, String value2) {
            addCriterion("country not between", value1, value2, "country");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNull() {
            addCriterion("province is null");
            return (Criteria) this;
        }

        public Criteria andProvinceIsNotNull() {
            addCriterion("province is not null");
            return (Criteria) this;
        }

        public Criteria andProvinceEqualTo(String value) {
            addCriterion("province =", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotEqualTo(String value) {
            addCriterion("province <>", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThan(String value) {
            addCriterion("province >", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("province >=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThan(String value) {
            addCriterion("province <", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLessThanOrEqualTo(String value) {
            addCriterion("province <=", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceLike(String value) {
            addCriterion("province like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotLike(String value) {
            addCriterion("province not like", value, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceIn(List<String> values) {
            addCriterion("province in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotIn(List<String> values) {
            addCriterion("province not in", values, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceBetween(String value1, String value2) {
            addCriterion("province between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andProvinceNotBetween(String value1, String value2) {
            addCriterion("province not between", value1, value2, "province");
            return (Criteria) this;
        }

        public Criteria andCityIsNull() {
            addCriterion("city is null");
            return (Criteria) this;
        }

        public Criteria andCityIsNotNull() {
            addCriterion("city is not null");
            return (Criteria) this;
        }

        public Criteria andCityEqualTo(String value) {
            addCriterion("city =", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotEqualTo(String value) {
            addCriterion("city <>", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThan(String value) {
            addCriterion("city >", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityGreaterThanOrEqualTo(String value) {
            addCriterion("city >=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThan(String value) {
            addCriterion("city <", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLessThanOrEqualTo(String value) {
            addCriterion("city <=", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityLike(String value) {
            addCriterion("city like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotLike(String value) {
            addCriterion("city not like", value, "city");
            return (Criteria) this;
        }

        public Criteria andCityIn(List<String> values) {
            addCriterion("city in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotIn(List<String> values) {
            addCriterion("city not in", values, "city");
            return (Criteria) this;
        }

        public Criteria andCityBetween(String value1, String value2) {
            addCriterion("city between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andCityNotBetween(String value1, String value2) {
            addCriterion("city not between", value1, value2, "city");
            return (Criteria) this;
        }

        public Criteria andUnionIdIsNull() {
            addCriterion("union_id is null");
            return (Criteria) this;
        }

        public Criteria andUnionIdIsNotNull() {
            addCriterion("union_id is not null");
            return (Criteria) this;
        }

        public Criteria andUnionIdEqualTo(String value) {
            addCriterion("union_id =", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdNotEqualTo(String value) {
            addCriterion("union_id <>", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdGreaterThan(String value) {
            addCriterion("union_id >", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdGreaterThanOrEqualTo(String value) {
            addCriterion("union_id >=", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdLessThan(String value) {
            addCriterion("union_id <", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdLessThanOrEqualTo(String value) {
            addCriterion("union_id <=", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdLike(String value) {
            addCriterion("union_id like", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdNotLike(String value) {
            addCriterion("union_id not like", value, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdIn(List<String> values) {
            addCriterion("union_id in", values, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdNotIn(List<String> values) {
            addCriterion("union_id not in", values, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdBetween(String value1, String value2) {
            addCriterion("union_id between", value1, value2, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnionIdNotBetween(String value1, String value2) {
            addCriterion("union_id not between", value1, value2, "unionId");
            return (Criteria) this;
        }

        public Criteria andUnbindTimeIsNull() {
            addCriterion("unbind_time is null");
            return (Criteria) this;
        }

        public Criteria andUnbindTimeIsNotNull() {
            addCriterion("unbind_time is not null");
            return (Criteria) this;
        }

        public Criteria andUnbindTimeEqualTo(Date value) {
            addCriterion("unbind_time =", value, "unbindTime");
            return (Criteria) this;
        }

        public Criteria andUnbindTimeNotEqualTo(Date value) {
            addCriterion("unbind_time <>", value, "unbindTime");
            return (Criteria) this;
        }

        public Criteria andUnbindTimeGreaterThan(Date value) {
            addCriterion("unbind_time >", value, "unbindTime");
            return (Criteria) this;
        }

        public Criteria andUnbindTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("unbind_time >=", value, "unbindTime");
            return (Criteria) this;
        }

        public Criteria andUnbindTimeLessThan(Date value) {
            addCriterion("unbind_time <", value, "unbindTime");
            return (Criteria) this;
        }

        public Criteria andUnbindTimeLessThanOrEqualTo(Date value) {
            addCriterion("unbind_time <=", value, "unbindTime");
            return (Criteria) this;
        }

        public Criteria andUnbindTimeIn(List<Date> values) {
            addCriterion("unbind_time in", values, "unbindTime");
            return (Criteria) this;
        }

        public Criteria andUnbindTimeNotIn(List<Date> values) {
            addCriterion("unbind_time not in", values, "unbindTime");
            return (Criteria) this;
        }

        public Criteria andUnbindTimeBetween(Date value1, Date value2) {
            addCriterion("unbind_time between", value1, value2, "unbindTime");
            return (Criteria) this;
        }

        public Criteria andUnbindTimeNotBetween(Date value1, Date value2) {
            addCriterion("unbind_time not between", value1, value2, "unbindTime");
            return (Criteria) this;
        }

        public Criteria andMobileLikeInsensitive(String value) {
            addCriterion("upper(mobile) like", value.toUpperCase(), "mobile");
            return (Criteria) this;
        }

        public Criteria andOpenIdLikeInsensitive(String value) {
            addCriterion("upper(open_id) like", value.toUpperCase(), "openId");
            return (Criteria) this;
        }

        public Criteria andWechatNickNameLikeInsensitive(String value) {
            addCriterion("upper(wechat_nick_name) like", value.toUpperCase(), "wechatNickName");
            return (Criteria) this;
        }

        public Criteria andWechatAvatarLikeInsensitive(String value) {
            addCriterion("upper(wechat_avatar) like", value.toUpperCase(), "wechatAvatar");
            return (Criteria) this;
        }

        public Criteria andCountryLikeInsensitive(String value) {
            addCriterion("upper(country) like", value.toUpperCase(), "country");
            return (Criteria) this;
        }

        public Criteria andProvinceLikeInsensitive(String value) {
            addCriterion("upper(province) like", value.toUpperCase(), "province");
            return (Criteria) this;
        }

        public Criteria andCityLikeInsensitive(String value) {
            addCriterion("upper(city) like", value.toUpperCase(), "city");
            return (Criteria) this;
        }

        public Criteria andUnionIdLikeInsensitive(String value) {
            addCriterion("upper(union_id) like", value.toUpperCase(), "unionId");
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