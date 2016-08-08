package com.wow.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wow.user.model.VersionLog;
import com.wow.user.model.VersionLogExample;
import com.wow.user.vo.VersionLogQuery;

public interface VersionLogMapper {
    int countByExample(VersionLogExample example);

    int deleteByExample(VersionLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(VersionLog record);

    int insertSelective(VersionLog record);

    List<VersionLog> selectByExample(VersionLogExample example);

    VersionLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") VersionLog record, @Param("example") VersionLogExample example);

    int updateByExample(@Param("record") VersionLog record, @Param("example") VersionLogExample example);

    int updateByPrimaryKeySelective(VersionLog record);

    int updateByPrimaryKey(VersionLog record);

    VersionLog selectLatestVersion(VersionLogQuery query);
}