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

        public Criteria andCategoryIdEqualTo(Integer value) {
            addCriterion("category_id =", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotEqualTo(Integer value) {
            addCriterion("category_id <>", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThan(Integer value) {
            addCriterion("category_id >", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("category_id >=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThan(Integer value) {
            addCriterion("category_id <", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdLessThanOrEqualTo(Integer value) {
            addCriterion("category_id <=", value, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdIn(List<Integer> values) {
            addCriterion("category_id in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotIn(List<Integer> values) {
            addCriterion("category_id not in", values, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdBetween(Integer value1, Integer value2) {
            addCriterion("category_id between", value1, value2, "categoryId");
            return (Criteria) this;
        }

        public Criteria andCategoryIdNotBetween(Integer value1, Integer value2) {
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

        public Criteria andMaterialTextIsNull() {
            addCriterion("material_text is null");
            return (Criteria) this;
        }

        public Criteria andMaterialTextIsNotNull() {
            addCriterion("material_text is not null");
            return (Criteria) this;
        }

        public Criteria andMaterialTextEqualTo(String value) {
            addCriterion("material_text =", value, "materialText");
            return (Criteria) this;
        }

        public Criteria andMaterialTextNotEqualTo(String value) {
            addCriterion("material_text <>", value, "materialText");
            return (Criteria) this;
        }

        public Criteria andMaterialTextGreaterThan(String value) {
            addCriterion("material_text >", value, "materialText");
            return (Criteria) this;
        }

        public Criteria andMaterialTextGreaterThanOrEqualTo(String value) {
            addCriterion("material_text >=", value, "materialText");
            return (Criteria) this;
        }

        public Criteria andMaterialTextLessThan(String value) {
            addCriterion("material_text <", value, "materialText");
            return (Criteria) this;
        }

        public Criteria andMaterialTextLessThanOrEqualTo(String value) {
            addCriterion("material_text <=", value, "materialText");
            return (Criteria) this;
        }

        public Criteria andMaterialTextLike(String value) {
            addCriterion("material_text like", value, "materialText");
            return (Criteria) this;
        }

        public Criteria andMaterialTextNotLike(String value) {
            addCriterion("material_text not like", value, "materialText");
            return (Criteria) this;
        }

        public Criteria andMaterialTextIn(List<String> values) {
            addCriterion("material_text in", values, "materialText");
            return (Criteria) this;
        }

        public Criteria andMaterialTextNotIn(List<String> values) {
            addCriterion("material_text not in", values, "materialText");
            return (Criteria) this;
        }

        public Criteria andMaterialTextBetween(String value1, String value2) {
            addCriterion("material_text between", value1, value2, "materialText");
            return (Criteria) this;
        }

        public Criteria andMaterialTextNotBetween(String value1, String value2) {
            addCriterion("material_text not between", value1, value2, "materialText");
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

        public Criteria andSeoTitleIsNull() {
            addCriterion("seo_title is null");
            return (Criteria) this;
        }

        public Criteria andSeoTitleIsNotNull() {
            addCriterion("seo_title is not null");
            return (Criteria) this;
        }

        public Criteria andSeoTitleEqualTo(String value) {
            addCriterion("seo_title =", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleNotEqualTo(String value) {
            addCriterion("seo_title <>", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleGreaterThan(String value) {
            addCriterion("seo_title >", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleGreaterThanOrEqualTo(String value) {
            addCriterion("seo_title >=", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleLessThan(String value) {
            addCriterion("seo_title <", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleLessThanOrEqualTo(String value) {
            addCriterion("seo_title <=", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleLike(String value) {
            addCriterion("seo_title like", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleNotLike(String value) {
            addCriterion("seo_title not like", value, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleIn(List<String> values) {
            addCriterion("seo_title in", values, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleNotIn(List<String> values) {
            addCriterion("seo_title not in", values, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleBetween(String value1, String value2) {
            addCriterion("seo_title between", value1, value2, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoTitleNotBetween(String value1, String value2) {
            addCriterion("seo_title not between", value1, value2, "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoDescIsNull() {
            addCriterion("seo_desc is null");
            return (Criteria) this;
        }

        public Criteria andSeoDescIsNotNull() {
            addCriterion("seo_desc is not null");
            return (Criteria) this;
        }

        public Criteria andSeoDescEqualTo(String value) {
            addCriterion("seo_desc =", value, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescNotEqualTo(String value) {
            addCriterion("seo_desc <>", value, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescGreaterThan(String value) {
            addCriterion("seo_desc >", value, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescGreaterThanOrEqualTo(String value) {
            addCriterion("seo_desc >=", value, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescLessThan(String value) {
            addCriterion("seo_desc <", value, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescLessThanOrEqualTo(String value) {
            addCriterion("seo_desc <=", value, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescLike(String value) {
            addCriterion("seo_desc like", value, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescNotLike(String value) {
            addCriterion("seo_desc not like", value, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescIn(List<String> values) {
            addCriterion("seo_desc in", values, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescNotIn(List<String> values) {
            addCriterion("seo_desc not in", values, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescBetween(String value1, String value2) {
            addCriterion("seo_desc between", value1, value2, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoDescNotBetween(String value1, String value2) {
            addCriterion("seo_desc not between", value1, value2, "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoKeyIsNull() {
            addCriterion("seo_key is null");
            return (Criteria) this;
        }

        public Criteria andSeoKeyIsNotNull() {
            addCriterion("seo_key is not null");
            return (Criteria) this;
        }

        public Criteria andSeoKeyEqualTo(String value) {
            addCriterion("seo_key =", value, "seoKey");
            return (Criteria) this;
        }

        public Criteria andSeoKeyNotEqualTo(String value) {
            addCriterion("seo_key <>", value, "seoKey");
            return (Criteria) this;
        }

        public Criteria andSeoKeyGreaterThan(String value) {
            addCriterion("seo_key >", value, "seoKey");
            return (Criteria) this;
        }

        public Criteria andSeoKeyGreaterThanOrEqualTo(String value) {
            addCriterion("seo_key >=", value, "seoKey");
            return (Criteria) this;
        }

        public Criteria andSeoKeyLessThan(String value) {
            addCriterion("seo_key <", value, "seoKey");
            return (Criteria) this;
        }

        public Criteria andSeoKeyLessThanOrEqualTo(String value) {
            addCriterion("seo_key <=", value, "seoKey");
            return (Criteria) this;
        }

        public Criteria andSeoKeyLike(String value) {
            addCriterion("seo_key like", value, "seoKey");
            return (Criteria) this;
        }

        public Criteria andSeoKeyNotLike(String value) {
            addCriterion("seo_key not like", value, "seoKey");
            return (Criteria) this;
        }

        public Criteria andSeoKeyIn(List<String> values) {
            addCriterion("seo_key in", values, "seoKey");
            return (Criteria) this;
        }

        public Criteria andSeoKeyNotIn(List<String> values) {
            addCriterion("seo_key not in", values, "seoKey");
            return (Criteria) this;
        }

        public Criteria andSeoKeyBetween(String value1, String value2) {
            addCriterion("seo_key between", value1, value2, "seoKey");
            return (Criteria) this;
        }

        public Criteria andSeoKeyNotBetween(String value1, String value2) {
            addCriterion("seo_key not between", value1, value2, "seoKey");
            return (Criteria) this;
        }

        public Criteria andOriginCountryIdIsNull() {
            addCriterion("origin_country_id is null");
            return (Criteria) this;
        }

        public Criteria andOriginCountryIdIsNotNull() {
            addCriterion("origin_country_id is not null");
            return (Criteria) this;
        }

        public Criteria andOriginCountryIdEqualTo(Integer value) {
            addCriterion("origin_country_id =", value, "originCountryId");
            return (Criteria) this;
        }

        public Criteria andOriginCountryIdNotEqualTo(Integer value) {
            addCriterion("origin_country_id <>", value, "originCountryId");
            return (Criteria) this;
        }

        public Criteria andOriginCountryIdGreaterThan(Integer value) {
            addCriterion("origin_country_id >", value, "originCountryId");
            return (Criteria) this;
        }

        public Criteria andOriginCountryIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("origin_country_id >=", value, "originCountryId");
            return (Criteria) this;
        }

        public Criteria andOriginCountryIdLessThan(Integer value) {
            addCriterion("origin_country_id <", value, "originCountryId");
            return (Criteria) this;
        }

        public Criteria andOriginCountryIdLessThanOrEqualTo(Integer value) {
            addCriterion("origin_country_id <=", value, "originCountryId");
            return (Criteria) this;
        }

        public Criteria andOriginCountryIdIn(List<Integer> values) {
            addCriterion("origin_country_id in", values, "originCountryId");
            return (Criteria) this;
        }

        public Criteria andOriginCountryIdNotIn(List<Integer> values) {
            addCriterion("origin_country_id not in", values, "originCountryId");
            return (Criteria) this;
        }

        public Criteria andOriginCountryIdBetween(Integer value1, Integer value2) {
            addCriterion("origin_country_id between", value1, value2, "originCountryId");
            return (Criteria) this;
        }

        public Criteria andOriginCountryIdNotBetween(Integer value1, Integer value2) {
            addCriterion("origin_country_id not between", value1, value2, "originCountryId");
            return (Criteria) this;
        }

        public Criteria andOriginCityIsNull() {
            addCriterion("origin_city is null");
            return (Criteria) this;
        }

        public Criteria andOriginCityIsNotNull() {
            addCriterion("origin_city is not null");
            return (Criteria) this;
        }

        public Criteria andOriginCityEqualTo(String value) {
            addCriterion("origin_city =", value, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityNotEqualTo(String value) {
            addCriterion("origin_city <>", value, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityGreaterThan(String value) {
            addCriterion("origin_city >", value, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityGreaterThanOrEqualTo(String value) {
            addCriterion("origin_city >=", value, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityLessThan(String value) {
            addCriterion("origin_city <", value, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityLessThanOrEqualTo(String value) {
            addCriterion("origin_city <=", value, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityLike(String value) {
            addCriterion("origin_city like", value, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityNotLike(String value) {
            addCriterion("origin_city not like", value, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityIn(List<String> values) {
            addCriterion("origin_city in", values, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityNotIn(List<String> values) {
            addCriterion("origin_city not in", values, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityBetween(String value1, String value2) {
            addCriterion("origin_city between", value1, value2, "originCity");
            return (Criteria) this;
        }

        public Criteria andOriginCityNotBetween(String value1, String value2) {
            addCriterion("origin_city not between", value1, value2, "originCity");
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

        public Criteria andSpecNameIsNull() {
            addCriterion("spec_name is null");
            return (Criteria) this;
        }

        public Criteria andSpecNameIsNotNull() {
            addCriterion("spec_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpecNameEqualTo(String value) {
            addCriterion("spec_name =", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameNotEqualTo(String value) {
            addCriterion("spec_name <>", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameGreaterThan(String value) {
            addCriterion("spec_name >", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameGreaterThanOrEqualTo(String value) {
            addCriterion("spec_name >=", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameLessThan(String value) {
            addCriterion("spec_name <", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameLessThanOrEqualTo(String value) {
            addCriterion("spec_name <=", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameLike(String value) {
            addCriterion("spec_name like", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameNotLike(String value) {
            addCriterion("spec_name not like", value, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameIn(List<String> values) {
            addCriterion("spec_name in", values, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameNotIn(List<String> values) {
            addCriterion("spec_name not in", values, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameBetween(String value1, String value2) {
            addCriterion("spec_name between", value1, value2, "specName");
            return (Criteria) this;
        }

        public Criteria andSpecNameNotBetween(String value1, String value2) {
            addCriterion("spec_name not between", value1, value2, "specName");
            return (Criteria) this;
        }

        public Criteria andColorIdIsNull() {
            addCriterion("color_id is null");
            return (Criteria) this;
        }

        public Criteria andColorIdIsNotNull() {
            addCriterion("color_id is not null");
            return (Criteria) this;
        }

        public Criteria andColorIdEqualTo(Byte value) {
            addCriterion("color_id =", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotEqualTo(Byte value) {
            addCriterion("color_id <>", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdGreaterThan(Byte value) {
            addCriterion("color_id >", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("color_id >=", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdLessThan(Byte value) {
            addCriterion("color_id <", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdLessThanOrEqualTo(Byte value) {
            addCriterion("color_id <=", value, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdIn(List<Byte> values) {
            addCriterion("color_id in", values, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotIn(List<Byte> values) {
            addCriterion("color_id not in", values, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdBetween(Byte value1, Byte value2) {
            addCriterion("color_id between", value1, value2, "colorId");
            return (Criteria) this;
        }

        public Criteria andColorIdNotBetween(Byte value1, Byte value2) {
            addCriterion("color_id not between", value1, value2, "colorId");
            return (Criteria) this;
        }

        public Criteria andProductColorImgIsNull() {
            addCriterion("product_color_img is null");
            return (Criteria) this;
        }

        public Criteria andProductColorImgIsNotNull() {
            addCriterion("product_color_img is not null");
            return (Criteria) this;
        }

        public Criteria andProductColorImgEqualTo(String value) {
            addCriterion("product_color_img =", value, "productColorImg");
            return (Criteria) this;
        }

        public Criteria andProductColorImgNotEqualTo(String value) {
            addCriterion("product_color_img <>", value, "productColorImg");
            return (Criteria) this;
        }

        public Criteria andProductColorImgGreaterThan(String value) {
            addCriterion("product_color_img >", value, "productColorImg");
            return (Criteria) this;
        }

        public Criteria andProductColorImgGreaterThanOrEqualTo(String value) {
            addCriterion("product_color_img >=", value, "productColorImg");
            return (Criteria) this;
        }

        public Criteria andProductColorImgLessThan(String value) {
            addCriterion("product_color_img <", value, "productColorImg");
            return (Criteria) this;
        }

        public Criteria andProductColorImgLessThanOrEqualTo(String value) {
            addCriterion("product_color_img <=", value, "productColorImg");
            return (Criteria) this;
        }

        public Criteria andProductColorImgLike(String value) {
            addCriterion("product_color_img like", value, "productColorImg");
            return (Criteria) this;
        }

        public Criteria andProductColorImgNotLike(String value) {
            addCriterion("product_color_img not like", value, "productColorImg");
            return (Criteria) this;
        }

        public Criteria andProductColorImgIn(List<String> values) {
            addCriterion("product_color_img in", values, "productColorImg");
            return (Criteria) this;
        }

        public Criteria andProductColorImgNotIn(List<String> values) {
            addCriterion("product_color_img not in", values, "productColorImg");
            return (Criteria) this;
        }

        public Criteria andProductColorImgBetween(String value1, String value2) {
            addCriterion("product_color_img between", value1, value2, "productColorImg");
            return (Criteria) this;
        }

        public Criteria andProductColorImgNotBetween(String value1, String value2) {
            addCriterion("product_color_img not between", value1, value2, "productColorImg");
            return (Criteria) this;
        }

        public Criteria andColorDisplayNameIsNull() {
            addCriterion("color_display_name is null");
            return (Criteria) this;
        }

        public Criteria andColorDisplayNameIsNotNull() {
            addCriterion("color_display_name is not null");
            return (Criteria) this;
        }

        public Criteria andColorDisplayNameEqualTo(String value) {
            addCriterion("color_display_name =", value, "colorDisplayName");
            return (Criteria) this;
        }

        public Criteria andColorDisplayNameNotEqualTo(String value) {
            addCriterion("color_display_name <>", value, "colorDisplayName");
            return (Criteria) this;
        }

        public Criteria andColorDisplayNameGreaterThan(String value) {
            addCriterion("color_display_name >", value, "colorDisplayName");
            return (Criteria) this;
        }

        public Criteria andColorDisplayNameGreaterThanOrEqualTo(String value) {
            addCriterion("color_display_name >=", value, "colorDisplayName");
            return (Criteria) this;
        }

        public Criteria andColorDisplayNameLessThan(String value) {
            addCriterion("color_display_name <", value, "colorDisplayName");
            return (Criteria) this;
        }

        public Criteria andColorDisplayNameLessThanOrEqualTo(String value) {
            addCriterion("color_display_name <=", value, "colorDisplayName");
            return (Criteria) this;
        }

        public Criteria andColorDisplayNameLike(String value) {
            addCriterion("color_display_name like", value, "colorDisplayName");
            return (Criteria) this;
        }

        public Criteria andColorDisplayNameNotLike(String value) {
            addCriterion("color_display_name not like", value, "colorDisplayName");
            return (Criteria) this;
        }

        public Criteria andColorDisplayNameIn(List<String> values) {
            addCriterion("color_display_name in", values, "colorDisplayName");
            return (Criteria) this;
        }

        public Criteria andColorDisplayNameNotIn(List<String> values) {
            addCriterion("color_display_name not in", values, "colorDisplayName");
            return (Criteria) this;
        }

        public Criteria andColorDisplayNameBetween(String value1, String value2) {
            addCriterion("color_display_name between", value1, value2, "colorDisplayName");
            return (Criteria) this;
        }

        public Criteria andColorDisplayNameNotBetween(String value1, String value2) {
            addCriterion("color_display_name not between", value1, value2, "colorDisplayName");
            return (Criteria) this;
        }

        public Criteria andStyleIdIsNull() {
            addCriterion("style_id is null");
            return (Criteria) this;
        }

        public Criteria andStyleIdIsNotNull() {
            addCriterion("style_id is not null");
            return (Criteria) this;
        }

        public Criteria andStyleIdEqualTo(Byte value) {
            addCriterion("style_id =", value, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleIdNotEqualTo(Byte value) {
            addCriterion("style_id <>", value, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleIdGreaterThan(Byte value) {
            addCriterion("style_id >", value, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleIdGreaterThanOrEqualTo(Byte value) {
            addCriterion("style_id >=", value, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleIdLessThan(Byte value) {
            addCriterion("style_id <", value, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleIdLessThanOrEqualTo(Byte value) {
            addCriterion("style_id <=", value, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleIdIn(List<Byte> values) {
            addCriterion("style_id in", values, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleIdNotIn(List<Byte> values) {
            addCriterion("style_id not in", values, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleIdBetween(Byte value1, Byte value2) {
            addCriterion("style_id between", value1, value2, "styleId");
            return (Criteria) this;
        }

        public Criteria andStyleIdNotBetween(Byte value1, Byte value2) {
            addCriterion("style_id not between", value1, value2, "styleId");
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

        public Criteria andApplicablePeopleIsNull() {
            addCriterion("applicable_people is null");
            return (Criteria) this;
        }

        public Criteria andApplicablePeopleIsNotNull() {
            addCriterion("applicable_people is not null");
            return (Criteria) this;
        }

        public Criteria andApplicablePeopleEqualTo(Byte value) {
            addCriterion("applicable_people =", value, "applicablePeople");
            return (Criteria) this;
        }

        public Criteria andApplicablePeopleNotEqualTo(Byte value) {
            addCriterion("applicable_people <>", value, "applicablePeople");
            return (Criteria) this;
        }

        public Criteria andApplicablePeopleGreaterThan(Byte value) {
            addCriterion("applicable_people >", value, "applicablePeople");
            return (Criteria) this;
        }

        public Criteria andApplicablePeopleGreaterThanOrEqualTo(Byte value) {
            addCriterion("applicable_people >=", value, "applicablePeople");
            return (Criteria) this;
        }

        public Criteria andApplicablePeopleLessThan(Byte value) {
            addCriterion("applicable_people <", value, "applicablePeople");
            return (Criteria) this;
        }

        public Criteria andApplicablePeopleLessThanOrEqualTo(Byte value) {
            addCriterion("applicable_people <=", value, "applicablePeople");
            return (Criteria) this;
        }

        public Criteria andApplicablePeopleIn(List<Byte> values) {
            addCriterion("applicable_people in", values, "applicablePeople");
            return (Criteria) this;
        }

        public Criteria andApplicablePeopleNotIn(List<Byte> values) {
            addCriterion("applicable_people not in", values, "applicablePeople");
            return (Criteria) this;
        }

        public Criteria andApplicablePeopleBetween(Byte value1, Byte value2) {
            addCriterion("applicable_people between", value1, value2, "applicablePeople");
            return (Criteria) this;
        }

        public Criteria andApplicablePeopleNotBetween(Byte value1, Byte value2) {
            addCriterion("applicable_people not between", value1, value2, "applicablePeople");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneTextIsNull() {
            addCriterion("applicable_scene_text is null");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneTextIsNotNull() {
            addCriterion("applicable_scene_text is not null");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneTextEqualTo(String value) {
            addCriterion("applicable_scene_text =", value, "applicableSceneText");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneTextNotEqualTo(String value) {
            addCriterion("applicable_scene_text <>", value, "applicableSceneText");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneTextGreaterThan(String value) {
            addCriterion("applicable_scene_text >", value, "applicableSceneText");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneTextGreaterThanOrEqualTo(String value) {
            addCriterion("applicable_scene_text >=", value, "applicableSceneText");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneTextLessThan(String value) {
            addCriterion("applicable_scene_text <", value, "applicableSceneText");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneTextLessThanOrEqualTo(String value) {
            addCriterion("applicable_scene_text <=", value, "applicableSceneText");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneTextLike(String value) {
            addCriterion("applicable_scene_text like", value, "applicableSceneText");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneTextNotLike(String value) {
            addCriterion("applicable_scene_text not like", value, "applicableSceneText");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneTextIn(List<String> values) {
            addCriterion("applicable_scene_text in", values, "applicableSceneText");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneTextNotIn(List<String> values) {
            addCriterion("applicable_scene_text not in", values, "applicableSceneText");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneTextBetween(String value1, String value2) {
            addCriterion("applicable_scene_text between", value1, value2, "applicableSceneText");
            return (Criteria) this;
        }

        public Criteria andApplicableSceneTextNotBetween(String value1, String value2) {
            addCriterion("applicable_scene_text not between", value1, value2, "applicableSceneText");
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

        public Criteria andCanCustomizedIsNull() {
            addCriterion("can_customized is null");
            return (Criteria) this;
        }

        public Criteria andCanCustomizedIsNotNull() {
            addCriterion("can_customized is not null");
            return (Criteria) this;
        }

        public Criteria andCanCustomizedEqualTo(Boolean value) {
            addCriterion("can_customized =", value, "canCustomized");
            return (Criteria) this;
        }

        public Criteria andCanCustomizedNotEqualTo(Boolean value) {
            addCriterion("can_customized <>", value, "canCustomized");
            return (Criteria) this;
        }

        public Criteria andCanCustomizedGreaterThan(Boolean value) {
            addCriterion("can_customized >", value, "canCustomized");
            return (Criteria) this;
        }

        public Criteria andCanCustomizedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("can_customized >=", value, "canCustomized");
            return (Criteria) this;
        }

        public Criteria andCanCustomizedLessThan(Boolean value) {
            addCriterion("can_customized <", value, "canCustomized");
            return (Criteria) this;
        }

        public Criteria andCanCustomizedLessThanOrEqualTo(Boolean value) {
            addCriterion("can_customized <=", value, "canCustomized");
            return (Criteria) this;
        }

        public Criteria andCanCustomizedIn(List<Boolean> values) {
            addCriterion("can_customized in", values, "canCustomized");
            return (Criteria) this;
        }

        public Criteria andCanCustomizedNotIn(List<Boolean> values) {
            addCriterion("can_customized not in", values, "canCustomized");
            return (Criteria) this;
        }

        public Criteria andCanCustomizedBetween(Boolean value1, Boolean value2) {
            addCriterion("can_customized between", value1, value2, "canCustomized");
            return (Criteria) this;
        }

        public Criteria andCanCustomizedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("can_customized not between", value1, value2, "canCustomized");
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

        public Criteria andProductStatusEqualTo(Byte value) {
            addCriterion("product_status =", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusNotEqualTo(Byte value) {
            addCriterion("product_status <>", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusGreaterThan(Byte value) {
            addCriterion("product_status >", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("product_status >=", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusLessThan(Byte value) {
            addCriterion("product_status <", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusLessThanOrEqualTo(Byte value) {
            addCriterion("product_status <=", value, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusIn(List<Byte> values) {
            addCriterion("product_status in", values, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusNotIn(List<Byte> values) {
            addCriterion("product_status not in", values, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusBetween(Byte value1, Byte value2) {
            addCriterion("product_status between", value1, value2, "productStatus");
            return (Criteria) this;
        }

        public Criteria andProductStatusNotBetween(Byte value1, Byte value2) {
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

        public Criteria andProductModelLikeInsensitive(String value) {
            addCriterion("upper(product_model) like", value.toUpperCase(), "productModel");
            return (Criteria) this;
        }

        public Criteria andMaterialTextLikeInsensitive(String value) {
            addCriterion("upper(material_text) like", value.toUpperCase(), "materialText");
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

        public Criteria andSeoTitleLikeInsensitive(String value) {
            addCriterion("upper(seo_title) like", value.toUpperCase(), "seoTitle");
            return (Criteria) this;
        }

        public Criteria andSeoDescLikeInsensitive(String value) {
            addCriterion("upper(seo_desc) like", value.toUpperCase(), "seoDesc");
            return (Criteria) this;
        }

        public Criteria andSeoKeyLikeInsensitive(String value) {
            addCriterion("upper(seo_key) like", value.toUpperCase(), "seoKey");
            return (Criteria) this;
        }

        public Criteria andOriginCityLikeInsensitive(String value) {
            addCriterion("upper(origin_city) like", value.toUpperCase(), "originCity");
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

        public Criteria andSpecNameLikeInsensitive(String value) {
            addCriterion("upper(spec_name) like", value.toUpperCase(), "specName");
            return (Criteria) this;
        }

        public Criteria andProductColorImgLikeInsensitive(String value) {
            addCriterion("upper(product_color_img) like", value.toUpperCase(), "productColorImg");
            return (Criteria) this;
        }

        public Criteria andColorDisplayNameLikeInsensitive(String value) {
            addCriterion("upper(color_display_name) like", value.toUpperCase(), "colorDisplayName");
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

        public Criteria andApplicableSceneTextLikeInsensitive(String value) {
            addCriterion("upper(applicable_scene_text) like", value.toUpperCase(), "applicableSceneText");
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