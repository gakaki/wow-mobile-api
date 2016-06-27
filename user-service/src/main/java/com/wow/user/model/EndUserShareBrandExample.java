package com.wow.user.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EndUserShareBrandExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EndUserShareBrandExample() {
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

        public Criteria andBrandIdIsNull() {
            addCriterion("brand_id is null");
            return (Criteria) this;
        }

        public Criteria andBrandIdIsNotNull() {
            addCriterion("brand_id is not null");
            return (Criteria) this;
        }

        public Criteria andBrandIdEqualTo(Integer value) {
            addCriterion("brand_id =", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotEqualTo(Integer value) {
            addCriterion("brand_id <>", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThan(Integer value) {
            addCriterion("brand_id >", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("brand_id >=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThan(Integer value) {
            addCriterion("brand_id <", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdLessThanOrEqualTo(Integer value) {
            addCriterion("brand_id <=", value, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdIn(List<Integer> values) {
            addCriterion("brand_id in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotIn(List<Integer> values) {
            addCriterion("brand_id not in", values, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdBetween(Integer value1, Integer value2) {
            addCriterion("brand_id between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andBrandIdNotBetween(Integer value1, Integer value2) {
            addCriterion("brand_id not between", value1, value2, "brandId");
            return (Criteria) this;
        }

        public Criteria andShareTitleIsNull() {
            addCriterion("share_title is null");
            return (Criteria) this;
        }

        public Criteria andShareTitleIsNotNull() {
            addCriterion("share_title is not null");
            return (Criteria) this;
        }

        public Criteria andShareTitleEqualTo(String value) {
            addCriterion("share_title =", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotEqualTo(String value) {
            addCriterion("share_title <>", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleGreaterThan(String value) {
            addCriterion("share_title >", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleGreaterThanOrEqualTo(String value) {
            addCriterion("share_title >=", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleLessThan(String value) {
            addCriterion("share_title <", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleLessThanOrEqualTo(String value) {
            addCriterion("share_title <=", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleLike(String value) {
            addCriterion("share_title like", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotLike(String value) {
            addCriterion("share_title not like", value, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleIn(List<String> values) {
            addCriterion("share_title in", values, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotIn(List<String> values) {
            addCriterion("share_title not in", values, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleBetween(String value1, String value2) {
            addCriterion("share_title between", value1, value2, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareTitleNotBetween(String value1, String value2) {
            addCriterion("share_title not between", value1, value2, "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareDescIsNull() {
            addCriterion("share_desc is null");
            return (Criteria) this;
        }

        public Criteria andShareDescIsNotNull() {
            addCriterion("share_desc is not null");
            return (Criteria) this;
        }

        public Criteria andShareDescEqualTo(String value) {
            addCriterion("share_desc =", value, "shareDesc");
            return (Criteria) this;
        }

        public Criteria andShareDescNotEqualTo(String value) {
            addCriterion("share_desc <>", value, "shareDesc");
            return (Criteria) this;
        }

        public Criteria andShareDescGreaterThan(String value) {
            addCriterion("share_desc >", value, "shareDesc");
            return (Criteria) this;
        }

        public Criteria andShareDescGreaterThanOrEqualTo(String value) {
            addCriterion("share_desc >=", value, "shareDesc");
            return (Criteria) this;
        }

        public Criteria andShareDescLessThan(String value) {
            addCriterion("share_desc <", value, "shareDesc");
            return (Criteria) this;
        }

        public Criteria andShareDescLessThanOrEqualTo(String value) {
            addCriterion("share_desc <=", value, "shareDesc");
            return (Criteria) this;
        }

        public Criteria andShareDescLike(String value) {
            addCriterion("share_desc like", value, "shareDesc");
            return (Criteria) this;
        }

        public Criteria andShareDescNotLike(String value) {
            addCriterion("share_desc not like", value, "shareDesc");
            return (Criteria) this;
        }

        public Criteria andShareDescIn(List<String> values) {
            addCriterion("share_desc in", values, "shareDesc");
            return (Criteria) this;
        }

        public Criteria andShareDescNotIn(List<String> values) {
            addCriterion("share_desc not in", values, "shareDesc");
            return (Criteria) this;
        }

        public Criteria andShareDescBetween(String value1, String value2) {
            addCriterion("share_desc between", value1, value2, "shareDesc");
            return (Criteria) this;
        }

        public Criteria andShareDescNotBetween(String value1, String value2) {
            addCriterion("share_desc not between", value1, value2, "shareDesc");
            return (Criteria) this;
        }

        public Criteria andShareUrlIsNull() {
            addCriterion("share_url is null");
            return (Criteria) this;
        }

        public Criteria andShareUrlIsNotNull() {
            addCriterion("share_url is not null");
            return (Criteria) this;
        }

        public Criteria andShareUrlEqualTo(String value) {
            addCriterion("share_url =", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotEqualTo(String value) {
            addCriterion("share_url <>", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlGreaterThan(String value) {
            addCriterion("share_url >", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlGreaterThanOrEqualTo(String value) {
            addCriterion("share_url >=", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLessThan(String value) {
            addCriterion("share_url <", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLessThanOrEqualTo(String value) {
            addCriterion("share_url <=", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlLike(String value) {
            addCriterion("share_url like", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotLike(String value) {
            addCriterion("share_url not like", value, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlIn(List<String> values) {
            addCriterion("share_url in", values, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotIn(List<String> values) {
            addCriterion("share_url not in", values, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlBetween(String value1, String value2) {
            addCriterion("share_url between", value1, value2, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareUrlNotBetween(String value1, String value2) {
            addCriterion("share_url not between", value1, value2, "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareImgIsNull() {
            addCriterion("share_img is null");
            return (Criteria) this;
        }

        public Criteria andShareImgIsNotNull() {
            addCriterion("share_img is not null");
            return (Criteria) this;
        }

        public Criteria andShareImgEqualTo(String value) {
            addCriterion("share_img =", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotEqualTo(String value) {
            addCriterion("share_img <>", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgGreaterThan(String value) {
            addCriterion("share_img >", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgGreaterThanOrEqualTo(String value) {
            addCriterion("share_img >=", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgLessThan(String value) {
            addCriterion("share_img <", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgLessThanOrEqualTo(String value) {
            addCriterion("share_img <=", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgLike(String value) {
            addCriterion("share_img like", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotLike(String value) {
            addCriterion("share_img not like", value, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgIn(List<String> values) {
            addCriterion("share_img in", values, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotIn(List<String> values) {
            addCriterion("share_img not in", values, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgBetween(String value1, String value2) {
            addCriterion("share_img between", value1, value2, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareImgNotBetween(String value1, String value2) {
            addCriterion("share_img not between", value1, value2, "shareImg");
            return (Criteria) this;
        }

        public Criteria andShareChannelIsNull() {
            addCriterion("share_channel is null");
            return (Criteria) this;
        }

        public Criteria andShareChannelIsNotNull() {
            addCriterion("share_channel is not null");
            return (Criteria) this;
        }

        public Criteria andShareChannelEqualTo(Byte value) {
            addCriterion("share_channel =", value, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelNotEqualTo(Byte value) {
            addCriterion("share_channel <>", value, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelGreaterThan(Byte value) {
            addCriterion("share_channel >", value, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelGreaterThanOrEqualTo(Byte value) {
            addCriterion("share_channel >=", value, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelLessThan(Byte value) {
            addCriterion("share_channel <", value, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelLessThanOrEqualTo(Byte value) {
            addCriterion("share_channel <=", value, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelIn(List<Byte> values) {
            addCriterion("share_channel in", values, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelNotIn(List<Byte> values) {
            addCriterion("share_channel not in", values, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelBetween(Byte value1, Byte value2) {
            addCriterion("share_channel between", value1, value2, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andShareChannelNotBetween(Byte value1, Byte value2) {
            addCriterion("share_channel not between", value1, value2, "shareChannel");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeIsNull() {
            addCriterion("recommend_code is null");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeIsNotNull() {
            addCriterion("recommend_code is not null");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeEqualTo(String value) {
            addCriterion("recommend_code =", value, "recommendCode");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeNotEqualTo(String value) {
            addCriterion("recommend_code <>", value, "recommendCode");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeGreaterThan(String value) {
            addCriterion("recommend_code >", value, "recommendCode");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeGreaterThanOrEqualTo(String value) {
            addCriterion("recommend_code >=", value, "recommendCode");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeLessThan(String value) {
            addCriterion("recommend_code <", value, "recommendCode");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeLessThanOrEqualTo(String value) {
            addCriterion("recommend_code <=", value, "recommendCode");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeLike(String value) {
            addCriterion("recommend_code like", value, "recommendCode");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeNotLike(String value) {
            addCriterion("recommend_code not like", value, "recommendCode");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeIn(List<String> values) {
            addCriterion("recommend_code in", values, "recommendCode");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeNotIn(List<String> values) {
            addCriterion("recommend_code not in", values, "recommendCode");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeBetween(String value1, String value2) {
            addCriterion("recommend_code between", value1, value2, "recommendCode");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeNotBetween(String value1, String value2) {
            addCriterion("recommend_code not between", value1, value2, "recommendCode");
            return (Criteria) this;
        }

        public Criteria andShareTimeIsNull() {
            addCriterion("share_time is null");
            return (Criteria) this;
        }

        public Criteria andShareTimeIsNotNull() {
            addCriterion("share_time is not null");
            return (Criteria) this;
        }

        public Criteria andShareTimeEqualTo(Date value) {
            addCriterion("share_time =", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeNotEqualTo(Date value) {
            addCriterion("share_time <>", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeGreaterThan(Date value) {
            addCriterion("share_time >", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("share_time >=", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeLessThan(Date value) {
            addCriterion("share_time <", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeLessThanOrEqualTo(Date value) {
            addCriterion("share_time <=", value, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeIn(List<Date> values) {
            addCriterion("share_time in", values, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeNotIn(List<Date> values) {
            addCriterion("share_time not in", values, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeBetween(Date value1, Date value2) {
            addCriterion("share_time between", value1, value2, "shareTime");
            return (Criteria) this;
        }

        public Criteria andShareTimeNotBetween(Date value1, Date value2) {
            addCriterion("share_time not between", value1, value2, "shareTime");
            return (Criteria) this;
        }

        public Criteria andIsShareSuccessIsNull() {
            addCriterion("is_share_success is null");
            return (Criteria) this;
        }

        public Criteria andIsShareSuccessIsNotNull() {
            addCriterion("is_share_success is not null");
            return (Criteria) this;
        }

        public Criteria andIsShareSuccessEqualTo(Boolean value) {
            addCriterion("is_share_success =", value, "isShareSuccess");
            return (Criteria) this;
        }

        public Criteria andIsShareSuccessNotEqualTo(Boolean value) {
            addCriterion("is_share_success <>", value, "isShareSuccess");
            return (Criteria) this;
        }

        public Criteria andIsShareSuccessGreaterThan(Boolean value) {
            addCriterion("is_share_success >", value, "isShareSuccess");
            return (Criteria) this;
        }

        public Criteria andIsShareSuccessGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_share_success >=", value, "isShareSuccess");
            return (Criteria) this;
        }

        public Criteria andIsShareSuccessLessThan(Boolean value) {
            addCriterion("is_share_success <", value, "isShareSuccess");
            return (Criteria) this;
        }

        public Criteria andIsShareSuccessLessThanOrEqualTo(Boolean value) {
            addCriterion("is_share_success <=", value, "isShareSuccess");
            return (Criteria) this;
        }

        public Criteria andIsShareSuccessIn(List<Boolean> values) {
            addCriterion("is_share_success in", values, "isShareSuccess");
            return (Criteria) this;
        }

        public Criteria andIsShareSuccessNotIn(List<Boolean> values) {
            addCriterion("is_share_success not in", values, "isShareSuccess");
            return (Criteria) this;
        }

        public Criteria andIsShareSuccessBetween(Boolean value1, Boolean value2) {
            addCriterion("is_share_success between", value1, value2, "isShareSuccess");
            return (Criteria) this;
        }

        public Criteria andIsShareSuccessNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_share_success not between", value1, value2, "isShareSuccess");
            return (Criteria) this;
        }

        public Criteria andShareTitleLikeInsensitive(String value) {
            addCriterion("upper(share_title) like", value.toUpperCase(), "shareTitle");
            return (Criteria) this;
        }

        public Criteria andShareDescLikeInsensitive(String value) {
            addCriterion("upper(share_desc) like", value.toUpperCase(), "shareDesc");
            return (Criteria) this;
        }

        public Criteria andShareUrlLikeInsensitive(String value) {
            addCriterion("upper(share_url) like", value.toUpperCase(), "shareUrl");
            return (Criteria) this;
        }

        public Criteria andShareImgLikeInsensitive(String value) {
            addCriterion("upper(share_img) like", value.toUpperCase(), "shareImg");
            return (Criteria) this;
        }

        public Criteria andRecommendCodeLikeInsensitive(String value) {
            addCriterion("upper(recommend_code) like", value.toUpperCase(), "recommendCode");
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