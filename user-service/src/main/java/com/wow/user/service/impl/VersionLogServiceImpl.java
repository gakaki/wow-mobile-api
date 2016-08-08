package com.wow.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wow.common.util.DateUtil;
import com.wow.common.util.ErrorCodeUtil;
import com.wow.common.util.StringUtil;
import com.wow.user.mapper.VersionLogMapper;
import com.wow.user.model.VersionLog;
import com.wow.user.model.VersionLogExample;
import com.wow.user.service.VersionLogService;
import com.wow.user.vo.VersionLogQuery;
import com.wow.user.vo.response.VersionLogResponse;

/**
 * 
 * @author kaiwei
 * @version V1.0 2016年8月8日 下午2:53:10 Exp
 */
@Service
@Transactional("userTransactionManager")
public class VersionLogServiceImpl implements VersionLogService {

    @Autowired
    private VersionLogMapper versionLogMapper;

    @Override
    public VersionLogResponse checkVersion(VersionLogQuery query) {
        VersionLogResponse versionLogResponse = new VersionLogResponse();

        /*** 业务校验开始*/
        //如果版本号 app类型或者平台类型为空 则返回错误提示
        if (query.getAppType() == null || query.getPlatForm() == null || StringUtil.isEmpty(query.getVersion())) {
            versionLogResponse.setResCode("40305");
            versionLogResponse.setResMsg(ErrorCodeUtil.getErrorMsg("40305"));

            return versionLogResponse;
        }
        /*** 业务校验结束*/

        //获取最新的版本号
        VersionLog versionLog = versionLogMapper.selectLatestVersion(query);
        //如果没有获取到最新版本号 则直接返回
        if (versionLog == null) {
            versionLogResponse.setResCode("50113");
            versionLogResponse.setResMsg(ErrorCodeUtil.getErrorMsg("50113"));
            
            return versionLogResponse;
        }

        //查询该版本号之后是否有需要强制升级的版本
        VersionLogExample versionLogExample = new VersionLogExample();
        VersionLogExample.Criteria criteria = versionLogExample.createCriteria();
        
        criteria.andAppTypeEqualTo(query.getAppType());
        criteria.andPlatFormEqualTo(query.getPlatForm());
        criteria.andIsRequiredUpgradeEqualTo(Boolean.TRUE);
        criteria.andVersionGreaterThan(query.getVersion());

        int count = versionLogMapper.countByExample(versionLogExample);

        //如果有需要强制升级的版本 则设置需要强制升级
        if (count > 0) {
            versionLogResponse.setIsRequiredUpgrade(Boolean.TRUE);
        }

        //设置版本信息
        versionLogResponse.setVersion(versionLog.getVersion());
        versionLogResponse.setBuildVersion(versionLog.getBuildVersion());
        versionLogResponse.setPublishLog(versionLog.getPublishLog());
        versionLogResponse.setPublishDateFormat(DateUtil.formatDate(versionLog.getPublishDate()));
        versionLogResponse.setUpgradeUrl(versionLog.getUpgradeUrl());

        return versionLogResponse;
    }

}