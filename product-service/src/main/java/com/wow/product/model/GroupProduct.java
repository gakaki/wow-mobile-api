package com.wow.product.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by win7 on 2016/8/5.
 */
public class GroupProduct implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;

    private String img;

    private BigDecimal price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
