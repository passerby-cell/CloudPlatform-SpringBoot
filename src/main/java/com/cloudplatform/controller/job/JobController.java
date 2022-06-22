package com.cloudplatform.controller.job;

import com.cloudplatform.pojo.Job;
import com.cloudplatform.service.job.JobService;
import com.cloudplatform.utils.JwtUtil;
import com.cloudplatform.utils.PageResult;
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
 * @Date: 2022/06/22/11:25 上午
 * @Description:
 */
@RestController
@RequestMapping("/job")
@Slf4j
public class JobController {
    @Autowired
    private JobService jobService;

    @GetMapping("/getjoblist")
    public Result<Job> getJobList(@RequestParam("token") String token,
                                  @RequestParam("userid") String userId,
                                  @RequestParam(value = "pagenum", required = false, defaultValue = "1") int pagenum,
                                  @RequestParam(value = "pagesize", required = false, defaultValue = "8") int pagesize) {
        PageResult<Job> jobList = jobService.getJobList(userId, pagenum, pagesize);
        try {
            JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("token令牌过期,验证失败");
            return new Result<>(false, StatusCode.LOGINERROR, "身份过期,请重新登陆");
        }
        return new Result<>(true, StatusCode.OK, "查询成功", jobList);
    }

    @GetMapping("/pausejob")
    public Result pauseJob(@RequestParam("token") String token, @RequestParam("id") String id) {
        try {
            JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("token令牌过期,验证失败");
            return new Result<>(false, StatusCode.LOGINERROR, "身份过期,请重新登陆");
        }
        jobService.pauseJob(id);
        return new Result<>(true, StatusCode.OK, "暂停成功");
    }

    @GetMapping("/startjob")
    public Result startJob(@RequestParam("token") String token, @RequestParam("id") String id) {
        try {
            JwtUtil.parseJWT(token);
        } catch (Exception e) {
            e.printStackTrace();
            log.warn("token令牌过期,验证失败");
            return new Result<>(false, StatusCode.LOGINERROR, "身份过期,请重新登陆");
        }
        jobService.startJob(id);
        return new Result<>(true, StatusCode.OK, "启动成功");
    }
}


