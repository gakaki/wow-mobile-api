package com.wow.user.vo.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.wow.common.response.CommonResponse;
import com.wow.user.vo.WechatBindStatusVo;

/**
 * Created by zhengzhiqing on 16/7/9.
 */
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class WechatBindStatusResponse extends CommonResponse {
    private WechatBindStatusVo wechatBindStatusVo;

    public WechatBindStatusVo getWechatBindStatusVo() {
        return wechatBindStatusVo;
    }

    public void setWechatBindStatusVo(WechatBindStatusVo wechatBindStatusVo) {
        this.wechatBindStatusVo = wechatBindStatusVo;
    }
}
