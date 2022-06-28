package com.cloudplatform.controller.file;

import com.cloudplatform.pojo.MyFile;
import com.cloudplatform.service.file.FileService;
import com.cloudplatform.utils.JwtUtil;
import com.cloudplatform.utils.PageResult;
import com.cloudplatform.utils.Result;
import com.cloudplatform.utils.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
    public Result mkDir(@RequestParam("token") String token,
                        @RequestParam("userid") String userid,
                        @RequestParam("dirname") String dirname,
                        @RequestParam(value = "dirpath", required = false, defaultValue = "null") String dirpath,
                        @RequestParam("parentdirid") String parentdirid) {
        if (JwtUtil.verifyToken(token)) {
            log.warn("token令牌过期,验证失败");
            return new Result<>(false, StatusCode.TOKENERROR, "身份过期,请重新登陆");
        }
        boolean flag = fileService.mkDir(userid, dirname, dirpath, parentdirid);
        if (flag) {
            return new Result(true, StatusCode.OK, "文件夹新建成功");
        } else {
            return new Result(false, StatusCode.EERROR, "新建失败,文件名重复");
        }
    }

    @GetMapping("/getfilelist")
    public Result<MyFile> getFileList(@RequestParam("token") String token,
                                      @RequestParam("userid") String userid,
                                      @RequestParam("parentdirid") String parentdirid,
                                      @RequestParam(value = "pagenum", required = false, defaultValue = "1") int pagenum,
                                      @RequestParam(value = "pagesize", required = false, defaultValue = "8") int pagesize) {
        if (JwtUtil.verifyToken(token)) {
            log.warn("token令牌过期,验证失败");
            return new Result<>(false, StatusCode.TOKENERROR, "身份过期,请重新登陆");
        }
        PageResult<MyFile> fileList = fileService.getFileList(userid, parentdirid, pagenum, pagesize);
        return new Result<>(true, StatusCode.OK, "查询成功", fileList);
    }

    @PostMapping("/uploadfile")
    public Result uploadFile(@RequestParam("token") String token,
                             @RequestParam("userid") String userid,
                             @RequestParam(value = "dirpath", required = false, defaultValue = "null") String dirpath,
                             @RequestParam("parentdirid") String parentdirid,
                             @RequestBody MultipartFile file) {
        if (JwtUtil.verifyToken(token)) {
            log.warn("token令牌过期,验证失败");
            return new Result<>(false, StatusCode.TOKENERROR, "身份过期,请重新登陆");
        }
        boolean flag = fileService.uploadFile(userid, dirpath, parentdirid, file);
        if (flag) {
            return new Result(true, StatusCode.OK, "上传成功");
        } else {
            return new Result(false, StatusCode.EERROR, "上传失败");
        }
    }

    @GetMapping("/updatename")
    public Result updateName(@RequestParam("token") String token,
                             @RequestParam("userid") String userid,
                             @RequestParam("newname") String newname,
                             @RequestParam("oldname") String oldname,
                             @RequestParam("id") String id,
                             @RequestParam(value = "dirpath", required = false, defaultValue = "null") String dirpath
    ) {
        if (JwtUtil.verifyToken(token)) {
            log.warn("token令牌过期,验证失败");
            return new Result<>(false, StatusCode.TOKENERROR, "身份过期,请重新登陆");
        }
        boolean flag = fileService.updateName(userid, newname, oldname, id, dirpath);
        if (flag) {
            return new Result(true, StatusCode.OK, "修改成功");
        }
        return new Result(true, StatusCode.OK, "修改失败");

    }
}
