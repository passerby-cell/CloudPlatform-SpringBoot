package com.cloudplatform.service.impl;

import com.cloudplatform.dao.CommonUserMapper;
import com.cloudplatform.pojo.CommonUser;
import com.cloudplatform.service.UserService;
import com.cloudplatform.utils.IdWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 林海洋
 * @Date: 2022/06/21/1:26 下午
 * @Description:
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private CommonUserMapper userMapper;

    @Override
    public CommonUser userLogin(CommonUser user) {
        return userMapper.selectByCommonUser(user);
    }

    @Override
    public void registUser(CommonUser user) {
        IdWorker idWorker = new IdWorker();
        user.setId(String.valueOf(idWorker.nextId()));
        user.setIsactive("0");
        userMapper.insert(user);
    }
}
