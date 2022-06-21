package com.cloudplatform.dao;

import com.cloudplatform.pojo.AdminUser;
import java.util.List;

public interface AdminUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(AdminUser record);

    AdminUser selectByPrimaryKey(String id);

    List<AdminUser> selectAll();

    int updateByPrimaryKey(AdminUser record);
}