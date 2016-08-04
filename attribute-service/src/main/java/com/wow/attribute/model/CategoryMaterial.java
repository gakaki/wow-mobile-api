package com.wow.attribute.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by win7 on 2016/8/4.
 */
public class CategoryMaterial implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private int categoryId;

    private List<String> materialList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public List<String> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(List<String> materialList) {
        this.materialList = materialList;
    }
}
