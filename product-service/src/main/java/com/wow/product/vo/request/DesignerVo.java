package com.wow.product.vo.request;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/21.
 */
public class DesignerVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private int designerId;
    private boolean isPrimary;

    public int getDesignerId() {
        return designerId;
    }

    public void setDesignerId(int designerId) {
        this.designerId = designerId;
    }

    public boolean isPrimary() {
        return isPrimary;
    }

    public void setPrimary(boolean primary) {
        isPrimary = primary;
    }
}
