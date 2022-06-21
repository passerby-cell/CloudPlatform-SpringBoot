package com.cloudplatform.controller.admin;

import com.cloudplatform.pojo.AdminUser;
import com.cloudplatform.service.AdminService;
import com.cloudplatform.utils.JwtUtil;
import com.cloudplatform.utils.Result;
import com.cloudplatform.utils.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 林海洋
 * @Date: 2022/06/21/3:33 下午
 * @Description:
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public Result<AdminUser> adminLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        AdminUser adminUser = new AdminUser();
        adminUser.setUsername(username);
        adminUser.setPassword(password);
        AdminUser user = adminService.adminLogin(adminUser);
        if (null != user) {
            return new Result<>(true, StatusCode.OK, "登陆成功", user, JwtUtil.createJWT(user.getId(), user.getUsername(), null));
        }
        return new Result<>(false, StatusCode.ERROR, "账号或密码错误");
    }
}
