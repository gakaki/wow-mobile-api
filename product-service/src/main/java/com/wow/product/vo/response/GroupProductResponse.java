package com.wow.product.vo.response;

import com.wow.common.response.ApiResponse;
import com.wow.common.response.CommonResponse;
import com.wow.product.model.GroupProduct;
import com.wow.product.vo.ProductVo;

import java.util.List;

/**
 * Created by win7 on 2016/8/5.
 */
public class GroupProductResponse extends ApiResponse {

    private static final long serialVersionUID = 1L;

    private List<GroupProduct> productList;

    //每页显示记录数
    private Integer pageSize;

    //总页数
    private Integer totalPage;

    //总记录数
    private Integer totalResult;

    //当前页
    private Integer currentPage;

    public List<GroupProduct> getProductList() {
        return productList;
    }

    public void setProductList(List<GroupProduct> productList) {
        this.productList = productList;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(Integer totalResult) {
        this.totalResult = totalResult;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}
