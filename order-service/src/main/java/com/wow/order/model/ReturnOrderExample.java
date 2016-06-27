package com.wow.order.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ReturnOrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ReturnOrderExample() {
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

        public Criteria andOrderIdIsNull() {
            addCriterion("order_id is null");
            return (Criteria) this;
        }

        public Criteria andOrderIdIsNotNull() {
            addCriterion("order_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIdEqualTo(Integer value) {
            addCriterion("order_id =", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotEqualTo(Integer value) {
            addCriterion("order_id <>", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThan(Integer value) {
            addCriterion("order_id >", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_id >=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThan(Integer value) {
            addCriterion("order_id <", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("order_id <=", value, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdIn(List<Integer> values) {
            addCriterion("order_id in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotIn(List<Integer> values) {
            addCriterion("order_id not in", values, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("order_id between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("order_id not between", value1, value2, "orderId");
            return (Criteria) this;
        }

        public Criteria andOrderItemIsNull() {
            addCriterion("order_item is null");
            return (Criteria) this;
        }

        public Criteria andOrderItemIsNotNull() {
            addCriterion("order_item is not null");
            return (Criteria) this;
        }

        public Criteria andOrderItemEqualTo(Integer value) {
            addCriterion("order_item =", value, "orderItem");
            return (Criteria) this;
        }

        public Criteria andOrderItemNotEqualTo(Integer value) {
            addCriterion("order_item <>", value, "orderItem");
            return (Criteria) this;
        }

        public Criteria andOrderItemGreaterThan(Integer value) {
            addCriterion("order_item >", value, "orderItem");
            return (Criteria) this;
        }

        public Criteria andOrderItemGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_item >=", value, "orderItem");
            return (Criteria) this;
        }

        public Criteria andOrderItemLessThan(Integer value) {
            addCriterion("order_item <", value, "orderItem");
            return (Criteria) this;
        }

        public Criteria andOrderItemLessThanOrEqualTo(Integer value) {
            addCriterion("order_item <=", value, "orderItem");
            return (Criteria) this;
        }

        public Criteria andOrderItemIn(List<Integer> values) {
            addCriterion("order_item in", values, "orderItem");
            return (Criteria) this;
        }

        public Criteria andOrderItemNotIn(List<Integer> values) {
            addCriterion("order_item not in", values, "orderItem");
            return (Criteria) this;
        }

        public Criteria andOrderItemBetween(Integer value1, Integer value2) {
            addCriterion("order_item between", value1, value2, "orderItem");
            return (Criteria) this;
        }

        public Criteria andOrderItemNotBetween(Integer value1, Integer value2) {
            addCriterion("order_item not between", value1, value2, "orderItem");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIsNull() {
            addCriterion("order_create_time is null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIsNotNull() {
            addCriterion("order_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeEqualTo(Date value) {
            addCriterion("order_create_time =", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotEqualTo(Date value) {
            addCriterion("order_create_time <>", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeGreaterThan(Date value) {
            addCriterion("order_create_time >", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("order_create_time >=", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeLessThan(Date value) {
            addCriterion("order_create_time <", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("order_create_time <=", value, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeIn(List<Date> values) {
            addCriterion("order_create_time in", values, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotIn(List<Date> values) {
            addCriterion("order_create_time not in", values, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeBetween(Date value1, Date value2) {
            addCriterion("order_create_time between", value1, value2, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andOrderCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("order_create_time not between", value1, value2, "orderCreateTime");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNull() {
            addCriterion("receiver_name is null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIsNotNull() {
            addCriterion("receiver_name is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverNameEqualTo(String value) {
            addCriterion("receiver_name =", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotEqualTo(String value) {
            addCriterion("receiver_name <>", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThan(String value) {
            addCriterion("receiver_name >", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_name >=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThan(String value) {
            addCriterion("receiver_name <", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLessThanOrEqualTo(String value) {
            addCriterion("receiver_name <=", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLike(String value) {
            addCriterion("receiver_name like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotLike(String value) {
            addCriterion("receiver_name not like", value, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameIn(List<String> values) {
            addCriterion("receiver_name in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotIn(List<String> values) {
            addCriterion("receiver_name not in", values, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameBetween(String value1, String value2) {
            addCriterion("receiver_name between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverNameNotBetween(String value1, String value2) {
            addCriterion("receiver_name not between", value1, value2, "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIsNull() {
            addCriterion("receiver_mobile is null");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIsNotNull() {
            addCriterion("receiver_mobile is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileEqualTo(String value) {
            addCriterion("receiver_mobile =", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotEqualTo(String value) {
            addCriterion("receiver_mobile <>", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileGreaterThan(String value) {
            addCriterion("receiver_mobile >", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_mobile >=", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLessThan(String value) {
            addCriterion("receiver_mobile <", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLessThanOrEqualTo(String value) {
            addCriterion("receiver_mobile <=", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLike(String value) {
            addCriterion("receiver_mobile like", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotLike(String value) {
            addCriterion("receiver_mobile not like", value, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileIn(List<String> values) {
            addCriterion("receiver_mobile in", values, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotIn(List<String> values) {
            addCriterion("receiver_mobile not in", values, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileBetween(String value1, String value2) {
            addCriterion("receiver_mobile between", value1, value2, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileNotBetween(String value1, String value2) {
            addCriterion("receiver_mobile not between", value1, value2, "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIsNull() {
            addCriterion("receiver_address is null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIsNotNull() {
            addCriterion("receiver_address is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressEqualTo(String value) {
            addCriterion("receiver_address =", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotEqualTo(String value) {
            addCriterion("receiver_address <>", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThan(String value) {
            addCriterion("receiver_address >", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_address >=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThan(String value) {
            addCriterion("receiver_address <", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLessThanOrEqualTo(String value) {
            addCriterion("receiver_address <=", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLike(String value) {
            addCriterion("receiver_address like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotLike(String value) {
            addCriterion("receiver_address not like", value, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressIn(List<String> values) {
            addCriterion("receiver_address in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotIn(List<String> values) {
            addCriterion("receiver_address not in", values, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressBetween(String value1, String value2) {
            addCriterion("receiver_address between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressNotBetween(String value1, String value2) {
            addCriterion("receiver_address not between", value1, value2, "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReturnTypeIsNull() {
            addCriterion("return_type is null");
            return (Criteria) this;
        }

        public Criteria andReturnTypeIsNotNull() {
            addCriterion("return_type is not null");
            return (Criteria) this;
        }

        public Criteria andReturnTypeEqualTo(Byte value) {
            addCriterion("return_type =", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeNotEqualTo(Byte value) {
            addCriterion("return_type <>", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeGreaterThan(Byte value) {
            addCriterion("return_type >", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("return_type >=", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeLessThan(Byte value) {
            addCriterion("return_type <", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeLessThanOrEqualTo(Byte value) {
            addCriterion("return_type <=", value, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeIn(List<Byte> values) {
            addCriterion("return_type in", values, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeNotIn(List<Byte> values) {
            addCriterion("return_type not in", values, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeBetween(Byte value1, Byte value2) {
            addCriterion("return_type between", value1, value2, "returnType");
            return (Criteria) this;
        }

        public Criteria andReturnTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("return_type not between", value1, value2, "returnType");
            return (Criteria) this;
        }

        public Criteria andIsSubmitByEndUserIsNull() {
            addCriterion("is_submit_by_end_user is null");
            return (Criteria) this;
        }

        public Criteria andIsSubmitByEndUserIsNotNull() {
            addCriterion("is_submit_by_end_user is not null");
            return (Criteria) this;
        }

        public Criteria andIsSubmitByEndUserEqualTo(Boolean value) {
            addCriterion("is_submit_by_end_user =", value, "isSubmitByEndUser");
            return (Criteria) this;
        }

        public Criteria andIsSubmitByEndUserNotEqualTo(Boolean value) {
            addCriterion("is_submit_by_end_user <>", value, "isSubmitByEndUser");
            return (Criteria) this;
        }

        public Criteria andIsSubmitByEndUserGreaterThan(Boolean value) {
            addCriterion("is_submit_by_end_user >", value, "isSubmitByEndUser");
            return (Criteria) this;
        }

        public Criteria andIsSubmitByEndUserGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_submit_by_end_user >=", value, "isSubmitByEndUser");
            return (Criteria) this;
        }

        public Criteria andIsSubmitByEndUserLessThan(Boolean value) {
            addCriterion("is_submit_by_end_user <", value, "isSubmitByEndUser");
            return (Criteria) this;
        }

        public Criteria andIsSubmitByEndUserLessThanOrEqualTo(Boolean value) {
            addCriterion("is_submit_by_end_user <=", value, "isSubmitByEndUser");
            return (Criteria) this;
        }

        public Criteria andIsSubmitByEndUserIn(List<Boolean> values) {
            addCriterion("is_submit_by_end_user in", values, "isSubmitByEndUser");
            return (Criteria) this;
        }

        public Criteria andIsSubmitByEndUserNotIn(List<Boolean> values) {
            addCriterion("is_submit_by_end_user not in", values, "isSubmitByEndUser");
            return (Criteria) this;
        }

        public Criteria andIsSubmitByEndUserBetween(Boolean value1, Boolean value2) {
            addCriterion("is_submit_by_end_user between", value1, value2, "isSubmitByEndUser");
            return (Criteria) this;
        }

        public Criteria andIsSubmitByEndUserNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_submit_by_end_user not between", value1, value2, "isSubmitByEndUser");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNull() {
            addCriterion("submit_time is null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIsNotNull() {
            addCriterion("submit_time is not null");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeEqualTo(Date value) {
            addCriterion("submit_time =", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotEqualTo(Date value) {
            addCriterion("submit_time <>", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThan(Date value) {
            addCriterion("submit_time >", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("submit_time >=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThan(Date value) {
            addCriterion("submit_time <", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeLessThanOrEqualTo(Date value) {
            addCriterion("submit_time <=", value, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeIn(List<Date> values) {
            addCriterion("submit_time in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotIn(List<Date> values) {
            addCriterion("submit_time not in", values, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeBetween(Date value1, Date value2) {
            addCriterion("submit_time between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andSubmitTimeNotBetween(Date value1, Date value2) {
            addCriterion("submit_time not between", value1, value2, "submitTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIsNull() {
            addCriterion("approve_time is null");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIsNotNull() {
            addCriterion("approve_time is not null");
            return (Criteria) this;
        }

        public Criteria andApproveTimeEqualTo(Date value) {
            addCriterion("approve_time =", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotEqualTo(Date value) {
            addCriterion("approve_time <>", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeGreaterThan(Date value) {
            addCriterion("approve_time >", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("approve_time >=", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeLessThan(Date value) {
            addCriterion("approve_time <", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeLessThanOrEqualTo(Date value) {
            addCriterion("approve_time <=", value, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeIn(List<Date> values) {
            addCriterion("approve_time in", values, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotIn(List<Date> values) {
            addCriterion("approve_time not in", values, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeBetween(Date value1, Date value2) {
            addCriterion("approve_time between", value1, value2, "approveTime");
            return (Criteria) this;
        }

        public Criteria andApproveTimeNotBetween(Date value1, Date value2) {
            addCriterion("approve_time not between", value1, value2, "approveTime");
            return (Criteria) this;
        }

        public Criteria andIsApprovedIsNull() {
            addCriterion("is_approved is null");
            return (Criteria) this;
        }

        public Criteria andIsApprovedIsNotNull() {
            addCriterion("is_approved is not null");
            return (Criteria) this;
        }

        public Criteria andIsApprovedEqualTo(Boolean value) {
            addCriterion("is_approved =", value, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedNotEqualTo(Boolean value) {
            addCriterion("is_approved <>", value, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedGreaterThan(Boolean value) {
            addCriterion("is_approved >", value, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_approved >=", value, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedLessThan(Boolean value) {
            addCriterion("is_approved <", value, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_approved <=", value, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedIn(List<Boolean> values) {
            addCriterion("is_approved in", values, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedNotIn(List<Boolean> values) {
            addCriterion("is_approved not in", values, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_approved between", value1, value2, "isApproved");
            return (Criteria) this;
        }

        public Criteria andIsApprovedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_approved not between", value1, value2, "isApproved");
            return (Criteria) this;
        }

        public Criteria andRejectReasonIsNull() {
            addCriterion("reject_reason is null");
            return (Criteria) this;
        }

        public Criteria andRejectReasonIsNotNull() {
            addCriterion("reject_reason is not null");
            return (Criteria) this;
        }

        public Criteria andRejectReasonEqualTo(String value) {
            addCriterion("reject_reason =", value, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonNotEqualTo(String value) {
            addCriterion("reject_reason <>", value, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonGreaterThan(String value) {
            addCriterion("reject_reason >", value, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonGreaterThanOrEqualTo(String value) {
            addCriterion("reject_reason >=", value, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonLessThan(String value) {
            addCriterion("reject_reason <", value, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonLessThanOrEqualTo(String value) {
            addCriterion("reject_reason <=", value, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonLike(String value) {
            addCriterion("reject_reason like", value, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonNotLike(String value) {
            addCriterion("reject_reason not like", value, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonIn(List<String> values) {
            addCriterion("reject_reason in", values, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonNotIn(List<String> values) {
            addCriterion("reject_reason not in", values, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonBetween(String value1, String value2) {
            addCriterion("reject_reason between", value1, value2, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andRejectReasonNotBetween(String value1, String value2) {
            addCriterion("reject_reason not between", value1, value2, "rejectReason");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCodeIsNull() {
            addCriterion("return_order_code is null");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCodeIsNotNull() {
            addCriterion("return_order_code is not null");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCodeEqualTo(String value) {
            addCriterion("return_order_code =", value, "returnOrderCode");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCodeNotEqualTo(String value) {
            addCriterion("return_order_code <>", value, "returnOrderCode");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCodeGreaterThan(String value) {
            addCriterion("return_order_code >", value, "returnOrderCode");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("return_order_code >=", value, "returnOrderCode");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCodeLessThan(String value) {
            addCriterion("return_order_code <", value, "returnOrderCode");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCodeLessThanOrEqualTo(String value) {
            addCriterion("return_order_code <=", value, "returnOrderCode");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCodeLike(String value) {
            addCriterion("return_order_code like", value, "returnOrderCode");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCodeNotLike(String value) {
            addCriterion("return_order_code not like", value, "returnOrderCode");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCodeIn(List<String> values) {
            addCriterion("return_order_code in", values, "returnOrderCode");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCodeNotIn(List<String> values) {
            addCriterion("return_order_code not in", values, "returnOrderCode");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCodeBetween(String value1, String value2) {
            addCriterion("return_order_code between", value1, value2, "returnOrderCode");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCodeNotBetween(String value1, String value2) {
            addCriterion("return_order_code not between", value1, value2, "returnOrderCode");
            return (Criteria) this;
        }

        public Criteria andNeedRefundIsNull() {
            addCriterion("need_refund is null");
            return (Criteria) this;
        }

        public Criteria andNeedRefundIsNotNull() {
            addCriterion("need_refund is not null");
            return (Criteria) this;
        }

        public Criteria andNeedRefundEqualTo(Boolean value) {
            addCriterion("need_refund =", value, "needRefund");
            return (Criteria) this;
        }

        public Criteria andNeedRefundNotEqualTo(Boolean value) {
            addCriterion("need_refund <>", value, "needRefund");
            return (Criteria) this;
        }

        public Criteria andNeedRefundGreaterThan(Boolean value) {
            addCriterion("need_refund >", value, "needRefund");
            return (Criteria) this;
        }

        public Criteria andNeedRefundGreaterThanOrEqualTo(Boolean value) {
            addCriterion("need_refund >=", value, "needRefund");
            return (Criteria) this;
        }

        public Criteria andNeedRefundLessThan(Boolean value) {
            addCriterion("need_refund <", value, "needRefund");
            return (Criteria) this;
        }

        public Criteria andNeedRefundLessThanOrEqualTo(Boolean value) {
            addCriterion("need_refund <=", value, "needRefund");
            return (Criteria) this;
        }

        public Criteria andNeedRefundIn(List<Boolean> values) {
            addCriterion("need_refund in", values, "needRefund");
            return (Criteria) this;
        }

        public Criteria andNeedRefundNotIn(List<Boolean> values) {
            addCriterion("need_refund not in", values, "needRefund");
            return (Criteria) this;
        }

        public Criteria andNeedRefundBetween(Boolean value1, Boolean value2) {
            addCriterion("need_refund between", value1, value2, "needRefund");
            return (Criteria) this;
        }

        public Criteria andNeedRefundNotBetween(Boolean value1, Boolean value2) {
            addCriterion("need_refund not between", value1, value2, "needRefund");
            return (Criteria) this;
        }

        public Criteria andIsRefundedIsNull() {
            addCriterion("is_refunded is null");
            return (Criteria) this;
        }

        public Criteria andIsRefundedIsNotNull() {
            addCriterion("is_refunded is not null");
            return (Criteria) this;
        }

        public Criteria andIsRefundedEqualTo(Boolean value) {
            addCriterion("is_refunded =", value, "isRefunded");
            return (Criteria) this;
        }

        public Criteria andIsRefundedNotEqualTo(Boolean value) {
            addCriterion("is_refunded <>", value, "isRefunded");
            return (Criteria) this;
        }

        public Criteria andIsRefundedGreaterThan(Boolean value) {
            addCriterion("is_refunded >", value, "isRefunded");
            return (Criteria) this;
        }

        public Criteria andIsRefundedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_refunded >=", value, "isRefunded");
            return (Criteria) this;
        }

        public Criteria andIsRefundedLessThan(Boolean value) {
            addCriterion("is_refunded <", value, "isRefunded");
            return (Criteria) this;
        }

        public Criteria andIsRefundedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_refunded <=", value, "isRefunded");
            return (Criteria) this;
        }

        public Criteria andIsRefundedIn(List<Boolean> values) {
            addCriterion("is_refunded in", values, "isRefunded");
            return (Criteria) this;
        }

        public Criteria andIsRefundedNotIn(List<Boolean> values) {
            addCriterion("is_refunded not in", values, "isRefunded");
            return (Criteria) this;
        }

        public Criteria andIsRefundedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_refunded between", value1, value2, "isRefunded");
            return (Criteria) this;
        }

        public Criteria andIsRefundedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_refunded not between", value1, value2, "isRefunded");
            return (Criteria) this;
        }

        public Criteria andIsGoodsSentBackIsNull() {
            addCriterion("is_goods_sent_back is null");
            return (Criteria) this;
        }

        public Criteria andIsGoodsSentBackIsNotNull() {
            addCriterion("is_goods_sent_back is not null");
            return (Criteria) this;
        }

        public Criteria andIsGoodsSentBackEqualTo(Integer value) {
            addCriterion("is_goods_sent_back =", value, "isGoodsSentBack");
            return (Criteria) this;
        }

        public Criteria andIsGoodsSentBackNotEqualTo(Integer value) {
            addCriterion("is_goods_sent_back <>", value, "isGoodsSentBack");
            return (Criteria) this;
        }

        public Criteria andIsGoodsSentBackGreaterThan(Integer value) {
            addCriterion("is_goods_sent_back >", value, "isGoodsSentBack");
            return (Criteria) this;
        }

        public Criteria andIsGoodsSentBackGreaterThanOrEqualTo(Integer value) {
            addCriterion("is_goods_sent_back >=", value, "isGoodsSentBack");
            return (Criteria) this;
        }

        public Criteria andIsGoodsSentBackLessThan(Integer value) {
            addCriterion("is_goods_sent_back <", value, "isGoodsSentBack");
            return (Criteria) this;
        }

        public Criteria andIsGoodsSentBackLessThanOrEqualTo(Integer value) {
            addCriterion("is_goods_sent_back <=", value, "isGoodsSentBack");
            return (Criteria) this;
        }

        public Criteria andIsGoodsSentBackIn(List<Integer> values) {
            addCriterion("is_goods_sent_back in", values, "isGoodsSentBack");
            return (Criteria) this;
        }

        public Criteria andIsGoodsSentBackNotIn(List<Integer> values) {
            addCriterion("is_goods_sent_back not in", values, "isGoodsSentBack");
            return (Criteria) this;
        }

        public Criteria andIsGoodsSentBackBetween(Integer value1, Integer value2) {
            addCriterion("is_goods_sent_back between", value1, value2, "isGoodsSentBack");
            return (Criteria) this;
        }

        public Criteria andIsGoodsSentBackNotBetween(Integer value1, Integer value2) {
            addCriterion("is_goods_sent_back not between", value1, value2, "isGoodsSentBack");
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

        public Criteria andCreateByIsNull() {
            addCriterion("create_by is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("create_by is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(String value) {
            addCriterion("create_by =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(String value) {
            addCriterion("create_by <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(String value) {
            addCriterion("create_by >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(String value) {
            addCriterion("create_by >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(String value) {
            addCriterion("create_by <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(String value) {
            addCriterion("create_by <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLike(String value) {
            addCriterion("create_by like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotLike(String value) {
            addCriterion("create_by not like", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<String> values) {
            addCriterion("create_by in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<String> values) {
            addCriterion("create_by not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(String value1, String value2) {
            addCriterion("create_by between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(String value1, String value2) {
            addCriterion("create_by not between", value1, value2, "createBy");
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

        public Criteria andReceiverNameLikeInsensitive(String value) {
            addCriterion("upper(receiver_name) like", value.toUpperCase(), "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLikeInsensitive(String value) {
            addCriterion("upper(receiver_mobile) like", value.toUpperCase(), "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLikeInsensitive(String value) {
            addCriterion("upper(receiver_address) like", value.toUpperCase(), "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andRejectReasonLikeInsensitive(String value) {
            addCriterion("upper(reject_reason) like", value.toUpperCase(), "rejectReason");
            return (Criteria) this;
        }

        public Criteria andReturnOrderCodeLikeInsensitive(String value) {
            addCriterion("upper(return_order_code) like", value.toUpperCase(), "returnOrderCode");
            return (Criteria) this;
        }

        public Criteria andCreateByLikeInsensitive(String value) {
            addCriterion("upper(create_by) like", value.toUpperCase(), "createBy");
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