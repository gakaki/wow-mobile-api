package com.wow.user.vo.request;

import com.wow.common.request.ApiRequest;
import com.wow.user.model.EndUserWechat;

/**
 * Created by zhengzhiqing on 16/7/6.
 */
public class WechatBindRequest extends ApiRequest {

    private EndUserWechat endUserWechat;

    public EndUserWechat getEndUserWechat() {
        return endUserWechat;
    }

    public void setEndUserWechat(EndUserWechat endUserWechat) {
        this.endUserWechat = endUserWechat;
    }
}
