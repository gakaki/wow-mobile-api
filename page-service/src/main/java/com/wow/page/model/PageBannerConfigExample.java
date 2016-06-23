package com.wow.page.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PageBannerConfigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PageBannerConfigExample() {
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

        public Criteria andBannerImgSrcIsNull() {
            addCriterion("banner_img_src is null");
            return (Criteria) this;
        }

        public Criteria andBannerImgSrcIsNotNull() {
            addCriterion("banner_img_src is not null");
            return (Criteria) this;
        }

        public Criteria andBannerImgSrcEqualTo(String value) {
            addCriterion("banner_img_src =", value, "bannerImgSrc");
            return (Criteria) this;
        }

        public Criteria andBannerImgSrcNotEqualTo(String value) {
            addCriterion("banner_img_src <>", value, "bannerImgSrc");
            return (Criteria) this;
        }

        public Criteria andBannerImgSrcGreaterThan(String value) {
            addCriterion("banner_img_src >", value, "bannerImgSrc");
            return (Criteria) this;
        }

        public Criteria andBannerImgSrcGreaterThanOrEqualTo(String value) {
            addCriterion("banner_img_src >=", value, "bannerImgSrc");
            return (Criteria) this;
        }

        public Criteria andBannerImgSrcLessThan(String value) {
            addCriterion("banner_img_src <", value, "bannerImgSrc");
            return (Criteria) this;
        }

        public Criteria andBannerImgSrcLessThanOrEqualTo(String value) {
            addCriterion("banner_img_src <=", value, "bannerImgSrc");
            return (Criteria) this;
        }

        public Criteria andBannerImgSrcLike(String value) {
            addCriterion("banner_img_src like", value, "bannerImgSrc");
            return (Criteria) this;
        }

        public Criteria andBannerImgSrcNotLike(String value) {
            addCriterion("banner_img_src not like", value, "bannerImgSrc");
            return (Criteria) this;
        }

        public Criteria andBannerImgSrcIn(List<String> values) {
            addCriterion("banner_img_src in", values, "bannerImgSrc");
            return (Criteria) this;
        }

        public Criteria andBannerImgSrcNotIn(List<String> values) {
            addCriterion("banner_img_src not in", values, "bannerImgSrc");
            return (Criteria) this;
        }

        public Criteria andBannerImgSrcBetween(String value1, String value2) {
            addCriterion("banner_img_src between", value1, value2, "bannerImgSrc");
            return (Criteria) this;
        }

        public Criteria andBannerImgSrcNotBetween(String value1, String value2) {
            addCriterion("banner_img_src not between", value1, value2, "bannerImgSrc");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTypeIsNull() {
            addCriterion("banner_link_type is null");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTypeIsNotNull() {
            addCriterion("banner_link_type is not null");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTypeEqualTo(Byte value) {
            addCriterion("banner_link_type =", value, "bannerLinkType");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTypeNotEqualTo(Byte value) {
            addCriterion("banner_link_type <>", value, "bannerLinkType");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTypeGreaterThan(Byte value) {
            addCriterion("banner_link_type >", value, "bannerLinkType");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("banner_link_type >=", value, "bannerLinkType");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTypeLessThan(Byte value) {
            addCriterion("banner_link_type <", value, "bannerLinkType");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTypeLessThanOrEqualTo(Byte value) {
            addCriterion("banner_link_type <=", value, "bannerLinkType");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTypeIn(List<Byte> values) {
            addCriterion("banner_link_type in", values, "bannerLinkType");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTypeNotIn(List<Byte> values) {
            addCriterion("banner_link_type not in", values, "bannerLinkType");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTypeBetween(Byte value1, Byte value2) {
            addCriterion("banner_link_type between", value1, value2, "bannerLinkType");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("banner_link_type not between", value1, value2, "bannerLinkType");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlIsNull() {
            addCriterion("banner_link_url is null");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlIsNotNull() {
            addCriterion("banner_link_url is not null");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlEqualTo(String value) {
            addCriterion("banner_link_url =", value, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlNotEqualTo(String value) {
            addCriterion("banner_link_url <>", value, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlGreaterThan(String value) {
            addCriterion("banner_link_url >", value, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlGreaterThanOrEqualTo(String value) {
            addCriterion("banner_link_url >=", value, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlLessThan(String value) {
            addCriterion("banner_link_url <", value, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlLessThanOrEqualTo(String value) {
            addCriterion("banner_link_url <=", value, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlLike(String value) {
            addCriterion("banner_link_url like", value, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlNotLike(String value) {
            addCriterion("banner_link_url not like", value, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlIn(List<String> values) {
            addCriterion("banner_link_url in", values, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlNotIn(List<String> values) {
            addCriterion("banner_link_url not in", values, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlBetween(String value1, String value2) {
            addCriterion("banner_link_url between", value1, value2, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlNotBetween(String value1, String value2) {
            addCriterion("banner_link_url not between", value1, value2, "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andActiveFromIsNull() {
            addCriterion("active_from is null");
            return (Criteria) this;
        }

        public Criteria andActiveFromIsNotNull() {
            addCriterion("active_from is not null");
            return (Criteria) this;
        }

        public Criteria andActiveFromEqualTo(Date value) {
            addCriterion("active_from =", value, "activeFrom");
            return (Criteria) this;
        }

        public Criteria andActiveFromNotEqualTo(Date value) {
            addCriterion("active_from <>", value, "activeFrom");
            return (Criteria) this;
        }

        public Criteria andActiveFromGreaterThan(Date value) {
            addCriterion("active_from >", value, "activeFrom");
            return (Criteria) this;
        }

        public Criteria andActiveFromGreaterThanOrEqualTo(Date value) {
            addCriterion("active_from >=", value, "activeFrom");
            return (Criteria) this;
        }

        public Criteria andActiveFromLessThan(Date value) {
            addCriterion("active_from <", value, "activeFrom");
            return (Criteria) this;
        }

        public Criteria andActiveFromLessThanOrEqualTo(Date value) {
            addCriterion("active_from <=", value, "activeFrom");
            return (Criteria) this;
        }

        public Criteria andActiveFromIn(List<Date> values) {
            addCriterion("active_from in", values, "activeFrom");
            return (Criteria) this;
        }

        public Criteria andActiveFromNotIn(List<Date> values) {
            addCriterion("active_from not in", values, "activeFrom");
            return (Criteria) this;
        }

        public Criteria andActiveFromBetween(Date value1, Date value2) {
            addCriterion("active_from between", value1, value2, "activeFrom");
            return (Criteria) this;
        }

        public Criteria andActiveFromNotBetween(Date value1, Date value2) {
            addCriterion("active_from not between", value1, value2, "activeFrom");
            return (Criteria) this;
        }

        public Criteria andActiveToIsNull() {
            addCriterion("active_to is null");
            return (Criteria) this;
        }

        public Criteria andActiveToIsNotNull() {
            addCriterion("active_to is not null");
            return (Criteria) this;
        }

        public Criteria andActiveToEqualTo(Date value) {
            addCriterion("active_to =", value, "activeTo");
            return (Criteria) this;
        }

        public Criteria andActiveToNotEqualTo(Date value) {
            addCriterion("active_to <>", value, "activeTo");
            return (Criteria) this;
        }

        public Criteria andActiveToGreaterThan(Date value) {
            addCriterion("active_to >", value, "activeTo");
            return (Criteria) this;
        }

        public Criteria andActiveToGreaterThanOrEqualTo(Date value) {
            addCriterion("active_to >=", value, "activeTo");
            return (Criteria) this;
        }

        public Criteria andActiveToLessThan(Date value) {
            addCriterion("active_to <", value, "activeTo");
            return (Criteria) this;
        }

        public Criteria andActiveToLessThanOrEqualTo(Date value) {
            addCriterion("active_to <=", value, "activeTo");
            return (Criteria) this;
        }

        public Criteria andActiveToIn(List<Date> values) {
            addCriterion("active_to in", values, "activeTo");
            return (Criteria) this;
        }

        public Criteria andActiveToNotIn(List<Date> values) {
            addCriterion("active_to not in", values, "activeTo");
            return (Criteria) this;
        }

        public Criteria andActiveToBetween(Date value1, Date value2) {
            addCriterion("active_to between", value1, value2, "activeTo");
            return (Criteria) this;
        }

        public Criteria andActiveToNotBetween(Date value1, Date value2) {
            addCriterion("active_to not between", value1, value2, "activeTo");
            return (Criteria) this;
        }

        public Criteria andBannerTitleIsNull() {
            addCriterion("banner_title is null");
            return (Criteria) this;
        }

        public Criteria andBannerTitleIsNotNull() {
            addCriterion("banner_title is not null");
            return (Criteria) this;
        }

        public Criteria andBannerTitleEqualTo(String value) {
            addCriterion("banner_title =", value, "bannerTitle");
            return (Criteria) this;
        }

        public Criteria andBannerTitleNotEqualTo(String value) {
            addCriterion("banner_title <>", value, "bannerTitle");
            return (Criteria) this;
        }

        public Criteria andBannerTitleGreaterThan(String value) {
            addCriterion("banner_title >", value, "bannerTitle");
            return (Criteria) this;
        }

        public Criteria andBannerTitleGreaterThanOrEqualTo(String value) {
            addCriterion("banner_title >=", value, "bannerTitle");
            return (Criteria) this;
        }

        public Criteria andBannerTitleLessThan(String value) {
            addCriterion("banner_title <", value, "bannerTitle");
            return (Criteria) this;
        }

        public Criteria andBannerTitleLessThanOrEqualTo(String value) {
            addCriterion("banner_title <=", value, "bannerTitle");
            return (Criteria) this;
        }

        public Criteria andBannerTitleLike(String value) {
            addCriterion("banner_title like", value, "bannerTitle");
            return (Criteria) this;
        }

        public Criteria andBannerTitleNotLike(String value) {
            addCriterion("banner_title not like", value, "bannerTitle");
            return (Criteria) this;
        }

        public Criteria andBannerTitleIn(List<String> values) {
            addCriterion("banner_title in", values, "bannerTitle");
            return (Criteria) this;
        }

        public Criteria andBannerTitleNotIn(List<String> values) {
            addCriterion("banner_title not in", values, "bannerTitle");
            return (Criteria) this;
        }

        public Criteria andBannerTitleBetween(String value1, String value2) {
            addCriterion("banner_title between", value1, value2, "bannerTitle");
            return (Criteria) this;
        }

        public Criteria andBannerTitleNotBetween(String value1, String value2) {
            addCriterion("banner_title not between", value1, value2, "bannerTitle");
            return (Criteria) this;
        }

        public Criteria andBannerDescIsNull() {
            addCriterion("banner_desc is null");
            return (Criteria) this;
        }

        public Criteria andBannerDescIsNotNull() {
            addCriterion("banner_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBannerDescEqualTo(String value) {
            addCriterion("banner_desc =", value, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescNotEqualTo(String value) {
            addCriterion("banner_desc <>", value, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescGreaterThan(String value) {
            addCriterion("banner_desc >", value, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescGreaterThanOrEqualTo(String value) {
            addCriterion("banner_desc >=", value, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescLessThan(String value) {
            addCriterion("banner_desc <", value, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescLessThanOrEqualTo(String value) {
            addCriterion("banner_desc <=", value, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescLike(String value) {
            addCriterion("banner_desc like", value, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescNotLike(String value) {
            addCriterion("banner_desc not like", value, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescIn(List<String> values) {
            addCriterion("banner_desc in", values, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescNotIn(List<String> values) {
            addCriterion("banner_desc not in", values, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescBetween(String value1, String value2) {
            addCriterion("banner_desc between", value1, value2, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerDescNotBetween(String value1, String value2) {
            addCriterion("banner_desc not between", value1, value2, "bannerDesc");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTargetIdIsNull() {
            addCriterion("banner_link_target_id is null");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTargetIdIsNotNull() {
            addCriterion("banner_link_target_id is not null");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTargetIdEqualTo(Integer value) {
            addCriterion("banner_link_target_id =", value, "bannerLinkTargetId");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTargetIdNotEqualTo(Integer value) {
            addCriterion("banner_link_target_id <>", value, "bannerLinkTargetId");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTargetIdGreaterThan(Integer value) {
            addCriterion("banner_link_target_id >", value, "bannerLinkTargetId");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTargetIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("banner_link_target_id >=", value, "bannerLinkTargetId");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTargetIdLessThan(Integer value) {
            addCriterion("banner_link_target_id <", value, "bannerLinkTargetId");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTargetIdLessThanOrEqualTo(Integer value) {
            addCriterion("banner_link_target_id <=", value, "bannerLinkTargetId");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTargetIdIn(List<Integer> values) {
            addCriterion("banner_link_target_id in", values, "bannerLinkTargetId");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTargetIdNotIn(List<Integer> values) {
            addCriterion("banner_link_target_id not in", values, "bannerLinkTargetId");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTargetIdBetween(Integer value1, Integer value2) {
            addCriterion("banner_link_target_id between", value1, value2, "bannerLinkTargetId");
            return (Criteria) this;
        }

        public Criteria andBannerLinkTargetIdNotBetween(Integer value1, Integer value2) {
            addCriterion("banner_link_target_id not between", value1, value2, "bannerLinkTargetId");
            return (Criteria) this;
        }

        public Criteria andBannerImgSrcLikeInsensitive(String value) {
            addCriterion("upper(banner_img_src) like", value.toUpperCase(), "bannerImgSrc");
            return (Criteria) this;
        }

        public Criteria andBannerLinkUrlLikeInsensitive(String value) {
            addCriterion("upper(banner_link_url) like", value.toUpperCase(), "bannerLinkUrl");
            return (Criteria) this;
        }

        public Criteria andBannerTitleLikeInsensitive(String value) {
            addCriterion("upper(banner_title) like", value.toUpperCase(), "bannerTitle");
            return (Criteria) this;
        }

        public Criteria andBannerDescLikeInsensitive(String value) {
            addCriterion("upper(banner_desc) like", value.toUpperCase(), "bannerDesc");
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