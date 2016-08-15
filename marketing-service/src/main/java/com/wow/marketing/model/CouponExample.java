package com.wow.marketing.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CouponExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CouponExample() {
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

        public Criteria andCouponTypeIsNull() {
            addCriterion("coupon_type is null");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIsNotNull() {
            addCriterion("coupon_type is not null");
            return (Criteria) this;
        }

        public Criteria andCouponTypeEqualTo(Byte value) {
            addCriterion("coupon_type =", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotEqualTo(Byte value) {
            addCriterion("coupon_type <>", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeGreaterThan(Byte value) {
            addCriterion("coupon_type >", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("coupon_type >=", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLessThan(Byte value) {
            addCriterion("coupon_type <", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeLessThanOrEqualTo(Byte value) {
            addCriterion("coupon_type <=", value, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeIn(List<Byte> values) {
            addCriterion("coupon_type in", values, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotIn(List<Byte> values) {
            addCriterion("coupon_type not in", values, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeBetween(Byte value1, Byte value2) {
            addCriterion("coupon_type between", value1, value2, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("coupon_type not between", value1, value2, "couponType");
            return (Criteria) this;
        }

        public Criteria andCouponTitleIsNull() {
            addCriterion("coupon_title is null");
            return (Criteria) this;
        }

        public Criteria andCouponTitleIsNotNull() {
            addCriterion("coupon_title is not null");
            return (Criteria) this;
        }

        public Criteria andCouponTitleEqualTo(String value) {
            addCriterion("coupon_title =", value, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleNotEqualTo(String value) {
            addCriterion("coupon_title <>", value, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleGreaterThan(String value) {
            addCriterion("coupon_title >", value, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_title >=", value, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleLessThan(String value) {
            addCriterion("coupon_title <", value, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleLessThanOrEqualTo(String value) {
            addCriterion("coupon_title <=", value, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleLike(String value) {
            addCriterion("coupon_title like", value, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleNotLike(String value) {
            addCriterion("coupon_title not like", value, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleIn(List<String> values) {
            addCriterion("coupon_title in", values, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleNotIn(List<String> values) {
            addCriterion("coupon_title not in", values, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleBetween(String value1, String value2) {
            addCriterion("coupon_title between", value1, value2, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponTitleNotBetween(String value1, String value2) {
            addCriterion("coupon_title not between", value1, value2, "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponDescIsNull() {
            addCriterion("coupon_desc is null");
            return (Criteria) this;
        }

        public Criteria andCouponDescIsNotNull() {
            addCriterion("coupon_desc is not null");
            return (Criteria) this;
        }

        public Criteria andCouponDescEqualTo(String value) {
            addCriterion("coupon_desc =", value, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescNotEqualTo(String value) {
            addCriterion("coupon_desc <>", value, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescGreaterThan(String value) {
            addCriterion("coupon_desc >", value, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescGreaterThanOrEqualTo(String value) {
            addCriterion("coupon_desc >=", value, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescLessThan(String value) {
            addCriterion("coupon_desc <", value, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescLessThanOrEqualTo(String value) {
            addCriterion("coupon_desc <=", value, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescLike(String value) {
            addCriterion("coupon_desc like", value, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescNotLike(String value) {
            addCriterion("coupon_desc not like", value, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescIn(List<String> values) {
            addCriterion("coupon_desc in", values, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescNotIn(List<String> values) {
            addCriterion("coupon_desc not in", values, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescBetween(String value1, String value2) {
            addCriterion("coupon_desc between", value1, value2, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponDescNotBetween(String value1, String value2) {
            addCriterion("coupon_desc not between", value1, value2, "couponDesc");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTypeIsNull() {
            addCriterion("coupon_limit_type is null");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTypeIsNotNull() {
            addCriterion("coupon_limit_type is not null");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTypeEqualTo(Byte value) {
            addCriterion("coupon_limit_type =", value, "couponLimitType");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTypeNotEqualTo(Byte value) {
            addCriterion("coupon_limit_type <>", value, "couponLimitType");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTypeGreaterThan(Byte value) {
            addCriterion("coupon_limit_type >", value, "couponLimitType");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("coupon_limit_type >=", value, "couponLimitType");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTypeLessThan(Byte value) {
            addCriterion("coupon_limit_type <", value, "couponLimitType");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTypeLessThanOrEqualTo(Byte value) {
            addCriterion("coupon_limit_type <=", value, "couponLimitType");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTypeIn(List<Byte> values) {
            addCriterion("coupon_limit_type in", values, "couponLimitType");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTypeNotIn(List<Byte> values) {
            addCriterion("coupon_limit_type not in", values, "couponLimitType");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTypeBetween(Byte value1, Byte value2) {
            addCriterion("coupon_limit_type between", value1, value2, "couponLimitType");
            return (Criteria) this;
        }

        public Criteria andCouponLimitTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("coupon_limit_type not between", value1, value2, "couponLimitType");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIsNull() {
            addCriterion("discount_rate is null");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIsNotNull() {
            addCriterion("discount_rate is not null");
            return (Criteria) this;
        }

        public Criteria andDiscountRateEqualTo(BigDecimal value) {
            addCriterion("discount_rate =", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotEqualTo(BigDecimal value) {
            addCriterion("discount_rate <>", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateGreaterThan(BigDecimal value) {
            addCriterion("discount_rate >", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_rate >=", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateLessThan(BigDecimal value) {
            addCriterion("discount_rate <", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("discount_rate <=", value, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateIn(List<BigDecimal> values) {
            addCriterion("discount_rate in", values, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotIn(List<BigDecimal> values) {
            addCriterion("discount_rate not in", values, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_rate between", value1, value2, "discountRate");
            return (Criteria) this;
        }

        public Criteria andDiscountRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("discount_rate not between", value1, value2, "discountRate");
            return (Criteria) this;
        }

        public Criteria andMinAmountLimitIsNull() {
            addCriterion("min_amount_limit is null");
            return (Criteria) this;
        }

        public Criteria andMinAmountLimitIsNotNull() {
            addCriterion("min_amount_limit is not null");
            return (Criteria) this;
        }

        public Criteria andMinAmountLimitEqualTo(Short value) {
            addCriterion("min_amount_limit =", value, "minAmountLimit");
            return (Criteria) this;
        }

        public Criteria andMinAmountLimitNotEqualTo(Short value) {
            addCriterion("min_amount_limit <>", value, "minAmountLimit");
            return (Criteria) this;
        }

        public Criteria andMinAmountLimitGreaterThan(Short value) {
            addCriterion("min_amount_limit >", value, "minAmountLimit");
            return (Criteria) this;
        }

        public Criteria andMinAmountLimitGreaterThanOrEqualTo(Short value) {
            addCriterion("min_amount_limit >=", value, "minAmountLimit");
            return (Criteria) this;
        }

        public Criteria andMinAmountLimitLessThan(Short value) {
            addCriterion("min_amount_limit <", value, "minAmountLimit");
            return (Criteria) this;
        }

        public Criteria andMinAmountLimitLessThanOrEqualTo(Short value) {
            addCriterion("min_amount_limit <=", value, "minAmountLimit");
            return (Criteria) this;
        }

        public Criteria andMinAmountLimitIn(List<Short> values) {
            addCriterion("min_amount_limit in", values, "minAmountLimit");
            return (Criteria) this;
        }

        public Criteria andMinAmountLimitNotIn(List<Short> values) {
            addCriterion("min_amount_limit not in", values, "minAmountLimit");
            return (Criteria) this;
        }

        public Criteria andMinAmountLimitBetween(Short value1, Short value2) {
            addCriterion("min_amount_limit between", value1, value2, "minAmountLimit");
            return (Criteria) this;
        }

        public Criteria andMinAmountLimitNotBetween(Short value1, Short value2) {
            addCriterion("min_amount_limit not between", value1, value2, "minAmountLimit");
            return (Criteria) this;
        }

        public Criteria andEffectiveFromIsNull() {
            addCriterion("effective_from is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveFromIsNotNull() {
            addCriterion("effective_from is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveFromEqualTo(Date value) {
            addCriterion("effective_from =", value, "effectiveFrom");
            return (Criteria) this;
        }

        public Criteria andEffectiveFromNotEqualTo(Date value) {
            addCriterion("effective_from <>", value, "effectiveFrom");
            return (Criteria) this;
        }

        public Criteria andEffectiveFromGreaterThan(Date value) {
            addCriterion("effective_from >", value, "effectiveFrom");
            return (Criteria) this;
        }

        public Criteria andEffectiveFromGreaterThanOrEqualTo(Date value) {
            addCriterion("effective_from >=", value, "effectiveFrom");
            return (Criteria) this;
        }

        public Criteria andEffectiveFromLessThan(Date value) {
            addCriterion("effective_from <", value, "effectiveFrom");
            return (Criteria) this;
        }

        public Criteria andEffectiveFromLessThanOrEqualTo(Date value) {
            addCriterion("effective_from <=", value, "effectiveFrom");
            return (Criteria) this;
        }

        public Criteria andEffectiveFromIn(List<Date> values) {
            addCriterion("effective_from in", values, "effectiveFrom");
            return (Criteria) this;
        }

        public Criteria andEffectiveFromNotIn(List<Date> values) {
            addCriterion("effective_from not in", values, "effectiveFrom");
            return (Criteria) this;
        }

        public Criteria andEffectiveFromBetween(Date value1, Date value2) {
            addCriterion("effective_from between", value1, value2, "effectiveFrom");
            return (Criteria) this;
        }

        public Criteria andEffectiveFromNotBetween(Date value1, Date value2) {
            addCriterion("effective_from not between", value1, value2, "effectiveFrom");
            return (Criteria) this;
        }

        public Criteria andEffectiveToIsNull() {
            addCriterion("effective_to is null");
            return (Criteria) this;
        }

        public Criteria andEffectiveToIsNotNull() {
            addCriterion("effective_to is not null");
            return (Criteria) this;
        }

        public Criteria andEffectiveToEqualTo(Date value) {
            addCriterion("effective_to =", value, "effectiveTo");
            return (Criteria) this;
        }

        public Criteria andEffectiveToNotEqualTo(Date value) {
            addCriterion("effective_to <>", value, "effectiveTo");
            return (Criteria) this;
        }

        public Criteria andEffectiveToGreaterThan(Date value) {
            addCriterion("effective_to >", value, "effectiveTo");
            return (Criteria) this;
        }

        public Criteria andEffectiveToGreaterThanOrEqualTo(Date value) {
            addCriterion("effective_to >=", value, "effectiveTo");
            return (Criteria) this;
        }

        public Criteria andEffectiveToLessThan(Date value) {
            addCriterion("effective_to <", value, "effectiveTo");
            return (Criteria) this;
        }

        public Criteria andEffectiveToLessThanOrEqualTo(Date value) {
            addCriterion("effective_to <=", value, "effectiveTo");
            return (Criteria) this;
        }

        public Criteria andEffectiveToIn(List<Date> values) {
            addCriterion("effective_to in", values, "effectiveTo");
            return (Criteria) this;
        }

        public Criteria andEffectiveToNotIn(List<Date> values) {
            addCriterion("effective_to not in", values, "effectiveTo");
            return (Criteria) this;
        }

        public Criteria andEffectiveToBetween(Date value1, Date value2) {
            addCriterion("effective_to between", value1, value2, "effectiveTo");
            return (Criteria) this;
        }

        public Criteria andEffectiveToNotBetween(Date value1, Date value2) {
            addCriterion("effective_to not between", value1, value2, "effectiveTo");
            return (Criteria) this;
        }

        public Criteria andCouponTitleLikeInsensitive(String value) {
            addCriterion("upper(coupon_title) like", value.toUpperCase(), "couponTitle");
            return (Criteria) this;
        }

        public Criteria andCouponDescLikeInsensitive(String value) {
            addCriterion("upper(coupon_desc) like", value.toUpperCase(), "couponDesc");
            return (Criteria) this;
        }

        public Criteria andDeductionToGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("deduction>=", value, "deduction");
            return (Criteria) this;
        }

        public Criteria andDeductionToLessThanOrEqualTo(String value) {
            addCriterion("deduction<=", value, "deduction");
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