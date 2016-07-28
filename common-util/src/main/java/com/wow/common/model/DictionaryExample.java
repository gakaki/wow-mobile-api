package com.wow.common.model;

import java.util.ArrayList;
import java.util.List;

public class DictionaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DictionaryExample() {
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

        public Criteria andKeyNameIsNull() {
            addCriterion("key_name is null");
            return (Criteria) this;
        }

        public Criteria andKeyNameIsNotNull() {
            addCriterion("key_name is not null");
            return (Criteria) this;
        }

        public Criteria andKeyNameEqualTo(String value) {
            addCriterion("key_name =", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameNotEqualTo(String value) {
            addCriterion("key_name <>", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameGreaterThan(String value) {
            addCriterion("key_name >", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameGreaterThanOrEqualTo(String value) {
            addCriterion("key_name >=", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameLessThan(String value) {
            addCriterion("key_name <", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameLessThanOrEqualTo(String value) {
            addCriterion("key_name <=", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameLike(String value) {
            addCriterion("key_name like", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameNotLike(String value) {
            addCriterion("key_name not like", value, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameIn(List<String> values) {
            addCriterion("key_name in", values, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameNotIn(List<String> values) {
            addCriterion("key_name not in", values, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameBetween(String value1, String value2) {
            addCriterion("key_name between", value1, value2, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyNameNotBetween(String value1, String value2) {
            addCriterion("key_name not between", value1, value2, "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyValueIsNull() {
            addCriterion("key_value is null");
            return (Criteria) this;
        }

        public Criteria andKeyValueIsNotNull() {
            addCriterion("key_value is not null");
            return (Criteria) this;
        }

        public Criteria andKeyValueEqualTo(String value) {
            addCriterion("key_value =", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotEqualTo(String value) {
            addCriterion("key_value <>", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueGreaterThan(String value) {
            addCriterion("key_value >", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueGreaterThanOrEqualTo(String value) {
            addCriterion("key_value >=", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueLessThan(String value) {
            addCriterion("key_value <", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueLessThanOrEqualTo(String value) {
            addCriterion("key_value <=", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueLike(String value) {
            addCriterion("key_value like", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotLike(String value) {
            addCriterion("key_value not like", value, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueIn(List<String> values) {
            addCriterion("key_value in", values, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotIn(List<String> values) {
            addCriterion("key_value not in", values, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueBetween(String value1, String value2) {
            addCriterion("key_value between", value1, value2, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyValueNotBetween(String value1, String value2) {
            addCriterion("key_value not between", value1, value2, "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyGroupIsNull() {
            addCriterion("key_group is null");
            return (Criteria) this;
        }

        public Criteria andKeyGroupIsNotNull() {
            addCriterion("key_group is not null");
            return (Criteria) this;
        }

        public Criteria andKeyGroupEqualTo(String value) {
            addCriterion("key_group =", value, "keyGroup");
            return (Criteria) this;
        }

        public Criteria andKeyGroupNotEqualTo(String value) {
            addCriterion("key_group <>", value, "keyGroup");
            return (Criteria) this;
        }

        public Criteria andKeyGroupGreaterThan(String value) {
            addCriterion("key_group >", value, "keyGroup");
            return (Criteria) this;
        }

        public Criteria andKeyGroupGreaterThanOrEqualTo(String value) {
            addCriterion("key_group >=", value, "keyGroup");
            return (Criteria) this;
        }

        public Criteria andKeyGroupLessThan(String value) {
            addCriterion("key_group <", value, "keyGroup");
            return (Criteria) this;
        }

        public Criteria andKeyGroupLessThanOrEqualTo(String value) {
            addCriterion("key_group <=", value, "keyGroup");
            return (Criteria) this;
        }

        public Criteria andKeyGroupLike(String value) {
            addCriterion("key_group like", value, "keyGroup");
            return (Criteria) this;
        }

        public Criteria andKeyGroupNotLike(String value) {
            addCriterion("key_group not like", value, "keyGroup");
            return (Criteria) this;
        }

        public Criteria andKeyGroupIn(List<String> values) {
            addCriterion("key_group in", values, "keyGroup");
            return (Criteria) this;
        }

        public Criteria andKeyGroupNotIn(List<String> values) {
            addCriterion("key_group not in", values, "keyGroup");
            return (Criteria) this;
        }

        public Criteria andKeyGroupBetween(String value1, String value2) {
            addCriterion("key_group between", value1, value2, "keyGroup");
            return (Criteria) this;
        }

        public Criteria andKeyGroupNotBetween(String value1, String value2) {
            addCriterion("key_group not between", value1, value2, "keyGroup");
            return (Criteria) this;
        }

        public Criteria andKeyDescIsNull() {
            addCriterion("key_desc is null");
            return (Criteria) this;
        }

        public Criteria andKeyDescIsNotNull() {
            addCriterion("key_desc is not null");
            return (Criteria) this;
        }

        public Criteria andKeyDescEqualTo(String value) {
            addCriterion("key_desc =", value, "keyDesc");
            return (Criteria) this;
        }

        public Criteria andKeyDescNotEqualTo(String value) {
            addCriterion("key_desc <>", value, "keyDesc");
            return (Criteria) this;
        }

        public Criteria andKeyDescGreaterThan(String value) {
            addCriterion("key_desc >", value, "keyDesc");
            return (Criteria) this;
        }

        public Criteria andKeyDescGreaterThanOrEqualTo(String value) {
            addCriterion("key_desc >=", value, "keyDesc");
            return (Criteria) this;
        }

        public Criteria andKeyDescLessThan(String value) {
            addCriterion("key_desc <", value, "keyDesc");
            return (Criteria) this;
        }

        public Criteria andKeyDescLessThanOrEqualTo(String value) {
            addCriterion("key_desc <=", value, "keyDesc");
            return (Criteria) this;
        }

        public Criteria andKeyDescLike(String value) {
            addCriterion("key_desc like", value, "keyDesc");
            return (Criteria) this;
        }

        public Criteria andKeyDescNotLike(String value) {
            addCriterion("key_desc not like", value, "keyDesc");
            return (Criteria) this;
        }

        public Criteria andKeyDescIn(List<String> values) {
            addCriterion("key_desc in", values, "keyDesc");
            return (Criteria) this;
        }

        public Criteria andKeyDescNotIn(List<String> values) {
            addCriterion("key_desc not in", values, "keyDesc");
            return (Criteria) this;
        }

        public Criteria andKeyDescBetween(String value1, String value2) {
            addCriterion("key_desc between", value1, value2, "keyDesc");
            return (Criteria) this;
        }

        public Criteria andKeyDescNotBetween(String value1, String value2) {
            addCriterion("key_desc not between", value1, value2, "keyDesc");
            return (Criteria) this;
        }

        public Criteria andKeyOrderIsNull() {
            addCriterion("key_order is null");
            return (Criteria) this;
        }

        public Criteria andKeyOrderIsNotNull() {
            addCriterion("key_order is not null");
            return (Criteria) this;
        }

        public Criteria andKeyOrderEqualTo(Short value) {
            addCriterion("key_order =", value, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andKeyOrderNotEqualTo(Short value) {
            addCriterion("key_order <>", value, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andKeyOrderGreaterThan(Short value) {
            addCriterion("key_order >", value, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andKeyOrderGreaterThanOrEqualTo(Short value) {
            addCriterion("key_order >=", value, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andKeyOrderLessThan(Short value) {
            addCriterion("key_order <", value, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andKeyOrderLessThanOrEqualTo(Short value) {
            addCriterion("key_order <=", value, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andKeyOrderIn(List<Short> values) {
            addCriterion("key_order in", values, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andKeyOrderNotIn(List<Short> values) {
            addCriterion("key_order not in", values, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andKeyOrderBetween(Short value1, Short value2) {
            addCriterion("key_order between", value1, value2, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andKeyOrderNotBetween(Short value1, Short value2) {
            addCriterion("key_order not between", value1, value2, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNull() {
            addCriterion("is_valid is null");
            return (Criteria) this;
        }

        public Criteria andIsValidIsNotNull() {
            addCriterion("is_valid is not null");
            return (Criteria) this;
        }

        public Criteria andIsValidEqualTo(Boolean value) {
            addCriterion("is_valid =", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotEqualTo(Boolean value) {
            addCriterion("is_valid <>", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThan(Boolean value) {
            addCriterion("is_valid >", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_valid >=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThan(Boolean value) {
            addCriterion("is_valid <", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidLessThanOrEqualTo(Boolean value) {
            addCriterion("is_valid <=", value, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidIn(List<Boolean> values) {
            addCriterion("is_valid in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotIn(List<Boolean> values) {
            addCriterion("is_valid not in", values, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidBetween(Boolean value1, Boolean value2) {
            addCriterion("is_valid between", value1, value2, "isValid");
            return (Criteria) this;
        }

        public Criteria andIsValidNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_valid not between", value1, value2, "isValid");
            return (Criteria) this;
        }

        public Criteria andKeyNameLikeInsensitive(String value) {
            addCriterion("upper(key_name) like", value.toUpperCase(), "keyName");
            return (Criteria) this;
        }

        public Criteria andKeyValueLikeInsensitive(String value) {
            addCriterion("upper(key_value) like", value.toUpperCase(), "keyValue");
            return (Criteria) this;
        }

        public Criteria andKeyGroupLikeInsensitive(String value) {
            addCriterion("upper(key_group) like", value.toUpperCase(), "keyGroup");
            return (Criteria) this;
        }

        public Criteria andKeyDescLikeInsensitive(String value) {
            addCriterion("upper(key_desc) like", value.toUpperCase(), "keyDesc");
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