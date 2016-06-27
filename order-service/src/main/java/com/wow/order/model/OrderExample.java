package com.wow.order.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOrderCodeIsNull() {
            addCriterion("order_code is null");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIsNotNull() {
            addCriterion("order_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrderCodeEqualTo(String value) {
            addCriterion("order_code =", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotEqualTo(String value) {
            addCriterion("order_code <>", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeGreaterThan(String value) {
            addCriterion("order_code >", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeGreaterThanOrEqualTo(String value) {
            addCriterion("order_code >=", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLessThan(String value) {
            addCriterion("order_code <", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLessThanOrEqualTo(String value) {
            addCriterion("order_code <=", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeLike(String value) {
            addCriterion("order_code like", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotLike(String value) {
            addCriterion("order_code not like", value, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeIn(List<String> values) {
            addCriterion("order_code in", values, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotIn(List<String> values) {
            addCriterion("order_code not in", values, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeBetween(String value1, String value2) {
            addCriterion("order_code between", value1, value2, "orderCode");
            return (Criteria) this;
        }

        public Criteria andOrderCodeNotBetween(String value1, String value2) {
            addCriterion("order_code not between", value1, value2, "orderCode");
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

        public Criteria andOrderAmountIsNull() {
            addCriterion("order_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIsNotNull() {
            addCriterion("order_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderAmountEqualTo(BigDecimal value) {
            addCriterion("order_amount =", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_amount <>", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThan(BigDecimal value) {
            addCriterion("order_amount >", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount >=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThan(BigDecimal value) {
            addCriterion("order_amount <", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_amount <=", value, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountIn(List<BigDecimal> values) {
            addCriterion("order_amount in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_amount not in", values, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andOrderAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_amount not between", value1, value2, "orderAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountIsNull() {
            addCriterion("product_amount is null");
            return (Criteria) this;
        }

        public Criteria andProductAmountIsNotNull() {
            addCriterion("product_amount is not null");
            return (Criteria) this;
        }

        public Criteria andProductAmountEqualTo(BigDecimal value) {
            addCriterion("product_amount =", value, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountNotEqualTo(BigDecimal value) {
            addCriterion("product_amount <>", value, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountGreaterThan(BigDecimal value) {
            addCriterion("product_amount >", value, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("product_amount >=", value, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountLessThan(BigDecimal value) {
            addCriterion("product_amount <", value, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("product_amount <=", value, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountIn(List<BigDecimal> values) {
            addCriterion("product_amount in", values, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountNotIn(List<BigDecimal> values) {
            addCriterion("product_amount not in", values, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_amount between", value1, value2, "productAmount");
            return (Criteria) this;
        }

        public Criteria andProductAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("product_amount not between", value1, value2, "productAmount");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeIsNull() {
            addCriterion("delivery_fee is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeIsNotNull() {
            addCriterion("delivery_fee is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeEqualTo(BigDecimal value) {
            addCriterion("delivery_fee =", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeNotEqualTo(BigDecimal value) {
            addCriterion("delivery_fee <>", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeGreaterThan(BigDecimal value) {
            addCriterion("delivery_fee >", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("delivery_fee >=", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeLessThan(BigDecimal value) {
            addCriterion("delivery_fee <", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("delivery_fee <=", value, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeIn(List<BigDecimal> values) {
            addCriterion("delivery_fee in", values, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeNotIn(List<BigDecimal> values) {
            addCriterion("delivery_fee not in", values, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("delivery_fee between", value1, value2, "deliveryFee");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("delivery_fee not between", value1, value2, "deliveryFee");
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

        public Criteria andReceiverProvinceIsNull() {
            addCriterion("receiver_province is null");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceIsNotNull() {
            addCriterion("receiver_province is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceEqualTo(String value) {
            addCriterion("receiver_province =", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNotEqualTo(String value) {
            addCriterion("receiver_province <>", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceGreaterThan(String value) {
            addCriterion("receiver_province >", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_province >=", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceLessThan(String value) {
            addCriterion("receiver_province <", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceLessThanOrEqualTo(String value) {
            addCriterion("receiver_province <=", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceLike(String value) {
            addCriterion("receiver_province like", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNotLike(String value) {
            addCriterion("receiver_province not like", value, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceIn(List<String> values) {
            addCriterion("receiver_province in", values, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNotIn(List<String> values) {
            addCriterion("receiver_province not in", values, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceBetween(String value1, String value2) {
            addCriterion("receiver_province between", value1, value2, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceNotBetween(String value1, String value2) {
            addCriterion("receiver_province not between", value1, value2, "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverCityIsNull() {
            addCriterion("receiver_city is null");
            return (Criteria) this;
        }

        public Criteria andReceiverCityIsNotNull() {
            addCriterion("receiver_city is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverCityEqualTo(String value) {
            addCriterion("receiver_city =", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNotEqualTo(String value) {
            addCriterion("receiver_city <>", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityGreaterThan(String value) {
            addCriterion("receiver_city >", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_city >=", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityLessThan(String value) {
            addCriterion("receiver_city <", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityLessThanOrEqualTo(String value) {
            addCriterion("receiver_city <=", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityLike(String value) {
            addCriterion("receiver_city like", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNotLike(String value) {
            addCriterion("receiver_city not like", value, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityIn(List<String> values) {
            addCriterion("receiver_city in", values, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNotIn(List<String> values) {
            addCriterion("receiver_city not in", values, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityBetween(String value1, String value2) {
            addCriterion("receiver_city between", value1, value2, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCityNotBetween(String value1, String value2) {
            addCriterion("receiver_city not between", value1, value2, "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyIsNull() {
            addCriterion("receiver_county is null");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyIsNotNull() {
            addCriterion("receiver_county is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyEqualTo(String value) {
            addCriterion("receiver_county =", value, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNotEqualTo(String value) {
            addCriterion("receiver_county <>", value, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyGreaterThan(String value) {
            addCriterion("receiver_county >", value, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_county >=", value, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyLessThan(String value) {
            addCriterion("receiver_county <", value, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyLessThanOrEqualTo(String value) {
            addCriterion("receiver_county <=", value, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyLike(String value) {
            addCriterion("receiver_county like", value, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNotLike(String value) {
            addCriterion("receiver_county not like", value, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyIn(List<String> values) {
            addCriterion("receiver_county in", values, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNotIn(List<String> values) {
            addCriterion("receiver_county not in", values, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyBetween(String value1, String value2) {
            addCriterion("receiver_county between", value1, value2, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyNotBetween(String value1, String value2) {
            addCriterion("receiver_county not between", value1, value2, "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverTownIsNull() {
            addCriterion("receiver_town is null");
            return (Criteria) this;
        }

        public Criteria andReceiverTownIsNotNull() {
            addCriterion("receiver_town is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverTownEqualTo(String value) {
            addCriterion("receiver_town =", value, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownNotEqualTo(String value) {
            addCriterion("receiver_town <>", value, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownGreaterThan(String value) {
            addCriterion("receiver_town >", value, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_town >=", value, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownLessThan(String value) {
            addCriterion("receiver_town <", value, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownLessThanOrEqualTo(String value) {
            addCriterion("receiver_town <=", value, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownLike(String value) {
            addCriterion("receiver_town like", value, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownNotLike(String value) {
            addCriterion("receiver_town not like", value, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownIn(List<String> values) {
            addCriterion("receiver_town in", values, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownNotIn(List<String> values) {
            addCriterion("receiver_town not in", values, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownBetween(String value1, String value2) {
            addCriterion("receiver_town between", value1, value2, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverTownNotBetween(String value1, String value2) {
            addCriterion("receiver_town not between", value1, value2, "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverPostcodeIsNull() {
            addCriterion("receiver_postcode is null");
            return (Criteria) this;
        }

        public Criteria andReceiverPostcodeIsNotNull() {
            addCriterion("receiver_postcode is not null");
            return (Criteria) this;
        }

        public Criteria andReceiverPostcodeEqualTo(String value) {
            addCriterion("receiver_postcode =", value, "receiverPostcode");
            return (Criteria) this;
        }

        public Criteria andReceiverPostcodeNotEqualTo(String value) {
            addCriterion("receiver_postcode <>", value, "receiverPostcode");
            return (Criteria) this;
        }

        public Criteria andReceiverPostcodeGreaterThan(String value) {
            addCriterion("receiver_postcode >", value, "receiverPostcode");
            return (Criteria) this;
        }

        public Criteria andReceiverPostcodeGreaterThanOrEqualTo(String value) {
            addCriterion("receiver_postcode >=", value, "receiverPostcode");
            return (Criteria) this;
        }

        public Criteria andReceiverPostcodeLessThan(String value) {
            addCriterion("receiver_postcode <", value, "receiverPostcode");
            return (Criteria) this;
        }

        public Criteria andReceiverPostcodeLessThanOrEqualTo(String value) {
            addCriterion("receiver_postcode <=", value, "receiverPostcode");
            return (Criteria) this;
        }

        public Criteria andReceiverPostcodeLike(String value) {
            addCriterion("receiver_postcode like", value, "receiverPostcode");
            return (Criteria) this;
        }

        public Criteria andReceiverPostcodeNotLike(String value) {
            addCriterion("receiver_postcode not like", value, "receiverPostcode");
            return (Criteria) this;
        }

        public Criteria andReceiverPostcodeIn(List<String> values) {
            addCriterion("receiver_postcode in", values, "receiverPostcode");
            return (Criteria) this;
        }

        public Criteria andReceiverPostcodeNotIn(List<String> values) {
            addCriterion("receiver_postcode not in", values, "receiverPostcode");
            return (Criteria) this;
        }

        public Criteria andReceiverPostcodeBetween(String value1, String value2) {
            addCriterion("receiver_postcode between", value1, value2, "receiverPostcode");
            return (Criteria) this;
        }

        public Criteria andReceiverPostcodeNotBetween(String value1, String value2) {
            addCriterion("receiver_postcode not between", value1, value2, "receiverPostcode");
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

        public Criteria andEndUserRemarksIsNull() {
            addCriterion("end_user_remarks is null");
            return (Criteria) this;
        }

        public Criteria andEndUserRemarksIsNotNull() {
            addCriterion("end_user_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andEndUserRemarksEqualTo(String value) {
            addCriterion("end_user_remarks =", value, "endUserRemarks");
            return (Criteria) this;
        }

        public Criteria andEndUserRemarksNotEqualTo(String value) {
            addCriterion("end_user_remarks <>", value, "endUserRemarks");
            return (Criteria) this;
        }

        public Criteria andEndUserRemarksGreaterThan(String value) {
            addCriterion("end_user_remarks >", value, "endUserRemarks");
            return (Criteria) this;
        }

        public Criteria andEndUserRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("end_user_remarks >=", value, "endUserRemarks");
            return (Criteria) this;
        }

        public Criteria andEndUserRemarksLessThan(String value) {
            addCriterion("end_user_remarks <", value, "endUserRemarks");
            return (Criteria) this;
        }

        public Criteria andEndUserRemarksLessThanOrEqualTo(String value) {
            addCriterion("end_user_remarks <=", value, "endUserRemarks");
            return (Criteria) this;
        }

        public Criteria andEndUserRemarksLike(String value) {
            addCriterion("end_user_remarks like", value, "endUserRemarks");
            return (Criteria) this;
        }

        public Criteria andEndUserRemarksNotLike(String value) {
            addCriterion("end_user_remarks not like", value, "endUserRemarks");
            return (Criteria) this;
        }

        public Criteria andEndUserRemarksIn(List<String> values) {
            addCriterion("end_user_remarks in", values, "endUserRemarks");
            return (Criteria) this;
        }

        public Criteria andEndUserRemarksNotIn(List<String> values) {
            addCriterion("end_user_remarks not in", values, "endUserRemarks");
            return (Criteria) this;
        }

        public Criteria andEndUserRemarksBetween(String value1, String value2) {
            addCriterion("end_user_remarks between", value1, value2, "endUserRemarks");
            return (Criteria) this;
        }

        public Criteria andEndUserRemarksNotBetween(String value1, String value2) {
            addCriterion("end_user_remarks not between", value1, value2, "endUserRemarks");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNull() {
            addCriterion("order_status is null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIsNotNull() {
            addCriterion("order_status is not null");
            return (Criteria) this;
        }

        public Criteria andOrderStatusEqualTo(Byte value) {
            addCriterion("order_status =", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotEqualTo(Byte value) {
            addCriterion("order_status <>", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThan(Byte value) {
            addCriterion("order_status >", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_status >=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThan(Byte value) {
            addCriterion("order_status <", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusLessThanOrEqualTo(Byte value) {
            addCriterion("order_status <=", value, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusIn(List<Byte> values) {
            addCriterion("order_status in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotIn(List<Byte> values) {
            addCriterion("order_status not in", values, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusBetween(Byte value1, Byte value2) {
            addCriterion("order_status between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andOrderStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("order_status not between", value1, value2, "orderStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNull() {
            addCriterion("payment_status is null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIsNotNull() {
            addCriterion("payment_status is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusEqualTo(Byte value) {
            addCriterion("payment_status =", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotEqualTo(Byte value) {
            addCriterion("payment_status <>", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThan(Byte value) {
            addCriterion("payment_status >", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("payment_status >=", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThan(Byte value) {
            addCriterion("payment_status <", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusLessThanOrEqualTo(Byte value) {
            addCriterion("payment_status <=", value, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusIn(List<Byte> values) {
            addCriterion("payment_status in", values, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotIn(List<Byte> values) {
            addCriterion("payment_status not in", values, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusBetween(Byte value1, Byte value2) {
            addCriterion("payment_status between", value1, value2, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("payment_status not between", value1, value2, "paymentStatus");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNull() {
            addCriterion("payment_method is null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIsNotNull() {
            addCriterion("payment_method is not null");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodEqualTo(Byte value) {
            addCriterion("payment_method =", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotEqualTo(Byte value) {
            addCriterion("payment_method <>", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThan(Byte value) {
            addCriterion("payment_method >", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodGreaterThanOrEqualTo(Byte value) {
            addCriterion("payment_method >=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThan(Byte value) {
            addCriterion("payment_method <", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodLessThanOrEqualTo(Byte value) {
            addCriterion("payment_method <=", value, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodIn(List<Byte> values) {
            addCriterion("payment_method in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotIn(List<Byte> values) {
            addCriterion("payment_method not in", values, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodBetween(Byte value1, Byte value2) {
            addCriterion("payment_method between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaymentMethodNotBetween(Byte value1, Byte value2) {
            addCriterion("payment_method not between", value1, value2, "paymentMethod");
            return (Criteria) this;
        }

        public Criteria andPaidTimeIsNull() {
            addCriterion("paid_time is null");
            return (Criteria) this;
        }

        public Criteria andPaidTimeIsNotNull() {
            addCriterion("paid_time is not null");
            return (Criteria) this;
        }

        public Criteria andPaidTimeEqualTo(Date value) {
            addCriterion("paid_time =", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeNotEqualTo(Date value) {
            addCriterion("paid_time <>", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeGreaterThan(Date value) {
            addCriterion("paid_time >", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("paid_time >=", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeLessThan(Date value) {
            addCriterion("paid_time <", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeLessThanOrEqualTo(Date value) {
            addCriterion("paid_time <=", value, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeIn(List<Date> values) {
            addCriterion("paid_time in", values, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeNotIn(List<Date> values) {
            addCriterion("paid_time not in", values, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeBetween(Date value1, Date value2) {
            addCriterion("paid_time between", value1, value2, "paidTime");
            return (Criteria) this;
        }

        public Criteria andPaidTimeNotBetween(Date value1, Date value2) {
            addCriterion("paid_time not between", value1, value2, "paidTime");
            return (Criteria) this;
        }

        public Criteria andIsUseCouponIsNull() {
            addCriterion("is_use_coupon is null");
            return (Criteria) this;
        }

        public Criteria andIsUseCouponIsNotNull() {
            addCriterion("is_use_coupon is not null");
            return (Criteria) this;
        }

        public Criteria andIsUseCouponEqualTo(Boolean value) {
            addCriterion("is_use_coupon =", value, "isUseCoupon");
            return (Criteria) this;
        }

        public Criteria andIsUseCouponNotEqualTo(Boolean value) {
            addCriterion("is_use_coupon <>", value, "isUseCoupon");
            return (Criteria) this;
        }

        public Criteria andIsUseCouponGreaterThan(Boolean value) {
            addCriterion("is_use_coupon >", value, "isUseCoupon");
            return (Criteria) this;
        }

        public Criteria andIsUseCouponGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_use_coupon >=", value, "isUseCoupon");
            return (Criteria) this;
        }

        public Criteria andIsUseCouponLessThan(Boolean value) {
            addCriterion("is_use_coupon <", value, "isUseCoupon");
            return (Criteria) this;
        }

        public Criteria andIsUseCouponLessThanOrEqualTo(Boolean value) {
            addCriterion("is_use_coupon <=", value, "isUseCoupon");
            return (Criteria) this;
        }

        public Criteria andIsUseCouponIn(List<Boolean> values) {
            addCriterion("is_use_coupon in", values, "isUseCoupon");
            return (Criteria) this;
        }

        public Criteria andIsUseCouponNotIn(List<Boolean> values) {
            addCriterion("is_use_coupon not in", values, "isUseCoupon");
            return (Criteria) this;
        }

        public Criteria andIsUseCouponBetween(Boolean value1, Boolean value2) {
            addCriterion("is_use_coupon between", value1, value2, "isUseCoupon");
            return (Criteria) this;
        }

        public Criteria andIsUseCouponNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_use_coupon not between", value1, value2, "isUseCoupon");
            return (Criteria) this;
        }

        public Criteria andEndUserCouponIdIsNull() {
            addCriterion("end_user_coupon_id is null");
            return (Criteria) this;
        }

        public Criteria andEndUserCouponIdIsNotNull() {
            addCriterion("end_user_coupon_id is not null");
            return (Criteria) this;
        }

        public Criteria andEndUserCouponIdEqualTo(Integer value) {
            addCriterion("end_user_coupon_id =", value, "endUserCouponId");
            return (Criteria) this;
        }

        public Criteria andEndUserCouponIdNotEqualTo(Integer value) {
            addCriterion("end_user_coupon_id <>", value, "endUserCouponId");
            return (Criteria) this;
        }

        public Criteria andEndUserCouponIdGreaterThan(Integer value) {
            addCriterion("end_user_coupon_id >", value, "endUserCouponId");
            return (Criteria) this;
        }

        public Criteria andEndUserCouponIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("end_user_coupon_id >=", value, "endUserCouponId");
            return (Criteria) this;
        }

        public Criteria andEndUserCouponIdLessThan(Integer value) {
            addCriterion("end_user_coupon_id <", value, "endUserCouponId");
            return (Criteria) this;
        }

        public Criteria andEndUserCouponIdLessThanOrEqualTo(Integer value) {
            addCriterion("end_user_coupon_id <=", value, "endUserCouponId");
            return (Criteria) this;
        }

        public Criteria andEndUserCouponIdIn(List<Integer> values) {
            addCriterion("end_user_coupon_id in", values, "endUserCouponId");
            return (Criteria) this;
        }

        public Criteria andEndUserCouponIdNotIn(List<Integer> values) {
            addCriterion("end_user_coupon_id not in", values, "endUserCouponId");
            return (Criteria) this;
        }

        public Criteria andEndUserCouponIdBetween(Integer value1, Integer value2) {
            addCriterion("end_user_coupon_id between", value1, value2, "endUserCouponId");
            return (Criteria) this;
        }

        public Criteria andEndUserCouponIdNotBetween(Integer value1, Integer value2) {
            addCriterion("end_user_coupon_id not between", value1, value2, "endUserCouponId");
            return (Criteria) this;
        }

        public Criteria andDeliveryMothodIsNull() {
            addCriterion("delivery_mothod is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryMothodIsNotNull() {
            addCriterion("delivery_mothod is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryMothodEqualTo(Byte value) {
            addCriterion("delivery_mothod =", value, "deliveryMothod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMothodNotEqualTo(Byte value) {
            addCriterion("delivery_mothod <>", value, "deliveryMothod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMothodGreaterThan(Byte value) {
            addCriterion("delivery_mothod >", value, "deliveryMothod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMothodGreaterThanOrEqualTo(Byte value) {
            addCriterion("delivery_mothod >=", value, "deliveryMothod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMothodLessThan(Byte value) {
            addCriterion("delivery_mothod <", value, "deliveryMothod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMothodLessThanOrEqualTo(Byte value) {
            addCriterion("delivery_mothod <=", value, "deliveryMothod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMothodIn(List<Byte> values) {
            addCriterion("delivery_mothod in", values, "deliveryMothod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMothodNotIn(List<Byte> values) {
            addCriterion("delivery_mothod not in", values, "deliveryMothod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMothodBetween(Byte value1, Byte value2) {
            addCriterion("delivery_mothod between", value1, value2, "deliveryMothod");
            return (Criteria) this;
        }

        public Criteria andDeliveryMothodNotBetween(Byte value1, Byte value2) {
            addCriterion("delivery_mothod not between", value1, value2, "deliveryMothod");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyNameIsNull() {
            addCriterion("delivery_company_name is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyNameIsNotNull() {
            addCriterion("delivery_company_name is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyNameEqualTo(String value) {
            addCriterion("delivery_company_name =", value, "deliveryCompanyName");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyNameNotEqualTo(String value) {
            addCriterion("delivery_company_name <>", value, "deliveryCompanyName");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyNameGreaterThan(String value) {
            addCriterion("delivery_company_name >", value, "deliveryCompanyName");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyNameGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_company_name >=", value, "deliveryCompanyName");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyNameLessThan(String value) {
            addCriterion("delivery_company_name <", value, "deliveryCompanyName");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyNameLessThanOrEqualTo(String value) {
            addCriterion("delivery_company_name <=", value, "deliveryCompanyName");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyNameLike(String value) {
            addCriterion("delivery_company_name like", value, "deliveryCompanyName");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyNameNotLike(String value) {
            addCriterion("delivery_company_name not like", value, "deliveryCompanyName");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyNameIn(List<String> values) {
            addCriterion("delivery_company_name in", values, "deliveryCompanyName");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyNameNotIn(List<String> values) {
            addCriterion("delivery_company_name not in", values, "deliveryCompanyName");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyNameBetween(String value1, String value2) {
            addCriterion("delivery_company_name between", value1, value2, "deliveryCompanyName");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyNameNotBetween(String value1, String value2) {
            addCriterion("delivery_company_name not between", value1, value2, "deliveryCompanyName");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNoIsNull() {
            addCriterion("delivery_order_no is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNoIsNotNull() {
            addCriterion("delivery_order_no is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNoEqualTo(String value) {
            addCriterion("delivery_order_no =", value, "deliveryOrderNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNoNotEqualTo(String value) {
            addCriterion("delivery_order_no <>", value, "deliveryOrderNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNoGreaterThan(String value) {
            addCriterion("delivery_order_no >", value, "deliveryOrderNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNoGreaterThanOrEqualTo(String value) {
            addCriterion("delivery_order_no >=", value, "deliveryOrderNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNoLessThan(String value) {
            addCriterion("delivery_order_no <", value, "deliveryOrderNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNoLessThanOrEqualTo(String value) {
            addCriterion("delivery_order_no <=", value, "deliveryOrderNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNoLike(String value) {
            addCriterion("delivery_order_no like", value, "deliveryOrderNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNoNotLike(String value) {
            addCriterion("delivery_order_no not like", value, "deliveryOrderNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNoIn(List<String> values) {
            addCriterion("delivery_order_no in", values, "deliveryOrderNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNoNotIn(List<String> values) {
            addCriterion("delivery_order_no not in", values, "deliveryOrderNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNoBetween(String value1, String value2) {
            addCriterion("delivery_order_no between", value1, value2, "deliveryOrderNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNoNotBetween(String value1, String value2) {
            addCriterion("delivery_order_no not between", value1, value2, "deliveryOrderNo");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIsNull() {
            addCriterion("delivery_date is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIsNotNull() {
            addCriterion("delivery_date is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateEqualTo(Date value) {
            addCriterion("delivery_date =", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotEqualTo(Date value) {
            addCriterion("delivery_date <>", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateGreaterThan(Date value) {
            addCriterion("delivery_date >", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateGreaterThanOrEqualTo(Date value) {
            addCriterion("delivery_date >=", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLessThan(Date value) {
            addCriterion("delivery_date <", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateLessThanOrEqualTo(Date value) {
            addCriterion("delivery_date <=", value, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateIn(List<Date> values) {
            addCriterion("delivery_date in", values, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotIn(List<Date> values) {
            addCriterion("delivery_date not in", values, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateBetween(Date value1, Date value2) {
            addCriterion("delivery_date between", value1, value2, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andDeliveryDateNotBetween(Date value1, Date value2) {
            addCriterion("delivery_date not between", value1, value2, "deliveryDate");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusIsNull() {
            addCriterion("goods_status is null");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusIsNotNull() {
            addCriterion("goods_status is not null");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusEqualTo(Byte value) {
            addCriterion("goods_status =", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotEqualTo(Byte value) {
            addCriterion("goods_status <>", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusGreaterThan(Byte value) {
            addCriterion("goods_status >", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("goods_status >=", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusLessThan(Byte value) {
            addCriterion("goods_status <", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusLessThanOrEqualTo(Byte value) {
            addCriterion("goods_status <=", value, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusIn(List<Byte> values) {
            addCriterion("goods_status in", values, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotIn(List<Byte> values) {
            addCriterion("goods_status not in", values, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusBetween(Byte value1, Byte value2) {
            addCriterion("goods_status between", value1, value2, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andGoodsStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("goods_status not between", value1, value2, "goodsStatus");
            return (Criteria) this;
        }

        public Criteria andDeliveryFailureReasonIsNull() {
            addCriterion("delivery_failure_reason is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryFailureReasonIsNotNull() {
            addCriterion("delivery_failure_reason is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryFailureReasonEqualTo(Byte value) {
            addCriterion("delivery_failure_reason =", value, "deliveryFailureReason");
            return (Criteria) this;
        }

        public Criteria andDeliveryFailureReasonNotEqualTo(Byte value) {
            addCriterion("delivery_failure_reason <>", value, "deliveryFailureReason");
            return (Criteria) this;
        }

        public Criteria andDeliveryFailureReasonGreaterThan(Byte value) {
            addCriterion("delivery_failure_reason >", value, "deliveryFailureReason");
            return (Criteria) this;
        }

        public Criteria andDeliveryFailureReasonGreaterThanOrEqualTo(Byte value) {
            addCriterion("delivery_failure_reason >=", value, "deliveryFailureReason");
            return (Criteria) this;
        }

        public Criteria andDeliveryFailureReasonLessThan(Byte value) {
            addCriterion("delivery_failure_reason <", value, "deliveryFailureReason");
            return (Criteria) this;
        }

        public Criteria andDeliveryFailureReasonLessThanOrEqualTo(Byte value) {
            addCriterion("delivery_failure_reason <=", value, "deliveryFailureReason");
            return (Criteria) this;
        }

        public Criteria andDeliveryFailureReasonIn(List<Byte> values) {
            addCriterion("delivery_failure_reason in", values, "deliveryFailureReason");
            return (Criteria) this;
        }

        public Criteria andDeliveryFailureReasonNotIn(List<Byte> values) {
            addCriterion("delivery_failure_reason not in", values, "deliveryFailureReason");
            return (Criteria) this;
        }

        public Criteria andDeliveryFailureReasonBetween(Byte value1, Byte value2) {
            addCriterion("delivery_failure_reason between", value1, value2, "deliveryFailureReason");
            return (Criteria) this;
        }

        public Criteria andDeliveryFailureReasonNotBetween(Byte value1, Byte value2) {
            addCriterion("delivery_failure_reason not between", value1, value2, "deliveryFailureReason");
            return (Criteria) this;
        }

        public Criteria andReceiveDateIsNull() {
            addCriterion("receive_date is null");
            return (Criteria) this;
        }

        public Criteria andReceiveDateIsNotNull() {
            addCriterion("receive_date is not null");
            return (Criteria) this;
        }

        public Criteria andReceiveDateEqualTo(Date value) {
            addCriterion("receive_date =", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateNotEqualTo(Date value) {
            addCriterion("receive_date <>", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateGreaterThan(Date value) {
            addCriterion("receive_date >", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateGreaterThanOrEqualTo(Date value) {
            addCriterion("receive_date >=", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateLessThan(Date value) {
            addCriterion("receive_date <", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateLessThanOrEqualTo(Date value) {
            addCriterion("receive_date <=", value, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateIn(List<Date> values) {
            addCriterion("receive_date in", values, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateNotIn(List<Date> values) {
            addCriterion("receive_date not in", values, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateBetween(Date value1, Date value2) {
            addCriterion("receive_date between", value1, value2, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReceiveDateNotBetween(Date value1, Date value2) {
            addCriterion("receive_date not between", value1, value2, "receiveDate");
            return (Criteria) this;
        }

        public Criteria andReturnOnDeliveryIsNull() {
            addCriterion("return_on_delivery is null");
            return (Criteria) this;
        }

        public Criteria andReturnOnDeliveryIsNotNull() {
            addCriterion("return_on_delivery is not null");
            return (Criteria) this;
        }

        public Criteria andReturnOnDeliveryEqualTo(Boolean value) {
            addCriterion("return_on_delivery =", value, "returnOnDelivery");
            return (Criteria) this;
        }

        public Criteria andReturnOnDeliveryNotEqualTo(Boolean value) {
            addCriterion("return_on_delivery <>", value, "returnOnDelivery");
            return (Criteria) this;
        }

        public Criteria andReturnOnDeliveryGreaterThan(Boolean value) {
            addCriterion("return_on_delivery >", value, "returnOnDelivery");
            return (Criteria) this;
        }

        public Criteria andReturnOnDeliveryGreaterThanOrEqualTo(Boolean value) {
            addCriterion("return_on_delivery >=", value, "returnOnDelivery");
            return (Criteria) this;
        }

        public Criteria andReturnOnDeliveryLessThan(Boolean value) {
            addCriterion("return_on_delivery <", value, "returnOnDelivery");
            return (Criteria) this;
        }

        public Criteria andReturnOnDeliveryLessThanOrEqualTo(Boolean value) {
            addCriterion("return_on_delivery <=", value, "returnOnDelivery");
            return (Criteria) this;
        }

        public Criteria andReturnOnDeliveryIn(List<Boolean> values) {
            addCriterion("return_on_delivery in", values, "returnOnDelivery");
            return (Criteria) this;
        }

        public Criteria andReturnOnDeliveryNotIn(List<Boolean> values) {
            addCriterion("return_on_delivery not in", values, "returnOnDelivery");
            return (Criteria) this;
        }

        public Criteria andReturnOnDeliveryBetween(Boolean value1, Boolean value2) {
            addCriterion("return_on_delivery between", value1, value2, "returnOnDelivery");
            return (Criteria) this;
        }

        public Criteria andReturnOnDeliveryNotBetween(Boolean value1, Boolean value2) {
            addCriterion("return_on_delivery not between", value1, value2, "returnOnDelivery");
            return (Criteria) this;
        }

        public Criteria andCancelRequestTimeIsNull() {
            addCriterion("cancel_request_time is null");
            return (Criteria) this;
        }

        public Criteria andCancelRequestTimeIsNotNull() {
            addCriterion("cancel_request_time is not null");
            return (Criteria) this;
        }

        public Criteria andCancelRequestTimeEqualTo(Date value) {
            addCriterion("cancel_request_time =", value, "cancelRequestTime");
            return (Criteria) this;
        }

        public Criteria andCancelRequestTimeNotEqualTo(Date value) {
            addCriterion("cancel_request_time <>", value, "cancelRequestTime");
            return (Criteria) this;
        }

        public Criteria andCancelRequestTimeGreaterThan(Date value) {
            addCriterion("cancel_request_time >", value, "cancelRequestTime");
            return (Criteria) this;
        }

        public Criteria andCancelRequestTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cancel_request_time >=", value, "cancelRequestTime");
            return (Criteria) this;
        }

        public Criteria andCancelRequestTimeLessThan(Date value) {
            addCriterion("cancel_request_time <", value, "cancelRequestTime");
            return (Criteria) this;
        }

        public Criteria andCancelRequestTimeLessThanOrEqualTo(Date value) {
            addCriterion("cancel_request_time <=", value, "cancelRequestTime");
            return (Criteria) this;
        }

        public Criteria andCancelRequestTimeIn(List<Date> values) {
            addCriterion("cancel_request_time in", values, "cancelRequestTime");
            return (Criteria) this;
        }

        public Criteria andCancelRequestTimeNotIn(List<Date> values) {
            addCriterion("cancel_request_time not in", values, "cancelRequestTime");
            return (Criteria) this;
        }

        public Criteria andCancelRequestTimeBetween(Date value1, Date value2) {
            addCriterion("cancel_request_time between", value1, value2, "cancelRequestTime");
            return (Criteria) this;
        }

        public Criteria andCancelRequestTimeNotBetween(Date value1, Date value2) {
            addCriterion("cancel_request_time not between", value1, value2, "cancelRequestTime");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIsNull() {
            addCriterion("cancel_reason is null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIsNotNull() {
            addCriterion("cancel_reason is not null");
            return (Criteria) this;
        }

        public Criteria andCancelReasonEqualTo(String value) {
            addCriterion("cancel_reason =", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotEqualTo(String value) {
            addCriterion("cancel_reason <>", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThan(String value) {
            addCriterion("cancel_reason >", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonGreaterThanOrEqualTo(String value) {
            addCriterion("cancel_reason >=", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThan(String value) {
            addCriterion("cancel_reason <", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLessThanOrEqualTo(String value) {
            addCriterion("cancel_reason <=", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLike(String value) {
            addCriterion("cancel_reason like", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotLike(String value) {
            addCriterion("cancel_reason not like", value, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonIn(List<String> values) {
            addCriterion("cancel_reason in", values, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotIn(List<String> values) {
            addCriterion("cancel_reason not in", values, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonBetween(String value1, String value2) {
            addCriterion("cancel_reason between", value1, value2, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelReasonNotBetween(String value1, String value2) {
            addCriterion("cancel_reason not between", value1, value2, "cancelReason");
            return (Criteria) this;
        }

        public Criteria andCancelApprovedTimeIsNull() {
            addCriterion("cancel_approved_time is null");
            return (Criteria) this;
        }

        public Criteria andCancelApprovedTimeIsNotNull() {
            addCriterion("cancel_approved_time is not null");
            return (Criteria) this;
        }

        public Criteria andCancelApprovedTimeEqualTo(Date value) {
            addCriterion("cancel_approved_time =", value, "cancelApprovedTime");
            return (Criteria) this;
        }

        public Criteria andCancelApprovedTimeNotEqualTo(Date value) {
            addCriterion("cancel_approved_time <>", value, "cancelApprovedTime");
            return (Criteria) this;
        }

        public Criteria andCancelApprovedTimeGreaterThan(Date value) {
            addCriterion("cancel_approved_time >", value, "cancelApprovedTime");
            return (Criteria) this;
        }

        public Criteria andCancelApprovedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("cancel_approved_time >=", value, "cancelApprovedTime");
            return (Criteria) this;
        }

        public Criteria andCancelApprovedTimeLessThan(Date value) {
            addCriterion("cancel_approved_time <", value, "cancelApprovedTime");
            return (Criteria) this;
        }

        public Criteria andCancelApprovedTimeLessThanOrEqualTo(Date value) {
            addCriterion("cancel_approved_time <=", value, "cancelApprovedTime");
            return (Criteria) this;
        }

        public Criteria andCancelApprovedTimeIn(List<Date> values) {
            addCriterion("cancel_approved_time in", values, "cancelApprovedTime");
            return (Criteria) this;
        }

        public Criteria andCancelApprovedTimeNotIn(List<Date> values) {
            addCriterion("cancel_approved_time not in", values, "cancelApprovedTime");
            return (Criteria) this;
        }

        public Criteria andCancelApprovedTimeBetween(Date value1, Date value2) {
            addCriterion("cancel_approved_time between", value1, value2, "cancelApprovedTime");
            return (Criteria) this;
        }

        public Criteria andCancelApprovedTimeNotBetween(Date value1, Date value2) {
            addCriterion("cancel_approved_time not between", value1, value2, "cancelApprovedTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalStatusIsNull() {
            addCriterion("refund_approval_status is null");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalStatusIsNotNull() {
            addCriterion("refund_approval_status is not null");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalStatusEqualTo(Byte value) {
            addCriterion("refund_approval_status =", value, "refundApprovalStatus");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalStatusNotEqualTo(Byte value) {
            addCriterion("refund_approval_status <>", value, "refundApprovalStatus");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalStatusGreaterThan(Byte value) {
            addCriterion("refund_approval_status >", value, "refundApprovalStatus");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("refund_approval_status >=", value, "refundApprovalStatus");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalStatusLessThan(Byte value) {
            addCriterion("refund_approval_status <", value, "refundApprovalStatus");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalStatusLessThanOrEqualTo(Byte value) {
            addCriterion("refund_approval_status <=", value, "refundApprovalStatus");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalStatusIn(List<Byte> values) {
            addCriterion("refund_approval_status in", values, "refundApprovalStatus");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalStatusNotIn(List<Byte> values) {
            addCriterion("refund_approval_status not in", values, "refundApprovalStatus");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalStatusBetween(Byte value1, Byte value2) {
            addCriterion("refund_approval_status between", value1, value2, "refundApprovalStatus");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("refund_approval_status not between", value1, value2, "refundApprovalStatus");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeIsNull() {
            addCriterion("refund_approval_time is null");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeIsNotNull() {
            addCriterion("refund_approval_time is not null");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeEqualTo(Date value) {
            addCriterion("refund_approval_time =", value, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeNotEqualTo(Date value) {
            addCriterion("refund_approval_time <>", value, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeGreaterThan(Date value) {
            addCriterion("refund_approval_time >", value, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("refund_approval_time >=", value, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeLessThan(Date value) {
            addCriterion("refund_approval_time <", value, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeLessThanOrEqualTo(Date value) {
            addCriterion("refund_approval_time <=", value, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeIn(List<Date> values) {
            addCriterion("refund_approval_time in", values, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeNotIn(List<Date> values) {
            addCriterion("refund_approval_time not in", values, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeBetween(Date value1, Date value2) {
            addCriterion("refund_approval_time between", value1, value2, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andRefundApprovalTimeNotBetween(Date value1, Date value2) {
            addCriterion("refund_approval_time not between", value1, value2, "refundApprovalTime");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNull() {
            addCriterion("operator_name is null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNotNull() {
            addCriterion("operator_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameEqualTo(String value) {
            addCriterion("operator_name =", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotEqualTo(String value) {
            addCriterion("operator_name <>", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThan(String value) {
            addCriterion("operator_name >", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("operator_name >=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThan(String value) {
            addCriterion("operator_name <", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThanOrEqualTo(String value) {
            addCriterion("operator_name <=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLike(String value) {
            addCriterion("operator_name like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotLike(String value) {
            addCriterion("operator_name not like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIn(List<String> values) {
            addCriterion("operator_name in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotIn(List<String> values) {
            addCriterion("operator_name not in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameBetween(String value1, String value2) {
            addCriterion("operator_name between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotBetween(String value1, String value2) {
            addCriterion("operator_name not between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andIsLeafIsNull() {
            addCriterion("is_leaf is null");
            return (Criteria) this;
        }

        public Criteria andIsLeafIsNotNull() {
            addCriterion("is_leaf is not null");
            return (Criteria) this;
        }

        public Criteria andIsLeafEqualTo(Boolean value) {
            addCriterion("is_leaf =", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafNotEqualTo(Boolean value) {
            addCriterion("is_leaf <>", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafGreaterThan(Boolean value) {
            addCriterion("is_leaf >", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_leaf >=", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafLessThan(Boolean value) {
            addCriterion("is_leaf <", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafLessThanOrEqualTo(Boolean value) {
            addCriterion("is_leaf <=", value, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafIn(List<Boolean> values) {
            addCriterion("is_leaf in", values, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafNotIn(List<Boolean> values) {
            addCriterion("is_leaf not in", values, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafBetween(Boolean value1, Boolean value2) {
            addCriterion("is_leaf between", value1, value2, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andIsLeafNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_leaf not between", value1, value2, "isLeaf");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdIsNull() {
            addCriterion("parent_order_id is null");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdIsNotNull() {
            addCriterion("parent_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdEqualTo(Integer value) {
            addCriterion("parent_order_id =", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdNotEqualTo(Integer value) {
            addCriterion("parent_order_id <>", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdGreaterThan(Integer value) {
            addCriterion("parent_order_id >", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_order_id >=", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdLessThan(Integer value) {
            addCriterion("parent_order_id <", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_order_id <=", value, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdIn(List<Integer> values) {
            addCriterion("parent_order_id in", values, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdNotIn(List<Integer> values) {
            addCriterion("parent_order_id not in", values, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_order_id between", value1, value2, "parentOrderId");
            return (Criteria) this;
        }

        public Criteria andParentOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_order_id not between", value1, value2, "parentOrderId");
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

        public Criteria andOrderSourceIsNull() {
            addCriterion("order_source is null");
            return (Criteria) this;
        }

        public Criteria andOrderSourceIsNotNull() {
            addCriterion("order_source is not null");
            return (Criteria) this;
        }

        public Criteria andOrderSourceEqualTo(Byte value) {
            addCriterion("order_source =", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceNotEqualTo(Byte value) {
            addCriterion("order_source <>", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceGreaterThan(Byte value) {
            addCriterion("order_source >", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_source >=", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceLessThan(Byte value) {
            addCriterion("order_source <", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceLessThanOrEqualTo(Byte value) {
            addCriterion("order_source <=", value, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceIn(List<Byte> values) {
            addCriterion("order_source in", values, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceNotIn(List<Byte> values) {
            addCriterion("order_source not in", values, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceBetween(Byte value1, Byte value2) {
            addCriterion("order_source between", value1, value2, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderSourceNotBetween(Byte value1, Byte value2) {
            addCriterion("order_source not between", value1, value2, "orderSource");
            return (Criteria) this;
        }

        public Criteria andOrderIpIsNull() {
            addCriterion("order_ip is null");
            return (Criteria) this;
        }

        public Criteria andOrderIpIsNotNull() {
            addCriterion("order_ip is not null");
            return (Criteria) this;
        }

        public Criteria andOrderIpEqualTo(Integer value) {
            addCriterion("order_ip =", value, "orderIp");
            return (Criteria) this;
        }

        public Criteria andOrderIpNotEqualTo(Integer value) {
            addCriterion("order_ip <>", value, "orderIp");
            return (Criteria) this;
        }

        public Criteria andOrderIpGreaterThan(Integer value) {
            addCriterion("order_ip >", value, "orderIp");
            return (Criteria) this;
        }

        public Criteria andOrderIpGreaterThanOrEqualTo(Integer value) {
            addCriterion("order_ip >=", value, "orderIp");
            return (Criteria) this;
        }

        public Criteria andOrderIpLessThan(Integer value) {
            addCriterion("order_ip <", value, "orderIp");
            return (Criteria) this;
        }

        public Criteria andOrderIpLessThanOrEqualTo(Integer value) {
            addCriterion("order_ip <=", value, "orderIp");
            return (Criteria) this;
        }

        public Criteria andOrderIpIn(List<Integer> values) {
            addCriterion("order_ip in", values, "orderIp");
            return (Criteria) this;
        }

        public Criteria andOrderIpNotIn(List<Integer> values) {
            addCriterion("order_ip not in", values, "orderIp");
            return (Criteria) this;
        }

        public Criteria andOrderIpBetween(Integer value1, Integer value2) {
            addCriterion("order_ip between", value1, value2, "orderIp");
            return (Criteria) this;
        }

        public Criteria andOrderIpNotBetween(Integer value1, Integer value2) {
            addCriterion("order_ip not between", value1, value2, "orderIp");
            return (Criteria) this;
        }

        public Criteria andSellerRemarksIsNull() {
            addCriterion("seller_remarks is null");
            return (Criteria) this;
        }

        public Criteria andSellerRemarksIsNotNull() {
            addCriterion("seller_remarks is not null");
            return (Criteria) this;
        }

        public Criteria andSellerRemarksEqualTo(String value) {
            addCriterion("seller_remarks =", value, "sellerRemarks");
            return (Criteria) this;
        }

        public Criteria andSellerRemarksNotEqualTo(String value) {
            addCriterion("seller_remarks <>", value, "sellerRemarks");
            return (Criteria) this;
        }

        public Criteria andSellerRemarksGreaterThan(String value) {
            addCriterion("seller_remarks >", value, "sellerRemarks");
            return (Criteria) this;
        }

        public Criteria andSellerRemarksGreaterThanOrEqualTo(String value) {
            addCriterion("seller_remarks >=", value, "sellerRemarks");
            return (Criteria) this;
        }

        public Criteria andSellerRemarksLessThan(String value) {
            addCriterion("seller_remarks <", value, "sellerRemarks");
            return (Criteria) this;
        }

        public Criteria andSellerRemarksLessThanOrEqualTo(String value) {
            addCriterion("seller_remarks <=", value, "sellerRemarks");
            return (Criteria) this;
        }

        public Criteria andSellerRemarksLike(String value) {
            addCriterion("seller_remarks like", value, "sellerRemarks");
            return (Criteria) this;
        }

        public Criteria andSellerRemarksNotLike(String value) {
            addCriterion("seller_remarks not like", value, "sellerRemarks");
            return (Criteria) this;
        }

        public Criteria andSellerRemarksIn(List<String> values) {
            addCriterion("seller_remarks in", values, "sellerRemarks");
            return (Criteria) this;
        }

        public Criteria andSellerRemarksNotIn(List<String> values) {
            addCriterion("seller_remarks not in", values, "sellerRemarks");
            return (Criteria) this;
        }

        public Criteria andSellerRemarksBetween(String value1, String value2) {
            addCriterion("seller_remarks between", value1, value2, "sellerRemarks");
            return (Criteria) this;
        }

        public Criteria andSellerRemarksNotBetween(String value1, String value2) {
            addCriterion("seller_remarks not between", value1, value2, "sellerRemarks");
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

        public Criteria andOrderCodeLikeInsensitive(String value) {
            addCriterion("upper(order_code) like", value.toUpperCase(), "orderCode");
            return (Criteria) this;
        }

        public Criteria andReceiverNameLikeInsensitive(String value) {
            addCriterion("upper(receiver_name) like", value.toUpperCase(), "receiverName");
            return (Criteria) this;
        }

        public Criteria andReceiverProvinceLikeInsensitive(String value) {
            addCriterion("upper(receiver_province) like", value.toUpperCase(), "receiverProvince");
            return (Criteria) this;
        }

        public Criteria andReceiverCityLikeInsensitive(String value) {
            addCriterion("upper(receiver_city) like", value.toUpperCase(), "receiverCity");
            return (Criteria) this;
        }

        public Criteria andReceiverCountyLikeInsensitive(String value) {
            addCriterion("upper(receiver_county) like", value.toUpperCase(), "receiverCounty");
            return (Criteria) this;
        }

        public Criteria andReceiverTownLikeInsensitive(String value) {
            addCriterion("upper(receiver_town) like", value.toUpperCase(), "receiverTown");
            return (Criteria) this;
        }

        public Criteria andReceiverPostcodeLikeInsensitive(String value) {
            addCriterion("upper(receiver_postcode) like", value.toUpperCase(), "receiverPostcode");
            return (Criteria) this;
        }

        public Criteria andReceiverAddressLikeInsensitive(String value) {
            addCriterion("upper(receiver_address) like", value.toUpperCase(), "receiverAddress");
            return (Criteria) this;
        }

        public Criteria andReceiverMobileLikeInsensitive(String value) {
            addCriterion("upper(receiver_mobile) like", value.toUpperCase(), "receiverMobile");
            return (Criteria) this;
        }

        public Criteria andEndUserRemarksLikeInsensitive(String value) {
            addCriterion("upper(end_user_remarks) like", value.toUpperCase(), "endUserRemarks");
            return (Criteria) this;
        }

        public Criteria andDeliveryCompanyNameLikeInsensitive(String value) {
            addCriterion("upper(delivery_company_name) like", value.toUpperCase(), "deliveryCompanyName");
            return (Criteria) this;
        }

        public Criteria andDeliveryOrderNoLikeInsensitive(String value) {
            addCriterion("upper(delivery_order_no) like", value.toUpperCase(), "deliveryOrderNo");
            return (Criteria) this;
        }

        public Criteria andCancelReasonLikeInsensitive(String value) {
            addCriterion("upper(cancel_reason) like", value.toUpperCase(), "cancelReason");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLikeInsensitive(String value) {
            addCriterion("upper(operator_name) like", value.toUpperCase(), "operatorName");
            return (Criteria) this;
        }

        public Criteria andSellerRemarksLikeInsensitive(String value) {
            addCriterion("upper(seller_remarks) like", value.toUpperCase(), "sellerRemarks");
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