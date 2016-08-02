
package com.wow.mobileapi.controller;

import com.qiniu.util.StringMap;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qiniu.util.Auth;
import com.wow.common.constant.CommonConstant;
import com.wow.common.request.ApiRequest;
import com.wow.common.response.ApiResponse;
import com.wow.common.util.JsonUtil;
import com.wow.common.util.RedisUtil;
import com.wow.common.util.StringUtil;
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

        //从redis中获取token
        String token = getUpTokenFromRedis(qiniuRequest.getBucket());

        //获取token
        if (StringUtil.isEmpty(token)) {
            token = getUpToken(qiniuRequest.getBucket());
        }

        QiniuResponse qiniuResponse = new QiniuResponse();
        qiniuResponse.setToken(token);

        apiResponse.setData(qiniuResponse);

        return apiResponse;
    }

    /**
     * 获取token
     * 
     * @param bucketname 上传的文件桶名称
     * @return
     */
    private String getUpToken(String bucketname,String key) {
        //密钥配置
        Auth auth = Auth.create(ACCESS_KEY, SECRET_KEY);
        //获取token
        //insert only 设置为0 才能同一url 覆盖 上传
        String token = auth.uploadToken(bucketname,key,3600,new StringMap().put("insertOnly", 0 ));

        //七牛云默认失效时间为3600s,由于从七牛返回服务器到存入缓存有延迟 所以减少10s,确保获取的token有效
        RedisUtil.set(CommonConstant.QINIU_TOKEN, token, 3590L);

        return token;
    }

    /**
     * 
     * 从redis 中获取相应的token
     * @param bucketname
     * @return
     */
    private String getUpTokenFromRedis(String bucketname) {
        return (String) RedisUtil.get(CommonConstant.QINIU_TOKEN);
    }

}
