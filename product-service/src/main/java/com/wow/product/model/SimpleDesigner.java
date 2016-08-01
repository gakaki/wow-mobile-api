package com.wow.product.model;

import java.io.Serializable;
import java.lang.annotation.Documented;

/**
 * Created by win7 on 2016/8/1.
 */
public class SimpleDesigner implements Serializable {


    private int designerId;

    private String designerName;

    public int getDesignerId() {
        return designerId;
    }

    public void setDesignerId(int designerId) {
        this.designerId = designerId;
    }

    public String getDesignerName() {
        return designerName;
    }

    public void setDesignerName(String designerName) {
        this.designerName = designerName;
    }
}
