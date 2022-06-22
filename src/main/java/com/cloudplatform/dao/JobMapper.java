package com.cloudplatform.dao;

import com.cloudplatform.pojo.Job;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface JobMapper {
    int deleteByPrimaryKey(String id);

    int insert(@Param("record") Job record);

    Job selectByPrimaryKey(String id);

    List<Job> selectAll();

    int updateStatusByPrimaryKey(@Param("record")Job record);

    List<Job> selectByUserId(String userId);
}