package com.cloudplatform.dao;

import com.cloudplatform.pojo.CommonUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommonUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(@Param("record") CommonUser record);

    CommonUser selectByPrimaryKey(String id);

    List<CommonUser> selectAll();

    int updateByPrimaryKey(@Param("record")CommonUser record);

    CommonUser selectByCommonUser(@Param("user") CommonUser user);
}