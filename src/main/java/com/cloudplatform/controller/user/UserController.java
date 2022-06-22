package com.cloudplatform.controller.user;

import com.cloudplatform.pojo.CommonUser;
import com.cloudplatform.service.user.UserService;
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
 * @Date: 2022/06/21/10:31 上午
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public Result<CommonUser> userLogin(@RequestParam("username") String username , @RequestParam("password") String password){
        CommonUser user = new CommonUser();
        user.setUsername(username);
        user.setPassword(password);
        CommonUser userLogin = userService.userLogin(user);
        if (null==userLogin){
            return new Result(false,StatusCode.LOGINERROR,"用户名或密码错误");
        }
        String token=JwtUtil.createJWT(userLogin.getId(),userLogin.getUsername(),null);
        return new Result(true,StatusCode.OK,"登录成功",userLogin,token);
    }

    @GetMapping("/regist")
    public Result registUser(@RequestParam("username") String username,
                             @RequestParam("password") String password){
        CommonUser user = new CommonUser();
        user.setUsername(username);
        CommonUser userexist = userService.userLogin(user);
        if (null==userexist){
            user.setPassword(password);
            userService.registUser(user);
            return new Result(true,StatusCode.OK,"注册成功");
        }
        return new Result(false,StatusCode.ERROR,"用户名已注册");
    }

}
