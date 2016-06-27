package com.wow.product.model;

import java.util.ArrayList;
import java.util.List;

public class BrandExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BrandExample() {
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

        public Criteria andBrandCnameIsNull() {
            addCriterion("brand_cname is null");
            return (Criteria) this;
        }

        public Criteria andBrandCnameIsNotNull() {
            addCriterion("brand_cname is not null");
            return (Criteria) this;
        }

        public Criteria andBrandCnameEqualTo(String value) {
            addCriterion("brand_cname =", value, "brandCname");
            return (Criteria) this;
        }

        public Criteria andBrandCnameNotEqualTo(String value) {
            addCriterion("brand_cname <>", value, "brandCname");
            return (Criteria) this;
        }

        public Criteria andBrandCnameGreaterThan(String value) {
            addCriterion("brand_cname >", value, "brandCname");
            return (Criteria) this;
        }

        public Criteria andBrandCnameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_cname >=", value, "brandCname");
            return (Criteria) this;
        }

        public Criteria andBrandCnameLessThan(String value) {
            addCriterion("brand_cname <", value, "brandCname");
            return (Criteria) this;
        }

        public Criteria andBrandCnameLessThanOrEqualTo(String value) {
            addCriterion("brand_cname <=", value, "brandCname");
            return (Criteria) this;
        }

        public Criteria andBrandCnameLike(String value) {
            addCriterion("brand_cname like", value, "brandCname");
            return (Criteria) this;
        }

        public Criteria andBrandCnameNotLike(String value) {
            addCriterion("brand_cname not like", value, "brandCname");
            return (Criteria) this;
        }

        public Criteria andBrandCnameIn(List<String> values) {
            addCriterion("brand_cname in", values, "brandCname");
            return (Criteria) this;
        }

        public Criteria andBrandCnameNotIn(List<String> values) {
            addCriterion("brand_cname not in", values, "brandCname");
            return (Criteria) this;
        }

        public Criteria andBrandCnameBetween(String value1, String value2) {
            addCriterion("brand_cname between", value1, value2, "brandCname");
            return (Criteria) this;
        }

        public Criteria andBrandCnameNotBetween(String value1, String value2) {
            addCriterion("brand_cname not between", value1, value2, "brandCname");
            return (Criteria) this;
        }

        public Criteria andBrandEnameIsNull() {
            addCriterion("brand_ename is null");
            return (Criteria) this;
        }

        public Criteria andBrandEnameIsNotNull() {
            addCriterion("brand_ename is not null");
            return (Criteria) this;
        }

        public Criteria andBrandEnameEqualTo(String value) {
            addCriterion("brand_ename =", value, "brandEname");
            return (Criteria) this;
        }

        public Criteria andBrandEnameNotEqualTo(String value) {
            addCriterion("brand_ename <>", value, "brandEname");
            return (Criteria) this;
        }

        public Criteria andBrandEnameGreaterThan(String value) {
            addCriterion("brand_ename >", value, "brandEname");
            return (Criteria) this;
        }

        public Criteria andBrandEnameGreaterThanOrEqualTo(String value) {
            addCriterion("brand_ename >=", value, "brandEname");
            return (Criteria) this;
        }

        public Criteria andBrandEnameLessThan(String value) {
            addCriterion("brand_ename <", value, "brandEname");
            return (Criteria) this;
        }

        public Criteria andBrandEnameLessThanOrEqualTo(String value) {
            addCriterion("brand_ename <=", value, "brandEname");
            return (Criteria) this;
        }

        public Criteria andBrandEnameLike(String value) {
            addCriterion("brand_ename like", value, "brandEname");
            return (Criteria) this;
        }

        public Criteria andBrandEnameNotLike(String value) {
            addCriterion("brand_ename not like", value, "brandEname");
            return (Criteria) this;
        }

        public Criteria andBrandEnameIn(List<String> values) {
            addCriterion("brand_ename in", values, "brandEname");
            return (Criteria) this;
        }

        public Criteria andBrandEnameNotIn(List<String> values) {
            addCriterion("brand_ename not in", values, "brandEname");
            return (Criteria) this;
        }

        public Criteria andBrandEnameBetween(String value1, String value2) {
            addCriterion("brand_ename between", value1, value2, "brandEname");
            return (Criteria) this;
        }

        public Criteria andBrandEnameNotBetween(String value1, String value2) {
            addCriterion("brand_ename not between", value1, value2, "brandEname");
            return (Criteria) this;
        }

        public Criteria andBrandNameFirstLetterIsNull() {
            addCriterion("brand_name_first_letter is null");
            return (Criteria) this;
        }

        public Criteria andBrandNameFirstLetterIsNotNull() {
            addCriterion("brand_name_first_letter is not null");
            return (Criteria) this;
        }

        public Criteria andBrandNameFirstLetterEqualTo(String value) {
            addCriterion("brand_name_first_letter =", value, "brandNameFirstLetter");
            return (Criteria) this;
        }

        public Criteria andBrandNameFirstLetterNotEqualTo(String value) {
            addCriterion("brand_name_first_letter <>", value, "brandNameFirstLetter");
            return (Criteria) this;
        }

        public Criteria andBrandNameFirstLetterGreaterThan(String value) {
            addCriterion("brand_name_first_letter >", value, "brandNameFirstLetter");
            return (Criteria) this;
        }

        public Criteria andBrandNameFirstLetterGreaterThanOrEqualTo(String value) {
            addCriterion("brand_name_first_letter >=", value, "brandNameFirstLetter");
            return (Criteria) this;
        }

        public Criteria andBrandNameFirstLetterLessThan(String value) {
            addCriterion("brand_name_first_letter <", value, "brandNameFirstLetter");
            return (Criteria) this;
        }

        public Criteria andBrandNameFirstLetterLessThanOrEqualTo(String value) {
            addCriterion("brand_name_first_letter <=", value, "brandNameFirstLetter");
            return (Criteria) this;
        }

        public Criteria andBrandNameFirstLetterLike(String value) {
            addCriterion("brand_name_first_letter like", value, "brandNameFirstLetter");
            return (Criteria) this;
        }

        public Criteria andBrandNameFirstLetterNotLike(String value) {
            addCriterion("brand_name_first_letter not like", value, "brandNameFirstLetter");
            return (Criteria) this;
        }

        public Criteria andBrandNameFirstLetterIn(List<String> values) {
            addCriterion("brand_name_first_letter in", values, "brandNameFirstLetter");
            return (Criteria) this;
        }

        public Criteria andBrandNameFirstLetterNotIn(List<String> values) {
            addCriterion("brand_name_first_letter not in", values, "brandNameFirstLetter");
            return (Criteria) this;
        }

        public Criteria andBrandNameFirstLetterBetween(String value1, String value2) {
            addCriterion("brand_name_first_letter between", value1, value2, "brandNameFirstLetter");
            return (Criteria) this;
        }

        public Criteria andBrandNameFirstLetterNotBetween(String value1, String value2) {
            addCriterion("brand_name_first_letter not between", value1, value2, "brandNameFirstLetter");
            return (Criteria) this;
        }

        public Criteria andBrandCountryIsNull() {
            addCriterion("brand_country is null");
            return (Criteria) this;
        }

        public Criteria andBrandCountryIsNotNull() {
            addCriterion("brand_country is not null");
            return (Criteria) this;
        }

        public Criteria andBrandCountryEqualTo(String value) {
            addCriterion("brand_country =", value, "brandCountry");
            return (Criteria) this;
        }

        public Criteria andBrandCountryNotEqualTo(String value) {
            addCriterion("brand_country <>", value, "brandCountry");
            return (Criteria) this;
        }

        public Criteria andBrandCountryGreaterThan(String value) {
            addCriterion("brand_country >", value, "brandCountry");
            return (Criteria) this;
        }

        public Criteria andBrandCountryGreaterThanOrEqualTo(String value) {
            addCriterion("brand_country >=", value, "brandCountry");
            return (Criteria) this;
        }

        public Criteria andBrandCountryLessThan(String value) {
            addCriterion("brand_country <", value, "brandCountry");
            return (Criteria) this;
        }

        public Criteria andBrandCountryLessThanOrEqualTo(String value) {
            addCriterion("brand_country <=", value, "brandCountry");
            return (Criteria) this;
        }

        public Criteria andBrandCountryLike(String value) {
            addCriterion("brand_country like", value, "brandCountry");
            return (Criteria) this;
        }

        public Criteria andBrandCountryNotLike(String value) {
            addCriterion("brand_country not like", value, "brandCountry");
            return (Criteria) this;
        }

        public Criteria andBrandCountryIn(List<String> values) {
            addCriterion("brand_country in", values, "brandCountry");
            return (Criteria) this;
        }

        public Criteria andBrandCountryNotIn(List<String> values) {
            addCriterion("brand_country not in", values, "brandCountry");
            return (Criteria) this;
        }

        public Criteria andBrandCountryBetween(String value1, String value2) {
            addCriterion("brand_country between", value1, value2, "brandCountry");
            return (Criteria) this;
        }

        public Criteria andBrandCountryNotBetween(String value1, String value2) {
            addCriterion("brand_country not between", value1, value2, "brandCountry");
            return (Criteria) this;
        }

        public Criteria andBrandHomeUrlIsNull() {
            addCriterion("brand_home_url is null");
            return (Criteria) this;
        }

        public Criteria andBrandHomeUrlIsNotNull() {
            addCriterion("brand_home_url is not null");
            return (Criteria) this;
        }

        public Criteria andBrandHomeUrlEqualTo(String value) {
            addCriterion("brand_home_url =", value, "brandHomeUrl");
            return (Criteria) this;
        }

        public Criteria andBrandHomeUrlNotEqualTo(String value) {
            addCriterion("brand_home_url <>", value, "brandHomeUrl");
            return (Criteria) this;
        }

        public Criteria andBrandHomeUrlGreaterThan(String value) {
            addCriterion("brand_home_url >", value, "brandHomeUrl");
            return (Criteria) this;
        }

        public Criteria andBrandHomeUrlGreaterThanOrEqualTo(String value) {
            addCriterion("brand_home_url >=", value, "brandHomeUrl");
            return (Criteria) this;
        }

        public Criteria andBrandHomeUrlLessThan(String value) {
            addCriterion("brand_home_url <", value, "brandHomeUrl");
            return (Criteria) this;
        }

        public Criteria andBrandHomeUrlLessThanOrEqualTo(String value) {
            addCriterion("brand_home_url <=", value, "brandHomeUrl");
            return (Criteria) this;
        }

        public Criteria andBrandHomeUrlLike(String value) {
            addCriterion("brand_home_url like", value, "brandHomeUrl");
            return (Criteria) this;
        }

        public Criteria andBrandHomeUrlNotLike(String value) {
            addCriterion("brand_home_url not like", value, "brandHomeUrl");
            return (Criteria) this;
        }

        public Criteria andBrandHomeUrlIn(List<String> values) {
            addCriterion("brand_home_url in", values, "brandHomeUrl");
            return (Criteria) this;
        }

        public Criteria andBrandHomeUrlNotIn(List<String> values) {
            addCriterion("brand_home_url not in", values, "brandHomeUrl");
            return (Criteria) this;
        }

        public Criteria andBrandHomeUrlBetween(String value1, String value2) {
            addCriterion("brand_home_url between", value1, value2, "brandHomeUrl");
            return (Criteria) this;
        }

        public Criteria andBrandHomeUrlNotBetween(String value1, String value2) {
            addCriterion("brand_home_url not between", value1, value2, "brandHomeUrl");
            return (Criteria) this;
        }

        public Criteria andBrandLogoImgIsNull() {
            addCriterion("brand_logo_img is null");
            return (Criteria) this;
        }

        public Criteria andBrandLogoImgIsNotNull() {
            addCriterion("brand_logo_img is not null");
            return (Criteria) this;
        }

        public Criteria andBrandLogoImgEqualTo(String value) {
            addCriterion("brand_logo_img =", value, "brandLogoImg");
            return (Criteria) this;
        }

        public Criteria andBrandLogoImgNotEqualTo(String value) {
            addCriterion("brand_logo_img <>", value, "brandLogoImg");
            return (Criteria) this;
        }

        public Criteria andBrandLogoImgGreaterThan(String value) {
            addCriterion("brand_logo_img >", value, "brandLogoImg");
            return (Criteria) this;
        }

        public Criteria andBrandLogoImgGreaterThanOrEqualTo(String value) {
            addCriterion("brand_logo_img >=", value, "brandLogoImg");
            return (Criteria) this;
        }

        public Criteria andBrandLogoImgLessThan(String value) {
            addCriterion("brand_logo_img <", value, "brandLogoImg");
            return (Criteria) this;
        }

        public Criteria andBrandLogoImgLessThanOrEqualTo(String value) {
            addCriterion("brand_logo_img <=", value, "brandLogoImg");
            return (Criteria) this;
        }

        public Criteria andBrandLogoImgLike(String value) {
            addCriterion("brand_logo_img like", value, "brandLogoImg");
            return (Criteria) this;
        }

        public Criteria andBrandLogoImgNotLike(String value) {
            addCriterion("brand_logo_img not like", value, "brandLogoImg");
            return (Criteria) this;
        }

        public Criteria andBrandLogoImgIn(List<String> values) {
            addCriterion("brand_logo_img in", values, "brandLogoImg");
            return (Criteria) this;
        }

        public Criteria andBrandLogoImgNotIn(List<String> values) {
            addCriterion("brand_logo_img not in", values, "brandLogoImg");
            return (Criteria) this;
        }

        public Criteria andBrandLogoImgBetween(String value1, String value2) {
            addCriterion("brand_logo_img between", value1, value2, "brandLogoImg");
            return (Criteria) this;
        }

        public Criteria andBrandLogoImgNotBetween(String value1, String value2) {
            addCriterion("brand_logo_img not between", value1, value2, "brandLogoImg");
            return (Criteria) this;
        }

        public Criteria andBrandVideoIsNull() {
            addCriterion("brand_video is null");
            return (Criteria) this;
        }

        public Criteria andBrandVideoIsNotNull() {
            addCriterion("brand_video is not null");
            return (Criteria) this;
        }

        public Criteria andBrandVideoEqualTo(String value) {
            addCriterion("brand_video =", value, "brandVideo");
            return (Criteria) this;
        }

        public Criteria andBrandVideoNotEqualTo(String value) {
            addCriterion("brand_video <>", value, "brandVideo");
            return (Criteria) this;
        }

        public Criteria andBrandVideoGreaterThan(String value) {
            addCriterion("brand_video >", value, "brandVideo");
            return (Criteria) this;
        }

        public Criteria andBrandVideoGreaterThanOrEqualTo(String value) {
            addCriterion("brand_video >=", value, "brandVideo");
            return (Criteria) this;
        }

        public Criteria andBrandVideoLessThan(String value) {
            addCriterion("brand_video <", value, "brandVideo");
            return (Criteria) this;
        }

        public Criteria andBrandVideoLessThanOrEqualTo(String value) {
            addCriterion("brand_video <=", value, "brandVideo");
            return (Criteria) this;
        }

        public Criteria andBrandVideoLike(String value) {
            addCriterion("brand_video like", value, "brandVideo");
            return (Criteria) this;
        }

        public Criteria andBrandVideoNotLike(String value) {
            addCriterion("brand_video not like", value, "brandVideo");
            return (Criteria) this;
        }

        public Criteria andBrandVideoIn(List<String> values) {
            addCriterion("brand_video in", values, "brandVideo");
            return (Criteria) this;
        }

        public Criteria andBrandVideoNotIn(List<String> values) {
            addCriterion("brand_video not in", values, "brandVideo");
            return (Criteria) this;
        }

        public Criteria andBrandVideoBetween(String value1, String value2) {
            addCriterion("brand_video between", value1, value2, "brandVideo");
            return (Criteria) this;
        }

        public Criteria andBrandVideoNotBetween(String value1, String value2) {
            addCriterion("brand_video not between", value1, value2, "brandVideo");
            return (Criteria) this;
        }

        public Criteria andBrandImgIsNull() {
            addCriterion("brand_img is null");
            return (Criteria) this;
        }

        public Criteria andBrandImgIsNotNull() {
            addCriterion("brand_img is not null");
            return (Criteria) this;
        }

        public Criteria andBrandImgEqualTo(String value) {
            addCriterion("brand_img =", value, "brandImg");
            return (Criteria) this;
        }

        public Criteria andBrandImgNotEqualTo(String value) {
            addCriterion("brand_img <>", value, "brandImg");
            return (Criteria) this;
        }

        public Criteria andBrandImgGreaterThan(String value) {
            addCriterion("brand_img >", value, "brandImg");
            return (Criteria) this;
        }

        public Criteria andBrandImgGreaterThanOrEqualTo(String value) {
            addCriterion("brand_img >=", value, "brandImg");
            return (Criteria) this;
        }

        public Criteria andBrandImgLessThan(String value) {
            addCriterion("brand_img <", value, "brandImg");
            return (Criteria) this;
        }

        public Criteria andBrandImgLessThanOrEqualTo(String value) {
            addCriterion("brand_img <=", value, "brandImg");
            return (Criteria) this;
        }

        public Criteria andBrandImgLike(String value) {
            addCriterion("brand_img like", value, "brandImg");
            return (Criteria) this;
        }

        public Criteria andBrandImgNotLike(String value) {
            addCriterion("brand_img not like", value, "brandImg");
            return (Criteria) this;
        }

        public Criteria andBrandImgIn(List<String> values) {
            addCriterion("brand_img in", values, "brandImg");
            return (Criteria) this;
        }

        public Criteria andBrandImgNotIn(List<String> values) {
            addCriterion("brand_img not in", values, "brandImg");
            return (Criteria) this;
        }

        public Criteria andBrandImgBetween(String value1, String value2) {
            addCriterion("brand_img between", value1, value2, "brandImg");
            return (Criteria) this;
        }

        public Criteria andBrandImgNotBetween(String value1, String value2) {
            addCriterion("brand_img not between", value1, value2, "brandImg");
            return (Criteria) this;
        }

        public Criteria andBrandDescIsNull() {
            addCriterion("brand_desc is null");
            return (Criteria) this;
        }

        public Criteria andBrandDescIsNotNull() {
            addCriterion("brand_desc is not null");
            return (Criteria) this;
        }

        public Criteria andBrandDescEqualTo(String value) {
            addCriterion("brand_desc =", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescNotEqualTo(String value) {
            addCriterion("brand_desc <>", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescGreaterThan(String value) {
            addCriterion("brand_desc >", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescGreaterThanOrEqualTo(String value) {
            addCriterion("brand_desc >=", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescLessThan(String value) {
            addCriterion("brand_desc <", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescLessThanOrEqualTo(String value) {
            addCriterion("brand_desc <=", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescLike(String value) {
            addCriterion("brand_desc like", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescNotLike(String value) {
            addCriterion("brand_desc not like", value, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescIn(List<String> values) {
            addCriterion("brand_desc in", values, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescNotIn(List<String> values) {
            addCriterion("brand_desc not in", values, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescBetween(String value1, String value2) {
            addCriterion("brand_desc between", value1, value2, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandDescNotBetween(String value1, String value2) {
            addCriterion("brand_desc not between", value1, value2, "brandDesc");
            return (Criteria) this;
        }

        public Criteria andBrandCnameLikeInsensitive(String value) {
            addCriterion("upper(brand_cname) like", value.toUpperCase(), "brandCname");
            return (Criteria) this;
        }

        public Criteria andBrandEnameLikeInsensitive(String value) {
            addCriterion("upper(brand_ename) like", value.toUpperCase(), "brandEname");
            return (Criteria) this;
        }

        public Criteria andBrandNameFirstLetterLikeInsensitive(String value) {
            addCriterion("upper(brand_name_first_letter) like", value.toUpperCase(), "brandNameFirstLetter");
            return (Criteria) this;
        }

        public Criteria andBrandCountryLikeInsensitive(String value) {
            addCriterion("upper(brand_country) like", value.toUpperCase(), "brandCountry");
            return (Criteria) this;
        }

        public Criteria andBrandHomeUrlLikeInsensitive(String value) {
            addCriterion("upper(brand_home_url) like", value.toUpperCase(), "brandHomeUrl");
            return (Criteria) this;
        }

        public Criteria andBrandLogoImgLikeInsensitive(String value) {
            addCriterion("upper(brand_logo_img) like", value.toUpperCase(), "brandLogoImg");
            return (Criteria) this;
        }

        public Criteria andBrandVideoLikeInsensitive(String value) {
            addCriterion("upper(brand_video) like", value.toUpperCase(), "brandVideo");
            return (Criteria) this;
        }

        public Criteria andBrandImgLikeInsensitive(String value) {
            addCriterion("upper(brand_img) like", value.toUpperCase(), "brandImg");
            return (Criteria) this;
        }

        public Criteria andBrandDescLikeInsensitive(String value) {
            addCriterion("upper(brand_desc) like", value.toUpperCase(), "brandDesc");
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