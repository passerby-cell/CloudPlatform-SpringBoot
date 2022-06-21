package com.cloudplatform.dao;

import com.cloudplatform.pojo.CommonUser;
import java.util.List;

public interface CommonUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(CommonUser record);

    CommonUser selectByPrimaryKey(String id);

    List<CommonUser> selectAll();

    int updateByPrimaryKey(CommonUser record);
}