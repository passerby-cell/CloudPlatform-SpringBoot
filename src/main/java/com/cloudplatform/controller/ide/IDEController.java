package com.cloudplatform.controller.ide;

import com.cloudplatform.service.ide.IDEService;
import com.cloudplatform.utils.JwtUtil;
import com.cloudplatform.utils.Result;
import com.cloudplatform.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 林海洋
 * @Date: 2022/06/30/11:30 上午
 * @Description:
 */
@RestController
@RequestMapping("/ide")
@Slf4j
public class IDEController {

    @Autowired
    private IDEService ideService;

    @GetMapping("/start")
    public Result startIDE(@RequestParam("token") String token,
                           @RequestParam("userid") String userid){
        if (JwtUtil.verifyToken(token)) {
            log.warn("token令牌过期,验证失败");
            return new Result<>(false, StatusCode.TOKENERROR, "身份过期,请重新登陆");
        }
        ideService.startIDE(userid);
        return new Result(true,StatusCode.OK,"开启成功");
    }
}
