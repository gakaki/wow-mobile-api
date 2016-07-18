package com.wow.user.service.impl;

import com.wow.common.response.CommonResponse;
import com.wow.user.mapper.EndUserLoginLogMapper;
import com.wow.user.model.EndUserLoginLog;
import com.wow.user.model.EndUserLoginLogExample;
import com.wow.user.service.LoginLogService;
import com.wow.user.vo.response.LoginLogResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by zhengzhiqing on 16/7/16.
 */
@Service
@Transactional(value = "userTransactionManager")
public class LoginLogServiceImpl implements LoginLogService {

    private static final Logger logger = LoggerFactory.getLogger(LoginLogServiceImpl.class);

    @Autowired
    private EndUserLoginLogMapper endUserLoginLogMapper;

    /**
     *
     * @param endUserLoginLog
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRES_NEW)
    public CommonResponse addLoginLog(EndUserLoginLog endUserLoginLog) {
        CommonResponse commonResponse = new CommonResponse();
        endUserLoginLogMapper.insertSelective(endUserLoginLog);
        return commonResponse;
    }

    /**
     * 查询用户登录日志
     *
     * @param endUserId
     * @return
     */
    @Override
    @Transactional(propagation= Propagation.NOT_SUPPORTED)
    public LoginLogResponse getLoginLogsByUserId(int endUserId) {
        LoginLogResponse loginLogResponse = new LoginLogResponse();
        EndUserLoginLogExample endUserLoginLogExample = new EndUserLoginLogExample();
        EndUserLoginLogExample.Criteria criteria = endUserLoginLogExample.createCriteria();
        criteria.andEndUserIdEqualTo(endUserId);
        List<EndUserLoginLog> endUserLoginLogList = endUserLoginLogMapper.selectByExample(endUserLoginLogExample);
        loginLogResponse.setEndUserLoginLogList(endUserLoginLogList);
        return loginLogResponse;
    }
}
