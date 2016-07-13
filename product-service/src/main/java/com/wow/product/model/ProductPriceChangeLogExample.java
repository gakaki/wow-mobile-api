package com.wow.product.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductPriceChangeLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductPriceChangeLogExample() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andPriceTypeIsNull() {
            addCriterion("price_type is null");
            return (Criteria) this;
        }

        public Criteria andPriceTypeIsNotNull() {
            addCriterion("price_type is not null");
            return (Criteria) this;
        }

        public Criteria andPriceTypeEqualTo(Byte value) {
            addCriterion("price_type =", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotEqualTo(Byte value) {
            addCriterion("price_type <>", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeGreaterThan(Byte value) {
            addCriterion("price_type >", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("price_type >=", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeLessThan(Byte value) {
            addCriterion("price_type <", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeLessThanOrEqualTo(Byte value) {
            addCriterion("price_type <=", value, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeIn(List<Byte> values) {
            addCriterion("price_type in", values, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotIn(List<Byte> values) {
            addCriterion("price_type not in", values, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeBetween(Byte value1, Byte value2) {
            addCriterion("price_type between", value1, value2, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("price_type not between", value1, value2, "priceType");
            return (Criteria) this;
        }

        public Criteria andPriceFromIsNull() {
            addCriterion("price_from is null");
            return (Criteria) this;
        }

        public Criteria andPriceFromIsNotNull() {
            addCriterion("price_from is not null");
            return (Criteria) this;
        }

        public Criteria andPriceFromEqualTo(BigDecimal value) {
            addCriterion("price_from =", value, "priceFrom");
            return (Criteria) this;
        }

        public Criteria andPriceFromNotEqualTo(BigDecimal value) {
            addCriterion("price_from <>", value, "priceFrom");
            return (Criteria) this;
        }

        public Criteria andPriceFromGreaterThan(BigDecimal value) {
            addCriterion("price_from >", value, "priceFrom");
            return (Criteria) this;
        }

        public Criteria andPriceFromGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_from >=", value, "priceFrom");
            return (Criteria) this;
        }

        public Criteria andPriceFromLessThan(BigDecimal value) {
            addCriterion("price_from <", value, "priceFrom");
            return (Criteria) this;
        }

        public Criteria andPriceFromLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_from <=", value, "priceFrom");
            return (Criteria) this;
        }

        public Criteria andPriceFromIn(List<BigDecimal> values) {
            addCriterion("price_from in", values, "priceFrom");
            return (Criteria) this;
        }

        public Criteria andPriceFromNotIn(List<BigDecimal> values) {
            addCriterion("price_from not in", values, "priceFrom");
            return (Criteria) this;
        }

        public Criteria andPriceFromBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_from between", value1, value2, "priceFrom");
            return (Criteria) this;
        }

        public Criteria andPriceFromNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_from not between", value1, value2, "priceFrom");
            return (Criteria) this;
        }

        public Criteria andPriceToIsNull() {
            addCriterion("price_to is null");
            return (Criteria) this;
        }

        public Criteria andPriceToIsNotNull() {
            addCriterion("price_to is not null");
            return (Criteria) this;
        }

        public Criteria andPriceToEqualTo(BigDecimal value) {
            addCriterion("price_to =", value, "priceTo");
            return (Criteria) this;
        }

        public Criteria andPriceToNotEqualTo(BigDecimal value) {
            addCriterion("price_to <>", value, "priceTo");
            return (Criteria) this;
        }

        public Criteria andPriceToGreaterThan(BigDecimal value) {
            addCriterion("price_to >", value, "priceTo");
            return (Criteria) this;
        }

        public Criteria andPriceToGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("price_to >=", value, "priceTo");
            return (Criteria) this;
        }

        public Criteria andPriceToLessThan(BigDecimal value) {
            addCriterion("price_to <", value, "priceTo");
            return (Criteria) this;
        }

        public Criteria andPriceToLessThanOrEqualTo(BigDecimal value) {
            addCriterion("price_to <=", value, "priceTo");
            return (Criteria) this;
        }

        public Criteria andPriceToIn(List<BigDecimal> values) {
            addCriterion("price_to in", values, "priceTo");
            return (Criteria) this;
        }

        public Criteria andPriceToNotIn(List<BigDecimal> values) {
            addCriterion("price_to not in", values, "priceTo");
            return (Criteria) this;
        }

        public Criteria andPriceToBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_to between", value1, value2, "priceTo");
            return (Criteria) this;
        }

        public Criteria andPriceToNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("price_to not between", value1, value2, "priceTo");
            return (Criteria) this;
        }

        public Criteria andPriceChangeReasonIsNull() {
            addCriterion("price_change_reason is null");
            return (Criteria) this;
        }

        public Criteria andPriceChangeReasonIsNotNull() {
            addCriterion("price_change_reason is not null");
            return (Criteria) this;
        }

        public Criteria andPriceChangeReasonEqualTo(String value) {
            addCriterion("price_change_reason =", value, "priceChangeReason");
            return (Criteria) this;
        }

        public Criteria andPriceChangeReasonNotEqualTo(String value) {
            addCriterion("price_change_reason <>", value, "priceChangeReason");
            return (Criteria) this;
        }

        public Criteria andPriceChangeReasonGreaterThan(String value) {
            addCriterion("price_change_reason >", value, "priceChangeReason");
            return (Criteria) this;
        }

        public Criteria andPriceChangeReasonGreaterThanOrEqualTo(String value) {
            addCriterion("price_change_reason >=", value, "priceChangeReason");
            return (Criteria) this;
        }

        public Criteria andPriceChangeReasonLessThan(String value) {
            addCriterion("price_change_reason <", value, "priceChangeReason");
            return (Criteria) this;
        }

        public Criteria andPriceChangeReasonLessThanOrEqualTo(String value) {
            addCriterion("price_change_reason <=", value, "priceChangeReason");
            return (Criteria) this;
        }

        public Criteria andPriceChangeReasonLike(String value) {
            addCriterion("price_change_reason like", value, "priceChangeReason");
            return (Criteria) this;
        }

        public Criteria andPriceChangeReasonNotLike(String value) {
            addCriterion("price_change_reason not like", value, "priceChangeReason");
            return (Criteria) this;
        }

        public Criteria andPriceChangeReasonIn(List<String> values) {
            addCriterion("price_change_reason in", values, "priceChangeReason");
            return (Criteria) this;
        }

        public Criteria andPriceChangeReasonNotIn(List<String> values) {
            addCriterion("price_change_reason not in", values, "priceChangeReason");
            return (Criteria) this;
        }

        public Criteria andPriceChangeReasonBetween(String value1, String value2) {
            addCriterion("price_change_reason between", value1, value2, "priceChangeReason");
            return (Criteria) this;
        }

        public Criteria andPriceChangeReasonNotBetween(String value1, String value2) {
            addCriterion("price_change_reason not between", value1, value2, "priceChangeReason");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNull() {
            addCriterion("update_by is null");
            return (Criteria) this;
        }

        public Criteria andUpdateByIsNotNull() {
            addCriterion("update_by is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateByEqualTo(String value) {
            addCriterion("update_by =", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotEqualTo(String value) {
            addCriterion("update_by <>", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThan(String value) {
            addCriterion("update_by >", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByGreaterThanOrEqualTo(String value) {
            addCriterion("update_by >=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThan(String value) {
            addCriterion("update_by <", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLessThanOrEqualTo(String value) {
            addCriterion("update_by <=", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByLike(String value) {
            addCriterion("update_by like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotLike(String value) {
            addCriterion("update_by not like", value, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByIn(List<String> values) {
            addCriterion("update_by in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotIn(List<String> values) {
            addCriterion("update_by not in", values, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByBetween(String value1, String value2) {
            addCriterion("update_by between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateByNotBetween(String value1, String value2) {
            addCriterion("update_by not between", value1, value2, "updateBy");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andPriceChangeReasonLikeInsensitive(String value) {
            addCriterion("upper(price_change_reason) like", value.toUpperCase(), "priceChangeReason");
            return (Criteria) this;
        }

        public Criteria andUpdateByLikeInsensitive(String value) {
            addCriterion("upper(update_by) like", value.toUpperCase(), "updateBy");
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