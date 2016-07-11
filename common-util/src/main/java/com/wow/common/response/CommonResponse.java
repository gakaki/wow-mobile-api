package com.wow.common.response;

import java.io.Serializable;


/**
 * 通用的响应类 包括错误码与错误信息
 * 
 * @author chenkaiwei
 * @version $Id: V1.0 2016年7月11日 下午5:02:37 Exp $
 */
public class CommonResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    
    //错误码 默认为0 表示成功
    private String resCode="0";
    
    //错误信息 默认为成功
    private String resMsg="成功";

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }
    
}
