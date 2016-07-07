package com.wow.mobileapi.dto;

import java.io.Serializable;

/**
 * Created by zhengzhiqing on 16/7/7.
 */
public class MobileRequestVo implements Serializable {

    private static final long serialVersionUID = 1L;

    private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
