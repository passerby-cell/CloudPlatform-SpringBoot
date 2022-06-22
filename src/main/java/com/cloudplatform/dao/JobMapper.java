package com.cloudplatform.dao;

import com.cloudplatform.pojo.Job;
import java.util.List;

public interface JobMapper {
    int deleteByPrimaryKey(String id);

    int insert(Job record);

    Job selectByPrimaryKey(String id);

    List<Job> selectAll();

    int updateByPrimaryKey(Job record);

    List<Job> selectByUserId(String userId);
}