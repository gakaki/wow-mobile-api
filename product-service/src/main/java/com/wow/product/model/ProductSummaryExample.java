package com.wow.product.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductSummaryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductSummaryExample() {
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

        public Criteria andTotalSoldQtyIsNull() {
            addCriterion("total_sold_qty is null");
            return (Criteria) this;
        }

        public Criteria andTotalSoldQtyIsNotNull() {
            addCriterion("total_sold_qty is not null");
            return (Criteria) this;
        }

        public Criteria andTotalSoldQtyEqualTo(Integer value) {
            addCriterion("total_sold_qty =", value, "totalSoldQty");
            return (Criteria) this;
        }

        public Criteria andTotalSoldQtyNotEqualTo(Integer value) {
            addCriterion("total_sold_qty <>", value, "totalSoldQty");
            return (Criteria) this;
        }

        public Criteria andTotalSoldQtyGreaterThan(Integer value) {
            addCriterion("total_sold_qty >", value, "totalSoldQty");
            return (Criteria) this;
        }

        public Criteria andTotalSoldQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_sold_qty >=", value, "totalSoldQty");
            return (Criteria) this;
        }

        public Criteria andTotalSoldQtyLessThan(Integer value) {
            addCriterion("total_sold_qty <", value, "totalSoldQty");
            return (Criteria) this;
        }

        public Criteria andTotalSoldQtyLessThanOrEqualTo(Integer value) {
            addCriterion("total_sold_qty <=", value, "totalSoldQty");
            return (Criteria) this;
        }

        public Criteria andTotalSoldQtyIn(List<Integer> values) {
            addCriterion("total_sold_qty in", values, "totalSoldQty");
            return (Criteria) this;
        }

        public Criteria andTotalSoldQtyNotIn(List<Integer> values) {
            addCriterion("total_sold_qty not in", values, "totalSoldQty");
            return (Criteria) this;
        }

        public Criteria andTotalSoldQtyBetween(Integer value1, Integer value2) {
            addCriterion("total_sold_qty between", value1, value2, "totalSoldQty");
            return (Criteria) this;
        }

        public Criteria andTotalSoldQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("total_sold_qty not between", value1, value2, "totalSoldQty");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSoldQtyIsNull() {
            addCriterion("seven_days_sold_qty is null");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSoldQtyIsNotNull() {
            addCriterion("seven_days_sold_qty is not null");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSoldQtyEqualTo(Integer value) {
            addCriterion("seven_days_sold_qty =", value, "sevenDaysSoldQty");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSoldQtyNotEqualTo(Integer value) {
            addCriterion("seven_days_sold_qty <>", value, "sevenDaysSoldQty");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSoldQtyGreaterThan(Integer value) {
            addCriterion("seven_days_sold_qty >", value, "sevenDaysSoldQty");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSoldQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("seven_days_sold_qty >=", value, "sevenDaysSoldQty");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSoldQtyLessThan(Integer value) {
            addCriterion("seven_days_sold_qty <", value, "sevenDaysSoldQty");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSoldQtyLessThanOrEqualTo(Integer value) {
            addCriterion("seven_days_sold_qty <=", value, "sevenDaysSoldQty");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSoldQtyIn(List<Integer> values) {
            addCriterion("seven_days_sold_qty in", values, "sevenDaysSoldQty");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSoldQtyNotIn(List<Integer> values) {
            addCriterion("seven_days_sold_qty not in", values, "sevenDaysSoldQty");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSoldQtyBetween(Integer value1, Integer value2) {
            addCriterion("seven_days_sold_qty between", value1, value2, "sevenDaysSoldQty");
            return (Criteria) this;
        }

        public Criteria andSevenDaysSoldQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("seven_days_sold_qty not between", value1, value2, "sevenDaysSoldQty");
            return (Criteria) this;
        }

        public Criteria andTotalCommentQtyIsNull() {
            addCriterion("total_comment_qty is null");
            return (Criteria) this;
        }

        public Criteria andTotalCommentQtyIsNotNull() {
            addCriterion("total_comment_qty is not null");
            return (Criteria) this;
        }

        public Criteria andTotalCommentQtyEqualTo(Integer value) {
            addCriterion("total_comment_qty =", value, "totalCommentQty");
            return (Criteria) this;
        }

        public Criteria andTotalCommentQtyNotEqualTo(Integer value) {
            addCriterion("total_comment_qty <>", value, "totalCommentQty");
            return (Criteria) this;
        }

        public Criteria andTotalCommentQtyGreaterThan(Integer value) {
            addCriterion("total_comment_qty >", value, "totalCommentQty");
            return (Criteria) this;
        }

        public Criteria andTotalCommentQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("total_comment_qty >=", value, "totalCommentQty");
            return (Criteria) this;
        }

        public Criteria andTotalCommentQtyLessThan(Integer value) {
            addCriterion("total_comment_qty <", value, "totalCommentQty");
            return (Criteria) this;
        }

        public Criteria andTotalCommentQtyLessThanOrEqualTo(Integer value) {
            addCriterion("total_comment_qty <=", value, "totalCommentQty");
            return (Criteria) this;
        }

        public Criteria andTotalCommentQtyIn(List<Integer> values) {
            addCriterion("total_comment_qty in", values, "totalCommentQty");
            return (Criteria) this;
        }

        public Criteria andTotalCommentQtyNotIn(List<Integer> values) {
            addCriterion("total_comment_qty not in", values, "totalCommentQty");
            return (Criteria) this;
        }

        public Criteria andTotalCommentQtyBetween(Integer value1, Integer value2) {
            addCriterion("total_comment_qty between", value1, value2, "totalCommentQty");
            return (Criteria) this;
        }

        public Criteria andTotalCommentQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("total_comment_qty not between", value1, value2, "totalCommentQty");
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

        public Criteria andIsDeletedIsNull() {
            addCriterion("is_deleted is null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIsNotNull() {
            addCriterion("is_deleted is not null");
            return (Criteria) this;
        }

        public Criteria andIsDeletedEqualTo(Boolean value) {
            addCriterion("is_deleted =", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotEqualTo(Boolean value) {
            addCriterion("is_deleted <>", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThan(Boolean value) {
            addCriterion("is_deleted >", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted >=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThan(Boolean value) {
            addCriterion("is_deleted <", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_deleted <=", value, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedIn(List<Boolean> values) {
            addCriterion("is_deleted in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotIn(List<Boolean> values) {
            addCriterion("is_deleted not in", values, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted between", value1, value2, "isDeleted");
            return (Criteria) this;
        }

        public Criteria andIsDeletedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_deleted not between", value1, value2, "isDeleted");
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