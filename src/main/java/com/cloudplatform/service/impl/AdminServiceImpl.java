package com.cloudplatform.service.impl;

import com.cloudplatform.dao.AdminUserMapper;
import com.cloudplatform.pojo.AdminUser;
import com.cloudplatform.service.AdminService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 林海洋
 * @Date: 2022/06/21/3:37 下午
 * @Description:
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Resource
    private AdminUserMapper adminUserMapper;
    @Override
    public AdminUser adminLogin(AdminUser adminUser) {
        return adminUserMapper.selectByAdminUser(adminUser);
    }
}
