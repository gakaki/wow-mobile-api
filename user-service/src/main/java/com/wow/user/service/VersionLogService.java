package com.wow.user.service;

import com.wow.user.vo.VersionLogQuery;
import com.wow.user.vo.response.VersionLogResponse;

/**
 * 版本升级服务
 * 
 * @author kaiwei
 * @version V1.0 2016年8月8日 下午2:52:18 Exp
 */
public interface VersionLogService {

    public VersionLogResponse checkVersion(VersionLogQuery query);

}
