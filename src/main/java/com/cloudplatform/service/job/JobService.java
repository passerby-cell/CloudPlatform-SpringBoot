package com.cloudplatform.service.job;

import com.cloudplatform.pojo.Job;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 林海洋
 * @Date: 2022/06/22/11:28 上午
 * @Description:
 */
public interface JobService {
    List<Job> getJobList();
}
