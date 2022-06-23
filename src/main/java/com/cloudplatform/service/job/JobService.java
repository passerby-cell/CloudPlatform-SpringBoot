package com.cloudplatform.service.job;

import com.cloudplatform.pojo.Job;
import com.cloudplatform.utils.PageResult;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 林海洋
 * @Date: 2022/06/22/11:28 上午
 * @Description:
 */
public interface JobService {
    PageResult<Job> getJobList(String userId, int currentPage, int pageSize);

    void pauseJob(String id);

    void startJob(String id);

    void deleteJob(String id);
}
