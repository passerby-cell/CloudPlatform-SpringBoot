package com.cloudplatform.dao;

import com.cloudplatform.pojo.File;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FileMapper {
    int deleteByPrimaryKey(String id);

    int insert(@Param("record") File record);

    File selectByPrimaryKey(String id);

    List<File> selectAll();

    int updateByPrimaryKey(@Param("record")File record);
}