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
    private Integer pageIndex;

    //每页的条数 （最大50条)
    private Integer pageSize;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

}
