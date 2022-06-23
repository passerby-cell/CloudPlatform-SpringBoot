package com.cloudplatform.controller.file;

import com.cloudplatform.service.file.FileService;
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
 * @Date: 2022/06/23/2:28 下午
 * @Description:
 */
@RestController
@RequestMapping("/file")
@Slf4j
public class FileController {
    @Autowired
    private FileService fileService;

    @GetMapping("/mkdir")
    public Result mkDir(@RequestParam("token")String token,
                        @RequestParam("userid")String userid,
                        @RequestParam("dirname")String dirname,
                        @RequestParam(value = "dirpath",required = false,defaultValue = "null")String dirpath,
                        @RequestParam("parentdirid")String parentdirid){
        if (JwtUtil.verifyToken(token)) {
            log.warn("token令牌过期,验证失败");
            return new Result<>(false, StatusCode.TOKENERROR, "身份过期,请重新登陆");
        }
        boolean flag = fileService.mkDir(userid, dirname, dirpath, parentdirid);
        if (flag){
            return new Result(true,StatusCode.OK,"文件夹新建成功");
        }else {
            return new Result(false,StatusCode.EERROR,"新建失败");
        }
    }
}
