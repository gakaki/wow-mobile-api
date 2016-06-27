package com.wow.product.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TopicExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TopicExample() {
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

        public Criteria andTopicNameIsNull() {
            addCriterion("topic_name is null");
            return (Criteria) this;
        }

        public Criteria andTopicNameIsNotNull() {
            addCriterion("topic_name is not null");
            return (Criteria) this;
        }

        public Criteria andTopicNameEqualTo(String value) {
            addCriterion("topic_name =", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameNotEqualTo(String value) {
            addCriterion("topic_name <>", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameGreaterThan(String value) {
            addCriterion("topic_name >", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameGreaterThanOrEqualTo(String value) {
            addCriterion("topic_name >=", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameLessThan(String value) {
            addCriterion("topic_name <", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameLessThanOrEqualTo(String value) {
            addCriterion("topic_name <=", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameLike(String value) {
            addCriterion("topic_name like", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameNotLike(String value) {
            addCriterion("topic_name not like", value, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameIn(List<String> values) {
            addCriterion("topic_name in", values, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameNotIn(List<String> values) {
            addCriterion("topic_name not in", values, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameBetween(String value1, String value2) {
            addCriterion("topic_name between", value1, value2, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicNameNotBetween(String value1, String value2) {
            addCriterion("topic_name not between", value1, value2, "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicImgIsNull() {
            addCriterion("topic_img is null");
            return (Criteria) this;
        }

        public Criteria andTopicImgIsNotNull() {
            addCriterion("topic_img is not null");
            return (Criteria) this;
        }

        public Criteria andTopicImgEqualTo(String value) {
            addCriterion("topic_img =", value, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgNotEqualTo(String value) {
            addCriterion("topic_img <>", value, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgGreaterThan(String value) {
            addCriterion("topic_img >", value, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgGreaterThanOrEqualTo(String value) {
            addCriterion("topic_img >=", value, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgLessThan(String value) {
            addCriterion("topic_img <", value, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgLessThanOrEqualTo(String value) {
            addCriterion("topic_img <=", value, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgLike(String value) {
            addCriterion("topic_img like", value, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgNotLike(String value) {
            addCriterion("topic_img not like", value, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgIn(List<String> values) {
            addCriterion("topic_img in", values, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgNotIn(List<String> values) {
            addCriterion("topic_img not in", values, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgBetween(String value1, String value2) {
            addCriterion("topic_img between", value1, value2, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgNotBetween(String value1, String value2) {
            addCriterion("topic_img not between", value1, value2, "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgLinkIsNull() {
            addCriterion("topic_img_link is null");
            return (Criteria) this;
        }

        public Criteria andTopicImgLinkIsNotNull() {
            addCriterion("topic_img_link is not null");
            return (Criteria) this;
        }

        public Criteria andTopicImgLinkEqualTo(String value) {
            addCriterion("topic_img_link =", value, "topicImgLink");
            return (Criteria) this;
        }

        public Criteria andTopicImgLinkNotEqualTo(String value) {
            addCriterion("topic_img_link <>", value, "topicImgLink");
            return (Criteria) this;
        }

        public Criteria andTopicImgLinkGreaterThan(String value) {
            addCriterion("topic_img_link >", value, "topicImgLink");
            return (Criteria) this;
        }

        public Criteria andTopicImgLinkGreaterThanOrEqualTo(String value) {
            addCriterion("topic_img_link >=", value, "topicImgLink");
            return (Criteria) this;
        }

        public Criteria andTopicImgLinkLessThan(String value) {
            addCriterion("topic_img_link <", value, "topicImgLink");
            return (Criteria) this;
        }

        public Criteria andTopicImgLinkLessThanOrEqualTo(String value) {
            addCriterion("topic_img_link <=", value, "topicImgLink");
            return (Criteria) this;
        }

        public Criteria andTopicImgLinkLike(String value) {
            addCriterion("topic_img_link like", value, "topicImgLink");
            return (Criteria) this;
        }

        public Criteria andTopicImgLinkNotLike(String value) {
            addCriterion("topic_img_link not like", value, "topicImgLink");
            return (Criteria) this;
        }

        public Criteria andTopicImgLinkIn(List<String> values) {
            addCriterion("topic_img_link in", values, "topicImgLink");
            return (Criteria) this;
        }

        public Criteria andTopicImgLinkNotIn(List<String> values) {
            addCriterion("topic_img_link not in", values, "topicImgLink");
            return (Criteria) this;
        }

        public Criteria andTopicImgLinkBetween(String value1, String value2) {
            addCriterion("topic_img_link between", value1, value2, "topicImgLink");
            return (Criteria) this;
        }

        public Criteria andTopicImgLinkNotBetween(String value1, String value2) {
            addCriterion("topic_img_link not between", value1, value2, "topicImgLink");
            return (Criteria) this;
        }

        public Criteria andTopicMainTitleIsNull() {
            addCriterion("topic_main_title is null");
            return (Criteria) this;
        }

        public Criteria andTopicMainTitleIsNotNull() {
            addCriterion("topic_main_title is not null");
            return (Criteria) this;
        }

        public Criteria andTopicMainTitleEqualTo(String value) {
            addCriterion("topic_main_title =", value, "topicMainTitle");
            return (Criteria) this;
        }

        public Criteria andTopicMainTitleNotEqualTo(String value) {
            addCriterion("topic_main_title <>", value, "topicMainTitle");
            return (Criteria) this;
        }

        public Criteria andTopicMainTitleGreaterThan(String value) {
            addCriterion("topic_main_title >", value, "topicMainTitle");
            return (Criteria) this;
        }

        public Criteria andTopicMainTitleGreaterThanOrEqualTo(String value) {
            addCriterion("topic_main_title >=", value, "topicMainTitle");
            return (Criteria) this;
        }

        public Criteria andTopicMainTitleLessThan(String value) {
            addCriterion("topic_main_title <", value, "topicMainTitle");
            return (Criteria) this;
        }

        public Criteria andTopicMainTitleLessThanOrEqualTo(String value) {
            addCriterion("topic_main_title <=", value, "topicMainTitle");
            return (Criteria) this;
        }

        public Criteria andTopicMainTitleLike(String value) {
            addCriterion("topic_main_title like", value, "topicMainTitle");
            return (Criteria) this;
        }

        public Criteria andTopicMainTitleNotLike(String value) {
            addCriterion("topic_main_title not like", value, "topicMainTitle");
            return (Criteria) this;
        }

        public Criteria andTopicMainTitleIn(List<String> values) {
            addCriterion("topic_main_title in", values, "topicMainTitle");
            return (Criteria) this;
        }

        public Criteria andTopicMainTitleNotIn(List<String> values) {
            addCriterion("topic_main_title not in", values, "topicMainTitle");
            return (Criteria) this;
        }

        public Criteria andTopicMainTitleBetween(String value1, String value2) {
            addCriterion("topic_main_title between", value1, value2, "topicMainTitle");
            return (Criteria) this;
        }

        public Criteria andTopicMainTitleNotBetween(String value1, String value2) {
            addCriterion("topic_main_title not between", value1, value2, "topicMainTitle");
            return (Criteria) this;
        }

        public Criteria andTopicDescIsNull() {
            addCriterion("topic_desc is null");
            return (Criteria) this;
        }

        public Criteria andTopicDescIsNotNull() {
            addCriterion("topic_desc is not null");
            return (Criteria) this;
        }

        public Criteria andTopicDescEqualTo(String value) {
            addCriterion("topic_desc =", value, "topicDesc");
            return (Criteria) this;
        }

        public Criteria andTopicDescNotEqualTo(String value) {
            addCriterion("topic_desc <>", value, "topicDesc");
            return (Criteria) this;
        }

        public Criteria andTopicDescGreaterThan(String value) {
            addCriterion("topic_desc >", value, "topicDesc");
            return (Criteria) this;
        }

        public Criteria andTopicDescGreaterThanOrEqualTo(String value) {
            addCriterion("topic_desc >=", value, "topicDesc");
            return (Criteria) this;
        }

        public Criteria andTopicDescLessThan(String value) {
            addCriterion("topic_desc <", value, "topicDesc");
            return (Criteria) this;
        }

        public Criteria andTopicDescLessThanOrEqualTo(String value) {
            addCriterion("topic_desc <=", value, "topicDesc");
            return (Criteria) this;
        }

        public Criteria andTopicDescLike(String value) {
            addCriterion("topic_desc like", value, "topicDesc");
            return (Criteria) this;
        }

        public Criteria andTopicDescNotLike(String value) {
            addCriterion("topic_desc not like", value, "topicDesc");
            return (Criteria) this;
        }

        public Criteria andTopicDescIn(List<String> values) {
            addCriterion("topic_desc in", values, "topicDesc");
            return (Criteria) this;
        }

        public Criteria andTopicDescNotIn(List<String> values) {
            addCriterion("topic_desc not in", values, "topicDesc");
            return (Criteria) this;
        }

        public Criteria andTopicDescBetween(String value1, String value2) {
            addCriterion("topic_desc between", value1, value2, "topicDesc");
            return (Criteria) this;
        }

        public Criteria andTopicDescNotBetween(String value1, String value2) {
            addCriterion("topic_desc not between", value1, value2, "topicDesc");
            return (Criteria) this;
        }

        public Criteria andTopicTypeIsNull() {
            addCriterion("topic_type is null");
            return (Criteria) this;
        }

        public Criteria andTopicTypeIsNotNull() {
            addCriterion("topic_type is not null");
            return (Criteria) this;
        }

        public Criteria andTopicTypeEqualTo(Byte value) {
            addCriterion("topic_type =", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotEqualTo(Byte value) {
            addCriterion("topic_type <>", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeGreaterThan(Byte value) {
            addCriterion("topic_type >", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("topic_type >=", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeLessThan(Byte value) {
            addCriterion("topic_type <", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeLessThanOrEqualTo(Byte value) {
            addCriterion("topic_type <=", value, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeIn(List<Byte> values) {
            addCriterion("topic_type in", values, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotIn(List<Byte> values) {
            addCriterion("topic_type not in", values, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeBetween(Byte value1, Byte value2) {
            addCriterion("topic_type between", value1, value2, "topicType");
            return (Criteria) this;
        }

        public Criteria andTopicTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("topic_type not between", value1, value2, "topicType");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andCanShowIsNull() {
            addCriterion("can_show is null");
            return (Criteria) this;
        }

        public Criteria andCanShowIsNotNull() {
            addCriterion("can_show is not null");
            return (Criteria) this;
        }

        public Criteria andCanShowEqualTo(Boolean value) {
            addCriterion("can_show =", value, "canShow");
            return (Criteria) this;
        }

        public Criteria andCanShowNotEqualTo(Boolean value) {
            addCriterion("can_show <>", value, "canShow");
            return (Criteria) this;
        }

        public Criteria andCanShowGreaterThan(Boolean value) {
            addCriterion("can_show >", value, "canShow");
            return (Criteria) this;
        }

        public Criteria andCanShowGreaterThanOrEqualTo(Boolean value) {
            addCriterion("can_show >=", value, "canShow");
            return (Criteria) this;
        }

        public Criteria andCanShowLessThan(Boolean value) {
            addCriterion("can_show <", value, "canShow");
            return (Criteria) this;
        }

        public Criteria andCanShowLessThanOrEqualTo(Boolean value) {
            addCriterion("can_show <=", value, "canShow");
            return (Criteria) this;
        }

        public Criteria andCanShowIn(List<Boolean> values) {
            addCriterion("can_show in", values, "canShow");
            return (Criteria) this;
        }

        public Criteria andCanShowNotIn(List<Boolean> values) {
            addCriterion("can_show not in", values, "canShow");
            return (Criteria) this;
        }

        public Criteria andCanShowBetween(Boolean value1, Boolean value2) {
            addCriterion("can_show between", value1, value2, "canShow");
            return (Criteria) this;
        }

        public Criteria andCanShowNotBetween(Boolean value1, Boolean value2) {
            addCriterion("can_show not between", value1, value2, "canShow");
            return (Criteria) this;
        }

        public Criteria andProductQtyShowAlongWithTopicIsNull() {
            addCriterion("product_qty_show_along_with_topic is null");
            return (Criteria) this;
        }

        public Criteria andProductQtyShowAlongWithTopicIsNotNull() {
            addCriterion("product_qty_show_along_with_topic is not null");
            return (Criteria) this;
        }

        public Criteria andProductQtyShowAlongWithTopicEqualTo(Byte value) {
            addCriterion("product_qty_show_along_with_topic =", value, "productQtyShowAlongWithTopic");
            return (Criteria) this;
        }

        public Criteria andProductQtyShowAlongWithTopicNotEqualTo(Byte value) {
            addCriterion("product_qty_show_along_with_topic <>", value, "productQtyShowAlongWithTopic");
            return (Criteria) this;
        }

        public Criteria andProductQtyShowAlongWithTopicGreaterThan(Byte value) {
            addCriterion("product_qty_show_along_with_topic >", value, "productQtyShowAlongWithTopic");
            return (Criteria) this;
        }

        public Criteria andProductQtyShowAlongWithTopicGreaterThanOrEqualTo(Byte value) {
            addCriterion("product_qty_show_along_with_topic >=", value, "productQtyShowAlongWithTopic");
            return (Criteria) this;
        }

        public Criteria andProductQtyShowAlongWithTopicLessThan(Byte value) {
            addCriterion("product_qty_show_along_with_topic <", value, "productQtyShowAlongWithTopic");
            return (Criteria) this;
        }

        public Criteria andProductQtyShowAlongWithTopicLessThanOrEqualTo(Byte value) {
            addCriterion("product_qty_show_along_with_topic <=", value, "productQtyShowAlongWithTopic");
            return (Criteria) this;
        }

        public Criteria andProductQtyShowAlongWithTopicIn(List<Byte> values) {
            addCriterion("product_qty_show_along_with_topic in", values, "productQtyShowAlongWithTopic");
            return (Criteria) this;
        }

        public Criteria andProductQtyShowAlongWithTopicNotIn(List<Byte> values) {
            addCriterion("product_qty_show_along_with_topic not in", values, "productQtyShowAlongWithTopic");
            return (Criteria) this;
        }

        public Criteria andProductQtyShowAlongWithTopicBetween(Byte value1, Byte value2) {
            addCriterion("product_qty_show_along_with_topic between", value1, value2, "productQtyShowAlongWithTopic");
            return (Criteria) this;
        }

        public Criteria andProductQtyShowAlongWithTopicNotBetween(Byte value1, Byte value2) {
            addCriterion("product_qty_show_along_with_topic not between", value1, value2, "productQtyShowAlongWithTopic");
            return (Criteria) this;
        }

        public Criteria andIsAllowCommentIsNull() {
            addCriterion("is_allow_comment is null");
            return (Criteria) this;
        }

        public Criteria andIsAllowCommentIsNotNull() {
            addCriterion("is_allow_comment is not null");
            return (Criteria) this;
        }

        public Criteria andIsAllowCommentEqualTo(Boolean value) {
            addCriterion("is_allow_comment =", value, "isAllowComment");
            return (Criteria) this;
        }

        public Criteria andIsAllowCommentNotEqualTo(Boolean value) {
            addCriterion("is_allow_comment <>", value, "isAllowComment");
            return (Criteria) this;
        }

        public Criteria andIsAllowCommentGreaterThan(Boolean value) {
            addCriterion("is_allow_comment >", value, "isAllowComment");
            return (Criteria) this;
        }

        public Criteria andIsAllowCommentGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_allow_comment >=", value, "isAllowComment");
            return (Criteria) this;
        }

        public Criteria andIsAllowCommentLessThan(Boolean value) {
            addCriterion("is_allow_comment <", value, "isAllowComment");
            return (Criteria) this;
        }

        public Criteria andIsAllowCommentLessThanOrEqualTo(Boolean value) {
            addCriterion("is_allow_comment <=", value, "isAllowComment");
            return (Criteria) this;
        }

        public Criteria andIsAllowCommentIn(List<Boolean> values) {
            addCriterion("is_allow_comment in", values, "isAllowComment");
            return (Criteria) this;
        }

        public Criteria andIsAllowCommentNotIn(List<Boolean> values) {
            addCriterion("is_allow_comment not in", values, "isAllowComment");
            return (Criteria) this;
        }

        public Criteria andIsAllowCommentBetween(Boolean value1, Boolean value2) {
            addCriterion("is_allow_comment between", value1, value2, "isAllowComment");
            return (Criteria) this;
        }

        public Criteria andIsAllowCommentNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_allow_comment not between", value1, value2, "isAllowComment");
            return (Criteria) this;
        }

        public Criteria andCommentQtyIsNull() {
            addCriterion("comment_qty is null");
            return (Criteria) this;
        }

        public Criteria andCommentQtyIsNotNull() {
            addCriterion("comment_qty is not null");
            return (Criteria) this;
        }

        public Criteria andCommentQtyEqualTo(Integer value) {
            addCriterion("comment_qty =", value, "commentQty");
            return (Criteria) this;
        }

        public Criteria andCommentQtyNotEqualTo(Integer value) {
            addCriterion("comment_qty <>", value, "commentQty");
            return (Criteria) this;
        }

        public Criteria andCommentQtyGreaterThan(Integer value) {
            addCriterion("comment_qty >", value, "commentQty");
            return (Criteria) this;
        }

        public Criteria andCommentQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("comment_qty >=", value, "commentQty");
            return (Criteria) this;
        }

        public Criteria andCommentQtyLessThan(Integer value) {
            addCriterion("comment_qty <", value, "commentQty");
            return (Criteria) this;
        }

        public Criteria andCommentQtyLessThanOrEqualTo(Integer value) {
            addCriterion("comment_qty <=", value, "commentQty");
            return (Criteria) this;
        }

        public Criteria andCommentQtyIn(List<Integer> values) {
            addCriterion("comment_qty in", values, "commentQty");
            return (Criteria) this;
        }

        public Criteria andCommentQtyNotIn(List<Integer> values) {
            addCriterion("comment_qty not in", values, "commentQty");
            return (Criteria) this;
        }

        public Criteria andCommentQtyBetween(Integer value1, Integer value2) {
            addCriterion("comment_qty between", value1, value2, "commentQty");
            return (Criteria) this;
        }

        public Criteria andCommentQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("comment_qty not between", value1, value2, "commentQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyIsNull() {
            addCriterion("follow_qty is null");
            return (Criteria) this;
        }

        public Criteria andFollowQtyIsNotNull() {
            addCriterion("follow_qty is not null");
            return (Criteria) this;
        }

        public Criteria andFollowQtyEqualTo(Integer value) {
            addCriterion("follow_qty =", value, "followQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyNotEqualTo(Integer value) {
            addCriterion("follow_qty <>", value, "followQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyGreaterThan(Integer value) {
            addCriterion("follow_qty >", value, "followQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("follow_qty >=", value, "followQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyLessThan(Integer value) {
            addCriterion("follow_qty <", value, "followQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyLessThanOrEqualTo(Integer value) {
            addCriterion("follow_qty <=", value, "followQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyIn(List<Integer> values) {
            addCriterion("follow_qty in", values, "followQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyNotIn(List<Integer> values) {
            addCriterion("follow_qty not in", values, "followQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyBetween(Integer value1, Integer value2) {
            addCriterion("follow_qty between", value1, value2, "followQty");
            return (Criteria) this;
        }

        public Criteria andFollowQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("follow_qty not between", value1, value2, "followQty");
            return (Criteria) this;
        }

        public Criteria andShareQtyIsNull() {
            addCriterion("share_qty is null");
            return (Criteria) this;
        }

        public Criteria andShareQtyIsNotNull() {
            addCriterion("share_qty is not null");
            return (Criteria) this;
        }

        public Criteria andShareQtyEqualTo(Integer value) {
            addCriterion("share_qty =", value, "shareQty");
            return (Criteria) this;
        }

        public Criteria andShareQtyNotEqualTo(Integer value) {
            addCriterion("share_qty <>", value, "shareQty");
            return (Criteria) this;
        }

        public Criteria andShareQtyGreaterThan(Integer value) {
            addCriterion("share_qty >", value, "shareQty");
            return (Criteria) this;
        }

        public Criteria andShareQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("share_qty >=", value, "shareQty");
            return (Criteria) this;
        }

        public Criteria andShareQtyLessThan(Integer value) {
            addCriterion("share_qty <", value, "shareQty");
            return (Criteria) this;
        }

        public Criteria andShareQtyLessThanOrEqualTo(Integer value) {
            addCriterion("share_qty <=", value, "shareQty");
            return (Criteria) this;
        }

        public Criteria andShareQtyIn(List<Integer> values) {
            addCriterion("share_qty in", values, "shareQty");
            return (Criteria) this;
        }

        public Criteria andShareQtyNotIn(List<Integer> values) {
            addCriterion("share_qty not in", values, "shareQty");
            return (Criteria) this;
        }

        public Criteria andShareQtyBetween(Integer value1, Integer value2) {
            addCriterion("share_qty between", value1, value2, "shareQty");
            return (Criteria) this;
        }

        public Criteria andShareQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("share_qty not between", value1, value2, "shareQty");
            return (Criteria) this;
        }

        public Criteria andLikeQtyIsNull() {
            addCriterion("like_qty is null");
            return (Criteria) this;
        }

        public Criteria andLikeQtyIsNotNull() {
            addCriterion("like_qty is not null");
            return (Criteria) this;
        }

        public Criteria andLikeQtyEqualTo(Integer value) {
            addCriterion("like_qty =", value, "likeQty");
            return (Criteria) this;
        }

        public Criteria andLikeQtyNotEqualTo(Integer value) {
            addCriterion("like_qty <>", value, "likeQty");
            return (Criteria) this;
        }

        public Criteria andLikeQtyGreaterThan(Integer value) {
            addCriterion("like_qty >", value, "likeQty");
            return (Criteria) this;
        }

        public Criteria andLikeQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("like_qty >=", value, "likeQty");
            return (Criteria) this;
        }

        public Criteria andLikeQtyLessThan(Integer value) {
            addCriterion("like_qty <", value, "likeQty");
            return (Criteria) this;
        }

        public Criteria andLikeQtyLessThanOrEqualTo(Integer value) {
            addCriterion("like_qty <=", value, "likeQty");
            return (Criteria) this;
        }

        public Criteria andLikeQtyIn(List<Integer> values) {
            addCriterion("like_qty in", values, "likeQty");
            return (Criteria) this;
        }

        public Criteria andLikeQtyNotIn(List<Integer> values) {
            addCriterion("like_qty not in", values, "likeQty");
            return (Criteria) this;
        }

        public Criteria andLikeQtyBetween(Integer value1, Integer value2) {
            addCriterion("like_qty between", value1, value2, "likeQty");
            return (Criteria) this;
        }

        public Criteria andLikeQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("like_qty not between", value1, value2, "likeQty");
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

        public Criteria andTopicNameLikeInsensitive(String value) {
            addCriterion("upper(topic_name) like", value.toUpperCase(), "topicName");
            return (Criteria) this;
        }

        public Criteria andTopicImgLikeInsensitive(String value) {
            addCriterion("upper(topic_img) like", value.toUpperCase(), "topicImg");
            return (Criteria) this;
        }

        public Criteria andTopicImgLinkLikeInsensitive(String value) {
            addCriterion("upper(topic_img_link) like", value.toUpperCase(), "topicImgLink");
            return (Criteria) this;
        }

        public Criteria andTopicMainTitleLikeInsensitive(String value) {
            addCriterion("upper(topic_main_title) like", value.toUpperCase(), "topicMainTitle");
            return (Criteria) this;
        }

        public Criteria andTopicDescLikeInsensitive(String value) {
            addCriterion("upper(topic_desc) like", value.toUpperCase(), "topicDesc");
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