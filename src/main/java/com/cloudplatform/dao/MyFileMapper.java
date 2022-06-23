package com.cloudplatform.dao;

import com.cloudplatform.pojo.MyFile;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MyFileMapper {
    int deleteByPrimaryKey(String id);

    int insert(@Param("record") MyFile record);

    MyFile selectByPrimaryKey(String id);

    List<MyFile> selectAll();

    int updateByPrimaryKey(@Param("record")MyFile record);
}