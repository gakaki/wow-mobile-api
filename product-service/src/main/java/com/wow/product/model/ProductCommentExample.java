package com.wow.product.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductCommentExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductCommentExample() {
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

        public Criteria andPackagingScoreIsNull() {
            addCriterion("packaging_score is null");
            return (Criteria) this;
        }

        public Criteria andPackagingScoreIsNotNull() {
            addCriterion("packaging_score is not null");
            return (Criteria) this;
        }

        public Criteria andPackagingScoreEqualTo(Byte value) {
            addCriterion("packaging_score =", value, "packagingScore");
            return (Criteria) this;
        }

        public Criteria andPackagingScoreNotEqualTo(Byte value) {
            addCriterion("packaging_score <>", value, "packagingScore");
            return (Criteria) this;
        }

        public Criteria andPackagingScoreGreaterThan(Byte value) {
            addCriterion("packaging_score >", value, "packagingScore");
            return (Criteria) this;
        }

        public Criteria andPackagingScoreGreaterThanOrEqualTo(Byte value) {
            addCriterion("packaging_score >=", value, "packagingScore");
            return (Criteria) this;
        }

        public Criteria andPackagingScoreLessThan(Byte value) {
            addCriterion("packaging_score <", value, "packagingScore");
            return (Criteria) this;
        }

        public Criteria andPackagingScoreLessThanOrEqualTo(Byte value) {
            addCriterion("packaging_score <=", value, "packagingScore");
            return (Criteria) this;
        }

        public Criteria andPackagingScoreIn(List<Byte> values) {
            addCriterion("packaging_score in", values, "packagingScore");
            return (Criteria) this;
        }

        public Criteria andPackagingScoreNotIn(List<Byte> values) {
            addCriterion("packaging_score not in", values, "packagingScore");
            return (Criteria) this;
        }

        public Criteria andPackagingScoreBetween(Byte value1, Byte value2) {
            addCriterion("packaging_score between", value1, value2, "packagingScore");
            return (Criteria) this;
        }

        public Criteria andPackagingScoreNotBetween(Byte value1, Byte value2) {
            addCriterion("packaging_score not between", value1, value2, "packagingScore");
            return (Criteria) this;
        }

        public Criteria andDeliverySpeedScoreIsNull() {
            addCriterion("delivery_speed_score is null");
            return (Criteria) this;
        }

        public Criteria andDeliverySpeedScoreIsNotNull() {
            addCriterion("delivery_speed_score is not null");
            return (Criteria) this;
        }

        public Criteria andDeliverySpeedScoreEqualTo(Byte value) {
            addCriterion("delivery_speed_score =", value, "deliverySpeedScore");
            return (Criteria) this;
        }

        public Criteria andDeliverySpeedScoreNotEqualTo(Byte value) {
            addCriterion("delivery_speed_score <>", value, "deliverySpeedScore");
            return (Criteria) this;
        }

        public Criteria andDeliverySpeedScoreGreaterThan(Byte value) {
            addCriterion("delivery_speed_score >", value, "deliverySpeedScore");
            return (Criteria) this;
        }

        public Criteria andDeliverySpeedScoreGreaterThanOrEqualTo(Byte value) {
            addCriterion("delivery_speed_score >=", value, "deliverySpeedScore");
            return (Criteria) this;
        }

        public Criteria andDeliverySpeedScoreLessThan(Byte value) {
            addCriterion("delivery_speed_score <", value, "deliverySpeedScore");
            return (Criteria) this;
        }

        public Criteria andDeliverySpeedScoreLessThanOrEqualTo(Byte value) {
            addCriterion("delivery_speed_score <=", value, "deliverySpeedScore");
            return (Criteria) this;
        }

        public Criteria andDeliverySpeedScoreIn(List<Byte> values) {
            addCriterion("delivery_speed_score in", values, "deliverySpeedScore");
            return (Criteria) this;
        }

        public Criteria andDeliverySpeedScoreNotIn(List<Byte> values) {
            addCriterion("delivery_speed_score not in", values, "deliverySpeedScore");
            return (Criteria) this;
        }

        public Criteria andDeliverySpeedScoreBetween(Byte value1, Byte value2) {
            addCriterion("delivery_speed_score between", value1, value2, "deliverySpeedScore");
            return (Criteria) this;
        }

        public Criteria andDeliverySpeedScoreNotBetween(Byte value1, Byte value2) {
            addCriterion("delivery_speed_score not between", value1, value2, "deliverySpeedScore");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceAttituteScoreIsNull() {
            addCriterion("delivery_service_attitute_score is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceAttituteScoreIsNotNull() {
            addCriterion("delivery_service_attitute_score is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceAttituteScoreEqualTo(Byte value) {
            addCriterion("delivery_service_attitute_score =", value, "deliveryServiceAttituteScore");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceAttituteScoreNotEqualTo(Byte value) {
            addCriterion("delivery_service_attitute_score <>", value, "deliveryServiceAttituteScore");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceAttituteScoreGreaterThan(Byte value) {
            addCriterion("delivery_service_attitute_score >", value, "deliveryServiceAttituteScore");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceAttituteScoreGreaterThanOrEqualTo(Byte value) {
            addCriterion("delivery_service_attitute_score >=", value, "deliveryServiceAttituteScore");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceAttituteScoreLessThan(Byte value) {
            addCriterion("delivery_service_attitute_score <", value, "deliveryServiceAttituteScore");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceAttituteScoreLessThanOrEqualTo(Byte value) {
            addCriterion("delivery_service_attitute_score <=", value, "deliveryServiceAttituteScore");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceAttituteScoreIn(List<Byte> values) {
            addCriterion("delivery_service_attitute_score in", values, "deliveryServiceAttituteScore");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceAttituteScoreNotIn(List<Byte> values) {
            addCriterion("delivery_service_attitute_score not in", values, "deliveryServiceAttituteScore");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceAttituteScoreBetween(Byte value1, Byte value2) {
            addCriterion("delivery_service_attitute_score between", value1, value2, "deliveryServiceAttituteScore");
            return (Criteria) this;
        }

        public Criteria andDeliveryServiceAttituteScoreNotBetween(Byte value1, Byte value2) {
            addCriterion("delivery_service_attitute_score not between", value1, value2, "deliveryServiceAttituteScore");
            return (Criteria) this;
        }

        public Criteria andProductSatisfactionScoreIsNull() {
            addCriterion("product_satisfaction_score is null");
            return (Criteria) this;
        }

        public Criteria andProductSatisfactionScoreIsNotNull() {
            addCriterion("product_satisfaction_score is not null");
            return (Criteria) this;
        }

        public Criteria andProductSatisfactionScoreEqualTo(Byte value) {
            addCriterion("product_satisfaction_score =", value, "productSatisfactionScore");
            return (Criteria) this;
        }

        public Criteria andProductSatisfactionScoreNotEqualTo(Byte value) {
            addCriterion("product_satisfaction_score <>", value, "productSatisfactionScore");
            return (Criteria) this;
        }

        public Criteria andProductSatisfactionScoreGreaterThan(Byte value) {
            addCriterion("product_satisfaction_score >", value, "productSatisfactionScore");
            return (Criteria) this;
        }

        public Criteria andProductSatisfactionScoreGreaterThanOrEqualTo(Byte value) {
            addCriterion("product_satisfaction_score >=", value, "productSatisfactionScore");
            return (Criteria) this;
        }

        public Criteria andProductSatisfactionScoreLessThan(Byte value) {
            addCriterion("product_satisfaction_score <", value, "productSatisfactionScore");
            return (Criteria) this;
        }

        public Criteria andProductSatisfactionScoreLessThanOrEqualTo(Byte value) {
            addCriterion("product_satisfaction_score <=", value, "productSatisfactionScore");
            return (Criteria) this;
        }

        public Criteria andProductSatisfactionScoreIn(List<Byte> values) {
            addCriterion("product_satisfaction_score in", values, "productSatisfactionScore");
            return (Criteria) this;
        }

        public Criteria andProductSatisfactionScoreNotIn(List<Byte> values) {
            addCriterion("product_satisfaction_score not in", values, "productSatisfactionScore");
            return (Criteria) this;
        }

        public Criteria andProductSatisfactionScoreBetween(Byte value1, Byte value2) {
            addCriterion("product_satisfaction_score between", value1, value2, "productSatisfactionScore");
            return (Criteria) this;
        }

        public Criteria andProductSatisfactionScoreNotBetween(Byte value1, Byte value2) {
            addCriterion("product_satisfaction_score not between", value1, value2, "productSatisfactionScore");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNull() {
            addCriterion("comments is null");
            return (Criteria) this;
        }

        public Criteria andCommentsIsNotNull() {
            addCriterion("comments is not null");
            return (Criteria) this;
        }

        public Criteria andCommentsEqualTo(String value) {
            addCriterion("comments =", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotEqualTo(String value) {
            addCriterion("comments <>", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThan(String value) {
            addCriterion("comments >", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsGreaterThanOrEqualTo(String value) {
            addCriterion("comments >=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThan(String value) {
            addCriterion("comments <", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLessThanOrEqualTo(String value) {
            addCriterion("comments <=", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsLike(String value) {
            addCriterion("comments like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotLike(String value) {
            addCriterion("comments not like", value, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsIn(List<String> values) {
            addCriterion("comments in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotIn(List<String> values) {
            addCriterion("comments not in", values, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsBetween(String value1, String value2) {
            addCriterion("comments between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentsNotBetween(String value1, String value2) {
            addCriterion("comments not between", value1, value2, "comments");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNull() {
            addCriterion("comment_time is null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIsNotNull() {
            addCriterion("comment_time is not null");
            return (Criteria) this;
        }

        public Criteria andCommentTimeEqualTo(Date value) {
            addCriterion("comment_time =", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotEqualTo(Date value) {
            addCriterion("comment_time <>", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThan(Date value) {
            addCriterion("comment_time >", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("comment_time >=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThan(Date value) {
            addCriterion("comment_time <", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeLessThanOrEqualTo(Date value) {
            addCriterion("comment_time <=", value, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeIn(List<Date> values) {
            addCriterion("comment_time in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotIn(List<Date> values) {
            addCriterion("comment_time not in", values, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeBetween(Date value1, Date value2) {
            addCriterion("comment_time between", value1, value2, "commentTime");
            return (Criteria) this;
        }

        public Criteria andCommentTimeNotBetween(Date value1, Date value2) {
            addCriterion("comment_time not between", value1, value2, "commentTime");
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

        public Criteria andCsReplyIsNull() {
            addCriterion("cs_reply is null");
            return (Criteria) this;
        }

        public Criteria andCsReplyIsNotNull() {
            addCriterion("cs_reply is not null");
            return (Criteria) this;
        }

        public Criteria andCsReplyEqualTo(String value) {
            addCriterion("cs_reply =", value, "csReply");
            return (Criteria) this;
        }

        public Criteria andCsReplyNotEqualTo(String value) {
            addCriterion("cs_reply <>", value, "csReply");
            return (Criteria) this;
        }

        public Criteria andCsReplyGreaterThan(String value) {
            addCriterion("cs_reply >", value, "csReply");
            return (Criteria) this;
        }

        public Criteria andCsReplyGreaterThanOrEqualTo(String value) {
            addCriterion("cs_reply >=", value, "csReply");
            return (Criteria) this;
        }

        public Criteria andCsReplyLessThan(String value) {
            addCriterion("cs_reply <", value, "csReply");
            return (Criteria) this;
        }

        public Criteria andCsReplyLessThanOrEqualTo(String value) {
            addCriterion("cs_reply <=", value, "csReply");
            return (Criteria) this;
        }

        public Criteria andCsReplyLike(String value) {
            addCriterion("cs_reply like", value, "csReply");
            return (Criteria) this;
        }

        public Criteria andCsReplyNotLike(String value) {
            addCriterion("cs_reply not like", value, "csReply");
            return (Criteria) this;
        }

        public Criteria andCsReplyIn(List<String> values) {
            addCriterion("cs_reply in", values, "csReply");
            return (Criteria) this;
        }

        public Criteria andCsReplyNotIn(List<String> values) {
            addCriterion("cs_reply not in", values, "csReply");
            return (Criteria) this;
        }

        public Criteria andCsReplyBetween(String value1, String value2) {
            addCriterion("cs_reply between", value1, value2, "csReply");
            return (Criteria) this;
        }

        public Criteria andCsReplyNotBetween(String value1, String value2) {
            addCriterion("cs_reply not between", value1, value2, "csReply");
            return (Criteria) this;
        }

        public Criteria andCommentsLikeInsensitive(String value) {
            addCriterion("upper(comments) like", value.toUpperCase(), "comments");
            return (Criteria) this;
        }

        public Criteria andCsReplyLikeInsensitive(String value) {
            addCriterion("upper(cs_reply) like", value.toUpperCase(), "csReply");
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