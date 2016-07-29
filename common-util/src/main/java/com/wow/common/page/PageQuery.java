package com.wow.common.page;

import java.io.Serializable;

/**
 * 通用的分页请求类
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月11日 下午5:11:31 Exp $
 */
public class PageQuery implements Serializable {

    private static final long serialVersionUID = 1L;

    //查询的页数
    private Integer currentPage;

    //每页的条数 （最大50条)
    private Integer pageSize;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
