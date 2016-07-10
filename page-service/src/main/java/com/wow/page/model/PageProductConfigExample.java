package com.wow.page.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PageProductConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PageProductConfigExample() {
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

        public Criteria andPageTypeIsNull() {
            addCriterion("page_type is null");
            return (Criteria) this;
        }

        public Criteria andPageTypeIsNotNull() {
            addCriterion("page_type is not null");
            return (Criteria) this;
        }

        public Criteria andPageTypeEqualTo(Byte value) {
            addCriterion("page_type =", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeNotEqualTo(Byte value) {
            addCriterion("page_type <>", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeGreaterThan(Byte value) {
            addCriterion("page_type >", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("page_type >=", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeLessThan(Byte value) {
            addCriterion("page_type <", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeLessThanOrEqualTo(Byte value) {
            addCriterion("page_type <=", value, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeIn(List<Byte> values) {
            addCriterion("page_type in", values, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeNotIn(List<Byte> values) {
            addCriterion("page_type not in", values, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeBetween(Byte value1, Byte value2) {
            addCriterion("page_type between", value1, value2, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("page_type not between", value1, value2, "pageType");
            return (Criteria) this;
        }

        public Criteria andPageModuleTypeIsNull() {
            addCriterion("page_module_type is null");
            return (Criteria) this;
        }

        public Criteria andPageModuleTypeIsNotNull() {
            addCriterion("page_module_type is not null");
            return (Criteria) this;
        }

        public Criteria andPageModuleTypeEqualTo(Byte value) {
            addCriterion("page_module_type =", value, "pageModuleType");
            return (Criteria) this;
        }

        public Criteria andPageModuleTypeNotEqualTo(Byte value) {
            addCriterion("page_module_type <>", value, "pageModuleType");
            return (Criteria) this;
        }

        public Criteria andPageModuleTypeGreaterThan(Byte value) {
            addCriterion("page_module_type >", value, "pageModuleType");
            return (Criteria) this;
        }

        public Criteria andPageModuleTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("page_module_type >=", value, "pageModuleType");
            return (Criteria) this;
        }

        public Criteria andPageModuleTypeLessThan(Byte value) {
            addCriterion("page_module_type <", value, "pageModuleType");
            return (Criteria) this;
        }

        public Criteria andPageModuleTypeLessThanOrEqualTo(Byte value) {
            addCriterion("page_module_type <=", value, "pageModuleType");
            return (Criteria) this;
        }

        public Criteria andPageModuleTypeIn(List<Byte> values) {
            addCriterion("page_module_type in", values, "pageModuleType");
            return (Criteria) this;
        }

        public Criteria andPageModuleTypeNotIn(List<Byte> values) {
            addCriterion("page_module_type not in", values, "pageModuleType");
            return (Criteria) this;
        }

        public Criteria andPageModuleTypeBetween(Byte value1, Byte value2) {
            addCriterion("page_module_type between", value1, value2, "pageModuleType");
            return (Criteria) this;
        }

        public Criteria andPageModuleTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("page_module_type not between", value1, value2, "pageModuleType");
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

        public Criteria andProductImgIsNull() {
            addCriterion("product_img is null");
            return (Criteria) this;
        }

        public Criteria andProductImgIsNotNull() {
            addCriterion("product_img is not null");
            return (Criteria) this;
        }

        public Criteria andProductImgEqualTo(String value) {
            addCriterion("product_img =", value, "productImg");
            return (Criteria) this;
        }

        public Criteria andProductImgNotEqualTo(String value) {
            addCriterion("product_img <>", value, "productImg");
            return (Criteria) this;
        }

        public Criteria andProductImgGreaterThan(String value) {
            addCriterion("product_img >", value, "productImg");
            return (Criteria) this;
        }

        public Criteria andProductImgGreaterThanOrEqualTo(String value) {
            addCriterion("product_img >=", value, "productImg");
            return (Criteria) this;
        }

        public Criteria andProductImgLessThan(String value) {
            addCriterion("product_img <", value, "productImg");
            return (Criteria) this;
        }

        public Criteria andProductImgLessThanOrEqualTo(String value) {
            addCriterion("product_img <=", value, "productImg");
            return (Criteria) this;
        }

        public Criteria andProductImgLike(String value) {
            addCriterion("product_img like", value, "productImg");
            return (Criteria) this;
        }

        public Criteria andProductImgNotLike(String value) {
            addCriterion("product_img not like", value, "productImg");
            return (Criteria) this;
        }

        public Criteria andProductImgIn(List<String> values) {
            addCriterion("product_img in", values, "productImg");
            return (Criteria) this;
        }

        public Criteria andProductImgNotIn(List<String> values) {
            addCriterion("product_img not in", values, "productImg");
            return (Criteria) this;
        }

        public Criteria andProductImgBetween(String value1, String value2) {
            addCriterion("product_img between", value1, value2, "productImg");
            return (Criteria) this;
        }

        public Criteria andProductImgNotBetween(String value1, String value2) {
            addCriterion("product_img not between", value1, value2, "productImg");
            return (Criteria) this;
        }

        public Criteria andLocationSortIsNull() {
            addCriterion("location_sort is null");
            return (Criteria) this;
        }

        public Criteria andLocationSortIsNotNull() {
            addCriterion("location_sort is not null");
            return (Criteria) this;
        }

        public Criteria andLocationSortEqualTo(Byte value) {
            addCriterion("location_sort =", value, "locationSort");
            return (Criteria) this;
        }

        public Criteria andLocationSortNotEqualTo(Byte value) {
            addCriterion("location_sort <>", value, "locationSort");
            return (Criteria) this;
        }

        public Criteria andLocationSortGreaterThan(Byte value) {
            addCriterion("location_sort >", value, "locationSort");
            return (Criteria) this;
        }

        public Criteria andLocationSortGreaterThanOrEqualTo(Byte value) {
            addCriterion("location_sort >=", value, "locationSort");
            return (Criteria) this;
        }

        public Criteria andLocationSortLessThan(Byte value) {
            addCriterion("location_sort <", value, "locationSort");
            return (Criteria) this;
        }

        public Criteria andLocationSortLessThanOrEqualTo(Byte value) {
            addCriterion("location_sort <=", value, "locationSort");
            return (Criteria) this;
        }

        public Criteria andLocationSortIn(List<Byte> values) {
            addCriterion("location_sort in", values, "locationSort");
            return (Criteria) this;
        }

        public Criteria andLocationSortNotIn(List<Byte> values) {
            addCriterion("location_sort not in", values, "locationSort");
            return (Criteria) this;
        }

        public Criteria andLocationSortBetween(Byte value1, Byte value2) {
            addCriterion("location_sort between", value1, value2, "locationSort");
            return (Criteria) this;
        }

        public Criteria andLocationSortNotBetween(Byte value1, Byte value2) {
            addCriterion("location_sort not between", value1, value2, "locationSort");
            return (Criteria) this;
        }

        public Criteria andValidFromIsNull() {
            addCriterion("valid_from is null");
            return (Criteria) this;
        }

        public Criteria andValidFromIsNotNull() {
            addCriterion("valid_from is not null");
            return (Criteria) this;
        }

        public Criteria andValidFromEqualTo(Date value) {
            addCriterion("valid_from =", value, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromNotEqualTo(Date value) {
            addCriterion("valid_from <>", value, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromGreaterThan(Date value) {
            addCriterion("valid_from >", value, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromGreaterThanOrEqualTo(Date value) {
            addCriterion("valid_from >=", value, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromLessThan(Date value) {
            addCriterion("valid_from <", value, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromLessThanOrEqualTo(Date value) {
            addCriterion("valid_from <=", value, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromIn(List<Date> values) {
            addCriterion("valid_from in", values, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromNotIn(List<Date> values) {
            addCriterion("valid_from not in", values, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromBetween(Date value1, Date value2) {
            addCriterion("valid_from between", value1, value2, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidFromNotBetween(Date value1, Date value2) {
            addCriterion("valid_from not between", value1, value2, "validFrom");
            return (Criteria) this;
        }

        public Criteria andValidToIsNull() {
            addCriterion("valid_to is null");
            return (Criteria) this;
        }

        public Criteria andValidToIsNotNull() {
            addCriterion("valid_to is not null");
            return (Criteria) this;
        }

        public Criteria andValidToEqualTo(Date value) {
            addCriterion("valid_to =", value, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToNotEqualTo(Date value) {
            addCriterion("valid_to <>", value, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToGreaterThan(Date value) {
            addCriterion("valid_to >", value, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToGreaterThanOrEqualTo(Date value) {
            addCriterion("valid_to >=", value, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToLessThan(Date value) {
            addCriterion("valid_to <", value, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToLessThanOrEqualTo(Date value) {
            addCriterion("valid_to <=", value, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToIn(List<Date> values) {
            addCriterion("valid_to in", values, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToNotIn(List<Date> values) {
            addCriterion("valid_to not in", values, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToBetween(Date value1, Date value2) {
            addCriterion("valid_to between", value1, value2, "validTo");
            return (Criteria) this;
        }

        public Criteria andValidToNotBetween(Date value1, Date value2) {
            addCriterion("valid_to not between", value1, value2, "validTo");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIsNull() {
            addCriterion("is_enabled is null");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIsNotNull() {
            addCriterion("is_enabled is not null");
            return (Criteria) this;
        }

        public Criteria andIsEnabledEqualTo(Boolean value) {
            addCriterion("is_enabled =", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotEqualTo(Boolean value) {
            addCriterion("is_enabled <>", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledGreaterThan(Boolean value) {
            addCriterion("is_enabled >", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_enabled >=", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledLessThan(Boolean value) {
            addCriterion("is_enabled <", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledLessThanOrEqualTo(Boolean value) {
            addCriterion("is_enabled <=", value, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledIn(List<Boolean> values) {
            addCriterion("is_enabled in", values, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotIn(List<Boolean> values) {
            addCriterion("is_enabled not in", values, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledBetween(Boolean value1, Boolean value2) {
            addCriterion("is_enabled between", value1, value2, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andIsEnabledNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_enabled not between", value1, value2, "isEnabled");
            return (Criteria) this;
        }

        public Criteria andProductImgLikeInsensitive(String value) {
            addCriterion("upper(product_img) like", value.toUpperCase(), "productImg");
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