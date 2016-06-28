package com.wow.product.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductExample() {
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

        public Criteria andProductNameIsNull() {
            addCriterion("product_name is null");
            return (Criteria) this;
        }

        public Criteria andProductNameIsNotNull() {
            addCriterion("product_name is not null");
            return (Criteria) this;
        }

        public Criteria andProductNameEqualTo(String value) {
            addCriterion("product_name =", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotEqualTo(String value) {
            addCriterion("product_name <>", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThan(String value) {
            addCriterion("product_name >", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameGreaterThanOrEqualTo(String value) {
            addCriterion("product_name >=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThan(String value) {
            addCriterion("product_name <", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLessThanOrEqualTo(String value) {
            addCriterion("product_name <=", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameLike(String value) {
            addCriterion("product_name like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotLike(String value) {
            addCriterion("product_name not like", value, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameIn(List<String> values) {
            addCriterion("product_name in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotIn(List<String> values) {
            addCriterion("product_name not in", values, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameBetween(String value1, String value2) {
            addCriterion("product_name between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductNameNotBetween(String value1, String value2) {
            addCriterion("product_name not between", value1, value2, "productName");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNull() {
            addCriterion("product_code is null");
            return (Criteria) this;
        }

        public Criteria andProductCodeIsNotNull() {
            addCriterion("product_code is not null");
            return (Criteria) this;
        }

        public Criteria andProductCodeEqualTo(String value) {
            addCriterion("product_code =", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotEqualTo(String value) {
            addCriterion("product_code <>", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThan(String value) {
            addCriterion("product_code >", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeGreaterThanOrEqualTo(String value) {
            addCriterion("product_code >=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThan(String value) {
            addCriterion("product_code <", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLessThanOrEqualTo(String value) {
            addCriterion("product_code <=", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeLike(String value) {
            addCriterion("product_code like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotLike(String value) {
            addCriterion("product_code not like", value, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeIn(List<String> values) {
            addCriterion("product_code in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotIn(List<String> values) {
            addCriterion("product_code not in", values, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeBetween(String value1, String value2) {
            addCriterion("product_code between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductCodeNotBetween(String value1, String value2) {
            addCriterion("product_code not between", value1, value2, "productCode");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNull() {
            addCriterion("product_type is null");
            return (Criteria) this;
        }

        public Criteria andProductTypeIsNotNull() {
            addCriterion("product_type is not null");
            return (Criteria) this;
        }

        public Criteria andProductTypeEqualTo(Byte value) {
            addCriterion("product_type =", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotEqualTo(Byte value) {
            addCriterion("product_type <>", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThan(Byte value) {
            addCriterion("product_type >", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("product_type >=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThan(Byte value) {
            addCriterion("product_type <", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeLessThanOrEqualTo(Byte value) {
            addCriterion("product_type <=", value, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeIn(List<Byte> values) {
            addCriterion("product_type in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotIn(List<Byte> values) {
            addCriterion("product_type not in", values, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeBetween(Byte value1, Byte value2) {
            addCriterion("product_type between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andProductTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("product_type not between", value1, value2, "productType");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNull() {
            addCriterion("category_id is null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIsNotNull() {
            addCriterion("category_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryIdEqualTo(String value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(String value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(String value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(String value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(String value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(String value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLike(String value) {
            addCriterion("category_id like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotLike(String value) {
            addCriterion("category_id not like", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<String> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<String> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(String value1, String value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(String value1, String value2) {
            addCriterion("category_id not between", value1, value2, "categoryId");
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

        public Criteria andProductModelIsNull() {
            addCriterion("product_model is null");
            return (Criteria) this;
        }

        public Criteria andProductModelIsNotNull() {
            addCriterion("product_model is not null");
            return (Criteria) this;
        }

        public Criteria andProductModelEqualTo(String value) {
            addCriterion("product_model =", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelNotEqualTo(String value) {
            addCriterion("product_model <>", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelGreaterThan(String value) {
            addCriterion("product_model >", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelGreaterThanOrEqualTo(String value) {
            addCriterion("product_model >=", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelLessThan(String value) {
            addCriterion("product_model <", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelLessThanOrEqualTo(String value) {
            addCriterion("product_model <=", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelLike(String value) {
            addCriterion("product_model like", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelNotLike(String value) {
            addCriterion("product_model not like", value, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelIn(List<String> values) {
            addCriterion("product_model in", values, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelNotIn(List<String> values) {
            addCriterion("product_model not in", values, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelBetween(String value1, String value2) {
            addCriterion("product_model between", value1, value2, "productModel");
            return (Criteria) this;
        }

        public Criteria andProductModelNotBetween(String value1, String value2) {
            addCriterion("product_model not between", value1, value2, "productModel");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNull() {
            addCriterion("material is null");
            return (Criteria) this;
        }

        public Criteria andMaterialIsNotNull() {
            addCriterion("material is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialEqualTo(String value) {
            addCriterion("material =", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotEqualTo(String value) {
            addCriterion("material <>", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThan(String value) {
            addCriterion("material >", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialGreaterThanOrEqualTo(String value) {
            addCriterion("material >=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThan(String value) {
            addCriterion("material <", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLessThanOrEqualTo(String value) {
            addCriterion("material <=", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialLike(String value) {
            addCriterion("material like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotLike(String value) {
            addCriterion("material not like", value, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialIn(List<String> values) {
            addCriterion("material in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotIn(List<String> values) {
            addCriterion("material not in", values, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialBetween(String value1, String value2) {
            addCriterion("material between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andMaterialNotBetween(String value1, String value2) {
            addCriterion("material not between", value1, value2, "material");
            return (Criteria) this;
        }

        public Criteria andSellingPointIsNull() {
            addCriterion("selling_point is null");
            return (Criteria) this;
        }

        public Criteria andSellingPointIsNotNull() {
            addCriterion("selling_point is not null");
            return (Criteria) this;
        }

        public Criteria andSellingPointEqualTo(String value) {
            addCriterion("selling_point =", value, "sellingPoint");
            return (Criteria) this;
        }

        public Criteria andSellingPointNotEqualTo(String value) {
            addCriterion("selling_point <>", value, "sellingPoint");
            return (Criteria) this;
        }

        public Criteria andSellingPointGreaterThan(String value) {
            addCriterion("selling_point >", value, "sellingPoint");
            return (Criteria) this;
        }

        public Criteria andSellingPointGreaterThanOrEqualTo(String value) {
            addCriterion("selling_point >=", value, "sellingPoint");
            return (Criteria) this;
        }

        public Criteria andSellingPointLessThan(String value) {
            addCriterion("selling_point <", value, "sellingPoint");
            return (Criteria) this;
        }

        public Criteria andSellingPointLessThanOrEqualTo(String value) {
            addCriterion("selling_point <=", value, "sellingPoint");
            return (Criteria) this;
        }

        public Criteria andSellingPointLike(String value) {
            addCriterion("selling_point like", value, "sellingPoint");
            return (Criteria) this;
        }

        public Criteria andSellingPointNotLike(String value) {
            addCriterion("selling_point not like", value, "sellingPoint");
            return (Criteria) this;
        }

        public Criteria andSellingPointIn(List<String> values) {
            addCriterion("selling_point in", values, "sellingPoint");
            return (Criteria) this;
        }

        public Criteria andSellingPointNotIn(List<String> values) {
            addCriterion("selling_point not in", values, "sellingPoint");
            return (Criteria) this;
        }

        public Criteria andSellingPointBetween(String value1, String value2) {
            addCriterion("selling_point between", value1, value2, "sellingPoint");
            return (Criteria) this;
        }

        public Criteria andSellingPointNotBetween(String value1, String value2) {
            addCriterion("selling_point not between", value1, value2, "sellingPoint");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionIsNull() {
            addCriterion("detail_description is null");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionIsNotNull() {
            addCriterion("detail_description is not null");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionEqualTo(String value) {
            addCriterion("detail_description =", value, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionNotEqualTo(String value) {
            addCriterion("detail_description <>", value, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionGreaterThan(String value) {
            addCriterion("detail_description >", value, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("detail_description >=", value, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionLessThan(String value) {
            addCriterion("detail_description <", value, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionLessThanOrEqualTo(String value) {
            addCriterion("detail_description <=", value, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionLike(String value) {
            addCriterion("detail_description like", value, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionNotLike(String value) {
            addCriterion("detail_description not like", value, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionIn(List<String> values) {
            addCriterion("detail_description in", values, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionNotIn(List<String> values) {
            addCriterion("detail_description not in", values, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionBetween(String value1, String value2) {
            addCriterion("detail_description between", value1, value2, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionNotBetween(String value1, String value2) {
            addCriterion("detail_description not between", value1, value2, "detailDescription");
            return (Criteria) this;
        }

        public Criteria andCanSaleIsNull() {
            addCriterion("can_sale is null");
            return (Criteria) this;
        }

        public Criteria andCanSaleIsNotNull() {
            addCriterion("can_sale is not null");
            return (Criteria) this;
        }

        public Criteria andCanSaleEqualTo(Boolean value) {
            addCriterion("can_sale =", value, "canSale");
            return (Criteria) this;
        }

        public Criteria andCanSaleNotEqualTo(Boolean value) {
            addCriterion("can_sale <>", value, "canSale");
            return (Criteria) this;
        }

        public Criteria andCanSaleGreaterThan(Boolean value) {
            addCriterion("can_sale >", value, "canSale");
            return (Criteria) this;
        }

        public Criteria andCanSaleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("can_sale >=", value, "canSale");
            return (Criteria) this;
        }

        public Criteria andCanSaleLessThan(Boolean value) {
            addCriterion("can_sale <", value, "canSale");
            return (Criteria) this;
        }

        public Criteria andCanSaleLessThanOrEqualTo(Boolean value) {
            addCriterion("can_sale <=", value, "canSale");
            return (Criteria) this;
        }

        public Criteria andCanSaleIn(List<Boolean> values) {
            addCriterion("can_sale in", values, "canSale");
            return (Criteria) this;
        }

        public Criteria andCanSaleNotIn(List<Boolean> values) {
            addCriterion("can_sale not in", values, "canSale");
            return (Criteria) this;
        }

        public Criteria andCanSaleBetween(Boolean value1, Boolean value2) {
            addCriterion("can_sale between", value1, value2, "canSale");
            return (Criteria) this;
        }

        public Criteria andCanSaleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("can_sale not between", value1, value2, "canSale");
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

        public Criteria andViewPlatformIsNull() {
            addCriterion("view_platform is null");
            return (Criteria) this;
        }

        public Criteria andViewPlatformIsNotNull() {
            addCriterion("view_platform is not null");
            return (Criteria) this;
        }

        public Criteria andViewPlatformEqualTo(Byte value) {
            addCriterion("view_platform =", value, "viewPlatform");
            return (Criteria) this;
        }

        public Criteria andViewPlatformNotEqualTo(Byte value) {
            addCriterion("view_platform <>", value, "viewPlatform");
            return (Criteria) this;
        }

        public Criteria andViewPlatformGreaterThan(Byte value) {
            addCriterion("view_platform >", value, "viewPlatform");
            return (Criteria) this;
        }

        public Criteria andViewPlatformGreaterThanOrEqualTo(Byte value) {
            addCriterion("view_platform >=", value, "viewPlatform");
            return (Criteria) this;
        }

        public Criteria andViewPlatformLessThan(Byte value) {
            addCriterion("view_platform <", value, "viewPlatform");
            return (Criteria) this;
        }

        public Criteria andViewPlatformLessThanOrEqualTo(Byte value) {
            addCriterion("view_platform <=", value, "viewPlatform");
            return (Criteria) this;
        }

        public Criteria andViewPlatformIn(List<Byte> values) {
            addCriterion("view_platform in", values, "viewPlatform");
            return (Criteria) this;
        }

        public Criteria andViewPlatformNotIn(List<Byte> values) {
            addCriterion("view_platform not in", values, "viewPlatform");
            return (Criteria) this;
        }

        public Criteria andViewPlatformBetween(Byte value1, Byte value2) {
            addCriterion("view_platform between", value1, value2, "viewPlatform");
            return (Criteria) this;
        }

        public Criteria andViewPlatformNotBetween(Byte value1, Byte value2) {
            addCriterion("view_platform not between", value1, value2, "viewPlatform");
            return (Criteria) this;
        }

        public Criteria andOriginCountryIsNull() {
            addCriterion("origin_country is null");
            return (Criteria) this;
        }

        public Criteria andOriginCountryIsNotNull() {
            addCriterion("origin_country is not null");
            return (Criteria) this;
        }

        public Criteria andOriginCountryEqualTo(String value) {
            addCriterion("origin_country =", value, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryNotEqualTo(String value) {
            addCriterion("origin_country <>", value, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryGreaterThan(String value) {
            addCriterion("origin_country >", value, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryGreaterThanOrEqualTo(String value) {
            addCriterion("origin_country >=", value, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryLessThan(String value) {
            addCriterion("origin_country <", value, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryLessThanOrEqualTo(String value) {
            addCriterion("origin_country <=", value, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryLike(String value) {
            addCriterion("origin_country like", value, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryNotLike(String value) {
            addCriterion("origin_country not like", value, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryIn(List<String> values) {
            addCriterion("origin_country in", values, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryNotIn(List<String> values) {
            addCriterion("origin_country not in", values, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryBetween(String value1, String value2) {
            addCriterion("origin_country between", value1, value2, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginCountryNotBetween(String value1, String value2) {
            addCriterion("origin_country not between", value1, value2, "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginAreaIdIsNull() {
            addCriterion("origin_area_id is null");
            return (Criteria) this;
        }

        public Criteria andOriginAreaIdIsNotNull() {
            addCriterion("origin_area_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriginAreaIdEqualTo(Integer value) {
            addCriterion("origin_area_id =", value, "originAreaId");
            return (Criteria) this;
        }

        public Criteria andOriginAreaIdNotEqualTo(Integer value) {
            addCriterion("origin_area_id <>", value, "originAreaId");
            return (Criteria) this;
        }

        public Criteria andOriginAreaIdGreaterThan(Integer value) {
            addCriterion("origin_area_id >", value, "originAreaId");
            return (Criteria) this;
        }

        public Criteria andOriginAreaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("origin_area_id >=", value, "originAreaId");
            return (Criteria) this;
        }

        public Criteria andOriginAreaIdLessThan(Integer value) {
            addCriterion("origin_area_id <", value, "originAreaId");
            return (Criteria) this;
        }

        public Criteria andOriginAreaIdLessThanOrEqualTo(Integer value) {
            addCriterion("origin_area_id <=", value, "originAreaId");
            return (Criteria) this;
        }

        public Criteria andOriginAreaIdIn(List<Integer> values) {
            addCriterion("origin_area_id in", values, "originAreaId");
            return (Criteria) this;
        }

        public Criteria andOriginAreaIdNotIn(List<Integer> values) {
            addCriterion("origin_area_id not in", values, "originAreaId");
            return (Criteria) this;
        }

        public Criteria andOriginAreaIdBetween(Integer value1, Integer value2) {
            addCriterion("origin_area_id between", value1, value2, "originAreaId");
            return (Criteria) this;
        }

        public Criteria andOriginAreaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("origin_area_id not between", value1, value2, "originAreaId");
            return (Criteria) this;
        }

        public Criteria andOriginTextIsNull() {
            addCriterion("origin_text is null");
            return (Criteria) this;
        }

        public Criteria andOriginTextIsNotNull() {
            addCriterion("origin_text is not null");
            return (Criteria) this;
        }

        public Criteria andOriginTextEqualTo(String value) {
            addCriterion("origin_text =", value, "originText");
            return (Criteria) this;
        }

        public Criteria andOriginTextNotEqualTo(String value) {
            addCriterion("origin_text <>", value, "originText");
            return (Criteria) this;
        }

        public Criteria andOriginTextGreaterThan(String value) {
            addCriterion("origin_text >", value, "originText");
            return (Criteria) this;
        }

        public Criteria andOriginTextGreaterThanOrEqualTo(String value) {
            addCriterion("origin_text >=", value, "originText");
            return (Criteria) this;
        }

        public Criteria andOriginTextLessThan(String value) {
            addCriterion("origin_text <", value, "originText");
            return (Criteria) this;
        }

        public Criteria andOriginTextLessThanOrEqualTo(String value) {
            addCriterion("origin_text <=", value, "originText");
            return (Criteria) this;
        }

        public Criteria andOriginTextLike(String value) {
            addCriterion("origin_text like", value, "originText");
            return (Criteria) this;
        }

        public Criteria andOriginTextNotLike(String value) {
            addCriterion("origin_text not like", value, "originText");
            return (Criteria) this;
        }

        public Criteria andOriginTextIn(List<String> values) {
            addCriterion("origin_text in", values, "originText");
            return (Criteria) this;
        }

        public Criteria andOriginTextNotIn(List<String> values) {
            addCriterion("origin_text not in", values, "originText");
            return (Criteria) this;
        }

        public Criteria andOriginTextBetween(String value1, String value2) {
            addCriterion("origin_text between", value1, value2, "originText");
            return (Criteria) this;
        }

        public Criteria andOriginTextNotBetween(String value1, String value2) {
            addCriterion("origin_text not between", value1, value2, "originText");
            return (Criteria) this;
        }

        public Criteria andIsImportIsNull() {
            addCriterion("is_import is null");
            return (Criteria) this;
        }

        public Criteria andIsImportIsNotNull() {
            addCriterion("is_import is not null");
            return (Criteria) this;
        }

        public Criteria andIsImportEqualTo(Boolean value) {
            addCriterion("is_import =", value, "isImport");
            return (Criteria) this;
        }

        public Criteria andIsImportNotEqualTo(Boolean value) {
            addCriterion("is_import <>", value, "isImport");
            return (Criteria) this;
        }

        public Criteria andIsImportGreaterThan(Boolean value) {
            addCriterion("is_import >", value, "isImport");
            return (Criteria) this;
        }

        public Criteria andIsImportGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_import >=", value, "isImport");
            return (Criteria) this;
        }

        public Criteria andIsImportLessThan(Boolean value) {
            addCriterion("is_import <", value, "isImport");
            return (Criteria) this;
        }

        public Criteria andIsImportLessThanOrEqualTo(Boolean value) {
            addCriterion("is_import <=", value, "isImport");
            return (Criteria) this;
        }

        public Criteria andIsImportIn(List<Boolean> values) {
            addCriterion("is_import in", values, "isImport");
            return (Criteria) this;
        }

        public Criteria andIsImportNotIn(List<Boolean> values) {
            addCriterion("is_import not in", values, "isImport");
            return (Criteria) this;
        }

        public Criteria andIsImportBetween(Boolean value1, Boolean value2) {
            addCriterion("is_import between", value1, value2, "isImport");
            return (Criteria) this;
        }

        public Criteria andIsImportNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_import not between", value1, value2, "isImport");
            return (Criteria) this;
        }

        public Criteria andLengthIsNull() {
            addCriterion("length is null");
            return (Criteria) this;
        }

        public Criteria andLengthIsNotNull() {
            addCriterion("length is not null");
            return (Criteria) this;
        }

        public Criteria andLengthEqualTo(Short value) {
            addCriterion("length =", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotEqualTo(Short value) {
            addCriterion("length <>", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThan(Short value) {
            addCriterion("length >", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthGreaterThanOrEqualTo(Short value) {
            addCriterion("length >=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThan(Short value) {
            addCriterion("length <", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthLessThanOrEqualTo(Short value) {
            addCriterion("length <=", value, "length");
            return (Criteria) this;
        }

        public Criteria andLengthIn(List<Short> values) {
            addCriterion("length in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotIn(List<Short> values) {
            addCriterion("length not in", values, "length");
            return (Criteria) this;
        }

        public Criteria andLengthBetween(Short value1, Short value2) {
            addCriterion("length between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andLengthNotBetween(Short value1, Short value2) {
            addCriterion("length not between", value1, value2, "length");
            return (Criteria) this;
        }

        public Criteria andWidthIsNull() {
            addCriterion("width is null");
            return (Criteria) this;
        }

        public Criteria andWidthIsNotNull() {
            addCriterion("width is not null");
            return (Criteria) this;
        }

        public Criteria andWidthEqualTo(Short value) {
            addCriterion("width =", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotEqualTo(Short value) {
            addCriterion("width <>", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThan(Short value) {
            addCriterion("width >", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthGreaterThanOrEqualTo(Short value) {
            addCriterion("width >=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThan(Short value) {
            addCriterion("width <", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthLessThanOrEqualTo(Short value) {
            addCriterion("width <=", value, "width");
            return (Criteria) this;
        }

        public Criteria andWidthIn(List<Short> values) {
            addCriterion("width in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotIn(List<Short> values) {
            addCriterion("width not in", values, "width");
            return (Criteria) this;
        }

        public Criteria andWidthBetween(Short value1, Short value2) {
            addCriterion("width between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andWidthNotBetween(Short value1, Short value2) {
            addCriterion("width not between", value1, value2, "width");
            return (Criteria) this;
        }

        public Criteria andHeightIsNull() {
            addCriterion("height is null");
            return (Criteria) this;
        }

        public Criteria andHeightIsNotNull() {
            addCriterion("height is not null");
            return (Criteria) this;
        }

        public Criteria andHeightEqualTo(Short value) {
            addCriterion("height =", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotEqualTo(Short value) {
            addCriterion("height <>", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThan(Short value) {
            addCriterion("height >", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightGreaterThanOrEqualTo(Short value) {
            addCriterion("height >=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThan(Short value) {
            addCriterion("height <", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightLessThanOrEqualTo(Short value) {
            addCriterion("height <=", value, "height");
            return (Criteria) this;
        }

        public Criteria andHeightIn(List<Short> values) {
            addCriterion("height in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotIn(List<Short> values) {
            addCriterion("height not in", values, "height");
            return (Criteria) this;
        }

        public Criteria andHeightBetween(Short value1, Short value2) {
            addCriterion("height between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andHeightNotBetween(Short value1, Short value2) {
            addCriterion("height not between", value1, value2, "height");
            return (Criteria) this;
        }

        public Criteria andSizeTextIsNull() {
            addCriterion("size_text is null");
            return (Criteria) this;
        }

        public Criteria andSizeTextIsNotNull() {
            addCriterion("size_text is not null");
            return (Criteria) this;
        }

        public Criteria andSizeTextEqualTo(String value) {
            addCriterion("size_text =", value, "sizeText");
            return (Criteria) this;
        }

        public Criteria andSizeTextNotEqualTo(String value) {
            addCriterion("size_text <>", value, "sizeText");
            return (Criteria) this;
        }

        public Criteria andSizeTextGreaterThan(String value) {
            addCriterion("size_text >", value, "sizeText");
            return (Criteria) this;
        }

        public Criteria andSizeTextGreaterThanOrEqualTo(String value) {
            addCriterion("size_text >=", value, "sizeText");
            return (Criteria) this;
        }

        public Criteria andSizeTextLessThan(String value) {
            addCriterion("size_text <", value, "sizeText");
            return (Criteria) this;
        }

        public Criteria andSizeTextLessThanOrEqualTo(String value) {
            addCriterion("size_text <=", value, "sizeText");
            return (Criteria) this;
        }

        public Criteria andSizeTextLike(String value) {
            addCriterion("size_text like", value, "sizeText");
            return (Criteria) this;
        }

        public Criteria andSizeTextNotLike(String value) {
            addCriterion("size_text not like", value, "sizeText");
            return (Criteria) this;
        }

        public Criteria andSizeTextIn(List<String> values) {
            addCriterion("size_text in", values, "sizeText");
            return (Criteria) this;
        }

        public Criteria andSizeTextNotIn(List<String> values) {
            addCriterion("size_text not in", values, "sizeText");
            return (Criteria) this;
        }

        public Criteria andSizeTextBetween(String value1, String value2) {
            addCriterion("size_text between", value1, value2, "sizeText");
            return (Criteria) this;
        }

        public Criteria andSizeTextNotBetween(String value1, String value2) {
            addCriterion("size_text not between", value1, value2, "sizeText");
            return (Criteria) this;
        }

        public Criteria andWeightIsNull() {
            addCriterion("weight is null");
            return (Criteria) this;
        }

        public Criteria andWeightIsNotNull() {
            addCriterion("weight is not null");
            return (Criteria) this;
        }

        public Criteria andWeightEqualTo(BigDecimal value) {
            addCriterion("weight =", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotEqualTo(BigDecimal value) {
            addCriterion("weight <>", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThan(BigDecimal value) {
            addCriterion("weight >", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("weight >=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThan(BigDecimal value) {
            addCriterion("weight <", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightLessThanOrEqualTo(BigDecimal value) {
            addCriterion("weight <=", value, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightIn(List<BigDecimal> values) {
            addCriterion("weight in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotIn(List<BigDecimal> values) {
            addCriterion("weight not in", values, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("weight not between", value1, value2, "weight");
            return (Criteria) this;
        }

        public Criteria andWeightTextIsNull() {
            addCriterion("weight_text is null");
            return (Criteria) this;
        }

        public Criteria andWeightTextIsNotNull() {
            addCriterion("weight_text is not null");
            return (Criteria) this;
        }

        public Criteria andWeightTextEqualTo(String value) {
            addCriterion("weight_text =", value, "weightText");
            return (Criteria) this;
        }

        public Criteria andWeightTextNotEqualTo(String value) {
            addCriterion("weight_text <>", value, "weightText");
            return (Criteria) this;
        }

        public Criteria andWeightTextGreaterThan(String value) {
            addCriterion("weight_text >", value, "weightText");
            return (Criteria) this;
        }

        public Criteria andWeightTextGreaterThanOrEqualTo(String value) {
            addCriterion("weight_text >=", value, "weightText");
            return (Criteria) this;
        }

        public Criteria andWeightTextLessThan(String value) {
            addCriterion("weight_text <", value, "weightText");
            return (Criteria) this;
        }

        public Criteria andWeightTextLessThanOrEqualTo(String value) {
            addCriterion("weight_text <=", value, "weightText");
            return (Criteria) this;
        }

        public Criteria andWeightTextLike(String value) {
            addCriterion("weight_text like", value, "weightText");
            return (Criteria) this;
        }

        public Criteria andWeightTextNotLike(String value) {
            addCriterion("weight_text not like", value, "weightText");
            return (Criteria) this;
        }

        public Criteria andWeightTextIn(List<String> values) {
            addCriterion("weight_text in", values, "weightText");
            return (Criteria) this;
        }

        public Criteria andWeightTextNotIn(List<String> values) {
            addCriterion("weight_text not in", values, "weightText");
            return (Criteria) this;
        }

        public Criteria andWeightTextBetween(String value1, String value2) {
            addCriterion("weight_text between", value1, value2, "weightText");
            return (Criteria) this;
        }

        public Criteria andWeightTextNotBetween(String value1, String value2) {
            addCriterion("weight_text not between", value1, value2, "weightText");
            return (Criteria) this;
        }

        public Criteria andSpecIsNull() {
            addCriterion("spec is null");
            return (Criteria) this;
        }

        public Criteria andSpecIsNotNull() {
            addCriterion("spec is not null");
            return (Criteria) this;
        }

        public Criteria andSpecEqualTo(String value) {
            addCriterion("spec =", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotEqualTo(String value) {
            addCriterion("spec <>", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThan(String value) {
            addCriterion("spec >", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecGreaterThanOrEqualTo(String value) {
            addCriterion("spec >=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThan(String value) {
            addCriterion("spec <", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLessThanOrEqualTo(String value) {
            addCriterion("spec <=", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecLike(String value) {
            addCriterion("spec like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotLike(String value) {
            addCriterion("spec not like", value, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecIn(List<String> values) {
            addCriterion("spec in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotIn(List<String> values) {
            addCriterion("spec not in", values, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecBetween(String value1, String value2) {
            addCriterion("spec between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecNotBetween(String value1, String value2) {
            addCriterion("spec not between", value1, value2, "spec");
            return (Criteria) this;
        }

        public Criteria andSpecImgIsNull() {
            addCriterion("spec_img is null");
            return (Criteria) this;
        }

        public Criteria andSpecImgIsNotNull() {
            addCriterion("spec_img is not null");
            return (Criteria) this;
        }

        public Criteria andSpecImgEqualTo(String value) {
            addCriterion("spec_img =", value, "specImg");
            return (Criteria) this;
        }

        public Criteria andSpecImgNotEqualTo(String value) {
            addCriterion("spec_img <>", value, "specImg");
            return (Criteria) this;
        }

        public Criteria andSpecImgGreaterThan(String value) {
            addCriterion("spec_img >", value, "specImg");
            return (Criteria) this;
        }

        public Criteria andSpecImgGreaterThanOrEqualTo(String value) {
            addCriterion("spec_img >=", value, "specImg");
            return (Criteria) this;
        }

        public Criteria andSpecImgLessThan(String value) {
            addCriterion("spec_img <", value, "specImg");
            return (Criteria) this;
        }

        public Criteria andSpecImgLessThanOrEqualTo(String value) {
            addCriterion("spec_img <=", value, "specImg");
            return (Criteria) this;
        }

        public Criteria andSpecImgLike(String value) {
            addCriterion("spec_img like", value, "specImg");
            return (Criteria) this;
        }

        public Criteria andSpecImgNotLike(String value) {
            addCriterion("spec_img not like", value, "specImg");
            return (Criteria) this;
        }

        public Criteria andSpecImgIn(List<String> values) {
            addCriterion("spec_img in", values, "specImg");
            return (Criteria) this;
        }

        public Criteria andSpecImgNotIn(List<String> values) {
            addCriterion("spec_img not in", values, "specImg");
            return (Criteria) this;
        }

        public Criteria andSpecImgBetween(String value1, String value2) {
            addCriterion("spec_img between", value1, value2, "specImg");
            return (Criteria) this;
        }

        public Criteria andSpecImgNotBetween(String value1, String value2) {
            addCriterion("spec_img not between", value1, value2, "specImg");
            return (Criteria) this;
        }

        public Criteria andColorIsNull() {
            addCriterion("color is null");
            return (Criteria) this;
        }

        public Criteria andColorIsNotNull() {
            addCriterion("color is not null");
            return (Criteria) this;
        }

        public Criteria andColorEqualTo(String value) {
            addCriterion("color =", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotEqualTo(String value) {
            addCriterion("color <>", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThan(String value) {
            addCriterion("color >", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorGreaterThanOrEqualTo(String value) {
            addCriterion("color >=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThan(String value) {
            addCriterion("color <", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLessThanOrEqualTo(String value) {
            addCriterion("color <=", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorLike(String value) {
            addCriterion("color like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotLike(String value) {
            addCriterion("color not like", value, "color");
            return (Criteria) this;
        }

        public Criteria andColorIn(List<String> values) {
            addCriterion("color in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotIn(List<String> values) {
            addCriterion("color not in", values, "color");
            return (Criteria) this;
        }

        public Criteria andColorBetween(String value1, String value2) {
            addCriterion("color between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andColorNotBetween(String value1, String value2) {
            addCriterion("color not between", value1, value2, "color");
            return (Criteria) this;
        }

        public Criteria andStyleIsNull() {
            addCriterion("style is null");
            return (Criteria) this;
        }

        public Criteria andStyleIsNotNull() {
            addCriterion("style is not null");
            return (Criteria) this;
        }

        public Criteria andStyleEqualTo(String value) {
            addCriterion("style =", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotEqualTo(String value) {
            addCriterion("style <>", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleGreaterThan(String value) {
            addCriterion("style >", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleGreaterThanOrEqualTo(String value) {
            addCriterion("style >=", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleLessThan(String value) {
            addCriterion("style <", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleLessThanOrEqualTo(String value) {
            addCriterion("style <=", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleLike(String value) {
            addCriterion("style like", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotLike(String value) {
            addCriterion("style not like", value, "style");
            return (Criteria) this;
        }

        public Criteria andStyleIn(List<String> values) {
            addCriterion("style in", values, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotIn(List<String> values) {
            addCriterion("style not in", values, "style");
            return (Criteria) this;
        }

        public Criteria andStyleBetween(String value1, String value2) {
            addCriterion("style between", value1, value2, "style");
            return (Criteria) this;
        }

        public Criteria andStyleNotBetween(String value1, String value2) {
            addCriterion("style not between", value1, value2, "style");
            return (Criteria) this;
        }

        public Criteria andVerboseInfoIsNull() {
            addCriterion("verbose_info is null");
            return (Criteria) this;
        }

        public Criteria andVerboseInfoIsNotNull() {
            addCriterion("verbose_info is not null");
            return (Criteria) this;
        }

        public Criteria andVerboseInfoEqualTo(String value) {
            addCriterion("verbose_info =", value, "verboseInfo");
            return (Criteria) this;
        }

        public Criteria andVerboseInfoNotEqualTo(String value) {
            addCriterion("verbose_info <>", value, "verboseInfo");
            return (Criteria) this;
        }

        public Criteria andVerboseInfoGreaterThan(String value) {
            addCriterion("verbose_info >", value, "verboseInfo");
            return (Criteria) this;
        }

        public Criteria andVerboseInfoGreaterThanOrEqualTo(String value) {
            addCriterion("verbose_info >=", value, "verboseInfo");
            return (Criteria) this;
        }

        public Criteria andVerboseInfoLessThan(String value) {
            addCriterion("verbose_info <", value, "verboseInfo");
            return (Criteria) this;
        }

        public Criteria andVerboseInfoLessThanOrEqualTo(String value) {
            addCriterion("verbose_info <=", value, "verboseInfo");
            return (Criteria) this;
        }

        public Criteria andVerboseInfoLike(String value) {
            addCriterion("verbose_info like", value, "verboseInfo");
            return (Criteria) this;
        }

        public Criteria andVerboseInfoNotLike(String value) {
            addCriterion("verbose_info not like", value, "verboseInfo");
            return (Criteria) this;
        }

        public Criteria andVerboseInfoIn(List<String> values) {
            addCriterion("verbose_info in", values, "verboseInfo");
            return (Criteria) this;
        }

        public Criteria andVerboseInfoNotIn(List<String> values) {
            addCriterion("verbose_info not in", values, "verboseInfo");
            return (Criteria) this;
        }

        public Criteria andVerboseInfoBetween(String value1, String value2) {
            addCriterion("verbose_info between", value1, value2, "verboseInfo");
            return (Criteria) this;
        }

        public Criteria andVerboseInfoNotBetween(String value1, String value2) {
            addCriterion("verbose_info not between", value1, value2, "verboseInfo");
            return (Criteria) this;
        }

        public Criteria andTipsIsNull() {
            addCriterion("tips is null");
            return (Criteria) this;
        }

        public Criteria andTipsIsNotNull() {
            addCriterion("tips is not null");
            return (Criteria) this;
        }

        public Criteria andTipsEqualTo(String value) {
            addCriterion("tips =", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotEqualTo(String value) {
            addCriterion("tips <>", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsGreaterThan(String value) {
            addCriterion("tips >", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsGreaterThanOrEqualTo(String value) {
            addCriterion("tips >=", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsLessThan(String value) {
            addCriterion("tips <", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsLessThanOrEqualTo(String value) {
            addCriterion("tips <=", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsLike(String value) {
            addCriterion("tips like", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotLike(String value) {
            addCriterion("tips not like", value, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsIn(List<String> values) {
            addCriterion("tips in", values, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotIn(List<String> values) {
            addCriterion("tips not in", values, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsBetween(String value1, String value2) {
            addCriterion("tips between", value1, value2, "tips");
            return (Criteria) this;
        }

        public Criteria andTipsNotBetween(String value1, String value2) {
            addCriterion("tips not between", value1, value2, "tips");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneIsNull() {
            addCriterion("applicable_scene is null");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneIsNotNull() {
            addCriterion("applicable_scene is not null");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneEqualTo(String value) {
            addCriterion("applicable_scene =", value, "applicableScene");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneNotEqualTo(String value) {
            addCriterion("applicable_scene <>", value, "applicableScene");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneGreaterThan(String value) {
            addCriterion("applicable_scene >", value, "applicableScene");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneGreaterThanOrEqualTo(String value) {
            addCriterion("applicable_scene >=", value, "applicableScene");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneLessThan(String value) {
            addCriterion("applicable_scene <", value, "applicableScene");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneLessThanOrEqualTo(String value) {
            addCriterion("applicable_scene <=", value, "applicableScene");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneLike(String value) {
            addCriterion("applicable_scene like", value, "applicableScene");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneNotLike(String value) {
            addCriterion("applicable_scene not like", value, "applicableScene");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneIn(List<String> values) {
            addCriterion("applicable_scene in", values, "applicableScene");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneNotIn(List<String> values) {
            addCriterion("applicable_scene not in", values, "applicableScene");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneBetween(String value1, String value2) {
            addCriterion("applicable_scene between", value1, value2, "applicableScene");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneNotBetween(String value1, String value2) {
            addCriterion("applicable_scene not between", value1, value2, "applicableScene");
            return (Criteria) this;
        }

        public Criteria andPostSaleServiceDescIsNull() {
            addCriterion("post_sale_service_desc is null");
            return (Criteria) this;
        }

        public Criteria andPostSaleServiceDescIsNotNull() {
            addCriterion("post_sale_service_desc is not null");
            return (Criteria) this;
        }

        public Criteria andPostSaleServiceDescEqualTo(String value) {
            addCriterion("post_sale_service_desc =", value, "postSaleServiceDesc");
            return (Criteria) this;
        }

        public Criteria andPostSaleServiceDescNotEqualTo(String value) {
            addCriterion("post_sale_service_desc <>", value, "postSaleServiceDesc");
            return (Criteria) this;
        }

        public Criteria andPostSaleServiceDescGreaterThan(String value) {
            addCriterion("post_sale_service_desc >", value, "postSaleServiceDesc");
            return (Criteria) this;
        }

        public Criteria andPostSaleServiceDescGreaterThanOrEqualTo(String value) {
            addCriterion("post_sale_service_desc >=", value, "postSaleServiceDesc");
            return (Criteria) this;
        }

        public Criteria andPostSaleServiceDescLessThan(String value) {
            addCriterion("post_sale_service_desc <", value, "postSaleServiceDesc");
            return (Criteria) this;
        }

        public Criteria andPostSaleServiceDescLessThanOrEqualTo(String value) {
            addCriterion("post_sale_service_desc <=", value, "postSaleServiceDesc");
            return (Criteria) this;
        }

        public Criteria andPostSaleServiceDescLike(String value) {
            addCriterion("post_sale_service_desc like", value, "postSaleServiceDesc");
            return (Criteria) this;
        }

        public Criteria andPostSaleServiceDescNotLike(String value) {
            addCriterion("post_sale_service_desc not like", value, "postSaleServiceDesc");
            return (Criteria) this;
        }

        public Criteria andPostSaleServiceDescIn(List<String> values) {
            addCriterion("post_sale_service_desc in", values, "postSaleServiceDesc");
            return (Criteria) this;
        }

        public Criteria andPostSaleServiceDescNotIn(List<String> values) {
            addCriterion("post_sale_service_desc not in", values, "postSaleServiceDesc");
            return (Criteria) this;
        }

        public Criteria andPostSaleServiceDescBetween(String value1, String value2) {
            addCriterion("post_sale_service_desc between", value1, value2, "postSaleServiceDesc");
            return (Criteria) this;
        }

        public Criteria andPostSaleServiceDescNotBetween(String value1, String value2) {
            addCriterion("post_sale_service_desc not between", value1, value2, "postSaleServiceDesc");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeTypeIsNull() {
            addCriterion("delivery_fee_type is null");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeTypeIsNotNull() {
            addCriterion("delivery_fee_type is not null");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeTypeEqualTo(Byte value) {
            addCriterion("delivery_fee_type =", value, "deliveryFeeType");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeTypeNotEqualTo(Byte value) {
            addCriterion("delivery_fee_type <>", value, "deliveryFeeType");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeTypeGreaterThan(Byte value) {
            addCriterion("delivery_fee_type >", value, "deliveryFeeType");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("delivery_fee_type >=", value, "deliveryFeeType");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeTypeLessThan(Byte value) {
            addCriterion("delivery_fee_type <", value, "deliveryFeeType");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeTypeLessThanOrEqualTo(Byte value) {
            addCriterion("delivery_fee_type <=", value, "deliveryFeeType");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeTypeIn(List<Byte> values) {
            addCriterion("delivery_fee_type in", values, "deliveryFeeType");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeTypeNotIn(List<Byte> values) {
            addCriterion("delivery_fee_type not in", values, "deliveryFeeType");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeTypeBetween(Byte value1, Byte value2) {
            addCriterion("delivery_fee_type between", value1, value2, "deliveryFeeType");
            return (Criteria) this;
        }

        public Criteria andDeliveryFeeTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("delivery_fee_type not between", value1, value2, "deliveryFeeType");
            return (Criteria) this;
        }

        public Criteria andNeedAssembleIsNull() {
            addCriterion("need_assemble is null");
            return (Criteria) this;
        }

        public Criteria andNeedAssembleIsNotNull() {
            addCriterion("need_assemble is not null");
            return (Criteria) this;
        }

        public Criteria andNeedAssembleEqualTo(Boolean value) {
            addCriterion("need_assemble =", value, "needAssemble");
            return (Criteria) this;
        }

        public Criteria andNeedAssembleNotEqualTo(Boolean value) {
            addCriterion("need_assemble <>", value, "needAssemble");
            return (Criteria) this;
        }

        public Criteria andNeedAssembleGreaterThan(Boolean value) {
            addCriterion("need_assemble >", value, "needAssemble");
            return (Criteria) this;
        }

        public Criteria andNeedAssembleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("need_assemble >=", value, "needAssemble");
            return (Criteria) this;
        }

        public Criteria andNeedAssembleLessThan(Boolean value) {
            addCriterion("need_assemble <", value, "needAssemble");
            return (Criteria) this;
        }

        public Criteria andNeedAssembleLessThanOrEqualTo(Boolean value) {
            addCriterion("need_assemble <=", value, "needAssemble");
            return (Criteria) this;
        }

        public Criteria andNeedAssembleIn(List<Boolean> values) {
            addCriterion("need_assemble in", values, "needAssemble");
            return (Criteria) this;
        }

        public Criteria andNeedAssembleNotIn(List<Boolean> values) {
            addCriterion("need_assemble not in", values, "needAssemble");
            return (Criteria) this;
        }

        public Criteria andNeedAssembleBetween(Boolean value1, Boolean value2) {
            addCriterion("need_assemble between", value1, value2, "needAssemble");
            return (Criteria) this;
        }

        public Criteria andNeedAssembleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("need_assemble not between", value1, value2, "needAssemble");
            return (Criteria) this;
        }

        public Criteria andAssembleTipsIsNull() {
            addCriterion("assemble_tips is null");
            return (Criteria) this;
        }

        public Criteria andAssembleTipsIsNotNull() {
            addCriterion("assemble_tips is not null");
            return (Criteria) this;
        }

        public Criteria andAssembleTipsEqualTo(String value) {
            addCriterion("assemble_tips =", value, "assembleTips");
            return (Criteria) this;
        }

        public Criteria andAssembleTipsNotEqualTo(String value) {
            addCriterion("assemble_tips <>", value, "assembleTips");
            return (Criteria) this;
        }

        public Criteria andAssembleTipsGreaterThan(String value) {
            addCriterion("assemble_tips >", value, "assembleTips");
            return (Criteria) this;
        }

        public Criteria andAssembleTipsGreaterThanOrEqualTo(String value) {
            addCriterion("assemble_tips >=", value, "assembleTips");
            return (Criteria) this;
        }

        public Criteria andAssembleTipsLessThan(String value) {
            addCriterion("assemble_tips <", value, "assembleTips");
            return (Criteria) this;
        }

        public Criteria andAssembleTipsLessThanOrEqualTo(String value) {
            addCriterion("assemble_tips <=", value, "assembleTips");
            return (Criteria) this;
        }

        public Criteria andAssembleTipsLike(String value) {
            addCriterion("assemble_tips like", value, "assembleTips");
            return (Criteria) this;
        }

        public Criteria andAssembleTipsNotLike(String value) {
            addCriterion("assemble_tips not like", value, "assembleTips");
            return (Criteria) this;
        }

        public Criteria andAssembleTipsIn(List<String> values) {
            addCriterion("assemble_tips in", values, "assembleTips");
            return (Criteria) this;
        }

        public Criteria andAssembleTipsNotIn(List<String> values) {
            addCriterion("assemble_tips not in", values, "assembleTips");
            return (Criteria) this;
        }

        public Criteria andAssembleTipsBetween(String value1, String value2) {
            addCriterion("assemble_tips between", value1, value2, "assembleTips");
            return (Criteria) this;
        }

        public Criteria andAssembleTipsNotBetween(String value1, String value2) {
            addCriterion("assemble_tips not between", value1, value2, "assembleTips");
            return (Criteria) this;
        }

        public Criteria andIsFragileIsNull() {
            addCriterion("is_fragile is null");
            return (Criteria) this;
        }

        public Criteria andIsFragileIsNotNull() {
            addCriterion("is_fragile is not null");
            return (Criteria) this;
        }

        public Criteria andIsFragileEqualTo(Boolean value) {
            addCriterion("is_fragile =", value, "isFragile");
            return (Criteria) this;
        }

        public Criteria andIsFragileNotEqualTo(Boolean value) {
            addCriterion("is_fragile <>", value, "isFragile");
            return (Criteria) this;
        }

        public Criteria andIsFragileGreaterThan(Boolean value) {
            addCriterion("is_fragile >", value, "isFragile");
            return (Criteria) this;
        }

        public Criteria andIsFragileGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_fragile >=", value, "isFragile");
            return (Criteria) this;
        }

        public Criteria andIsFragileLessThan(Boolean value) {
            addCriterion("is_fragile <", value, "isFragile");
            return (Criteria) this;
        }

        public Criteria andIsFragileLessThanOrEqualTo(Boolean value) {
            addCriterion("is_fragile <=", value, "isFragile");
            return (Criteria) this;
        }

        public Criteria andIsFragileIn(List<Boolean> values) {
            addCriterion("is_fragile in", values, "isFragile");
            return (Criteria) this;
        }

        public Criteria andIsFragileNotIn(List<Boolean> values) {
            addCriterion("is_fragile not in", values, "isFragile");
            return (Criteria) this;
        }

        public Criteria andIsFragileBetween(Boolean value1, Boolean value2) {
            addCriterion("is_fragile between", value1, value2, "isFragile");
            return (Criteria) this;
        }

        public Criteria andIsFragileNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_fragile not between", value1, value2, "isFragile");
            return (Criteria) this;
        }

        public Criteria andIsPresaleIsNull() {
            addCriterion("is_presale is null");
            return (Criteria) this;
        }

        public Criteria andIsPresaleIsNotNull() {
            addCriterion("is_presale is not null");
            return (Criteria) this;
        }

        public Criteria andIsPresaleEqualTo(Boolean value) {
            addCriterion("is_presale =", value, "isPresale");
            return (Criteria) this;
        }

        public Criteria andIsPresaleNotEqualTo(Boolean value) {
            addCriterion("is_presale <>", value, "isPresale");
            return (Criteria) this;
        }

        public Criteria andIsPresaleGreaterThan(Boolean value) {
            addCriterion("is_presale >", value, "isPresale");
            return (Criteria) this;
        }

        public Criteria andIsPresaleGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_presale >=", value, "isPresale");
            return (Criteria) this;
        }

        public Criteria andIsPresaleLessThan(Boolean value) {
            addCriterion("is_presale <", value, "isPresale");
            return (Criteria) this;
        }

        public Criteria andIsPresaleLessThanOrEqualTo(Boolean value) {
            addCriterion("is_presale <=", value, "isPresale");
            return (Criteria) this;
        }

        public Criteria andIsPresaleIn(List<Boolean> values) {
            addCriterion("is_presale in", values, "isPresale");
            return (Criteria) this;
        }

        public Criteria andIsPresaleNotIn(List<Boolean> values) {
            addCriterion("is_presale not in", values, "isPresale");
            return (Criteria) this;
        }

        public Criteria andIsPresaleBetween(Boolean value1, Boolean value2) {
            addCriterion("is_presale between", value1, value2, "isPresale");
            return (Criteria) this;
        }

        public Criteria andIsPresaleNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_presale not between", value1, value2, "isPresale");
            return (Criteria) this;
        }

        public Criteria andIsBundlingIsNull() {
            addCriterion("is_bundling is null");
            return (Criteria) this;
        }

        public Criteria andIsBundlingIsNotNull() {
            addCriterion("is_bundling is not null");
            return (Criteria) this;
        }

        public Criteria andIsBundlingEqualTo(Boolean value) {
            addCriterion("is_bundling =", value, "isBundling");
            return (Criteria) this;
        }

        public Criteria andIsBundlingNotEqualTo(Boolean value) {
            addCriterion("is_bundling <>", value, "isBundling");
            return (Criteria) this;
        }

        public Criteria andIsBundlingGreaterThan(Boolean value) {
            addCriterion("is_bundling >", value, "isBundling");
            return (Criteria) this;
        }

        public Criteria andIsBundlingGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_bundling >=", value, "isBundling");
            return (Criteria) this;
        }

        public Criteria andIsBundlingLessThan(Boolean value) {
            addCriterion("is_bundling <", value, "isBundling");
            return (Criteria) this;
        }

        public Criteria andIsBundlingLessThanOrEqualTo(Boolean value) {
            addCriterion("is_bundling <=", value, "isBundling");
            return (Criteria) this;
        }

        public Criteria andIsBundlingIn(List<Boolean> values) {
            addCriterion("is_bundling in", values, "isBundling");
            return (Criteria) this;
        }

        public Criteria andIsBundlingNotIn(List<Boolean> values) {
            addCriterion("is_bundling not in", values, "isBundling");
            return (Criteria) this;
        }

        public Criteria andIsBundlingBetween(Boolean value1, Boolean value2) {
            addCriterion("is_bundling between", value1, value2, "isBundling");
            return (Criteria) this;
        }

        public Criteria andIsBundlingNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_bundling not between", value1, value2, "isBundling");
            return (Criteria) this;
        }

        public Criteria andProductStatusIsNull() {
            addCriterion("product_status is null");
            return (Criteria) this;
        }

        public Criteria andProductStatusIsNotNull() {
            addCriterion("product_status is not null");
            return (Criteria) this;
        }

        public Criteria andProductStatusEqualTo(Short value) {
            addCriterion("product_status =", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusNotEqualTo(Short value) {
            addCriterion("product_status <>", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusGreaterThan(Short value) {
            addCriterion("product_status >", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusGreaterThanOrEqualTo(Short value) {
            addCriterion("product_status >=", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusLessThan(Short value) {
            addCriterion("product_status <", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusLessThanOrEqualTo(Short value) {
            addCriterion("product_status <=", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusIn(List<Short> values) {
            addCriterion("product_status in", values, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusNotIn(List<Short> values) {
            addCriterion("product_status not in", values, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusBetween(Short value1, Short value2) {
            addCriterion("product_status between", value1, value2, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusNotBetween(Short value1, Short value2) {
            addCriterion("product_status not between", value1, value2, "productStatus");
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

        public Criteria andOnShelfTimeIsNull() {
            addCriterion("on_shelf_time is null");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeIsNotNull() {
            addCriterion("on_shelf_time is not null");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeEqualTo(Date value) {
            addCriterion("on_shelf_time =", value, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeNotEqualTo(Date value) {
            addCriterion("on_shelf_time <>", value, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeGreaterThan(Date value) {
            addCriterion("on_shelf_time >", value, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("on_shelf_time >=", value, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeLessThan(Date value) {
            addCriterion("on_shelf_time <", value, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeLessThanOrEqualTo(Date value) {
            addCriterion("on_shelf_time <=", value, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeIn(List<Date> values) {
            addCriterion("on_shelf_time in", values, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeNotIn(List<Date> values) {
            addCriterion("on_shelf_time not in", values, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeBetween(Date value1, Date value2) {
            addCriterion("on_shelf_time between", value1, value2, "onShelfTime");
            return (Criteria) this;
        }

        public Criteria andOnShelfTimeNotBetween(Date value1, Date value2) {
            addCriterion("on_shelf_time not between", value1, value2, "onShelfTime");
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

        public Criteria andApprovalTimeIsNull() {
            addCriterion("approval_time is null");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIsNotNull() {
            addCriterion("approval_time is not null");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeEqualTo(Date value) {
            addCriterion("approval_time =", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotEqualTo(Date value) {
            addCriterion("approval_time <>", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeGreaterThan(Date value) {
            addCriterion("approval_time >", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("approval_time >=", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeLessThan(Date value) {
            addCriterion("approval_time <", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeLessThanOrEqualTo(Date value) {
            addCriterion("approval_time <=", value, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeIn(List<Date> values) {
            addCriterion("approval_time in", values, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotIn(List<Date> values) {
            addCriterion("approval_time not in", values, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeBetween(Date value1, Date value2) {
            addCriterion("approval_time between", value1, value2, "approvalTime");
            return (Criteria) this;
        }

        public Criteria andApprovalTimeNotBetween(Date value1, Date value2) {
            addCriterion("approval_time not between", value1, value2, "approvalTime");
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

        public Criteria andProductNameLikeInsensitive(String value) {
            addCriterion("upper(product_name) like", value.toUpperCase(), "productName");
            return (Criteria) this;
        }

        public Criteria andProductCodeLikeInsensitive(String value) {
            addCriterion("upper(product_code) like", value.toUpperCase(), "productCode");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLikeInsensitive(String value) {
            addCriterion("upper(category_id) like", value.toUpperCase(), "categoryId");
            return (Criteria) this;
        }

        public Criteria andProductModelLikeInsensitive(String value) {
            addCriterion("upper(product_model) like", value.toUpperCase(), "productModel");
            return (Criteria) this;
        }

        public Criteria andMaterialLikeInsensitive(String value) {
            addCriterion("upper(material) like", value.toUpperCase(), "material");
            return (Criteria) this;
        }

        public Criteria andSellingPointLikeInsensitive(String value) {
            addCriterion("upper(selling_point) like", value.toUpperCase(), "sellingPoint");
            return (Criteria) this;
        }

        public Criteria andDetailDescriptionLikeInsensitive(String value) {
            addCriterion("upper(detail_description) like", value.toUpperCase(), "detailDescription");
            return (Criteria) this;
        }

        public Criteria andOriginCountryLikeInsensitive(String value) {
            addCriterion("upper(origin_country) like", value.toUpperCase(), "originCountry");
            return (Criteria) this;
        }

        public Criteria andOriginTextLikeInsensitive(String value) {
            addCriterion("upper(origin_text) like", value.toUpperCase(), "originText");
            return (Criteria) this;
        }

        public Criteria andSizeTextLikeInsensitive(String value) {
            addCriterion("upper(size_text) like", value.toUpperCase(), "sizeText");
            return (Criteria) this;
        }

        public Criteria andWeightTextLikeInsensitive(String value) {
            addCriterion("upper(weight_text) like", value.toUpperCase(), "weightText");
            return (Criteria) this;
        }

        public Criteria andSpecLikeInsensitive(String value) {
            addCriterion("upper(spec) like", value.toUpperCase(), "spec");
            return (Criteria) this;
        }

        public Criteria andSpecImgLikeInsensitive(String value) {
            addCriterion("upper(spec_img) like", value.toUpperCase(), "specImg");
            return (Criteria) this;
        }

        public Criteria andColorLikeInsensitive(String value) {
            addCriterion("upper(color) like", value.toUpperCase(), "color");
            return (Criteria) this;
        }

        public Criteria andStyleLikeInsensitive(String value) {
            addCriterion("upper(style) like", value.toUpperCase(), "style");
            return (Criteria) this;
        }

        public Criteria andVerboseInfoLikeInsensitive(String value) {
            addCriterion("upper(verbose_info) like", value.toUpperCase(), "verboseInfo");
            return (Criteria) this;
        }

        public Criteria andTipsLikeInsensitive(String value) {
            addCriterion("upper(tips) like", value.toUpperCase(), "tips");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneLikeInsensitive(String value) {
            addCriterion("upper(applicable_scene) like", value.toUpperCase(), "applicableScene");
            return (Criteria) this;
        }

        public Criteria andPostSaleServiceDescLikeInsensitive(String value) {
            addCriterion("upper(post_sale_service_desc) like", value.toUpperCase(), "postSaleServiceDesc");
            return (Criteria) this;
        }

        public Criteria andAssembleTipsLikeInsensitive(String value) {
            addCriterion("upper(assemble_tips) like", value.toUpperCase(), "assembleTips");
            return (Criteria) this;
        }

        public Criteria andRejectReasonLikeInsensitive(String value) {
            addCriterion("upper(reject_reason) like", value.toUpperCase(), "rejectReason");
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