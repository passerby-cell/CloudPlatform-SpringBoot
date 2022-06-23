package com.cloudplatform.service.impl;

import com.cloudplatform.dao.JobMapper;
import com.cloudplatform.pojo.Job;
import com.cloudplatform.service.job.JobService;
import com.cloudplatform.utils.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 *
 * @Auther: 林海洋
 * @Date: 2022/06/22/11:28 上午
 * @Description:
 */
@Service
public class JobServiceImpl implements JobService {
    @Resource
    private JobMapper jobMapper;

    @Override
    public PageResult<Job> getJobList(String userId, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Job> jobList = jobMapper.selectByUserId(userId);
        //获取总条数
        PageInfo<Job> pageInfo = new PageInfo<>(jobList);
        return new PageResult<Job>(pageInfo.getTotal(),pageNum,pageSize,jobList);
    }

    @Override
    public void pauseJob(String id) {
        Job job = new Job();
        job.setStatus("暂停中");
        job.setId(id);
        jobMapper.updateStatusByPrimaryKey(job);
    }

    @Override
    public void startJob(String id) {
        Job job = new Job();
        job.setStatus("执行中");
        job.setId(id);
        jobMapper.updateStatusByPrimaryKey(job);
    }

    @Override
    public void deleteJob(String id) {
        jobMapper.deleteByPrimaryKey(id);
    }

}
