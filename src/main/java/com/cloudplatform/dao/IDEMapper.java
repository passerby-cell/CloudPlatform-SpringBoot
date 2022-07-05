package com.cloudplatform.dao;

import com.cloudplatform.pojo.IDE;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface IDEMapper {
    int deleteByPrimaryKey(String id);

    int insert(@Param("record") IDE record);

    IDE selectByPrimaryKey(String id);

    List<IDE> selectAll();

    int updateByPrimaryKey(@Param("record")IDE record);

    IDE selectByPort(int freePort);

    IDE selectByUserid(String userid);
}