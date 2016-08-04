package com.wow.attribute.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by win7 on 2016/8/4.
 */
public class CategoryMaterial implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String material;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
