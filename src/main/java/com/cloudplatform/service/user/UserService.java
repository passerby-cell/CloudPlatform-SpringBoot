package com.cloudplatform.service.user;

import com.cloudplatform.pojo.CommonUser;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 林海洋
 * @Date: 2022/06/21/1:25 下午
 * @Description:
 */
public interface UserService {
    CommonUser userLogin(CommonUser user);

    void registUser(CommonUser user);
}
