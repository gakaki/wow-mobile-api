package com.wow.order.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SaleOrderItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SaleOrderItemExample() {
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

        public Criteria andSaleOrderIdIsNull() {
            addCriterion("sale_order_id is null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdIsNotNull() {
            addCriterion("sale_order_id is not null");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdEqualTo(Integer value) {
            addCriterion("sale_order_id =", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdNotEqualTo(Integer value) {
            addCriterion("sale_order_id <>", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdGreaterThan(Integer value) {
            addCriterion("sale_order_id >", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sale_order_id >=", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdLessThan(Integer value) {
            addCriterion("sale_order_id <", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdLessThanOrEqualTo(Integer value) {
            addCriterion("sale_order_id <=", value, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdIn(List<Integer> values) {
            addCriterion("sale_order_id in", values, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdNotIn(List<Integer> values) {
            addCriterion("sale_order_id not in", values, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdBetween(Integer value1, Integer value2) {
            addCriterion("sale_order_id between", value1, value2, "saleOrderId");
            return (Criteria) this;
        }

        public Criteria andSaleOrderIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sale_order_id not between", value1, value2, "saleOrderId");
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

        public Criteria andOrderItemAmountIsNull() {
            addCriterion("order_item_amount is null");
            return (Criteria) this;
        }

        public Criteria andOrderItemAmountIsNotNull() {
            addCriterion("order_item_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOrderItemAmountEqualTo(BigDecimal value) {
            addCriterion("order_item_amount =", value, "orderItemAmount");
            return (Criteria) this;
        }

        public Criteria andOrderItemAmountNotEqualTo(BigDecimal value) {
            addCriterion("order_item_amount <>", value, "orderItemAmount");
            return (Criteria) this;
        }

        public Criteria andOrderItemAmountGreaterThan(BigDecimal value) {
            addCriterion("order_item_amount >", value, "orderItemAmount");
            return (Criteria) this;
        }

        public Criteria andOrderItemAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_item_amount >=", value, "orderItemAmount");
            return (Criteria) this;
        }

        public Criteria andOrderItemAmountLessThan(BigDecimal value) {
            addCriterion("order_item_amount <", value, "orderItemAmount");
            return (Criteria) this;
        }

        public Criteria andOrderItemAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_item_amount <=", value, "orderItemAmount");
            return (Criteria) this;
        }

        public Criteria andOrderItemAmountIn(List<BigDecimal> values) {
            addCriterion("order_item_amount in", values, "orderItemAmount");
            return (Criteria) this;
        }

        public Criteria andOrderItemAmountNotIn(List<BigDecimal> values) {
            addCriterion("order_item_amount not in", values, "orderItemAmount");
            return (Criteria) this;
        }

        public Criteria andOrderItemAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_item_amount between", value1, value2, "orderItemAmount");
            return (Criteria) this;
        }

        public Criteria andOrderItemAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_item_amount not between", value1, value2, "orderItemAmount");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceIsNull() {
            addCriterion("order_item_price is null");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceIsNotNull() {
            addCriterion("order_item_price is not null");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceEqualTo(BigDecimal value) {
            addCriterion("order_item_price =", value, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceNotEqualTo(BigDecimal value) {
            addCriterion("order_item_price <>", value, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceGreaterThan(BigDecimal value) {
            addCriterion("order_item_price >", value, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("order_item_price >=", value, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceLessThan(BigDecimal value) {
            addCriterion("order_item_price <", value, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceLessThanOrEqualTo(BigDecimal value) {
            addCriterion("order_item_price <=", value, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceIn(List<BigDecimal> values) {
            addCriterion("order_item_price in", values, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceNotIn(List<BigDecimal> values) {
            addCriterion("order_item_price not in", values, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_item_price between", value1, value2, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemPriceNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("order_item_price not between", value1, value2, "orderItemPrice");
            return (Criteria) this;
        }

        public Criteria andOrderItemQtyIsNull() {
            addCriterion("order_item_qty is null");
            return (Criteria) this;
        }

        public Criteria andOrderItemQtyIsNotNull() {
            addCriterion("order_item_qty is not null");
            return (Criteria) this;
        }

        public Criteria andOrderItemQtyEqualTo(Byte value) {
            addCriterion("order_item_qty =", value, "orderItemQty");
            return (Criteria) this;
        }

        public Criteria andOrderItemQtyNotEqualTo(Byte value) {
            addCriterion("order_item_qty <>", value, "orderItemQty");
            return (Criteria) this;
        }

        public Criteria andOrderItemQtyGreaterThan(Byte value) {
            addCriterion("order_item_qty >", value, "orderItemQty");
            return (Criteria) this;
        }

        public Criteria andOrderItemQtyGreaterThanOrEqualTo(Byte value) {
            addCriterion("order_item_qty >=", value, "orderItemQty");
            return (Criteria) this;
        }

        public Criteria andOrderItemQtyLessThan(Byte value) {
            addCriterion("order_item_qty <", value, "orderItemQty");
            return (Criteria) this;
        }

        public Criteria andOrderItemQtyLessThanOrEqualTo(Byte value) {
            addCriterion("order_item_qty <=", value, "orderItemQty");
            return (Criteria) this;
        }

        public Criteria andOrderItemQtyIn(List<Byte> values) {
            addCriterion("order_item_qty in", values, "orderItemQty");
            return (Criteria) this;
        }

        public Criteria andOrderItemQtyNotIn(List<Byte> values) {
            addCriterion("order_item_qty not in", values, "orderItemQty");
            return (Criteria) this;
        }

        public Criteria andOrderItemQtyBetween(Byte value1, Byte value2) {
            addCriterion("order_item_qty between", value1, value2, "orderItemQty");
            return (Criteria) this;
        }

        public Criteria andOrderItemQtyNotBetween(Byte value1, Byte value2) {
            addCriterion("order_item_qty not between", value1, value2, "orderItemQty");
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

        public Criteria andProductSaleTypeIsNull() {
            addCriterion("product_sale_type is null");
            return (Criteria) this;
        }

        public Criteria andProductSaleTypeIsNotNull() {
            addCriterion("product_sale_type is not null");
            return (Criteria) this;
        }

        public Criteria andProductSaleTypeEqualTo(Byte value) {
            addCriterion("product_sale_type =", value, "productSaleType");
            return (Criteria) this;
        }

        public Criteria andProductSaleTypeNotEqualTo(Byte value) {
            addCriterion("product_sale_type <>", value, "productSaleType");
            return (Criteria) this;
        }

        public Criteria andProductSaleTypeGreaterThan(Byte value) {
            addCriterion("product_sale_type >", value, "productSaleType");
            return (Criteria) this;
        }

        public Criteria andProductSaleTypeGreaterThanOrEqualTo(Byte value) {
            addCriterion("product_sale_type >=", value, "productSaleType");
            return (Criteria) this;
        }

        public Criteria andProductSaleTypeLessThan(Byte value) {
            addCriterion("product_sale_type <", value, "productSaleType");
            return (Criteria) this;
        }

        public Criteria andProductSaleTypeLessThanOrEqualTo(Byte value) {
            addCriterion("product_sale_type <=", value, "productSaleType");
            return (Criteria) this;
        }

        public Criteria andProductSaleTypeIn(List<Byte> values) {
            addCriterion("product_sale_type in", values, "productSaleType");
            return (Criteria) this;
        }

        public Criteria andProductSaleTypeNotIn(List<Byte> values) {
            addCriterion("product_sale_type not in", values, "productSaleType");
            return (Criteria) this;
        }

        public Criteria andProductSaleTypeBetween(Byte value1, Byte value2) {
            addCriterion("product_sale_type between", value1, value2, "productSaleType");
            return (Criteria) this;
        }

        public Criteria andProductSaleTypeNotBetween(Byte value1, Byte value2) {
            addCriterion("product_sale_type not between", value1, value2, "productSaleType");
            return (Criteria) this;
        }

        public Criteria andParentOrderItemIdIsNull() {
            addCriterion("parent_order_item_id is null");
            return (Criteria) this;
        }

        public Criteria andParentOrderItemIdIsNotNull() {
            addCriterion("parent_order_item_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentOrderItemIdEqualTo(Integer value) {
            addCriterion("parent_order_item_id =", value, "parentOrderItemId");
            return (Criteria) this;
        }

        public Criteria andParentOrderItemIdNotEqualTo(Integer value) {
            addCriterion("parent_order_item_id <>", value, "parentOrderItemId");
            return (Criteria) this;
        }

        public Criteria andParentOrderItemIdGreaterThan(Integer value) {
            addCriterion("parent_order_item_id >", value, "parentOrderItemId");
            return (Criteria) this;
        }

        public Criteria andParentOrderItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_order_item_id >=", value, "parentOrderItemId");
            return (Criteria) this;
        }

        public Criteria andParentOrderItemIdLessThan(Integer value) {
            addCriterion("parent_order_item_id <", value, "parentOrderItemId");
            return (Criteria) this;
        }

        public Criteria andParentOrderItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("parent_order_item_id <=", value, "parentOrderItemId");
            return (Criteria) this;
        }

        public Criteria andParentOrderItemIdIn(List<Integer> values) {
            addCriterion("parent_order_item_id in", values, "parentOrderItemId");
            return (Criteria) this;
        }

        public Criteria andParentOrderItemIdNotIn(List<Integer> values) {
            addCriterion("parent_order_item_id not in", values, "parentOrderItemId");
            return (Criteria) this;
        }

        public Criteria andParentOrderItemIdBetween(Integer value1, Integer value2) {
            addCriterion("parent_order_item_id between", value1, value2, "parentOrderItemId");
            return (Criteria) this;
        }

        public Criteria andParentOrderItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_order_item_id not between", value1, value2, "parentOrderItemId");
            return (Criteria) this;
        }

        public Criteria andIsItemLeafIsNull() {
            addCriterion("is_item_leaf is null");
            return (Criteria) this;
        }

        public Criteria andIsItemLeafIsNotNull() {
            addCriterion("is_item_leaf is not null");
            return (Criteria) this;
        }

        public Criteria andIsItemLeafEqualTo(Boolean value) {
            addCriterion("is_item_leaf =", value, "isItemLeaf");
            return (Criteria) this;
        }

        public Criteria andIsItemLeafNotEqualTo(Boolean value) {
            addCriterion("is_item_leaf <>", value, "isItemLeaf");
            return (Criteria) this;
        }

        public Criteria andIsItemLeafGreaterThan(Boolean value) {
            addCriterion("is_item_leaf >", value, "isItemLeaf");
            return (Criteria) this;
        }

        public Criteria andIsItemLeafGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_item_leaf >=", value, "isItemLeaf");
            return (Criteria) this;
        }

        public Criteria andIsItemLeafLessThan(Boolean value) {
            addCriterion("is_item_leaf <", value, "isItemLeaf");
            return (Criteria) this;
        }

        public Criteria andIsItemLeafLessThanOrEqualTo(Boolean value) {
            addCriterion("is_item_leaf <=", value, "isItemLeaf");
            return (Criteria) this;
        }

        public Criteria andIsItemLeafIn(List<Boolean> values) {
            addCriterion("is_item_leaf in", values, "isItemLeaf");
            return (Criteria) this;
        }

        public Criteria andIsItemLeafNotIn(List<Boolean> values) {
            addCriterion("is_item_leaf not in", values, "isItemLeaf");
            return (Criteria) this;
        }

        public Criteria andIsItemLeafBetween(Boolean value1, Boolean value2) {
            addCriterion("is_item_leaf between", value1, value2, "isItemLeaf");
            return (Criteria) this;
        }

        public Criteria andIsItemLeafNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_item_leaf not between", value1, value2, "isItemLeaf");
            return (Criteria) this;
        }

        public Criteria andProductSupplierIdIsNull() {
            addCriterion("product_supplier_id is null");
            return (Criteria) this;
        }

        public Criteria andProductSupplierIdIsNotNull() {
            addCriterion("product_supplier_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductSupplierIdEqualTo(Integer value) {
            addCriterion("product_supplier_id =", value, "productSupplierId");
            return (Criteria) this;
        }

        public Criteria andProductSupplierIdNotEqualTo(Integer value) {
            addCriterion("product_supplier_id <>", value, "productSupplierId");
            return (Criteria) this;
        }

        public Criteria andProductSupplierIdGreaterThan(Integer value) {
            addCriterion("product_supplier_id >", value, "productSupplierId");
            return (Criteria) this;
        }

        public Criteria andProductSupplierIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_supplier_id >=", value, "productSupplierId");
            return (Criteria) this;
        }

        public Criteria andProductSupplierIdLessThan(Integer value) {
            addCriterion("product_supplier_id <", value, "productSupplierId");
            return (Criteria) this;
        }

        public Criteria andProductSupplierIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_supplier_id <=", value, "productSupplierId");
            return (Criteria) this;
        }

        public Criteria andProductSupplierIdIn(List<Integer> values) {
            addCriterion("product_supplier_id in", values, "productSupplierId");
            return (Criteria) this;
        }

        public Criteria andProductSupplierIdNotIn(List<Integer> values) {
            addCriterion("product_supplier_id not in", values, "productSupplierId");
            return (Criteria) this;
        }

        public Criteria andProductSupplierIdBetween(Integer value1, Integer value2) {
            addCriterion("product_supplier_id between", value1, value2, "productSupplierId");
            return (Criteria) this;
        }

        public Criteria andProductSupplierIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_supplier_id not between", value1, value2, "productSupplierId");
            return (Criteria) this;
        }

        public Criteria andFrozenRealStockQtyIsNull() {
            addCriterion("frozen_real_stock_qty is null");
            return (Criteria) this;
        }

        public Criteria andFrozenRealStockQtyIsNotNull() {
            addCriterion("frozen_real_stock_qty is not null");
            return (Criteria) this;
        }

        public Criteria andFrozenRealStockQtyEqualTo(Integer value) {
            addCriterion("frozen_real_stock_qty =", value, "frozenRealStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenRealStockQtyNotEqualTo(Integer value) {
            addCriterion("frozen_real_stock_qty <>", value, "frozenRealStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenRealStockQtyGreaterThan(Integer value) {
            addCriterion("frozen_real_stock_qty >", value, "frozenRealStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenRealStockQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("frozen_real_stock_qty >=", value, "frozenRealStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenRealStockQtyLessThan(Integer value) {
            addCriterion("frozen_real_stock_qty <", value, "frozenRealStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenRealStockQtyLessThanOrEqualTo(Integer value) {
            addCriterion("frozen_real_stock_qty <=", value, "frozenRealStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenRealStockQtyIn(List<Integer> values) {
            addCriterion("frozen_real_stock_qty in", values, "frozenRealStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenRealStockQtyNotIn(List<Integer> values) {
            addCriterion("frozen_real_stock_qty not in", values, "frozenRealStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenRealStockQtyBetween(Integer value1, Integer value2) {
            addCriterion("frozen_real_stock_qty between", value1, value2, "frozenRealStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenRealStockQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("frozen_real_stock_qty not between", value1, value2, "frozenRealStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenVirtualStockQtyIsNull() {
            addCriterion("frozen_virtual_stock_qty is null");
            return (Criteria) this;
        }

        public Criteria andFrozenVirtualStockQtyIsNotNull() {
            addCriterion("frozen_virtual_stock_qty is not null");
            return (Criteria) this;
        }

        public Criteria andFrozenVirtualStockQtyEqualTo(Integer value) {
            addCriterion("frozen_virtual_stock_qty =", value, "frozenVirtualStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenVirtualStockQtyNotEqualTo(Integer value) {
            addCriterion("frozen_virtual_stock_qty <>", value, "frozenVirtualStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenVirtualStockQtyGreaterThan(Integer value) {
            addCriterion("frozen_virtual_stock_qty >", value, "frozenVirtualStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenVirtualStockQtyGreaterThanOrEqualTo(Integer value) {
            addCriterion("frozen_virtual_stock_qty >=", value, "frozenVirtualStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenVirtualStockQtyLessThan(Integer value) {
            addCriterion("frozen_virtual_stock_qty <", value, "frozenVirtualStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenVirtualStockQtyLessThanOrEqualTo(Integer value) {
            addCriterion("frozen_virtual_stock_qty <=", value, "frozenVirtualStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenVirtualStockQtyIn(List<Integer> values) {
            addCriterion("frozen_virtual_stock_qty in", values, "frozenVirtualStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenVirtualStockQtyNotIn(List<Integer> values) {
            addCriterion("frozen_virtual_stock_qty not in", values, "frozenVirtualStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenVirtualStockQtyBetween(Integer value1, Integer value2) {
            addCriterion("frozen_virtual_stock_qty between", value1, value2, "frozenVirtualStockQty");
            return (Criteria) this;
        }

        public Criteria andFrozenVirtualStockQtyNotBetween(Integer value1, Integer value2) {
            addCriterion("frozen_virtual_stock_qty not between", value1, value2, "frozenVirtualStockQty");
            return (Criteria) this;
        }

        public Criteria andIsVirtualStockReadyIsNull() {
            addCriterion("is_virtual_stock_ready is null");
            return (Criteria) this;
        }

        public Criteria andIsVirtualStockReadyIsNotNull() {
            addCriterion("is_virtual_stock_ready is not null");
            return (Criteria) this;
        }

        public Criteria andIsVirtualStockReadyEqualTo(Boolean value) {
            addCriterion("is_virtual_stock_ready =", value, "isVirtualStockReady");
            return (Criteria) this;
        }

        public Criteria andIsVirtualStockReadyNotEqualTo(Boolean value) {
            addCriterion("is_virtual_stock_ready <>", value, "isVirtualStockReady");
            return (Criteria) this;
        }

        public Criteria andIsVirtualStockReadyGreaterThan(Boolean value) {
            addCriterion("is_virtual_stock_ready >", value, "isVirtualStockReady");
            return (Criteria) this;
        }

        public Criteria andIsVirtualStockReadyGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_virtual_stock_ready >=", value, "isVirtualStockReady");
            return (Criteria) this;
        }

        public Criteria andIsVirtualStockReadyLessThan(Boolean value) {
            addCriterion("is_virtual_stock_ready <", value, "isVirtualStockReady");
            return (Criteria) this;
        }

        public Criteria andIsVirtualStockReadyLessThanOrEqualTo(Boolean value) {
            addCriterion("is_virtual_stock_ready <=", value, "isVirtualStockReady");
            return (Criteria) this;
        }

        public Criteria andIsVirtualStockReadyIn(List<Boolean> values) {
            addCriterion("is_virtual_stock_ready in", values, "isVirtualStockReady");
            return (Criteria) this;
        }

        public Criteria andIsVirtualStockReadyNotIn(List<Boolean> values) {
            addCriterion("is_virtual_stock_ready not in", values, "isVirtualStockReady");
            return (Criteria) this;
        }

        public Criteria andIsVirtualStockReadyBetween(Boolean value1, Boolean value2) {
            addCriterion("is_virtual_stock_ready between", value1, value2, "isVirtualStockReady");
            return (Criteria) this;
        }

        public Criteria andIsVirtualStockReadyNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_virtual_stock_ready not between", value1, value2, "isVirtualStockReady");
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

        public Criteria andIsSplitedIsNull() {
            addCriterion("is_splited is null");
            return (Criteria) this;
        }

        public Criteria andIsSplitedIsNotNull() {
            addCriterion("is_splited is not null");
            return (Criteria) this;
        }

        public Criteria andIsSplitedEqualTo(Boolean value) {
            addCriterion("is_splited =", value, "isSplited");
            return (Criteria) this;
        }

        public Criteria andIsSplitedNotEqualTo(Boolean value) {
            addCriterion("is_splited <>", value, "isSplited");
            return (Criteria) this;
        }

        public Criteria andIsSplitedGreaterThan(Boolean value) {
            addCriterion("is_splited >", value, "isSplited");
            return (Criteria) this;
        }

        public Criteria andIsSplitedGreaterThanOrEqualTo(Boolean value) {
            addCriterion("is_splited >=", value, "isSplited");
            return (Criteria) this;
        }

        public Criteria andIsSplitedLessThan(Boolean value) {
            addCriterion("is_splited <", value, "isSplited");
            return (Criteria) this;
        }

        public Criteria andIsSplitedLessThanOrEqualTo(Boolean value) {
            addCriterion("is_splited <=", value, "isSplited");
            return (Criteria) this;
        }

        public Criteria andIsSplitedIn(List<Boolean> values) {
            addCriterion("is_splited in", values, "isSplited");
            return (Criteria) this;
        }

        public Criteria andIsSplitedNotIn(List<Boolean> values) {
            addCriterion("is_splited not in", values, "isSplited");
            return (Criteria) this;
        }

        public Criteria andIsSplitedBetween(Boolean value1, Boolean value2) {
            addCriterion("is_splited between", value1, value2, "isSplited");
            return (Criteria) this;
        }

        public Criteria andIsSplitedNotBetween(Boolean value1, Boolean value2) {
            addCriterion("is_splited not between", value1, value2, "isSplited");
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