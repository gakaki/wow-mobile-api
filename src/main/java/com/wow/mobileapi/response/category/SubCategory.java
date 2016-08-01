package com.wow.mobileapi.response.category;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/8/1.
 */
public class SubCategory implements Serializable{

    private static final long serialVersionUID = 1L;

    private int id;
    private String categoryName;
    private int categoryLevel;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public int getCategoryLevel() {
        return categoryLevel;
    }

    public void setCategoryLevel(int categoryLevel) {
        this.categoryLevel = categoryLevel;
    }
}
