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

        public Criteria andKeyIsNull() {
            addCriterion("key is null");
            return (Criteria) this;
        }

        public Criteria andKeyIsNotNull() {
            addCriterion("key is not null");
            return (Criteria) this;
        }

        public Criteria andKeyEqualTo(String value) {
            addCriterion("key =", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotEqualTo(String value) {
            addCriterion("key <>", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThan(String value) {
            addCriterion("key >", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyGreaterThanOrEqualTo(String value) {
            addCriterion("key >=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThan(String value) {
            addCriterion("key <", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLessThanOrEqualTo(String value) {
            addCriterion("key <=", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyLike(String value) {
            addCriterion("key like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotLike(String value) {
            addCriterion("key not like", value, "key");
            return (Criteria) this;
        }

        public Criteria andKeyIn(List<String> values) {
            addCriterion("key in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotIn(List<String> values) {
            addCriterion("key not in", values, "key");
            return (Criteria) this;
        }

        public Criteria andKeyBetween(String value1, String value2) {
            addCriterion("key between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andKeyNotBetween(String value1, String value2) {
            addCriterion("key not between", value1, value2, "key");
            return (Criteria) this;
        }

        public Criteria andValueIsNull() {
            addCriterion("value is null");
            return (Criteria) this;
        }

        public Criteria andValueIsNotNull() {
            addCriterion("value is not null");
            return (Criteria) this;
        }

        public Criteria andValueEqualTo(String value) {
            addCriterion("value =", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotEqualTo(String value) {
            addCriterion("value <>", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThan(String value) {
            addCriterion("value >", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueGreaterThanOrEqualTo(String value) {
            addCriterion("value >=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThan(String value) {
            addCriterion("value <", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLessThanOrEqualTo(String value) {
            addCriterion("value <=", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueLike(String value) {
            addCriterion("value like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotLike(String value) {
            addCriterion("value not like", value, "value");
            return (Criteria) this;
        }

        public Criteria andValueIn(List<String> values) {
            addCriterion("value in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotIn(List<String> values) {
            addCriterion("value not in", values, "value");
            return (Criteria) this;
        }

        public Criteria andValueBetween(String value1, String value2) {
            addCriterion("value between", value1, value2, "value");
            return (Criteria) this;
        }

        public Criteria andValueNotBetween(String value1, String value2) {
            addCriterion("value not between", value1, value2, "value");
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

        public Criteria andKeyOrderEqualTo(Byte value) {
            addCriterion("key_order =", value, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andKeyOrderNotEqualTo(Byte value) {
            addCriterion("key_order <>", value, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andKeyOrderGreaterThan(Byte value) {
            addCriterion("key_order >", value, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andKeyOrderGreaterThanOrEqualTo(Byte value) {
            addCriterion("key_order >=", value, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andKeyOrderLessThan(Byte value) {
            addCriterion("key_order <", value, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andKeyOrderLessThanOrEqualTo(Byte value) {
            addCriterion("key_order <=", value, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andKeyOrderIn(List<Byte> values) {
            addCriterion("key_order in", values, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andKeyOrderNotIn(List<Byte> values) {
            addCriterion("key_order not in", values, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andKeyOrderBetween(Byte value1, Byte value2) {
            addCriterion("key_order between", value1, value2, "keyOrder");
            return (Criteria) this;
        }

        public Criteria andKeyOrderNotBetween(Byte value1, Byte value2) {
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

        public Criteria andKeyLikeInsensitive(String value) {
            addCriterion("upper(key) like", value.toUpperCase(), "key");
            return (Criteria) this;
        }

        public Criteria andValueLikeInsensitive(String value) {
            addCriterion("upper(value) like", value.toUpperCase(), "value");
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