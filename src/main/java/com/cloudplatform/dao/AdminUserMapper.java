package com.cloudplatform.dao;

import com.cloudplatform.pojo.AdminUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(@Param("record") AdminUser record);

    AdminUser selectByPrimaryKey(String id);

    List<AdminUser> selectAll();

    int updateByPrimaryKey(@Param("record") AdminUser record);
}