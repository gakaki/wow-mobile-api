package com.wow.product.model;

import java.util.ArrayList;
import java.util.List;

public class DesignerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DesignerExample() {
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

        public Criteria andDesignerNameIsNull() {
            addCriterion("designer_name is null");
            return (Criteria) this;
        }

        public Criteria andDesignerNameIsNotNull() {
            addCriterion("designer_name is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerNameEqualTo(String value) {
            addCriterion("designer_name =", value, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameNotEqualTo(String value) {
            addCriterion("designer_name <>", value, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameGreaterThan(String value) {
            addCriterion("designer_name >", value, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameGreaterThanOrEqualTo(String value) {
            addCriterion("designer_name >=", value, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameLessThan(String value) {
            addCriterion("designer_name <", value, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameLessThanOrEqualTo(String value) {
            addCriterion("designer_name <=", value, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameLike(String value) {
            addCriterion("designer_name like", value, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameNotLike(String value) {
            addCriterion("designer_name not like", value, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameIn(List<String> values) {
            addCriterion("designer_name in", values, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameNotIn(List<String> values) {
            addCriterion("designer_name not in", values, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameBetween(String value1, String value2) {
            addCriterion("designer_name between", value1, value2, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerNameNotBetween(String value1, String value2) {
            addCriterion("designer_name not between", value1, value2, "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerSexIsNull() {
            addCriterion("designer_sex is null");
            return (Criteria) this;
        }

        public Criteria andDesignerSexIsNotNull() {
            addCriterion("designer_sex is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerSexEqualTo(Byte value) {
            addCriterion("designer_sex =", value, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexNotEqualTo(Byte value) {
            addCriterion("designer_sex <>", value, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexGreaterThan(Byte value) {
            addCriterion("designer_sex >", value, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexGreaterThanOrEqualTo(Byte value) {
            addCriterion("designer_sex >=", value, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexLessThan(Byte value) {
            addCriterion("designer_sex <", value, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexLessThanOrEqualTo(Byte value) {
            addCriterion("designer_sex <=", value, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexIn(List<Byte> values) {
            addCriterion("designer_sex in", values, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexNotIn(List<Byte> values) {
            addCriterion("designer_sex not in", values, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexBetween(Byte value1, Byte value2) {
            addCriterion("designer_sex between", value1, value2, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerSexNotBetween(Byte value1, Byte value2) {
            addCriterion("designer_sex not between", value1, value2, "designerSex");
            return (Criteria) this;
        }

        public Criteria andDesignerCountryIsNull() {
            addCriterion("designer_country is null");
            return (Criteria) this;
        }

        public Criteria andDesignerCountryIsNotNull() {
            addCriterion("designer_country is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerCountryEqualTo(String value) {
            addCriterion("designer_country =", value, "designerCountry");
            return (Criteria) this;
        }

        public Criteria andDesignerCountryNotEqualTo(String value) {
            addCriterion("designer_country <>", value, "designerCountry");
            return (Criteria) this;
        }

        public Criteria andDesignerCountryGreaterThan(String value) {
            addCriterion("designer_country >", value, "designerCountry");
            return (Criteria) this;
        }

        public Criteria andDesignerCountryGreaterThanOrEqualTo(String value) {
            addCriterion("designer_country >=", value, "designerCountry");
            return (Criteria) this;
        }

        public Criteria andDesignerCountryLessThan(String value) {
            addCriterion("designer_country <", value, "designerCountry");
            return (Criteria) this;
        }

        public Criteria andDesignerCountryLessThanOrEqualTo(String value) {
            addCriterion("designer_country <=", value, "designerCountry");
            return (Criteria) this;
        }

        public Criteria andDesignerCountryLike(String value) {
            addCriterion("designer_country like", value, "designerCountry");
            return (Criteria) this;
        }

        public Criteria andDesignerCountryNotLike(String value) {
            addCriterion("designer_country not like", value, "designerCountry");
            return (Criteria) this;
        }

        public Criteria andDesignerCountryIn(List<String> values) {
            addCriterion("designer_country in", values, "designerCountry");
            return (Criteria) this;
        }

        public Criteria andDesignerCountryNotIn(List<String> values) {
            addCriterion("designer_country not in", values, "designerCountry");
            return (Criteria) this;
        }

        public Criteria andDesignerCountryBetween(String value1, String value2) {
            addCriterion("designer_country between", value1, value2, "designerCountry");
            return (Criteria) this;
        }

        public Criteria andDesignerCountryNotBetween(String value1, String value2) {
            addCriterion("designer_country not between", value1, value2, "designerCountry");
            return (Criteria) this;
        }

        public Criteria andDesignerHomeUrlIsNull() {
            addCriterion("designer_home_url is null");
            return (Criteria) this;
        }

        public Criteria andDesignerHomeUrlIsNotNull() {
            addCriterion("designer_home_url is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerHomeUrlEqualTo(String value) {
            addCriterion("designer_home_url =", value, "designerHomeUrl");
            return (Criteria) this;
        }

        public Criteria andDesignerHomeUrlNotEqualTo(String value) {
            addCriterion("designer_home_url <>", value, "designerHomeUrl");
            return (Criteria) this;
        }

        public Criteria andDesignerHomeUrlGreaterThan(String value) {
            addCriterion("designer_home_url >", value, "designerHomeUrl");
            return (Criteria) this;
        }

        public Criteria andDesignerHomeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("designer_home_url >=", value, "designerHomeUrl");
            return (Criteria) this;
        }

        public Criteria andDesignerHomeUrlLessThan(String value) {
            addCriterion("designer_home_url <", value, "designerHomeUrl");
            return (Criteria) this;
        }

        public Criteria andDesignerHomeUrlLessThanOrEqualTo(String value) {
            addCriterion("designer_home_url <=", value, "designerHomeUrl");
            return (Criteria) this;
        }

        public Criteria andDesignerHomeUrlLike(String value) {
            addCriterion("designer_home_url like", value, "designerHomeUrl");
            return (Criteria) this;
        }

        public Criteria andDesignerHomeUrlNotLike(String value) {
            addCriterion("designer_home_url not like", value, "designerHomeUrl");
            return (Criteria) this;
        }

        public Criteria andDesignerHomeUrlIn(List<String> values) {
            addCriterion("designer_home_url in", values, "designerHomeUrl");
            return (Criteria) this;
        }

        public Criteria andDesignerHomeUrlNotIn(List<String> values) {
            addCriterion("designer_home_url not in", values, "designerHomeUrl");
            return (Criteria) this;
        }

        public Criteria andDesignerHomeUrlBetween(String value1, String value2) {
            addCriterion("designer_home_url between", value1, value2, "designerHomeUrl");
            return (Criteria) this;
        }

        public Criteria andDesignerHomeUrlNotBetween(String value1, String value2) {
            addCriterion("designer_home_url not between", value1, value2, "designerHomeUrl");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoIsNull() {
            addCriterion("designer_photo is null");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoIsNotNull() {
            addCriterion("designer_photo is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoEqualTo(String value) {
            addCriterion("designer_photo =", value, "designerPhoto");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoNotEqualTo(String value) {
            addCriterion("designer_photo <>", value, "designerPhoto");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoGreaterThan(String value) {
            addCriterion("designer_photo >", value, "designerPhoto");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("designer_photo >=", value, "designerPhoto");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoLessThan(String value) {
            addCriterion("designer_photo <", value, "designerPhoto");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoLessThanOrEqualTo(String value) {
            addCriterion("designer_photo <=", value, "designerPhoto");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoLike(String value) {
            addCriterion("designer_photo like", value, "designerPhoto");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoNotLike(String value) {
            addCriterion("designer_photo not like", value, "designerPhoto");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoIn(List<String> values) {
            addCriterion("designer_photo in", values, "designerPhoto");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoNotIn(List<String> values) {
            addCriterion("designer_photo not in", values, "designerPhoto");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoBetween(String value1, String value2) {
            addCriterion("designer_photo between", value1, value2, "designerPhoto");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoNotBetween(String value1, String value2) {
            addCriterion("designer_photo not between", value1, value2, "designerPhoto");
            return (Criteria) this;
        }

        public Criteria andDesignerVideoIsNull() {
            addCriterion("designer_video is null");
            return (Criteria) this;
        }

        public Criteria andDesignerVideoIsNotNull() {
            addCriterion("designer_video is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerVideoEqualTo(String value) {
            addCriterion("designer_video =", value, "designerVideo");
            return (Criteria) this;
        }

        public Criteria andDesignerVideoNotEqualTo(String value) {
            addCriterion("designer_video <>", value, "designerVideo");
            return (Criteria) this;
        }

        public Criteria andDesignerVideoGreaterThan(String value) {
            addCriterion("designer_video >", value, "designerVideo");
            return (Criteria) this;
        }

        public Criteria andDesignerVideoGreaterThanOrEqualTo(String value) {
            addCriterion("designer_video >=", value, "designerVideo");
            return (Criteria) this;
        }

        public Criteria andDesignerVideoLessThan(String value) {
            addCriterion("designer_video <", value, "designerVideo");
            return (Criteria) this;
        }

        public Criteria andDesignerVideoLessThanOrEqualTo(String value) {
            addCriterion("designer_video <=", value, "designerVideo");
            return (Criteria) this;
        }

        public Criteria andDesignerVideoLike(String value) {
            addCriterion("designer_video like", value, "designerVideo");
            return (Criteria) this;
        }

        public Criteria andDesignerVideoNotLike(String value) {
            addCriterion("designer_video not like", value, "designerVideo");
            return (Criteria) this;
        }

        public Criteria andDesignerVideoIn(List<String> values) {
            addCriterion("designer_video in", values, "designerVideo");
            return (Criteria) this;
        }

        public Criteria andDesignerVideoNotIn(List<String> values) {
            addCriterion("designer_video not in", values, "designerVideo");
            return (Criteria) this;
        }

        public Criteria andDesignerVideoBetween(String value1, String value2) {
            addCriterion("designer_video between", value1, value2, "designerVideo");
            return (Criteria) this;
        }

        public Criteria andDesignerVideoNotBetween(String value1, String value2) {
            addCriterion("designer_video not between", value1, value2, "designerVideo");
            return (Criteria) this;
        }

        public Criteria andDesignerDescIsNull() {
            addCriterion("designer_desc is null");
            return (Criteria) this;
        }

        public Criteria andDesignerDescIsNotNull() {
            addCriterion("designer_desc is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerDescEqualTo(String value) {
            addCriterion("designer_desc =", value, "designerDesc");
            return (Criteria) this;
        }

        public Criteria andDesignerDescNotEqualTo(String value) {
            addCriterion("designer_desc <>", value, "designerDesc");
            return (Criteria) this;
        }

        public Criteria andDesignerDescGreaterThan(String value) {
            addCriterion("designer_desc >", value, "designerDesc");
            return (Criteria) this;
        }

        public Criteria andDesignerDescGreaterThanOrEqualTo(String value) {
            addCriterion("designer_desc >=", value, "designerDesc");
            return (Criteria) this;
        }

        public Criteria andDesignerDescLessThan(String value) {
            addCriterion("designer_desc <", value, "designerDesc");
            return (Criteria) this;
        }

        public Criteria andDesignerDescLessThanOrEqualTo(String value) {
            addCriterion("designer_desc <=", value, "designerDesc");
            return (Criteria) this;
        }

        public Criteria andDesignerDescLike(String value) {
            addCriterion("designer_desc like", value, "designerDesc");
            return (Criteria) this;
        }

        public Criteria andDesignerDescNotLike(String value) {
            addCriterion("designer_desc not like", value, "designerDesc");
            return (Criteria) this;
        }

        public Criteria andDesignerDescIn(List<String> values) {
            addCriterion("designer_desc in", values, "designerDesc");
            return (Criteria) this;
        }

        public Criteria andDesignerDescNotIn(List<String> values) {
            addCriterion("designer_desc not in", values, "designerDesc");
            return (Criteria) this;
        }

        public Criteria andDesignerDescBetween(String value1, String value2) {
            addCriterion("designer_desc between", value1, value2, "designerDesc");
            return (Criteria) this;
        }

        public Criteria andDesignerDescNotBetween(String value1, String value2) {
            addCriterion("designer_desc not between", value1, value2, "designerDesc");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleIsNull() {
            addCriterion("designer_style is null");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleIsNotNull() {
            addCriterion("designer_style is not null");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleEqualTo(String value) {
            addCriterion("designer_style =", value, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleNotEqualTo(String value) {
            addCriterion("designer_style <>", value, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleGreaterThan(String value) {
            addCriterion("designer_style >", value, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleGreaterThanOrEqualTo(String value) {
            addCriterion("designer_style >=", value, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleLessThan(String value) {
            addCriterion("designer_style <", value, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleLessThanOrEqualTo(String value) {
            addCriterion("designer_style <=", value, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleLike(String value) {
            addCriterion("designer_style like", value, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleNotLike(String value) {
            addCriterion("designer_style not like", value, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleIn(List<String> values) {
            addCriterion("designer_style in", values, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleNotIn(List<String> values) {
            addCriterion("designer_style not in", values, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleBetween(String value1, String value2) {
            addCriterion("designer_style between", value1, value2, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleNotBetween(String value1, String value2) {
            addCriterion("designer_style not between", value1, value2, "designerStyle");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNull() {
            addCriterion("is_active is null");
            return (Criteria) this;
        }

        public Criteria andIsActiveIsNotNull() {
            addCriterion("is_active is not null");
            return (Criteria) this;
        }

        public Criteria andIsActiveEqualTo(Boolean value) {
            addCriterion("is_active =", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotEqualTo(Boolean value) {
            addCriterion("is_active <>", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThan(Boolean value) {
            addCriterion("is_active >", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_active >=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThan(Boolean value) {
            addCriterion("is_active <", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveLessThanOrEqualTo(Boolean value) {
            addCriterion("is_active <=", value, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveIn(List<Boolean> values) {
            addCriterion("is_active in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotIn(List<Boolean> values) {
            addCriterion("is_active not in", values, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveBetween(Boolean value1, Boolean value2) {
            addCriterion("is_active between", value1, value2, "isActive");
            return (Criteria) this;
        }

        public Criteria andIsActiveNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_active not between", value1, value2, "isActive");
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

        public Criteria andDesignerNameLikeInsensitive(String value) {
            addCriterion("upper(designer_name) like", value.toUpperCase(), "designerName");
            return (Criteria) this;
        }

        public Criteria andDesignerCountryLikeInsensitive(String value) {
            addCriterion("upper(designer_country) like", value.toUpperCase(), "designerCountry");
            return (Criteria) this;
        }

        public Criteria andDesignerHomeUrlLikeInsensitive(String value) {
            addCriterion("upper(designer_home_url) like", value.toUpperCase(), "designerHomeUrl");
            return (Criteria) this;
        }

        public Criteria andDesignerPhotoLikeInsensitive(String value) {
            addCriterion("upper(designer_photo) like", value.toUpperCase(), "designerPhoto");
            return (Criteria) this;
        }

        public Criteria andDesignerVideoLikeInsensitive(String value) {
            addCriterion("upper(designer_video) like", value.toUpperCase(), "designerVideo");
            return (Criteria) this;
        }

        public Criteria andDesignerDescLikeInsensitive(String value) {
            addCriterion("upper(designer_desc) like", value.toUpperCase(), "designerDesc");
            return (Criteria) this;
        }

        public Criteria andDesignerStyleLikeInsensitive(String value) {
            addCriterion("upper(designer_style) like", value.toUpperCase(), "designerStyle");
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