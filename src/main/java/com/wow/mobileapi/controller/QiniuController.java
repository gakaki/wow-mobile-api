
package com.wow.mobileapi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiniu.util.Auth;
import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.JsonUtil;
import com.wow.mobileapi.request.sdk.QiniuRequest;
import com.wow.mobileapi.response.sdk.QiniuResponse;

@PropertySource(value = "classpath:/qiniu.properties")
@RestController
public class QiniuController {

    //设置账号的ACCESS_KEY
    @Value("${qiniu.access_key}")
    private String ACCESS_KEY;

    //设置账号的SECRET_KEY
    @Value("${qiniu.access_key}")
    private String SECRET_KEY;

    /**
     * 获取七牛token
     * 
     * @param file_path
     * @return
     */
    @RequestMapping("/v1/qiniutoken")
    public ApiResponse getQiniutoken(ApiRequest request) {
        ApiResponse apiResponse = new ApiResponse();

        QiniuRequest qiniuRequest = JsonUtil.fromJSON(request.getParamJson(), QiniuRequest.class);

        String token = getUpToken(qiniuRequest.getBucket(), qiniuRequest.getKey());

        QiniuResponse qiniuResponse = new QiniuResponse();
        qiniuResponse.setToken(token);

        apiResponse.setData(qiniuResponse);

        return apiResponse;
    }

    /**
     * 获取token
     * 
     * @param bucketname 上传的文件桶名称
     * @param key 上传的key名称
     * @return
     */
    private String getUpToken(String bucketname, String key) {
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        //获取token
        String token = auth.uploadToken(bucketname, key);

        return token;
    }

}
