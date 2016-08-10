package com.wow.attribute.model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by win7 on 2016/8/4.
 */
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
